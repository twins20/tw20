package Model1;

import java.sql.*;


public class DBConnect { // 연결 관련 설정
	
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 주소
		String id = "sys as sysdba"; // 아이디
		String pass = "1111"; // 비번
		
		Connection conn = null; // conn 값 초기화
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url,id,pass); // 데이터베이스 연결 설정 = url + id + pw
		}catch(Exception e) { // 예외가 발생할 시
			System.out.println(e); // e값을 출력???
		}
		return conn; // conn 값 반환(void가 아니므로 반환값이 있음)
	}
}

