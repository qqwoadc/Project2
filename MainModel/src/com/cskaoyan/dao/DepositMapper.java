package com.cskaoyan.dao;

import com.cskaoyan.bean.Deposit;

import java.util.ArrayList;

public interface DepositMapper {
    //显示某个用户所有的押金记录
    ArrayList<Deposit> findAllDeposit(int predetermineId);
    //追加押金
    int addDeposit(int predetermineId);

}
