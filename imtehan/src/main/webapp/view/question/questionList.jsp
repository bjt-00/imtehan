<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
		<jsp:include page="../structure/imports.jsp"/>
	<title>Question List - Title </title>
	
	<script>
	$(document).ready(function() {
		$('.nav-collapse').collapse({
		  onShow: function(){
			$(this).html('Hide');//change the button label to be 'Hide'
		  },
		  onHide: function(){
			$(this).html('This is the Question');//change the button label to be 'Show'
		  }
		});
	});

	(function($) {
		$.fn.collapse=function(options){
		$(this).click(function(){
			//get collapse content selector
			var collapse_content_selector = $(this).attr('href');

			//make the collapse content to be shown
			var collapse_content = $(collapse_content_selector);
			if(collapse_content.hasClass('show')){
				collapse_content.removeClass('show');
				$(this).html('This is the Question');
				if(options && options.onHide){
					options.onHide();
				}
			}else{
				collapse_content.addClass('show');
				if(options && options.onShow){
					options.onShow();
				}
			}
		  });
		}
		}(jQuery));

		</script>
</head>


<body>

<span class="PageTitle">${qb.title}</span>
<p> <label>Type : </label> ${qb.type} 
|<label>Technology : </label> ${qb.technology} 
|<label>Total Questions : </label> ${qb.totalQuestions} 
|<label>Date : </label> ${qb.date}</p>
<div class="row">&nbsp;</div>

<div class="row">
		<a href=" <spring:url value="/q/add.do?qbid=${qbid}"/>" class="btn btn-primary pull-right">Add Question</a>&nbsp;
		<a href=" <spring:url value="/qb/list.do"/>" class="btn btn-danger pull-right">Back</a>  
 </div>
<div class="row">&nbsp;</div>

<fieldset>
<legend>Questions in the Bundle</legend>

<table id="questionList" class="table">
	<thead>
		<tr>
				<th>Sr.No</th>
				<th>Question</th>
				<th>Type</th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${questionList}" var="question" varStatus="i" >					
		    <tr>
			    <td> ${i.index+1}</td>
				<td> ${question.question}</td>
				<td> ${(question.type eq 'mcqzForm'?'MCQs':question.type)}</td>					
			    <td>
					<a href="<spring:url value="/q/edit.do?id=${question.questionId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
					<a href="${pageContext.request.contextPath}/q/delete.do?id=${question.questionId}"><span class="glyphicon glyphicon-trash"></span></a>
		        </td>
		    </tr>	    
		</c:forEach>	    
	 </tbody>
 </table>
</fieldset>

<section>
<div>

	 	 
</div>
</section>

<script>
$(document).ready(function() {
    $('#questionList').DataTable();
} );
</script>
</body>
</html>