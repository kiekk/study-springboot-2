<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	<style>
		#key, #checkSMS {
			display:none;
		}
		
	</style>
</head>
<body>
	<!-- Header -->
	<%@ include file="../include/header.jsp" %>
	
	<form method="post" name="joinForm" action="/user/signup" style="margin: 0 auto; width: 60%;" onSubmit="return false;">
		<input type="hidden" id="phoneCheck" value="true" />
		<input type="hidden" id="idCheck" value="false" />		
		<h3>SignUp</h3>
		<div class="row gtr-uniform">
			<div class="col-12">
				<div>아이디</div>
				<input type="text" name="id" id="id" value="" placeholder="Id" onkeyup="checkId(this.value)" onchange="checkId(this.value)"/>
				<button id="check_id">중복 확인</button>
				<div id="id_result"></div>
			</div>
			<div class="col-12">
				<div>비밀번호</div>
				<input type="password" name="password" id="password" value="" placeholder="Password" />
			</div>
			<div class="col-12">
				<div>이름</div>
				<input type="text" name="name" id="name" value="" placeholder="Name" />
			</div>
			<div class="col-12">
				<div>전화번호</div>
				<input type="text" name="phone" id="phone" value="" placeholder="Phone-Number" />
				<button id="sendSMS">인증번호 요청하기</button>
				<input type="text" name="key" id="key" value="" placeholder="인증번호를 입력하세요."/>
				<button id="checkSMS">인증</button>
				<div id="result"></div>
			</div>
			<div class="col-12">
				<div>이메일</div>
				<input type="text" name="email" id="email" value="" placeholder="Email" />
			</div>
			<!-- 주소와 우편번호를 입력할 <input>들을 생성하고 적당한 name과 class를 부여한다 -->
			<div class="col-12">
				<div>우편번호</div>
				<input type="text" id="zipcode" name="zipcode" class="postcodify_postcode5" value="" readonly/>
				<button id="postcodify_search_button">검색</button><br />
			</div>
			<div class="col-12">
				<div>주소</div>
				<input type="text" id="address" name="address" class="postcodify_address" value="" readonly/><br />
			</div>
			<div class="col-12">
				<div>상세주소</div>
				<input type="text" id="address_detail" name="address_detail" class="postcodify_details" value="" /><br />
			</div>
			<div class="col-12">
				<div>참고항목</div>
				<input type="text" id="address_etc" name="address_etc" class="postcodify_extra_info" value="" readonly/><br />
			</div>
		</div>
		<a href="/user/login">로그인 페이지로 이동</a>
		<ul class="actions" style="margin-top: 20px;">
			<li><a href="javascript:onSubmit()" class="button primary">회원가입</a></li>
			<li><a href="/" class="button">취소</a></li>
		</ul>
	</form>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>
	
	<!-- Scripts -->
	<%@ include file="../include/src.jsp" %>
</body>
<script src="/resources/assets/js/join.js"></script>
<script>
	/*
	기능 확인 완료, 주석처리 phoneCheck는 true로 변경
	$("#sendSMS").on("click", function(e){
		e.preventDefault();
		//console.log("제이쿼리 입력");
		var phone = document.getElementById("phone");
		console.log("인증 클릭 : " + phone.value);
		phone.setAttribute("readonly", "");
		this.style.display = "none";
		document.getElementById("key").style.display = "block";
		document.getElementById("checkSMS").style.display = "block";
		
		//전화번호 정규식으로 검사
		var key = "";
		$.ajax({
			url: "/phone/checkSMS",
			data: phone.value,
			contentType: "application/json;charset=utf-8",
			type: "POST",
			success: function(data){
				key = data;
				console.log("Data : " + key);
			}
		});
		
		$("#checkSMS").on("click",function(e){
			e.preventDefault();
			
			var input = document.getElementById("key");
			var result = document.getElementById("result");
			
			console.log(input.value);
			if(key == input.value){
				result.textContent = "인증 성공";
				input.style.display = "none";
				this.style.display = "none";
				document.getElementById("phoneCheck").value = "true";
			} else {
				result.textContent = "인증 실패";
				document.getElementById("phoneCheck").value = "false";
			}
		});
	});
	*/
	
	$("#check_id").on("click", function(e){
		e.preventDefault();
		
		var id = document.getElementById("id");
		var result = document.getElementById("id_result");
		var check = document.getElementById("idCheck");
		
		if(id.value == "" || id.value == null){
			alert("아이디를 입력하세요.");
			id.focus();
			return false;
		}
		console.log(id.value);
		
		checkId(id.value);
	});
	
</script>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</html>