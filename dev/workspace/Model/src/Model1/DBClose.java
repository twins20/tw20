package Model1;

import java.sql.*;

public class DBClose { // 닫는 객체를 만드는 곳 모든 설정이 들어감
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) { //  con pstmt rs 선언
		try {
			try {
				if(rs!=null) { rs.close(); rs=null;} // rs가 null이 아니면 rs를 닫아주세요(rs가 있으면 닫으라는 것)
			}catch(Exception e) {}
			
			try {
				if(pstmt!=null) { pstmt.close(); pstmt=null; } // pstmt가 있으면 pstmt를 닫아주세요
			}catch(Exception e) {}
			
			try {
				if(con!=null) { con.close(); con=null; } // con이 있으면 con을 닫아주세요
			}catch(Exception e) {}
		}catch(Exception e) {}
	}
	
	public static void close(Connection con, PreparedStatement pstmt) { // con과 pstmt만 선언
		try {
			try {
				if(pstmt!=null) { pstmt.close(); pstmt=null; }
			}catch(Exception e) {}
			
			try {
				if(con!=null) { con.close(); con=null; }
			}catch(Exception e) {}
		}catch(Exception e) {}
	}


	public static void close(Connection con, Statement stmt) {
		try {
			try {
				if(stmt!=null) { stmt.close(); stmt=null; }
			}catch(Exception e) {}
		
			try {
				if(con!=null) { con.close(); con=null; }
			}catch(Exception e) {}
		}catch(Exception e) {}
	}
	
	public static void close(Connection con) {
		try {
			try {
				if(con!=null) { con.close(); con=null; }
			}catch(Exception e) {}
		}catch(Exception e) {}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			try {
				if(pstmt!=null) { pstmt.close(); pstmt=null; }
			}catch(Exception e) {}
		
		}catch(Exception e) {}
	}
	
	public static void close(Statement stmt) {
		try {
			try {
				if(stmt!=null) { stmt.close(); stmt=null; }
			}catch(Exception e) {}
		
		}catch(Exception e) {}
	}
	
	public static void close(ResultSet rs) {
		try {
			try {
				if(rs!=null) { rs.close(); rs=null; }
			}catch(Exception e) {}

		}catch(Exception e) {}
	}
	
	public static void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			try {
				if(rs!=null) { rs.close(); rs=null; }
			}catch(Exception e) {}
			
			try {
				if(pstmt!=null) { pstmt.close(); pstmt=null; }
			}catch(Exception e) {}

		}catch(Exception e) {}
	} 

}


