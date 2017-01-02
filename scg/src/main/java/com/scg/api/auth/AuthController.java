package com.scg.api.auth;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	/*
	 * social authorize 리다이렉트
	 */
	@RequestMapping(value="{social}", method=RequestMethod.GET)
	public ModelAndView authorize(HttpServletRequest req, @PathVariable("social") String social){
		authService.setPlaceHolder(social);
		return new ModelAndView("redirect:"+authService.getRedirectUrl()); 
	}
	
	/*
	 * social 인증 콜백
	 */
	@RequestMapping(value="{social}/oauth", method=RequestMethod.GET)
	public ModelAndView oauthCallback(HttpServletRequest req,@RequestParam(value="code") String authorize_code, @PathVariable("social") String social){
		authService.setPlaceHolder(social);
		
		
		switch(social){
			case "kakao":
				authService.doPostToken(social,authorize_code);
				break;
			case "facebook":
				authService.doGetToken(social,authorize_code);
				break;
		}
		
		//인증처리
		return new ModelAndView("result");
	}
	
	/*
	 * 로그아웃
	 */
	@RequestMapping(value="{social}/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest req, @PathVariable("social") String social){
		
		
		//로그아웃
		return "로그아웃"; 
	}
	
	/*
	 * 앱연결
	 */
	@RequestMapping(value="{social}/connect", method=RequestMethod.GET)
	public String connect(HttpServletRequest req, @PathVariable("social") String social){
		
		//앱 연결
		return "앱 연결"; 
	}
	
	/*
	 * 앱 연결해체
	 */
	@RequestMapping(value="{social}/disconnect", method=RequestMethod.GET)
	public String disconnect(HttpServletRequest req, @PathVariable("social") String social){
		
		//앱 연결 해제
		return "앱 연결 해제"; 
	}
	
	/*
	 * 사용자 정보
	 */
	@RequestMapping(value="{social}/getUser", method=RequestMethod.GET)
	public String getUser(HttpServletRequest req, @PathVariable("social") String social){
		
		//	사용자 정보 요청
		return "사용자 정보 요청"; 
	}
	
	
	/*
	 *사용자 토큰 유효성 검사 및 정보 얻기
	 */
	@RequestMapping(value="{social}/check", method=RequestMethod.GET)
	public String check(HttpServletRequest req, @PathVariable("social") String social){
		
		//사용자 토큰 유효성 검사 및 정보 얻기
		return "사용자 토큰 유효성 검사 및 정보 얻기"; 
	}
	
}
