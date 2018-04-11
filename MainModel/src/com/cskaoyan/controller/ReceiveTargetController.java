package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReceiveTargetController {

    @RequestMapping(path = "ReceiveTarget/tolist",method ={RequestMethod.GET,RequestMethod.POST})
    public String roomsetToList(){

        return "/WEB-INF/jsp/receivetarget/list.jsp";
    }
}
