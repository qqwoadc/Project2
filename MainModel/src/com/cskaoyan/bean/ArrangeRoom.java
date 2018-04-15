package com.cskaoyan.bean;

public class ArrangeRoom {

    private String tuanDuiID;
    private String LvKeLeiXingId;
    //    房间号
    private String roomName;


    private String registerTime;
    private String rentOutTypeID;
    private String passengerTypeID;
    //    住店天数/小时
    private String stayNumber;
    //    押金
    private String deposit;
    private String billUnitID;
    private String depositPayWayID;

    public String getTuanDuiID() {
        return tuanDuiID;
    }

    public void setTuanDuiID(String tuanDuiID) {
        this.tuanDuiID = tuanDuiID;
    }

    public String getLvKeLeiXingId() {
        return LvKeLeiXingId;
    }

    public void setLvKeLeiXingId(String lvKeLeiXingId) {
        LvKeLeiXingId = lvKeLeiXingId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getRentOutTypeID() {
        return rentOutTypeID;
    }

    public void setRentOutTypeID(String rentOutTypeID) {
        this.rentOutTypeID = rentOutTypeID;
    }

    public String getPassengerTypeID() {
        return passengerTypeID;
    }

    public void setPassengerTypeID(String passengerTypeID) {
        this.passengerTypeID = passengerTypeID;
    }

    public String getStayNumber() {
        return stayNumber;
    }

    public void setStayNumber(String stayNumber) {
        this.stayNumber = stayNumber;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getBillUnitID() {
        return billUnitID;
    }

    public void setBillUnitID(String billUnitID) {
        this.billUnitID = billUnitID;
    }

    public String getDepositPayWayID() {
        return depositPayWayID;
    }

    public void setDepositPayWayID(String depositPayWayID) {
        this.depositPayWayID = depositPayWayID;
    }
}
