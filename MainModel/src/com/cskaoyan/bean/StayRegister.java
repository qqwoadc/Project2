package com.cskaoyan.bean;

import java.util.Date;

public class StayRegister {

    private int srId;
    private int predetermineId;
    private int changingRoomNumber;
    private float changRoomMoney;
    private Date changRoomTime;
    private Date registerTime;
    private float sumConst;

    @Override
    public String toString() {
        return "StayRegister{" +
                "srId=" + srId +
                ", predetermineId=" + predetermineId +
                ", changingRoomNumber=" + changingRoomNumber +
                ", changRoomMoney=" + changRoomMoney +
                ", changRoomTime=" + changRoomTime +
                ", registerTime=" + registerTime +
                ", sumConst=" + sumConst +
                '}';
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
