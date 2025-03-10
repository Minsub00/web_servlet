package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class step_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter pw = response.getWriter();
		try {
			String mid = request.getParameter("mid");
			String mname = request.getParameter("mname");
			String mmail = request.getParameter("mmail");
			String mnumber = request.getParameter("mnumber");
			
			request.setAttribute("mid", mid);
			request.setAttribute("mname", mname);
			request.setAttribute("mmail", mmail);
			request.setAttribute("mnumber", mnumber);
			
			System.out.println("mid: " + mid);
			System.out.println("mname: " + mname);
			System.out.println("mmail: " + mmail);
			System.out.println("mnumber: " + mnumber);
						
			RequestDispatcher rd = request.getRequestDispatcher("/step_3.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
			pw.write("<script>"
					+ "alert('올바른 값이 전달되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		} finally {	
			pw.close();
		}
	}

}
