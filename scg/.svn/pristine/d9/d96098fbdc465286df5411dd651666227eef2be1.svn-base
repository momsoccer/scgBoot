<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>

<hr>
mypage.jsp
<hr>
<a href="/">홈</a>
<hr>

<form action="/logout" method="post">
<input type="submit" value="로그아웃"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<hr>

사용자 목록 조회 (권한없음 에러 테스트)<br>
<input type="button" value="조회" onclick="$.getUserList();"/><br>
<div id="userList"></div>

<hr>

사용자 정보 조회<br>
<input type="button" value="조회" onclick="$.getUser();"/><br>
<div id="userInfo"></div>

<hr>

<script src="/js/jquery-1.10.2.min.js"></script>
<script>
$.getUserList = function() {
	$.ajax({
		url     : "/api/userList",
		type    : "GET",
		success : function(jsonData) {
			$.displayUserList(jsonData);
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert("[" + jqXHR.status + "] " + errorThrown);
		}
	})
};

$.displayUserList = function(jsonData) {

	var htmlOut = "";

	for(var i in jsonData) {
		htmlOut  = "";
		htmlOut += "<pre>";
		htmlOut += jsonData[i].userid  + "/"
		htmlOut += jsonData[i].pwd     + "/"
		htmlOut += jsonData[i].email   + "/"
		htmlOut += jsonData[i].snstype + "/"
		htmlOut += jsonData[i].snsid   + "/"
		htmlOut += jsonData[i].enable  + "/"
		htmlOut += jsonData[i].regionid;
		htmlOut += "</pre>";

		$("#userList").append(htmlOut);
	}
};

$.getUser = function() {
	$.ajax({
		url     : "/api/user?userid=user1",
		type    : "GET",
		success : function(jsonData) {
			$.displayUser(jsonData);
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert("[" + jqXHR.status + "] " + errorThrown);
		}
	})
};

$.displayUser = function(jsonData) {

	var htmlOut = "";
	htmlOut += "<pre>";
	htmlOut += jsonData.userid  + "/"
	htmlOut += jsonData.pwd     + "/"
	htmlOut += jsonData.email   + "/"
	htmlOut += jsonData.snstype + "/"
	htmlOut += jsonData.snsid   + "/"
	htmlOut += jsonData.enable  + "/"
	htmlOut += jsonData.regionid;
	htmlOut += "</pre>";

	$("#userInfo").append(htmlOut);
};
</script>

</body>
</html>