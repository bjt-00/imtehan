<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Question Bundle Form - Title</title>
	<jsp:include page="../structure/imports.jsp"/>
</head>

<body>


<span class="PageTitle">&nbsp; Add a Question Bundle Form</span>

<div class="row">&nbsp;</div>


<fieldset>
<form:form modelAttribute="qborm" method="post" action="${action}.do">
<form:errors path="*" cssClass="alert alert-danger" element="div"/>

<div id="questionBundleInformation">
	
	<table class="table">
	    <tr>
	        <td>
	        	<b>Title: </b>
	        	<form:input class="form-control" placeholder="" path="title" type="text" />
	        </td>
	        <td>
	        	<b>Date : </b>
	        	<form:input class="form-control" placeholder="" path="date" type="text" />
	        </td>
	    </tr>
	    
	    <tr>
	        <td>
	        	<b>Type : </b> 
	        	<form:input class="form-control" placeholder="" path="type" type="text" />
	        </td>
	        <td>
	        	<b>Technology : </b> 
	        	<form:input class="form-control" placeholder="" path="technology" type="text" />
	        </td>
	    </tr>
	</table>
	
</div>


<div id="actionButtons">
		
		<a  href=" <spring:url value="/qb/list.do"/>" class="btn btn-danger">
		 Back
		</a>
		<a  href="#" >
		 <button id="btnAdd" type="submit" class="btn btn-primary" >${action}</button>
		</a>
		
        
</div>

</form:form>

</fieldset>

</body>
</html>