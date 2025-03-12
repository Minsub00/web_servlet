package mallpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mallpage/loginok.do")
public class loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter pw = null;
	m_member dto = new m_member(); // DTO 선언
	m_member dto2 = new m_member();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		this.dto.setMid(request.getParameter("mid"));
		this.dto.setMpass(request.getParameter("mpass"));
		
		copyright cr = new copyright();
		// Controller => Model로 DTO 값을 전송
		String result = cr.user_login(this.dto);
		m_member dto2 = cr.mb; // Model에서 적용된 DTO값을 Controller에서 받음		
		
		if(result == "ok") {
			// DTO를 활용하여 Session을 생성
			// HttpSession : Controller (login, logout) 에서만 설정
			HttpSession session = request.getSession();
			session.setAttribute("mid", dto2.getMid());
			session.setAttribute("mname", dto2.getMname());
			session.setAttribute("memail", dto2.getMemail());
			
			
			this.pw.write("<script>"
					+ "alert('로그인 하였습니다.');"
					+ "location.href = './index.do';"			
					+ "</script>");
		}
		else {
			this.pw.write("<script>"
					+ "alert('로그인 하였습니다.');"
					+ "history.go(-1);"	
					+ "</script>");
		}
	}

}
