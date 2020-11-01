<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서추가</title>
<link rel="stylesheet" href="css/emplist.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#add').on("click", function(){
			alert("추가");
			var newDept={
					deptNo:$('#deptNo').val(),
					deptName:$('#deptName').val(),
					floor:$('#floor').val()
			}
			$.ajax({
				type:"post",
				url:'DeptAddHandler',
				cache:false,
				data:JSON.stringify(newDept),
				complete:function(data){
					alert("추가되었습니다." + data);
					window.location.href="DeptListHandler";
				}
			})
		})
		
		$('#cancel').on("click", function(){
			alert("취소");
			window.location.href="DeptListHandler";
		})
	})
</script>
</head>
<body>
	<fieldset>
		<legend>부서추가</legend>
		<ul>
			<li>
				<label for="deptNo">부서번호</label>
				<input type="number" id="deptNo" value="${param.nextNo }" readonly>
			</li>
			<li>
				<label for="deptName">부&nbsp;&nbsp;서&nbsp;&nbsp;명</label>
				<input type="text" id="deptName" value="${deptName }">
			</li>
			<li>
				<label for="floor">위&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;치</label>
				<input type="number" id="floor" value="${floor }">
			</li>
			<button id="add">추가</button>
			<button id="cancel">취소</button>
		</ul>
		
	</fieldset>
</body>
</html>