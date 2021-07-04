let index = {
	init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-login").on("click",()=>{
			this.login();
		});
	},
	
	
	save: function(){
		let data = {
			username:$("#username").val(),
			email:$("#email").val(),
			password:$("#password").val(),
		}
		$.ajax({
			type:"POST",
			url:"/api/user",
			data: JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", //body데이터가 어떤 타입인지(MINE)
			//dataType:"json", //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열...(생긴게 json이라면) => json으로 변경해줌.,
		}).done((res)=>{
			alert("회원가입이 완료 되었습니다.")
			location.href="/"
		}).fail((e)=>{
			alert(JSON.stringify(e))
		});
	},
	login: function(){
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
		}
		$.ajax({
			type:"POST",
			url:"/api/user/login",
			data: JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", //body데이터가 어떤 타입인지(MINE)
			//dataType:"json", //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열...(생긴게 json이라면) => json으로 변경해줌.,
		}).done((res)=>{
			location.href="/"
		}).fail((e)=>{
			alert(JSON.stringify(e))
		});
	}
}

index.init();