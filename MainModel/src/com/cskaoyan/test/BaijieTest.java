package com.cskaoyan.test;


import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.dao.ReceiveTargetMapper;
import com.cskaoyan.service.ReceiveTargetService;
import com.cskaoyan.utils.MyDateConverter;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.ReceiveTargetVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sound.sampled.ReverbType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BaijieTest {

    @Autowired
    ReceiveTargetService service;

    ReceiveTargetVO receiveTargetVO;

    @Test
    public void test1(){
        List<ReceiveTarget> allRt = service.findAllRt(receiveTargetVO);
        System.out.println("jhfliaudflkdshf!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+allRt);
    }

//    @Test
//    public void test2() throws ParseException {
//
//  MyDateConverter myDateConverter = new MyDateConverter();
//
//        Date convert = myDateConverter.convert("1999-01-01 12:12:12");
//        System.out.println("registerTime ============================================"+convert);
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.setLenient(false);
//        String s = String.valueOf(System.currentTimeMillis());
//        java.util.Date date = format.parse(s);
//        java.sql.Date date1 = new java.sql.Date(date.getTime());
//        System.out.println("sqltime = ================"+date1);
//
//
//
//        ReceiveTarget receiveTarget = new ReceiveTarget();
//        int teamId = receiveTarget.getTeamId();
//        receiveTarget.setTeamId(teamId);
//        receiveTarget.setTeamCode("TD004");
//        receiveTarget.setTeamName("测试");
//        receiveTarget.setTargetTypeName("团队");
//        receiveTarget.setPrincipal("测试");
//        receiveTarget.setRegisterTime(new java.sql.Date(System.currentTimeMillis()));
//        receiveTarget.setContactPhoneNUmber("电话号码");
//
//        int i = dao.addReceiveTarget(receiveTarget);
//        System.out.println("添加是否成功============"+i);
//    }
//
//    @Test
//    public void test3(){
//        List<ReceiveTarget> allRt = dao.findAllRt();
//        System.out.println("allRt =  ==========="+allRt.toString());
//    }
//
    @Test
    public void test4(){
        int i = service.deleteReceiveTargetById(10);
        System.out.println("deleteRt==============="+i);
    }

    @Test
    public void test5(){

/*
        Page<ReceiveTarget> page = service.deleteReceiveTargetByIds();

        System.out.println(page+"====================================================================================" +
                "============================================================");*/


        int [] id={18};

        Integer  i = service.deleteReceiveTargetByIds(id);
        System.out.println(i+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


    }



}
