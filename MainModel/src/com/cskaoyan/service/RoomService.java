package com.cskaoyan.service;
import com.cskaoyan.bean.Room;
import java.util.ArrayList;

public interface RoomService {



    //主页跳转客房管理-要查一次所有客房-分页显示
    //精确查询-如果什么也不输入也要分页显示所有客房
   ArrayList<Room> findRoomByRoomNumber(String  roomNumber);

    //新增客房-
    int insertSelective(Room record);

    //修改客房-
    int updateByPrimaryKeySelective(Room record);

    //删除客房-(批量循环删除-直接在dao层实现)
    int deleteByPrimaryKey(Integer id);

}
