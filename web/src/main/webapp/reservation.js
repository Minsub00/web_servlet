function next() {	
	var movies = document.getElementsByName("movie");
    var isChecked = false;

    for (let i = 0; i < movies.length; i++) {
        if (movies[i].checked) {
            isChecked = true;
            break;
        }
    }
	if(frm.username.value == ""){
		alert("고객명을 입력하세요.");
	} else if (frm.usertel.value == ""){
		alert("연락처를 입력하세요.");
	} else if (isChecked == false){
		alert("영화를 선택해주세요");
	} else if (frm.reservationDate.value == ""){
		alert("날짜를 선택해주세요.");
	} else {
		frm.submit();
	}
}