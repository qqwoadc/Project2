package com.cskaoyan.bean;

import java.util.Date;

public class Passenger {
    int id;
    //旅客姓名
    String name;
    //性别
    String genderName;
    //出生日期
    Date birthDate;
    //国别
    String nationName;
    //发证机关
    String licenceIssuingAuthorty;
    //职业
    String profession;
    //学历
    String educationDegreeID;
    //旅客等级
    String passengerLevelName;
    //证件有效日期
    String papersValidity;
    //证件名称
    String papersName;
    //证件号码
    String papersNumber;
    //单位或地址
    String unitsOrAddress;
    //事由
    String thingReasonID;
    //从哪来
    String whereAreFrom;
    //到哪去
    String whereToGo;
    //联系电话
    String contactPhoneNumber;
    //备注
    String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getLicenceIssuingAuthorty() {
        return licenceIssuingAuthorty;
    }

    public void setLicenceIssuingAuthorty(String licenceIssuingAuthorty) {
        this.licenceIssuingAuthorty = licenceIssuingAuthorty;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(String educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public String getPassengerLevelName() {
        return passengerLevelName;
    }

    public void setPassengerLevelName(String passengerLevelName) {
        this.passengerLevelName = passengerLevelName;
    }

    public String getPapersValidity() {
        return papersValidity;
    }

    public void setPapersValidity(String papersValidity) {
        this.papersValidity = papersValidity;
    }

    public String getPapersName() {
        return papersName;
    }

    public void setPapersName(String papersName) {
        this.papersName = papersName;
    }

    public String getPapersNumber() {
        return papersNumber;
    }

    public void setPapersNumber(String papersNumber) {
        this.papersNumber = papersNumber;
    }

    public String getUnitsOrAddress() {
        return unitsOrAddress;
    }

    public void setUnitsOrAddress(String unitsOrAddress) {
        this.unitsOrAddress = unitsOrAddress;
    }

    public String getThingReasonID() {
        return thingReasonID;
    }

    public void setThingReasonID(String thingReasonID) {
        this.thingReasonID = thingReasonID;
    }

    public String getWhereAreFrom() {
        return whereAreFrom;
    }

    public void setWhereAreFrom(String whereAreFrom) {
        this.whereAreFrom = whereAreFrom;
    }

    public String getWhereToGo() {
        return whereToGo;
    }

    public void setWhereToGo(String whereToGo) {
        this.whereToGo = whereToGo;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genderName='" + genderName + '\'' +
                ", birthDate=" + birthDate +
                ", nationName='" + nationName + '\'' +
                ", licenceIssuingAuthorty='" + licenceIssuingAuthorty + '\'' +
                ", profession='" + profession + '\'' +
                ", educationDegreeID='" + educationDegreeID + '\'' +
                ", passengerLevelName='" + passengerLevelName + '\'' +
                ", papersValidity='" + papersValidity + '\'' +
                ", papersName='" + papersName + '\'' +
                ", papersNumber='" + papersNumber + '\'' +
                ", unitsOrAddress='" + unitsOrAddress + '\'' +
                ", thingReasonID='" + thingReasonID + '\'' +
                ", whereAreFrom='" + whereAreFrom + '\'' +
                ", whereToGo='" + whereToGo + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
