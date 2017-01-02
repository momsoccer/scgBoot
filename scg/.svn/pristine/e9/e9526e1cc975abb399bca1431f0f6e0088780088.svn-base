package com.scg.persistence;

import com.scg.datadto.PagingDTO;
import com.scg.event.EventBoardVo;
import com.scg.event.EventMain;
import com.scg.event.Eventrequest;

import java.util.List;

/**
 * Created by sungbo on 2016-09-19.
 */
public interface EventMapper {

    public void saveEvent(EventMain enventMain);
    public List<EventMain> getEventMainList();
    public EventMain getEventMain();


    public void saveEventReq(Eventrequest eventrequest);
    public List<Eventrequest> getEventReqList(int mainid);
    public void deleteReq(int reqid);



    public int getTotalCount(PagingDTO pagingDTO);

    public List<EventMain> getList(PagingDTO pagingDTO);
    public EventMain getEvent(int mainid);

    public List<Eventrequest> getEventRequestList(int mainid);

    public Eventrequest getReqData(Eventrequest eventrequest);

    public void deleteReq(Eventrequest eventrequest);


    public List<EventBoardVo> getBoardList(int mainid);
    public void EventBoardSave(EventBoardVo vo);
}
