package com.scg.test.api;

import com.scg.api.user.UserService;
import com.scg.model.Juso;
import com.scg.model.JusoResult;
import com.scg.model.User;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by KIMU on 2016. 6. 29..
 */
@RestController
@RequestMapping("/android/")
public class JusoController {
    protected Logger logger = Logger.getLogger(this.getClass());

    /**
     * 정부 신주소 검색 서비스 연동
     * 유저한테 신주소와 구주소를 선택할 수 있는 리스트를 리턴함
     *
     * @param addr
     * @return
     */
    @RequestMapping(value = "searchJuso", method = RequestMethod.GET)
    public List<Juso> searchJuso(@RequestParam(name = "addr") String addr) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JusoResult> result = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<Juso> jusoList = null;

        try {

            result = restTemplate.getForEntity("http://www.juso.go.kr/addrlink/addrLinkApi.do?"
                    + "currentPage=1&"
                    + "countPerPage=10&"
                    //호스트당 정부 주소 검색 서비스 인증키 발급 필요
                    + "confmKey=U01TX0FVVEgyMDE2MDcxMjAxMzk0NjEzNzIx&"
                    + "keyword=" + addr, JusoResult.class);

            if (result.getStatusCode() != HttpStatus.OK)
                logger.debug("전송 오류 : " + result.getStatusCode().toString());

            //디버그 하는 용도
            jusoList = result.getBody().getJuso();
            for (Juso j : jusoList) {
                logger.debug(j.getJibunAddr());
            }


        } catch (Exception e) {

            logger.error(e.getMessage());

        }


        return jusoList;
    }

    /**
     * 유저 저장시에 주소에 대한 처리를 따로 만듬. 디비스키마 변경 및 유저세이브 로직과 코드병합 필요
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "jusoSave", method = RequestMethod.POST)
    public String jusoSave(@RequestBody User user) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JusoResult> result = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<Juso> jusoList = null;

        try {

            //네이버 아이피에 대한 인증키 필요
            headers.add("X-Naver-Client-Id", "BLnsH9AnFRv32ALT5L_U");
            headers.add("X-Naver-Client-Secret", "oqBusE3mON");
            HttpEntity request = new HttpEntity(null, headers);

            result = restTemplate.exchange("https://openapi.naver.com/v1/map/geocode?" +
                            "encoding=utf-8&" +
                            "coord=latlng&" +
                            "output=json&" +
                            "query=" + user.getLocation(),//주소검색 결과값 저장한 값 다른 멤버 변수로 선언해야함
                    HttpMethod.GET, request, JusoResult.class);

            logger.debug(result.getBody().toString());

            jusoList = result.getBody().getJuso();
            for (Juso j : jusoList) {

                logger.debug(j.getPoint().getX() + j.getPoint().getY());

             /*   user.setLattitude(j.getPoint().getX());
                user.setLongitude(j.getPoint().getY());
                user.setDetailAddr();
              */
            }

            //유저 세이브 로직
            /*
            UserService userService = new UserService();
            userService.saveUser(user);
            */
            //주소저장
            /*
            JusoService jusoService = new JusoService();
            //없는 주소를 저장한다. 추후에 데이터가 쌓이면 검색 기능을 덧붙여 오픈아이피의 의존도를 낮춘다
            //경도와 위도에 대한 위치에 대한 한글 주소를 저장하여 조회할때 사용한다
            jusoService.JusoSave(jusoList);
            */

        } catch (Exception e) {

            logger.error(e.getMessage());

        }


        return "success";
    }
}
