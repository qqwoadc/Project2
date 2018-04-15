package com.cskaoyan.controller;
import com.cskaoyan.bean.Passenger;
import com.cskaoyan.service.PassengerService;
import com.cskaoyan.utils.Downorder;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.PassengerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@Controller
public class PassengerController {
    @Autowired
    PassengerService passengerService;


    //旅客信息首页-自动搜索/手动搜索
    @RequestMapping("/Passenger/tolist.do")
    public String tolistPassenger(String txtname, Integer currentPage, Model model) {
        ArrayList<Passenger> passengers;//旅客
        if (currentPage == null) {
            currentPage = 1;
        }
        //总页数
        int totalPage;
        //每页有几条数据
        int limit = 2;
        //每页的起始记录是第几条记录
        int offset;
        //总的旅客
        double totalPassenger;
        //判断是否搜索
        if (txtname == null || txtname.isEmpty()) {
            //当没有进行搜索，则显示所有的记录
            //计算offset
            offset = (currentPage - 1) * limit;
            //使用包装类
            PassengerVO passengerVO = new PassengerVO(limit, offset);
            //所有的旅客
            passengers = passengerService.selectPassengersList(passengerVO);
            //旅客总数
            totalPassenger = passengerService.countAllPassenger();
            //总页数
            totalPage = (int) Math.ceil(totalPassenger / limit);
            Page<Passenger> passengerPage = new Page<>();
            //传入总页数
            passengerPage.setTotalPage(totalPage);
            //传入所有的旅客
            passengerPage.setResult(passengers);
            //传入当前页
            passengerPage.setCurrentPage(currentPage);
            //放入域对象
            model.addAttribute("list", passengerPage);
            return "/WEB-INF/jsp/passenger/list.jsp";
        } else {
            offset = (currentPage - 1) * limit;
            //产生包装类
            PassengerVO passengerVO1 = new PassengerVO(limit, offset);
            passengerVO1.setName("%" + txtname + "%");
            passengerVO1.setLimit(limit);
            passengerVO1.setOffset(offset);
            passengers = passengerService.findPassengerByName(passengerVO1);
            //求出符合条件的人的个数
            totalPassenger = passengerService.countAllPassengerByName("%" + txtname + "%");
            //求出页面总数
            totalPage = (int) Math.ceil(totalPassenger / limit);
            //把所求的信息放到page中
            Page<Passenger> passengerPage1 = new Page<>();
            passengerPage1.setCurrentPage(currentPage);
            passengerPage1.setTotalPage(totalPage);
            passengerPage1.setResult(passengers);
            model.addAttribute("list", passengerPage1);
            model.addAttribute("txtname", txtname);
            return "/WEB-INF/jsp/passenger/list.jsp";
        }
    }

    //实现下拉框
    @RequestMapping("/Passenger/toadd.do")
    public String addDownList(Model model) {


/*        mav1.addAttribute("listGender", passengerDownOrdersService.findGender());
        mav1.addAttribute("listNation", passengerDownOrdersService.findNation());
        mav1.addAttribute("listEducationDegree", passengerDownOrdersService.findCultureLevel());
        mav1.addAttribute("listPassengerLevel", passengerDownOrdersService.findPassengerLevel());
        mav1.addAttribute("listPapers", passengerDownOrdersService.findLicenseCategory());
        mav1.addAttribute("listThingReason", passengerDownOrdersService.findReason());
        modelAndView.setViewName("/WEB-INF/jsp/passenger/add.jsp");
        return modelAndView;*/

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

        model.addAttribute("listGender", listGender);
        model.addAttribute("listNation", listNation);
        model.addAttribute("listEducationDegree", listEducationDegree);
        model.addAttribute("listPassengerLevel", listPassengerLevel);
        model.addAttribute("listPapers", listPapers);
        model.addAttribute("listThingReason", listThingReason);


        return "/WEB-INF/jsp/passenger/add.jsp";

    }


    //把数据插入表中
    @RequestMapping("/Passenger/add.do")
    public String add(Passenger passenger) throws ServletException, IOException, ServletException, IOException {


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

        //添加passenger
        passengerService.addPassenger(passenger);

        return "/Passenger/tolist.do";
    }


    //实现修改页面的下拉框
    @RequestMapping("/Passenger/toupdate.do")
    public String updateDownList(String id, Model model) {


//        mav2.addAttribute("listGender", passengerDownOrdersService.findGender());
//        mav2.addAttribute("listNation", passengerDownOrdersService.findNation());
//        mav2.addAttribute("listEducationDegree", passengerDownOrdersService.findCultureLevel());
//        mav2.addAttribute("listPassengerLevel", passengerDownOrdersService.findPassengerLevel());
//        mav2.addAttribute("listPapers", passengerDownOrdersService.findLicenseCategory());
//        mav2.addAttribute("listThingReason", passengerDownOrdersService.findReason());
//        Passenger passengerById = passengerService.findPassengerById(Integer.parseInt(id));
//        //借助map把修改前的信息放在修改页面
//        HashMap<String, String> list = new HashMap<>();
//        list.put("name",passengerById.getName());
//        //String.valueOf(passengerById.getId())中的passengerById.getId()是int型，此方法把int型转化为String型
//        list.put("id",String.valueOf(passengerById.getId()));
//        //添上会报500
//        //list.put("genderID",passengerById.getGenderName());
//        //list.put("nationID",passengerById.getNationName());
//        //list.put("educationDegreeID",passengerById.getEducationDegreeID());
//        //list.put("passengerLevelID",passengerById.getPassengerLevelName());
//        //list.put("papersID",passengerById.getPapersName());
//        //list.put("thingReasonID",passengerById.getThingReasonID());
//        list.put("name",passengerById.getName());
//        list.put("birthDate",passengerById.getBirthDate());
//        list.put("papersValidity",passengerById.getPapersValidity());
//        list.put("profession",passengerById.getProfession());
//        list.put("papersNumber",passengerById.getPapersNumber());
//        list.put("unitsOrAddress",passengerById.getUnitsOrAddress());
//        list.put("whereAreFrom",passengerById.getWhereAreFrom());
//        list.put("whereToGo",passengerById.getWhereToGo());
//        list.put("contactPhoneNumber",passengerById.getContactPhoneNumber());
//        list.put("remarks",passengerById.getRemarks());
//        mav2.addAttribute("list",list);
//        modelAndView.setViewName("/WEB-INF/jsp/passenger/update.jsp?id="+id);
//        return modelAndView;

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

        //查出需要回显的passenger对象
        Passenger passenger = passengerService.findPassengerById(Integer.parseInt(id));

        //放入值
        model.addAttribute("list",passenger);
        model.addAttribute("listGender", listGender);
        model.addAttribute("listNation", listNation);
        model.addAttribute("listEducationDegree", listEducationDegree);
        model.addAttribute("listPassengerLevel", listPassengerLevel);
        model.addAttribute("listPapers", listPapers);
        model.addAttribute("listThingReason", listThingReason);


        return"/WEB-INF/jsp/passenger/update.jsp";
    }


    //点击修改页面-修改按钮
    @RequestMapping("/Passenger/update")
    public String updateInformation(Passenger passenger, Model model) throws ServletException, IOException {
//        //未修改前的信息放在add.jsp上
//        modelAndView.addObject("list", passengerService.findPassengerById(passenger.getId()));
//        modelAndView.setViewName("/WEB-INF/jsp/passenger/update.jsp");
//        return modelAndView
/*        Passenger passengerById = passengerService.findPassengerById(Integer.parseInt(id));
        //更新
        passengerById.setName(request.getParameter("name"));
        passengerById.setBirthDate(request.getParameter("birthDate"));
        passengerById.setPapersValidity(request.getParameter("papersValidity"));
        passengerById.setProfession(request.getParameter("profession"));
        passengerById.setPapersNumber(request.getParameter("papersNumber"));
        passengerById.setUnitsOrAddress(request.getParameter("unitsOrAddress"));
        passengerById.setWhereAreFrom(request.getParameter("whereAreFrom"));
        passengerById.setWhereToGo(request.getParameter("whereToGo"));
        passengerById.setContactPhoneNumber(request.getParameter("contactPhoneNumber"));
        passengerById.setRemarks(request.getParameter("remarks"));
        passengerById.setGenderName(request.getParameter("genderID"));
        passengerById.setNationName(request.getParameter("nationID"));
        passengerById.setEducationDegreeID(request.getParameter("educationDegreeID"));
        passengerById.setPassengerLevelName(request.getParameter("passengerLevelID"));
        passengerById.setPapersName(request.getParameter("papersID"));
        passengerById.setThingReasonID(request.getParameter("thingReasonID"));
        int i = Integer.parseInt(id);
        int log = passengerService.updatePassenger(passengerById);
        System.out.println(passengerById);*/

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


        //根据id更新 passenger
        int log = passengerService.updatePassenger(passenger);



        //更新后跳转到tolist.do页面
        return "/Passenger/tolist.do";
    }

    @RequestMapping("/Passenger/delete.do")
    public void deletePassenger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //删除得到的id参数是
        String ids = request.getParameter("id");

        String[] split = ids.split(",");

        for (String id : split) {

            //根据id删除
            passengerService.deletePassengerById(Integer.parseInt(id));
        }
        request.getRequestDispatcher("tolist.do").forward(request, response);
    }
}