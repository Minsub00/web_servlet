package event;
//database 환경설정 및 셋팅

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	public static Connection info() throws Exception{
		// String database = "com.mysql.jdbc.Driver"; // v5.1 ~ v5.5
		
		//mysql연결 
		String database = "com.mysql.cj.jdbc.Driver"; // v5.7 ~
		
		// 연결 경로
		String dburl = "jdbc:mysql://localhost:3306/mrp";
		
		// 아이디, 패스워드
		String user = "project";
		String password = "p402402";
		
		//db 연결
		Class.forName(database); // 어떤 라이브러리를 이용하여 db에 접속할것인지를 정하는 것을 말함
		//mysql -u 아이디 -p
		Connection con = DriverManager.getConnection(dburl,user,password);
		return con;
	}
}
