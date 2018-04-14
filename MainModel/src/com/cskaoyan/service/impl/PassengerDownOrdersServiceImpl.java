package com.cskaoyan.service.impl;

import com.cskaoyan.bean.PassengerDownOrders;
import com.cskaoyan.dao.PassengerDownOrdersMapper;
import com.cskaoyan.service.PassengerDownOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerDownOrdersServiceImpl implements PassengerDownOrdersService {
    @Autowired
    PassengerDownOrdersMapper passengerDownOrdersMapper;
    @Override
    public List<PassengerDownOrders> findGender() {
        return passengerDownOrdersMapper.findGender();
    }

    @Override
    public List<PassengerDownOrders> findNation() {
        return passengerDownOrdersMapper.findNation();
    }

    @Override
    public List<PassengerDownOrders> findCultureLevel() {
        return passengerDownOrdersMapper.findCultureLevel();
    }

    @Override
    public List<PassengerDownOrders> findPassengerLevel() {
        return passengerDownOrdersMapper.findPassengerLevel();
    }

    @Override
    public List<PassengerDownOrders> findLicenseCategory() {
        return passengerDownOrdersMapper.findLicenseCategory();
    }

    @Override
    public List<PassengerDownOrders> findReason() {
        return passengerDownOrdersMapper.findReason();
    }

}

