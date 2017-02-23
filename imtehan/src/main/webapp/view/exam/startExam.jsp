<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Bundle List</title>
<jsp:include page="../structure/imports.jsp" />
</head>
<body>
	<div class="row" style="text-align:center">
		<span class="PageTitle">&nbsp; ${examModel.exam.title}</span>
	</div>
	<br>
	<div class="row" style="text-align:center">
		Attend Question <input type="text" placeholder="${examModel.totalQuestions}" size="4" /> / ${examModel.totalQuestions}
	</div>
	<br>
	<br>

	<div class="row" style="text-align:center">
		<label><input type="checkbox" name="timer"> Use Timer</label><span>
		</span>
		<!--  5 mints<input type="range" name="points" min="0" max="10" size="20" />120 mints-->
     <label><input type="checkbox" name="shuffle" > Shuffle Question Order</label><span> </span>
 
	</div>
	<div>
		<input type="text" class="form-control" placeholder="exam ID" />
	</div>
	<br><br>
	<div>
		<input type="text" class="form-control" placeholder="User ID" />
	</div>
	<div class="row">&nbsp;</div>
	<div class="row" style="float:right">
		<a href=" <spring:url value="/qb/list.do"/>" class="btn btn-danger">
		 Cancel
		</a>
		 <a class="btn btn-success" href="<spring:url value="/exam/start.do"/>" > start </a>
	</div>


</body>
</html>