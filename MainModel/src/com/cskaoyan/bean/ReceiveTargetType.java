package com.cskaoyan.bean;

public class ReceiveTargetType {
    int far_id;
    String attributeDetailsName;

    public ReceiveTargetType(int far_id, String attributeDetailsName) {
        this.far_id = far_id;
        this.attributeDetailsName = attributeDetailsName;
    }

    public ReceiveTargetType() {
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

    @Override
    public String toString() {
        return "ReceiveTargetType{" +
                "far_id=" + far_id +
                ", attributeDetailsName='" + attributeDetailsName + '\'' +
                '}';
    }
}
