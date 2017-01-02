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
    <h3>시드미션 등록관리   <a href="/admin/lookup">관리자 홈으로 이동</a></h3>
  </section>

  <section>
    <spring:form method="post" action="/admin/missioncreate"  name="frm" cssClass="form-horizontal" modelAttribute="missionregistervo">
      <fieldset>
        <legend>시드미션 등록</legend>

        <div class="form-group">
          <label for="categoryid" class="col-md-3 control-label">미션카테고리</label>
          <div class="col-md-4">
            <select class="form-control" id="categoryid" name="categoryid"></select>
          </div>
        </div>

        <div class="form-group">
          <label for="typeid" class="col-md-3 control-label">미션타입</label>
          <div class="col-md-4">
            <select class="form-control" id="typeid" name="typeid"></select>
          </div>
        </div>

        <div class="form-group">
          <label for="sequence" class="col-md-3 control-label">미션시퀀스</label>
          <div class="col-md-4">
            <select class="form-control" id="sequence" name="sequence">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>
              <option value="19">19</option>
              <option value="20">20</option>
            </select>
          </div>
        </div>

        <script>
          var options = JSON.parse('${categoryList}');
          var selectBox = document.getElementById('categoryid');
          for(var i = 0, l = options.length; i < l; i++){
            var option = options[i];
            selectBox.options.add( new Option(option.name, option.id, option.selected) );
          }

          var optionst = JSON.parse('${typeList}');
          var selectBoxt = document.getElementById('typeid');
          for(var i = 0, l = optionst.length; i < l; i++){
            var optiont = optionst[i];
            selectBoxt.options.add( new Option(optiont.name, optiont.id, optiont.selected) );
          }

        </script>

        <div class="form-group">
          <label for="missionname" class="col-md-3 control-label">미션제목</label>
          <div class="col-md-9">
            <input type="text" class="form-control" id="missionname" name="missionname"  required>
          </div>
        </div>

        <div class="form-group">
          <label for="description" class="col-md-3 control-label">미션설명</label>
          <div class="col-md-9">
            <textarea class="form-control" rows="3" id="description" name="description" required></textarea>
          </div>
        </div>

        <div class="form-group">
          <label for="precon" class="col-md-3 control-label">미션 클리어조건</label>
          <div class="col-md-9">
            <textarea class="form-control" rows="3" name="precon" id="precon"></textarea>
          </div>
        </div>

        <div class="form-group">
          <label for="videoaddr" class="col-md-3 control-label">서버 비디오 위치(주소)</label>
          <div class="col-md-9">
            <input type="text" class="form-control" id="videoaddr" name="videoaddr">
          </div>
        </div>

        <div class="form-group">
          <label for="fullyoutubeaddr" class="col-md-3 control-label">유투브 비디오 풀주소</label>
          <div class="col-md-9">
            <input type="text" class="form-control" id="fullyoutubeaddr" name="fullyoutubeaddr" required>
          </div>
        </div>

        <div class="form-group">
          <label for="youtubeaddr" class="col-md-3 control-label">안드로이드 비디오 주소</label>
          <div class="col-md-4">
            <input type="text" class="form-control" id="youtubeaddr" name="youtubeaddr"  required>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-3 control-label">무료/유료</label>
          <div class="col-md-4">
            <div class="radio" id="feetype">
              <label>
                <input type="radio" name="feetype" value="N" checked> No
              </label>
              <label>
                <input type="radio" name="feetype" value="Y"> Yes
              </label>
            </div>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-3 control-label">사용유무</label>
          <div class="col-md-4">
            <div class="radio" id="enabled">
              <label>
                <input type="radio" name="enabled" value="Y" checked> Yes
              </label>
              <label>
                <input type="radio" name="enabled" value="N"> No
              </label>
            </div>
          </div>
        </div>

        <div class="form-group">
          <label for="typecode" class="col-md-3 control-label">포인트매니저 타입</label>
          <div class="col-md-4">
            <select class="form-control" id="typecode" name="typecode">
              <option value="MISSION">미션</option>
              <option value="EVENT">이벤트</option>
              <option value="NOREASON">기타</option>
            </select>
          </div>
        </div>

        <div class="form-group">

          <label class="col-md-2 control-label" for="getpoint">미션클리어 포인트</label>
          <div class="col-md-2">
            <input class="form-control text-center" min="100" max="2000" step="100" type="number" id="getpoint" name="getpoint" required>
          </div>

          <label class="col-md-2 control-label" for="escapepoint">미션도전 포인트</label>
          <div class="col-md-2">
            <input class="form-control text-center" min="100" max="2000" step="100" type="number" id="escapepoint" name="escapepoint" required>
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
    <h4>조회 조건</h4>
    <spring:form method="post" action="/admin/mission"  name="frm" cssClass="form-horizontal" modelAttribute="querymission">
      <div class="form-group">
        <label class="col-md-3 control-label">미션 카테고리</label>
        <div class="col-md-2">
          <select class="form-control" id="qcategoryid" name="categoryid">
            <option value="0"></option>
          </select>
        </div>
        <div class="col-md-7">
          <input type="submit" id="submit" class="btn btn-default" value="검색" style="width: 90px"/>
          <input type="reset"  value="지우기" class="btn btn-default" style="width: 90px" >
        </div>
      </div>

      <div class="form-group">
        <label for="typeid" class="col-md-2 control-label">미션타입</label>
        <div class="col-md-4">
          <select class="form-control" id="qtypeid" name="typeid">
            <option value="0"></option>
          </select>
        </div>
      </div>

      <div class="form-group">
        <label class="col-md-3 control-label">사용유무</label>
        <div class="col-md-4">
          <div class="radio" id="qenabled">
            <label>
              <input type="radio" name="enabled" value="Y" checked> Yes
            </label>
            <label>
              <input type="radio" name="enabled" value="N"> No
            </label>
          </div>
        </div>
      </div>

      <script>
        var options = JSON.parse('${qcategoryList}');
        var selectBox = document.getElementById('qcategoryid');
        for(var i = 0, l = options.length; i < l; i++){
          var option = options[i];
          selectBox.options.add( new Option(option.name, option.id, option.selected) );
        }

        var optionst = JSON.parse('${qtypeList}');
        var selectBoxt = document.getElementById('qtypeid');
        for(var i = 0, l = optionst.length; i < l; i++){
          var optiont = optionst[i];
          selectBoxt.options.add( new Option(optiont.name, optiont.id, optiont.selected) );
        }
      </script>

    </spring:form>
  </section>

  <section class="highlight">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>번호</th>
        <th>카테고리</th>
        <th>타입</th>
        <th>시퀀스</th>
        <th>미션제목</th>
        <th>설명</th>
        <th>클리어조건</th>
        <th>비디오주소</th>
        <th>Youtube 풀주소</th>
        <th>Youtube 안드로이드</th>
        <th>요금타입</th>
        <th>사용유무</th>
        <th>생성일자</th>
        <th>변경일자</th>
      </tr>
      </thead>

      <tbody>
      <c:if test="${list.size() != 0}">
        <c:forEach items="${list}" var="missionList">
          <tr>
            <td>${missionList.missionid}</td>
            <td>${missionList.categoryid}</td>
            <td>${missionList.typeid}</td>
            <td>${missionList.sequence}</td>
            <td>${missionList.missionname}</td>
            <td>${missionList.description}</td>
            <td>${missionList.precon}</td>
            <td>${missionList.videoaddr}</td>
            <td>${missionList.fullyoutubeaddr}</td>
            <td>${missionList.youtubeaddr}</td>
            <td>${missionList.enabled}</td>
            <td>${missionList.feetype}</td>
            <td><fmt:formatDate value="${missionList.creationdate}" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${missionList.updatedate}" pattern="yyyy-MM-dd"/></td>
          </tr>
        </c:forEach>
      </c:if>

      <c:if test="${MissionCategoryList.size() == 0}">
        <tr><td colspan="14" style="text-align: center" class="warning">등록된 미션이 없습니다</td></tr>
      </c:if>
      </tbody>
    </table>
  </section>
</article>


</body>
</html>
