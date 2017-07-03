package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "sys as sysdba";
		String pw = "1111";
	
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
}