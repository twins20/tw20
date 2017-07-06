package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.BoardVo;
import common.DBClose;
import common.DBConnect;
import common.PagingQ;

public class BoardNewsServiceImpl {
	
	DBConnect dbconnect = new DBConnect();
	String sql = "";
	
	public ArrayList<BoardVo> boardNewsListCate(String cate, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try {
			
			this.sql = "SELECT * "
				+ 		"FROM TF_BOARD_NEWS "
				+ 		"WHERE VIEWSTAT = 1 "
				+ 			"AND CATE = ? "
				+ 		"ORDER BY OBIDX DESC, RBIDX ASC";
					
			this.sql = new  PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setCommCnt(rs.getInt("commcnt"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
				vo.setpIdx(rs.getInt("pidx"));
								
				alist.add(vo);				
			}
					
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
	
	}
	
	public ArrayList<BoardVo> boardNewsCon(int bidx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try {
			
			this.sql = "SELECT * "
				+	"FROM TF_BOARD_NEWS "
				+	"WHERE BIDX = ?" ;				
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bidx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setCommCnt(rs.getInt("commcnt"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
				
				alist.add(vo);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
	
	}
	
	public ArrayList<BoardCommVo> boardNewsCommList(int bidx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardCommVo> blist = new ArrayList<BoardCommVo>();
		
		try{		
			
			this.sql = "SELECT * "
				+ 	"FROM TF_BOARD_COMM_NEWS "
				+ 	"WHERE BIDX = ? "
				+ 		"AND VIEWSTAT = 1 "
				+ 	"ORDER BY OCOMMIDX DESC, RCOMMIDX ASC";	
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt =con.prepareStatement(this.sql);
			pstmt.setInt(1, bidx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				BoardCommVo vc = new BoardCommVo();			
				vc.setrNum(rs.getInt("rnum"));
				vc.setCommIdx(rs.getInt("commidx"));
				vc.setbIdx(rs.getInt("bidx"));
				vc.setIdx(rs.getInt("idx"));
				vc.setComments(rs.getString("comments"));
				vc.setGood(rs.getInt("good"));
				vc.setBad(rs.getInt("bad"));
				vc.setOcommIdx(rs.getInt("ocommidx"));
				vc.setRcommIdx(rs.getInt("rcommidx"));
							
				blist.add(vc);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return blist;
	
	}
		
	public int boardNewsCommWrite(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;

		try{
			
			this.sql = " INSERT INTO TF_BOARD_COMM_NEWS (COMMIDX, BIDX, IDX, COMMENTS, GOOD, BAD, OCOMMIDX, RCOMMIDX, COMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
				+	" VALUES (SEQ_TF_COMMIDX_NEWS.NEXTVAL, ?, ?, ?, 0, 0, SEQ_TF_COMMIDX_NEWS.CURRVAL, 1, 1, 1, SYSDATE, SYSDATE) ";			
		
			pstmt = con.prepareStatement(this.sql);
			
			pstmt.setInt(1, vc.getbIdx());
			pstmt.setInt(2, vc.getIdx());
			pstmt.setString(3, vc.getComments());
			
			row = pstmt.executeUpdate();
				
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row;
	
	}
	
	public int boardNewsSubCommWriteTransaction(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			 
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_BOARD_COMM_NEWS "
				+	"SET RCOMMIDX = RCOMMIDX + 1 "
				+	"WHERE OCOMMIDX = (SELECT OCOMMIDX FROM TF_BOARD_COMM_NEWS WHERE COMMIDX = ?) "
				+ 		"AND RCOMMIDX > (SELECT RCOMMIDX FROM TF_BOARD_COMM_NEWS WHERE COMMIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql);	
			
			pstmt.setInt(1, vc.getOcommIdx());
			pstmt.setInt(2, vc.getOcommIdx());
							
			row = pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_BOARD_COMM_NEWS (COMMIDX, BIDX, IDX, COMMENTS, GOOD, BAD, OCOMMIDX, RCOMMIDX, COMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
				+	"VALUES (SEQ_TF_COMMIDX_NEWS.NEXTVAL, (SELECT BIDX FROM TF_BOARD_COMM_NEWS WHERE COMMIDX = ?), ?, ?, 0, 0, (SELECT OCOMMIDX FROM TF_BOARD_COMM_NEWS WHERE COMMIDX = ?), (SELECT RCOMMIDX FROM TF_BOARD_COMM_NEWS WHERE COMMIDX = ?) + 1, (SELECT COMMDEPTH FROM TF_BOARD_COMM_NEWS WHERE COMMIDX = ?) + 1, 1, SYSDATE, SYSDATE)";	
				
			pstmt = con.prepareStatement(this.sql);
			
			pstmt.setInt(1, vc.getOcommIdx());
			pstmt.setInt(2, vc.getIdx());
			pstmt.setString(3, vc.getComments());
			pstmt.setInt(4, vc.getOcommIdx());
			pstmt.setInt(5, vc.getOcommIdx());
			pstmt.setInt(6, vc.getOcommIdx());			
			
			row += pstmt.executeUpdate();
			
			con.commit();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			try{
				con.rollback();
			} catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				con.setAutoCommit(true);
			}catch(Exception e){
				e.getMessage();
			}
			DBClose.close(con,pstmt);
		}
		
		return row;
		
	}
	
	
	public int boardNewsCommWriteCntMod(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{			
			
			this.sql = " UPDATE TF_BOARD_COMM_NEWS "
				+	" SET COMMENTS = ?, MODDATE = SYSDATE "
				+	" WHERE COMMIDX = ? ";
			
			pstmt = con.prepareStatement(this.sql);			
			pstmt.setString(1, vc.getComments());
			pstmt.setInt(2, vc.getCommIdx());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row;
	
	}
			
	public ArrayList<ProjectVo> boardNewsProjList(int bidx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
		
		try{
			
			this.sql = "SELECT * "
				+	"FROM TF_PROJECT_LIST "
				+	"WHERE PIDX = (SELECT PIDX FROM TF_BOARD_NEWS WHERE BIDX = ?)";
			
			this.sql=new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bidx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				ProjectVo vo = new ProjectVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setItList(rs.getString("itlist"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				
				alist.add(vo);	
			}			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
	}
				
	public int boardNewsHit(int bidx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			
			this.sql = "UPDATE TF_BOARD_NEWS "
				+ 	"SET HIT = HIT +1 "
				+ 	"WHERE BIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);		
			pstmt.setInt(1, bidx);		
			row = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row;	 
	
	}
		
	 public int boardNewsCommDel(int bidx){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			  
			  this.sql="UPDATE TF_BOARD_COMM_NEWS "
		  	 	  +	  "SET VIEWSTAT = 0 "
		  	  	  +   "WHERE BIDX = ?";
			   
			  pstmt = con.prepareStatement(this.sql);
			  pstmt.setInt(1, bidx);
			  
			  row = pstmt.executeUpdate();
			  
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }finally{
			  DBClose.close(con,pstmt);
		  }
		  
		  return row;
	  
	 }
		
}