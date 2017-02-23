<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript" src='<c:url value="/resources/scripts/add_options.js" />' ></script>
<script src='<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" />' ></script>

<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="qorm" method="post" action="${action}.do" class="form-group">
<form:errors path="*" cssClass="alert alert-danger" element="div"/>
		<input type="hidden" name="type" value="${qorm.type}">
		<input type="hidden" name="questionBundleId" value="${qorm.questionBundleId}" >
		<input type="hidden" id="questionId" name="questionId" value="${qorm.questionId}" >
		<input type="hidden" name="action" value="${action}"> 
		<div class="form-group">
			<label for="question" >Question : </label>
			<form:textarea rows="6" cols="40" id="question" path="question" class="form-control"/>
		</div>
		
		<div class="row">
			<a  href="#" >
			 <button id="btnAddOption" type="submit" class="btn btn-default pull-right" formaction="addOption.do" ><span class="glyphicon glyphicon-plus"></span>Add Option</button>
			</a>
			
		</div>

			 <div class="row">
				<div class="col-lg-11">Option Label</div>	
				<div class="col-lg-1">T/F</div>
			</div>


		<c:forEach items="${qorm.optionsList}" var="option" varStatus="i" >
			 <div class="row" id="option-${i.index}">
				<div class="col-lg-11">
				<form:input type="text" id="option-${i.index}-text" path="optionsList[${i.index}].optionLabel" class="form-control"  /> 
				</div>	
				<div class="col-lg-1">
				<form:checkbox path="optionsList[${i.index}].correct" value="${option.correct}" />
					<span class="glyphicon glyphicon-trash" onclick="$('#option-${i.index}').fadeOut();$('#option-${i.index}-text').val('');" ></span>
				</div>
			</div>
		</c:forEach>

		<div id="optionList" class="row">
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<a  href=" <spring:url value="/q/list.do?qbid=${qorm.questionBundleId}"/>" class="btn btn-danger">
			 Back
			</a>
			<a  href="#" >
			 <button id="btnAdd" type="submit" class="btn btn-primary" >${action}</button>
			</a>
		</div>
</form:form>	
</body>
</html>