package notice;
// DB에 있는 모든 데이터를 가져오는 역할 (Model)

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import shop.m_dbinfo;

public class m_noticelist {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	m_dbinfo db = new m_dbinfo();
	String sql = "";
	ArrayList<String> data = null; // 1차배열 각 컬럼별 값을 저장
	ArrayList<ArrayList<String>> alldata = null; // 2차배열 데이터베이스의 전체 데이터를 저장
	int spage = 0; // 첫번째 노드
	int ea = 3; // 페이지 당 게시물 3개출력
			
	public m_noticelist(int s) {
		this.spage = s; // sql 쿼리문의 limit를 사용하기 위함
	}
	
	public ArrayList<ArrayList<String>> db_data(){
		try {
			this.con = db.getConnection();
			// 필요한 컬럼만 지정하여 select 문법으로 데이터를 가져오는 코드
			this.sql = "select nidx, subject, writer, nview, ndate,(select count(*) from notice) as total from notice "
					+ "order by nidx desc limit ?,?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, this.spage);
			this.ps.setInt(2, this.ea);
			this.rs = this.ps.executeQuery();
			
			// 반복문으로 Table에 있는 컬럼을 1차배열로 이관 후 2차 배열에 담는 코드
			this.alldata = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("subject"));
				this.data.add(this.rs.getString("writer"));
				this.data.add(this.rs.getString("nview"));
				this.data.add(this.rs.getString("ndate"));
				this.data.add(this.rs.getString("total"));
				this.alldata.add(this.data);				
			}
		} catch (Exception e) {
			System.out.println(e);
			this.alldata = null;
		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				
			}
		}
		//Model에서 Controller로 데이터를 회신
		return alldata;
	}
}
