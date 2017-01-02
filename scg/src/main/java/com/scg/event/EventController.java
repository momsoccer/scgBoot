package com.scg.event;


import com.scg.api.common.UploadFunction;
import com.scg.datadto.PagingDTO;
import com.scg.persistence.EventMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/event/")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventService eventService;

    @Autowired
    private EventMapper eventMapper;

    @RequestMapping(value = "eventmain")
    public String home(Model model,
                       HttpServletRequest request){


        List<Eventrequest> eventrequestList = eventService.getEventReqList(18);

        model.addAttribute("list",eventrequestList);
        model.addAttribute("userCount",eventrequestList.size());

        return "/event/eventmain";
    }

    @RequestMapping(value = "evententer")
    public String enter(){

        return "/event/evententer";
    }

    @RequestMapping(value = "enter" , method = RequestMethod.POST)
    public String enterEvent(
            HttpServletRequest request
            ,@ModelAttribute("vo") EventMain eventMain,
                             @RequestParam("date") String date
    ){

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 스트링 타입을 => 데이트 타입으로 변경해준다.
            Date parseDate = transFormat.parse(date);
            eventMain.setTime(parseDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String upfileName = eventMain.getFile().getOriginalFilename(); //get file name
        String upfileNam2 = eventMain.getFile2().getOriginalFilename();
        String upfileNam3 = eventMain.getFile3().getOriginalFilename(); //get file name

        if (!eventMain.getFile().isEmpty()) {

            String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/event/";
            eventMain.setImg("http://14.63.220.208:80/resources/event/"+upfileName);

            UploadFunction uploadFunction = new UploadFunction();
            uploadFunction.writeFile(eventMain.getFile(), upfileName, request, rootPath);
        }

        if (!eventMain.getFile2().isEmpty()) {

            String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/event/";
            eventMain.setImg2("http://14.63.220.208:80/resources/event/" + upfileNam2);

            UploadFunction uploadFunction = new UploadFunction();
            uploadFunction.writeFile(eventMain.getFile2(), upfileNam2, request, rootPath);
        }

        if (!eventMain.getFile3().isEmpty()) {

            String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/event/";
            eventMain.setImg3("http://14.63.220.208:80/resources/event/" + upfileNam3);

            UploadFunction uploadFunction = new UploadFunction();
            uploadFunction.writeFile(eventMain.getFile3(), upfileNam3, request, rootPath);
        }


        eventService.saveEvent(eventMain);

        return "redirect:" +"/event/eventlist";
    }

    @RequestMapping(value = "eventmap")
    public String eventMap(){

        return "/event/eventmap";
    }

    @RequestMapping(value = "request", method = RequestMethod.POST)
    public String request(@ModelAttribute("vo") Eventrequest eventrequest){

        eventService.saveEvent(eventrequest);

        return "redirect:" +"/event/eventdetail?mainid="+eventrequest.getMainid();
    }


    @RequestMapping(value = "eventlist")
    public String eventList(Model model,
                            @ModelAttribute("pagingDTO") PagingDTO pagingDTO,
                            @RequestParam(value = "pageNo", required = false) String pageNo
    ){


        pagingDTO.setPageSize(8);
        pagingDTO.setPageNo(1);
        pagingDTO.setBlockSize(8);

        if(StringUtils.isNotEmpty(pageNo)){
            pagingDTO.setPageNo(Integer.parseInt(pageNo));
        }

        pagingDTO.setTotalCount(eventService.getTotalCount(pagingDTO));
        model.addAttribute("mainlist", eventService.getList(pagingDTO));

        model.addAttribute("paging", pagingDTO);
        return "/event/eventlist";
    }

    @RequestMapping(value = "eventdetail")
    public String getEvent(Model model,
                           @RequestParam(value = "mainid", required = true) int mainId,
                           @RequestParam(value = "deleteflag", required = false, defaultValue = "S") String deleteflag
    ){

        model.addAttribute("eventmain", eventService.getEvent(mainId));
        model.addAttribute("reqlist",eventService.getEventRequestList(mainId));
        model.addAttribute("deleteflag",deleteflag);

        return "/event/eventview";
    }


    @RequestMapping(value = "eventreqdelete", method = RequestMethod.POST)
    public String deleteEventReq(HttpServletRequest request){

        String reqids = request.getParameter("reqid");
        String password = request.getParameter("password");
        String smainid = request.getParameter("smainid");
        int reqid = Integer.valueOf(reqids);
        int mainid = Integer.valueOf(smainid);

        Eventrequest eventrequest = new Eventrequest();
        eventrequest.setReqid(reqid);
        eventrequest.setPassword(password);

        eventrequest = eventService.getReqData(eventrequest);

        if(eventrequest.getMainid()==mainid){
            //삭제할 수 있다 비번이 맞음
            eventService.deleteReq(eventrequest);
            return "redirect:" +"/event/eventdetail?mainid="+mainid+"&deleteflag=Y";
        }else{
            //데이터가 없다
            return "redirect:" +"/event/eventdetail?mainid="+mainid+"&deleteflag=N";
        }
    }

    @RequestMapping(value = "eventcomment")
    public String commentList(Model model
            ,@RequestParam("mainid") int mainid
            ,@RequestParam(value = "flag",required = false,defaultValue = "S") String flag
    ) {
        model.addAttribute("list",eventMapper.getBoardList(mainid));
        model.addAttribute("mainid",mainid);
        model.addAttribute("flag",flag);
        return "/event/eventcomment";
    }

    @RequestMapping(value = "commentinsert")
    public String insert(Model model, @ModelAttribute("vo") EventBoardVo vo){

        logger.info(vo.toString());

        eventMapper.EventBoardSave(vo);

        return "redirect:" +"/event/eventcomment?mainid="+vo.getMainid()+"&flag="+"I";
    }

}
