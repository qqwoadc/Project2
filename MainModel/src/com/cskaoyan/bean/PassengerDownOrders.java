package com.cskaoyan.bean;

public class PassengerDownOrders {
    int id;
    int far_id;
    String attributeDetailsName;

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
    @Override
    public String toString() {
        return "PassengerDownOrders{" +
                "id=" + id +
                ", far_id=" + far_id +
                ", attributeDetailsName='" + attributeDetailsName + '\'' +
                '}';
    }
}
