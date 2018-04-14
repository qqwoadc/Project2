package com.cskaoyan.controller;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.bean.Predetermine;
import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.bean.Room;
import com.cskaoyan.service.PassengerService;
import com.cskaoyan.service.PredetermineService;
import com.cskaoyan.service.RoomService;
import com.cskaoyan.utils.ListOne;
import com.cskaoyan.utils.MyDateConverter;
import com.cskaoyan.utils.Page;
import com.sun.deploy.net.HttpResponse;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.annotations.Param;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class PredetermineController {


    @Autowired
    PredetermineService predetermineService;

    //返回所有符合页面要求的预定信息，默认返回所有预定信息
    @RequestMapping(path = "Predetermine/tolist.do" ,method ={RequestMethod.GET,RequestMethod.POST})
    public String toList(String txtname, String state, String currentPage, Model model){

        //状态下拉菜单
        List<ListOne> listOne = predetermineService.findListOne();
        model.addAttribute("listOne",listOne);


        if (state==null||state.isEmpty()){
            //默认页面（未安排）
            Page<Predetermine> page = predetermineService.findPage1(currentPage);

            model.addAttribute("list", page);

            return "/WEB-INF/jsp/predetermine/list.jsp";

        }else {

            if (txtname==null||txtname.isEmpty()){

                //非默认页面，根据state查询
                Page<Predetermine> page = predetermineService.findPage2(currentPage,state);

                model.addAttribute("list", page);
                model.addAttribute("state",state);
                return "/WEB-INF/jsp/predetermine/list.jsp";

            }else {

                //根据查询结果返回所需页面
                Page<Predetermine> page = predetermineService.findPage3(txtname, state, currentPage);

                model.addAttribute("list", page);
                model.addAttribute("state",state);
                model.addAttribute("txtname",txtname);
                return "/WEB-INF/jsp/predetermine/list.jsp";
            }
        }

    }

    @RequestMapping(path = "Predetermine/selectTarget.do" ,method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<ReceiveTarget> selectTarget(HttpServletRequest request, HttpServletResponse response){


        String txtname = request.getParameter("txtname");

        System.out.println();
        System.out.println(txtname);
        System.out.println();

        //查找默认团队页面
        if (txtname==null||txtname.isEmpty()){

            System.out.println("hehehe");
            List<ReceiveTarget> allTeamTarget = predetermineService.findAllTeamTarget();

            return allTeamTarget;
        }else {

            System.out.println("hahah");
            //按txtname查找团队页面
            List<ReceiveTarget> teamTargetByName = predetermineService.findTeamTargetByName(txtname);

            return teamTargetByName;
        }

    }

    @RequestMapping(path = "Predetermine/selectPassenger.do",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<Passenger> selectPassenger (HttpServletRequest request,HttpServletResponse response){

        String txtname = request.getParameter("txtname");

        //查找所有旅客信息
        if (txtname==null||txtname.isEmpty()){

            System.out.println("hehehe");

            List<Passenger> allPassenger = predetermineService.findAllPassenger();

            return allPassenger;

        }else {
            System.out.println();
            System.out.println(txtname);
            System.out.println();
            System.out.println("hahah");

            //按txtname查找旅客信息
            List<Passenger> passengerByName = predetermineService.findPassengerByName(txtname);

            return passengerByName;
        }
    }

    @RequestMapping(path = "Predetermine/confirmPassenger.do",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Passenger confirmPassenger(HttpServletRequest request,HttpServletResponse response){

        int id = Integer.parseInt(request.getParameter("id"));

        Passenger passengerById = predetermineService.findPassengerById(id);

        return passengerById;
    }


    @RequestMapping(path = "Predetermine/toadd.do" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String toadd(HttpServletRequest request,HttpServletResponse response,Model model){

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String type = request.getParameter("type");

        //团队或旅客姓名
        model.addAttribute("name",name);
        //团队或旅客ID
        model.addAttribute("id",id);
        //区分团队或旅客的id即passengerId
        model.addAttribute("type",type);

        //支付方式下拉菜单
        List<ListOne> listPay = predetermineService.findListPay();
        model.addAttribute("listOne",listPay);

        return "/WEB-INF/jsp/predetermine/add.jsp";
    }

    @RequestMapping(path = "Predetermine/selectRoom.do",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<Room> selectRoom(HttpServletRequest request,HttpServletResponse response){

        String roomNumber = request.getParameter("roomNumber");

        if (roomNumber==null||roomNumber.isEmpty()){
            //默认房间选择页面，显示所有可用房间
            List<Room> allAvailableRoom = predetermineService.findAllAvailableRoom();

            return allAvailableRoom;
        }else {
            //根据txtname选择房间
            List<Room> roomByNumber = predetermineService.findRoomByNumber(roomNumber);

            return roomByNumber;
        }

    }

    @RequestMapping(path = "Predetermine/add.do",method = {RequestMethod.GET,RequestMethod.POST})
    public void addPredetermine(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        //向数据库中添加预定信息
        //选中对象的id
        int id = Integer.parseInt(request.getParameter("id"));
        //passengerI区分团队和旅客
        int passengerId = Integer.parseInt(request.getParameter("type"));
        //房间id用于查找房间
        String[] roomIdShuZu = request.getParameter("roomIdShuZu").split(",");
        //总共需添加的信息个数
        int length = roomIdShuZu.length;

        //得到公用的属性
        String arriveTimeString = request.getParameter("arriveTime");

        MyDateConverter myDateConverter = new MyDateConverter();
        Date arriveTime = myDateConverter.convert(arriveTimeString);

        String deposite = request.getParameter("deposite");

        int predetermineDay = Integer.parseInt(request.getParameter("predetermineDay"));

        //团队名称或旅客姓名
        String commodityName = request.getParameter("commodityName");



        //根据passengerId判断输入类型
        if(passengerId==1){
            //预定信息为散客类型
            //需要向数据库中传入的数据有
            // passengerId;
            // roomNumber;
            // guestRoomLevelName;
            // arriveTime;
            // deposite;
            // predetermineDay;
            // predetermineStateName;
            // 不加remind;
            // receiveTargetTypeName;
            // passengerName;
            // passengerContactPhoneNumber

            //根据信息个数添加
            for (int i = 0; i < length; i++ ){
                Predetermine predetermine = new Predetermine();
                //设置passengerId
                predetermine.setPassengerId(id);

                //设置roomNumber
                int roomId = Integer.parseInt(roomIdShuZu[i]);
                Room roomById = predetermineService.findRoomById(roomId);
                String roomNumber = roomById.getRoomNumber();
                predetermine.setRoomNumber(roomNumber);

                //设置guestRoomLevelName
                String guestRoomLevelName = roomById.getGuestRoomLevelName();
                predetermine.setGuestRoomLevelName(guestRoomLevelName);

                //设置arriveTime
                predetermine.setArriveTime(arriveTime);

                //设置deposite
                predetermine.setDeposit(Float.valueOf(deposite));

                //设置predetermineDay
                predetermine.setPredetermineDay(predetermineDay);

                //设置predetermineStateName
                predetermine.setPredetermineStateName("未安排");

                //设置receiveTargetTypeName
                predetermine.setReceiveTargetTypeName("散客");

                //设置passengerName
                predetermine.setPassengerName(commodityName);

                //设置passengerContactPhoneNumber
                Passenger passengerById = predetermineService.findPassengerById(id);
                String contactPhoneNumber = passengerById.getContactPhoneNumber();
                predetermine.setPassengerContactPhoneNumber(contactPhoneNumber);

                //将信息加入到数据库
                int i1 = predetermineService.addPredetermineMSG(predetermine);
                System.out.println(i1);

                //将预定的房间设置为预定状态
                predetermineService.updateRoomById(roomId);

                //跳转到list页面
                request.getRequestDispatcher("/Predetermine/tolist.do").forward(request,response);
            }

        }else if (passengerId==0){
            //预定信息为团队类型
            //需要向数据库中传入的数据有
            // passengerId = 0;
            // roomNumber;
            // guestRoomLevelName;
            // arriveTime;
            // deposite;
            // predetermineDay;
            // predetermineStateName;
            // 不加remind;
            // teamId;
            // receiveTeamName
            // receivePrincipal;
            // receiveContactPhoneNumber
            for (int i = 0; i < length; i++){

                Predetermine predetermine = new Predetermine();
                //设置passengerId
                predetermine.setPassengerId(0);

                //设置roomNumber
                int roomId = Integer.parseInt(roomIdShuZu[i]);
                Room roomById = predetermineService.findRoomById(roomId);
                String roomNumber = roomById.getRoomNumber();
                predetermine.setRoomNumber(roomNumber);

                //设置guestRoomLevelName
                String guestRoomLevelName = roomById.getGuestRoomLevelName();
                predetermine.setGuestRoomLevelName(guestRoomLevelName);

                //设置arriveTime
                predetermine.setArriveTime(arriveTime);

                //设置deposite
                predetermine.setDeposit(Float.valueOf(deposite));

                //设置predetermineDay
                predetermine.setPredetermineDay(predetermineDay);

                //设置predetermineStateName
                predetermine.setPredetermineStateName("未安排");

                //设置teamId
                predetermine.setTeamId(id);

                //设置receiveTeamName
                ReceiveTarget teamById = predetermineService.findTeamById(id);
                String teamName = teamById.getTeamName();
                predetermine.setReceiveTeamName(teamName);

                //设置receivePrincipal;
                String principal = teamById.getPrincipal();
                predetermine.setReceivePrincipal(principal);

                //receiveContactPhoneNumber
                String contactPhoneNUmber = teamById.getContactPhoneNUmber();
                predetermine.setReceiveContactPhoneNumber(contactPhoneNUmber);

                //将信息加入到数据库
                int i1 = predetermineService.addPredetermineMSG(predetermine);
                System.out.println(i1);

                //将预定的房间设置为预定状态
                predetermineService.updateRoomById(roomId);

                //跳转到list页面
                request.getRequestDispatcher("/Predetermine/tolist.do").forward(request,response);
            }
        }else {
            response.getWriter().println("输入有误");
        }
    }

    @RequestMapping(path = "Predetermine/toupdate.do",method = {RequestMethod.GET,RequestMethod.POST})
    public String toupdate(HttpServletRequest request,HttpServletResponse response){


        return "/WEB-INF/jsp/predetermine/update.jsp";
    }
}
