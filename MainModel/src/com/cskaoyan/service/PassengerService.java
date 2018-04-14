package com.cskaoyan.service;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.utils.PassengerVO;

import java.util.ArrayList;

public interface PassengerService{
    ArrayList<Passenger> selectPassengersList(PassengerVO passengerVO);
    int deletePassengerById(int id);
    int addPassenger(Passenger passenger);
    int updatePassenger(Passenger passenger);
    ArrayList<Passenger> findPassengerByName(PassengerVO passengerVO);
    int countAllPassenger();
    int coutAllPassengerByName(String txtname);
    Passenger findPassengerById(int id);
}
