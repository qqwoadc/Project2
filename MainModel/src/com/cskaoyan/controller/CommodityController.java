package com.cskaoyan.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommodityController {


    @RequestMapping(path = "Commodity/tolist",method ={RequestMethod.GET,RequestMethod.POST})
    public String commodityToList(){

        return "/WEB-INF/jsp/commodity/list.jsp";
    }


    @RequestMapping(path = "Commodity/toadd",method ={RequestMethod.GET,RequestMethod.POST})
    public String commodityToAdd( ){


        return "/WEB-INF/jsp/commodity/add.jsp";
    }



    @RequestMapping(path = "Commodity/add",method ={RequestMethod.GET,RequestMethod.POST})
    public String commodityAdd(  ){

        return "/WEB-INF/jsp/commodity/list.jsp";
    }
}
