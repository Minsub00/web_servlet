package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 *2, // 파일 한개의 최대 용량 2MB
		maxRequestSize = 1024 * 1024 * 100 // 여러개 파일 전송시 총 용량 100MB
)

public class part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 회원가입
	PrintWriter pw = null;
	String url = null;
	String filenm = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			String mid = request.getParameter("mid");
			String mname = request.getParameter("mname");
			String mpass = request.getParameter("mpass");
			String mtel = request.getParameter("mtel");
			String memail = request.getParameter("memail");
			Part mfile = request.getPart("mfile");
			this.pw = response.getWriter();
			if (mid.equals("") || mname.equals("") || mpass.equals("") || mtel.equals("") || memail.equals("")) {
				this.pw.write("<script>"
						+ "alert('올바른 데이터 접근이 아닙니다.');"
						+ "history.go(-1)"
						+ "</script>");
			} else {
				this.filenm = mfile.getSubmittedFileName();
				if(this.filenm != null && this.filenm != "") {
					long size = mfile.getSize();
					if(size > 2097152) {
						this.pw.write("<script>"
								+ "alert('첨부파일은 최대 2MB 까지 입니다.');"
								+ "history.go(-1)"
								+ "</script>");
					} else {
						this.url = request.getServletContext().getRealPath("/user/");
						mfile.write(this.url + this.filenm);
					}	
				}
				request.setAttribute("mname", mname);
				request.setAttribute("memail", memail);
				request.setAttribute("mtel", mtel);
				request.setAttribute("mid", mid);
				request.setAttribute("image", this.filenm);
				RequestDispatcher rd = request.getRequestDispatcher("./part3.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			
		} finally {
			
		}
	}

}
