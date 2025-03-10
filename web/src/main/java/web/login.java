package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet : Java를 웹에서 사용할 수 있도록 처리하는 클래스
public class login extends HttpServlet {
	// serialVersionUID : Backend 가상의 페이지 일련번호
	private static final long serialVersionUID = 1L;
    
	// doGet, doPost : Front-end가 Form 태그에 method를 설정한 사항과 동일한 정보를 처리하는 메소드
	// request : Front-end에게 전달받는 값
	// response : Backend가 처리한 결과 값을 출력하는 역할
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getParameter() : Front-end 에서 전달되는 name 이름을 말함
		response.setCharacterEncoding("UTF-8"); // 출력 결과 값 한글 깨짐 방지
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8"); // front-end로 부터 받은 값 한글 깨짐 방지
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		
		// PrintWriter : javascript를 핸들링
		PrintWriter pw = response.getWriter();
		if(mid.equals("hong") && mpass.equals("a123456")) {
			pw.write("<Script>"
					+ "alert('정상적으로 로그인 하셨습니다');"
					+ "</Script>");
		} else {
			pw.write("<Script>"
					+ "alert('아이디 및 패스워드를 다시 확인하세요');"
					+ "location.href = './login.html';"
					+ "</Script>");
		}
	}

}
