package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.DownorderMapperService;
import com.cskaoyan.service.RegisterService;
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
import java.util.ArrayList;
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

//    张宇江自用service
    @Autowired
    RegisterService registerService;

//    列表显示
    @RequestMapping(path = "/StayRegister/tolist",method ={RequestMethod.GET,RequestMethod.POST})
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

    @RequestMapping(path = "StayRegister/register.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String register(Integer id, Passenger passenger, Integer lvKeID, Integer LvKeLeiXingId, Integer stayRegisterId) {

//一种是自己输入数据-旅客信息必须插入数据库-然后再
// 然后把passenger表中-passengerName属性放入stayregister表passengerName属性中


        System.out.println(stayRegisterId);

        System.out.println(passenger);

        if (lvKeID == null) {

            //插入passenger表中
            switch (passenger.getGenderID()) {

                case "1":
                    passenger.setGenderName("女");
                    break;
                case "31":
                    passenger.setGenderName("男");
                    break;

            }


            switch (passenger.getNationID()) {

                case "33":
                    passenger.setNationName("汉");
                    break;
                case "1":
                    passenger.setNationName("苗族");
                    break;
                case "2":
                    passenger.setNationName("壮");
                    break;
                case "3":
                    passenger.setNationName("其他");
                    break;


            }

            switch (passenger.getPassengerLevelID()) {

                case "52":
                    passenger.setPassengerLevelName("首次");
                    break;
                case "1":
                    passenger.setPassengerLevelName("熟客");
                    break;
                case "2":
                    passenger.setPassengerLevelName("VIP");
                    break;


            }


            switch (passenger.getPapersID()) {

                case "37":
                    passenger.setPapersName("二代身份证");
                    break;
                case "1":
                    passenger.setPapersName("护照");
                    break;
                case "2":
                    passenger.setPapersName("其他");
                    break;

            }

            switch (passenger.getEducationDegreeID()) {

                case "43":
                    passenger.setEducationDegree("高中");
                    break;
                case "1":
                    passenger.setEducationDegree("无");
                    break;
                case "2":
                    passenger.setEducationDegree("小学");
                    break;
                case "3":
                    passenger.setEducationDegree("初中");
                    break;
                case "4":
                    passenger.setEducationDegree("大专");
                    break;
                case "5":
                    passenger.setEducationDegree("本科");
                    break;
                case "6":
                    passenger.setEducationDegree("研究生");
                    break;
                case "7":
                    passenger.setEducationDegree("硕士");
                    break;
                case "8":
                    passenger.setEducationDegree("博士");
                    break;
                case "9":
                    passenger.setEducationDegree("其他");
                    break;
            }

            switch (passenger.getThingReasonID()) {

                case "51":
                    passenger.setThingReason("个人旅行");
                    break;
                case "1":
                    passenger.setThingReason("公务出差");
                    break;
            }


            System.out.println(passenger);


            //再把得到的passenger对象插入数据库中

            int i = registerService.insertSelective(passenger);


            String name = passenger.getName();
            StayRegister sr = new StayRegister();
            sr.setPassengerName(name);
            sr.setSrId(stayRegisterId);
            //再
            stayRegisterService.updateByPrimaryKeySelective(sr);

        } else {

            //不执行插入passenger表中
            //但是根据旅客id-查姓名-再插入到stayregister表-passengerName中

            String name = passenger.getName();

            StayRegister stayRegister = new StayRegister();
            stayRegister.setSrId(stayRegisterId);
            stayRegister.setPassengerName(name);
            //根据stayRegisterId找到 对象再插入其中  插入 表中
            stayRegisterService.updateByPrimaryKeySelective(stayRegister);

        }


        //一种是ajx后台查询的数据-旅客信息必须插入数据库(判断是否存在根据隐藏的旅客id)
        // 然后把passenger表中-passengerName属性放入stayregister表passengerName属性中


        return "/StayRegister/tolist.do";
    }

    //散客页面-勾选房间-再点击登记按钮(根据传来的id值-在登记页面回显房间号-填充下拉栏)
    @RequestMapping(path = "StayRegister/toregister.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toRegister(Integer id, String roomNumber, Integer LvKeLeiXingId, Model model) {


        System.out.println(id);//选择的数据的id-srid---绑定stayRegister  (放入一个隐藏的) value="${stayRegisterId} 中
        System.out.println(roomNumber);//房间号-get传过来的
        System.out.println(LvKeLeiXingId);//旅客类型-作为一个隐藏的属性 value="${LvKeLeiXingId}


        ArrayList<Downorder> listGender = new ArrayList<>();//性别下拉菜单 默认-男31
        Downorder Gender = new Downorder(31, "男");
        Downorder Gender1 = new Downorder(1, "女");
        listGender.add(Gender);
        listGender.add(Gender1);


        ArrayList<Downorder> listNation = new ArrayList<>();//民族下拉菜单 默认-汉33
        Downorder Nation = new Downorder(33, "汉");
        Downorder Nation1 = new Downorder(1, "苗");
        Downorder Nation2 = new Downorder(2, "壮");
        Downorder Nation3 = new Downorder(3, "其他");
        listNation.add(Nation);
        listNation.add(Nation1);
        listNation.add(Nation2);
        listNation.add(Nation3);

        ArrayList<Downorder> listEducationDegree = new ArrayList<>();//文化程度 默认-高中-43
        Downorder EducationDegree = new Downorder(43, "高中");
        Downorder EducationDegree1 = new Downorder(1, "无");
        Downorder EducationDegree2 = new Downorder(2, "小学");
        Downorder EducationDegree3 = new Downorder(3, "初中");
        Downorder EducationDegree4 = new Downorder(4, "大专");
        Downorder EducationDegree5 = new Downorder(5, "本科");
        Downorder EducationDegree6 = new Downorder(6, "研究生");
        Downorder EducationDegree7 = new Downorder(7, "硕士");
        Downorder EducationDegree8 = new Downorder(8, "博士");
        Downorder EducationDegree9 = new Downorder(9, "其他");
        listEducationDegree.add(EducationDegree);
        listEducationDegree.add(EducationDegree1);
        listEducationDegree.add(EducationDegree2);
        listEducationDegree.add(EducationDegree3);
        listEducationDegree.add(EducationDegree4);
        listEducationDegree.add(EducationDegree5);
        listEducationDegree.add(EducationDegree6);
        listEducationDegree.add(EducationDegree7);
        listEducationDegree.add(EducationDegree8);
        listEducationDegree.add(EducationDegree9);

        ArrayList<Downorder> listPassengerLevel = new ArrayList<>();//旅客级别 默认-首次-52
        Downorder PassengerLevel = new Downorder(52, "首次");
        Downorder PassengerLevel1 = new Downorder(1, "熟客");
        Downorder PassengerLevel2 = new Downorder(2, "VIP");
        listPassengerLevel.add(PassengerLevel);
        listPassengerLevel.add(PassengerLevel1);
        listPassengerLevel.add(PassengerLevel2);


        ArrayList<Downorder> listPapers = new ArrayList<>();//证件类型  默认-身份证-37
        Downorder Papers = new Downorder(37, "二代身份证");
        Downorder Papers1 = new Downorder(1, "护照");
        Downorder lPapers2 = new Downorder(2, "其他");

        listPapers.add(Papers);
        listPapers.add(Papers1);
        listPapers.add(lPapers2);


        ArrayList<Downorder> listThingReason = new ArrayList<>();//事由  默认-个人旅行-51
        Downorder ThingReason = new Downorder(51, "个人旅行");
        Downorder ThingReason1 = new Downorder(1, "公务出差");

        listThingReason.add(ThingReason);
        listThingReason.add(ThingReason1);

        //放入值
        model.addAttribute("roomNumber", roomNumber);
        model.addAttribute("listGender", listGender);
        model.addAttribute("listNation", listNation);
        model.addAttribute("listEducationDegree", listEducationDegree);
        model.addAttribute("listPassengerLevel", listPassengerLevel);
        model.addAttribute("listPapers", listPapers);
        model.addAttribute("listThingReason", listThingReason);
        model.addAttribute("stayRegisterId",id);

        //转到旅客登记页面
        return "/WEB-INF/jsp/stayregister/register.jsp";
    }

    //选择旅客-异步构建悬浮窗口(刚进去执行全部搜索)
    //选择旅客-搜索按钮异步构建悬浮页面(模糊条件搜索)(有bug前端没有清除搜索数据)
    @RequestMapping(path = "StayRegister/selectPassenger.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ArrayList<Passenger> selectPassenger(String txtname) {


        if (txtname == null || txtname.isEmpty()) {

            //搜素所有-异步返回给页面(不用分页)

            ArrayList<Passenger> allPassenger = registerService.findAllPassenger();


            System.out.println(allPassenger);


            return allPassenger;
        } else {

            //搜索txtname,返回给页面(不用分页)

            ArrayList<Passenger> passengerByName = registerService.findPassengerByName("%" + txtname + "%");

            System.out.println(txtname);

            return passengerByName;

        }

        //返回一个list
    }

    //返回查到的旅客信息-并且填充到jsp页面(也是异步-就没有离开过登记页面)
    @RequestMapping(path = "StayRegister/confirmPassenger.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Passenger confirmPassenger(Integer id) {

        System.out.println(id);

        Passenger passenger = registerService.selectByPrimaryKey(id);

        System.out.println(passenger);

        return passenger;
    }

}
