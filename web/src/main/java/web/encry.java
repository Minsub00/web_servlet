package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class encry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwd = "a123456";
		// 해당 문자를 base64를 이용하여 encode(암호화)
		encry_model em = new encry_model(); // 암호화 모델 클래스 로드
		String result = em.dataencode(passwd); // 해당 메소드에 문자 값을 전달
		System.out.println(result); // 암호화된 passwd 출력
		
		// 암호화된 문자를 base64를 이용하여 decode(복호화)
		String repass = "YTEyMzQ1Ng==";
		String result2 = em.datadecode(repass);
		System.out.println(result2);
		
		//md5(암호화 알고리즘)를 이용한 암호화
		String result3 = em.md5_encode(passwd);
		System.out.println(result3);
	}

}
