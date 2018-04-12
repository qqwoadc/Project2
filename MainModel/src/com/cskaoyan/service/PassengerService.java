package com.cskaoyan.service;

import com.cskaoyan.bean.Passenger;

import java.util.List;

public interface PassengerService{
    List<Passenger> selectPassengersList();
    int deletePassengerById(int id);
    int addPassenger(Passenger passenger);
    int updatePassenger(Passenger passenger);
    List<Passenger> findPassengerByName(String name);
}
