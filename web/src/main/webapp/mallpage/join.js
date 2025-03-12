function joinok(){
	if(frm.mid.value == ""){
		alert("아이디를 입력해주세요");
	} else if(frm.mpass.value == ""){
		alert("비밀번호를 입력해주세요");
	} else{
		var pw2 = document.getElementById("mpass2").value;
		if(pw2 != frm.mpass.value){
			alert("동일한 패스워드를 입력하셔야만 회원가입이 진행됩니다.");
		} else {
			frm.submit();
		}
	}
	
}