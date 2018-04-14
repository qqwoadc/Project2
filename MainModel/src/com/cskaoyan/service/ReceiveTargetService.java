package com.cskaoyan.service;

import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.ReceiveTargetVO;

import java.util.List;

public interface ReceiveTargetService {

    /*
     * 显示所有登记对象
     * */
    List<ReceiveTarget> findAllRt(ReceiveTargetVO receiveTargetVO);

    /*
     * 增加对象团体
     * */
    int addReceiveTarget(ReceiveTarget receiveTarget);

    /*
     * 模糊查找对象团体
     * */
    List<ReceiveTarget> findRtBlur(ReceiveTargetVO receiveTargetVO);

    /*
     * 修改对象团体
     * */
    int updateByPrimaryKeySelective(ReceiveTarget receiveTarget);

    /*
     * 删除对象团体
     * */
    Integer deleteReceiveTargetByIds(int[] id);

    int deleteReceiveTargetById(int id);


    /*锁定选中删除的对象*/
    ReceiveTarget findReceiveTargetById(int id);

    /*
    * 所有对象的数量
    * */
    int findReceiveTargetCount();

    /*
    * 条件查询
    * */
    int findReceiveTargetPartCount(String txtname);

    /*分页技术*/
    Page<ReceiveTarget> allReceiveTargetPage(int currentPage, double limit);

    /*模糊查询后分页*/
    Page<ReceiveTarget> searchPartPage(String txtname, int currentPage,double limit);

}
