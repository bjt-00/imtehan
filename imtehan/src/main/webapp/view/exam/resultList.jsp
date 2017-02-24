<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Bundle List</title>
<jsp:include page="../structure/imports.jsp" />
</head>
<body>
	<div class="row" style="text-align:center">
		<span class="PageTitle">Examination Score Report</span>
		<p>Name</p>
		<p><label>Testing ID : </label>${examModel.exam.testingId}</p>
	</div>

	<div class="row" style="text-align:center">
		<span>${examModel.exam.title}</span>
	</div>
	<br>
	<div class="row">
		<div class="col-lg-4"><label>Exam Date : </label>${examModel.exam.date}</div>
		<div class="col-lg-4"><label>Registration ID : </label>${examModel.exam.registrationId}</div>
		<div class="col-lg-4"><label>Center ID : </label>Online</div>
	</div>
	<div class="row">
		<div class="col-lg-4"><label>Your Score : </label>${examModel.yourScore}</div>
		<div class="col-lg-4"><label>Passing Score : </label>${examModel.passingScore}</div>
		<div class="col-lg-4"><label>Result : </label>${examModel.result}</div>
	</div>
	<br>
	<div class="row">
<table id="questionList" class="table">
	<thead>
		<tr>
				<th>Sr.No</th>
				<th>Question</th>
				<th>Type</th>
				<th>Correct Answer</th>
				<th>Your Answer</th>
				<th>Result</th>			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${examModel.questionsList}" var="question" varStatus="i" >					
		    <tr>
			    <td> ${i.index+1}</td>
				<td> ${question.question}</td>
				<td> ${(question.type eq 'mcqzForm'?'MCQs':question.type)}</td>					
				<td> ${question.correctAnswers}</td>
				<td> ${question.userAnswers}</td>
				<td><span class="glyphicon glyphicon-${question.userAnswer?'ok':'remove'} ${question.userAnswer?'btn-success':'btn-danger'}"></span> </td>
		    </tr>	    
		</c:forEach>	    
	 </tbody>
 </table>
	
	</div>
	<div class="row">&nbsp;</div>
	<div class="row" style="float:right">
		<a href=" <spring:url value="/qb/list.do"/>" class="btn btn-danger">
		 Back
		</a>
		 <a class="btn btn-success" href="<spring:url value="/exam/welcome.do?id=${examModel.exam.questionBundleId}"/>" > Start Exam Again </a>
	</div>


</body>
</html>