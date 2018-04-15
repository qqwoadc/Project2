package com.cskaoyan.dao;

import com.cskaoyan.bean.Financialstatistics;
import com.cskaoyan.bean.Financialstatisticsparticular;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FinancialstatisticsMapper {

    public List<Financialstatistics> findAllFinancialstatistics(@Param("limit")int limit,@Param("offset") int offset);
    public int addFinancialstatistics(Financialstatistics financialstatistics);
    public List<Financialstatistics> findFinancialstatisticsByPayTime(@Param("start") String start, @Param("end") String end,@Param("limit")int limit,@Param("offset") int offset);
    public int getTotalItems();


    public int[] getzhuSuRenShu();
    public float[] getxiaoFeiJinE();
    public float[] getJieZhangJinE();

    public Financialstatisticsparticular getFinancialstatisticsparticular(int stayregisterId);
}
