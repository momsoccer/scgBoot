package com.scg.api.commonlookup;

import com.scg.api.common.FcmTokenService;
import com.scg.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sungbo on 2016-06-02.
 * 미션카테고리와 미션 타입을 변경 할 수 있는 웹 페이지 컨트롤러
 */

@Controller
@RequestMapping("/admin/")
public class WebLookupController {

    private static final Logger logger = LoggerFactory.getLogger(WebLookupController.class);

    @Autowired
    private FcmTokenService fcmTokenService;

    @Autowired
    LookupService lookupService;

    @RequestMapping(value="lookup")
    public String lookupMain(){
        return "/admin/lookup";
    }

    @RequestMapping(value="caterory")
    public String lookUpMainPate(Model model){
        MissionCategory missionCategory = new MissionCategory();
        List<MissionCategory> categoryList = lookupService.getMissionCategoryList(missionCategory);
        model.addAttribute("MissionCategoryList", categoryList);
        return "/admin/caterory";
    }

    @RequestMapping(value = "categorycreate")
    public String categorycreate(@ModelAttribute("category") MissionCategory category){
        lookupService.createMissionCategory(category);
        return "redirect:" +"/admin/caterory";
    }

    @RequestMapping(value = "categorydelete")
    public String categorydelete(@RequestParam("categoryid") int categoryid){
        lookupService.deleteMissionCategory(categoryid);
        return "redirect:" +"/admin/caterory";
    }

    @RequestMapping(value = "type")
    public String type(Model model){

        MissionType type = new MissionType();

        List<MissionType> typelist = lookupService.getMissionType(type);
        model.addAttribute("type", typelist);
        return "/admin/type";
    }

    @RequestMapping(value = "typecreate")
    public String typecreate(@ModelAttribute("type") MissionType type){
        lookupService.createMissionType(type);
        return "redirect:" +"/admin/type";
    }

    @RequestMapping(value = "typedelete")
    public String typedelete(@RequestParam("typeid") int typeid){
        logger.info("타입을 삭제 합니다");
        lookupService.deleteMissionType(typeid);
        return "redirect:" +"/admin/type";
    }


    @RequestMapping(value = "fileuploadpage")
    public String fileuploadpage(){
        return "/admin/fileuploadpage";
    }

    @RequestMapping("gcmexeucte")
    public String gcmMessage(){

        return "/admin/gcmMessage";
    }

    @RequestMapping(value = "gcmsend", method = RequestMethod.POST)
    public String gcmsend(
            @RequestParam("title") String title,
            @RequestParam("message") String message,
            @RequestParam("content") String content
    ){


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap> result;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "key=AIzaSyAq3dIJEdjsZvydXugP5uPOKnqeLm52UMA");

        try {
            List<FcmToken> list = fcmTokenService.getFcmTokenList(new FcmToken());

            for (FcmToken f : list) {
                Message messageVo = new Message("타이틀","콘텐트","메세지");

                GcmObject gcmObject = new GcmObject(f.getFcmtoken(), messageVo);

                HttpEntity request = new HttpEntity(gcmObject, headers);


                result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);


                if (result.getStatusCode() != HttpStatus.OK)
                    logger.debug("전송 오류 : " + result.getStatusCode().toString());

                /*디버깅
                Map retJson = result.getBody();
                for (Object key : retJson.keySet()) {
                    logger.debug(key + " : " + retJson.get(key).toString());
                }
                */

            }
        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return "redirect:" +"/admin/gcmexeucte";
    }

}
