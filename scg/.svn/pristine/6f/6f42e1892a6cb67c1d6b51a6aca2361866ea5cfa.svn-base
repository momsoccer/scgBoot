<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>몸싸커데이</title>

  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <link href="/resources/bootstrap-3.3.2-dist/css/custom1.css" rel="stylesheet">
  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>

  <%--datetimepicker--%>
  <link rel="stylesheet" href="/resources/datetimepicker/css/bootstrap-datetimepicker.min.css">
  <script type="text/javascript" src="/resources/datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="/resources/datetimepicker/js/locales/bootstrap-datetimepicker.ko.js" charset="UTF-8"></script>

  <style>
    body { padding-top: 70px; padding-bottom: 70px;}
  </style>

  <script type="text/javascript">
    function goPage(pageNo){
      document.listForm.pageNo.value = pageNo;
      document.listForm.submit();
    }

    //jquery start
    $(document).ready(function() {

/*      setTimeout(function(){
        $('#alert').alert('close');
      },3000);*/

      //이전에 조회 값을 넣었다면..
      /*
      $('#search_weather').val($('#weather').val());
      $('#search_result').val($('#result').val());
      $('#search_formation').val($('#formation').val());
      $('#search_exclass').val($('#exclass').val());
      */


    });
  </script>

</head>
<body>

<div class="container">

  <%--내비게이션헤더--%>
  <%@ include file="../common/navigation.jsp"%>

  <article>
    <div class="jumbotron">
      <h1 style="color: #265a88">몸싸커 오프라인 레슨! </h1>
      <p style="margin-top: 20px">검증된 축구 전문 강사분들에게 누구나 합리적인 가격으로 강습을 받으실 수 있습니다</p>
      <p>원하시는 지역에서, 원하시는 기술을, 원하는 날짜에 강습을 받으세요</p>
      <p>베타 테스트 기간에는 누구나 신청하실 수 있습니다</p>
      <%--
      <div class="row">
        <ul class="nav nav-pills" role="tablist">
          <li role="presentation" class="active"><a href="eventlist">신청접수 중인 행사<span class="badge">1</span></a></li>
          <li role="presentation"><a href="eventlist">종료된 행사 <span class="badge">3</span></a></li>
        </ul>
      </div>
--%>
    </div>

    <c:set var="i" value="0" />
    <c:set var="j" value="4" />
    <c:set var="row" value="0" />

    <%--문자 변수 지정하기
    <c:set value="Hello World" var="msg"/>
    msg : ${msg}<br>
    --%>


    <c:forEach items="${mainlist}" var="list">
      <c:if test="${row == 0}">
        <div class="row">
      </c:if>
      <c:set var="row" value="1" />
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="${list.img}" alt="레슨 프리뷰">
          <div class="caption">
            <h3 class="text-success">${list.subject}</h3>
            <p><strong>교육주제</strong> : <a class="text-primary">${list.skill}</a></p>
            <p><strong>연령</strong> : ${list.age}</p>
            <p><strong>장소</strong> : ${list.location}</p>
            <p><strong>일자</strong> : <fmt:formatDate value="${list.time}" pattern="yyyy년 MM월 dd일 HH:mm"/></p>
            <p><strong>최대정원</strong> : ${list.entrance} 명,최소정원 : ${list.minentrance}명</p>
            <p><strong>신청자</strong> :  <span class="badge">${list.reqcount}</span></p>
            <p><strong>강습료</strong> :  <fmt:formatNumber value="${list.fee}" pattern="#,###" />원</p>

            <c:set var="progvalue" value="0" />
            <c:set var="progvalue" value="${list.reqcount/list.entrance*100}" />

            <div class="progress">
              <div class="progress-bar progress-bar-info progress-bar-striped active"
                   role="progressbar" aria-valuenow="${list.reqcount}" aria-valuemin="${list.minentrance}" aria-valuemax="${list.entrance}"
                   style="width: ${progvalue}%;">
                  ${fn:substring(progvalue,0,3)}%
              </div>
            </div>
            <p><a href="eventdetail?mainid=${list.mainid}" class="btn btn-primary btn-block" role="button">수강신청 및 정보</a></p>
            <p><a href="eventcomment?mainid=${list.mainid}" class="btn btn-success btn-block" role="button">후기 입력 및 보기 <span class="badge">${list.boardcount}</span></a></p>
          </div>
        </div>
      </div>

      <c:if test="${i%j == j-1}">
        </div>
        <c:set var="row" value="0" />
      </c:if>



      <c:set var="i" value="${i+1}" />



      </c:forEach>


<c:if test="${mainlist.size() > 8}">
      <form name="listForm" action="eventlist" method="post">
        <div class="pagination">
          <input type="hidden" name="firstPageNo" value="${paging.firstPageNo}" />
          <input type="hidden" name="prevPageNo" value="${paging.prevPageNo}" />
          <input type="hidden" name="startPageNo" value="${paging.startPageNo}" />
          <input type="hidden" name="pageNo" value="${paging.pageNo}" />
          <input type="hidden" name="endPageNo" value="${paging.endPageNo}" />
          <input type="hidden" name="nextPageNo" value="${paging.nextPageNo}" />
          <input type="hidden" name="finalPageNo" value="${paging.finalPageNo}" />


          <li class="previous"><a href="javascript:goPage(${paging.firstPageNo})"><span aria-hidden="true"></span>처음</a></li>
          <li><a href="javascript:goPage(${paging.prevPageNo})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
          <li>
            <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
              <c:choose>
                <c:when test="${i eq paging.pageNo}">
                  <a href="javascript:goPage(${i})" class="selected">${i}</a>
                </c:when>
                <c:otherwise>
                  <a href="javascript:goPage(${i})">${i}</a>
                </c:otherwise>
              </c:choose>
            </c:forEach>
          </li>
          <li><a href="javascript:goPage(${paging.nextPageNo})" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
          <li class="next"><a href="javascript:goPage(${paging.finalPageNo})">마지막<span aria-hidden="true"></span></a></li>
        </div>
      </form>
</c:if>

  </article>


  <%@ include file="../common/footer.jsp"%>


</div>

</body>
</html>
