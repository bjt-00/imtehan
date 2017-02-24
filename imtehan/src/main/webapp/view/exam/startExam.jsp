<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Bundle List</title>
<jsp:include page="../structure/imports.jsp" />
</head>
<body>
<form:form commandName="examModel.exam" method="post" action="start.do" class="form-group">

	<div class="row" style="text-align:center">
		<span class="PageTitle">&nbsp; ${examModel.exam.title}</span>
	</div>
	<br>
	<div class="row" style="text-align:center">
		<label>Attend Question : 
		<span id="questionLimit">${examModel.exam.totalQuestions} </span> / ${examModel.exam.totalQuestions}
		<input type="range" name="questionsLimit" min="1" max="${examModel.exam.totalQuestions}" step="1" onchange="$('#questionLimit').html(this.value)" />
		</label>
	</div>
	<br>
	<div>
		<form:input type="text" class="form-control" path="testingId" placeholder="Testing ID" />
	</div>
	<br><br>
	<div>
		<form:input type="text" class="form-control" path="registrationId"  placeholder="Registration ID" />
	</div>
	<div class="row">&nbsp;</div>
	<div class="row" style="float:right">
		<a href=" <spring:url value="/qb/list.do"/>" class="btn btn-danger">
		 Cancel
		</a>
		 <button type="submit" class="btn btn-success pull-right" >Start Exam</button>
	</div>
</form:form>
</body>
</html>