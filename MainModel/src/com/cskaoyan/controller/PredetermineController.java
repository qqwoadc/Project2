package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PredetermineController {

    @RequestMapping(path = "Predetermine/tolist" ,method ={RequestMethod.GET,RequestMethod.POST})
    public String roomsetToList(){

        return "/WEB-INF/jsp/predetermine/list.jsp";
    }
}
