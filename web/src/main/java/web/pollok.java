package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pollok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// method=get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 동일한 name = radio : 여러개의 오브젝트 중 한가지만 선택
		// PrintWriter => Controller에서 종료 (결과값에 대해서 처리)
		// RequestDispatcher => Controller => View (jsp) 결과를 처리
		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		
		String subject = request.getParameter("subject");
		String etc[] = request.getParameterValues("etc");
		//ArrayList<String> etc = new ArrayList<String>(Arrays.asList(request.getParameterValues("etc")));
		PrintWriter pw = response.getWriter();
		try {
			request.setAttribute("etc", etc);
			request.setAttribute("subject", subject);
			RequestDispatcher rd = request.getRequestDispatcher("./pollok.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			pw.write("<script>"
					+ "alert('올바른 접근이 아닙니다');"
					+ "</script>");
		} finally {
			pw.close();
		}
	}

}
