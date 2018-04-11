package com.cskaoyan.dao;

import com.cskaoyan.bean.Room;

import java.util.ArrayList;

public interface RoomMapper {

    //删除
    int deleteByPrimaryKey(Integer id);

    //增加(所有元素)
    int insert(Room record);

    //增加(部分元素)
    int insertSelective(Room record);

    //查-根据房间号
    ArrayList<Room> findRoomByRoomNumber(String roomNumber);

    Room selectByPrimaryKey(Integer id);

    //改-房间元素的修改(部分修改)(主要还是房间状态-如何修改的问题)
    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

}