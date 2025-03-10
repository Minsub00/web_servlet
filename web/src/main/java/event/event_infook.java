package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class event_infook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PrintWriter pw = null;
	Statement st = null;
	public event_infook() {
		try {
			this.con = new dbconfig().info();
			System.out.println("db연결성공");
		} catch (Exception e) {
			System.out.println("연결실패");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String ename = req.getParameter("ename");
		String etel = req.getParameter("etel");
		String email = req.getParameter("email");
		String ememo = req.getParameter("ememo");
		String info1 = req.getParameter("info1").trim();
		String info2 = req.getParameter("info2").trim();
		
		
		// sql query문 (DDL) -select, insert, update, delete
		String sql = "insert into event(eidx,ename,etel,email,info1,info2,ememo,ejoin)"
				+ "values('0','"+ename+"','"+etel+"','"+email+"','"+info1+"','"+info2+"','"+ememo+"',now())";
		this.pw = res.getWriter();
		try {
			// SQL 문법을 실행시키는 클래스 (기초)
			this.st = this.con.createStatement();
			int result = st.executeUpdate(sql);
			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('정상적으로 이벤트에 참여되었습니다.');"
						+ "location.href='./event_info.html';"
						+ "</script>");
			} else {
				this.pw.write("<script>"
						+ "alert('이미 참여하셨습니다.');"
						+ "location.href='./event_info.html';"
						+ "</script>");
			}
			st.close();
		} catch (Exception e) {
			System.out.println("sql 문법오류"+ e);
		} finally {
			try {
				this.pw.close();
				this.con.close();
			} catch (Exception e){
				System.out.println("db가 올바르게 종료되지 않았습니다.");
			}
		}
		
	}
}
