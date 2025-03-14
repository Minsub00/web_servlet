package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nidx = Integer.parseInt(request.getParameter("nidx"));
		// 조회수 증가 및 데이터 출력
		m_noticeview nv = new m_noticeview();
		nv.viewcount(nidx);
		// 게시물의 내용을 받아옴
		ArrayList<String> notice_v = nv.db_data;
		request.setAttribute("notice_v", notice_v);
		
		RequestDispatcher rd = request.getRequestDispatcher("./notice_view.jsp");
		rd.forward(request, response);
			
	}

}
