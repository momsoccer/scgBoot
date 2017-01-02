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
    <title>몸싸커</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>


<body>
<div class="container">

    <div class="page-header">

        <div class="row" style="margin-left: 20px; margin-right: 20px">
            <div class="row"><h1><img src="/resources/serverimg/140_image.png" width="70" height="70">    Mom Soccer</h1>
                <h1><small>1회 몸싸커 오프라인 레슨 행사에 여러분을 초대합니다</small></h1>
            </div>
        </div>
    </div>

    <div class="page-information">

        <div class="jumbotron">
            <h3>참가자격 : 몸싸커 앱에 1회 이상 셀프트레이닝 영상을 업로드한 유저 누구나</h3>
            <p style="color: red">현재 신청자 :  ${userCount} 명</p>
            <p><strong># 선착순 15명 신청을 받습니다</strong></p>
            <p></p>
            <p>일시 : 2016년 12월 10일 오후 4시 ~ 7시</p>
            <p>장소 : 서대문돌산구장 (서울 서대문구 홍은1동 10-305)</p>
            <p>참가비 : 10,000원 (12월 8일까지 입금하신 분)</p>
            <p>계좌정보 : 하나은행 28691006880707 심성보</p>
            <p>구글플레이 <a href="https://play.google.com/store/apps/details?id=com.mom.soccer" target="_blank">"몸싸커 다운로드"</a></p>

            <div class="row">
                <div class="col-md-4">
                    <div id="map" style="width:300px;height:300px"></div> <!-- 지도를 표시할 div 입니다 -->
                    <br>
                    <a href="/event/eventmap" target="_blank">지도 크게 보기/교통 설명</a>

                    <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=d24c7b885a5a5af44ae789bdff94f356&libraries=services,clusterer,drawing"></script>
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
                        geocoder.addr2coord('서울 서대문구 홍은1동 10-305', function(status, result) {

                            // 정상적으로 검색이 완료됐으면
                            if (status === daum.maps.services.Status.OK) {

                                var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);

                                // 결과값으로 받은 위치를 마커로 표시합니다
                                var marker = new daum.maps.Marker({
                                    map: map,
                                    position: coords
                                });

                                // 인포윈도우로 장소에 대한 설명을 표시합니다
                                var infowindow = new daum.maps.InfoWindow({
                                    content: '<div style="width:200px;text-align:center;padding:6px 0;">' +
                                    '<img src="/resources/serverimg/140_image.png" width="35" height="35" align="center">서대문돌산구장</div>'
                                });
                                infowindow.open(map, marker);

                                // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                                map.setCenter(coords);
                            }
                        });
                    </script>


                </div>
                <div class="col-md-8">
                    <div class="row">

                        <div class="col-md-4"></div>
                        <div class="col-md-4"><h4>신청서 작성</h4></div>
                        <div class="col-md-4"></div>

                    </div>

                    <spring:form method="post" action="/event/request"  name="frm" cssClass="form-horizontal" modelAttribute="vo">
                        <div class="form-group">
                            <label for="name" class="col-md-3 control-label">몸싸커앱닉네임-입금자</label>
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
                                    <option value="12">12세 이하</option>
                                    <option value="13">13세</option>
                                    <option value="14">14세</option>
                                    <option value="15">15세</option>
                                    <option value="16">16세</option>
                                    <option value="17">17세</option>
                                    <option value="18">18세</option>
                                    <option value="19">19세</option>
                                    <option value="20">20세 이상</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="reqrason" class="col-md-3 control-label">개인레슨 요청부분</label>
                            <div class="col-md-9">
                                <textarea class="form-control" rows="5" name="reqrason" id="reqrason" placeholder="축구관련해서 평소 궁금했던 부분이나 꼭 마스터 하고 싶은 기술 기재"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-md-3 control-label">전화번호</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="000-000-0000" required>
                            </div>
                        </div>

                        <div class="col-md-3">
                        </div>

                        <input type="hidden" value="18" class="btn btn-default" name="mainid" id="mainid">

                        <div class="col-md-9">
                            <input type="submit" value="신청하기" class="btn btn-default" style="width: 100px">
                            <input type="reset" value="지우기" class="btn btn-default" style="width: 100px">
                        </div>
                    </spring:form>

                </div>
            </div>

        </div>

        <div class="jumbotron">
            <table class="table table-hover">
                <thead>
                <tr>
                   <%-- <th>순번</th>--%>
                    <th>신청일시</th>
                    <th>닉네임/이름</th>
                    <th>이메일주소</th>
                    <th>참여자나이</th>
                    <th>입금상태</th>
                    <th>확정</th>
                </tr>
                </thead>
                <!-- db data view -->
                <tbody>
                <c:if test="${list.size() != 0}">
                    <c:forEach items="${list}" var="list">
                        <tr>
                            <td>${list.change_creationdate}</td>
                            <td>${list.name}</td>
                            <td>${list.emailaddr}</td>
                            <td>${list.age}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${list.bankflag== 'N'}">
                                        입금전
                                    </c:when>
                                    <c:when test="${list.bankflag== 'Y'}">
                                        입금됨
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${list.confirm== 'N'}">
                                        확정전
                                    </c:when>
                                    <c:when test="${list.confirm== 'Y'}">
                                        참가확정
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${list.size() == 0}">
                    <tr>
                        <td colspan="7" style="text-align: center" class="warning">등록된 연습경기 정보가 없습니다</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>

    </div>
</div>
</body>
</html>
