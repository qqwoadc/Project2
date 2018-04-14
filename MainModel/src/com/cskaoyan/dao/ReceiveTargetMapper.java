package com.cskaoyan.dao;

import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.utils.ReceiveTargetVO;

import java.util.List;

public interface ReceiveTargetMapper {
    /*
    * 添加对象团体
    * */
    int addReceiveTarget(ReceiveTarget receiveTarget);

    /*
     * 查找所有登记对象
     * */
    List<ReceiveTarget> findAllRt(ReceiveTargetVO receiveTargetVO);

    /*
    * 模糊查找对象团体
    * */
    List<ReceiveTarget> findRtBlur(ReceiveTargetVO receiveTargetVO);

    /*
    * 修改对象团体
    * */
    int updateByPrimaryKeySelective(ReceiveTarget receiveTarget);

    /*
     * 删除单个对象团体
     * */
    int deleteReceiveTargetById(int id);

    /*
    * 批量删除对象团体
    * */
    Integer deleteReceiveTargetByIds(int[] id);

    /*
    * id值查找接待对象
    * */
    ReceiveTarget findReceiveTargetById(int id);

    /*
    * 查找对象总数
    * */
    int findReceiveTargetCount();

    /*
    * 根据条件查找的数量
    * */
    int findReceiveTargetPartCount(String txtname);
}
