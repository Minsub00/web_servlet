package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.m_dbinfo;
import shop.m_md5;

@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 5,
	maxFileSize = 1024 * 1024 * 50,
	maxRequestSize = 1024 * 1024 * 500
)
public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	// Model
	m_dbinfo db = new m_dbinfo(); // db
	m_md5 md5 = new m_md5();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		// 첨부파일 유,무에 따라 sql 저장방식이 다름
		Part nfile = request.getPart("nfile");
		long filesize = nfile.getSize();
		
		try {
			this.con = this.db.getConnection();
			String subject = request.getParameter("subject");
			String writer = request.getParameter("writer");
			String pw = request.getParameter("pw");
			String texts = request.getParameter("texts");
			
			pw = md5.md5_code(pw);
			
			String sql = "";
			int result = 0;
			
			if(filesize == 0) { // 첨부파일 無
				sql = "insert into notice (nidx, subject, writer, pw, texts, ndate)"
						+ "values('0',?,?,?,?,now())";
				
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, subject);
				this.ps.setString(2, writer);
				this.ps.setString(3, pw);
				this.ps.setString(4, texts);
				
				result = this.ps.executeUpdate();
				
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('정상적으로 게시물이 등록되었습니다.');"
							+ "location.href ='./notice_list.do';"
							+ "</script>");
				}
			} else { // 첨부파일 有 *Model 이용
				m_notice nt = new m_notice(nfile, subject, writer, pw, texts, request);
				// return 메소드가 private이므로 전역변수 값을 직접 Controller에서 로드
				String msg = nt.msg;
				if(msg == "ok") {
					this.pw.write("<script>"
							+ "alert('정상적으로 게시물이 등록되었습니다.');"
							+ "location.href ='./notice_list.do';"
							+ "</script>");
				} else {
					this.pw.write("<script>"
							+ "alert('첨부파일 등록중 문제가 발생하였습니다.');"
							+ "history.go(-1)';"
							+ "</script>");
				}
			}
		} catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('데이터베이스 문제로 인하여 저장되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
			System.out.println(e);
		} finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			} catch (Exception e) {
				
			}
		}
	}

}
