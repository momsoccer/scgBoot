package com.scg.persistence;

import com.scg.model.Common.Mominfo;

import java.util.List;

/**
 * Created by sungbo on 2016-08-14.
 */
public interface MominfoMapper {

    public List<Mominfo> getMomInfo(String enabled);
}
