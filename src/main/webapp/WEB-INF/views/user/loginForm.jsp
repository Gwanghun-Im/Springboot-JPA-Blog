<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="POST">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username</label> <input type="text" class="form-control" id="username"  name="username">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label> <input type="password" class="form-control" id="password" name="password">
		</div>
		<button id="btn-login" class="btn btn-primary" >Login</button>
	</form>
	
</div>
<%@ include file="../layout/footer.jsp"%>