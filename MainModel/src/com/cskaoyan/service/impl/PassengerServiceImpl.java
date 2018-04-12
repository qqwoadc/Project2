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
    PassengerMapper passengerMapper;
    @Override
    public List selectPassengersList() {
        return passengerMapper.findAllPassenger();
    }

    @Override
    public int deletePassengerById(int id) {
        return passengerMapper.deletePassenger(id);
    }

    @Override
    public int addPassenger(Passenger passenger) {
        return passengerMapper.addPassenger(passenger);
    }

    @Override
    public int updatePassenger(Passenger passenger) {
        return passengerMapper.updatePassenger(passenger);
    }

    @Override
    public List<Passenger> findPassengerByName(String name) {
        return passengerMapper.findPassengerByName(name);
    }
}
