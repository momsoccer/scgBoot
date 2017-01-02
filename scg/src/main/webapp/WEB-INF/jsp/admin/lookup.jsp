<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
  <title>룩업 홈</title>
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>

  <style>
    body { padding-top: 70px; padding-bottom: 70px;}
  </style>

</head>
<body>
<div class="container">
  <%@ include file="../common/navigation.jsp"%>

  <article>

    <section class="page-subject">
      <h3>관리자 모드</h3>
    </section>

    <div class="row">
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/admin/caterory" style="width: 150px">미션카테고리</a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/admin/type" style="width: 150px">미션타입</a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/admin/mission" style="width: 150px">시드미션</a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/admin/gcmexeucte" style="width: 150px">앱 메세지 보내기</a>
      </div>
    </div>

    <div class="row" style="margin-top: 20px">
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/admin/coachapprov" style="width: 150px">코치승인</a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/admin/reqpointlist" style="width: 150px">포인트신청리스트</a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/missionwork/missionreqlist" style="width: 150px">미션심사</a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a class="btn btn-default" href="/event/evententer" style="width: 150px">이벤트 입력</a>
      </div>
    </div>





  </article>

</div>
</body>
</html>
