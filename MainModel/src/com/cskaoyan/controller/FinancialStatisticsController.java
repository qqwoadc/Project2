package com.cskaoyan.controller;

import com.cskaoyan.bean.Consumption;
import com.cskaoyan.bean.Deposit;
import com.cskaoyan.bean.FinancialstatisticsVO;
import com.cskaoyan.bean.Financialstatisticsparticular;
import com.cskaoyan.service.FinancialstatisticsService;
import com.cskaoyan.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FinancialStatisticsController {

    @Autowired
    FinancialstatisticsService service;

    @RequestMapping(path = "FinancialStatistics/tolist" ,method ={RequestMethod.GET,RequestMethod.POST})
    public String roomsetToList(Model model,String datemin, String datemax, String currentPage){


        int chuZuFangJianShu = service.getchuZuFangJianShu();
        float JieZhangJinE = service.getJieZhangJinE();
        float xiaoFeiJinE = service.getxiaoFeiJinE();
        int zhuSuRenShu = service.getzhuSuRenShu();
        Page<FinancialstatisticsVO> list = service.findFinancialstatisticsByPayTime(datemin, datemax, currentPage);

        model.addAttribute("chuZuFangJianShu",chuZuFangJianShu);
        model.addAttribute("jieZhangJinE",JieZhangJinE);
        model.addAttribute("xiaoFeiJinE",xiaoFeiJinE);
        model.addAttribute("zhuSuRenShu",zhuSuRenShu);
        model.addAttribute("list",list);

        return "/WEB-INF/jsp/financialstatistics/financialstatistics.jsp";
    }

    @RequestMapping(path = "FinancialStatistics/toinformation")
    public String particularInformation(Model model,Integer id){


//        这些方法都需要传入id
        Financialstatisticsparticular particularInformation = service.getFinancialstatisticsparticular(id);
        List<Consumption> consumption = service.getConsumption(id);
        List<Deposit> deposit = service.getDeposit(id);

        ArrayList<Financialstatisticsparticular> list = new ArrayList<>();
        list.add(particularInformation);

        model.addAttribute("listDeposit",deposit);
        model.addAttribute("listXiaoFei",consumption);
        model.addAttribute("list",list);

        return "/WEB-INF/jsp/financialstatistics/particulars.jsp";
    }

}
