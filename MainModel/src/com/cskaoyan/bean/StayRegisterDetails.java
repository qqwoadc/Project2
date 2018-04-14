package com.cskaoyan.bean;

import java.util.Date;

public class StayRegisterDetails {

    private int remind;
    private String roomNumber;
    private String  roomGuestRoomLevelName;
    private int roomAmount;
    private int receiveTargetID;
    private String predetermineReceiveTargeTypeName;
    private String receiveTeamName;
    private String passengerName;
    private String passengerTypeName;
    private int changingRoomNumber;
    private float changRoomMoney;
    private Date changRoomTime;
    private Date registerTime;
    private float sumConst;
    private int isBillID;
    private int stayregisterdetailsId;
//以下是arrangeroom页面提交的数据，新生成一条住宿登记记录
    //tuanDuiID
//LvKeLeiXingId
//roomName房间号

//registerTime
//rentOutTypeID
//passengerTypeID
//stayNumber住店天数/小时
//deposit押金
//billUnitID
//depositPayWayID
    @Override
    public String toString() {
        return "StayRegisterDetails{" +
                "remind=" + remind +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomGuestRoomLevelName='" + roomGuestRoomLevelName + '\'' +
                ", roomAmount=" + roomAmount +
                ", receiveTargetID=" + receiveTargetID +
                ", predetermineReceiveTargeTypeName='" + predetermineReceiveTargeTypeName + '\'' +
                ", receiveTeamName='" + receiveTeamName + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerTypeName='" + passengerTypeName + '\'' +
                ", changingRoomNumber=" + changingRoomNumber +
                ", changRoomMoney=" + changRoomMoney +
                ", changRoomTime=" + changRoomTime +
                ", registerTime=" + registerTime +
                ", sumConst=" + sumConst +
                ", isBillID=" + isBillID +
                ", stayregisterdetailsId=" + stayregisterdetailsId +
                '}';
    }

    public int getRemind() {
        return remind;
    }

    public void setRemind(int remind) {
        this.remind = remind;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomGuestRoomLevelName() {
        return roomGuestRoomLevelName;
    }

    public void setRoomGuestRoomLevelName(String roomGuestRoomLevelName) {
        this.roomGuestRoomLevelName = roomGuestRoomLevelName;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public int getReceiveTargetID() {
        return receiveTargetID;
    }

    public void setReceiveTargetID(int receiveTargetID) {
        this.receiveTargetID = receiveTargetID;
    }

    public String getPredetermineReceiveTargeTypeName() {
        return predetermineReceiveTargeTypeName;
    }

    public void setPredetermineReceiveTargeTypeName(String predetermineReceiveTargeTypeName) {
        this.predetermineReceiveTargeTypeName = predetermineReceiveTargeTypeName;
    }

    public String getReceiveTeamName() {
        return receiveTeamName;
    }

    public void setReceiveTeamName(String receiveTeamName) {
        this.receiveTeamName = receiveTeamName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerTypeName() {
        return passengerTypeName;
    }

    public void setPassengerTypeName(String passengerTypeName) {
        this.passengerTypeName = passengerTypeName;
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

    public int getIsBillID() {
        return isBillID;
    }

    public void setIsBillID(int isBillID) {
        this.isBillID = isBillID;
    }

    public int getStayregisterdetailsId() {
        return stayregisterdetailsId;
    }

    public void setStayregisterdetailsId(int stayregisterdetailsId) {
        this.stayregisterdetailsId = stayregisterdetailsId;
    }
}
