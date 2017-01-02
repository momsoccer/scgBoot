package com.scg.api.instructor;

import com.scg.ins.vo.InsInfoVo;
import com.scg.model.Instructor;
import com.scg.model.InstructorPointHistory;
import com.scg.persistence.InsPosintHistoryMapper;
import com.scg.persistence.InstructorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-06-01.
 */
@Service
public class InstructorService {

    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    @Autowired
    private InstructorMapper mapper;

    @Autowired
    private InsPosintHistoryMapper historyMapper;

    public void updateInstructor(Instructor instructor){
        mapper.updateInstructor(instructor);
    }

    public Instructor getInstrutor(Instructor instructor){
        return mapper.getInstrutor(instructor);
    };

    public List<Instructor> getInstrutorList(Instructor instructor){
        return mapper.getInstrutorList(instructor);
    };

    public void savePointHistory(InstructorPointHistory history){

        historyMapper.savePointHistory(history);
    };

    public Instructor getFindIns(int insId){

        Instructor resultIns = null;
        try{
            resultIns = mapper.getFindIns(insId);
        }catch (Exception e){

        }

        if(resultIns == null){
            resultIns = new Instructor();
        }


        return resultIns;
    };


    /*************************
     *
     * 강사 피드백 포인트 설정
     *
     * ************************/
    public int saveInstructor(Instructor instructor){
        int id = 0;
        try{
            id = mapper.saveInstructor(instructor);
            return id;
        }catch (Exception e){
            id = -5;
            logger.info("중복 데이터 발생");
            //e.printStackTrace();
            return id;
        }
    }

    public InstructorPointHistory getPointHis(int insid){
        return historyMapper.getPointHis(insid);
    };

    public List<Instructor> getCoachSearchList(Instructor instructor){
        return mapper.getCoachSearchList(instructor);
    };

    //유저가 강사 팀에게 지원할때 보는 페이지용
    public InsInfoVo getInsInfoApply(int insid){
        return mapper.getInsInfoApply(insid);
    };

}
