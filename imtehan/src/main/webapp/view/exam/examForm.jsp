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
<jsp:include page="../structure/imports.jsp"/>
</head>
<body>
<form:form commandName="examModel.orm" method="post" action="${action}.do" class="form-group">

<div class="row" style="text-align:center">
		<span class="PageTitle">&nbsp; ${examModel.exam.title}</span>
</div>
	<div class="row" style="text-align:center">
		Question ${examModel.currentIndex} / ${examModel.exam.totalQuestions}
	</div>

<br>

<div class="row" style="text-align:center">
<textarea rows="10" cols="40" id="question"  class="form-control" readonly="readonly">
	${examModel.orm.question}
</textarea>
</div>
<div class="row">
<fieldset>
	<legend>Options</legend>
		<ol>
				<c:forEach items="${examModel.orm.optionsList}" var="option" varStatus="i" >
						<li> 
						<label>
						 <form:checkbox path="optionsList[${i.index}].userAnswer" value="${option.userAnswer}" />
						 ${option.optionLabel}
						 </label>
						 <span class="glyphicons glyphicons-brightness-increase" title="Correct Answer is = ${option.correct}" onclick="$('#answer-${i.index}').html('${option.correct}')">Show Answer</span>
						 <span id="answer-${i.index}" style="color:green;font-weight:bold"></span>
						</li>
				</c:forEach>
		</ol>
</fieldset>
</div>

<div>

<div class="row" style="float:right">
<button type="submit" formaction="back.do" class="btn btn-outline-warning">Back</button>

<button type="submit" formaction="next.do" class="btn btn-outline-info">Next</button>
<button type="submit" formaction="result.do" class="btn btn-outline-info">Stop</button>

		<a  href=" <spring:url value="/qb/list.do"/>" class="btn btn-danger">
		 Cancel
		</a>

</div>
</div>
</form:form>
</body>
</html>