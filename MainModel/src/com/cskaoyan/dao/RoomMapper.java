package com.cskaoyan.dao;

import com.cskaoyan.bean.Room;
import com.cskaoyan.utils.RoomVO;

import java.util.ArrayList;

public interface RoomMapper {

    //删除
    int deleteByPrimaryKey(int[] ids);

    //增加(部分元素)
    int insertSelective(Room record);

    //查-所有的房间-分页查询
    ArrayList<Room> findAllRoom(RoomVO vo);

    //查-根据房间号--模糊查询(分页)
    ArrayList<Room> findRoomByRoomNumber(RoomVO vo);

    //改-房间元素的修改(部分修改)(主要还是房间状态-如何修改的问题)
    int updateByPrimaryKeySelective(Room record);

    //查找要修改的房间
    Room findRoomById(int id);

}