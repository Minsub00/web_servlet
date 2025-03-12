package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;



// Copyright Model + Login Model
public class copyright {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql;
	ArrayList<String> cp = null;
	m_dbinfo db = new m_dbinfo();
	String result = null;
	
	m_member mb = new m_member();
	public String user_login(m_member dto) {
		try {
			this.con = this.db.getConnection();
			this.sql = "select mid, mname, memail from joins where mid=? and mpass=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, dto.getMid());
			this.ps.setString(2, dto.getMpass());
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == true) {  // 일치하는 아이디, 비밀번호가 있을 경우
				this.result = "ok";
				// 기존 사용된 DTO 초기화 및 새로운 DTO값 구성
				mb.setMid(this.rs.getString("mid"));
				mb.setMname(this.rs.getString("mname"));
				mb.setMemail(this.rs.getString("memail"));
			}
		} catch (Exception e) {
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				
			}
		}
		return this.result;
	}
	
	
	public ArrayList<String> copyright_info() {
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from corp_info";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			this.rs.next();
			this.cp = new ArrayList<String>();
			this.cp.add(this.rs.getString("corp_nm"));
			this.cp.add(this.rs.getString("ceo_nm"));
			this.cp.add(this.rs.getString("ceo_addr"));
			this.cp.add(this.rs.getString("corp_tel"));
			this.cp.add(this.rs.getString("corp_time"));
			this.cp.add(this.rs.getString("ceo_mail"));
			this.cp.add(this.rs.getString("corp_no"));
			this.cp.add(this.rs.getString("corp_no2"));
			this.cp.add(this.rs.getString("corp_master"));
			this.cp.add(this.rs.getString("corp_domain"));
			
		} catch(Exception e) {
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return this.cp;
	}
}
