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
  <title>몸싸커데이 후기</title>

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
    //jquery start
    $(document).ready(function() {

      /*setTimeout(function(){
       $('#alert').alert('close');
       },3000);*/

    });
  </script>

</head>
<body>

<div class="container">
  <%@ include file="../common/navigation.jsp"%>
  <article>

    <div class="jumbotron">
      <h3 class="text-info">오프라인 레슨 후기입력</h3>
      <spring:form method="post" action="/event/commentinsert"  name="frm" cssClass="form-horizontal" modelAttribute="vo">

        <div style="margin-bottom: 10px">
          <input type="radio" name="eval" value="A" checked="checked">좋음
          <input type="radio" name="eval" value="B">보통
          <input type="radio" name="eval" value="C">별로
        </div>

        <input type="hidden" name="mainid" id="mainid" value="${mainid}">
        <div class="input-group input-group-lg">
          <span class="input-group-addon" id="username">이름</span>
          <input type="text" class="form-control" placeholder="참여자명/몸싸커닉네임" aria-describedby="username" name="username" required>
        </div>

        <div class="form-group" style="margin-top: 10px">
          <div class="col-md-12">
            <textarea class="form-control" rows="3" name="content" id="content" placeholder="내용" required></textarea>
          </div>
        </div>
        <section>
          <div class="col-md-1"><input type="submit" id="submit" class="btn btn-default" value="등록" style="width: 80px"/></div>
          <div class="col-md-11">
          </div>
        </section>
      </spring:form>
      </form>
    </div>
    <table class="table table-hover">
      <thead>
      <tr>
        <th class="text-left">이름</th>
        <th class="text-left">후기내용</th>
        <th class="text-left">등록일</th>
      </tr>
      </thead>
      <!-- db data view -->
      <tbody>
      <c:if test="${list.size() != 0}">
      <c:forEach items="${list}" var="listcomment">
      <tr>
        <td class="text-left" style="width: 10%">${listcomment.username}</td>
        <td class="text-left" style="width: 70%">${listcomment.content}</td>
        <td class="text-left" style="width: 20%"><fmt:formatDate value="${listcomment.creationdate}" pattern="yyyy-MM-dd HH:mm"/></td>
        </c:forEach>
        </c:if>
        <c:if test="${list.size() == 0}">
      <tr>
        <td colspan="3" style="text-align: center" class="success">등록된 글이 없습니다</td>
      </tr>
      </c:if>
      </tbody>
    </table>
  </article>
  <%@ include file="../common/footer.jsp"%>
</div>

<%--신규 입력후 메세지--%>
<div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
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
        <h4 class="text-success">후기가 입력 되었습니다</h4>
        <p class="text-info">소중한 의견 감사합니다.</p>
      </div>

    </div>
  </div>
</div>

<c:if test="${flag == 'I'}">
  <script>
    $('#deleteModal').modal('show');
  </script>
</c:if>

</body>
</html>
