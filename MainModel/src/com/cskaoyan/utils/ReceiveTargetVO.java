package com.cskaoyan.utils;

public class ReceiveTargetVO {

    private int limit;
    private int offset;
    private String textName;
    private String teamName;
    private String principal;
    private String contactPhoneNUmber;


    public ReceiveTargetVO(int limit, int offset, String textName, String teamName, String teamCode, String
            principal, String contactPhoneNUmber) {
        this.limit = limit;
        this.offset = offset;
        this.textName = textName;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.principal = principal;
        this.contactPhoneNUmber = contactPhoneNUmber;
    }

    private String teamCode;

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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public ReceiveTargetVO() {
    }

    public ReceiveTargetVO(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }


    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }
}
