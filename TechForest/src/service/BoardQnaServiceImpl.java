package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import service.BoardVo;
import common.DBClose;
import common.DBConnect;
import common.PagingQ;


public class BoardQnaServiceImpl {
	
	DBConnect dbconnect = new DBConnect();
	String sql = "";
		
	public ArrayList<BoardVo> boardQnaList(int idx, int listCnt, int pageCnt){
		  
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		  
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		  
		try{
			  
			this.sql = "SELECT * "
			  	+ 		"FROM TF_BOARD_QNA "
			  	+ 		"WHERE VIEWSTAT = 1 "
		 		+ 			"AND BDEPTH = 1 "
		 		+ 			"AND IDX = ?";	
			  
			this.sql=new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			  
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			  
			while(rs.next()){
				  
			  BoardVo vo = new BoardVo();  			  
			  vo.setrNum(rs.getInt("rnum"));
			  vo.setbIdx(rs.getInt("bidx"));
			  vo.setIdx(rs.getInt("idx"));
			  vo.setpIdx(rs.getInt("pidx"));
			  vo.setCate(rs.getString("cate"));
			  vo.setTitle(rs.getString("title"));
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

	public int boardQnaWrite(BoardVo vo){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			 
			  this.sql=	"INSERT INTO TF_BOARD_QNA (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, EXTCOLUMN) "
			  	+	"VALUES (SEQ_TF_BIDX_QNA.NEXTVAL, ?, ?, ?, ?, 0, 0, 0, SEQ_TF_BIDX_QNA.CURRVAL, 1, 1, 1, 0, SYSDATE, SYSDATE, ?)";
		 
			  pstmt=con.prepareStatement(sql);
			  
			  pstmt.setInt(1, vo.getIdx());
			  pstmt.setString(2, vo.getCate());
			  pstmt.setString(3, vo.getContents());
			  pstmt.setString(4, vo.getTitle());
//			  pstmt.setString(5, vo.getExtColumn());
			  		  
			  row = pstmt.executeUpdate();	  
			  System.out.println(row);
		  
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }finally{
			  DBClose.close(con,pstmt);
		  }
		  
		  return row;
		  
	  }
	  
	public ArrayList<BoardVo> boardQnaCon(int bidx){
		
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  
		  ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		  
		  try{
			  
			  this.sql="SELECT * "
			  	+	"FROM TF_BOARD_QNA "
			  	+	"WHERE BIDX = ? ";
			 
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bidx);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setHit(rs.getInt("hit"));
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

	  
	public ArrayList<ProjectVo> boardQnaProjList(int bidx, int listCnt, int pageCnt){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  
		  ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
		  
		  try{
			  
			  this.sql="SELECT * "
			  	  +	  "FROM TF_PROJECT_LIST	"
			  	  +	  "WHERE PIDX = (SELECT PIDX FROM TF_BOARD_QNA WHERE BIDX = ? )";
			 
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
	  
	public int boardQnaMod(BoardVo vo){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			  
			  this.sql="UPDATE TF_BOARD_QNA "
				  +	   "SET TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "
			  	  +	   "WHERE BIDX = ? ";
			  		  
			  pstmt=con.prepareStatement(sql);
			 
			  pstmt.setString(1, vo.getTitle());
			  pstmt.setString(2, vo.getContents());
			  pstmt.setInt(3, vo.getbIdx());
			  row = pstmt.executeUpdate();
			  
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }finally{
			  DBClose.close(con,pstmt);
		  }
		  
		  return row;
		  
	  }
	  
	public int boardQnaDel(int bidx){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			
			  this.sql = "UPDATE TF_BOARD_QNA "
		  		+	"SET VIEWSTAT = 0 "
		  		+	"WHERE BIDX = ? ";
			  
			  pstmt = con.prepareStatement(sql);
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
