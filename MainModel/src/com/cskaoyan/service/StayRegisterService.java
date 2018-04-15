package com.cskaoyan.service;

import com.cskaoyan.bean.ArrangeRoom;
import com.cskaoyan.bean.StayRegister;
import com.cskaoyan.bean.StayRegisterDetails;
import com.cskaoyan.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.ArrayList;

public interface StayRegisterService {


    //查-所有的(是否结账)
    ArrayList<StayRegister> findAllStayRegister(String isbill);

    //模糊查询(分页)是否结账、是散客还是群体\有没有查询条件
    Page<StayRegisterDetails> findPartStayRegister(String isbill,
                                                   String txtname, Integer currentPage,
                                                   String lvkeleixing);


    //    通过id修改
    int updateByPrimaryKeySelective(StayRegister sr);
    //增加
    int addStayRegister(StayRegister sr);

//    通过安排房间页面提供的数据新建表单
    int addStayRegisterByArrangeRoom(ArrangeRoom arrangeRoom) throws ParseException;

    StayRegisterDetails getAllMessage(int srId);
}
