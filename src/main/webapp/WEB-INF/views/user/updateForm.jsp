<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>
		<input type="hidden" id="id" value="${principal.user.id }">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username</label> 
			<input type="text" value="${principal.user.username}" class="form-control" id="username" readonly="readonly">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label> 
			<input type="password" class="form-control" id="password" >
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Email address</label> 
			<input type="email"  value="${principal.user.email }"class="form-control" id="email" >
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary" >Update</button>
	
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>