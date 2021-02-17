<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
</head>
<body>
	<!-- Header -->
	<%@ include file="../include/header.jsp" %>
	
	<form method="post" action="/user/login" style="margin: 0 auto; width: 60%;">
		<h3>Login</h3>
		<div class="row gtr-uniform">
			<div class="col-12">
				<input type="text" name="id" id="id" value="" placeholder="Id" />
			</div>
			<div class="col-12">
				<input type="password" name="password" id="password" value="" placeholder="Password" />
			</div>
		</div>
		<a href="/user/signup">회원가입 페이지로 이동</a>
		<ul class="actions" style="margin-top: 20px;">
			<li><a href="#" class="button primary">로그인</a></li>
		</ul>
	</form>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>
	
	<!-- Scripts -->
	<%@ include file="../include/src.jsp" %>
</body>
</html>