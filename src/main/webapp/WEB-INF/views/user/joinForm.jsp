<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username</label> <input type="text" class="form-control" id="username" >
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Email address</label> <input type="email" class="form-control" id="email" >
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label> <input type="password" class="form-control" id="password">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">Submit</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>