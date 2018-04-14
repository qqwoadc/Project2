package com.cskaoyan.dao;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.utils.PassengerVO;

import java.util.ArrayList;

public interface PassengerMapper {
    //显示所有的旅客
    ArrayList<Passenger> findAllPassenger(PassengerVO passengerVO);
    //增加旅客
    int addPassenger(Passenger passenger);
    //更新用户信息
    int updatePassenger(Passenger passenger);
    //删除用户
    int deletePassenger(int id);
    //通过name查旅客
    ArrayList<Passenger> findPassengerByName(PassengerVO passengerVO);
    //统计所有的旅客
    int countAllPassenger();
    //通过名字统计所有的旅客
    int countAllPassengerByName(String txtname);
    //通过id查找所有的旅客
    Passenger findPassengerById(int id);
}
