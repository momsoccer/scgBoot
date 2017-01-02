package com.scg.event;

import com.scg.datadto.PagingDTO;
import com.scg.persistence.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-11-24.
 */

@Service
public class EventService {

    @Autowired
    EventMapper eventMapper;

    public void saveEvent(EventMain enventMain){
        eventMapper.saveEvent(enventMain);
    };

    public void saveEvent(Eventrequest eventrequest){
        eventMapper.saveEventReq(eventrequest);
    }

    public List<Eventrequest> getEventReqList(int mainid){
        return eventMapper.getEventReqList(mainid);
    };

    public int getTotalCount(PagingDTO pagingDTO){
        return eventMapper.getTotalCount(pagingDTO);
    }

    public List<EventMain> getList(PagingDTO pagingDTO){
        return eventMapper.getList(pagingDTO);
    }

    public EventMain getEvent(int mainid){
        return eventMapper.getEvent(mainid);
    };

    public List<Eventrequest> getEventRequestList(int mainid){
        return eventMapper.getEventRequestList(mainid);
    }

    public Eventrequest getReqData(Eventrequest eventrequest){

        Eventrequest getevent = null;
        try{
            getevent = eventMapper.getReqData(eventrequest);
        }catch (Exception e){

        }

        if(getevent == null){
            getevent = new Eventrequest();
        }

        return getevent;
    };

    public void deleteReq(Eventrequest eventrequest){
        eventMapper.deleteReq(eventrequest);
    }
}
