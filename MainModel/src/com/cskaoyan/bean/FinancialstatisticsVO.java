package com.cskaoyan.bean;

import java.util.Date;

public class FinancialstatisticsVO {

    private int id;
    private String roomNumber;
    private int receiveTargetID;
    private String predetermineReceiveTargeTypeName;
    private String receiveTeamName;
    private String passengerName;
    private int changingRoomNumber;
    private Date changRoomTime;
    private Date registerTime;
    private Date payTime;
    private float sumConst;
    private int stayregisterdetailsId;

    @Override
    public String toString() {
        return "FinancialstatisticsVO{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", receiveTargetID=" + receiveTargetID +
                ", predetermineReceiveTargeTypeName='" + predetermineReceiveTargeTypeName + '\'' +
                ", receiveTeamName='" + receiveTeamName + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", changingRoomNumber=" + changingRoomNumber +
                ", changRoomTime=" + changRoomTime +
                ", registerTime=" + registerTime +
                ", payTime=" + payTime +
                ", sumConst=" + sumConst +
                ", stayregisterdetailsId=" + stayregisterdetailsId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public int getChangingRoomNumber() {
        return changingRoomNumber;
    }

    public void setChangingRoomNumber(int changingRoomNumber) {
        this.changingRoomNumber = changingRoomNumber;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public float getSumConst() {
        return sumConst;
    }

    public void setSumConst(float sumConst) {
        this.sumConst = sumConst;
    }

    public int getStayregisterdetailsId() {
        return stayregisterdetailsId;
    }

    public void setStayregisterdetailsId(int stayregisterdetailsId) {
        this.stayregisterdetailsId = stayregisterdetailsId;
    }
}
