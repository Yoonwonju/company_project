<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var status = false;
		
		$('#modify').on('click', function(){
			alert("수정");
			if(!status){
				$('input').each(function(index, value){
					$(this).attr("readonly", false);
					console.log($(this));
				})
				$('#empNo').attr("readonly", true);
				$('select').each(function(){
					$(this).prop("disabled", false);
				})
				status = true;
			}else{
				if($('#passwd').val() != $('#repasswd').val()){
					alert("비밀번호가 일치하지 않습니다.");
					$('#passwd').val('');
					$('#repasswd').val('');
					$('#passwd').focus();
				}
				var updateEmp={
						empNo:$('#empNo').val(),
						empName:$('#empName').val(),
						dept:{deptNo:$('#dept').val()},
						manager:{empNo:$('#manager').val()},
						title:{titleNo:$('#title').val()},
						salary:$('#salary').val(),
						regDate:$('#regDate').val(),
						email:$('#email').val(),
						tel:$('#tel').val(),
						passwd:$('#passwd').val()
				}
				$.ajax({
					type:"post",
					url:"EmpModifyHandler",
					data:JSON.stringify(updateEmp),
					success:function(data){
						alert("data");
						if(data == 1){
							window.location.href="EmpListHandler";
						}
					}
				})
			}
		});
		
/* 		$.post("DeptListHandler", function(json){
			var deptSelected = ${emp.dept.deptNo};
			var dataLength = json.length;
			if(dataLength >= 1){
				var sCont = "<option value='' disabled selected hidden>부서를 선택하세요! </option>";
				for(i = 0; i < dataLength; i++){
					sCont += "<option value=" + json[i].deptNo;
					if(deptSelected == json[i].deptNo){
						sCont += " selected ";
					}
					sCont += ">" + json[i].deptName + "</>";
				}
				$('#dept').append(sCont);
			}
		})
		
		$.post("EmpManagerListHandler", function(json){
			var dataLength = json.length;
			var managerNo = ${emp.manager.empNo};
			if(dataLength >= 1){
				var sCont = "<option value='' disabled selected hidden>직속상사를 선택하세요! </option>";
				if(i = 0; i < dataLength; i++){
					sCont += "<option value=" + json[i].empNo;
					if(managerNo == json[i].empNo){
						sCont += " selected ";
					}
					sCont += ">" + json[i].empName + "</>";
				}
				${'#manager'}.append(sCont);
			}
		}) */
		
		
		
		
/* 		$.post("TitleListHandler", function(json){
			var titleSelected = ${emp.title.titleNo};
			var dataLength = json.length;
			if(dataLength >= 1){
				var sCont="";
				sCont += "<option value='' disabled selected hidden>직책을 선택하세요! </option>";
				for(i = 0; i < dataLength; i++){
					sCont += "<option value=" + json[i].titleNo;
					if(titleSelected == json[i].titleNo){
						sCont += " selected ";
					}
					sCont += ">" + json[i].titleName + "</>";
				}
				$('#title').append(sCont);
			}
		}) */
		
		$('#dept').on('change', function(){
			alert($('#dept').val());
			var selectedManager = ${emp.manager.empNo};
			
			$('#manager').empty();
			var dept = {deptNo:$('#dept').val()};
			
			$.get('EmpManagerListHandler', dept, function(json){
				var dataLength = json.length;
				if(dataLength >= 1){
					alert(data);
					var sCont="";
					for(i = 0; i < dataLength; i++){
						sCont += "<option value=" + json[i].empNo;
						if(selectManager == json[i].empNo){
							sCont += " selected ";
						}
						sCont += ">" + json[i].empName + "</>";
					}
					$("#manager").append(sCont);
				}
			})
		})
		
		$('#list').on('click', function(){
			alert("목록");
			window.location.href="EmpListHandler";
		})
		
		$('#delete').on('click', function(){
			alert("삭제");
			var delEmp = {empNo:$('#empNo').val()}
			$.ajax({
				type:"get",
				url:"EmpDeleteHandler",
				data:delEmp,
				success:function(data){
					alert("data");
					if(data == 1){
						alert("삭제 되었습니다.");
						window.location.href="EmpListHandler";
					}
				}
			})
		})
	})
</script>
</head>
<body>
${emp }<hr>
	<fieldset>
		<legend>사원추가</legend>
		<ul>
			<li>
				<label for="empNo">사원번호</label>
				<input type="number" id="empNo" value="${emp.empNo }" readonly>
			</li>
			<br>
			<li>
				<label for="empName">사&nbsp; 원&nbsp; 명</label>
				<input type="text" id="empName" value="${emp.empName }" readonly>
			</li>
			<br>
			<li>
				<label for="dept">부&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서</label>
				<select id="dept" name="dept" disabled="disabled"></select>
			</li>
			<br>
			<li>
				<label for="manager">직속상사</label>
				<select id="manager" name="manager" disabled="disabled"></select>
			</li>
			<br>
			<li>
				<label for="title">직&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;책</label>
				<select id="title" name="title" disabled="disabled"></select>
			</li>
			<br>
			<li>
				<label for="salary">급&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;여</label>
				<input type="number" id="salary" value="${emp.salary }" readonly>
			</li>
			<br>
			<li>
				<label for="regDate">입사일자</label>
				<input type="date" id="regDate" value="${emp.regDate }" readonly>
			</li>
			<br>
			<li>
				<label for="email">이 &nbsp;메 &nbsp;일</label>
				<input type="email" id="email" value="${emp.email }" readonly>
			</li>
			<br>
			<li>
				<label for="tel">연 &nbsp;락 &nbsp;처</label>
				<input type="tel" id="tel" value="${emp.tel }" readonly>
			</li>
			<br>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" id="passwd">
			</li>
			<br>
			<li>
				<label for="repasswd">비밀번호</label>
				<input type="password" id="repasswd">
			</li>
			<br>
			
			
				<button id="modify">수정</button>
				<button id="delete">삭제</button>
				<button id="list">목록</button>	
		</ul>
	
	</fieldset>
</body>
</html>