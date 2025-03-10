package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class idsearchok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter pw = response.getWriter();
		try {
			String cname = request.getParameter("client_name");
			String cnumber = request.getParameter("client_number");
			String cmail = request.getParameter("client_email");
			String result;
			
			if(cname.equals("홍길동") && cnumber.equals("01010041919") && cmail.equals("hong@naver.com") ) {
				result = "hong2025";
			} else {
				result = "가입정보가 확인되지 않습니다.";
			}
				
			request.setAttribute("result", result);
			
			RequestDispatcher rd = request.getRequestDispatcher("/idsearch.jsp");
			rd.forward(request, response);
			
			
			
		} catch (Exception e) {
			pw.write("<script>"
					+ "alert('올바른 값이 전달되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
	}

}
