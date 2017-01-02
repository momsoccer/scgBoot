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
    $(window).resize(function(){resizeYoutube();});
    $(function(){resizeYoutube();});
    function resizeYoutube(){ $("iframe").each(function(){ if( /^https?:\/\/www.youtube.com\/embed\//g.test($(this).attr("src")) ){ $(this).css("width","100%"); $(this).css("height",Math.ceil( parseInt($(this).css("width")) * 480 / 854 ) + "px");} }); }
  </script>

</head>



<body>
<div class="container">
  <%@ include file="../common/navigation.jsp"%>

  <div class="jumbotron">
    <h2 class="text-primary">"시범 운영중입니다"</h2>
    <p class="text-info">곧 "몸싸커"를 웹에서도 만나 보실수 있습니다</p>
    <div class="row">
      <div class="col-xs-12 col-md-12">
        <iframe width="560" height="315" src="https://www.youtube.com/embed/GIlfW994wmo" frameborder="0" allowfullscreen></iframe>
      </div>
    </div>
  </div>


  <%--
    <jstl:choose>
      <jstl:when test="${curlogname eq 'anonymousUser'}">
        <div class="container">

          <%@ include file="../common/navigation.jsp"%>

          <div class="col-md-6" style="float:none;margin:0 auto;">
            <form method="POST" action="/mom/index">
              <h2 class="form-signin-heading">Please sign in</h2>
              <label for="username" class="sr-only">Email address</label>
              <input type="email" id="username" class="form-control" placeholder="Email address" required="" autofocus="">

              <label for="pwd" class="sr-only">Password</label>
              <input type="password" style="margin-top: 10px" id="pwd" class="form-control" placeholder="Password" required="">

              <div style="margin-top: 5px">
                <a href="/oauth/login?snsname=google">구글로그인/회원가입</a>
                </a>
              </div>

              <div style="margin-top: 5px">
                <a href="/oauth/login?snsname=kakao">카카오로그인</a>
                </a>
              </div>
              <div style="margin-top: 5px">
                <a href="/oauth/login?snsname=facebook">페이스북로그인</a>
                </a>
              </div>
              <div style="margin-top: 5px">
                  &lt;%&ndash; <input type="image" src="/resources/serverimg/emaillogin.png" style="max-width: 100%; height: auto;">&ndash;%&gt;
                <input type="submit" value="회원가입" class="btn btn-default">
              </div>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
          </div>
        </div>
      </jstl:when>

      <jstl:when test="${curlogname ne'anonymousUser'}">


        &lt;%&ndash;<h1>로그인한 상태입니다</h1><strong><a href="/mom/logout">로그아웃</a></strong>&ndash;%&gt;

  &lt;%&ndash;      <div id="carousel-example-generic" class="carousel slide">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
          </ol>

          <!-- Carousel items -->
          <div class="carousel-inner">
            <div class="item active">
              <img src="/resources/serverimg/slide1.jpg" alt="First slide">
            </div>
            <div class="item">
              <img src="/resources/serverimg/slide2.jpg" alt="Second slide">
            </div>
            <div class="item">
              <img src="/resources/serverimg/slide3.jpg" alt="Third slide">
            </div>
          </div>
          <!-- Controls -->
          <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
            <!-- <span class="icon-prev"></span> -->
            <img src="/resources/serverimg/left.png" class="control">
          </a>
          <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
            <!--  <span class="icon-next"></span> -->
            <img src="/resources/serverimg/right.png" class="control">
          </a>
        </div>

        <script>
          $('.carousel').carousel()
        </script>&ndash;%&gt;

      </jstl:when>

    </jstl:choose>
  --%>

  <%--
  <sec:authorize access="isAnonymous()">
    <a href="${CONTEXT }/mom/index">로그인</a>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <a href="${CONTEXT }/mom/logout">로그아웃</a>
  </sec:authorize>
  --%>


  <%@ include file="../common/footer.jsp"%>


</div>
</body>
</html>
