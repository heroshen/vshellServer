package com.vshell.server.generator;

import java.util.List;
import java.util.Map;

/**
 * Created by heroshen on 2017/12/19.
 */
public class GeneratorBean {

    private String javaClassName;

    private List<Map<String, String>> fieldList;

    public String getJavaClassName() {
        return javaClassName;
    }

    public void setJavaClassName(String javaClassName) {
        this.javaClassName = javaClassName;
    }

    public List<Map<String, String>> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Map<String, String>> fieldList) {
        this.fieldList = fieldList;
    }
}
