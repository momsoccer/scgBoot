package com.scg.wep.controller;

import com.google.gson.Gson;
import com.scg.api.user.UserService;
import com.scg.event.UserSnsVo;
import com.scg.event.Utils;
import com.scg.model.User;
import com.scg.persistence.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/oauth/")
public class OathController {

    private static final Logger logger = LoggerFactory.getLogger(MomSoccerController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(WebCommon.FACEBOOK_APPID,WebCommon.FACEBOOK_APPSECRET_);
    OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();

    public String getAuthorizeUrl(){

        oAuth2Parameters.setScope(WebCommon.FACEBOOK_SCOPE);
        oAuth2Parameters.setRedirectUri(WebCommon.FACEBOOK_CALLBACK_ADDR);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        String authorizeUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
        return authorizeUrl;
    }


    public boolean setAuthentication(HttpServletRequest request,String useremail, String userpwd,String snstype){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(useremail,userpwd);
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));

        PreludebUserService preludebUserService = new PreludebUserService();
        preludebUserService.setSnstype(snstype);
        preludebUserService.setPwd(userpwd);
        preludebUserService.setUserMapper(userMapper);

        UserDetails userDetails = preludebUserService.loadUserByUsername(useremail);


        if(StringUtils.isEmpty(userDetails.getUsername())){
            return false;
        }else{
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, userpwd, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return true;
        }
    }


    @RequestMapping(value = "/login")
    public String naverLogin(HttpSession session
            ,HttpServletRequest request
            ,HttpServletResponse response
            ,@RequestParam(required = false,value = "snsname") String snsname) {

        if (snsname.equals("kakao")) {

            String state = Utils.generateState();
            session.setAttribute("state", state);

            logger.info("Sesstion.state :" + state);
            logger.info("login 코드 요청 종료 CallBack 기다리는 중");
            logger.info("login 코드 요청 보낸 uri 값은 " + WebCommon.karequestUrl + state);

            return "redirect:" + WebCommon.karequestUrl + state;
        }

        if(snsname.equals("facebook")){

            logger.info("1.페이스북 로그인 요청을 보냅니다");
            try {
                response.sendRedirect(getAuthorizeUrl());
                logger.info("2.페이스북 Call 됨.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(snsname.equals("google")){

            logger.info("구글로 인증 요청을 합니다");

            GoogleConnectionFactory factory = new GoogleConnectionFactory("262443400456-jb3ces65viv3522pbjgk05jrerupqu9s.apps.googleusercontent.com",
                    "yXpuKNhmuCfsR8pDjiSkGG-b");

            OAuth2Parameters auth2Parameters = new OAuth2Parameters();
            auth2Parameters.setScope("https://www.googleapis.com/auth/plus.login");
            auth2Parameters.setRedirectUri("http://www.momsofttest.co.kr:8080/oauth/callback/google");

            OAuth2Operations oauthOperations = factory.getOAuthOperations();
            String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, auth2Parameters);

            logger.info("리다이렉트 페이지 : " + url);

            try {
                response.sendRedirect(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @RequestMapping(value = "/callback/google")
    public String callGoogle(@RequestParam(required = false,value = "code") String code){

        logger.info("구글 인증 페이지로 부터 왔습니다");
        GoogleConnectionFactory factory = new GoogleConnectionFactory(WebCommon.GOOGLE_APPID,WebCommon.GOOGLE_SECRITID);
        OAuth2Parameters auth2Parameters = new OAuth2Parameters();
        auth2Parameters.setScope("https://www.googleapis.com/auth/plus.login");
        auth2Parameters.setRedirectUri("http://www.momsofttest.co.kr:8080/oauth/callback/google");

        OAuth2Operations oauthOperations = factory.getOAuthOperations();
        AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, auth2Parameters.getRedirectUri(), null);
        String accessToken = accessGrant.getAccessToken();
        Long expireTime =  accessGrant.getExpireTime();

        if (expireTime != null && expireTime < System.currentTimeMillis()) {
            accessToken = accessGrant.getRefreshToken();
            logger.info("accessToken is expired. refresh token = {}" , accessToken);
        }

        Connection<Google>connection = factory.createConnection(accessGrant);
        Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();

        PlusOperations plusOperations = google.plusOperations();
        Person person = plusOperations.getGoogleProfile();

        /*
        logger.info("값은 : " + person.getAccountEmail());
        logger.info("값은 : " + person.toString());
        logger.info("값은 : " + person.getImageUrl());
        logger.info("값은 : " + person.getEmailAddresses());
        logger.info("값은 : " + person.getEmails());
        logger.info("값은 : " + person.getUrl());
        logger.info("값은 : " + person.getAboutMe());
        */

        return "/mom/index";
    }


    @RequestMapping(value = "/callback/kakao")
    public String callbackkakao(@RequestParam(required = false,value = "state") String state,
                                @RequestParam(required = false,value = "code") String code,
                                HttpServletRequest request,
                                Model model,
                                HttpSession session){

        String grant_type="authorization_code";
        /*
        * client_id
        * redirect_uri
        * code
        * */
        logger.info("토큰을 받을 주소를 만듭니다.");
        String tokenReqUrl="https://kauth.kakao.com/oauth/token?grant_type="+grant_type+"&client_id="+WebCommon.restapi
                +"&redirect_uri="+WebCommon.mydomainkakao+"&code="+code;

        logger.info("토큰 주소는 : " + tokenReqUrl);

        logger.info("토크을 보내고 받아 옵니다.");

        String data = Utils.getHtml(tokenReqUrl, code);       //access_token을 받아옵니다.
        logger.info("응답바디는 :" + data);
        Map<String,String> map = Utils.JSONStringToMap(data); //JSON의 형태로 받아온 값을 Map으로 저장합니다.

        String accessToken = map.get("access_token");
        String tokenType = map.get("token_type");

        String refresh_Token = map.get("refresh_token");
        String scope = map.get("scope");

        //나중에 로그아웃 하기 위한 토큰저장
        session.setAttribute("accessToken", accessToken);

        String kakaoUserProfileReqUrl="https://kapi.kakao.com/v1/user/me?Authorization="+accessToken;
        String userData = Utils.getHtml(kakaoUserProfileReqUrl, tokenType + " " + accessToken);


        logger.info("가져온 값은 : " + userData);

        UserSnsVo userkakaoVo    = new Gson().fromJson(userData, UserSnsVo.class);


        //userVo에 담기
        User user = new User();
        user.setSnsid(userkakaoVo.getId());
        user.setSnstype("kakao");
        user = userService.getUser(user);

        logger.info("유저정보 인증 하기");

        if(setAuthentication(request,user.getUseremail(),user.getPassword(),user.getSnstype())){
            logger.info("카카오 로그인 성공");

            if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                return "redirect:" + "/mom/index";
            }
        }else{
            logger.info("가입페이지 후 홈으로 이동");
            return "/mom/index";
        }

        return "/mom/index";
    }


    @RequestMapping(value = "/callback/facebook",method = RequestMethod.GET)
    public String printWelcome(String code,
                               HttpServletRequest request
    ) throws Exception{

        logger.info("FaceBook Login CallBack");

        String accessToken = code;
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, WebCommon.FACEBOOK_CALLBACK_ADDR, null);

        String accessToken1 = accessGrant.getAccessToken();

        logger.info("accessToken1 :" + accessToken1);
        logger.info("code : " + accessToken);

        Long expireTime =  accessGrant.getExpireTime();

        if (expireTime != null && expireTime < System.currentTimeMillis()) {
            accessToken = accessGrant.getRefreshToken();
            System.out.println("accessToken is expired. refresh token = {}" + accessToken);
        }

        Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
        Facebook facebook = connection == null ? new FacebookTemplate(accessToken) : connection.getApi();
        UserOperations userOperations = facebook.userOperations();
        FacebookProfile facebookProfile = null;

        try {
            facebookProfile = userOperations.getUserProfile();
        } catch (MissingAuthorizationException e) {
            e.printStackTrace();

        } catch (ApiException e) {
            e.printStackTrace();
        }

        logger.info("ID " + facebookProfile.getId());
        logger.info("Name "+facebookProfile.getName());

        //userVo에 담기
        User user = new User();
        user.setSnsid(facebookProfile.getId());
        user.setSnstype("facebook");
        user = userService.getUser(user);

        if(setAuthentication(request,user.getUseremail(),user.getPassword(),user.getSnstype())){
            logger.info("페이스북 로그인");

            if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                return "redirect:" + "/mom/index";
            }
        }else{
            logger.info("가입후 홈으로 이동");
            return "/mom/index";
        }

        return "/mom/index";
    }
}
