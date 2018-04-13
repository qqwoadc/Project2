package com.cskaoyan.service;

import com.cskaoyan.bean.Room;
import com.cskaoyan.bean.RoomLevel;
import com.cskaoyan.bean.RoomStatus;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.RoomVO;

import java.util.ArrayList;

public interface RoomService {


    //根据id精确查询
    Room findRoomById(int id);

    //删除客房-(批量循环删除-直接在dao层实现)
    int deleteByPrimaryKey(int[] ids);

    //重构

    Page<Room> allRoomPaging(Integer currentPage, double limit);

    Page<Room> searchRoomPaging(String txtname, Integer currentPage, double limit);

    ArrayList<RoomLevel> toAddRoomLevelService();

    ArrayList<RoomStatus> toAddRoomStatusService();

    int addRoomService(Room room);

    int updateRoomService(Room room);

    int aJXService(String roomNumber);
}
