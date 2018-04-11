package com.cskaoyan.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AdminController {



    @RequestMapping(path = "Login/tologin",method ={RequestMethod.GET,RequestMethod.POST})
    public String tologin(){

        return "/WEB-INF/jsp/login/login.jsp";
    }


    @RequestMapping(path = "/Login/tomain",method ={RequestMethod.GET,RequestMethod.POST})
    public String tomain( ){

        return "/WEB-INF/jsp/main/main.jsp";
    }

}
