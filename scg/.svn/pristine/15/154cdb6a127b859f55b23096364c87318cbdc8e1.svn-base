<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />


  <title>장소 소개 및 지도</title>

</head>
<body>


<div id="map" style="width:100%;height:800px"></div> <!-- 지도를 표시할 div 입니다 -->

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
<p>종로3가역 → 마을버스 서대문11(홍제역) → 풍림.극동아파트 정류장 하차</p>
<p>종로3가역 → 마을버스 서대문13(홍제역.1번출구) → 풍림.극동아파트 정류장 하차</p>
</body>
</html>
