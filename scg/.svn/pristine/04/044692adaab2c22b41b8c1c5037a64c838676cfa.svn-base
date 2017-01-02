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
  <title>몸싸커데이 오프라인 레슨 상세보기</title>

  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <link href="/resources/bootstrap-3.3.2-dist/css/custom1.css" rel="stylesheet">


  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>

  <%--datetimepicker--%>
  <link rel="stylesheet" href="/resources/datetimepicker/css/bootstrap-datetimepicker.min.css">
  <script type="text/javascript" src="/resources/datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="/resources/datetimepicker/js/locales/bootstrap-datetimepicker.ko.js" charset="UTF-8"></script>
  <script src="/resources/animatescroll.min.js"></script>
  <style>
    body { padding-top: 70px; padding-bottom: 70px;}
  </style>


  <script type="text/javascript">
    $(document).ready(function() {



    });
  </script>

</head>
<body>
<div class="container-fluid"  >
  <div class="container">

    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="navbar-scroll">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="eventlist">몸싸커데이</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-1-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#ins" onclick="$('#loc').animatescroll();"> <span class="glyphicon glyphicon-picture icons"> 장소소개</span> </a></li>
            <li><a href="#ins" onclick="$('#ins').animatescroll();"> <span class="glyphicon glyphicon-user icons"> 강사소개</span> </a></li>
            <li><a href="#info" onclick="$('#info').animatescroll();"><span class="glyphicon glyphicon-bookmark icons"> 강습내용</span></a></li>
            <li><a href="#mapinfo" onclick="$('#mapinfo').animatescroll();"><span class="glyphicon glyphicon-globe icons"> 위치/시간</span> </a></li>
            <li><a href="#req" onclick="$('#req').animatescroll();"><span class="glyphicon glyphicon-edit"> 수강신청</span> </a></li>
          </ul>
        </div>
      </div><!-- /.navbar-collapse -->
    </nav>

    <article>

      <div id="loc"></div>
      <header class="content1">  <!-- about start-->
        <div class="container">
          <div class="jumbotron">
            <h2><span class="glyphicon glyphicon-picture icons"> </span> 장소 소개 및 기타정보</h2>
            <p>${eventmain.conditions}</p>
            <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-6">
                <iframe width="560" height="315" src="https://www.youtube.com/embed/${eventmain.youtube}" frameborder="0" allowfullscreen></iframe>
              </div>
              <div class="col-md-3"></div>
            </div>

            <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-6">
                <div id="carousel-example-generic" class="carousel slide">
                  <!-- Indicators -->
                  <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                  </ol>

                  <!-- Carousel items -->
                  <div class="carousel-inner">
                    <div class="item active">
                      <img src="${eventmain.img}" alt="First slide">
                    </div>
                    <div class="item">
                      <img src="${eventmain.img2}" alt="Second slide">
                    </div>
                    <div class="item">
                      <img src="${eventmain.img3}" alt="Third slide">
                    </div>
                  </div>
                  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                  </a>
                  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right "></span>
                  </a>
                </div>
              </div>
              <div class="col-md-3"></div>
            </div>
            <script>
              $('.carousel').carousel()

              $(window).resize(function(){

                resizeYoutube();

                $("#map").each(function(){
                  $(this).css("width","100%"); $(this).css("height",Math.ceil( parseInt($(this).css("width")) * 480 / 854 ) + "px"); });

              });

              $(function(){
                resizeYoutube();}
              );

              function resizeYoutube(){


                $("iframe").each(function(){ if( /^https?:\/\/www.youtube.com\/embed\//g.test($(this).attr("src")) ){
                  $(this).css("width","100%"); $(this).css("height",Math.ceil( parseInt($(this).css("width")) * 480 / 854 ) + "px");} });


              }


            </script>

          </div>
        </div><!-- end .container -->
      </header>

      <div id="ins"></div>
      <header class="content1">  <!-- about start-->
        <div class="container">
          <div class="jumbotron">
            <h2><span class="glyphicon glyphicon-user icons"> </span> 강사정보</h2>

            <div class="row">

              <div class="col-xs-6 col-md-3">
                <div class="thumbnail">
                  <img src="${eventmain.insimg}" alt="강사사진">
                  <div class="caption">
                    <p class="text-primary">강사 : ${eventmain.insname}</p>
                  </div>
                </div>
              </div>

              <div class="col-xs-6 col-md-9">
                <p class="text-primary">강사 이력</p>
                <p class="text-success">${eventmain.inscareer}</p>
              </div>

            </div>
          </div>

        </div>
  </div><!-- end .container -->
  </header>


  <div id="info"></div>
  <header class="content2">  <!-- about start-->
    <div class="container">
      <div class="jumbotron">
        <h2><span class="glyphicon glyphicon-bookmark icons"></span> 훈련/강습 내용</h2>
        <p>강습 주제 : ${eventmain.skill}</p>
        <p>세부 내용 : ${eventmain.description}</p>
      </div>
    </div><!-- end .container -->
  </header>



  <div id="mapinfo"></div>
  <header class="content3">  <!-- about start-->
    <div class="container">
      <div class="jumbotron">
        <h2><span class="glyphicon glyphicon-globe icons"></span> 장소 및 시간</h2>
        <p>주소 : ${eventmain.location}</p>
        <p>시간 : <fmt:formatDate value="${eventmain.time}" pattern="yyyy년MM월dd일 HH시mm분"/></p>
        <p>오시는 방법 : ${eventmain.locdesc}</p>
        <p class="text-info">강습료 입금계좌 정보 : 하나은행 286-910068-80707 심성보</p>
        <p class="text-success">기타 문의 : ishimsungbo@gmail.com, 010-2499-1591, 카카오톡ID : @몸싸커</p>

        *빠른 시일내에 결재 시스템을 구축하겠습니다!
        <!-- 지도를 표시할 div 입니다 -->
        <div id="map" style="width:1000px;height:500px"></div>



      </div>
    </div><!-- end .container -->
  </header>

  <div id="req"></div>
  <header class="content4">  <!-- about start-->
    <div class="container">
      <div class="jumbotron">
        <h2><span class="glyphicon glyphicon-edit"></span> 수강신청 및 수강자 목록</h2>


        <c:if test="${eventmain.endflag == 'Y'}">
          <p> <span class="glyphicon glyphicon-remove-sign icons"></span> 종료된 레슨 행사입니다. 다음 행사에 신청해주세요~</p>
        </c:if>

        <c:if test="${eventmain.endflag != 'Y'}">

          <spring:form method="post" action="/event/request"  name="frm" cssClass="form-horizontal" modelAttribute="vo">
            <div class="form-group" style="margin-top: 50px">
              <label for="agree" class="col-md-3 control-label" data-toggle="modal" data-target="#myModalAgree">이용약관 동의 및 환불정책 숙지</label>
              <div class="col-md-1">
                <input type="checkbox" id="agree" name="agree" value="Y" required>
              </div>
              <div class="col-md-2">
                <a class="text-left" href="#myModalAgree" data-toggle="modal" >환불정책</a>
              </div>
              <div class="col-md-2">
                <a class="text-left" href="../common/agreement" target="_blank">이용약관</a>
              </div>
            </div>

            <div class="form-group">
              <label for="name" class="col-md-3 control-label">입금자(몸싸커앱 닉네임)</label>
              <div class="col-md-9">
                <input type="text" class="form-control" id="name" name="name" placeholder="몸싸커앱 닉네임-입금자" required>
              </div>
            </div>

            <div class="form-group">
              <label for="emailaddr" class="col-md-3 control-label">이메일</label>
              <div class="col-md-9">
                <input type="email" class="form-control" id="emailaddr" name="emailaddr" placeholder="Email 주소" required>
              </div>
            </div>

            <div class="form-group">
              <label for="age" class="col-md-3 control-label">참여 유저 나이</label>
              <div class="col-md-9">
                <select name="age" class="form-control" id ="age" required>
                  <option value="">나이선택</option>
                  <option value="7">7세</option>
                  <option value="8">8세</option>
                  <option value="9">9세</option>
                  <option value="10">10세</option>
                  <option value="11">11세</option>
                  <option value="12">12세</option>
                  <option value="13">13세</option>
                  <option value="14">14세</option>
                  <option value="15">15세</option>
                  <option value="16">16세</option>
                  <option value="17">17세</option>
                  <option value="18">18세</option>
                  <option value="19">19세</option>
                  <option value="20">20세</option>
                  <option value="21">21세</option>
                  <option value="22">22세</option>
                  <option value="23">23세</option>
                  <option value="24">24세</option>
                  <option value="25">25세</option>
                  <option value="26">26세</option>
                  <option value="27">27세</option>
                  <option value="28">28세</option>
                  <option value="29">29세</option>
                  <option value="30">30세이상</option>

                </select>
              </div>
            </div>

            <div class="form-group">
              <label for="reqrason" class="col-md-3 control-label">개인별 궁금한 사항</label>
              <div class="col-md-9">
                <textarea class="form-control" rows="3" name="reqrason" id="reqrason" placeholder="축구관련해서 평소 궁금했던 부분이나 꼭 마스터 하고 싶은 기술 기재"></textarea>
              </div>
            </div>

            <div class="form-group">
              <label for="phone" class="col-md-3 control-label">전화번호</label>
              <div class="col-md-3">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="000-000-0000" required>
              </div>
              <label for="password" class="col-md-3 control-label">비밀번호</label>
              <div class="col-md-3">
                <input type="password" class="form-control" id="password" name="password" maxlength="5" required>
              </div>
            </div>

            <div class="col-md-3">
            </div>

            <input type="hidden" value="${eventmain.mainid}" class="btn btn-default" name="mainid" id="mainid">

            <div class="col-md-9">
              <input type="submit" value="신청하기" class="btn btn-default" style="width: 100px">
              <input type="reset" value="지우기" class="btn btn-default" style="width: 100px">
            </div>
          </spring:form>
        </c:if>
        <c:set var="i" value="1" />
      </div>

      <table class="table table-hover">
        <thead>
        <tr>
          <th>순번</th>
          <th>이름</th>
          <th>나이</th>
          <th>개인레슨 요청 부분</th>
          <th>확정구분</th>
          <th>신청일자</th>
          <th>접수취소</th>
        </tr>
        </thead>
        <!-- db data view -->
        <tbody>
        <c:if test="${reqlist.size() != 0}">
        <c:forEach items="${reqlist}" var="list">
        <tr>
          <td>${i}</td>
          <td>${list.name}</td>
          <td>${list.age}</td>
          <td>${fn:substring(list.reqrason,0,50)}</td>
          <td>${list.confirm}</td>
          <td><fmt:formatDate value="${list.creationdate}" pattern="yyyy-MM-dd HH:mm"/></td>
          <td><a type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"
                 data-whatever="${list.reqid}"
                  >취소</a></td>
            <c:set var="i" value="${i+1}" />

          </c:forEach>
          </c:if>
          <c:if test="${reqlist.size() == 0}">
        <tr>
          <td colspan="7" style="text-align: center" class="success">신청자가 없습니다</td>
        </tr>
        </c:if>
        </tbody>
      </table>

    </div><!-- end .container -->
  </header>

  <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=b93f69455de010dfcb1e467b24d4798e&libraries=services,clusterer,drawing"></script>
  <script>
    var infowindow = new daum.maps.InfoWindow({zIndex:1});

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
              center: new daum.maps.LatLng(36.566826, 126.9786567), // 지도의 중심좌표
              level: 5 // 지도의 확대 레벨
            };

    // 지도를 생성합니다
    var map = new daum.maps.Map(mapContainer, mapOption);

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new daum.maps.services.Geocoder();

    // 주소로 좌표를 검색합니다
    geocoder.addr2coord('${eventmain.location}', function(status, result) {

      // 정상적으로 검색이 완료됐으면
      if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
          map: map,
          position: coords
        });


        /*          // 인포윈도우로 장소에 대한 설명을 표시합니다
         var infowindow = new daum.maps.InfoWindow({
         content: '<div style="width:200px;text-align:center;padding:6px 0;"></div>'
         });*/

        //infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
      }
    });
  </script>
  </article>
  <%@ include file="../common/footer1.jsp"%>
</div>
</div>



<%--Modal 이용약관--%>
<div class="modal fade" id="myModalAgree" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">×
        </button>
        <h4 class="modal-title">
          환불정책
        </h4>
      </div>
      <div class="modal-body">

        <p class="text-info">몸싸커의 환불 정책은 평생교육법 시행령[개정 2015년 11월26일] 제23조 제2항에 따릅니다</p>
        <p class="text-success">환불 관련 문의 및 환불 요청방법</p>
        <p class="text-success">이메일 : ishimsungbo@gmail.com</p>
        <p class="text-success">전화 : 010-2499-1591(문자포함)</p>
        <p class="text-success">카카오톡 ID : @몸싸커</p>
        <p class="text-danger"></p>
        <p class="text-danger">1. 강습 전일 불참의사 통보 및 환불 요청시 이미 납부한 수강료 전액 환불해드립니다</p>
        <p class="text-danger">2. 강습 당일과 강의 시간이 1/3 경과하기 전 불참의사 통보 및 환불 요청시, 이미 납부한 수강료의 2/3 해당 금액을 환불해드립니다</p>
        <p class="text-danger">3. 강습 당일 강의 시간이 1/2 경과 전 불참 및 환불 요청시, 이미 납부한 수강료의 1/2 해당 금액을 환불해드립니다</p>
        <p class="text-danger">4. 강습 당일 강의 시간의 1/2및 경과 후에 불참 및 환불 요청시, 환불금은 없습니다</p>
        <p></p>
        <p class="text-info">"몸싸커"는 축구를 사랑하시는 고객 분들의 편의를 위해 최대한 노력하겠습니다</p>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<%--Modal Delete--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">×
        </button>
        <h4 class="modal-title" id="myModalLabel">
          신청 취소
        </h4>
      </div>
      <div class="modal-body">
        <form action="eventreqdelete" method="post">
          <input type="hidden" class="form-control" id="reqid" name="reqid">
          <input type="hidden" class="form-control" id="smainid" name="smainid">
          <div class="form-group">
            <label for="pwd" class="control-label">신청 비밀번호 : </label>
            <input class="form-control" id="pwd" name="password" placeholder="비밀번호를 입력해주세요" required>
          </div>
          <button type="button" class="btn btn-default"
                  data-dismiss="modal">
            닫기
          </button>
          <input type="submit" class="btn btn-primary" id="submit">
        </form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<%--Modal Aler--%>

<div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">×
        </button>
        <h4 class="modal-title">
          알림
        </h4>
      </div>

      <div class="modal-body">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
              <c:if test="${deleteflag == 'Y'}">
                신청이 취소 되었습니다
              </c:if>
              <c:if test="${deleteflag == 'N'}">
                비밀번호가 틀립니다
              </c:if>
            </div>
            <div class="col-md-1"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
  $('#myModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var recipient = button.data('whatever')
    var modal = $(this)
    modal.find('.modal-body input').val(recipient)
    modal.find('#pwd').val("")
    modal.find('#submit').val("신청취소")
    modal.find('#smainid').val("${eventmain.mainid}")
  });
</script>

<c:if test="${deleteflag != 'S'}">
  <script>
    $('#deleteModal').modal('show');
  </script>
</c:if>
</body>
</html>
