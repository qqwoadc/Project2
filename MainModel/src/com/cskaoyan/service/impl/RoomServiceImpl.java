package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Room;
import com.cskaoyan.bean.RoomLevel;
import com.cskaoyan.bean.RoomStatus;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.RoomVO;
import com.cskaoyan.dao.RoomMapper;
import com.cskaoyan.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoomServiceImpl implements RoomService {


    @Autowired
    RoomMapper dao;


    //精确查询根据id
    @Override
    public Room findRoomById(int id) {


        return dao.findRoomById(id);

    }


    //对应删除&批量删除房间
    @Override
    public int deleteByPrimaryKey(int[] ids) {
        return dao.deleteByPrimaryKey(ids);
    }

    //实现全部数据分页-接收数据-返回页面对象
    @Override
    public Page<Room> allRoomPaging(Integer currentPage, double limit) {


        int offset = (int) ((currentPage - 1) * limit);//求出偏移量;

        double totalRoom = dao.findAllRoomCount();//得到总的房间-数量

        int totalPage = (int) Math.ceil(totalRoom / limit);//求出总页数

        RoomVO roomVO = new RoomVO((int) limit, offset);//包装类

        ArrayList<Room> rooms = dao.findAllRoom(roomVO);//查出所有的房间-列表对象(分页查需要传入-偏移量-根据传入的页面计算)

        Page<Room> roomPage = new Page<Room>();

        roomPage.setTotalPage(totalPage);//传入总页数

        roomPage.setResult(rooms);//传入列表对象

        roomPage.setCurrentPage(currentPage);//传入当前页数


        return roomPage;
    }


    //模糊查询分页-接收数据-返回页面对象
    @Override
    public Page<Room> searchRoomPaging(String txtname, Integer currentPage, double limit) {

        int offset = (int) ((currentPage - 1) * limit);//求出偏移量;

        double totalRoom = dao.finRoomCount("%" + txtname + "%");//求出房间总数

        int totalPage = (int) Math.ceil(totalRoom / limit);//求出总页数

        RoomVO roomVO = new RoomVO();//产生包装类

        roomVO.setRoomNumber("%" + txtname + "%");//放入值

        roomVO.setLimit((int) limit);

        roomVO.setOffset(offset);

        ArrayList<Room> rooms = dao.findRoomByRoomNumber(roomVO);//查数据库,查出链表

        Page<Room> roomPage = new Page<>(); //把所求出的信息放入page类中

        roomPage.setCurrentPage(currentPage);

        roomPage.setTotalPage(totalPage);

        roomPage.setResult(rooms);

        return roomPage;
    }

    //增加房间页面的(房间等级)下拉栏业务
    @Override
    public ArrayList<RoomLevel> toAddRoomLevelService() {


        ArrayList<RoomLevel> levelList = new ArrayList<>();//客房等级


        //产生对象房间等级对象
        RoomLevel roomLevel = new RoomLevel(1, "单人标准间");
        RoomLevel roomLevel1 = new RoomLevel(2, "二人普通房");
        RoomLevel roomLevel2 = new RoomLevel(3, "二人标准间");
        RoomLevel roomLevel3 = new RoomLevel(4, "豪华间");
        RoomLevel roomLevel4 = new RoomLevel(5, "会议室");
        RoomLevel roomLevel5 = new RoomLevel(6, "总统套房");
        RoomLevel roomLevel6 = new RoomLevel(8, "单人普通房");
        //放入链表祝
        levelList.add(roomLevel);
        levelList.add(roomLevel1);
        levelList.add(roomLevel2);
        levelList.add(roomLevel3);
        levelList.add(roomLevel4);
        levelList.add(roomLevel5);
        levelList.add(roomLevel6);


        return levelList;

    }


    //增加房间页面的(房态)下拉栏业务
    @Override
    public ArrayList<RoomStatus> toAddRoomStatusService() {


        ArrayList<RoomStatus> statusList = new ArrayList<>();//房态


        //产生房间状态
        RoomStatus roomStatus = new RoomStatus(1, "空房间");
        RoomStatus roomStatus1 = new RoomStatus(2, "自用房");
        RoomStatus roomStatus2 = new RoomStatus(4, "预定");
        RoomStatus roomStatus3 = new RoomStatus(5, "待清洁");
        RoomStatus roomStatus4 = new RoomStatus(6, "维修");
        RoomStatus roomStatus5 = new RoomStatus(7, "不可用");
        RoomStatus roomStatus6 = new RoomStatus(65, "满");

        //产生房间状态对象
        statusList.add(roomStatus);
        statusList.add(roomStatus1);
        statusList.add(roomStatus2);
        statusList.add(roomStatus3);
        statusList.add(roomStatus4);
        statusList.add(roomStatus5);
        statusList.add(roomStatus6);


        return statusList;

    }


    @Override
    public int addRoomService(Room room) {


        switch (room.getGuestRoomLevelID()) {

            case 1:
                room.setGuestRoomLevelName("单人标准间");
                break;
            case 2:
                room.setGuestRoomLevelName("二人普通房");
                break;
            case 3:
                room.setGuestRoomLevelName("二人标准间");
                break;
            case 4:
                room.setGuestRoomLevelName("豪华间");
                break;
            case 5:
                room.setGuestRoomLevelName("会议室");
                break;
            case 6:
                room.setGuestRoomLevelName("总统套房");
                break;
            case 8:
                room.setGuestRoomLevelName("单人普通房");
                break;
        }


        switch (room.getRoomStateID()) {

            case 1:
                room.setRoomName("空房间");
                break;
            case 2:
                room.setRoomName("自用房");
                break;
            case 4:
                room.setRoomName("预定");
                break;
            case 5:
                room.setRoomName("待清洁");
                break;
            case 6:
                room.setRoomName("维修");
                break;
            case 7:
                room.setRoomName("不可用");
                break;
            case 65:
                room.setRoomName("满");
                break;
        }

        int i = dao.insertSelective(room);


        return i;

    }


    @Override
    public int updateRoomService(Room room) {


        switch (room.getGuestRoomLevelID()) {

            case 1:
                room.setGuestRoomLevelName("单人标准间");
                break;
            case 2:
                room.setGuestRoomLevelName("二人普通房");
                break;
            case 3:
                room.setGuestRoomLevelName("二人标准间");
                break;
            case 4:
                room.setGuestRoomLevelName("豪华间");
                break;
            case 5:
                room.setGuestRoomLevelName("会议室");
                break;
            case 6:
                room.setGuestRoomLevelName("总统套房");
                break;
            case 8:
                room.setGuestRoomLevelName("单人普通房");
                break;
        }


        switch (room.getRoomStateID()) {

            case 1:
                room.setRoomName("空房间");
                break;
            case 2:
                room.setRoomName("自用房");
                break;
            case 4:
                room.setRoomName("预定");
                break;
            case 5:
                room.setRoomName("待清洁");
                break;
            case 6:
                room.setRoomName("维修");
                break;
            case 7:
                room.setRoomName("不可用");
                break;
            case 65:
                room.setRoomName("满");
                break;
        }

        int i = dao.updateByPrimaryKeySelective(room);


        return i;

    }


    @Override
    public int aJXService(String roomNumber) {


        String[] split = roomNumber.split("=");

        roomNumber = split[1];

        int result = dao.exactFindByRoomNumber(roomNumber);

        return result;

    }

    @Override
    public List<Room> getAllRoom() {
        return dao.getAllRoom();
    }

    @Override
    public List<Room> getRoomByRoomLevel(String guestRoomLevelID) {

        int i = Integer.parseInt(guestRoomLevelID);
        String txt = "";
        switch (i) {
            case 8:
                txt = "单人普通房";
                break;
            case 9:
                txt = "单人标准间";
                break;
            case 10:
                txt = "二人普通房";
                break;
            case 11:
                txt = "二人标准间";
                break;
            case 12:
                txt = "豪华间";
                break;
            case 13:
                txt = "会议室";
                break;
            case 14:
                txt = "总统套房";
                break;
            case 0:
                txt = "%%";
                break;
        }
        List<Room> roomByRoomLevel = dao.getRoomByRoomLevel(txt);
        return roomByRoomLevel;
    }


}
