function wordck(){
	var w = "0101234-1234";
	// let ck = /^[0-9]/;
	//console.log(ck.test(w));
	//console.log(w.match(ck));
	console.log(ck.test(w));
}
function eventok(){
	if(f.ename.value == ""){
		alert("고객명을 입력하세요.");
	} else if(f.etel.value == ""){
		alert("전화번호를 입력하세요.");
	} else if(f.email.value == ""){
		alert("이메일을 입력하세요.");
	} else if(f.ememo.value == ""){
		alert("참여 사유를 입력하세요.");
	} else if(f.info1.checked == false){
		alert("개인 정보 활용 동의하셔합니다.");
	} else if(f.info2.checked == false){
		alert("제3자 정보 제공 동의하셔합니다.");
	} else {
		// 정규식 코드
		let ck = /^\d{2,3}\d{3,4}\d{4}$/;
		if(ck.test(f.etel.value) == false){
			alert("전화번호를 정상적으로 입력하세요.");
		} else{
			f.submit();			
		}
	}
}