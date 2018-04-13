package com.cskaoyan.dao;

import com.cskaoyan.bean.PassengerDownOrders;

import java.util.List;

public interface PassengerDownOrdersMapper {
    List<PassengerDownOrders> findGender();
    List<PassengerDownOrders> findNation();
    List<PassengerDownOrders> findCultureLevel();
    List<PassengerDownOrders> findPassengerLevel();
    List<PassengerDownOrders> findLicenseCategory();
    List<PassengerDownOrders> findLicenseNumber();
    List<PassengerDownOrders> findReason();

}
