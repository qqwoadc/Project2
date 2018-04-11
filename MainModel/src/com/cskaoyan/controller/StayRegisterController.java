package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StayRegisterController {

    @RequestMapping(path = "StayRegister/tolist",method ={RequestMethod.GET,RequestMethod.POST})
    public String roomsetToList(){

        return "/WEB-INF/jsp/stayregister/list.jsp";
    }
}
