<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
 $(function(){
	 $.post("TitleListHandler", function(json){
		 var dataLength = json.length;
		 if(dataLength >= 1){
			 var sCont = "";
			 for(i = 0; i < dataLength; i++){
				 sCont += "<option value=" + json[i].titleNo + ">" + json[i].titleName + "</>"
			 }
			 $("#title").append(sCont);
		 }
	 })
	 
	 $.post("DeptListHandler", function(json){
		 var dataLength = json.length;
		 if(dataLength >= 1){
			 var sCont = "";
			 for(i = 0; i < dataLength; i++){
				 sCont += "<option value=" + json[i].deptNo + ">" + json[i].deptName + "</>"
			 }
			 $("#dept").append(sCont);
		 }
	 })
	 
	 $('#addEmp').on("click", function(){
		 self.location = "empAdd.jsp";
	 })
	 
	 $.post("EmpListHandler", function(json){
		 var dataLength = json.length
		 if(dataLength >= 1){
			 var sCont = "";
			 for (i = 0; i < dataLength; i++){
				 sCont += "<tr>";
				 sCont += "<td>" + json[i].empNo + "</td>";
				 sCont += "<td>" + json[i].empName + "</td>"; 
				 sCont += "<td>" + json[i].title.titleName + "(" + json[i].title.titleNo + ")</td>";
				 if(json[i].manager.empNo != null){
					 sCont += "<td>" + json[i].manager.empNo + "(" + json[i].manager.empNo + ")</td>"
				 };
				 sCont += "<td>" + json[i].salary + "</td>"; 
				 sCont += "<td>" + json[i].dept.deptName + "(" + json[i].dept.deptNo + ")</td>";
				 sCont += "<td>" + json[i].regDate + "</td>"
				 sCont += "<td>" + json[i].email + "</td>"
				 sCont += "<td>" + json[i].tel+ "</td>"
				 sCont += "</tr>"
			 }
			 /* $("table > tbody:last-child").append(sCont);    */
	         $("#load:last-child").append(sCont);
		 }
	 })
 })
</script>
<link rel="stylesheet" href="css/emplist.css">
</head>
<body>
${list }<hr>
	<label for="title">직책</label><select id="title"></select>
	<label for="dept">부서</label><select id="dept"></select>
	<h2>사원목록</h2>
	<table>
		<thead>
			<td>사원번호</td>
			<td>사원명</td>
			<td>사원직책</td>
			<td>직속상사</td>
			<td>급여</td>
			<td>부서</td>
			<td>입사일</td>
			<td>이메일</td>
			<td>연락처</td>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list }">
				<tr>
					<td>${emp.empNo } </td>
					<td><a href="EmpGetHandler?empNo=${emp.empNo }">${emp.empName } </a></td>
					<td>${emp.title.titleName }(${emp.title.titleNo }) </td>
					<td>${emp.manager.empName }(${emp.manager.empNo }) </td>
					<td>${emp.salary } </td>
					<td>${emp.dept.deptName }(${emp.dept.deptNo }) </td>
					<td><fmt:formatDate value="${emp.regDate }" pattern="yyyy년 MM월 dd일"/> </td>
					<td>${emp.email } </td>
					<td>${emp.tel } </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="addEmp">사원추가</button>
</body>
</html>