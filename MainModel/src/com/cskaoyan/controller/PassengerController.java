package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PassengerController {
    @RequestMapping(path = "Passenger/tolist",method ={RequestMethod.GET,RequestMethod.POST})
    public String roomsetToList(){

        return "/WEB-INF/jsp/passenger/list.jsp";
    }




    @RequestMapping(path = "Passenger/toadd" ,method ={RequestMethod.GET,RequestMethod.POST})
    public String passengerToAdd( ){

        return "/WEB-INF/jsp/passenger/add.jsp";
    }
}
