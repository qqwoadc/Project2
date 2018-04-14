package com.cskaoyan.utils;

public class ListOne {

    private String far_id;

    private String attributeDetailsName;

    public String getFar_id() {
        return far_id;
    }

    public void setFar_id(String far_id) {
        this.far_id = far_id;
    }

    public String getAttributeDetailsName() {
        return attributeDetailsName;
    }

    public void setAttributeDetailsName(String attributeDetailsName) {
        this.attributeDetailsName = attributeDetailsName;
    }

    public ListOne(String far_id, String attributeDetailsName) {
        this.far_id = far_id;
        this.attributeDetailsName = attributeDetailsName;
    }
}
