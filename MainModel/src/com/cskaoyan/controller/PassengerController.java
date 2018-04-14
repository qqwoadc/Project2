package com.cskaoyan.controller;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.service.PassengerDownOrdersService;
import com.cskaoyan.service.PassengerService;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.PassengerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    @Autowired
    PassengerDownOrdersService passengerDownOrdersService;

    @RequestMapping("Passenger/tolist.do")
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
            totalPassenger = passengerService.coutAllPassengerByName("%"+txtname+"%");
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
    @RequestMapping("Passenger/toadd.do")
    public ModelAndView addDownList(ModelAndView modelAndView,Model mav1) {
        mav1.addAttribute("listGender", passengerDownOrdersService.findGender());
        mav1.addAttribute("listNation", passengerDownOrdersService.findNation());
        mav1.addAttribute("listEducationDegree", passengerDownOrdersService.findCultureLevel());
        mav1.addAttribute("listPassengerLevel", passengerDownOrdersService.findPassengerLevel());
        mav1.addAttribute("listPapers", passengerDownOrdersService.findLicenseCategory());
        mav1.addAttribute("listThingReason", passengerDownOrdersService.findReason());
        modelAndView.setViewName("/WEB-INF/jsp/passenger/add.jsp");
        return modelAndView;
    }

    @RequestMapping("Passenger/add.do")
    public void add(Passenger passenger, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        passenger.setGenderName(request.getParameter("genderID"));
        passenger.setNationName(request.getParameter("nationID"));
        passenger.setEducationDegreeID(request.getParameter("educationDegreeID"));
        passenger.setPassengerLevelName(request.getParameter("passengerLevelID"));
        passenger.setPapersName(request.getParameter("papersID"));
        passenger.setThingReasonID( request.getParameter("thingReasonID"));
        passengerService.addPassenger(passenger);
        request.getRequestDispatcher("tolist.do").forward(request, response);
    }
    //实现修改页面的下拉框
    @RequestMapping("Passenger/toupdate.do")
    public ModelAndView updateDownList(ModelAndView modelAndView,Model mav2,String id,HttpServletRequest request) {
        mav2.addAttribute("listGender", passengerDownOrdersService.findGender());
        mav2.addAttribute("listNation", passengerDownOrdersService.findNation());
        mav2.addAttribute("listEducationDegree", passengerDownOrdersService.findCultureLevel());
        mav2.addAttribute("listPassengerLevel", passengerDownOrdersService.findPassengerLevel());
        mav2.addAttribute("listPapers", passengerDownOrdersService.findLicenseCategory());
        mav2.addAttribute("listThingReason", passengerDownOrdersService.findReason());
        Passenger passengerById = passengerService.findPassengerById(Integer.parseInt(id));
        //借助map把修改前的信息放在修改页面
        HashMap<String, String> list = new HashMap<>();
        list.put("name",passengerById.getName());
        //String.valueOf(passengerById.getId())中的passengerById.getId()是int型，此方法把int型转化为String型
        list.put("id",String.valueOf(passengerById.getId()));
        //添上会报500
        //list.put("genderID",passengerById.getGenderName());
        //list.put("nationID",passengerById.getNationName());
        //list.put("educationDegreeID",passengerById.getEducationDegreeID());
        //list.put("passengerLevelID",passengerById.getPassengerLevelName());
        //list.put("papersID",passengerById.getPapersName());
        //list.put("thingReasonID",passengerById.getThingReasonID());
        list.put("name",passengerById.getName());
        list.put("birthDate",passengerById.getBirthDate());
        list.put("papersValidity",passengerById.getPapersValidity());
        list.put("profession",passengerById.getProfession());
        list.put("papersNumber",passengerById.getPapersNumber());
        list.put("unitsOrAddress",passengerById.getUnitsOrAddress());
        list.put("whereAreFrom",passengerById.getWhereAreFrom());
        list.put("whereToGo",passengerById.getWhereToGo());
        list.put("contactPhoneNumber",passengerById.getContactPhoneNumber());
        list.put("remarks",passengerById.getRemarks());
        mav2.addAttribute("list",list);
        modelAndView.setViewName("/WEB-INF/jsp/passenger/update.jsp?id="+id);
        return modelAndView;
    }

    @RequestMapping("Passenger/update")
    public void updateInformation(String id, HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
//        //未修改前的信息放在add.jsp上
//        modelAndView.addObject("list", passengerService.findPassengerById(passenger.getId()));
//        modelAndView.setViewName("/WEB-INF/jsp/passenger/update.jsp");
//        return modelAndView
        Passenger passengerById = passengerService.findPassengerById(Integer.parseInt(id));
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
        passengerById.setThingReasonID( request.getParameter("thingReasonID"));
        int i = Integer.parseInt(id);
        int log = passengerService.updatePassenger(passengerById);
        System.out.println(passengerById);
        //更新后跳转到tolist.do页面

        request.getRequestDispatcher("tolist.do").forward(request, response);
    }

    @RequestMapping("Passenger/delete.do")
    public void deletePassenger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //删除得到的id参数是
        String ids = request.getParameter("id");

        String[] split = ids.split(",");

        for (String id : split) {
            passengerService.deletePassengerById(Integer.parseInt(id));
        }
        request.getRequestDispatcher("tolist.do").forward(request, response);
    }
}