package com.cskaoyan.test;

import com.cskaoyan.bean.Predetermine;
import com.cskaoyan.service.PredetermineService;
import com.cskaoyan.utils.MyDateConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PredetermineServiceTest {

    @Autowired
    PredetermineService predetermineService;

    @Test
    public void testdemo(){
        System.out.println("test");
    }

    @Test
    public void testfindAllPredetermineMSG(){

        List<Predetermine> allPredetermineMSG = predetermineService.findAllPredetermineMSG();

        System.out.println(allPredetermineMSG);

    }

    @Test
    public void testaddPredetermineMSG(){

        Date convert = new MyDateConverter().convert("2018-05-05 05:05:05");
        Predetermine predetermine = new Predetermine();
       // predetermine.setPredetermineId(5);
        predetermine.setRemind(1);
        predetermine.setArriveTime(convert);
        predetermine.setPassengerId(003);
        predetermine.setDeposit((float) 200);
        predetermine.setPredetermineStateName("未安排");
        predetermine.setPredetermineDay(5);
        predetermine.setTeamId(0);
        int i = predetermineService.addPredetermineMSG(predetermine);
        System.out.println(i);
    }

    @Test
    public void testupdatePredetermineMSG(){

        Date convert = new MyDateConverter().convert("2018-05-05 05:05:05");

        Predetermine predetermine = new Predetermine();

        predetermine.setPredetermineId(1);
        predetermine.setRemind(1);
        predetermine.setArriveTime(convert);
        predetermine.setPassengerId(003);
        predetermine.setDeposit((float) 200);
        predetermine.setPredetermineStateName("未安排");
        predetermine.setPredetermineDay(5);
        predetermine.setTeamId(0);

        int i = predetermineService.updatePredetermineMSG(predetermine);

        System.out.println(i);
    }

    @Test
    public void testdeletePredetermineById(){

        Predetermine predetermine = new Predetermine();

        predetermine.setPredetermineId(1);

        int i = predetermineService.deletePredetermineMSG(predetermine);

        System.out.println(i);
    }

}
