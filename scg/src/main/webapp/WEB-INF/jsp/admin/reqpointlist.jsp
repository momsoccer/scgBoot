<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <title>미션 카테고리 및 타입 설정 페이지</title>
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
  <script type="text/javascript">


    //jquery start
    $(document).ready(function() {

      $(function () {
        $('[data-toggle="tooltip"]').tooltip()
      })

    });
  </script>
</head>
<body class="stmbody">

<article>

  <section class="page-subject">
    <h3>포인트 신청 리스트   <a href="/admin/lookup">관리자 홈으로 이동</a></h3>
  </section>

  <section class="highlight">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>이름</th>
        <th>팀이름</th>
        <th>신청사유</th>
        <th>신청일자</th>
        <th>영상업로드수</th>
        <th>포인트지급횟수</th>
        <th>3000P</th>
        <th>5000P</th>
        <th>30000P</th>
      </tr>
      </thead>

      <tbody>
      <c:if test="${pointReqList.size() != 0}">
        <c:forEach items="${pointReqList}" var="reqlist">
          <tr>
            <td>${reqlist.username}</td>
            <td>${reqlist.reason}</td>
            <td>${reqlist.teamname}</td>
            <td>${reqlist.change_creationdate}</td>
            <th>${reqlist.uploadcount}</th>
            <th>${reqlist.pointcount}</th>
            <th><a href="/admin/pointexecute?uid=${reqlist.uid}&point=3000&id=${reqlist.id}">3000P</a></th>
            <th><a href="/admin/pointexecute?uid=${reqlist.uid}&point=5000&id=${reqlist.id}">5000P</a></th>
            <th><a href="/admin/pointexecute?uid=${reqlist.uid}&point=30000&id=${reqlist.id}">30000P</a></th>
          </tr>
        </c:forEach>
      </c:if>

      <c:if test="${pointReqList.size() == 0}">
        <tr><td colspan="14" style="text-align: center" class="warning">포인트 신청이력이 없습니다</td></tr>
      </c:if>
      </tbody>
    </table>
  </section>

</article>


</body>
</html>
