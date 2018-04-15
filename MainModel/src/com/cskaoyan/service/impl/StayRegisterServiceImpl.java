package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ArrangeRoom;
import com.cskaoyan.bean.Predetermine;
import com.cskaoyan.bean.StayRegister;
import com.cskaoyan.bean.StayRegisterDetails;
import com.cskaoyan.dao.StayRegisterMapper;
import com.cskaoyan.service.PredetermineService;
import com.cskaoyan.service.StayRegisterService;
import com.cskaoyan.utils.Page;
import com.cskaoyan.utils.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class StayRegisterServiceImpl implements StayRegisterService {

    @Autowired
    StayRegisterMapper dao;

    @Autowired
    PredetermineService predetermineService;

    @Override
    public ArrayList<StayRegister> findAllStayRegister(String isbill) {
        return dao.findAllStayRegister(isbill);
    }

    @Override
    public Page<StayRegisterDetails> findPartStayRegister(String isbill, String txtname, Integer currentPage, String lvkeleixing) {


        if (txtname==null){
            txtname="";
        }

        Page<StayRegisterDetails> srpage = new Page<>();

        int limit = Page.DEFAULT_IETMS;

        int offset = (int) ((currentPage - 1) * limit);//求出偏移量;

        double totalitems = dao.gettotalItems(isbill,lvkeleixing,"%" + txtname + "%");//求出房间总数

        int totalPage = (int) Math.ceil(totalitems / limit);//求出总页数

        ArrayList<StayRegister> partStayRegister = dao.findPartStayRegister(isbill, limit, offset, "%" + txtname + "%", lvkeleixing);

        ArrayList<StayRegisterDetails> result = new ArrayList<>();
//        填充信息
        for (StayRegister stayRegister : partStayRegister) {
            int srId = stayRegister.getSrId();
            StayRegisterDetails allMessage = dao.getAllMessage(srId);

//            填充一些数据库无法获取的信息
            result.add(allMessage);
        }


        srpage.setCurrentPage(currentPage);
        srpage.setResult(result);
        srpage.setTotalPage(totalPage);

        return srpage;
    }


    @Override
    public int updateByPrimaryKeySelective(StayRegister sr) {
        return dao.updateByPrimaryKeySelective(sr);
    }

    @Override
    public int addStayRegister(StayRegister sr) {
        return dao.addStayRegister(sr);
    }

    @Override
    public int addStayRegisterByArrangeRoom(ArrangeRoom arrangeRoom) throws ParseException {

        StayRegister stayRegister = new StayRegister();
        Predetermine predetermine = new Predetermine();
//        时间处理
        String registerTime = arrangeRoom.getRegisterTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(registerTime);

        stayRegister.setRegisterTime(parse);
        //押金
        predetermine.setDeposit(Float.parseFloat(arrangeRoom.getDeposit()));

        //房间号
        predetermine.setRoomNumber(arrangeRoom.getRoomName());
        //房间等级
        String guestRoomLevelName;
        //区分是旅客还是团队的id

        predetermine.setPredetermineStateName("已安排");


        //旅客类型名称
        predetermine.setReceiveTargetTypeName(arrangeRoom.getLvKeLeiXingId());
        //旅客姓名

        int i = predetermineService.addPredetermineMSG(predetermine);

        if (i==1){

            int predetermineId = predetermine.getPredetermineId();
            stayRegister.setPredetermineId(predetermineId);

        }
        return this.addStayRegister(stayRegister);
    }

    @Override
    public StayRegisterDetails getAllMessage(int srId) {
        return dao.getAllMessage(srId);
    }

    @Override
    public int updateByLvkeType(String lvkeleixing, int id) {
        return dao.updateByLvkeType(lvkeleixing,id);
    }
}
