package com.cskaoyan.service;

import com.cskaoyan.bean.StayRegister;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface StayRegisterService {


    //查-所有的(是否结账)
    ArrayList<StayRegister> findAllStayRegister(String isbill);

    //模糊查询(分页)是否结账、是散客还是群体\有没有查询条件
    ArrayList<StayRegister> findPartStayRegister(@Param("isbill") String isbill,
                                                 @Param("limit")int limit,
                                                 @Param("offset")int offset,
                                                 @Param("txt") String txt,
                                                 @Param("lvkeleixing")String lvkeleixing);

    int gettotalItems(@Param("isbill")String isbill,@Param("lvkeleixing")String lvkeleixing,@Param("txt") String txt);
    //    通过id修改
    int updateByPrimaryKeySelective(StayRegister sr);
    //增加
    int addStayRegister(StayRegister sr);
}
