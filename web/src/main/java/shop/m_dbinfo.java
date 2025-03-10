package shop;

import java.sql.Connection;
import java.sql.DriverManager;

//Database, 사용자 아이디, 사용자 패스워드
public class m_dbinfo {
	public static Connection getConnection() throws Exception{
		//해당 라이브러리를 가져오는 역할 변수
		String db_driver = "com.mysql.cj.jdbc.Driver";
		// db 경로 연결 : jdbc:mysql://IP 또는 도메인:port번호/Database 이름
		String db_url = "jdbc:mysql://localhost:3306/mrp";
		// mysql에 접속하는 사용자
		String db_user = "project";
		// mysql에 접속하는 사용자의 패스워드
		String db_passwd = "a123456";
		
		// 실제 Database에 연결을 하는 명령어
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_passwd);
		// System.out.println(con);
		return con; // 데이터베이스 연결 결과 반환	
	}
}
