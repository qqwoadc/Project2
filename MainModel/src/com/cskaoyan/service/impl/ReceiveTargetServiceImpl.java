package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.dao.ReceiveTargetMapper;
import com.cskaoyan.service.ReceiveTargetService;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.ReceiveTargetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveTargetServiceImpl implements ReceiveTargetService {

    @Autowired
    ReceiveTargetMapper dao;

    @Override
    public List<ReceiveTarget> findAllRt(ReceiveTargetVO receiveTargetVO) {
        return dao.findAllRt(receiveTargetVO);
    }

    @Override
    public int addReceiveTarget(ReceiveTarget receiveTarget) {
        return dao.addReceiveTarget(receiveTarget);
    }

    @Override
    public List<ReceiveTarget> findRtBlur(ReceiveTargetVO receiveTargetVO) {
        return dao.findRtBlur(receiveTargetVO);
    }

    @Override
    public int updateByPrimaryKeySelective(ReceiveTarget receiveTarget) {
        return dao.updateByPrimaryKeySelective(receiveTarget);
    }

    @Override
    public Integer deleteReceiveTargetByIds(int[] id) {

        return dao.deleteReceiveTargetByIds(id);

    }

    @Override
    public int deleteReceiveTargetById(int id){
        return dao.deleteReceiveTargetById(id);
    }
    @Override
    public ReceiveTarget findReceiveTargetById(int id) {
        return dao.findReceiveTargetById(id);
    }

    @Override
    public int findReceiveTargetCount() {
        return dao.findReceiveTargetCount();
    }

    @Override
    public int findReceiveTargetPartCount(String txtname) {
        return dao.findReceiveTargetPartCount(txtname);
    }

    /*
     * 全部分页
     * */
    @Override
    public Page<ReceiveTarget> allReceiveTargetPage(int currentPage, double limit){

        int offset = (int) ((currentPage - 1) * limit);//求出偏移量;

        int receiveTargetCount = dao.findReceiveTargetCount();//得到总的房间-数量

        double totalPageDB = receiveTargetCount / limit;//求出总页数

        int totalPage = (int) Math.ceil(totalPageDB);//向上取整

        ReceiveTargetVO targetVO = new ReceiveTargetVO((int) limit,offset);

        //查出所有的房间-列表对象(分页查需要传入-偏移量-根据传入的页面计算)
        List<ReceiveTarget> receiveTargets = dao.findAllRt(targetVO);

        Page<ReceiveTarget> receiveTargetPage = new Page<>();

        receiveTargetPage.setTotalPage(totalPage);//传入总页数

        receiveTargetPage.setResult(receiveTargets);//传入列表对象

        receiveTargetPage.setCurrentPage(currentPage);//传入当前页数

        return receiveTargetPage;
    }

    /*
     * 模糊查询分页
     * */
    @Override
    public Page<ReceiveTarget> searchPartPage(String txtname, int currentPage, double limit) {

        int offset = (int) ((currentPage - 1) * limit);     //求出偏移量;
        int receiveTargetCount = dao.findReceiveTargetCount(); //得到总的房间-数量
        double totalPageDB = receiveTargetCount / limit;       //求出总页数
        int totalPage = (int) Math.ceil(totalPageDB);        //向上取整

        ReceiveTargetVO targetVO = new ReceiveTargetVO((int) limit,offset); //产生包装类
//        targetVO.setTextName("%"+txtname+"%");
        targetVO.setLimit((int) limit);
        targetVO.setOffset(offset);
        targetVO.setTeamName("%"+txtname+"%");
        targetVO.setTeamCode("%"+txtname+"%");
        targetVO.setPrincipal("%"+txtname+"%");
        targetVO.setContactPhoneNUmber("%"+txtname+"%");
        

        List<ReceiveTarget> receiveTargets = dao.findRtBlur(targetVO);//查数据库,查出链表
        Page<ReceiveTarget> targetPage = new Page<>(); //把所求出的信息放入page类中

        targetPage.setCurrentPage(currentPage);
        targetPage.setTotalPage(totalPage);
        targetPage.setResult(receiveTargets);

        return targetPage;
    }


}
