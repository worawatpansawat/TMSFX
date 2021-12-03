package com.tms.models;

public class SystemMenu {
    private String name;
    private String parentName;
    private String key;
    private String tag;

    public SystemMenu() {
        this.name = "";
        this.parentName = "";
        this.key = "";
        this.tag = "";
    }

    public SystemMenu(String name) {
        this.name = name;
    }

    public SystemMenu(String name, String parentName) {
        this.name = name;
        if (parentName == null) {
            parentName = "";
        }
        this.parentName = parentName;
    }

    public SystemMenu(String name, String parentName, String key) {
        this.name = name;
        this.parentName = parentName;
        this.key = key;
    }

    public SystemMenu(String name, String parentName, String key, String tag) {
        this.name = name;
        this.parentName = parentName;
        this.key = key;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        if (parentName == null) {
            parentName = "";
        }
        this.parentName = parentName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
