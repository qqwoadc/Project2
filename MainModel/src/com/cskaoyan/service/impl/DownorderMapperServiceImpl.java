package com.cskaoyan.service.impl;

import com.cskaoyan.dao.DownorderMapper;
import com.cskaoyan.service.DownorderMapperService;
import com.cskaoyan.utils.Downorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownorderMapperServiceImpl implements DownorderMapperService {

    @Autowired
    DownorderMapper dao;

    @Override
    public String getAttributeDetailsNameById(int id) {
        return dao.getAttributeDetailsNameById(id);
    }

    @Override
    public List<Downorder> getAttributeByfar_id(int far_id) {
        return dao.getAttributeByfar_id(far_id);
    }
}
