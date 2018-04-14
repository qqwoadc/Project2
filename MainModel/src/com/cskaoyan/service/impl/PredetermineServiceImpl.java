package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Passenger;
import com.cskaoyan.bean.Predetermine;
import com.cskaoyan.bean.ReceiveTarget;
import com.cskaoyan.bean.Room;
import com.cskaoyan.dao.PassengerMapper;
import com.cskaoyan.dao.PredetermineMapper;
import com.cskaoyan.dao.RoomMapper;
import com.cskaoyan.service.PredetermineService;
import com.cskaoyan.utils.ListOne;
import com.cskaoyan.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredetermineServiceImpl implements PredetermineService {

    @Autowired
    PredetermineMapper dao;

    @Autowired
    RoomMapper roomdao;

    @Autowired
    PassengerMapper passengerdao;


    //查找所有预定信息，返回一个List
    @Override
    public List<Predetermine> findAllPredetermineMSG() {

        return dao.findAllPredetermineMSG();
    }

    //添加一个预定信息
    @Override
    public int addPredetermineMSG(Predetermine predetermine) {
        int rag = dao.addPredetermineMSG(predetermine);
        return rag;
    }

    //修改一个预定信息
    @Override
    public int updatePredetermineMSG(Predetermine predetermine) {
        int rag = dao.updatePredetermineMSG(predetermine);
        return rag;
    }

    //删除一个预定信息
    @Override
    public int deletePredetermineMSG(Predetermine predetermine) {
        int rag = dao.deletePredetermineMSGById(predetermine);
        return rag;
    }

    //返回默认预定页面(未安排)
    @Override
    public Page<Predetermine> findPage1(String currentPage) {

        Page<Predetermine> predeterminePage = new Page<>();

        //查找记录总数 totalMSGNum为记录总数
        int totalMSGNum = dao.findTotalMSGNum1();

        //计算并设置总页数
        int i = totalMSGNum / predeterminePage.DEFAULT_IETMS;
        int totalPage = totalMSGNum % predeterminePage.DEFAULT_IETMS == 0 ? i : i + 1;
        predeterminePage.setTotalPage(totalPage);

        //设置当前页面
        int currentPageNum;
        if (currentPage==null){
            currentPageNum = 1;
        }else {
            currentPageNum = Integer.parseInt(currentPage);
        }
        predeterminePage.setCurrentPage(currentPageNum);

        //设置当前页面的数据集合
        List<Predetermine> partPredetermineMSG =
                dao.findPartPredetermineMSG1(predeterminePage.DEFAULT_IETMS, (currentPageNum - 1) * predeterminePage.DEFAULT_IETMS);

        predeterminePage.setResult(partPredetermineMSG);

        return predeterminePage;
    }


    //返回符合查询类型的页面
    @Override
    public Page<Predetermine> findPage3(String txtname,String state,String currentPage) {

        //根据state选择MSG
        String MSG;
       // System.out.println("哈哈哈哈哈哈哈哈哈哈哈"+state);
        if (state.equals("1")){
            MSG = "未安排";
        }else {
            MSG = "已安排";
        }

        Page<Predetermine> predeterminePage = new Page<>();

        //查找符合查询条件的记录总数 searchMSGNum为记录总数
        int searchMSGNum = dao.searchMSGNum("%"+txtname+"%",MSG);

        //计算并设置总页数totalPage为总页数
        int i = searchMSGNum / predeterminePage.DEFAULT_IETMS;
        int totalPage = searchMSGNum % predeterminePage.DEFAULT_IETMS == 0 ? i : i + 1;
        predeterminePage.setTotalPage(totalPage);

        //设置当前页面
        int currentPageNum;
        if (currentPage==null){
            currentPageNum = 1;
        }else {
            currentPageNum = Integer.parseInt(currentPage);
        }
        predeterminePage.setCurrentPage(currentPageNum);

        //设置当前页面的数据集合
        List<Predetermine> partPredetermineMSG =
                dao.findPartPredetermineMSG3("%"+txtname+"%",MSG,predeterminePage.DEFAULT_IETMS, (currentPageNum - 1) * predeterminePage.DEFAULT_IETMS);

        predeterminePage.setResult(partPredetermineMSG);

        return predeterminePage;
    }

    //返回按state查询的页面
    @Override
    public Page<Predetermine> findPage2(String currentPage, String state) {

        //根据state选择MSG
        String MSG;
        //System.out.println("哈哈哈哈哈哈哈哈哈哈哈"+state);
        if (state.equals("1")){
            MSG = "未安排";
        }else {
            MSG = "已安排";
        }

        //根据MSG查询页面

        Page<Predetermine> predeterminePage = new Page<>();

        //根据MSG查找记录总数 totalMSGNum为记录总数
        int totalMSGNum = dao.findTotalMSGNum2(MSG);

        //计算并设置总页数
        int i = totalMSGNum / predeterminePage.DEFAULT_IETMS;
        int totalPage = totalMSGNum % predeterminePage.DEFAULT_IETMS == 0 ? i : i + 1;
        predeterminePage.setTotalPage(totalPage);

        //设置当前页面
        int currentPageNum;
        if (currentPage==null){
            currentPageNum = 1;
        }else {
            currentPageNum = Integer.parseInt(currentPage);
        }
        predeterminePage.setCurrentPage(currentPageNum);

        //设置当前页面的数据集合
        List<Predetermine> partPredetermineMSG =
                dao.findPartPredetermineMSG2(MSG,predeterminePage.DEFAULT_IETMS, (currentPageNum - 1) * predeterminePage.DEFAULT_IETMS);

        predeterminePage.setResult(partPredetermineMSG);

        return predeterminePage;

    }

    //安排下拉菜单
    @Override
    public List<ListOne> findListOne() {

        ListOne op1 = new ListOne("1","未安排");
        ListOne op2 = new ListOne("2","已安排");
        List<ListOne> listOnes = new ArrayList<>();
        listOnes.add(op1);
        listOnes.add(op2);
        return listOnes;
    }

    //支付方式下拉菜单
    @Override
    public List<ListOne> findListPay() {

        ListOne op1 = new ListOne("1", "现金");
        ListOne op2 = new ListOne("2", "转账");
        ListOne op3 = new ListOne("3", "支付宝");
        List<ListOne> listOnes = new ArrayList<>();
        listOnes.add(op1);
        listOnes.add(op2);
        listOnes.add(op3);
        return listOnes;
    }


    //查找团队默认页面
    @Override
    public List<ReceiveTarget> findAllTeamTarget() {

        List<ReceiveTarget> allTeamTarget = dao.findAllTeamTarget();

        return allTeamTarget;
    }

    //根据txtname查找团队信息
    @Override
    public List<ReceiveTarget> findTeamTargetByName(String txtname) {

        List<ReceiveTarget> teamTargetByName = dao.findTeamTargetByName("%" + txtname + "%");
        return teamTargetByName;
    }


    //查找所有旅客信息
    @Override
    public List<Passenger> findAllPassenger() {

        List<Passenger> allPassenger = dao.findAllPassenger();

        return allPassenger;
    }

    //根据txtname查找旅客信息
    @Override
    public List<Passenger> findPassengerByName(String txtname) {

        List<Passenger> passengerByName = dao.findPassengerByName("%" + txtname + "%");

        return passengerByName;
    }

    //根据选择的ID查找旅客信息
    @Override
    public Passenger findPassengerById(int id) {

        Passenger passengerById = dao.findPassengerById(id);

        return passengerById;
    }

    //选择所有可用房间
    @Override
    public List<Room> findAllAvailableRoom() {

        List<Room> allAvailableRoom = dao.findAllAvailableRoom();

        return allAvailableRoom;
    }

    //根据roomNUMBER选择房间
    @Override
    public List<Room> findRoomByNumber(String roomNumber) {

        List<Room> roomByNumber = dao.findRoomByNumber(roomNumber);
        return roomByNumber;
    }

    //根据roomid查找roomNumber
    @Override
    public Room findRoomById(int roomId) {
        Room roomById = dao.findRoomById(roomId);
        return roomById;
    }

    //根据房间ID修改房间状态
    @Override
    public int updateRoomById(int roomId) {
        int id = dao.updateRoomById(roomId);
        return id;
    }

    //根据id查找接待对象
    @Override
    public ReceiveTarget findTeamById(int id) {
        ReceiveTarget teamById = dao.findTeamById(id);
        return teamById;
    }


}
