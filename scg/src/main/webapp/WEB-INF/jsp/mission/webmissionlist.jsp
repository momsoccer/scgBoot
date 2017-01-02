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
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>몸싸커</title>

  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
  <link href="/resources/bootstrap-3.3.2-dist/css/custom1.css" rel="stylesheet">

  <script src="/resources/jquery-1.11.3.min.js"></script>
  <script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
  <%--<script type="text/javascript" src="/resources/jquery.youtubepopup.min.js"></script>--%>
  <style>
    body { padding-top: 70px; padding-bottom: 70px;}
  </style>

  <style>
    .youtubeWrap {
      position: relative;
      width: 100%;
      padding-bottom: 56.25%;
    }
    .youtubeWrap iframe {
      position: absolute;
      width: 100%;
      height: 100%;
    }
  </style>
</head>

<body>
<div class="container">
  <%--내비게이션헤더--%>
  <%@ include file="../common/navigation.jsp"%>

  <article>

    <c:forEach items="${list}" var="list">
      <div class="jumbotron">

        <div class="row">
          <div class="col-sm-12 col-md-12">
          <p class="text-danger"><span class="glyphicon glyphicon-hand-down icons"></span> 영상을 보시려면 이미지를 클릭해주세요!</p>
          </div>
        </div>

        <div class="row">
          <div class="col-sm-6 col-md-6">
            <a data-toggle="modal" data-target="#myModal" data-whatever="${list.youtubeaddr}" data-name="${list.missionname}">
              <img style="width: 100%; margin-bottom: 5px" src="http://img.youtube.com/vi/${list.youtubeaddr}/hqdefault.jpg" alt="미션 챌린지 이미지">
            </a>

              <%--
                          <img class="youtube"
                               rel="${list.youtubeaddr}"
                               style="width: 100%; margin-bottom: 5px" src="http://img.youtube.com/vi/${list.youtubeaddr}/hqdefault.jpg" alt="미션 챌린지 이미지">
              --%>

          </div>
          <div class="col-sm-6 col-md-6">

            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">레벨 : ${list.sequence} ${list.missionname}</h3>
              </div>
              <div class="panel-body">
                  ${list.description}
              </div>
            </div>

            <div class="panel panel-success">
              <div class="panel-heading">
                <h3 class="panel-title">성공 조건</h3>
              </div>
              <div class="panel-body">
                  ${list.precon}
              </div>
            </div>

          </div>
        </div>
      </div>
    </c:forEach>

  </article>

  <%@ include file="../common/footer.jsp"%>


  <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
       aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"
                  aria-hidden="true">×
          </button>
          <h4 class="modal-title" id="myModalLabel">
            미션 영상 보기
          </h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-md-12">
              <iframe  width="560" height="315" src="https://www.youtube.com/embed/" frameborder="0" allowfullscreen></iframe>
            </div>
          </div>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
</div>

<script>
  $('#myModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var youtubeid = button.data('whatever')
    var name = button.data('name')

    var modal = $(this)
    modal.find('#myModalLabel').text("미션 명 : "+name)
    modal.find('.modal-body iframe').attr("src","https://www.youtube.com/embed/"+youtubeid+"?autoplay=1");
  });
</script>

<script>
  jQuery( document ).ready( function( $ ) {
    $( 'iframe[src^="https://www.youtube.com/"]' ).wrap( '<div class="youtubeWrap"></div>' );
  } );
</script>

</body>
</html>
