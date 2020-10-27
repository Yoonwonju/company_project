<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책목록</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#addTitle').on("click", function(){
			alert("직책 추가 버튼 클릭");
			$.ajax({
				type:"get",
				url:"TitleAddHandler",
				success:function(data){
					alert("data --> " + data);
					window.location.href="titleAdd.jsp?nextNo="+data;
				}
			})
		})
	})

</script>
</head>
<body>
${list }<hr>
	<h2>직책목록</h2>
	<table border=1>
		<thead>
			<td>직책 번호</td>
			<td>직책명</td>
		</thead>
		<tbody>
			<c:forEach var="title" items="${list }">
				<tr>
					<td>${title.titleNo } </td>
					<td><a href="TitleGetHandler?titleNo=${title.titleNo }"> ${title.titleName } </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="addTitle">직책 추가</button>
</body>
</html>