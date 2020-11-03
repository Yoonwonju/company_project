<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원추가</title>
<link rel="stylesheet" href="css/emplist.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post('TitleListHandler', function(json){
			var dataLength = json.length;
			if(dataLength >= 1){
				var sCont = "";
				sCont += "<option value='' disabled selected hidden>직책을 선택하세요!</option>";
				for(i = 0; i < dataLength; i++){
					sCont += "<option value=" + json[i].titleNo + ">" + json[i].titleName + "</>";
				}
				$("#title").append(sCont);
			}
		})
		
		$.post('DeptListHandler', function(json){
			var dataLength = json.length;
			if(dataLength >= 1){
				var sCont = '';
				sCont += "<option value='' disabled selected hidden>부서를 선택하세요!</option>";
				for(i = 0; i < dataLength; i++){
					sCont += "<option value=" + json[i].deptNo + ">" + json[i].deptName + "</>";
				}
				$("#dept").append(sCont);
			}
		})
		
		var isEmpNoCheck = false;
		$('#empNoDupCheck').on('click', function(){
			alert($('#empNo').val());
			var emp = {empNo:$('#empNo').val()};
			$.post('DuplicateEmpNoCheckHandler', emp, function(data){
				if(data == 1){
					alert("사용가능한 사원번호");
					isEmpNoCheck = true;
				}else{
					alert("사원번호 중복");
					$('#empNo').val('');
					$('#empNo').focus();
				}
			})
		})
		
		$('#dept').on('change', function(){
			alert($('#dept').val());
			$('#manager').empty();
			var dept = {deptNo:$('#dept').val()};
			$.get('EmpManagerListHandler', dept, function(json){
				var dataLength = json.length;
				if(dataLength >= 1){
					var sCont = "";
					for(i = 0; i < dataLength; i++){
						sCont += "<option value=" + json[i].empNo + ">" + json[i].empName + "</>";
					}
					$('#manager').append(sCont);
				}
			})
		})
		
		$('#cancel').on('click', function(){
			alert("취소");
			window.location.href="EmpListHandler";
		})
		
		$('#add').on('click', function(){
			alert("추가");
			if($('#passwd').val() != $('#repasswd').val()){
				alert("비밀번호가 일치하지 않습니다.");
				$('#passwd').val('');
				$('#repasswd').val('');
				$('#passwd').focus();
				return;
			}
			if(!isEmpNoCheck){
				alert("중복체크 하세요!");
				return;
			}
			
			var newEmp={
					empNo:$('#empNo').val(),
					empName:$('#empName').val(),
					title:{titleNo:$('#title').val()},
					manager:{empNo:$('#manager').val()},
					salary:$('#salary').val(),
					dept:{deptNo:$('#dept').val()},
					regDate:$('#regDate').val(),
					email:$('#email').val(),
					tel:$('#tel').val(),
					passwd:$('#passwd').val()
			}
			
			$.ajax({
				type:"post",
				url:"EmpAddHandler",
				cache:false,
				data:JSON.stringify(newEmp),
				complete:function(data){
					alert("추가되었습니다." + data);
					window.location.href="EmpListHandler";
				}
			})
		})
		
	})
</script>
</head>
<body>
	<fieldset>
		<legend>사원추가</legend>
		<ul>
			<li>
				<label for="empNo">사원번호</label>
				<input type="number" id="empNo" >
				<button id="empNoDupCheck">중복체크</button>
			</li>
			<li>
				<label for="empName">사 &nbsp;원 &nbsp;명</label>
				<input type="text" id="empName" name="empName">
			</li>
			<li>
				<label for="dept">부 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서</label>
				<select id="dept" name="dept"></select>
			</li>
			<li>
				<label for="manager">직속상사</label>
				<select id="manager" name="manager"></select>
			</li>
			<li>
				<label for="title">직 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;책</label>
				<select id="title" name="title"></select>
			</li>
			<li>
				<label for="salary">급 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;여</label>
				<input type="number" id="salary" name="salary">
			</li>			
			<li>
				<label for="regDate">입사일자</label>
				<input type="date" id="regDate" name="regDate">
			</li>			
			<li>
				<label for="email">이 &nbsp;메 &nbsp;일</label>
				<input type="email" id="email" name="email">
			</li>
			<li>
				<label for="tel">연 &nbsp;락 &nbsp;처</label>
				<input type="tel" id="tel" name="tel">
			</li>
			<li>
				<label for="password">비밀번호</label>
				<input type="password" id="passwd" name="passwd">
			</li>			
			<li>
				<label for="repasswd">비밀번호</label>
				<input type="password" id="repasswd" name="repasswd">
			</li>			
				<button id="add">추가</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="cancel">취소</button>
		</ul>		
	</fieldset>
</body>
</html>