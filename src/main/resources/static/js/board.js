let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
	},


	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), 
			contentType: "application/json;charset=utf-8",
		}).done((res) => {
			alert("글쓰기가 완료 되었습니다.")
			location.href = "/"
		}).fail((e) => {
			alert(JSON.stringify(e))
		});
	},
	deleteById: function() {
		let id = $("#id").text()
		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id, 
		}).done((res) => {
			alert("삭제가 완료 되었습니다.")
			location.href = "/"
		}).fail((e) => {
			alert(JSON.stringify(e))
		});
	},
	update: function() {
		let id = $("#id").val()
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		$.ajax({
			type: "PUT",
			url: "/api/board/"+id, 
			contentType: "application/json;charset=utf-8",
			data: JSON.stringify(data), 
		}).done((res) => {
			alert("수정이 완료 되었습니다.")
			location.href = "/"
		}).fail((e) => {
			alert(JSON.stringify(e))
		});
	},
}

index.init();