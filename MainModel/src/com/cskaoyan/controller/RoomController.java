package com.cskaoyan.controller;

import com.cskaoyan.bean.Room;
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

        double limit = 10;//每页数据

        int offset;//偏移量

        double totalRoom;//总房间数


        //判断传入的数据是不是空/空字符串
        if (txtname == null || txtname.isEmpty()) {

            //当第一进入页面或者传入的是空字符串的时候

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


            //当输入的是非空/非空空字符串-进行模糊查询
            //1.需要提供offset=(页面-1)10

            offset = (int) ((currentPage - 1) * limit);//计算偏移量

            RoomVO roomVO = new RoomVO(txtname, (int) limit, offset);//产生包装类

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
    public String toAddRoom() {





        return "/WEB-INF/jsp/roomset/add.jsp";
    }

    //增加房间业务
    @RequestMapping(path = "add.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String addRoom() {




        return "/WEB-INF/jsp/roomset/roomset.jsp";
    }



    //修改房间信息的下拉栏
    @RequestMapping(path = "toupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toUpdateRoom() {


        return "/WEB-INF/jsp/roomset/update.jsp";
    }

    //房间修改业务
    @RequestMapping(path = "update.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateRoom() {


        return "/WEB-INF/jsp/roomset/update.jsp";
    }


    //用阿贾克斯验证房间号是否存在
    @RequestMapping(path = "YZ.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateRoomAJX() {


        return "/WEB-INF/jsp/roomset/update.jsp";
    }





    //删除房间(涉及批量删除)-之后再返回主页查询所有房间
    @RequestMapping(path = "delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteRoom() {


        return "/WEB-INF/jsp/roomset/roomset.jsp";

    }


}
