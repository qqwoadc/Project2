package com.cskaoyan.controller;
import com.cskaoyan.bean.Room;
import com.cskaoyan.bean.RoomLevel;
import com.cskaoyan.bean.RoomStatus;
import com.cskaoyan.service.RoomService;
import com.cskaoyan.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@RequestMapping("/RoomSet")
@Controller
public class RoomController {


    @Autowired
    RoomService service;

    //通过房间号查询
    @RequestMapping(path = "/tolist.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String findRoom(String txtname, Integer currentPage, Model model) {


        //判断是不是第一次访问,第一次访问没有currentPage
        if (currentPage == null) {

            currentPage = 1;

        }

        double limit;//每页多少数据

        //判断传入的数据是不是空/空字符串
        if (txtname == null || txtname.isEmpty()) {

            limit = 2;

            Page<Room> roomPage = service.allRoomPaging(currentPage, limit);

            model.addAttribute("list", roomPage);//放入域对象中

            return "/WEB-INF/jsp/roomset/roomset.jsp";

        } else {


            limit = 2;

            Page<Room> roomPage = service.searchRoomPaging(txtname, currentPage, limit);

            model.addAttribute("list", roomPage);

            model.addAttribute("txtname", txtname);

            return "/WEB-INF/jsp/roomset/roomset.jsp";

        }

    }

    //增加房间页面的下拉栏
    @RequestMapping(path = "toadd.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toAddRoom(Model model) {

        ArrayList<RoomLevel> levelList = service.toAddRoomLevelService();
        ArrayList<RoomStatus> statusList = service.toAddRoomStatusService();

        //放入域对象中
        model.addAttribute("listOne", levelList);
        model.addAttribute("listTwo", statusList);


        return "/WEB-INF/jsp/roomset/add.jsp";
    }


    //增加房间业务
    @RequestMapping(path = "add.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String addRoom(Room room) {

        int log = service.addRoomService(room);

        //可以根据log再增加一个添加成功的页面

        return "/RoomSet/tolist.do";
    }


    //修改房间信息的下拉栏
    @RequestMapping(path = "toupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toUpdateRoom(Model model, int id) {

        System.out.println(id);

        ArrayList<RoomLevel> levelList = service.toAddRoomLevelService();
        ArrayList<RoomStatus> statusList = service.toAddRoomStatusService();

        //查询room对象并且回显
        Room room = service.findRoomById(id);

        //放入域对象中
        model.addAttribute("listOne", levelList);
        model.addAttribute("listTwo", statusList);
        model.addAttribute("listPo", room);

        return "/WEB-INF/jsp/roomset/update.jsp";

    }


    //房间修改业务
    @RequestMapping(path = "update.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateRoom(Room room) {

        //增加修改成功页面
        int log = service.updateRoomService(room);

        return "/RoomSet/tolist.do";
    }


    //用阿贾克斯验证房间号是否存在(使用json数据)
    @RequestMapping(path = "YZ.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int updateRoomAJX(@RequestBody String roomNumber) {

        //根据roomNumber精确查找是否存相同的房间号
        int result = service.aJXService(roomNumber);

        return result;
    }


    //删除房间(涉及批量删除)-之后再返回主页查询所有房间
    @RequestMapping(path = "delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteRoom(int[] id) {

        int log = service.deleteByPrimaryKey(id);

        //可以增加一个删除成功页面

        return "/RoomSet/tolist.do";

    }


}
