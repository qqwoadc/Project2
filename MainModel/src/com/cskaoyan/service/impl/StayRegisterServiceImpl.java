package com.cskaoyan.service.impl;

import com.cskaoyan.bean.StayRegister;
import com.cskaoyan.service.StayRegisterService;

import java.util.ArrayList;

public class StayRegisterServiceImpl implements StayRegisterService {
    @Override
    public ArrayList<StayRegister> findAllStayRegister(String isbill) {
        return null;
    }

    @Override
    public ArrayList<StayRegister> findPartStayRegister(String isbill, int limit, int offset, String txt, String lvkeleixing) {
        return null;
    }

    @Override
    public int gettotalItems(String isbill, String lvkeleixing, String txt) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(StayRegister sr) {
        return 0;
    }

    @Override
    public int addStayRegister(StayRegister sr) {
        return 0;
    }
}
