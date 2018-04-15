package com.cskaoyan.service;

import com.cskaoyan.bean.Deposit;

import java.util.ArrayList;

public interface DepositService {
    ArrayList<Deposit> findAllDeposit(int predetermineId);
    int addDeposit(int predetermineId);
}
