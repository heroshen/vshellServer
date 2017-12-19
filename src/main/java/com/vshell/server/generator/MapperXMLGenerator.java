package com.vshell.server.generator;

import com.vshell.server.utils.FileUtil;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heroshen on 2017/12/6.
 */
public class MapperXMLGenerator {

    public static void main(String[] args) {
        reParseXML();
        reParseDao();
    }

    public static void reParseDao() {
        String sampleContent = FileUtil.read(GeneratorConstants.generatorPath + "$SampleDao");
        List<String> fileNameList = FileUtil.getFileName(GeneratorConstants.daoPath);
        for (String fileName : fileNameList) {
            System.out.println("处理DAO文件中。。。" + fileName);
            if ((!StringUtils.isEmpty(GeneratorConstants.testFile)) && (fileName.indexOf(GeneratorConstants.testFile) == -1)) {
                continue;
            }
            String file = GeneratorConstants.daoPath + fileName;
            String service = fileName.replace("Mapper.java", "");
            String content = readAndModify(file, sampleContent, service);
            if (StringUtils.isEmpty(content)) {
                System.out.println(fileName + "已存在多条件翻页查询，忽略此文件生成");
            } else {
                FileUtil.write(file, content);
            }
        }
    }

    public static String readAndModify(String filePath, String sampleContent, String service) {
        BufferedReader br = null;
        StringBuffer buf = new StringBuffer();

        try {
            // 根据文件路径创建缓冲输入流
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("public interface") > -1) {
                    buf.append("import java.util.Map;");
                    buf.append(System.getProperty("line.separator"));
                    buf.append("import java.util.List;");
                    buf.append(System.getProperty("line.separator"));
                    buf.append(System.getProperty("line.separator"));
                } else if (line.indexOf("}") > -1) {
                    buf.append(System.getProperty("line.separator"));
                    buf.append(parseMethodFrame(sampleContent, service));
                } else if (line.indexOf("selectByConditions") > -1) {
                    buf = new StringBuffer();
                    break;
                }
                buf.append(line);
                buf.append(System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                }
            }
        }

        return buf.toString();
    }

    private static String parseMethodFrame(String sampleContent, String service) {
        String methodFrame = sampleContent.replace("${service}", service);
        return methodFrame;
    }

    public static void reParseXML() {
        String sampleContent = FileUtil.read(GeneratorConstants.generatorPath + "$SampleMapper");
        String equalContent = FileUtil.read(GeneratorConstants.generatorPath + "$EqualCondition");
        String likeContent = FileUtil.read(GeneratorConstants.generatorPath + "$LikeCondition");
        String tail = "</mapper>";
        List<String> fileNameList = FileUtil.getFileName(GeneratorConstants.mapperXMLPath);
        for (String fileName : fileNameList) {
            System.out.println("处理XML文件中。。。" + fileName);
            if ((!StringUtils.isEmpty(GeneratorConstants.testFile)) && (fileName.indexOf(GeneratorConstants.testFile) == -1)) {
                continue;
            }
            String file = GeneratorConstants.mapperXMLPath + fileName;
            String content = FileUtil.read(file);
            if (content.indexOf("selectByConditions") == -1) {
                content = reParseContent(sampleContent, equalContent, likeContent, tail, file, content);
                FileUtil.write(file, content);
            } else {
                System.out.println(fileName + "已存在多条件翻页查询，忽略此文件生成");
            }
        }
    }

    private static String reParseContent(String sampleContent, String equalContent, String likeContent, String tail, String file, String content) {
        content = content.replace(tail, "");
        GeneratorBean generatorBean = readXML(file);
        String methodFrame = parseMethodFrame(sampleContent, equalContent, likeContent, generatorBean);
        content = content + methodFrame;
        content = content + tail;
        return content;
    }

    private static String parseMethodFrame(String sampleContent, String equalContent, String likeContent, GeneratorBean generatorBean) {
        String pathUrl = generatorBean.getJavaClassName().substring(0, generatorBean.getJavaClassName().lastIndexOf("."));
        String javaName = generatorBean.getJavaClassName().substring(generatorBean.getJavaClassName().lastIndexOf(".") + 1);
        String methodFrame = sampleContent.replace("${pathUrl}", pathUrl).replace("${javaName}", javaName);
        String conditions = parseConditions(equalContent, likeContent, generatorBean.getFieldList());
        methodFrame = methodFrame.replace("${conditions}", conditions);
        return methodFrame;
    }

    private static String parseConditions(String equalContent, String likeContent, List<Map<String, String>> mapList) {
        String conditions = "";
        for (Map<String, String> map : mapList) {
            String jdbcType = map.get("jdbcType");
            String dbColumn = map.get("column");
            String javaProperty = map.get("property");
            if (!GeneratorConstants.ignoreList.contains(dbColumn)) {
                String condition;
                if (jdbcType.indexOf("VARCHAR") > -1) {
                    condition = likeContent;
                } else {
                    condition = equalContent;
                }
                condition = condition.replace("${dbColumn}", dbColumn).replace("${javaProperty}", javaProperty);
                conditions = conditions + condition;
            }
        }
        return conditions;
    }


    private static GeneratorBean readXML(String file) {
        GeneratorBean generatorBean = new GeneratorBean();
        List<Map<String, String>> mapList = new ArrayList<>();
        String javaClassName = null;
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            Document doc = builderFactory.newDocumentBuilder().parse(new File(file));
            doc.getDocumentElement().normalize();
            Node resultMapNode = doc.getElementsByTagName("resultMap").item(0);
            Element ele2 = (Element) resultMapNode;
            javaClassName = ele2.getAttribute("type");
            NodeList sList = ele2.getElementsByTagName("result");
            for (int j = 0; j < sList.getLength(); j++) {
                Element ele = (Element) sList.item(j);
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < ele.getAttributes().getLength(); i++) {
                    Node node = ele.getAttributes().item(i);
                    map.put(node.getNodeName(), node.getNodeValue());
                }
                mapList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        generatorBean.setFieldList(mapList);
        generatorBean.setJavaClassName(javaClassName);
        return generatorBean;
    }
}
