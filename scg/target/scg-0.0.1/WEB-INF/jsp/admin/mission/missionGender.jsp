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
				<h4 class="page-header">m gen 관리</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
	
					<div class="panel-heading">
						<i class="fa fa-list"></i> m gen 목록
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Gender</label>
									<input id="gender" class="form-control" maxlength="2">
								</div>
								<div class="form-group">
									<label>Name</label>
									<input id="gendername" class="form-control" maxlength="10">
								</div>
							</div>
							<div class="col-lg-8">
								<button type="button" class="btn btn-primary" id="btnWrite">추가 / 수정</button>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped" id="missionGenderList">
								<thead>
								<tr>
								<th>Gender</th>
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
	$.getMissionGenderList();
});

$.getMissionGenderList = function() {
	$.ajax({
		url     : "/api/missionGender",
		type    : "GET",
		success : function(jsonData) {
			$.displayMissionGenderList(jsonData);
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
};

$.displayMissionGenderList = function(jsonData) {

	$("#missionGenderList > tbody").empty();

	var tr = "";

	for (var i in jsonData) {
		tr  = "";
		tr += "<tr>";
		tr += "<td>" + jsonData[i].gender     + "</td>";
		tr += "<td>" + jsonData[i].gendername + "</td>";
		tr += "<td>";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.modifyGender(\""+jsonData[i].gender+"\", \""+jsonData[i].gendername+"\");'><i class='glyphicon glyphicon-pencil'></i> 수정</button>&nbsp;&nbsp;";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.deleteGender(\""+jsonData[i].gender+"\");'><i class='glyphicon glyphicon-remove'></i> 삭제</button>";
		tr += "</td>";
		tr += "</tr>";

		$("#missionGenderList > tbody:last-child").append(tr);
	}
};

$("#btnWrite").click(function() {
	if ($("#gender").val() == "" || $("#gendername").val() == "") {
		alert("다 입력하세요.");
		return;
	}

	var formData = new FormData();
	formData.append("gender",     $("#gender").val());
	formData.append("gendername", $("#gendername").val());

	$.ajax({
		url         : "/api/missionGender",
		data        : formData,
		type        : "POST",
		contentType : false,
		processData : false,
		beforeSend  : function(xhr) {
			xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
		},
		success     : function(jsondata) {
			alert("저장하였습니다.");
			$.getMissionGenderList();
			$("#gender").val("");
			$("#gendername").val("");
		},
		error       : function (jqXHR, textStatus, errorThrown) {
			alert("[" + jqXHR.status + "] " + errorThrown);
		}
	});
});

$.modifyGender = function(gender, gendername) {
	$("#gender").val(gender);
	$("#gendername").val(gendername);
};

$.deleteGender = function(gender) {
	if (confirm("삭제하시겠습니까?")) {
		$.ajax({
			url         : "/api/missionGender/" + gender,
			type        : "DELETE",
			beforeSend  : function(xhr) {
				xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
			},
			success     : function(jsondata) {
				alert("삭제하였습니다.");
				$.getMissionGenderList();
				$("#gender").val("");
				$("#gendername").val("");
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