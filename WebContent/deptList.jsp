<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
<link rel="stylesheet" href="css/emplist.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#addDept').on("click", function(){
			alert("직책 추가 버튼 클릭");
			$.ajax({
				type:"get",
				url:"DeptAddHandler",
				success:function(data){
					alert("data --> " + data);
					window.location.href="deptAdd.jsp?nextNo=" + data;
				}
			})
		})
		
	})
</script>
</head>
<body>
${list }<hr>
<h2>부서목록</h2>
	<table border=1>
		<thead>
			<td>부서번호</td>
			<td>부서명</td>			
			<td>부서위치</td>			
		</thead>
		<tbody>
			<c:forEach var="dept" items="${list }">
				<tr>
					<td>${dept.deptNo }</td>
					<td><a href="DeptGetHandler?deptNo=${dept.deptNo}">${dept.deptName }</a></td>
					<td><a href="DeptGetHandler?deptNo=${dept.deptNo}">${dept.floor }</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="addDept">부서추가</button>
</body>
</html>