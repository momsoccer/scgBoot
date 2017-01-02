package com.scg.event;

import com.scg.datadto.PagingDTO;
import com.scg.persistence.EventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/event/")
public class EventRestController {

    private static final Logger logger = LoggerFactory.getLogger(EventRestController.class);

    @Autowired
    EventMapper eventMapper;

    //json 형태는 스트링으로 넘어오기 때문에 넘버 타입으로 받을 때는 형변환을 해준다.
    @RequestMapping(value="getEventMainList", method= RequestMethod.GET)
    public List<EventMain> getEventMainList(){

        PagingDTO pagingDTO = new PagingDTO();
        pagingDTO.setPageSize(100);
        pagingDTO.setStartRowNum(0);

        return eventMapper.getList(pagingDTO);
    }

}
