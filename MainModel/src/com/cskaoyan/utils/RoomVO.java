package com.cskaoyan.utils;


//包装类
public class RoomVO {

   private String roomNumber;
   private int limit;
   private int offset;


    public RoomVO() {
    }

    public RoomVO(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public RoomVO(String roomNumber, int limit, int offset) {
        this.roomNumber = roomNumber;
        this.limit = limit;
        this.offset = offset;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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
        return "RoomVO{" +
                "roomNumber='" + roomNumber + '\'' +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
