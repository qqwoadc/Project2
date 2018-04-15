package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
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
import java.util.Map;

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
        int type = Integer.parseInt(request.getParameter("type"));
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
        if(type==1){
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

        }else if (type==0){
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
    public String toupdate(HttpServletRequest request,HttpServletResponse response,Model model){

        String predetermineId = request.getParameter("id");

        //支付方式下拉菜单
        List<ListOne> listPay = predetermineService.findListPay();
        model.addAttribute("listOne",listPay);


        //根据Id查找预订信息
        Predetermine predeterMSGById = predetermineService.findPredeterMSGById(predetermineId);

        //根据passengerId判断是团队还是旅客
        int passengerId = predeterMSGById.getPassengerId();

        if (passengerId==0){
            //为团队

            //回写predetermineId
            model.addAttribute("predetermineId",predetermineId);

            //回写id
            model.addAttribute("id",passengerId);

            //回写type
            model.addAttribute("type","0");

            //回写接待对象名称
            String receiveTeamName = predeterMSGById.getReceiveTeamName();
            model.addAttribute("name",receiveTeamName);

            //回写预定天数
            int predetermineDay = predeterMSGById.getPredetermineDay();
            model.addAttribute("predetermineDay",predetermineDay);

            //回写押金
            Float deposit = predeterMSGById.getDeposit();

            System.out.println();
            System.out.println(deposit);
            System.out.println();
            model.addAttribute("zhengShu",deposit);

            //回写抵达时间
            Date arriveTime = predeterMSGById.getArriveTime();
            model.addAttribute("arriveTime",arriveTime);

            //回写房间表格
            String roomNumber = predeterMSGById.getRoomNumber();
            Room roomByNumber = predetermineService.findRoomByNumber2(roomNumber);
            model.addAttribute("roomSetPolist",roomByNumber);

            //回写roomNumber
            model.addAttribute("roomNumberyuan",roomNumber);

            //回写teamId
            int teamId = predeterMSGById.getTeamId();
            model.addAttribute("teamId",teamId);

        }else {
            //为散客
            //回写predetermineId
            model.addAttribute("predetermineId",predetermineId);

            //回写id
            model.addAttribute("id",passengerId);

            //回写type
            model.addAttribute("type","1");

            //回写接待对象名称
            String passengerName = predeterMSGById.getPassengerName();
            model.addAttribute("name", passengerName);

            //回写预定天数
            int predetermineDay = predeterMSGById.getPredetermineDay();
            model.addAttribute("predetermineDay",predetermineDay);

            //回写押金
            Float deposit = predeterMSGById.getDeposit();
            model.addAttribute("zhengShu",deposit);

            //回写抵达时间
            Date arriveTime = predeterMSGById.getArriveTime();
            model.addAttribute("arriveTime",arriveTime);

            //回写房间表格
            String roomNumber = predeterMSGById.getRoomNumber();
            Room roomByNumber = predetermineService.findRoomByNumber2(roomNumber);
            model.addAttribute("roomSetPolist",roomByNumber);

            //回写roomNumber
            model.addAttribute("roomNumberyuan",roomNumber);
        }

        return "/WEB-INF/jsp/predetermine/update.jsp";
    }

    @RequestMapping(path = "Predetermine/update.do",method = {RequestMethod.GET,RequestMethod.POST})
    public void update(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //修改数据库中的数据

        //选中predetermineId
        System.out.println();
        System.out.println(request.getParameter("predetermineId"));
        System.out.println("哈哈");
        int predetermineId = Integer.parseInt(request.getParameter("predetermineId"));

        //选中对象的id
        int id = Integer.parseInt(request.getParameter("id"));

        System.out.println();
        System.out.println(id);
        System.out.println("呵呵呵呵");
        //passengerI区分团队和旅客
        int type = Integer.parseInt(request.getParameter("type"));

        System.out.println();
        System.out.println(type);
        System.out.println("呵呵");

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

        //得到修改前的roomNumber
        String roomNumberyuan = request.getParameter("roomNumberyuan");

        //
        String teamTrueId = request.getParameter("teamTrueId");


        //根据passengerId判断输入类型
        if(type==1){

            //根据信息个数添加
            for (int i = 0; i < length; i++ ){
                Predetermine predetermine = new Predetermine();
                //设置predetermineID
                predetermine.setPredetermineId(predetermineId);
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
                System.out.println();
                System.out.println(id);
                System.out.println();
                String contactPhoneNumber = passengerById.getContactPhoneNumber();
                predetermine.setPassengerContactPhoneNumber(contactPhoneNumber);

                //将信息加入到数据库
                int i1 = predetermineService.updatePredetermineMSG(predetermine);
                System.out.println(i1);

                //将预定的房间设置为预定状态
                predetermineService.updateRoomById(roomId);

                //判断房间是否发生了更改

                System.out.println();
                System.out.println(roomNumberyuan);
                System.out.println("roomNumber1");
                System.out.println();
                System.out.println(roomNumber);
                System.out.println("roomNumber");
                if(!roomNumberyuan.equals(roomNumber)){
                    //房间发生更改，将原房间状态变为空房间
                    predetermineService.updateRoomByNumber(roomNumberyuan);

                }

                //跳转到list页面
                request.getRequestDispatcher("/Predetermine/tolist.do").forward(request,response);
            }

        }else if (type==0){

            for (int i = 0; i < length; i++){

                Predetermine predetermine = new Predetermine();
                //设置predetermineID
                predetermine.setPredetermineId(predetermineId);
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
                predetermine.setTeamId(Integer.parseInt(teamTrueId));

                //设置receiveTeamName
                ReceiveTarget teamById = predetermineService.findTeamById(Integer.parseInt(teamTrueId));
                String teamName = teamById.getTeamName();
                predetermine.setReceiveTeamName(teamName);

                //设置receivePrincipal;
                String principal = teamById.getPrincipal();
                predetermine.setReceivePrincipal(principal);

                //receiveContactPhoneNumber
                String contactPhoneNUmber = teamById.getContactPhoneNUmber();
                predetermine.setReceiveContactPhoneNumber(contactPhoneNUmber);

                //将信息加入到数据库
                int i1 = predetermineService.updatePredetermineMSG(predetermine);
                System.out.println(i1);

                //判断房间是否发生了更改
                if(!roomNumberyuan.equals(roomNumber)){
                    //房间发生更改，将原房间状态变为空房间
                    predetermineService.updateRoomByNumber(roomNumberyuan);

                }

                //将预定的房间设置为预定状态
                predetermineService.updateRoomById(roomId);


                //跳转到list页面
                request.getRequestDispatcher("/Predetermine/tolist.do").forward(request,response);
            }
        }else {
            response.getWriter().println("输入有误");
        }
    }

    //删除功能
    @RequestMapping(path = "Predetermine/delete.do",method = {RequestMethod.GET,RequestMethod.POST})
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String predetermineId = request.getParameter("id");

        Predetermine predeterMSGById = predetermineService.findPredeterMSGById(predetermineId);

        String predetermineStateName = predeterMSGById.getPredetermineStateName();

        String roomNumber = predeterMSGById.getRoomNumber();


        int i = predetermineService.deletePredetermineMSG(predeterMSGById);

        if ("未安排".equals(predetermineStateName)){
            //将房间设为空房间
            predetermineService.updateRoomByNumber(roomNumber);
        }
        request.getRequestDispatcher("/Predetermine/tolist.do").forward(request,response);
    }

    @RequestMapping(path = "/Predetermine/arrangeRoom.do",method = {RequestMethod.GET,RequestMethod.POST})
    public void arrangeRoom(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String predetermineId = request.getParameter("id");

        Predetermine predeterMSGById = predetermineService.findPredeterMSGById(predetermineId);

        //更新predetermine状态
        predetermineService.updatePredetermineStateById(predetermineId);
        //安排房间，将信息添加进住宿登记表
        if (predeterMSGById.getPassengerId()!=0){
            //预定信息中的为旅客
            StayRegister stayRegister = new StayRegister();

            String passengerName = predeterMSGById.getPassengerName();
            String receiveTargetTypeName = predeterMSGById.getReceiveTargetTypeName();

            stayRegister.setPredetermineId(Integer.parseInt(predetermineId));
            stayRegister.setPassengerName(passengerName);
            stayRegister.setLvkeleixing(receiveTargetTypeName);

            //添加
            predetermineService.addPredetermineMSGToStayRegister(stayRegister);
        }else {
            //预定信息中为团队

            StayRegister stayRegister = new StayRegister();

            String receivePrincipal = predeterMSGById.getReceivePrincipal();
            String receiveTeamName = predeterMSGById.getReceiveTeamName();

            stayRegister.setPredetermineId(Integer.parseInt(predetermineId));
            stayRegister.setPassengerName(receivePrincipal);
            stayRegister.setLvkeleixing(receiveTeamName);

            //添加
            predetermineService.addPredetermineMSGToStayRegister(stayRegister);

        }

        String tiaoZhuang = request.getParameter("tiaoZhuang");

        //判断是否跳转到住宿登记页面
        if (tiaoZhuang=="1"){
            //跳转到住宿登记页面
            request.getRequestDispatcher("/StayRegister/tolist.do").forward(request,response);


        }else if (tiaoZhuang=="2"){
            //跳转到list页面
            request.getRequestDispatcher("/Predetermine/tolist.do").forward(request,response);

        }

    }
}
