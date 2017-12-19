package com.vshell.server.generator;

import com.vshell.server.utils.FileUtil;
import com.vshell.server.utils.StringUtil;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heroshen on 2017/12/3.
 */
public class ControllerGenerator {

    public static void main(String[] args) {
        generatorController();
    }

    public static void generatorController() {
        List<String> serviceNameList = findServiceList();
        for (String service : serviceNameList) {
            System.out.println("处理controller文件中。。。" + service + "Controller.java");
            if ((!StringUtils.isEmpty(GeneratorConstants.testFile)) && (service.indexOf(GeneratorConstants.testFile) == -1)) {
                continue;
            }
            String resultFile = GeneratorConstants.controllerPath + service + "Controller.java";
            FileUtil.copyFile(GeneratorConstants.generatorPath + "$SampleController", resultFile);
            String resultContent = FileUtil.read(resultFile);
            resultContent = resultContent.replace("${Service}", service).replace("${lowerService}", StringUtil.upperCase(service));
            FileUtil.write(resultFile, resultContent);
        }
    }

    private static List<String> findServiceList() {
        List<String> fileNameList = FileUtil.getFileName(GeneratorConstants.daoPath);
        List<String> serviceNameList = new ArrayList<String>();
        if (!CollectionUtils.isEmpty(fileNameList)) {
            for (String fileName : fileNameList) {
                serviceNameList.add(fileName.substring(0, fileName.indexOf("Mapper.java")));
            }
        }
        return serviceNameList;
    }
}
