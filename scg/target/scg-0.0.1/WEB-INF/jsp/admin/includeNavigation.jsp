<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">
		<a class="navbar-brand">관리자</a>
	</div>

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li>
					<a id="submitBtn" style="cursor:pointer;"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
					<form action="/logout" method="post" name="frm" id="frm">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</li>
			</ul>
		</li>
	</ul>

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li>
					<a href="#"><i class="fa fa-list fa-fw"></i> m 코드 관리</a>
					<ul class="nav nav-second-level">
						<li><a href="/admin/mission/missionAge">age</a></li>
						<li><a href="/admin/mission/missionGender">gender</a></li>
						<li><a href="/admin/mission/missionGrade">grade</a></li>
					</ul>
				</li>
				<li>
					<a href="/admin/mission/mission"><i class="fa fa-list fa-fw"></i> m 관리</a>
				</li>
			</ul>
		</div>
	</div>
</nav>