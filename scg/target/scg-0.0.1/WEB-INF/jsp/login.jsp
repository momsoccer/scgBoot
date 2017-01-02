<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>

<hr>
login.jsp
<hr>
<a href="/">홈</a>
<hr>

<form name="frm" action="/login" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
아이디 : <input type="text" name="username" />&nbsp;&nbsp;&nbsp;&nbsp;
비밀번호 : <input type="text" name="password" />&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="로그인"/>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/auth/kakao"> <img src="/img/kakao_account_login_btn_medium_narrow_ov.png"></a>

<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="false" data-auto-logout-link="false"></div>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.5";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


<c:if test="${param.error ne null}">
<span>아이디 / 비밀번호를 확인해 주세요.</span>
</c:if>
</form>

<hr>
테스트 아이디<br><br>
관리자 : admin // 1234<br>
사용자 : user1 // 1234<br>

</body>
</html>