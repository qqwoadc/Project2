package com.cskaoyan.test;


import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.dao.ReceiveTargetMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BaijieTest {

    @Autowired
    ReceiveTargetMapper dao;

    @Test
    public void test(){

        ReceiveTarget a = dao.findRtByTeamName("%a%");

        System.out.println("jhfliaudflkdshf!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+a);
    }

}
