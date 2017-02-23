<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp" %>

<jsp:include page="structure/header.jsp"/>
<div class="container Contents">
	<div class="row">&nbsp;</div>

			<jsp:include page="structure/alert.jsp"/>

			<jsp:include page="${(not empty view ?view:'welcome')}.jsp"/>
</div>
<jsp:include page="structure/footer.jsp"/>

	