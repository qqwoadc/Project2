package com.cskaoyan.controller;

import com.cskaoyan.bean.Room;
import com.cskaoyan.service.DownorderMapperService;
import com.cskaoyan.service.RoomService;
import com.cskaoyan.utils.Downorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StayRegisterController {


    @Autowired
    DownorderMapperService downorderMapperService;

    @Autowired
    RoomService roomService;

    @RequestMapping(path = "StayRegister/tolist",method ={RequestMethod.GET,RequestMethod.POST})
    public String stToList(){


        return "/WEB-INF/jsp/stayregister/list.jsp";
    }

//房间安排界面
    @RequestMapping(path = "StayRegister/toarrangeroom")
    public String arrangeRooom(String LvKeLeiXingId, String tuanDuiID, Model model){

//出租方式列表 listRentOutType
        List<Downorder> listRentOutType = downorderMapperService.getAttributeByfar_id(20);
//旅客类别列表 listPassengerType
        List<Downorder> listPassengerType = downorderMapperService.getAttributeByfar_id(21);
// 结账单位    listBillUnit
        List<Downorder> listBillUnit = downorderMapperService.getAttributeByfar_id(22);
// 支付方式 listPayWay
        List<Downorder> listPayWay = downorderMapperService.getAttributeByfar_id(23);
//        list，元素为房间
        List<Room> list = roomService.getAllRoom();

        model.addAttribute("listRentOutType",listRentOutType);
        model.addAttribute("listPassengerType",listPassengerType);
        model.addAttribute("listBillUnit",listBillUnit);
        model.addAttribute("listPayWay",listPayWay);
        model.addAttribute("list",list);

//        当安排房间的是群体对象时会先指定一个群体
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        model.addAttribute("tuanDuiID",tuanDuiID);

        return "/WEB-INF/jsp/stayregister/arrangeroom.jsp";
    }

//    安排房间,相当于新增一个房间登记项
    @RequestMapping(path = "StayRegister/arrangeroom")
    public String arrangeroom(String LvKeLeiXingId){


        return "/WEB-INF/jsp/stayregister/list.jsp";
    }

//  显示各类房间列表
    @RequestMapping(path = "StayRegister/guestRoomLevelSelectRoom")
    public String guestRoomLevelSelectRoom(@RequestBody String guestRoomLevelID){


        List<Room> roomByRoomLevel = roomService.getRoomByRoomLevel(guestRoomLevelID);
        return "/WEB-INF/jsp/stayregister/arrangeroom.jsp";
    }
}
