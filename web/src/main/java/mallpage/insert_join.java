package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import shop.m_dbinfo;

// 회원가입 처리 모델
public class insert_join {
	Connection con = null;
	PreparedStatement ps = null;
	m_dbinfo db = new m_dbinfo();
	String sql;
	Integer result;
	
	public Integer insert_member(m_member m) {
		try {
			this.con = this.db.getConnection();
			this.sql = "insert into joins values('0',?,?,?,?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			//DTO에서 getter를 이용해 DB에 저장
			this.ps.setString(1, m.getMid());
			this.ps.setString(2, m.getMpass());
			this.ps.setString(3, m.getMname());
			this.ps.setString(4, m.getMemail());
			this.ps.setString(5, m.getMtel());
			this.ps.setString(6, m.getEvent_mail());
			this.ps.setString(7, m.getEvent_sms());
			
			this.result = this.ps.executeUpdate();
			
		} catch (Exception e) {
			this.result = null;
			System.out.println(e);
		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				this.result = null;
			}
		}
		return result;
	}
}
