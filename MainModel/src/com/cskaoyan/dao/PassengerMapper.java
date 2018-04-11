package com.cskaoyan.dao;

import com.cskaoyan.bean.Passenger;

public interface PassengerMapper {
    public Passenger findAllPassenger();
    public int addPassenger(Passenger passenger);
    public int updatePassenger(int id);
    public int deletePassenger(int id);
    public Passenger findPassengerByName(String name);
}
