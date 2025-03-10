package mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		try {
			m_mail mail = new m_mail(request);
			String msg = mail.msg;
			if(msg.equals("ok")) {
				this.pw.write("<script>"
						+ "alert('메일이 정상적으로 발송되었습니다.');"
						+ "location.href='./mail.html';"
						+ "</script>");
			} else {
				this.pw.write("<script>"
						+ "alert('메일 발송중 오류가 발생하였습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			this.pw.close();
		}
	}

}
