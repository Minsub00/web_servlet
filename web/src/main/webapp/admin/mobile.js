// ECMAScript : touchstart, touchend, touchmove, touchcancel
var btn = document.getElementById("btn").addEventListener("click",function(){		
	reviews();
});
function reviews(){
	if(frm.mname.value == ""){
		alert("고객명을 입력하세요.");
		frm.mname.focus();
	} else if(frm.pname.value == ""){
		alert("상품명을 입역하세요.")
		frm.pname.focus();
	} else if(frm.mtext.value == ""){
		alert("내용을 작성하세요");
		frm.mtext.focus();
	} else{
		frm.submit();
	}
}