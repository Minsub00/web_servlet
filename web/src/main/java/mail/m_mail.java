package mail;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import shop.m_dbinfo;

public class m_mail {
	Connection con = null;
	PreparedStatement ps = null;
	m_dbinfo db = new m_dbinfo();
	String sql = "";
	int result = 0;
	String msg;
	public m_mail(HttpServletRequest request) throws Exception {		
		try {
			this.con = db.getConnection();
			String to_name = request.getParameter("to_name");
			String to_mail =request.getParameter("to_mail");
			String subject = request.getParameter("subject");
			String context = request.getParameter("context");
			
			this.sql = "insert into mail values('0',?,?,?,?,now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
			this.result = this.ps.executeUpdate();
			
			if(result > 0) {
				msg = "ok";
			}
		} catch (Exception e) {
			msg = "err";
		} finally {
			this.ps.close();
			this.con.close();
		}
	}
	
}
