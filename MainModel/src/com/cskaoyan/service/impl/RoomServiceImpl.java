package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Room;
import com.cskaoyan.utils.RoomVO;
import com.cskaoyan.dao.RoomMapper;
import com.cskaoyan.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RoomServiceImpl implements RoomService {


    @Autowired
    RoomMapper dao;


    //查找所有房间
    @Override
    public ArrayList<Room> findAllRoom(RoomVO vo) {


        return dao.findAllRoom(vo);
    }

    @Override
    public ArrayList<Room> findRoomByRoomNumber(RoomVO vo) {


        return dao.findRoomByRoomNumber(vo);
    }

    @Override
    public int insertSelective(Room record) {


        return dao.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Room record) {

        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(int[] ids) {
        return dao.deleteByPrimaryKey(ids);
    }

    @Override
    public Room findRoomById(int id) {

        Room room = dao.findRoomById(id);

        return room;
    }

    @Override
    public int findAllRoomCount() {

        int count = dao.findAllRoomCount();


        return count;
    }

    @Override
    public int finRoomCount(String txtname) {


        int count = dao.finRoomCount(txtname);


        return count;
    }

    @Override
    public int exactFindByRoomNumber(String roomNumber) {

        int i = dao.exactFindByRoomNumber(roomNumber);

        return i;
    }

}
