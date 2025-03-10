package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con = null;   
	//ajax 통신을 받는 메소드 (아이디 중복체크)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = ""; // Front-end에게 결과값을 보내는 변수
		// Ajax로 Front-end가 보낸 데이터를 받는 역할
		PrintWriter pw = response.getWriter();
		
		try {
			String id = request.getParameter("sid");
			if(id.equals("")) {
				msg = "error";
			} else {
				m_dbinfo db = new m_dbinfo();
				this.con = db.getConnection();
				String sql = "select count(*) as ctn from shop_member where sid='"+ id + "'";
				Statement st = this.con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				/*
				while(rs.next()){
					System.out.println(rs.getString("ctn"));
				}
				*/
				if(rs.next() == true) { // 정상적으로 쿼리문이 작동했을 경우
					if(rs.getString("ctn").equals("0")){ // 해당 데이터가 없을 경우
						msg = "ok";
					} else {
						msg = "no";
					}
				}
				rs.close();
				st.close();
			}
			pw.write(msg);
		} catch (NullPointerException ne) { // front-end가 올바른 값을 전달하지 못했을 경우
			// Back-end가 Front-end에게 결과값을 통보하는 역할
			pw.write(msg); // ok: 가능, no: 불가능, error: 데이터 오류
		
		} catch(Exception e) {
			msg = "Mysql-CODE 844";
			pw.write(msg);
		}	finally {
			pw.close();
		}
	}

}
