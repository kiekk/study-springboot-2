/**
 * 회원가입 관련 스크립트
 */

function onSubmit(){
	var form = document.joinForm;
	var id = document.getElementById("id");
	var idCheck = document.getElementById("idCheck");
	var phoneCheck = document.getElementById("phoneCheck");
	var password = document.getElementById("password");
	var name = document.getElementById("name");
	var phone = document.getElementById("phone");
	var email = document.getElementById("email");
	var zipcode = document.getElementById("zipcode");
	var address = document.getElementById("address");
	var address_detail = document.getElementById("address_detail");
	var address_etc = document.getElementById("address_etc");
	
	if(id.value == "" || id.value == null){
		alert("아이디를 입력하세요.");
		id.focus();
		return false;
	}
	if(idCheck.value == "false"){
		alert("중복확인을 체크해주세요");
		id.focus();
		return false;
	}
	if(password.value == "" || password.value == null){
		alert("비밀번호를 입력하세요.");
		password.focus();
		return false;
	}
	if(name.value == "" || name.value == null){
		alert("이름을 입력하세요.");
		name.focus();
		return false;
	}
	if(phone.value == "" || phone.value == null){
		alert("전화번호를 입력하세요.");
		phone.focus();
		return false;
	}
	if(phoneCheck.value == "false"){
		alert("핸드폰 인증을 해주세요.");
		phone.focus();
		return false;
	}
	if(email.value == "" || email.value == null){
		alert("이메일을 입력하세요.");
		email.focus();
		return false;
	}
	
	form.submit();
	
}


/**
 * 중복 확인
 */
function checkId(id) {
	
	var result = document.getElementById("id_result");
	var check = document.getElementById("idCheck");
	
	$.ajax({
		url: "/user/checkId",
		type : "POST",
		contentType: "application/json;charset=utf-8",
		data : id,
		success : function(data){
			console.log(data);
			
			if(data == "success"){
				result.textContent = "사용 가능한 아이디입니다.";
				check.value = "true";					
			}else {
				result.textContent = "이미 등록된 아이디입니다.";
				check.value = "false";					
			}
		},
		error : function() {
			alert("요청 실패");
		}
	});
}

/**
 * 로그인
 */
function login(){
	var form = document.loginForm;
	var id = document.getElementById("id");
	var password = document.getElementById("password");
	
	if(id.value == "" || id.value == null){
		alert("아이디를 입력하세요.");
		id.focus();
		return false;
	}
	if(password.value == "" || password.value == null){
		alert("비밀번호를 입력하세요.");
		password.focus();
		return false;
	}
	
	form.submit();
}