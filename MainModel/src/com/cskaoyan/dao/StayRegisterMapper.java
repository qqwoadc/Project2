package com.cskaoyan.dao;

import com.cskaoyan.bean.StayRegister;
import com.cskaoyan.bean.StayRegisterDetails;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface StayRegisterMapper {


    //查-所有的(是否结账)
    ArrayList<StayRegister> findAllStayRegister(String isbill);

    //模糊查询(分页)是否结账、是散客还是群体\有没有查询条件
    ArrayList<StayRegister> findPartStayRegister(@Param("isBill") String isbill,
                                                 @Param("limit")int limit,
                                                 @Param("offset")int offset,
                                                 @Param("roomNumber") String txt,
                                                 @Param("lvkeleixing")String lvkeleixing);

    int gettotalItems(@Param("isBill")String isbill,@Param("lvkeleixing")String lvkeleixing,@Param("roomNumber")String txt);
//    通过id修改
    int updateByPrimaryKeySelective(StayRegister sr);
//增加
    int addStayRegister(StayRegister sr);

//    与订单左交获取所有数据

    StayRegisterDetails getAllMessage(int srId);
}
