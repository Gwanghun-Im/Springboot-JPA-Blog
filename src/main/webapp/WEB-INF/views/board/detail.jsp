<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id }">
		<button id="btn-delete" class="btn btn-danger">삭제</button>
		<a href="/board/${board.id }/updateForm" class="btn btn-warning">수정</a>
	</c:if>
	<hr>
	<div>
		글번호: <span id="id"><em>${board.id }</em></span> 작성자: <span><em>${board.user.username }</em></span> 작성시간: <span><em>${board.createDate}</em></span>
	</div>
	<br>
	<div>
		<h3>${board.title }</h3>
	</div>
	<hr>
	<div>
		<div>${board.content }</div>
	</div>
	<hr>
	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="reply--box" class="list-group">
		<c:forEach var="reply" items="${board.reply }">
				<li id="reply--1" class="list-group-item d-flex justify-content-between">
					<div>${reply.content }</div>
					<div class="d-flex">
						<div>작성자: ${reply.user.username}&nbsp;</div>
						<c:if test="${principal.user.id == reply.user.id }">
							<button class="badge bg-danger">삭제</button>
						</c:if>
						
					</div>
				</li>
			</c:forEach>
			
		</ul>
	</div>
	<br>
	<div class="card">
	<form>
	<input type="hidden" id="boardId" value="${board.id }">
	<div class="card-body">
			<textarea class="form-control" placeholder="Leave a comment here" id="reply-content"></textarea>
		</div>
		<div class="card-footer">
			<button type="button" class="btn btn-primary" id="btn-reply-save">등록</button>
		</div>
	</form>
	</div>


</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>