package com.cskaoyan.utils;

public class Downorder {


    private int id;
    private int far_id;
    private String attributeDetailsName;

    @Override
    public String toString() {
        return "Downorder{" +
                "id=" + id +
                ", far_id=" + far_id +
                ", attributeDetailsName='" + attributeDetailsName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFar_id() {
        return far_id;
    }

    public void setFar_id(int far_id) {
        this.far_id = far_id;
    }

    public String getAttributeDetailsName() {
        return attributeDetailsName;
    }

    public void setAttributeDetailsName(String attributeDetailsName) {
        this.attributeDetailsName = attributeDetailsName;
    }
}
