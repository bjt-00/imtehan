<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1" %>
<%@ page isErrorPage="true" %>

<jsp:include page="structure/header.jsp"/>
<div class="row">&nbsp;</div>
<div class="row Body">
    <div class="col-lg-2"> </div>
	<div class="col-lg-8">
		<h1 class="PageTitle">Error Page</h1>
		<p>Please check your internet connection. All other errors will be auto reported to dev team, for immediate assistance you can contact tech lead : 872-222-3435</p>
		<p>
			<u>Message:</u></p>
			<font color="red">
			<%=(null != exception ?exception.getMessage():"")%>
			</font>
			<p>
			<u>Exception:</u></p>
			<font color="red">
			<%=(null != exception ?exception.getStackTrace():"")%>
			</font>
	</div>
	<div class="col-lg-2"> </div>
</div>

<jsp:include page="structure/footer.jsp"/>
	