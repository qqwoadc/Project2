package com.cskaoyan.dao;

import com.cskaoyan.utils.Downorder;

import java.util.List;

public interface DownorderMapper {

    public String getAttributeDetailsNameById(int id);
    public List<Downorder> getAttributeByfar_id(int far_id);

}
