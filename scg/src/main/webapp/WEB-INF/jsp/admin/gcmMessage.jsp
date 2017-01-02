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
    <title>푸쉬보내기</title>

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

    <article>
        <section class="page-subject">
            <h3><a href="/admin/lookup">관리자 홈</a> Google Cloud Message</h3>
        </section>


        <spring:form method="post" action="/admin/allpush"  name="frm" cssClass="form-horizontal" modelAttribute="message">
            <div class="form-group">
                <label for="key1" class="col-md-2 control-label">참여 유저 나이</label>
                <div class="col-sm-10">
                    <select name="key1" class="form-control" id ="key1" required>
                        <option value="lesson">오프라인 레슨 홍보</option>
                        <option value="A">기타1</option>
                        <option value="B">기타2</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="content" class="col-sm-2 control-label">제목</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="content" name="content" placeholder="제목">
                </div>
            </div>

            <div class="form-group">
                <label for="message" class="col-sm-2 control-label">메세지</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="3" id="message" name="message" placeholder="내용"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">보내기</button>
                </div>
            </div>
        </spring:form>

    </article>

</div>
</body>
</html>
