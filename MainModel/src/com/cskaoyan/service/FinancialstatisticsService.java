package com.cskaoyan.service;

import com.cskaoyan.bean.*;
import com.cskaoyan.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FinancialstatisticsService {


    public int addFinancialstatistics(Financialstatistics financialstatistics);
    public Page<FinancialstatisticsVO> findFinancialstatisticsByPayTime(String start,String end,String currentPage);

    public int getchuZuFangJianShu();
    public int getzhuSuRenShu();
    public float getxiaoFeiJinE();
    public float getJieZhangJinE();

//    particular页面数据(待完成)
    public Financialstatisticsparticular getParticularInformation();
    public List<Consumption> getConsumption();
    public List<Deposit> getDeposit();


}
