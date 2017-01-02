package com.scg.ins.service;

import com.scg.datadto.InsPointBalance;
import com.scg.ins.vo.InsApplyVo;
import com.scg.persistence.InsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-08-11.
 */
@Service
public class InsService {

    private static final Logger logger = LoggerFactory.getLogger(InsService.class);

    @Autowired
    InsMapper insMapper;

    public void saveIns(InsApplyVo insApply){
        insMapper.saveIns(insApply);
    };
    public void updateIns(InsApplyVo insApply){
        insMapper.updateIns(insApply);
    };
    public List<InsApplyVo> getListIns(InsApplyVo insApply){
        return insMapper.getListIns(insApply);
    };



    public InsApplyVo getIns(InsApplyVo insApply){

        InsApplyVo insApplyVo = null;

        try{
            insApplyVo = insMapper.getIns(insApply);
            logger.info("data check : "+insApply.toString());
        }catch (Exception e){
            e.printStackTrace();
            logger.info("error InsService getins");
        }
        if(insApplyVo == null){
            insApplyVo = new InsApplyVo();
        }

        return insApplyVo;
    };

    public void delete(InsApplyVo insApply){
        insMapper.delete(insApply);
    };

    public List<InsPointBalance> getInsPointBalanceList(int insid){
        return insMapper.getInsPointBalanceList(insid);
    };

}
