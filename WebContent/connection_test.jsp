<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="company_project.ds.JdbcUtilJNDI" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연결 테스트</title>
</head>
<body>
	<c:set var="con" value="<%=JdbcUtilJNDI.getConnection() %>"></c:set>
	<c:out value="${con }"/>
</body>
</html>