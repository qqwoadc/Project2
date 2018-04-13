package com.cskaoyan.test;

import com.cskaoyan.bean.Room;
import com.cskaoyan.utils.Page;
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

/*
    //测试删除
    @Test
    public void test1() {

        int[] ids = {1, 2};
        service.deleteByPrimaryKey(ids);

    }

    //插入所有属性
    @Test
    public void test2() {

        Room room = new Room("007", "单人普通房",
                1, 1, 200.0, 50.0,
                4, 1, 150.0, "空房间", 1);

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
                4, 1, 150.0, "空房间", 4);

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


    //查找所有房间通过id
    @Test
    public void test6() {


        service.findRoomById(1);

    }


    //查找所有行
    @Test
    public void test7() {


        int i = service.findAllRoomCount();


        System.out.println(i);

    }


    @Test
    public void test8() {

        int i = service.finRoomCount("%00%");
        System.out.println(i);

    }


    @Test
    public void test9() {


        String roomNumber = "003";

        int i = service.exactFindByRoomNumber(roomNumber);
        System.out.println(i + "=============================================");

    }
*/


    @Test
    public void test10() {


        Page<Room> roomPage = service.allRoomPaging(1, 2);
        System.out.println(roomPage);


    }


    @Test
    public void test11() {


        Page<Room> roomPage = service.searchRoomPaging("003", 1, 2);
        System.out.println(roomPage);


    }

}
