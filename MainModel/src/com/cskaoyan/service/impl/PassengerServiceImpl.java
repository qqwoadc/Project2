package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.dao.PassengerMapper;
import com.cskaoyan.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService{
    @Autowired
    public PassengerMapper passengerMapper;
    @Override
    public List<Passenger> selectPassengersList() {
        return passengerMapper.findAllPassenger();
    }

    @Override
    public int deletePassengerById(int id) {
        return 0;
    }

    @Override
    public int addPassenger() {
        return 0;
    }
}
