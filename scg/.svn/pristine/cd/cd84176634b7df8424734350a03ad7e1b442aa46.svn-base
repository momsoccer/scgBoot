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
    <h3>미션 카테고리   <a href="/admin/lookup">관리자 홈으로 이동</a></h3>
  </section>

  <section>
    <spring:form method="post" action="/admin/categorycreate"  name="frm" cssClass="form-horizontal" modelAttribute="category">
      <fieldset>
        <legend>미션카테고리 명 등록</legend>

        <div class="form-group">
          <label for="name" class="col-md-2 control-label">카테고리명</label>
          <div class="col-md-4">
            <input type="text" class="form-control" id="name" name="name" placeholder="카테고리명" required>
          </div>
        </div>

        <div class="form-group">
          <label for="name" class="col-md-2 control-label">카테고리설명</label>
          <div class="col-md-4">
            <textarea class="form-control" rows="3" name="description" id="description"></textarea>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-2 control-label">활성/비활성</label>
          <div class="col-md-4">
            <div class="radio" id="enable">
              <label>
                <input type="radio" name="enabled" value="Y" checked> Yes
              </label>
              <label>
                <input type="radio" name="enabled" value="N"> No
              </label>
            </div>
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

  <section class="highlight">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>번호</th>
        <th>카테고리명</th>
        <th>설명</th>
        <th>사용/불가</th>
        <th>생성일자</th>
        <th>변경일자</th>
      </tr>
      </thead>

      <tbody>
      <c:if test="${MissionCategoryList.size() != 0}">
        <c:forEach items="${MissionCategoryList}" var="list">
          <tr>
            <td>${list.categoryid}</td>
            <td>
              <a data-toggle="tooltip" data-placement="left" title="미션카테고리를 삭제합니다"
                      href="/admin/categorydelete?categoryid=${list.categoryid}">
            ${list.name}
            </a>
            </td>
            <td>${list.description}</td>
            <td>${list.enabled}</td>
            <td><fmt:formatDate value="${list.creationdate}" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${list.lastupdate}" pattern="yyyy-MM-dd"/></td>
          </tr>
        </c:forEach>
      </c:if>

      <c:if test="${MissionCategoryList.size() == 0}">
        <tr><td colspan="6" style="text-align: center" class="warning">등록된 미션카테고리가 없습니다</td></tr>
      </c:if>
      </tbody>
    </table>
  </section>

</article>


</body>
</html>
