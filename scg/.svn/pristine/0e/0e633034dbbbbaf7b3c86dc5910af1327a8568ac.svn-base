<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
  <title>유저미션 검사</title>
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>

  <script>
    $(document).ready(function() {

              $("textarea#failuredisp").prop("disabled",true)

              $('input[type=radio][name=passflag]').change(function() {
                if (this.value == 'Y') {
                  $("textarea#failuredisp").val("");
                  $("textarea#failuredisp").prop('disabled',true)
                  $("textarea#inscomment").prop("disabled",false)
                }
                else if (this.value == 'N') {
                  $("textarea#inscomment").val("");
                  $("textarea#inscomment").prop("disabled",true)
                  $("textarea#failuredisp").prop("disabled",false)
                }
              });

            }
    )
  </script>
  <style>
    body { padding-top: 70px; padding-bottom: 70px;}
  </style>
</head>

<body>
<div class="container">
  <%@ include file="../common/navigation.jsp"%>
  <article>
    <section class="page-subject">
      <h3>미션 심사   <a href="/missionwork/missionreqlist">미션심사리스트</a></h3>
    </section>



    <div class="panel panel-default">
      <div class="panel-heading">심사회차-유저명-심사요청일-팀명</div>
      <div class="panel-body">
        ${PassVo.seq} - ${PassVo.username} - <fmt:formatDate value="${PassVo.creationdate}" pattern="yyyy-MM-dd"/> - ${PassVo.teamname}
      </div>
    </div>

    <div class="panel panel-default">
      <div class="panel-heading">미션 기술 카테고리 - 미션 명</div>
      <div class="panel-body">
        ${PassVo.missiontypename} - ${PassVo.missionname}
        <br>${PassVo.description}
      </div>
    </div>

    <div class="panel panel-default">
      <div class="panel-heading">유저 도전 영상</div>
      <div class="panel-body">
        <div class="row">
          <div class="col-md-6">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/${PassVo.useryoutubeaddr}" frameborder="0" allowfullscreen></iframe>
          </div>
          <div class="col-md-6">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/${PassVo.youtubeaddr}" frameborder="0" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>


    <spring:form method="post" action="/missionwork/missioneval"  name="frm" cssClass="form-horizontal" modelAttribute="missionpassvo">
      <section style="margin-bottom: 50px">
        <div class="form-group">
          <label class="col-md-2 control-label">합격/불합격</label>
          <div class="col-md-4">
            <div class="radio" id="passflag">
              <label>
                <input type="radio" name="passflag" value="Y" checked> 합격
              </label>
              <label>
                <input type="radio" name="passflag" value="N"> 불합격
              </label>
            </div>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-2 control-label">합격사유</label>
          <div class="col-md-4">
            <textarea class="form-control" rows="2" name="inscomment" id="inscomment"  required></textarea>
          </div>
          <label class="col-md-2 control-label">불합격사유</label>
          <div class="col-md-4">
            <textarea class="form-control" rows="2" name="failuredisp" id="failuredisp" required></textarea>
          </div>
        </div>

        <input type="hidden" name="missionid" id="missionid" value="${PassVo.missionid}">
        <input type="hidden" name="passid" id="passid" value="${PassVo.passid}">
        <input type="hidden" name="usermissionid" id="usermissionid" value="${PassVo.usermissionid}">
        <input type="hidden" name="uid" id="uid" value="${PassVo.uid}">

        <div class="col-md-2"></div>
        <div class="col-md-4">
          <input type="submit" id="submit" class="btn btn-default" value="심사" style="width: 90px"/>
          <input type="reset"  value="지우기" class="btn btn-default" style="width: 90px" >
        </div>
      </section>
    </spring:form>

  </article>
</div>
</body>
</html>
