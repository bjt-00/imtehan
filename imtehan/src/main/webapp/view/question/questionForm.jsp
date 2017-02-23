<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../structure/imports.jsp" />
</head>
<body>
<span class="PageTitle">&nbsp;${action eq 'save'?'Add':'Edit'} Question</span>

<div class="row">&nbsp;</div>

	
			<form action="questionType.do" method="post" style="display:${action eq 'update'?'none':'' }">
			<input type="hidden" name="id" value="${qorm.questionId}" >
				<div class="form-group">
					<label for="type" >Question Type :</label> 
					<select name="type" onchange="submit()" class="form-control">
							<option value="mcqzForm"  ${qorm.type eq 'mcqzForm'?"selected='selected'":'' }>mcqzForm</option>
					</select>
				</div>
			</form>
			
			<jsp:include page="${(qorm.type eq null?'mcqzForm':qorm.type)}.jsp"/>
</body>
</html>