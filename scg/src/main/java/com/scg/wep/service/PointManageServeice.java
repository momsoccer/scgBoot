package com.scg.wep.service;

import com.scg.model.PointManagement;
import com.scg.persistence.PointManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungbo on 2016-08-11.
 */
@Service
public class PointManageServeice {

    @Autowired
    PointManageMapper pointManageMapper;

    public void savePointManager(PointManagement pointManagement){
        pointManageMapper.savePointManager(pointManagement);
    };

}
