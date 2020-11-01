<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보</title>
<link rel="stylesheet" href="css/emplist.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var status = false;
		
		$('#modify').on("click", function(){
			alert("수정");
			if(!status){
				$('input#deptName').attr('readonly', false);
				$('input#floor').attr('readonly', false);
				status=true;
			}else{
				var dept={
						deptNo: $('#deptNo').val(),
						deptName: $('#deptName').val(),
						floor: $('#floor').val()};
				$.ajax({
					type:"post",
					url:"DeptModifyHandler",
					data:JSON.stringify(dept),
					success:function(data){
						alert(data);
						if(data == 1)
							window.location.href="DeptListHandler";
					}
				})
			}
		})
		
		$('#delete').on("click", function(){
			alert("삭제");
			var delDept = {deptNo:$('#deptNo').val()}
			$.ajax({
				type:"get",
				url:"DeptDeleteHandler",
				data:delDept,
				success:function(data){
					alert(data);
					if(data == 1){
						alert("삭제되었습니다.");
						window.location.href="DeptListHandler";
					}
				}
			})
		})
		
		$('#list').on("click", function(){
			alert("목록");
			window.location.href="DeptListHandler";
		})
	})

</script>
</head>
<body>
	<fieldset>
		<legend>부서 정보</legend>
		<ul>
			<li>
				<label for="deptNo">부서번호</label>
				<input type="number" id="deptNo" name="deptNo" value="${dept.deptNo }" readonly>
			</li>
			<li>
				<label for="deptName">부서명</label>
				<input type="text" id="deptName" name="deptName" value="${dept.deptName }" readonly>
			</li>
			<li>
				<label for="floor">위치</label>
				<input type="number" id="floor" name="floor" value="${dept.floor }" readonly>
			</li>
		</ul>
		<button id="modify">수정</button>
		<button id="delete">삭제</button>
		<button id="list">목록</button>
	</fieldset>
</body>
</html>