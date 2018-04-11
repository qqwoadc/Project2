package com.cskaoyan.bean;


public class Room {
    private Integer id;

    private String roomNumber;

    private String guestRoomLevelName;

    private Integer roomStateID;

    private Integer roomAmount;

    private Double standardPriceDay;

    private Double standardPrice;

    private Integer maxDuration;

    private Integer firstDuration;

    private Double firstPrice;

    private String roomName;


    public Room(Integer id, String roomNumber, String guestRoomLevelName, Integer roomStateID, Integer roomAmount, Double standardPriceDay, Double standardPrice, Integer maxDuration, Integer firstDuration, Double firstPrice, String roomName) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.guestRoomLevelName = guestRoomLevelName;
        this.roomStateID = roomStateID;
        this.roomAmount = roomAmount;
        this.standardPriceDay = standardPriceDay;
        this.standardPrice = standardPrice;
        this.maxDuration = maxDuration;
        this.firstDuration = firstDuration;
        this.firstPrice = firstPrice;
        this.roomName = roomName;
    }

    public Room(String roomNumber, String guestRoomLevelName, Integer roomStateID, Integer roomAmount, Double standardPriceDay, Double standardPrice, Integer maxDuration, Integer firstDuration, Double firstPrice, String roomName) {
        this.roomNumber = roomNumber;
        this.guestRoomLevelName = guestRoomLevelName;
        this.roomStateID = roomStateID;
        this.roomAmount = roomAmount;
        this.standardPriceDay = standardPriceDay;
        this.standardPrice = standardPrice;
        this.maxDuration = maxDuration;
        this.firstDuration = firstDuration;
        this.firstPrice = firstPrice;
        this.roomName = roomName;
    }


    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestRoomLevelName() {
        return guestRoomLevelName;
    }

    public void setGuestRoomLevelName(String guestRoomLevelName) {
        this.guestRoomLevelName = guestRoomLevelName;
    }

    public Integer getRoomStateID() {
        return roomStateID;
    }

    public void setRoomStateID(Integer roomStateID) {
        this.roomStateID = roomStateID;
    }

    public Integer getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    public Double getStandardPriceDay() {
        return standardPriceDay;
    }

    public void setStandardPriceDay(Double standardPriceDay) {
        this.standardPriceDay = standardPriceDay;
    }

    public Double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(Double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Integer getFirstDuration() {
        return firstDuration;
    }

    public void setFirstDuration(Integer firstDuration) {
        this.firstDuration = firstDuration;
    }

    public Double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(Double firstPrice) {
        this.firstPrice = firstPrice;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", guestRoomLevelName='" + guestRoomLevelName + '\'' +
                ", roomStateID=" + roomStateID +
                ", roomAmount=" + roomAmount +
                ", standardPriceDay=" + standardPriceDay +
                ", standardPrice=" + standardPrice +
                ", maxDuration=" + maxDuration +
                ", firstDuration=" + firstDuration +
                ", firstPrice=" + firstPrice +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}