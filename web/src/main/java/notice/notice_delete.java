package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;
import shop.m_md5;


public class notice_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	int result;
	m_md5 md = new m_md5();
	m_dbinfo db = new m_dbinfo();
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String nidx = request.getParameter("nidx");
		String ori_pw = request.getParameter("ori_pw");
		String npw = request.getParameter("npw");
		this.pw = response.getWriter();
		
		try {
			// 사용자가 입력한 패스워드와 자동 증가값이 전달되지 않을경우
			if(nidx.equals(null) || npw.equals(null)) {
				this.pw.write("<script>"
						+ "alert('올바른 접근이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			} else {
				// 사용자가 입력한 패스워드를 암호화한 이후에 ori_pw와 비교
				npw = md.md5_code(npw);
				if (npw.equals(ori_pw)) {
					this.con = this.db.getConnection(); // 보안을 위해 조건문 안에 작성
					this.sql = "delete from notice where nidx=?";
					this.ps = this.con.prepareStatement(this.sql);
					this.ps.setString(1, nidx);
					this.result = this.ps.executeUpdate();
					if(this.result > 0) {
						this.pw.write("<script>"
								+ "alert('게시물이 정상적으로 삭제되었습니다.');"
								+ "location.href = './notice_list.do';"
								+ "</script>");
					}
					
				} else {
					this.pw.write("<script>"
							+ "alert('패스워드가 다릅니다.');"
							+ "history.go(-1);"
							+ "</script>");
				}
			}
		} catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('게시물 삭제 중 문제가 발생하였습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		} finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
