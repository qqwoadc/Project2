package com.cskaoyan.utils;
//包装类
public class PassengerVO {

    private String name;
    private int limit;
    private int offset;

    public PassengerVO() {
    }

    public PassengerVO(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public PassengerVO(String name, int limit, int offset) {
        this.name = name;
        this.limit = limit;
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "PassengerVO{" +
                "name='" + name + '\'' +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
