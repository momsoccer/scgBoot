<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <title>시드미션 등록관리</title>
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
<body class="widebody">

<article>

  <section class="page-subject">
    <h3>코치 승인페이지   <a href="/admin/lookup">관리자 홈으로 이동</a></h3>
  </section>

  <section>
    <spring:form method="post" action="/admin/coachconfirm"  name="frm" cssClass="form-horizontal" modelAttribute="ins">
      <fieldset>
        <legend>코치승인</legend>

        <div class="form-group">
          <label for="uid" class="col-md-3 control-label">승인유저UID</label>
          <div class="col-md-2">
            <input type="text" class="form-control" id="uid" name="uid">
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
</article>


</body>
</html>
