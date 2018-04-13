package com.cskaoyan.bean;

public class Deposit {
//判断旅客类型，为2表示散客，不为2表示团体
    private int receiveTargetID;
    private String receiveTargeTypeName;
    private String receiveTeamName;
    private String deposit;
    private String depositPayWayName;
    private String depositRegisterTime;

    @Override
    public String toString() {
        return "Deposit{" +
                "receiveTargetID=" + receiveTargetID +
                ", receiveTargeTypeName='" + receiveTargeTypeName + '\'' +
                ", receiveTeamName='" + receiveTeamName + '\'' +
                ", deposit='" + deposit + '\'' +
                ", depositPayWayName='" + depositPayWayName + '\'' +
                ", depositRegisterTime='" + depositRegisterTime + '\'' +
                '}';
    }

    public int getReceiveTargetID() {
        return receiveTargetID;
    }

    public void setReceiveTargetID(int receiveTargetID) {
        this.receiveTargetID = receiveTargetID;
    }

    public String getReceiveTargeTypeName() {
        return receiveTargeTypeName;
    }

    public void setReceiveTargeTypeName(String receiveTargeTypeName) {
        this.receiveTargeTypeName = receiveTargeTypeName;
    }

    public String getReceiveTeamName() {
        return receiveTeamName;
    }

    public void setReceiveTeamName(String receiveTeamName) {
        this.receiveTeamName = receiveTeamName;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getDepositPayWayName() {
        return depositPayWayName;
    }

    public void setDepositPayWayName(String depositPayWayName) {
        this.depositPayWayName = depositPayWayName;
    }

    public String getDepositRegisterTime() {
        return depositRegisterTime;
    }

    public void setDepositRegisterTime(String depositRegisterTime) {
        this.depositRegisterTime = depositRegisterTime;
    }
}
