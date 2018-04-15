<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="jspf/head_config.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="jspf/head.jsp"%>
	<%@ include file="jspf/mainMenu.jsp"%>


	<form:form modelAttribute="user" method="POST">

		<div>
			<form:label path="email"></form:label>
			<form:input type="email" path="email" placeholder="email" />
			<form:errors path="email"></form:errors>

		</div>
		<div>
			<form:label path="password"></form:label>
			<form:password path="password" placeholder="password" />
			<form:errors path="password"></form:errors>

		</div>
		<div>
			<input type="submit" />
		</div>



	</form:form>
</body>
</html>