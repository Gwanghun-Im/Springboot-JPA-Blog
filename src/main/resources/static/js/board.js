let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
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
}

index.init();