<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="header" class="alt ">
	<h1><a href="/">Drift <span>by Pixelarity</span></a></h1>
	<nav id="nav">
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href="/board/list">BOARD</a></li>
			<li>
				<c:choose>
					<c:when test="${!empty user}">
						<a href="/user/logout">LOGOUT</a>					
					</c:when>
					<c:otherwise>
						<a href="/user/login">LOGIN</a>					
					</c:otherwise>
				</c:choose>
			</li>
			<li>
				<c:choose>
					<c:when test="${!empty user}">
						<a href="#">${user.id}</a>					
					</c:when>
					<c:otherwise>
						<a href="/user/signup">SIGNUP</a>
					</c:otherwise>
				</c:choose>
			</li>
			<li><a href="/index/elements">Elements</a></li>
		</ul>
	</nav>
</header>