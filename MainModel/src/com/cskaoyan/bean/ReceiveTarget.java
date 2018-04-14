package com.cskaoyan.bean;

import java.util.Date;

public class ReceiveTarget {
    int id;
    int targetTypeID;
    String targetTypeName;
    String teamCode;
    String teamName;
    String principal;
    String contactPhoneNUmber;
    String registerTime;
    String receiveTargetTypeName;

    ReceiveTargetType receiveTargetType;


    public ReceiveTarget(int id, int targetTypeID, String targetTypeName, String teamCode, String teamName,
                         String principal, String contactPhoneNUmber, String registerTime, String
                                 receiveTargetTypeName, ReceiveTargetType receiveTargetType) {
        this.id = id;
        this.targetTypeID = targetTypeID;
        this.targetTypeName = targetTypeName;
        this.teamCode = teamCode;
        this.teamName = teamName;
        this.principal = principal;
        this.contactPhoneNUmber = contactPhoneNUmber;
        this.registerTime = registerTime;
        this.receiveTargetTypeName = receiveTargetTypeName;
        this.receiveTargetType = receiveTargetType;
    }

    public ReceiveTarget() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTargetTypeID() {
        return targetTypeID;
    }

    public void setTargetTypeID(int targetTypeID) {
        this.targetTypeID = targetTypeID;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getContactPhoneNUmber() {
        return contactPhoneNUmber;
    }

    public void setContactPhoneNUmber(String contactPhoneNUmber) {
        this.contactPhoneNUmber = contactPhoneNUmber;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getReceiveTargetTypeName() {
        return receiveTargetTypeName;
    }

    public void setReceiveTargetTypeName(String receiveTargetTypeName) {
        this.receiveTargetTypeName = receiveTargetTypeName;
    }

    public ReceiveTargetType getReceiveTargetType() {
        return receiveTargetType;
    }

    public void setReceiveTargetType(ReceiveTargetType receiveTargetType) {
        this.receiveTargetType = receiveTargetType;
    }

    @Override
    public String toString() {
        return "ReceiveTarget{" +
                "id=" + id +
                ", targetTypeID=" + targetTypeID +
                ", targetTypeName='" + targetTypeName + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", teamName='" + teamName + '\'' +
                ", principal='" + principal + '\'' +
                ", contactPhoneNUmber='" + contactPhoneNUmber + '\'' +
                ", registerTime=" + registerTime +
                ", receiveTargetTypeName='" + receiveTargetTypeName + '\'' +
                ", receiveTargetType=" + receiveTargetType +
                '}';
    }
}
