function ajaxs(){
	var mid = document.getElementById("mid");
	var memail = document.getElementById("memail");
	if(mid.value ==""){
		alert("아이디를 입력하세요!");
	} else {
		// ajax ㅖㅒㄴㅆ 통신을 위한 함수 호풀
		this.ajax_post(mid.value, memail.value);		
	}
}

// Ajax POST wjsthdgksms gkatn
function ajax_post(mid, memail){
	var http, result; // http : Back-end 통신, result : Back-end 제공한 데이터
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			console.log(this.response);
		} else if(http.status == 405){
		alert("통신 규격 오류 발생")		
		} else if(http.status == 404){
		alert("경로 오류 발생")		
		}
	}
	
	// GET 방식
	// http.open("get", "./ajax_postok.do?userid="+mid, true); 
	// http.send()
	// POST 방식으로 요청 보내기
	http.open("post", "./ajax_postok.do", true);
	// content-type 설정을 open() 이후에 호출해야 합니다
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	// 데이터 전송
	http.send("userid="+mid+"&usermail="+memail);

}