package com.cskaoyan.test;

import com.cskaoyan.bean.Room;
import com.cskaoyan.utils.RoomVO;
import com.cskaoyan.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceTest {


    @Autowired
    RoomService service;

    //测试删除
    @Test
    public void test1() {


        service.deleteByPrimaryKey(7);


    }

    //插入所有属性
    @Test
    public void test2() {

        Room room = new Room("007", "单人普通房",
                1, 1, 200.0, 50.0,
                4, 1, 150.0, "空房间");

        int insert = service.insertSelective(room);

        System.out.println(insert);

    }

    //查询
    @Test
    public void test3() {


        //Room room = new Room();
        //ArrayList<Room> rooms = service.findRoomByRoomNumber("");
        //ArrayList<Room> rooms = mapper.findRoomByRoomNumber("001");
        //ArrayList<Room> rooms = dao.findRoomByRoomNumber(room.getRoomnumber());


        //System.out.println(rooms);

    }

    //修改
    @Test
    public void test4() {

        Room room = new Room(9, "007", "豪华间",
                1, 1, 200.0, 50.0,
                4, 1, 150.0, "空房间");

        int i = service.updateByPrimaryKeySelective(room);
        System.out.println(i);


    }


    //查找所有房间
    @Test
    public void test5() {


        RoomVO roomVO = new RoomVO();
        roomVO.setLimit(5);
        roomVO.setOffset(0);
        ArrayList<Room> rooms = service.findAllRoom(roomVO);
        System.out.println(rooms);

    }


}
