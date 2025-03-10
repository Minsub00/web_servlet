package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class reservationok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	SimpleDateFormat sd = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			
		String username = request.getParameter("username");
		String usertel = request.getParameter("usertel");
		String movie = request.getParameter("movie");
		String date = request.getParameter("reservationDate");
		
		ArrayList<String> data = new ArrayList<String>();
		
		data.add(username);
		data.add(usertel);
		data.add(movie);
		data.add(date);
		
		request.setAttribute("data", data);
		
		this.sd = new SimpleDateFormat("yyyy-MM-dd");
		Date getdate = new Date();
		String today = sd.format(getdate);
		
		this.pw = response.getWriter(); 
		
		if(date.equals(today)) {
			this.pw.write("<script>"
					+ "alert('오늘 이후의 날짜만 선택 가능합니다.');"
					+ "history.go(-1);"
					+ "</script>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/reservationok.jsp");
			rd.forward(request, response);			
		}
	}

}
