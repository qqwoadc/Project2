package com.cskaoyan.service;

import com.cskaoyan.utils.Downorder;

import java.util.List;

public interface DownorderMapperService {

    public String getAttributeDetailsNameById(int id);
    public List<Downorder> getAttributeByfar_id(int far_id);
}
