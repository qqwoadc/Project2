package com.cskaoyan.dao;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.bean.Predetermine;
import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.bean.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PredetermineMapper {

    //返回所有预定信息
    List<Predetermine> findAllPredetermineMSG();

    //添加预定信息
    int addPredetermineMSG(Predetermine predetermine);

    //修改预定信息
    int updatePredetermineMSG(Predetermine predetermine);

    //删除预定信息
    int deletePredetermineMSGById(Predetermine predetermine);

    //查找默认记录总数（未安排）
    int findTotalMSGNum1();

    //根据MSG查找记录总数
    int findTotalMSGNum2(@Param("MSG") String MSG);

    //查找符合条件的信息总数
    int searchMSGNum(@Param("txtname") String txtname,@Param("predetermineStateName") String MSG);

    //查找默认预定页面信息（未安排）
    List<Predetermine> findPartPredetermineMSG1(@Param("limit") int limit,
                                                @Param("offset") int offset);

    //根据MSG查找页面信息
    List<Predetermine> findPartPredetermineMSG2(@Param("predetermineStateName") String MSG,
                                                @Param("limit") int limit,
                                                @Param("offset") int offset);

    //查找符合条件的页面信息
    List<Predetermine> findPartPredetermineMSG3(@Param("txtname") String txtname,
                                                @Param("predetermineStateName") String MSG,
                                                @Param("limit") int limit,
                                                @Param("offset") int offset);

    //查找所有团队信息
    List<ReceiveTarget> findAllTeamTarget();

    //根据txtname查找所有团队信息
    List<ReceiveTarget> findTeamTargetByName(@Param("txtname") String txtname);

    //查找所有旅客信息
    List<Passenger> findAllPassenger();

    //根据txtname查找旅客信息
    List<Passenger> findPassengerByName(@Param("txtname") String txtname);

    //根据选择的ID查找旅客信息
    Passenger findPassengerById(int id);

    //选择所有可用房间
    List<Room> findAllAvailableRoom();

    //根据roomNumber选择房间
    List<Room> findRoomByNumber(String roomNumber);

    //根据roomId查找房间
    Room findRoomById(@Param("roomId") int roomId);

    //根据房间Id修改房间状态
    int updateRoomById(@Param("roomId") int roomId);

    //根据id查找接待对象
    ReceiveTarget findTeamById(@Param("id") int id);
}
