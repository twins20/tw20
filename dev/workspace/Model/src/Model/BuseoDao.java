package Model;

import java.sql.*; 
import java.util.ArrayList; 
import Model1.DBClose;
import Model1.DBConnect;

public class BuseoDao {
	
	DBConnect dbconnect = null; // dbconnect 값을 초기화함
	String sql=""; // sql 값 공백으로
	
	public BuseoDao() { // 클래스명과 같으므로 생성자
		dbconnect = new DBConnect(); // dbconnect 객체를 생성 dbconnect 찾는 곳이 있으면 객체를 생성해서 사용하겠다는 것
		} 	
	
	public ArrayList<BuseoVo> getBuseoList() {  // 제네릭 타입을 통해 BuseoVo타입 선언
		Connection con = dbconnect.getConnection(); // con은 dbconnect 파일에 있는 getconnection을 불러옵니다.
		PreparedStatement pstmt = null;  // pstmt값 초기화
		ResultSet rs = null;  // rs 값 초기화
		ArrayList<BuseoVo> alist = new ArrayList<BuseoVo>(); // alist는 BuseoVo 타입의 배열
		try { 
		String	sql = "select * from buseo order by bidx desc"; // select 구문
			pstmt = con.prepareStatement(sql); // pstmt 값에 sql을 담아서 sql에 있는 select 실행
			rs = pstmt.executeQuery();  // executequery = 결과를 받아와야 하는 select 문에서 사용함
			
			while(rs.next()) { // next = 쿼리를 실행해서 다음의 값이 있는지 확인
			BuseoVo bv = new BuseoVo(); // member vo 객체를 생성 
			
			bv.setBidx(rs.getInt(1));  // vo에 있는 sexidx를 가져오고 거기에 getint값을 넣음
			bv.setBname(rs.getString(2));  // setname 가져오고 getString 값 넣음
			bv.setIdx(rs.getInt(3)); 		
			alist.add(bv); // 배열 add 메소드에 vo 값이 들어감(각각에 값을 할당해주고 add가 실행되어야 값이 들어감)
			}
		}catch(Exception e) { 
			
		}finally { // 무조건 한 번은 실행
			DBClose.close(con,pstmt,rs); //dbclose 클래스에 있는 close를 불러와서 con pstmt rs를 닫아줍니다.
			}
		return alist; // alist 값 반환
		}
	
	public BuseoVo getMember(int bidx) {  // 성별 , 지역
		Connection con = dbconnect.getConnection(); // con은 dbconnect 파일에 있는 getconnection을 불러옵니다.
		PreparedStatement pstmt = null;  // pstmt값 초기화
		ResultSet rs = null;  // rs 값 초기화
		BuseoVo bv = null; // 리턴 vo가 메소드 안 지역변수이므로 가장 위로 빼서 맞춰줌
		try { 
		String	sql = "select bname,idx,bidx from buseo where bidx=?"; // select 구문
			pstmt = con.prepareStatement(sql); // pstmt 값에 sql을 담아서 sql에 있는 select 실행
			pstmt.setInt(1,bidx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // next = 쿼리를 실행해서 다음의 값이 있는지 확인
				bv = new BuseoVo(); // member vo 객체를 생성 
			
			bv.setBname(rs.getString(1)); // getString 괄호 안 sex / area로 작성해도 됨
			bv.setIdx(rs.getInt(2)); 
			bv.setBidx(rs.getInt(3));
			}
		}catch(Exception e) { 
			
		}finally { // 무조건 한 번은 실행
			DBClose.close(con,pstmt,rs); //dbclose 클래스에 있는 close를 불러와서 con pstmt rs를 닫아줍니다.
			}
		return bv; // alist 값 반환
		}

	
	public  int insertWrite(BuseoVo bv, int max) { // 값을 넣는 구문과 관련된 곳
		Connection con = dbconnect.getConnection();  // con은 dbconnect 파일에 있는 getconnection을 불러옵니다.
		PreparedStatement pstmt = null;  // pstmt 초기화
		int row = 0; // row 값을 초기화
		try { sql = "INSERT INTO buseo VALUES(?,?,?)"; // pstmt는 ?로 해도 구문 처리 가능 
		pstmt = con.prepareStatement(sql); //con.pstmt에 sql을 담아서 insert문
		pstmt.setInt(1, max+1); // 데이터를 담는데 max 값에 + 1이 올라감 1번이 idx이므로 idx에 적용
		pstmt.setString(2, bv.getBname()); // pasing = 메소드(아래 만들어둠)
		pstmt.setInt(3, bv.getIdx()); // 
		//	pstmt.execute();
		row = pstmt.executeUpdate(); // executeupdate를 실행하고 난 후 값을 row에 담음(row는 int형)
									// insert update delete와 같은 곳에 사용
		}catch(Exception e) { 
			
		}finally { 
			DBClose.close(con,pstmt); // 끝나면 닫아줌
			} 
			 return row; // row 값 반환
		} 

	public int getMax() { // insertwrite에 들어가는 max 값
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; // rs 값 초기화
		int max = 0; // max 값 초기화
		try { 
			sql = "SELECT MAX(bidx) FROM buseo"; //sql 실행 idx의 max 값을 찾음
			pstmt = con.prepareStatement(sql);  //pstmt값에 sql 담음
			
			rs = pstmt.executeQuery(); // 결과 받아오는 문에 사용하는 execute
			if(rs.next()) { // 값이 있는지 확인
				max=rs.getInt(1); // getint1 = idx에 max 값을 담음
				} 
			}catch(Exception e) { // 예외
				
			}finally { // 무조건 실행
				DBClose.close(con,pstmt,rs); // 닫아줌
				} 
		return max; // max 반환
		}
	
	public BuseoVo Modify(int bidx) {  // 데이터를 수정하기 전에 불러와서 뿌려주는 메소드
		Connection con = dbconnect.getConnection(); // con은 dbconnect 파일에 있는 getconnection을 불러옵니다.
		PreparedStatement pstmt = null;  // pstmt값 초기화
		ResultSet rs = null;  // rs 값 초기화
		BuseoVo bv = null; // 리턴 vo가 메소드 안 지역변수이므로 가장 위로 빼서 맞춰줌
		
		try { 
		String	sql = "select bname, idx from buseo where bidx=?"; // select 구문
		// 데이터를 수정하기 전에 불러와서 뿌려주는 메소드이기 때문에 idx 값을 제외한 모든 컬럼을 불러온다.
			pstmt = con.prepareStatement(sql); // pstmt 값에 sql을 담아서 sql에 있는 select 실행
			pstmt.setInt(1,bidx); // idx값이 조건이기 때문에 set 값 지정해서 담음
			// 하지만 Modify 가서는 idx값을 설정하지 않아 불러오지 못하므로 수정 필요
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // next = 쿼리를 실행해서 다음의 값이 있는지 확인
				bv = new BuseoVo(); // member vo 객체를 생성 
			
			bv.setBname(rs.getString(1));
			bv.setIdx(rs.getInt(2));	
			}
		}catch(Exception e) { 
			
		}finally { // 무조건 한 번은 실행
			DBClose.close(con,pstmt,rs); //dbclose 클래스에 있는 close를 불러와서 con pstmt rs를 닫아줍니다.
			}
			return bv;
		}
	
	public int Update(BuseoVo bv, int bidx) { // 값을 넣는 구문과 관련된 곳 modifyWrite 구문으로 생각
		Connection con = dbconnect.getConnection();  // con은 dbconnect 파일에 있는 getconnection을 불러옵니다.
		PreparedStatement pstmt = null;  // pstmt 초기화
		int ra = 0; // row 값을 초기화
		try { 
			sql = "UPDATE buseo SET Bname = ? , Idx = ? WHERE Bidx= ?"; // pstmt는 ?로 해도 구문 처리 가능 
		pstmt = con.prepareStatement(sql); //con.pstmt에 sql을 담아서 insert문
		pstmt.setString(1, bv.getBname()); // 데이터를 담는데 max 값에 + 1이 올라감 1번이 idx이므로 idx에 적용
		pstmt.setInt(2, bv.getIdx()); // pasing = 메소드(아래 만들어둠)
		pstmt.setInt(3, bidx);
		
		ra = pstmt.executeUpdate(); // executeupdate를 실행하고 난 후 값을 row에 담음(row는 int형)
									// insert update delete와 같은 곳에 사용
		}catch(Exception e) { 
			
		}finally { 
			DBClose.close(con,pstmt); // 끝나면 닫아줌
			} 
			 return ra; // row 값 반환
		}
	
	
	public int Delete(int bidx) { // 값을 넣는 구문과 관련된 곳
		Connection con = dbconnect.getConnection();  // con은 dbconnect 파일에 있는 getconnection을 불러옵니다.
		PreparedStatement pstmt = null;  // pstmt 초기화
		int dt = 0;
		
		try { 
			sql = "DELETE from buseo where bidx=?"; // pstmt는 ?로 해도 구문 처리 가능 
		pstmt = con.prepareStatement(sql); //con.pstmt에 sql을 담아서 insert문
		pstmt.setInt(1, bidx); // 데이터를 담는데 max 값에 + 1이 올라감 1번이 idx이므로 idx에 적용
		dt = pstmt.executeUpdate(); // executeupdate를 실행하고 난 후 값을 row에 담음(row는 int형)
									// insert update delete와 같은 곳에 사용
		}catch(Exception e) { 
			
		}finally { 
			DBClose.close(con,pstmt); // 끝나면 닫아줌
			} 
			 return dt; // row 값 반환
		} 
	
	

	public String pasing(String data) { // insertwrite에 값에 사용한 구문 한글깨짐 방지하는 메소드 생성 Data형 문자열
		try { 
			data = new String(data.getBytes("8859_1"), "UTF-8"); //data는 문자열 타입이고 한글 코팅 8859_1, UTF-8설정
			}catch (Exception e){ // 예외
				
			}
		return data; // data 값을 반환
		}

}
