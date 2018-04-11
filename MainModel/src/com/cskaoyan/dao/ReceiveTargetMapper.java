package com.cskaoyan.dao;

import com.cskaoyan.bean.ReceiveTarget;

public interface ReceiveTargetMapper {
    /*
    * 添加对象团体
    * */
    int addReceiveTarget(ReceiveTarget receiveTarget);

    /*
    * 模糊查找对象团体
    * */
    public ReceiveTarget findRtByTeamName(String teamName);

    /*
    * 修改对象团体
    * */
    public int updateRtByTeamCode(ReceiveTarget receiveTarget);

    /*
    * 删除对象团体
    * */
    public ReceiveTarget deleteRtByTeamCode(String teamCode);


}
