<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作回馈界面</title>
</head>
<body>
		<c:choose>
			<c:when test="${'noLogin'==error }">
			<c:out value="error=${error}"></c:out>
				<h1>您还没有登录</h1>
			</c:when>
			<c:when test="${'errorMessage'==error }">
			<h1>您用户名或者密码错误</h1>
			</c:when>
			<c:when test="${'noUser'==error }">
			<h1>不存在该用户</h1>
			</c:when>
			<c:otherwise>
				<h1> 其他的未知错误</h1>
			</c:otherwise>
		</c:choose>
		<h1>
			<a href="login.jsp">点击返回登录</a>
		</h1>
</body>
</html>