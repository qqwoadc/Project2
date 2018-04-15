package com.cskaoyan.controller;

import com.cskaoyan.bean.ArrangeRoom;
import com.cskaoyan.bean.Room;
import com.cskaoyan.bean.StayRegister;
import com.cskaoyan.bean.StayRegisterDetails;
import com.cskaoyan.service.DownorderMapperService;
import com.cskaoyan.service.RoomService;
import com.cskaoyan.service.StayRegisterService;
import com.cskaoyan.utils.Downorder;
import com.cskaoyan.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StayRegisterController {


    @Autowired
    DownorderMapperService downorderMapperService;

    @Autowired
    RoomService roomService;

    @Autowired
    StayRegisterService stayRegisterService;


//    列表显示
    @RequestMapping(path = "StayRegister/tolist",method ={RequestMethod.GET,RequestMethod.POST})
    public String stToList(Model model,String isBillID, String txtname, String currentPage, String LvKeLeiXingId){


//        传参处理
        String isBill = "";
        if (isBillID=="34"){
            isBill="未结账";
        }else if (isBillID=="35"){
            isBill="已结账";
        }

        String lvkeleixing = "";
        if (LvKeLeiXingId=="36"){
            isBill="散客";
        }else if (LvKeLeiXingId=="37"){
            isBill="团体";
        }

        int cp = 0;
        if (currentPage==""||currentPage==null){
            currentPage="1";
        }
        cp = Integer.parseInt(currentPage);

//        页面需要的列表设置
        Page<StayRegisterDetails> srpage = stayRegisterService.findPartStayRegister(isBill, txtname, cp, lvkeleixing);

        List<Downorder> listOne = downorderMapperService.getAttributeByfar_id(24);

//      加入model
        model.addAttribute("txtname",txtname);
        model.addAttribute("list",srpage);

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
    public String arrangeroom(ArrangeRoom arrangeRoom) throws ParseException {


//        `srId` int(11) NOT NULL AUTO_INCREMENT,
//  `predetermineId` int(11) DEFAULT NULL,
//  `passengerName` varchar(128) DEFAULT NULL,
//  `changingRoomNumber` int(11) DEFAULT NULL,
//  `changRoomMoney` float DEFAULT NULL,
//  `changRoomTime` datetime DEFAULT NULL,
//  `registerTime` datetime DEFAULT NULL,
//  `sumConst` float DEFAULT NULL,
//  `isBill` varchar(32) DEFAULT NULL,
//  `lvkeleixing` varchar(128) DEFAULT NULL,
//        

        stayRegisterService.addStayRegisterByArrangeRoom(arrangeRoom);


        return "/StayRegister/tolist.do";
    }

//  显示各类房间列表
    @RequestMapping(path = "StayRegister/guestRoomLevelSelectRoom")
    @ResponseBody
    public  List<Room> guestRoomLevelSelectRoom(@RequestBody String guestRoomLevelID, HttpServletResponse response) throws IOException {

        String[] split = guestRoomLevelID.split("=");
        String levelId = split[1];
        List<Room> roomByRoomLevel = roomService.getRoomByRoomLevel(levelId);

        return roomByRoomLevel;
    }
}
