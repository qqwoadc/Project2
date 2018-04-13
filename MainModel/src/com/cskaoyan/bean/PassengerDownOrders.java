package com.cskaoyan.bean;

public class PassengerDownOrders {
    int id;
    String order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PassengerDownOrders{" +
                "id=" + id +
                ", order='" + order + '\'' +
                '}';
    }
}
