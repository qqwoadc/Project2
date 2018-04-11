package com.cskaoyan.bean;

import java.io.Serializable;

public class Room{
    private Integer id;

    private String roomnumber;

    private String guestroomlevelname;

    private Integer roomstateid;

    private Integer roomamount;

    private Double standardpriceday;

    private Double standardprice;

    private Integer maxduration;

    private Integer firstduration;

    private Double firstprice;

    private String roomname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber == null ? null : roomnumber.trim();
    }

    public String getGuestroomlevelname() {
        return guestroomlevelname;
    }

    public void setGuestroomlevelname(String guestroomlevelname) {
        this.guestroomlevelname = guestroomlevelname == null ? null : guestroomlevelname.trim();
    }

    public Integer getRoomstateid() {
        return roomstateid;
    }

    public void setRoomstateid(Integer roomstateid) {
        this.roomstateid = roomstateid;
    }

    public Integer getRoomamount() {
        return roomamount;
    }

    public void setRoomamount(Integer roomamount) {
        this.roomamount = roomamount;
    }

    public Double getStandardpriceday() {
        return standardpriceday;
    }

    public void setStandardpriceday(Double standardpriceday) {
        this.standardpriceday = standardpriceday;
    }

    public Double getStandardprice() {
        return standardprice;
    }

    public void setStandardprice(Double standardprice) {
        this.standardprice = standardprice;
    }

    public Integer getMaxduration() {
        return maxduration;
    }

    public void setMaxduration(Integer maxduration) {
        this.maxduration = maxduration;
    }

    public Integer getFirstduration() {
        return firstduration;
    }

    public void setFirstduration(Integer firstduration) {
        this.firstduration = firstduration;
    }

    public Double getFirstprice() {
        return firstprice;
    }

    public void setFirstprice(Double firstprice) {
        this.firstprice = firstprice;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomnumber='" + roomnumber + '\'' +
                ", guestroomlevelname='" + guestroomlevelname + '\'' +
                ", roomstateid=" + roomstateid +
                ", roomamount=" + roomamount +
                ", standardpriceday=" + standardpriceday +
                ", standardprice=" + standardprice +
                ", maxduration=" + maxduration +
                ", firstduration=" + firstduration +
                ", firstprice=" + firstprice +
                ", roomname='" + roomname + '\'' +
                '}';
    }


    public Room() {
    }


    public Room( String roomnumber, String guestroomlevelname, Integer roomstateid, Integer roomamount, Double standardpriceday, Double standardprice, Integer maxduration, Integer firstduration, Double firstprice, String roomname) {
        this.roomnumber = roomnumber;
        this.guestroomlevelname = guestroomlevelname;
        this.roomstateid = roomstateid;
        this.roomamount = roomamount;
        this.standardpriceday = standardpriceday;
        this.standardprice = standardprice;
        this.maxduration = maxduration;
        this.firstduration = firstduration;
        this.firstprice = firstprice;
        this.roomname = roomname;
    }

    public Room(Integer id, String roomnumber, String guestroomlevelname, Integer roomstateid, Integer roomamount, Double standardpriceday, Double standardprice, Integer maxduration, Integer firstduration, Double firstprice, String roomname) {
        this.id = id;
        this.roomnumber = roomnumber;
        this.guestroomlevelname = guestroomlevelname;
        this.roomstateid = roomstateid;
        this.roomamount = roomamount;
        this.standardpriceday = standardpriceday;
        this.standardprice = standardprice;
        this.maxduration = maxduration;
        this.firstduration = firstduration;
        this.firstprice = firstprice;
        this.roomname = roomname;
    }
}