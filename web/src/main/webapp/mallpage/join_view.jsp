<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="./join.js"></script>
<div class="products">
    <h3>MEMBER_JOIN</h3>
    <div class="sub_view">
   
    <div class="joinview">     
    <form id="frm" method="post" action="./joinok.do">
    <h3>회원가입</h3>
	<span class="join_info">
    <ol>
    <li>기본정보 </li>
    <li>※ 표시는 반드시 입력하셔야 하는 항목 입니다.</li>
    </ol>
    </span>
    <ul class="join_ul">
    <li>※ 아이디</li>
    <li>
    <input type="text" class="join_in1" name="mid"> <input type="button" value="중복확인" class="join_btn1">
    </li>
    <li>※ 비밀번호</li>
    <li>
    <input type="password" class="join_in1 join_in2" name="mpass"> ※ 최소 6자 이상 입력하셔야 합니다.
    </li>
    <li>※ 비밀번호 확인</li>
    <li>
    <input type="password" class="join_in1 join_in2" id="mpass2"> ※ 동일한 패스워드를 입력하세요.
    </li>
    <li>※ 이름</li>
    <li>
    <input type="text" class="join_in1" name="mname">
    </li>
    <li>※ 이메일</li>
    <li>
    <input type="text" class="join_in1" name="memail"> <input type="button" value="이메일 인증" class="join_btn1"> ※ 입력하신 이메일을 확인해 주세요.
    </li>
    <li>※ 인증번호</li>
    <li>
    <input type="text" class="join_in1 join_in3" maxlength="8" id="seno"> ※ 8자리 인증번호를 입력하세요.
    </li>
    <li>※ 전화번호</li>
    <li>
    <input type="text" class="join_in1 join_in2" maxlength="11" name="mtel"> ※ 숫자만 입력하세요
    </li>
    <li>※ 이벤트 메일 수신</li>
    <li>
    <label><input type="checkbox" class="join_ck1" name="event_mail" value="Y"> 정보/이벤트 메일 수신에 동의합니다.</label>
    </li>
    <li>※ 이벤트 SMS 수신</li>
    <li>
    <label><input type="checkbox" class="join_ck1" name="event_sms" value="Y"> 정보/이벤트 SMS 수신에 동의합니다.</label>
    </li>
    </ul>
    <div class="btn_center_box">
    <button type="button" id="btnNextStep" class="btn_join" onclick="joinok()">회원가입</button>
    </div>
	</form>
    </div>
    </div>
    </div>