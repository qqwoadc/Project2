package com.cskaoyan.bean;

import java.util.Date;

public class StayRegister {

    private int srId;
    private String passengerName;
    private int predetermineId;
    private int changingRoomNumber;
    private float changRoomMoney;
    private Date changRoomTime;
    private Date registerTime;
    private float sumConst;
    private String isBill;
    private String lvkeleixing;
    private String rentOutTypeName;

    public String getRentOutTypeName() {
        return rentOutTypeName;
    }

    public void setRentOutTypeName(String rentOutTypeName) {
        this.rentOutTypeName = rentOutTypeName;
    }

    @Override
    public String toString() {
        return "StayRegister{" +
                "srId=" + srId +
                ", passengerName='" + passengerName + '\'' +
                ", predetermineId=" + predetermineId +
                ", changingRoomNumber=" + changingRoomNumber +
                ", changRoomMoney=" + changRoomMoney +
                ", changRoomTime=" + changRoomTime +
                ", registerTime=" + registerTime +
                ", sumConst=" + sumConst +
                ", isBill='" + isBill + '\'' +
                ", lvkeleixing='" + lvkeleixing + '\'' +
                ", rentOutTypeName='" + rentOutTypeName + '\'' +
                '}';
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getLvkeleixing() {
        return lvkeleixing;
    }

    public void setLvkeleixing(String lvkeleixing) {
        this.lvkeleixing = lvkeleixing;
    }
    public String getIsBill() {
        return isBill;
    }

    public void setIsBill(String isBill) {
        this.isBill = isBill;
    }

    public int getSrId() {
        return srId;
    }

    public void setSrId(int srId) {
        this.srId = srId;
    }

    public int getPredetermineId() {
        return predetermineId;
    }

    public void setPredetermineId(int predetermineId) {
        this.predetermineId = predetermineId;
    }

    public int getChangingRoomNumber() {
        return changingRoomNumber;
    }

    public void setChangingRoomNumber(int changingRoomNumber) {
        this.changingRoomNumber = changingRoomNumber;
    }

    public float getChangRoomMoney() {
        return changRoomMoney;
    }

    public void setChangRoomMoney(float changRoomMoney) {
        this.changRoomMoney = changRoomMoney;
    }

    public Date getChangRoomTime() {
        return changRoomTime;
    }

    public void setChangRoomTime(Date changRoomTime) {
        this.changRoomTime = changRoomTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public float getSumConst() {
        return sumConst;
    }

    public void setSumConst(float sumConst) {
        this.sumConst = sumConst;
    }

}
