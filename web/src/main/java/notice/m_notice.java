package notice;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import shop.m_dbinfo;

// 파일을 저장하는 Model
public class m_notice{

	Connection con = null;
	PreparedStatement ps = null;
	// Model
	m_dbinfo db = new m_dbinfo(); // db
	String msg = ""; // Model 에서 처리된 값을 Controller로 반환하는 변수
	String sql = ""; // DB query문
	int result = 0; // DB 저장 결과값
	String subject, writer, pw, texts;
	// 즉시 실행 메소드는 첨부파일을 저장하는 역할
	public m_notice(Part nfile, String subject, String writer, String pw, String texts, HttpServletRequest request) throws Exception {
		this.subject = subject;
		this.writer = writer;
		this.pw = pw;
		this.texts = texts;
		
		String filenm = nfile.getSubmittedFileName();
		String url = request.getServletContext().getRealPath("/notice_file/");
		try {
			nfile.write(url + filenm); // 웹에 저장
			this.fileok(filenm);
		} catch (Exception e) {			
			this.fileok("error");
		}

	}
	
	private String fileok (String data) throws Exception {
		if(data.equals("error")) {
			this.msg = "error";
		} else { // 파일이 정상적으로 저장 되었을 경우
			try {
				this.con = this.db.getConnection();
				this.sql = "insert into notice(nidx,subject,writer,pw,texts,filenm,nfile,ndate)"
						+ "values('0',?,?,?,?,?,?,now())";

				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, this.subject);
				this.ps.setString(2, this.writer);
				this.ps.setString(3, this.pw);
				this.ps.setString(4, this.texts);
				this.ps.setString(5, data);
				this.ps.setString(6, data);
				this.result = this.ps.executeUpdate();
				
				if (this.result > 0) {
					this.msg = "ok";
				}
			} catch(Exception e) {
				this.msg = "error";
			} finally {
				this.ps.close();
				this.con.close();
			}
			
		}
		
		return this.msg;
	}
}
