package com.cskaoyan.controller;
import com.cskaoyan.bean.Commodity;
import com.cskaoyan.bean.Commoditymeasurement;
import com.cskaoyan.bean.Commoditytype;
import com.cskaoyan.service.CommodityService;
import com.cskaoyan.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

//窄化请求
@RequestMapping("/Commodity")
@Controller
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    //显示界面
    @RequestMapping("/tolist")
    public String commodityToList(Integer currentPage, String txtname, Integer commodityTypeID,Model model){
        if(currentPage==null){
            currentPage = 1;
        }
        if(commodityTypeID==null){
            commodityTypeID = 1;
        }
        Page<Commodity> page = commodityService.findPage(currentPage, txtname, commodityTypeID);
        List<Commoditytype> commoditytype = commodityService.findAllCommoditytype();
        LinkedList<Commoditytype> list = new LinkedList<>();
        for(Commoditytype c : commoditytype){
            if(c.getFar_id().equals(commodityTypeID)){
                list.addFirst(c);
            } else {
                list.addLast(c);
            }
        }
        model.addAttribute("list", page);
        model.addAttribute("listOne", list);
        return "/WEB-INF/jsp/commodity/list.jsp";
    }


    //转发到新增页面
    @RequestMapping("/toadd")
    public String commodityToAdd(Model model){
        List<Commoditytype> commoditytype = commodityService.findAllCommoditytype();
        List<Commoditymeasurement> commoditymeasurement = commodityService.findAllCommoditymeasurement();
        model.addAttribute("listOne",commoditymeasurement);
        model.addAttribute("listTwo",commoditytype);
        return "/WEB-INF/jsp/commodity/add.jsp";
    }


    //新增商品
    @RequestMapping("/add")
    public String commodityAdd(Commodity commodity, Model model){
        commodityService.insertCommodity(commodity);
        return commodityToList(1, "", 1, model);
    }

    //删除商品
    @RequestMapping("/delete")
    public String delete(int id ,Model model){
        commodityService.deleteCommodityById(id);
        return commodityToList(1, "", 1,model);
    }


    //修改界面
    @RequestMapping("/toupdate")
    public String toupdate(int id, Model model){
        List<Commoditytype> commoditytype = commodityService.findAllCommoditytype();
        List<Commoditymeasurement> commoditymeasurement = commodityService.findAllCommoditymeasurement();
        model.addAttribute("listOne",commoditymeasurement);
        model.addAttribute("listTwo",commoditytype);
        Commodity commodity = commodityService.findCommodityById(id);
        model.addAttribute("listPo", commodity);
        return "/WEB-INF/jsp/commodity/update.jsp";
    }


    //修改商品
    @RequestMapping("/update")
    public String update(Commodity commodity, Model model){
        commodityService.updateCommodityById(commodity);
        return commodityToList(1, "", 1, model);
    }


    //新增商品类别
    @RequestMapping("/newadd")
    public String newadd(String txtname, Model model){
        commodityService.insertCommoditytype(txtname);
        return commodityToList(1, "", 1, model);
    }


    //删除商品类别
    @RequestMapping("/newdelete")
    public String newdelete(int id, Model model){
        commodityService.deleteCommoditytypeById(id);
        return commodityToList(1, "", 1, model);
    }
}
