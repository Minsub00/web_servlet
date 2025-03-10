// 게시물 등록시 체크사항
function writeck(){
	if(frm.subject.value == ""){
		alert("제목을 입력해주세요.");
		frm.subject.foucs();
	} else if(frm.writer.value == ""){
		alert("글쓴이를 입력해주세요.");
		frm.write.focus();
	} else if(frm.pw.value == ""){
		alert("패스워드를 입력해주세요");
		frm.pw.focus();
	} else{
		// CKEDITOR.instances.id이름.getData() : ckeditor를 로드
		var txt = CKEDITOR.instances.editor.getData()
		if(txt == ""){
			alert("내용을 입력해주세요.");
		} else if(txt.length < 40){
			alert("최소 40자 이상의 내용을 입력해주세요")
		} else {
			frm.submit();
		}
	}
}