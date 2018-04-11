package com.cskaoyan.controller;

import com.cskaoyan.bean.Room;
import com.cskaoyan.bean.RoomLevel;
import com.cskaoyan.bean.RoomStatus;
import com.cskaoyan.utils.RoomVO;
import com.cskaoyan.service.RoomService;
import com.cskaoyan.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@RequestMapping("/RoomSet")
@Controller
public class RoomController {


    @Autowired
    RoomService service;


    //通过房间号查询
    @RequestMapping(path = "/tolist.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String findRoom(String txtname, String current, Model model) {

        System.out.println(txtname);
        System.out.println(current);

        ArrayList<Room> roomList;//room链表


        int currentPage = 1;


        if (current != null) {

            currentPage = Integer.valueOf(current) + 1;

        }


        int totalPage;//总页数

        double limit = 100;//每页数据

        int offset;//偏移量

        double totalRoom;//总房间数


        //判断传入的数据是不是空/空字符串
        if (txtname == null || txtname.isEmpty()) {

            //当第一进入页面或者传入的是空字符串的时候-全部查询并且分页

            offset = (int) ((currentPage - 1) * limit);//求出偏移量

            RoomVO roomVO = new RoomVO((int) limit, offset);//包装类

            roomList = service.findAllRoom(roomVO);//查出所有的房间-列表对象(分页查需要传入-偏移量-根据传入的页面计算)

            System.out.println(roomList);

            totalRoom = roomList.size();//得到总的房间-数量

            totalPage = (int) Math.ceil(totalRoom / limit);//算出总页数


            Page<Room> roomPage = new Page<Room>();

            roomPage.setTotalPage(totalPage);//传入总页数

            roomPage.setResult(roomList);//传入列表对象

            roomPage.setCurrentPage(currentPage);//传入当前页数

            model.addAttribute("list", roomPage);//放入域对象中

            return "/WEB-INF/jsp/roomset/roomset.jsp";

        } else {


            //当输入的是非空/非空空字符串-进行模糊查询-并且分页
            //1.需要提供offset=(页面-1)10

            offset = (int) ((currentPage - 1) * limit);//计算偏移量

            RoomVO roomVO = new RoomVO();//产生包装类

            roomVO.setRoomNumber("%"+txtname+"%");//放入值
            roomVO.setLimit((int) limit);
            roomVO.setOffset(offset);

            roomList = service.findRoomByRoomNumber(roomVO);//查数据库,查出链表

            totalRoom = roomList.size();//求出房间总数

            totalPage = (int) Math.ceil(totalRoom / limit); //求出页面总数

            Page<Room> roomPage = new Page<>(); //把所求出的信息放入page类中

            roomPage.setCurrentPage(currentPage);

            roomPage.setTotalPage(totalPage);

            roomPage.setResult(roomList);

            model.addAttribute("list", roomPage);
            model.addAttribute("txtname", txtname);

            return "/WEB-INF/jsp/roomset/roomset.jsp";

        }

    }


    //增加房间页面的下拉栏
    @RequestMapping(path = "toadd.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toAddRoom(Model model) {

        ArrayList<RoomLevel> levelList = new ArrayList<>();//客房等级
        ArrayList<Object> statusList = new ArrayList<>();//房态

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


        //放入域对象中
        model.addAttribute("listOne", levelList);
        model.addAttribute("listTwo", statusList);


        return "/WEB-INF/jsp/roomset/add.jsp";
    }

    //增加房间业务
    @RequestMapping(path = "add.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String addRoom(Room room) {

        System.out.println(room);


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

        service.insertSelective(room);

        return "/RoomSet/tolist.do";
    }


    //修改房间信息的下拉栏
    @RequestMapping(path = "toupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toUpdateRoom(Model model,int id) {

        System.out.println(id);
        ArrayList<RoomLevel> levelList = new ArrayList<>();//客房等级
        ArrayList<Object> statusList = new ArrayList<>();//房态

        //产生对象房间等级对象
        RoomLevel roomLevel = new RoomLevel(1, "单人标准间");
        RoomLevel roomLevel1 = new RoomLevel(2, "二人普通房");
        RoomLevel roomLevel2 = new RoomLevel(3, "二人标准间");
        RoomLevel roomLevel3 = new RoomLevel(4, "豪华间");
        RoomLevel roomLevel4 = new RoomLevel(5, "会议室");
        RoomLevel roomLevel5 = new RoomLevel(6, "总统套房");
        RoomLevel roomLevel6 = new RoomLevel(8, "单人普通房");
        //放入链表
        levelList.add(roomLevel);
        levelList.add(roomLevel1);
        levelList.add(roomLevel2);
        levelList.add(roomLevel3);
        levelList.add(roomLevel4);
        levelList.add(roomLevel5);
        levelList.add(roomLevel6);

        //产生房间状态对象
        RoomStatus roomStatus = new RoomStatus(1, "空房间");
        RoomStatus roomStatus1 = new RoomStatus(2, "自用房");
        RoomStatus roomStatus2 = new RoomStatus(4, "预定");
        RoomStatus roomStatus3 = new RoomStatus(5, "待清洁");
        RoomStatus roomStatus4 = new RoomStatus(6, "维修");
        RoomStatus roomStatus5 = new RoomStatus(7, "不可用");
        RoomStatus roomStatus6 = new RoomStatus(65, "满");

        //放入链表中
        statusList.add(roomStatus);
        statusList.add(roomStatus1);
        statusList.add(roomStatus2);
        statusList.add(roomStatus3);
        statusList.add(roomStatus4);
        statusList.add(roomStatus5);
        statusList.add(roomStatus6);




        //查询room对象并且回显
        Room room = service.findRoomById(id);

        //放入域对象中
        model.addAttribute("listOne", levelList);
        model.addAttribute("listTwo", statusList);
        model.addAttribute("listPo",room);

        return "/WEB-INF/jsp/roomset/update.jsp";

    }

    //房间修改业务
    @RequestMapping(path = "update.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateRoom(Room room) {

        System.out.println(room);


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


        service.updateByPrimaryKeySelective(room);

        return "/RoomSet/tolist.do";
    }


    //用阿贾克斯验证房间号是否存在(使用json数据)
    @RequestMapping(path = "YZ.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateRoomAJX() {


        return "/WEB-INF/jsp/roomset/update.jsp";
    }


    //删除房间(涉及批量删除)-之后再返回主页查询所有房间
    @RequestMapping(path = "delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteRoom(int[] id) {

        service.deleteByPrimaryKey(id);

        return "/RoomSet/tolist.do";

    }


}
