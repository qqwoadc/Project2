package com.cskaoyan.dao;

import com.cskaoyan.bean.Passenger;

import java.util.ArrayList;
import java.util.List;

public interface PassengerMapper {
    List<Passenger> findAllPassenger();
    int addPassenger(Passenger passenger);
    int updatePassenger(Passenger passenger);
    int deletePassenger(int id);
    List<Passenger> findPassengerByName(String name);
}
