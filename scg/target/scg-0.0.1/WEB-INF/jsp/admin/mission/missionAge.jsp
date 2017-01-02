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
				<h4 class="page-header">m age 관리</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
	
					<div class="panel-heading">
						<i class="fa fa-list"></i> m age 목록
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>age</label>
									<input id="age" class="form-control" maxlength="2">
								</div>
								<div class="form-group">
									<label>from</label>
									<input id="agefrom" class="form-control" maxlength="2">
								</div>
								<div class="form-group">
									<label>to</label>
									<input id="ageto" class="form-control" maxlength="2">
								</div>
							</div>
							<div class="col-lg-8">
								<button type="button" class="btn btn-primary" id="btnWrite">추가 / 수정</button>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped" id="missionAgeList">
								<thead>
								<tr>
								<th>Age</th>
								<th>from</th>
								<th>to</th>
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
	$.getMissionAgeList();
});

$.getMissionAgeList = function() {
	$.ajax({
		url     : "/api/missionAge",
		type    : "GET",
		success : function(jsonData) {
			$.displayMissionAgeList(jsonData);
		},
		error   : function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
};

$.displayMissionAgeList = function(jsonData) {

	$("#missionAgeList > tbody").empty();

	var tr = "";

	for (var i in jsonData) {
		tr  = "";
		tr += "<tr>";
		tr += "<td>" + jsonData[i].age     + "</td>";
		tr += "<td>" + jsonData[i].agefrom + "</td>";
		tr += "<td>" + jsonData[i].ageto   + "</td>";
		tr += "<td>";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.modifyAge(\""+jsonData[i].age+"\", \""+jsonData[i].agefrom+"\", \""+jsonData[i].ageto+"\");'><i class='glyphicon glyphicon-pencil'></i> 수정</button>&nbsp;&nbsp;";
		tr += "<button type='button' class='btn btn-primary btn-xs' onclick='$.deleteAge(\""+jsonData[i].age+"\");'><i class='glyphicon glyphicon-remove'></i> 삭제</button>";
		tr += "</td>";
		tr += "</tr>";

		$("#missionAgeList > tbody:last-child").append(tr);
	}
};

$("#btnWrite").click(function() {
	if ($("#age").val() == "" || $("#agefrom").val() == "" || $("#ageto").val() == "") {
		alert("다 입력하세요.");
		return;
	}

	var formData = new FormData();
	formData.append("age",     $("#age").val());
	formData.append("agefrom", $("#agefrom").val());
	formData.append("ageto",   $("#ageto").val());

	$.ajax({
		url         : "/api/missionAge",
		data        : formData,
		type        : "POST",
		contentType : false,
		processData : false,
		beforeSend  : function(xhr) {
			xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
		},
		success     : function(jsondata) {
			alert("저장하였습니다.");
			$.getMissionAgeList();
			$("#age").val("");
			$("#agefrom").val("");
			$("#ageto").val("");
		},
		error       : function (jqXHR, textStatus, errorThrown) {
			alert("[" + jqXHR.status + "] " + errorThrown);
		}
	});
});

$.modifyAge = function(age, agefrom, ageto) {
	$("#age").val(age);
	$("#agefrom").val(agefrom);
	$("#ageto").val(ageto);
};

$.deleteAge = function(age) {
	if (confirm("삭제하시겠습니까?")) {
		$.ajax({
			url         : "/api/missionAge/" + age,
			type        : "DELETE",
			beforeSend  : function(xhr) {
				xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
			},
			success     : function(jsondata) {
				alert("삭제하였습니다.");
				$.getMissionAgeList();
				$("#age").val("");
				$("#agefrom").val("");
				$("#ageto").val("");
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