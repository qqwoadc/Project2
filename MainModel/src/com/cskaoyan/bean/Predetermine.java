package com.cskaoyan.bean;

import java.util.Date;

public class Predetermine {
    //预定信息编号
    int predetermineId;
    //是否到达抵达时间
    int remind;
    //房间号
    String roomNumber;
    //房间等级
    String guestRoomLevelName;
    //区分是旅客还是团队的id
    int passengerId;
    //抵达时间
    Date arriveTime;
    //押金
    Float deposit;
    //预定天数
    int predetermineDay;
    //预定状态
    String predetermineStateName;
    //预定人类型ID
    int teamId;
    //团队类型名称
    String receiveTeamName;
    //团队负责人姓名
    String receivePrincipal;
    //团队负责人电话号码
    String receiveContactPhoneNumber;
    //旅客类型名称
    String receiveTargetTypeName;
    //旅客姓名
    String passengerName;
    //旅客电话号码
    String passengerContactPhoneNumber;

    public int getPredetermineId() {
        return predetermineId;
    }

    public void setPredetermineId(int predetermineId) {
        this.predetermineId = predetermineId;
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

    public String getGuestRoomLevelName() {
        return guestRoomLevelName;
    }

    public void setGuestRoomLevelName(String guestRoomLevelName) {
        this.guestRoomLevelName = guestRoomLevelName;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    public int getPredetermineDay() {
        return predetermineDay;
    }

    public void setPredetermineDay(int predetermineDay) {
        this.predetermineDay = predetermineDay;
    }

    public String getPredetermineStateName() {
        return predetermineStateName;
    }

    public void setPredetermineStateName(String predetermineStateName) {
        this.predetermineStateName = predetermineStateName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getReceiveTeamName() {
        return receiveTeamName;
    }

    public void setReceiveTeamName(String receiveTeamName) {
        this.receiveTeamName = receiveTeamName;
    }

    public String getReceivePrincipal() {
        return receivePrincipal;
    }

    public void setReceivePrincipal(String receivePrincipal) {
        this.receivePrincipal = receivePrincipal;
    }

    public String getReceiveContactPhoneNumber() {
        return receiveContactPhoneNumber;
    }

    public void setReceiveContactPhoneNumber(String receiveContactPhoneNumber) {
        this.receiveContactPhoneNumber = receiveContactPhoneNumber;
    }

    public String getReceiveTargetTypeName() {
        return receiveTargetTypeName;
    }

    public void setReceiveTargetTypeName(String receiveTargetTypeName) {
        this.receiveTargetTypeName = receiveTargetTypeName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerContactPhoneNumber() {
        return passengerContactPhoneNumber;
    }

    public void setPassengerContactPhoneNumber(String passengerContactPhoneNumber) {
        this.passengerContactPhoneNumber = passengerContactPhoneNumber;
    }
}
