<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="stm" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/mom/index">몸싸커</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/mission/main">미션챌린지</a></li>
                <li><a href="/event/eventlist">몸싸커데이</a></li>
                <li><a href="#deleteModal" data-toggle="modal" data-target="#alert">몸싸커강의</a></li>
                <li><a href="#deleteModal" data-toggle="modal" data-target="#alert">오픈보드</a></li>
                <!-- <li class="dropdown">
                   <a href="#" class="dropdown-toggle" data-toggle="dropdown">드롭다운 <b class="caret"></b></a>
                   <ul class="dropdown-menu">
                     <li><a href="#">서브메뉴 1</a></li>
                     <li><a href="#">서브메뉴 2</a></li>
                     <li><a href="#">서브메뉴 3</a></li>
                   </ul>
                 </li> -->
            </ul>
            <%-- 로그인
                  <div class="navbar-form navbar-right" style="    padding-top: 10px; ">
                      <sec:authorize access="isAnonymous()">
                          <a href="${CONTEXT }/mom/index">로그인</a>
                      </sec:authorize>
                      <sec:authorize access="isAuthenticated()">
                          <a href="${CONTEXT }/mom/logout">로그아웃</a>
                      </sec:authorize>
                  </div>
                    --%>
        </div>
    </div>
</nav>

<%--신규 입력후 메세지--%>
<div class="modal fade bs-example-modal-sm" id="alert" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h3 class="modal-title text-info">
                    알림
                </h3>
            </div>

            <div class="modal-body">
                <h4 class="text-success">서비스를 준비 중입니다</h4>
            </div>

        </div>
    </div>
</div>

