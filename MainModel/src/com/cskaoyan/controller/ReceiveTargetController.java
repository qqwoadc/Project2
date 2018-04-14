package com.cskaoyan.controller;

import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.bean.ReceiveTargetType;
import com.cskaoyan.service.ReceiveTargetService;
import com.cskaoyan.utils.Page;
import com.sun.scenario.effect.Offset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ReceiveTarget")
public class ReceiveTargetController {

    @Autowired
    ReceiveTargetService service;

    /*
     * 从main页面进入接待对象页面，显示全部的接待对象
     * 与搜索业务整合在一起
     * */
    @RequestMapping(path = "/tolist.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String findReceiveTarget(Model model, String txtname, Integer currentPage) {

        //判断是不是第一次访问,第一次访问没有currentPage
        if (null == currentPage) {
            currentPage = 1;
        }

        //每页显示多少数据
        int limit = 2;

        //判断传入的数据是不是空/空字符串
        if (null == txtname || txtname.isEmpty()) {
            Page<ReceiveTarget> receiveTargetPage = service.allReceiveTargetPage(currentPage, limit);

            model.addAttribute("list", receiveTargetPage);

            return "/WEB-INF/jsp/receivetarget/list.jsp";
        } else {
            limit = 2;

            System.out.println(currentPage);

            Page<ReceiveTarget> receiveTargetPage = service.searchPartPage(txtname,currentPage,limit);

            model.addAttribute("txtname", txtname);
            model.addAttribute("list", receiveTargetPage);

            return "/WEB-INF/jsp/receivetarget/list.jsp";
        }

    }
    @RequestMapping(path = "/toadd.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toAddReceiveTarget(Model model, ReceiveTarget receiveTarget) {

        /*增加对象类型*/

        /*散客和团队*/
        List<ReceiveTargetType> targetTypes = new ArrayList<>();

        ReceiveTargetType team = new ReceiveTargetType(56, "团队");
        ReceiveTargetType single = new ReceiveTargetType(57, "散客");

        /*把2个类型写入到数组中*/
        targetTypes.add(team);
        targetTypes.add(single);

        /*放入Model域中*/
        model.addAttribute("listOne", targetTypes);
        return "/WEB-INF/jsp/receivetarget/add.jsp";
    }

    /*
     * 业务二：增加接待对象
     * */
    @RequestMapping(path = "/add.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String addReceiveTarget(ReceiveTarget receiveTarget) {

        switch (receiveTarget.getTargetTypeID()) {
            case 56:
                receiveTarget.setReceiveTargetTypeName("团队");
                break;
            case 57:
                receiveTarget.setReceiveTargetTypeName("散客");
                break;
        }

        System.out.println(receiveTarget);

        service.addReceiveTarget(receiveTarget);

        return "/ReceiveTarget/tolist.do";
    }

    /*
     * 业务三：修改下拉框的对象类型
     * */
    @RequestMapping(path = "/toupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String toUpdateReceiveTarget(Model model, int id) {
        /*散客和团队*/
        List<ReceiveTargetType> targetTypes = new ArrayList<>();

        ReceiveTargetType team = new ReceiveTargetType(56, "团队");
        ReceiveTargetType single = new ReceiveTargetType(57, "散客");

        /*把2个类型写入到数组中*/
        targetTypes.add(team);
        targetTypes.add(single);

        /*回显*/
        ReceiveTarget receiveTargetById = service.findReceiveTargetById(id);
        model.addAttribute("listOne", targetTypes);
        model.addAttribute("list", receiveTargetById);

        return "/WEB-INF/jsp/receivetarget/update.jsp";
    }

    /*业务三：修改接待对象*/
    @RequestMapping(path = "/update.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateReceiveTarget(ReceiveTarget receiveTarget) {

        switch (receiveTarget.getTargetTypeID()) {
            case 56:
                receiveTarget.setReceiveTargetTypeName("团队");
            case 57:
                receiveTarget.setReceiveTargetTypeName("散客");
        }

        service.updateByPrimaryKeySelective(receiveTarget);

        return "/ReceiveTarget/tolist.do";
    }

    /*
     * 业务四：删除对象
     * */
    @RequestMapping(path = "/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteReceiveTarget(int[] id) {


        System.out.println(id);

        Integer  i = service.deleteReceiveTargetByIds(id);

         /*int i = service.deleteReceiveTargetById(id);*/
        System.out.println("-------------------------------------------------"+i);

        return "/ReceiveTarget/tolist.do";
    }
}
