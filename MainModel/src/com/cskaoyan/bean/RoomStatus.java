package com.cskaoyan.bean;

public class RoomStatus {


    private int far_id;
    private String attributeDetailsName;


    public RoomStatus() {
    }

    public RoomStatus(int far_id, String attributeDetailsName) {
        this.far_id = far_id;
        this.attributeDetailsName = attributeDetailsName;
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
