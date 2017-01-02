package com.scg.persistence;

import com.scg.datadto.InsPointBalance;
import com.scg.ins.vo.InsApplyVo;

import java.util.List;

/**
 * Created by sungbo on 2016-08-11.
 */
public interface InsMapper {

    public void saveIns(InsApplyVo insApply);
    public void updateIns(InsApplyVo insApply);
    public void delete(InsApplyVo insApply);
    public List<InsApplyVo> getListIns(InsApplyVo insApply);
    public InsApplyVo getIns(InsApplyVo insApply);


    //강사수입내역
    public List<InsPointBalance> getInsPointBalanceList(int insid);

}
