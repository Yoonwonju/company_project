<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="company_project.ds.JdbcUtilJNDI" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX PAGE</title>
</head>
<body>
	<c:set var="con" value="${JdbcUtilJNDI.getConnection() }"></c:set>
	<c:out value="${con }"></c:out>
	<br><hr><br>
	<a href="TitleListHandler"><b>직책 목록</b></a>
	<br><hr><br>
	<a href="DeptListHandler"><b>부서 목록</b></a>
	<br><hr><br>
	<a href="EmpListHandler"><b>사원 목록</b></a>
</body>
</html>