<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Bundle List</title>
</head>
<body>

<span class="PageTitle">&nbsp; Question Bundles</span>

<div class="row">&nbsp;</div>

<div class="row">
<a  href=" <spring:url value="/qb/add.do"/>">
 <button id="addBundle" type="submit" class="btn btn-primary pull-right" >Add Bundle</button>
</a>
 </div>
<div class="row">&nbsp;</div>

	<table id='questionBundleList' class="table">
	<thead>
	<tr>		
		<th>Title</th>
		<th>Type</th>
		<th>Technology</th>
		<th>No of Qs</th>
		<th>Date</th>
		<th></th>
	</tr>	
	</thead>

	<tbody>
	<c:forEach var="b" items="${bundleList}">
		<tr>
			<td>${b.title}</td>
			<td>${b.type}</td>
			<td>${b.technology}</td>
			<td>${b.totalQuestions}</td>
			<td>${b.date}</td>
			<td> &nbsp;
				<a href="${pageContext.request.contextPath}/qb/edit.do?id=${b.questionBundleId}"   title="Edit Bundle"><span class="glyphicon glyphicon-pencil"></span></a>
				<a href="${pageContext.request.contextPath}/qb/delete.do?id=${b.questionBundleId}" title="Delete Bundle" ><span class="glyphicon glyphicon-trash"></span></a>
				<a href="${pageContext.request.contextPath}/q/list.do?qbid=${b.questionBundleId}"  title="Questions List"><span class="glyphicon glyphicon-plus-sign"></span></a>
				<a href="${pageContext.request.contextPath}/exam/welcome.do?id=${b.questionBundleId}" title="Begin Test" ><span class="glyphicon glyphicon-play-circle"></span></a>
			</td>
		</tr>
	</c:forEach>	
	</tbody>
	</table>	
<script>
$(document).ready(function() {
    $('#questionBundleList').DataTable();
} );
</script>


</body>
</html>