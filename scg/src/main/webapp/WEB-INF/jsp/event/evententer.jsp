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
  <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>몸싸커이벤트 입력</title>

  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">

  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
  <style>
    body { padding-top: 70px; padding-bottom: 70px;}
  </style>
  <%--datetimepicker--%>
  <link rel="stylesheet" href="/resources/datetimepicker/css/bootstrap-datetimepicker.min.css">
  <script type="text/javascript" src="/resources/datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="/resources/datetimepicker/js/locales/bootstrap-datetimepicker.ko.js" charset="UTF-8"></script>
</head>


<body>

<div class="container">
  <%@ include file="../common/navigation.jsp"%>

  <div style="margin-bottom: 20px">

    <a href="/admin/lookup">
      <img src="/resources/serverimg/return.png" width="30px">
    </a>

  </div>

  <section style="float:none;margin:0 auto;">

    <spring:form method="post" action="/event/enter"  name="frm" cssClass="form-horizontal" modelAttribute="vo" enctype="multipart/form-data">
      <fieldset>
        <legend>이벤트 등록</legend>
        <div class="form-group">
          <label for="subject" class="col-md-2 control-label">강습제목</label>
          <div class="col-md-4">
            <input type="text" class="form-control" id="subject" name="subject" placeholder="강습 제목" required>
          </div>
        </div>

        <div class="form-group">
          <label for="location" class="col-md-2 control-label">운동장(주소)</label>
          <div class="col-md-4">
            <input type="text" class="form-control" id="location" name="location" placeholder="장소" required>
          </div>
        </div>


        <div class="form-group">
          <label for="date" class="col-md-2 control-label">일시</label>
          <div class="col-md-4">
            <div class="input-group date form_datetime"  data-date-format="yyyy-mm-dd hh:ii" data-link-field="date">
              <input class="form-control" size="16" type="text" value="" required>
              <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
              <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="date" name="date" /><br/>
            <script>
              $('.date').datetimepicker({
                language:  'ko',
                weekStart: 1,
                todayBtn:  1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                forceParse: 0,
                showMeridian: 1
              });
            </script>
          </div>
        </div>

        <div class="form-group">
          <label for="insname" class="col-md-2 control-label">강사명</label>
          <div class="col-md-4">
            <input type="text" class="form-control" id="insname" name="insname" placeholder="강사명" required>
          </div>
        </div>

        <div class="form-group">
          <label for="inscareer" class="col-md-2 control-label">강사 경력</label>
          <div class="col-md-4">
            <textarea class="form-control" rows="3" name="inscareer" id="inscareer" placeholder="강사 경력"></textarea>
          </div>
        </div>

        <div class="form-group">
          <label for="skill" class="col-md-2 control-label">교육주제</label>
          <div class="col-md-4">
            <input class="form-control" type="text" name="skill" id="skill" placeholder="드리블,트래핑,리프팅">
          </div>
        </div>

        <div class="form-group">
          <label for="description" class="col-md-2 control-label">강습 세부내용</label>
          <div class="col-md-4">
            <textarea class="form-control" rows="5" name="description" id="description" placeholder="강습 설명"></textarea>
          </div>
        </div>

        <div class="form-group">
          <label for="conditions" class="col-md-2 control-label">특이사항</label>
          <div class="col-md-4">
            <textarea class="form-control" rows="2" name="conditions" id="conditions" placeholder="준비물, 특이사항"></textarea>
          </div>
        </div>


        <div class="form-group">
          <label for="file" class="col-md-2 control-label">메인이미지</label>
          <div class="col-md-4">
            <input type="file" name="file" id="file"/>
          </div>
          <div class="col-md-4">
            <input type="file" name="file2" id="file2"/>
          </div>
          <div class="col-md-4">
            <input type="file" name="file3" id="file3"/>
          </div>
        </div>


        <div class="form-group">
          <label for="youtube" class="col-md-2 control-label">유투브영상 주소</label>
          <div class="col-md-4">
            <input type="text" class="form-control" id="youtube" name="youtube" placeholder="유투브 영상주소">
          </div>
        </div>

        <div class="form-group">
          <label for="fee" class="col-md-2 control-label">참가비</label>
          <div class="col-md-4">
            <input  type="number" id="fee" name="fee" class="form-control"  min="0" max="50000" step="1000" value="0" required>
          </div>
        </div>

        <div class="form-group">
          <label for="age" class="col-md-2 control-label">참가자연령 제한</label>
          <div class="col-md-4">
            <input type="text" class="form-control" id="age" name="age" placeholder="참가자 연령">
          </div>
        </div>

        <div class="form-group">
          <label for="minentrance" class="col-md-2 control-label">최소참가인원</label>
          <div class="col-md-4">
            <input  type="number" id="minentrance" name="minentrance" class="form-control" min="0" max="50" step="1" value="0" required>
          </div>
        </div>

        <div class="form-group">
          <label for="entrance" class="col-md-2 control-label">최대참가인원</label>
          <div class="col-md-4">
            <input  type="number" id="entrance" name="entrance" class="form-control" min="0" max="50" step="1" value="0" required>
          </div>
        </div>

        <div class="form-group">
          <label for="locdesc" class="col-md-2 control-label">오시는 길</label>
          <div class="col-md-4">
            <textarea class="form-control" rows="3" name="locdesc" id="locdesc" placeholder="오시는길" re></textarea>
          </div>
        </div>

      </fieldset>



      <section style="margin-bottom: 50px">
        <div class="col-md-2"></div>
        <div class="col-md-4">
          <input type="submit" id="submit" class="btn btn-default" value="등록" style="width: 90px"/>
          <input type="reset"  value="지우기" class="btn btn-default" style="width: 90px" >
        </div>
      </section>
    </spring:form>
  </section>

  <footer class="modal-footer">
    <%@ include file="../common/footer.jsp"%>
  </footer>
</div>
</body>
</html>
