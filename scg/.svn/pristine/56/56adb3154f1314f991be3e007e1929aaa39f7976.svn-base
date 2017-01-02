<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <title>미션심사요청 리스트</title>
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
</head>



<body class="widebody">
<article>
  <section class="page-subject">
    <h3>미션심사요청 리스트   <a href="/admin/lookup">관리자 홈으로 이동</a></h3>
  </section>

  <section class="highlight">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>팀명</th>
        <th>유저명</th>
        <th>기술타입</th>
        <th>심사회차</th>
        <th>미션제목</th>
        <th>상태</th>
        <th>요청일자</th>
      </tr>
      </thead>

      <tbody>
      <c:if test="${passlist.size() != 0}">
        <c:forEach items="${passlist}" var="passlist">
          <tr>
            <td>${passlist.teamname}</td>
            <td><a href="/missionwork/evalenter?usermissionid=${passlist.usermissionid}">${passlist.username}</a></td>
            <td>${passlist.missiontypename}</td>
            <td>${passlist.seq}</td>
            <td>${passlist.missionname}</td>
            <td>${passlist.status}</td>
            <td><fmt:formatDate value="${passlist.creationdate}" pattern="yyyy-MM-dd"/></td>
          </tr>
        </c:forEach>
      </c:if>
      </tbody>
    </table>
  </section>
</article>
</body>
</html>
