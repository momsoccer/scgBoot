package com.scg.api.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.scg.model.SocialAuth;

@PropertySource("classpath:auth.properties")
@Service
public class AuthService {

	// 동적으로 value 불러오기
	@Autowired
	Environment env;

	private String authorize_url;
	private String client_id;
	private String adminkey;
	private String en_redirect_uri;
	private String de_redirect_uri;
	private String token;
	private String logout;
	private String signup;
	private String unlink;
	private String me;
	private String tokenInfo;
	
	

	/*
	 * post token 가져오기
	 */
	public SocialAuth doPostToken(String social, String authorize_code) {

		RestTemplate restTemplate = null;
		HttpEntity<MultiValueMap<String, String>> request = null;
		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			restTemplate = new RestTemplate();
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			// request 헤더 설정
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.add("Authorization", authorize_code);
			headers.add("charset", "UTF-8");
			// post 파라미터
			parameters.add("grant_type", "authorization_code");
			parameters.add("client_id", client_id);
			parameters.add("redirect_uri", de_redirect_uri);
			parameters.add("code", authorize_code);
			request = new HttpEntity<>(parameters, headers);
			response = restTemplate.exchange(token, HttpMethod.POST, request, SocialAuth.class);
			socialAuth = response.getBody();
			// auth code도 저장한다.
			socialAuth.setCode(authorize_code);
			socialAuth.setSocialType(social);
			// 세션을 저장한다.
			setSession(socialAuth);

		} catch (HttpClientErrorException e) {
			// 에러처리
		}

		return socialAuth;

	}

	/*
	 * get token 가져오기
	 */
	public SocialAuth doGetToken(String social, String authorize_code) {

		RestTemplate restTemplate = null;
		HttpEntity<MultiValueMap<String, String>> request = null;
		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			restTemplate = new RestTemplate();
			headers = new HttpHeaders();
			/*
			 * parameters = new LinkedMultiValueMap<String, String>(); //
			 * request 헤더 설정
			 * headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			 * parameters.add("client_secret", adminkey);
			 * parameters.add("client_id", client_id);
			 * parameters.add("redirect_uri", de_redirect_uri);
			 * parameters.add("code", authorize_code); request = new
			 * HttpEntity<>(parameters, headers);
			 */
			request = new HttpEntity<>(headers);

			response = restTemplate.exchange(token + authorize_code, HttpMethod.GET, request, SocialAuth.class);
			socialAuth = response.getBody();
			// auth code도 저장한다.
			socialAuth.setCode(authorize_code);
			socialAuth.setSocialType(social);
			// 세션을 저장한다.
			setSession(socialAuth);

		} catch (HttpClientErrorException e) {
			// 에러처리
		}
		return socialAuth;

	}
	

	/**
	 * reflesh 토큰갱신
	 * @param social
	 * @return
	 */
	public SocialAuth reflesh(String social) {

		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			socialAuth = getAuth();
			headers.add("charset", "UTF-8");
			parameters.add("grant_type", "refresh_token");
			parameters.add("client_id", client_id);
			parameters.add("refresh_token", socialAuth.getRefresh_token());

			response = (ResponseEntity<SocialAuth>) doPost(token, headers, parameters, SocialAuth.class.getName());

			expireAuth();

		} catch (HttpClientErrorException e) {
			// 에러처리
		}
		return response.getBody();

	}
	

	/*
	 * post logout
	 */
	public SocialAuth logout(String social) {

		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			socialAuth = getAuth();
			headers.add("Authorization", "Bearer" + socialAuth.getAccess_token());
			headers.add("charset", "UTF-8");

			response = (ResponseEntity<SocialAuth>) doPost(logout, headers, parameters, SocialAuth.class.getName());

			expireAuth();

		} catch (HttpClientErrorException e) {
			// 에러처리
		}
		return response.getBody();

	}
	
	/**
	 * 앱연결
	 * @param social
	 * @return
	 */
	public SocialAuth signup(String social) {

		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			socialAuth = getAuth();
			headers.add("Authorization", "Bearer" + socialAuth.getAccess_token());
			headers.add("charset", "UTF-8");
			response = (ResponseEntity<SocialAuth>) doPost(signup, headers, parameters, SocialAuth.class.getName());


		} catch (HttpClientErrorException e) {
			// 에러처리
		}
		return response.getBody();

	}
	
	/**
	 * unlink 앱해체
	 * @param social
	 * @return
	 */
	public SocialAuth unlink(String social) {

		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			socialAuth = getAuth();
			headers.add("Authorization", "Bearer" + socialAuth.getAccess_token());
			headers.add("charset", "UTF-8");
			response = (ResponseEntity<SocialAuth>) doPost(unlink, headers, parameters, SocialAuth.class.getName());


		} catch (HttpClientErrorException e) {
			// 에러처리
		}
		return response.getBody();

	}
	
	
	/**
	 * me
	 * @param social
	 * @return
	 */
	public SocialAuth me(String social) {

		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			socialAuth = getAuth();
			headers.add("Authorization", "Bearer" + socialAuth.getAccess_token());
			headers.add("charset", "UTF-8");
			//response 객체 만들어야함....
			response = (ResponseEntity<SocialAuth>) doPost(me, headers, parameters, SocialAuth.class.getName());

		} catch (HttpClientErrorException e) {
			// 에러처리
		}
		return response.getBody();

	}

	/**
	 * tokenInfo
	 * @param social
	 * @return
	 */
	public SocialAuth tokenInfo(String social) {

		ResponseEntity<SocialAuth> response = null;
		HttpHeaders headers = null;
		MultiValueMap<String, String> parameters = null;
		SocialAuth socialAuth = null;

		try {
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			socialAuth = getAuth();
			headers.add("Authorization", "Bearer" + socialAuth.getAccess_token());
			headers.add("charset", "UTF-8");
			//response 객체 만들어야함....
			response = (ResponseEntity<SocialAuth>) doPost(tokenInfo, headers, parameters, SocialAuth.class.getName());

		} catch (HttpClientErrorException e) {
			// 에러처리
		}
		return response.getBody();

	}
	/**
	 * REST template get 
	 * 매너져 클래스 필요...
	 * @param url
	 * @param headers
	 * @param returntype
	 * @return
	 */
	private ResponseEntity<?> doGet(String url, HttpHeaders headers, String returntype) {

		RestTemplate restTemplate = null;
		HttpEntity<MultiValueMap<String, String>> request = null;
		ResponseEntity<?> response = null;
		Class<?> klass = null;
		try {
			restTemplate = new RestTemplate();
			headers = new HttpHeaders();
			klass = ClassLoader.getSystemClassLoader().loadClass(returntype);
			request = new HttpEntity<>(headers);
			response = (ResponseEntity<?>) restTemplate.exchange(url, HttpMethod.GET, request, klass);
			response.getBody();

		} catch (HttpClientErrorException | ClassNotFoundException e) {
			// 에러처리
		}
		return response;

	}
	
	/**
	 * 
	 * @param url
	 * @param headers
	 * @param parameters
	 * @param returntype
	 * @return
	 */
	private ResponseEntity<?> doPost(String url, HttpHeaders headers, MultiValueMap<String, String> parameters,
			String returntype) {

		RestTemplate restTemplate = null;
		HttpEntity<MultiValueMap<String, String>> request = null;
		ResponseEntity<?> response = null;
		Class<?> klass = null;
		try {
			restTemplate = new RestTemplate();
			headers = new HttpHeaders();
			parameters = new LinkedMultiValueMap<String, String>();
			klass = ClassLoader.getSystemClassLoader().loadClass(returntype);
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			request = new HttpEntity<>(parameters, headers);
			response = (ResponseEntity<?>) restTemplate.exchange(url, HttpMethod.POST, request, klass);
			response.getBody();

		} catch (HttpClientErrorException | ClassNotFoundException e) {
			// 에러처리
		}
		return response;

	}

	/*
	 * 리다이렉트 URL
	 */
	public String getRedirectUrl() {
		return authorize_url;

	}

	/*
	 * 구분자에 맞게 properties value 불러오기
	 */
	public void setPlaceHolder(String type) {

		authorize_url = env.getProperty(type + ".authorize.url");
		client_id = env.getProperty(type + ".client_id");
		adminkey = env.getProperty(type + ".adminkey");
		en_redirect_uri = env.getProperty(type + ".encode.redirect_uri");
		de_redirect_uri = env.getProperty(type + ".decode.redirect_uri");
		token = env.getProperty(type + ".token.url");
		logout = env.getProperty(type + ".logout.url");
		signup = env.getProperty(type + ".signup.url");
		unlink = env.getProperty(type + ".unlink.url");
		me = env.getProperty(type + ".unlink.url");
		tokenInfo= env.getProperty(type + ".tokeninfo.url");
	}

	/*
	 * 
	 * session 관리 클래스 필요
	 * 
	 * 
	 */
	/*
	 * 쇼셜 토큰값 저장하기
	 */
	private void setSession(SocialAuth socialAuth) {
		ServletRequestAttributes reqAttr = null;
		HttpServletRequest req = null;
		try {
			reqAttr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			req = reqAttr.getRequest();
			req.getSession().setAttribute("oauth", socialAuth);
		} catch (Exception e) {

		}
	}

	private SocialAuth getAuth() {

		ServletRequestAttributes reqAttr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest req = reqAttr.getRequest();
		SocialAuth socialAuth = (SocialAuth) req.getSession().getAttribute("oauth");

		return socialAuth;
	}

	private void expireAuth() {
		ServletRequestAttributes reqAttr = null;
		HttpServletRequest req = null;

		try {
			reqAttr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			req = reqAttr.getRequest();
			req.getSession().removeAttribute("oauth");
		} catch (Exception e) {

		}

	}
}
