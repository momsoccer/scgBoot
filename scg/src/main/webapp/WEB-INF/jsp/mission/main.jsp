<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>몸싸커</title>

  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <link href="/resources/bootstrap-3.3.2-dist/css/custom1.css" rel="stylesheet">

  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
  <style>
    body { padding-top: 70px; padding-bottom: 70px;}
  </style>



</head>

<body>
<div class="container">
  <%--내비게이션헤더--%>
  <%@ include file="../common/navigation.jsp"%>

  <article>

    <div class="jumbotron">
      <h1>몸싸커 미션챌린지!</h1>
      <p style="margin-top: 20px">축구 기술별, 단계별로 미션 영상을 보고 따라해보세요</p>
      <p>드리블, 트래핑, 리프팅, 프리스타일 기술등 200여개의 미션챌린지에 도전해보세요</p>
      <p>셀프트레이닝을 한 후 몸싸커 데이 강습에도 참여해보세요</p>
      <a data-toggle="tooltip" data-placement="top" title="구글플레이 스토어에서 몸싸커를 다운 받습니다" target="_blank"
         href="https://play.google.com/store/apps/details?id=com.mom.soccer"><img src="/resources/serverimg/appdown.png" width="250"></a>
    </div>

    <c:set var="i" value="0" />
    <c:set var="j" value="3" />
    <c:set var="row" value="0" />

    <c:forEach items="${list}" var="list">
      <c:if test="${row == 0}">
        <div class="row">
      </c:if>
      <c:set var="row" value="1" />
      <div class="col-sm-4 col-md-4">
        <div class="thumbnail">
          <img src="http://img.youtube.com/vi/${list.previewimg}/hqdefault.jpg" alt="미션 챌린지 이미지">
          <div class="caption">
            <h3 class="text-success">${list.description}</h3>
            <a class="btn btn-default btn-block" type="button" href="webmissionlist?typeid=${list.typeid}">
              등록 미션 영상 수 <span class="badge">${list.missioncount}</span>
            </a>
            <a class="btn btn-success btn-block" type="button" href="webusermissionlist?typename=${list.missiontype}">
              도전 유저 영상 수 <span class="badge">${list.usercount}</span>
            </a>
          </div>
        </div>
      </div>

      <c:if test="${i%j == j-1}">
        </div>
        <c:set var="row" value="0" />
      </c:if>



      <c:set var="i" value="${i+1}" />



    </c:forEach>

  </article>

    <%@ include file="../common/footer.jsp"%>

</div>

</body>
</html>
