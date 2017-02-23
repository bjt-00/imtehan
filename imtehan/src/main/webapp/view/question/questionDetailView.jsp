<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question Detail View</title>
</head>
<body>


<p> QuestionID : ${question.questionId}</p>
<p> QuestionBundle ID : ${question.questionBundleId}</p>
<p> Question Text : ${question.question}</p>
<p> Question Type : ${question.type}</p>
<%-- <p> ${question.isTrue}</p>
<p> ${question.isFalse}</p>
<p> ${question.options}</p> --%>

<p>
<a  href=" <spring:url value="/question/list"/>">
 	<button id="addBundle" type="submit"class="btn btn-danger" >BackToQuesitonBundleList</button>
</a>
</p>


</body>

</html>