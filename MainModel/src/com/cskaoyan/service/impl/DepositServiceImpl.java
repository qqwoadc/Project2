package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Deposit;
import com.cskaoyan.dao.DepositMapper;
import com.cskaoyan.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    DepositMapper depositMapper;
    @Override
    public ArrayList<Deposit> findAllDeposit(int predetermineId) {
        return depositMapper.findAllDeposit(predetermineId);
    }

    @Override
    public int addDeposit(int predetermineId) {
        return depositMapper.addDeposit(predetermineId);
    }
}
