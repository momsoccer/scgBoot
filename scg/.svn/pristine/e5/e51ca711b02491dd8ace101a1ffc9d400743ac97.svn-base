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
				<h4 class="page-header">m grd 관리</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
	
					<div class="panel-heading">
						<i class="fa fa-list"></i> m grd 목록
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>grade</label>
									<input id="grade" class="form-control" maxlength="2">
								</div>
								<div class="form-group">
									<label>Name</label>
									<input id="gradename" class="form-control" maxlength="10">
								</div>
							</div>
							<div class="col-lg-8">
								<button type="button" class="btn btn-primary" id="btnWrite">추가 / 수정</button>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped" id="missionGradeList">
								<thead>
								<tr>
								<th>grd</th>
								<th>Name</th>
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
	$.getMissionGradeList();
});

$.getMissionGradeList = function() {
	$.ajax({
		url     : "/api/missionGrade",
		type    : "GET",
		success : function(jsonData) {
			$.displayMissionGradeList(jsonData);
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
};

$.displayMissionGradeList = function(jsonData) {

	$("#missionGradeList > tbody").empty();

	var tr = "";

	for (var i in jsonData) {
		tr  = "";
		tr += "<tr>";
		tr += "<td>" + jsonData[i].grade     + "</td>";
		tr += "<td>" + jsonData[i].gradename + "</td>";
		tr += "<td>";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.modifyGrade(\""+jsonData[i].grade+"\", \""+jsonData[i].gradename+"\");'><i class='glyphicon glyphicon-pencil'></i> 수정</button>&nbsp;&nbsp;";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.deleteGrade(\""+jsonData[i].grade+"\");'><i class='glyphicon glyphicon-remove'></i> 삭제</button>";
		tr += "</td>";
		tr += "</tr>";

		$("#missionGradeList > tbody:last-child").append(tr);
	}
};

$("#btnWrite").click(function() {
	if ($("#grade").val() == "" || $("#gradename").val() == "") {
		alert("다 입력하세요.");
		return;
	}

	var formData = new FormData();
	formData.append("grade",     $("#grade").val());
	formData.append("gradename", $("#gradename").val());

	$.ajax({
		url         : "/api/missionGrade",
		data        : formData,
		type        : "POST",
		contentType : false,
		processData : false,
		beforeSend  : function(xhr) {
			xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
		},
		success     : function(jsondata) {
			alert("저장하였습니다.");
			$.getMissionGradeList();
			$("#grade").val("");
			$("#gradename").val("");
		},
		error       : function (jqXHR, textStatus, errorThrown) {
			alert("[" + jqXHR.status + "] " + errorThrown);
		}
	});
});

$.modifyGrade = function(grade, gradename) {
	$("#grade").val(grade);
	$("#gradename").val(gradename);
};

$.deleteGrade = function(grade) {
	if (confirm("삭제하시겠습니까?")) {
		$.ajax({
			url         : "/api/missionGrade/" + grade,
			type        : "DELETE",
			beforeSend  : function(xhr) {
				xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
			},
			success     : function(jsondata) {
				alert("삭제하였습니다.");
				$.getMissionGradeList();
				$("#grade").val("");
				$("#gradename").val("");
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