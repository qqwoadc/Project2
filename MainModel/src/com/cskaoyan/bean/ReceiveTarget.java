package com.cskaoyan.bean;

import java.util.Date;

public class ReceiveTarget {

    String teamCode;
    String teamName;
    String principal;
    String contactPhoneNUmber;
    Date registerTime;
    String targetTypeName;

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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }

    @Override
    public String toString() {
        return "ReceiveTarget{" +
                "teamCode='" + teamCode + '\'' +
                ", teamName='" + teamName + '\'' +
                ", principal='" + principal + '\'' +
                ", contactPhoneNUmber='" + contactPhoneNUmber + '\'' +
                ", registerTime=" + registerTime +
                ", targetTypeName='" + targetTypeName + '\'' +
                '}';
    }
}
