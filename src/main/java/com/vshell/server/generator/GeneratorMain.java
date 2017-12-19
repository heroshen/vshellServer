package com.vshell.server.generator;

/**
 * Created by heroshen on 2017/12/19.
 */
public class GeneratorMain {
    public static void main(String[] args) {
        MapperXMLGenerator.reParseXML();
        MapperXMLGenerator.reParseDao();
        ControllerGenerator.generatorController();
    }
}
