package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.dao.PassengerMapper;
import com.cskaoyan.service.PassengerService;
import com.cskaoyan.utils.PassengerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerMapper passengerMapper;
    @Override
    public ArrayList<Passenger> selectPassengersList(PassengerVO passengerVO) {

        return passengerMapper.findAllPassenger(passengerVO);
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
    public ArrayList<Passenger> findPassengerByName(PassengerVO passengerVO) {
        return passengerMapper.findPassengerByName(passengerVO);
    }

    @Override
    public int countAllPassenger() {
        return passengerMapper.countAllPassenger();
    }

    @Override
    public int coutAllPassengerByName(String txtname) {
        return passengerMapper.countAllPassengerByName(txtname);
    }

    @Override
    public Passenger findPassengerById(int id) {
        return passengerMapper.findPassengerById(id);
    }
}
