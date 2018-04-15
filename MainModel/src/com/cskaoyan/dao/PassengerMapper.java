package com.cskaoyan.dao;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.utils.PassengerVO;

import java.util.ArrayList;

public interface PassengerMapper {


    int insert(Passenger record);

    int updateByPrimaryKey(Passenger record);



    //删除
    int deleteByPrimaryKey(Integer id);

    //插入passenger
    int insertSelective(Passenger record);

    //根据id查出对象
    Passenger selectByPrimaryKey(Integer id);

    //更新
    int updateByPrimaryKeySelective(Passenger record);



    //求所有旅客数量(自己写)
    int countAllPassenger();

    //分页查询(自己写)
    ArrayList<Passenger> selectPassengersList(PassengerVO passengerVO);

    //模糊查询数量(自己写)
    int countAllPassengerByName(String txtname);

    //模糊分页(自己写)
    ArrayList<Passenger> findPassengerByName(PassengerVO passengerVO);






}