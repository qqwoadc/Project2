package com.cskaoyan.test;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.service.PassengerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HanhaominTest {

    @Autowired
    PassengerService dao;

    @Test
    public void test(){

//        List<Passenger> a = dao.selectPassengersList();
//        ArrayList<Passenger> list = new ArrayList(a);
//        System.out.println("a="+list.toString());
    }

}

