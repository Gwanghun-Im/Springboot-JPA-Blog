<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="POST">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username</label> <input type="text" class="form-control" id="username" name="username">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label> <input type="password" class="form-control" id="password" name="password">
		</div>
		<button id="btn-login" class="btn btn-primary">Login</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=45c227c59e6d943b1a4c7b646fc31098&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="40px" alt=""
			src="/image/kakao_login_button.png"></a>
	</form>

</div>
<%@ include file="../layout/footer.jsp"%>