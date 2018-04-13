package com.cskaoyan.bean;

import java.util.Date;

public class Financialstatistics {

    private int fsId;
    private Date payTime;
    private int stayregisterdetailsId;
    private int passengerNumber;
    private float consumptionMoney;
    private float sumConst;

    public float getConsumptionMoney() {
        return consumptionMoney;
    }

    public void setConsumptionMoney(float consumptionMoney) {
        this.consumptionMoney = consumptionMoney;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public float getSumConst() {
        return sumConst;
    }

    public void setSumConst(float sumConst) {
        this.sumConst = sumConst;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getStayregisterdetailsId() {
        return stayregisterdetailsId;
    }

    public void setStayregisterdetailsId(int stayregisterdetailsId) {
        this.stayregisterdetailsId = stayregisterdetailsId;
    }

    public int getFsId() {

        return fsId;
    }

    public void setFsId(int fsId) {
        this.fsId = fsId;
    }

    @Override
    public String toString() {
        return "Financialstatistics{" +
                "fsId=" + fsId +
                ", payTime=" + payTime +
                ", stayregisterdetailsId=" + stayregisterdetailsId +
                ", passengerNumber=" + passengerNumber +
                ", consumptionMoney=" + consumptionMoney +
                ", sumConst=" + sumConst +
                '}';
    }
}
