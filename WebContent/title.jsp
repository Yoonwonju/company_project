<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책정보</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var status = false;
		
		$('#modify').on("click", function(){
			alert("수정");
			if(!status){										// 수정할수 없는 상태면 if 코드실행
				$('input#titleName').attr("readonly", false);	// titleName의 상태가 수정할수있게 false로 상태변경
				status = true;									// 수정할수있는 상태로 변경
			}else{
				var title = {
						titleNo:$('#titleNo').val(),
						titleName:$('#titleName').val()}		// 타이핑한값이 titleNo, titleName에 저장
				$.ajax({
					type:"post",
					url:"TitleModifyHandler",
					data:JSON.stringify(title),
					success:function(data){
						alert(data);
						if(data == 1)
							window.location.href="TitleListHandler";
					}
				})
			}
		})
		
		$('#delete').on("click", function(){
			alert("삭제");
			var delTitle = {
					titleNo:$('#titleNo').val()
			}
			$.ajax({
				type:"get",
				url:"TitleDeleteHandler",
				data:delTitle,
				success:function(data){
					alert(data);
					if(data == 1){
						alert(data + "삭제 되었습니다.");
						window.location.href="TitleListHandler";
					}
				}
			})
		})
		
		$('#list').on("click", function(){
			alert("목록");
			window.location.href="TitleListHandler";
		})
		
		
	})
</script>
</head>
<body>
${title }<hr>
	<fieldset>
		<legend>직책정보</legend>
		<ul>
			<li>
				<label for="titleNo">직책 번호</label>
				<input id="titleNo" type="number" name="titleNo" value="${title.titleNo }" readonly>
			</li>
			<li>
				<label for="titleName">직책 이름</label>
				<input id="titleName" type="text" name="titleName" value="${title.titleName }" readonly>
			</li>
			<li>
				<button id="modify">수정</button>
				<button id="delete">삭제</button>
				<button id="list">목록</button>				
			</li>
		</ul>
	</fieldset>
</body>
</html>