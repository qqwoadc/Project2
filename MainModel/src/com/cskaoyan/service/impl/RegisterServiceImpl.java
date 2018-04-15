package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.dao.PassengerMapper2;

import com.cskaoyan.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    PassengerMapper2 dao;


    @Override
    public int deleteByPrimaryKey(Integer id) {


        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Passenger record) {


        return dao.insert(record);
    }

    @Override
    public int insertSelective(Passenger record) {


        return dao.insertSelective(record);
    }

    @Override
    public Passenger selectByPrimaryKey(Integer id) {


        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Passenger record) {

        return dao.updateByPrimaryKeySelective(record);

    }

    @Override
    public int updateByPrimaryKey(Passenger record) {

        return dao.updateByPrimaryKey(record);

    }

    @Override
    public ArrayList<Passenger> findAllPassenger() {
        return dao.findAllPassenger();
    }

    @Override
    public ArrayList<Passenger> findPassengerByName(String txtname) {
        return dao.findPassengerByName(txtname);
    }
}
