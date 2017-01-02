<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- Header --%>
<jsp:include page="../includeHeader.jsp" flush="false" />
<%-- // Header --%>

<div id="wrapper">

	<%-- Navigation --%>
	<jsp:include page="../includeNavigation.jsp" flush="false" />
	<%-- // Navigation --%>

	<!-- Page -->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h4 class="page-header">m 관리</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
	
					<div class="panel-heading">
						<i class="fa fa-list"></i> m 목록
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-4">
								<fieldset disabled>
								<div class="form-group">
									<label>missionid</label>
									<input id="missionid" class="form-control" maxlength="20">
								</div>
								</fieldset>
								<div class="form-group">
									<label>age</label>
									<select class="form-control" id="ageList"></select>
								</div>
								<div class="form-group">
									<label>gender</label>
									<select class="form-control" id="genderList"></select>
								</div>
								<div class="form-group">
									<label>grade</label>
									<select class="form-control" id="gradeList"></select>
								</div>
								<div class="form-group">
									<label>description</label>
									<input id="description" class="form-control" maxlength="500">
								</div>
								<div class="form-group">
									<label>youtubeid</label>
									<input id="youtubeid" class="form-control" maxlength="20">
								</div>
							</div>
							<div class="col-lg-8">
								<button type="button" class="btn btn-primary" id="btnCancel">취소</button>
								<button type="button" class="btn btn-primary" id="btnWrite">추가 / 수정</button>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped" id="missionList">
								<thead>
								<tr>
								<th>missionid</th>
								<th>age</th>
								<th>gender</th>
								<th>grade</th>
								<th>description</th>
								<th>filepath</th>
								<th>youtubeid</th>
								<th></th>
								</tr>
								</thead>
								<tbody>
								</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- // Page -->

</div>

<%-- Js --%>
<jsp:include page="../includeJs.jsp" flush="false" />
<%-- // Js --%>

<script>
$(document).ready(function() {
	$.getMissionList();
	$.getMissionAgeList();
	$.getMissionGenderList();
	$.getMissionGradeList();
});

$.getMissionList = function() {
	$.ajax({
		url     : "/api/mission",
		type    : "GET",
		success : function(jsonData) {
			$.displayMissionList(jsonData);
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
};

$.displayMissionList = function(jsonData) {

	$("#missionList > tbody").empty();

	var tr = "";

	for (var i in jsonData) {
		tr  = "";
		tr += "<tr>";
		tr += "<td>" + jsonData[i].missionid   + "</td>";
		tr += "<td>" + jsonData[i].age         + "</td>";
		tr += "<td>" + jsonData[i].gender      + "</td>";
		tr += "<td>" + jsonData[i].grade       + "</td>";
		tr += "<td>" + jsonData[i].description + "</td>";
		tr += "<td>" + jsonData[i].filepath    + "</td>";
		tr += "<td><a href='https://youtu.be/" + jsonData[i].youtubeid + "' target='_blank'><img src='http://img.youtube.com/vi/" + jsonData[i].youtubeid + "/default.jpg'></a></td>";
		tr += "<td>";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.modifyMission(\""+jsonData[i].missionid+"\", \""+jsonData[i].age+"\", \""+jsonData[i].gender+"\", \""+jsonData[i].grade+"\", \""+jsonData[i].description+"\", \""+jsonData[i].youtubeid+"\");'><i class='glyphicon glyphicon-pencil'></i> 수정</button>&nbsp;&nbsp;";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.deleteMission(\""+jsonData[i].missionid+"\");'><i class='glyphicon glyphicon-remove'></i> 삭제</button>";
		tr += "</td>";
		tr += "</tr>";

		$("#missionList > tbody:last-child").append(tr);
	}
};

$.getMissionAgeList = function() {
	$.ajax({
		url     : "/api/missionAge",
		type    : "GET",
		success : function(jsonData) {
			$.makeSelectList(jsonData, "ageList");
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
};

$.getMissionGenderList = function() {
	$.ajax({
		url     : "/api/missionGender",
		type    : "GET",
		success : function(jsonData) {
			$.makeSelectList(jsonData, "genderList");
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
};

$.getMissionGradeList = function() {
	$.ajax({
		url     : "/api/missionGrade",
		type    : "GET",
		success : function(jsonData) {
			$.makeSelectList(jsonData, "gradeList");
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
};

$.makeSelectList = function(jsonData, target) {

	var html = "";

	html += "<option value=''> -- 선택하세요 -- </option>";

	switch (target) {
	case "ageList":
		for (var i in jsonData) {
			html += "<option value='" + jsonData[i].age + "'>[" + jsonData[i].age + "] " + jsonData[i].agefrom + " ~ " + jsonData[i].ageto + "</option>";
		}
		break;
	case "genderList":
		for (var i in jsonData) {
			html += "<option value='" + jsonData[i].gender + "'>[" + jsonData[i].gender + "] " + jsonData[i].gendername + "</option>";
		}
		break;
	case "gradeList":
		for (var i in jsonData) {
			html += "<option value='" + jsonData[i].grade + "'>[" + jsonData[i].grade + "] " + jsonData[i].gradename + "</option>";
		}
		break;
	}

	$("#"+target).html(html);
};

$("#btnCancel").click(function() {
	$(".form-control").val("");
});

$("#btnWrite").click(function() {
	if ($("#ageList").val() == "" || $("#genderList").val() == "" || $("#gradeList").val() == "" || $("#description").val() == "" || $("#youtubeid").val() == "") {
		alert("다 입력하세요.");
		return;
	}

	var formData = new FormData();
	formData.append("missionid",   $("#missionid").val());
	formData.append("age",         $("#ageList").val());
	formData.append("gender",      $("#genderList").val());
	formData.append("grade",       $("#gradeList").val());
	formData.append("description", $("#description").val());
	formData.append("youtubeid",   $("#youtubeid").val());

	$.ajax({
		url         : "/api/mission",
		data        : formData,
		type        : "POST",
		contentType : false,
		processData : false,
		beforeSend  : function(xhr) {
			xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
		},
		success     : function(jsondata) {
			alert("저장하였습니다.");
			$.getMissionList();
			$(".form-control").val("");
		},
		error       : function (jqXHR, textStatus, errorThrown) {
			alert("[" + jqXHR.status + "] " + errorThrown);
		}
	});
});

$.modifyMission = function(missionid, age, gender, grade, description, youtubeid) {
	$("#missionid").val(missionid);
	$("#ageList").val(age);
	$("#genderList").val(gender);
	$("#gradeList").val(grade);
	$("#description").val(description);
	$("#youtubeid").val(youtubeid);
};

$.deleteMission = function(missionid) {
	if (confirm("삭제하시겠습니까?")) {
		$.ajax({
			url         : "/api/mission/" + missionid,
			type        : "DELETE",
			beforeSend  : function(xhr) {
				xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
			},
			success     : function(jsondata) {
				alert("삭제하였습니다.");
				$.getMissionList();
				$(".form-control").val("");
			},
			error       : function (jqXHR, textStatus, errorThrown) {
				alert("[" + jqXHR.status + "] " + errorThrown);
			}
		});
	}
};
</script>

</body>
</html>