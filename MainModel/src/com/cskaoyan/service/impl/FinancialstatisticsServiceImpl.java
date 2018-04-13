package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.dao.FinancialstatisticsMapper;
import com.cskaoyan.service.FinancialstatisticsService;
import com.cskaoyan.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FinancialstatisticsServiceImpl implements FinancialstatisticsService {

    @Autowired
    FinancialstatisticsMapper dao;


    @Override
    public int addFinancialstatistics(Financialstatistics financialstatistics) {
        return dao.addFinancialstatistics(financialstatistics);
    }

    @Override
    public Page<FinancialstatisticsVO> findFinancialstatisticsByPayTime(String start, String end,String currentPage) {

        //        实现分页
        if (currentPage == null||currentPage==""){
            currentPage = "1";
        }

        int cp = Integer.parseInt(currentPage);

        Page<FinancialstatisticsVO> mypage = new Page<>();

        int limit = Page.DEFAULT_IETMS;
        int offset = (cp-1)*limit;


        int totalItems = dao.getTotalItems();
        int totalPage = (int) Math.ceil(totalItems/limit);

        mypage.setTotalPage(totalPage);
        mypage.setCurrentPage(cp);

        if (start == null||start ==""){
            start = "1970-01-01";
        }

        if (end== null||end ==""){
            end = "2100-01-01";
        }

        List<Financialstatistics> allFinancialstatistics = dao.findFinancialstatisticsByPayTime(start, end,limit,offset);

        List<FinancialstatisticsVO> financialstatisticsVOS = new ArrayList<>();
//        构建jsp界面需要的VO类
        for (Financialstatistics financialstatistic : allFinancialstatistics) {


            FinancialstatisticsVO vo = new FinancialstatisticsVO();

            int stayregisterdetailsId = financialstatistic.getStayregisterdetailsId();
//            查询其他表格，填充数据(调用其他的service方法)


//           加入vo列表
            financialstatisticsVOS.add(vo);
        }

        mypage.setResult(financialstatisticsVOS);
        return mypage;
    }

    @Override
    public int getchuZuFangJianShu() {
        return dao.getTotalItems();
    }

    @Override
    public int getzhuSuRenShu() {

        int[] ints = dao.getzhuSuRenShu();

        int sum = 0;
        for (int anInt : ints) {
            sum = sum+ anInt;
        }

        return sum;
    }

    @Override
    public float getxiaoFeiJinE() {


        float[] floats = dao.getxiaoFeiJinE();
        float sum = 0;
        for (float aFloat : floats) {
            sum = sum + aFloat;
        }
        return sum;
    }

    @Override
    public float getJieZhangJinE() {

        float[] jieZhangJinE = dao.getJieZhangJinE();

        float sum  = 0;

        for (float v : jieZhangJinE) {
            sum= sum+v;
        }

        return sum;
    }

    @Override
    public Financialstatisticsparticular getParticularInformation() {
        return null;
    }

    @Override
    public List<Consumption> getConsumption() {
        return null;
    }

    @Override
    public List<Deposit> getDeposit() {
        return null;
    }


}