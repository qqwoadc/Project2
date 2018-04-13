package com.cskaoyan.bean;

import java.io.StringReader;
import java.util.Date;

//消费类
public class Consumption {

    private int id;
    private int srId;
    private String commodityName;
    private String commodityTypeName;
    private String commodityUOMName;
    private int consumptionNumber;
    private float commoditySalePrice;
    private float consumptionMoney;
    private String consumptionTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSrId() {
        return srId;
    }

    public void setSrId(int srId) {
        this.srId = srId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityTypeName() {
        return commodityTypeName;
    }

    public void setCommodityTypeName(String commodityTypeName) {
        this.commodityTypeName = commodityTypeName;
    }

    public String getCommodityUOMName() {
        return commodityUOMName;
    }

    public void setCommodityUOMName(String commodityUOMName) {
        this.commodityUOMName = commodityUOMName;
    }

    public int getConsumptionNumber() {
        return consumptionNumber;
    }

    public void setConsumptionNumber(int consumptionNumber) {
        this.consumptionNumber = consumptionNumber;
    }

    public float getCommoditySalePrice() {
        return commoditySalePrice;
    }

    public void setCommoditySalePrice(float commoditySalePrice) {
        this.commoditySalePrice = commoditySalePrice;
    }

    public float getConsumptionMoney() {
        return consumptionMoney;
    }

    public void setConsumptionMoney(float consumptionMoney) {
        this.consumptionMoney = consumptionMoney;
    }

    public String getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(String consumptionTime) {
        this.consumptionTime = consumptionTime;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "id=" + id +
                ", srId=" + srId +
                ", commodityName='" + commodityName + '\'' +
                ", commodityTypeName='" + commodityTypeName + '\'' +
                ", commodityUOMName='" + commodityUOMName + '\'' +
                ", consumptionNumber='" + consumptionNumber + '\'' +
                ", commoditySalePrice='" + commoditySalePrice + '\'' +
                ", consumptionMoney='" + consumptionMoney + '\'' +
                ", consumptionTime=" + consumptionTime +
                '}';
    }
}
