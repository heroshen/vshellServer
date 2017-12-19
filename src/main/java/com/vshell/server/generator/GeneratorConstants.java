package com.vshell.server.generator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heroshen on 2017/12/7.
 */
public class GeneratorConstants {
    public static final String serverPath = "/Users/heroshen/WorkspacesSelf/vshellServer/";
    public static final String javaPath = serverPath + "src/main/java/com/vshell/server/";
    public static final String controllerPath = javaPath + "controller/";
    public static final String daoPath = javaPath + "dao/";
    public static final String mapperXMLPath = serverPath + "src/main/resources/mapping/";
    public static final String generatorPath = javaPath + "generator/";

    public static final List<String> ignoreList = Arrays.asList("id", "add_time", "update_time", "delete_sign");

    public static final String testFile = "";
}
