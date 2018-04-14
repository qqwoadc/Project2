package com.cskaoyan.service;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.bean.Predetermine;
import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.bean.Room;
import com.cskaoyan.utils.ListOne;
import com.cskaoyan.utils.Page;

import java.util.List;

public interface PredetermineService {

    //查找所有预定信息，返回一个List
    List<Predetermine> findAllPredetermineMSG();

    //添加一个预定信息
    int addPredetermineMSG(Predetermine predetermine);

    //修改一个预定信息
    int updatePredetermineMSG(Predetermine predetermine);

    //删除一个预定信息
    int deletePredetermineMSG(Predetermine predetermine);

    //返回默认预定页面（未安排）
    Page<Predetermine> findPage1(String currentPage);

    //返回符合查询类型的页面
    Page<Predetermine> findPage3(String txtname,String state,String currentPage);

    //返回按state查找的页面
    Page<Predetermine> findPage2(String currentPage, String state);

    //下拉菜单
    List<ListOne> findListOne();

    //返回默认团队表单
    List<ReceiveTarget> findAllTeamTarget();

    //根据txtname查询团队表单
    List<ReceiveTarget> findTeamTargetByName(String txtname);

    //查找所有旅客信息
    List<Passenger> findAllPassenger();

    //根据txtname查找旅客信息
    List<Passenger> findPassengerByName(String txtname);

    //根据选择的ID查找旅客信息
    Passenger findPassengerById(int id);

    //支付方式下拉菜单
    List<ListOne> findListPay();

    //选择所有可用房间
    List<Room> findAllAvailableRoom();

    //根据房间号码选择房间
    List<Room> findRoomByNumber(String roomNumber);

    //根据房间Id查找room
    Room findRoomById(int roomId);

    //根据房间ID修改房间状态
    int updateRoomById(int roomId);

    //根据teamId查找receiveTarget
    ReceiveTarget findTeamById(int id);
}
