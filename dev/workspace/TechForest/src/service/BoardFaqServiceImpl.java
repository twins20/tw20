package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import common.DBClose;
import common.DBConnect;
import common.PagingQ;

public class BoardFaqServiceImpl {
	DBConnect dbconnect = new DBConnect();
	String sql = "";

	//FAQ 게시판 카테고리 별 리스트 
	public ArrayList<BoardVo> boardFaqListCate(String cate, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try {
			
			this.sql = "SELECT * "
				+ 		"FROM TF_BOARD_FAQ "
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
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setCommCnt(rs.getInt("commcnt"));
				vo.setbDepth(rs.getInt("bdepth"));
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

	//FAQ 게시판 카테고리 리스트 Cnt
	public int boardFaqListCateTtCnt(String cate){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		try {
			
			this.sql = "SELECT * "
				+ 		"FROM TF_BOARD_FAQ "
				+ 		"WHERE VIEWSTAT = 1 "
				+ 			"AND CATE = ? "
				+ 		"ORDER BY OBIDX DESC, RBIDX ASC";
					
			this.sql = new  PagingQ().pagingCnt(this.sql);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				row = rs.getInt(1);	
			}
					
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return row;
	
	}		
	
	//FAQ 전체 리스트 
	public ArrayList<BoardVo> boardFaqList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT * "
				+	"FROM TF_BOARD_FAQ "
				+	"ORDER BY BIDX DESC ";		
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setbIdx(rs.getInt("bidx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setCommCnt(rs.getInt("commcnt"));
				vo.setbDepth(rs.getInt("bdepth"));
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

	//FAQ 전체 리스트 Cnt
	public int boardFaqListTtCnt(){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		try{
			
			this.sql = "SELECT * "
				+	"FROM TF_BOARD_FAQ "
				+	"ORDER BY BIDX DESC ";		
			
			this.sql = new PagingQ().pagingCnt(this.sql);
			
			pstmt = con.prepareStatement(this.sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				row = rs.getInt(1);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return row;
		
	}

	//FAQ 게시판 프로젝트 리스트 	
	public ProjectVo boardFaqProjList(int pIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		ProjectVo vo = null;
		
		try{
			
			this.sql = "SELECT * "
				+	"FROM TF_PROJECT_LIST "
				+	"WHERE PIDX = (SELECT PIDX FROM TF_BOARD_FAQ WHERE BIDX = ?)";
							
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				vo = new ProjectVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setItList(rs.getString("itlist"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));					
				
			}			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return vo;
	}

	//FAQ 게시판 내용
	public BoardVo boardFaqCon(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		BoardVo vo = null;

		try{
			
			this.sql = "SELECT * "
				+	"FROM TF_BOARD_FAQ "
				+	"WHERE BIDX = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
			
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{

			DBClose.close(con,pstmt,rs);
		}
		
		return vo;
	}

	//FAQ 게시판 작성	
	public int boardFaqWrite(BoardVo vo){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			 
			  this.sql=	"INSERT INTO TF_BOARD_FAQ (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE) "
			  	  +		"VALUES (SEQ_TF_BIDX_FAQ.NEXTVAL, ?, ?, ?, ?, 0, 0, 0, SEQ_TF_BIDX_FAQ.CURRVAL, 1, 1, 0, 1, SYSDATE, SYSDATE)";
		 
			  pstmt=con.prepareStatement(this.sql);
			  pstmt.setInt(1, vo.getIdx());
			  pstmt.setString(2, vo.getCate());
			  pstmt.setString(3, vo.getTitle());
			  pstmt.setString(4, vo.getContents());			  		  
			  row = pstmt.executeUpdate();	 
		  
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }finally{
			  DBClose.close(con,pstmt);
		  }
		  
		  return row;
		  
	  }	

	//FAQ 게시판 수정	
	public int boardFaqMod(BoardVo vo){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			  
			  this.sql = "UPDATE TF_BOARD_FAQ "
				  +	  	 "SET TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "
			  	  +	  	 "WHERE BIDX = ? ";
			  		  
			  pstmt=con.prepareStatement(this.sql);
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

	//FAQ 게시판 삭제	
	public int boardFaqDel(int bIdx){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			
			  this.sql = "UPDATE TF_BOARD_FAQ "
		  		  +		 "SET VIEWSTAT = 0 "
		  		  +		 "WHERE BIDX = ? ";
			  
			  pstmt = con.prepareStatement(this.sql);
			  pstmt.setInt(1, bIdx);		  
			  row = pstmt.executeUpdate();
			  
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }finally{
			  DBClose.close(con,pstmt);
		  }
		  
		  return row;
	  
	      }

	public ArrayList<Map<String, Object>> boardFaqCommList(int bIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();

		try{		
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_FAQ A, TF_MEMBER B "
				+ 	"WHERE A.IDX = B.IDX "
				+ 		"AND A.BIDX = ? "
				+ 		"AND A.OCOMMIDX = A.COMMIDX "
				+ 		"AND A.VIEWSTAT = 1 "
				+ 	"ORDER BY A.OCOMMIDX DESC, A.RCOMMIDX ASC";	
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bIdx);		
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				Map<String, Object> data = new HashMap<String, Object>();
				
				BoardCommVo commvo = new BoardCommVo();			
				commvo.setrNum(rs.getInt("rnum"));
				commvo.setComments(rs.getString("comments"));
				commvo.setGood(rs.getInt("good"));
				commvo.setBad(rs.getInt("bad"));
				commvo.setCommIdx(rs.getInt("commIdx"));
				commvo.setbIdx(rs.getInt("bIdx"));
				commvo.setIdx(rs.getInt("idx"));
				
				MemberVo mvo = new MemberVo();
				mvo.setNick(rs.getString("nick"));
				
				data.put("vo", commvo);
				data.put("vo2", mvo);
				
				alist.add(data);	
							
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
	
	}
	
	//FAQ 게시판 댓글 리스트 Cnt
	public int boardFaqCommListTtCnt(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;

		try{		
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_FAQ A, TF_MEMBER B "
				+ 	"WHERE A.IDX = B.IDX "
				+ 		"AND A.BIDX = ? "
				+ 		"AND A.OCOMMIDX = A.COMMIDX "
				+ 		"AND A.VIEWSTAT = 1 "
				+ 	"ORDER BY A.OCOMMIDX DESC, A.RCOMMIDX ASC";	
			
			this.sql = new PagingQ().pagingCnt(this.sql);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bIdx);		
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				row = rs.getInt(1);	
				
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return row;
	
	}	
	
	//FAQ 게시판 대댓글 리스트 
	public ArrayList<Map<String, Object>> BoardFaqSubCommList(int commIdx, int bIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 

		try{
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_FAQ A,TF_MEMBER B "
				+ 	"WHERE A.IDX = B.IDX "
				+ 		"AND A.OCOMMIDX = ? "
				+  		"AND A.BIDX = ? "
				+ 		"AND A.COMMIDX > A.OCOMMIDX "
				+ 		"AND A.VIEWSTAT = 1 "
				+ 	"ORDER BY A.OCOMMIDX ASC, A.RCOMMIDX DESC";	
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, commIdx);
			pstmt.setInt(2,  bIdx);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				Map<String, Object> data = new HashMap<String, Object>();
				
				BoardCommVo commvo = new BoardCommVo();
				commvo.setrNum(rs.getInt("rnum"));
				commvo.setComments(rs.getString("comments"));
				commvo.setGood(rs.getInt("good"));
				commvo.setBad(rs.getInt("bad"));
				commvo.setCommIdx(rs.getInt("commIdx"));
				commvo.setbIdx(rs.getInt("bIdx"));
				commvo.setIdx(rs.getInt("idx"));
				
				MemberVo mvo = new MemberVo();
				mvo.setNick(rs.getString("nick"));
				
				data.put("vo", commvo);
				data.put("vo2", mvo);			
				
				alist.add(data);
			
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
	
	}
	
	//FAQ 게시판 대댓글 리스트 Cnt
	public int BoardFaqSubCommListTtCnt(int commIdx, int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;

		try{
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_FAQ A,TF_MEMBER B "
				+ 	"WHERE A.IDX = B.IDX "
				+ 		"AND A.OCOMMIDX = ? "
				+  		"AND A.BIDX = ? "
				+ 		"AND A.COMMIDX > A.OCOMMIDX "
				+ 		"AND A.VIEWSTAT = 1 "
				+ 	"ORDER BY A.OCOMMIDX ASC, A.RCOMMIDX DESC";	
			
			this.sql = new PagingQ().pagingCnt(this.sql);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, commIdx);
			pstmt.setInt(2,  bIdx);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				row = rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return row;
	
	}	

	//FAQ 게시판 댓글 작성 	
	public int boardFaqCommWrite(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;

		try{
			
			this.sql = " INSERT INTO TF_BOARD_COMM_FAQ (COMMIDX, BIDX, IDX, COMMENTS, GOOD, BAD, OCOMMIDX, RCOMMIDX, COMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
				+	" VALUES (SEQ_TF_COMMIDX_FAQ.NEXTVAL, ?, ?, ?, 0, 0, SEQ_TF_COMMIDX_FAQ.CURRVAL, 1, 1, 1, SYSDATE, SYSDATE) ";			
		
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

	//FAQ 대댓글 작성 	
	public int boardFaqSubCommWriteTransaction(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			 
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_BOARD_COMM_FAQ "
				+	"SET RCOMMIDX = RCOMMIDX + 1 "
				+	"WHERE OCOMMIDX = ? "
				+ 		"AND BIDX = ?";
		
			pstmt = con.prepareStatement(this.sql);	
			
			pstmt.setInt(1, vc.getCommIdx());
			pstmt.setInt(2, vc.getbIdx());
							
			row += pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_BOARD_COMM_FAQ (COMMIDX, BIDX, IDX, COMMENTS, GOOD, BAD, OCOMMIDX, RCOMMIDX, COMMDEPTH, VIEWSTAT, INSDATE, MODDATE ) "
				+	"VALUES (SEQ_TF_COMMIDX_FAQ.NEXTVAL, ?, ?, ?, 0, 0, ?, 1, 1, 1, SYSDATE, SYSDATE )";	
				
			pstmt = con.prepareStatement(this.sql);
		
			pstmt.setInt(1, vc.getbIdx());
			pstmt.setInt(2, vc.getIdx());
			pstmt.setString(3, vc.getComments());
			pstmt.setInt(4, vc.getCommIdx());
				
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
	
	
	//FAQ 댓글 수정
	public int boardFaqCommWriteCntMod(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;

		try{			
			
			this.sql = " UPDATE TF_BOARD_COMM_FAQ "
				+	" SET COMMENTS = ?, MODDATE = SYSDATE "
				+	" WHERE COMMIDX = ? "
				+ 		"AND BIDX = ?";
			
			pstmt = con.prepareStatement(this.sql);			
			pstmt.setString(1, vc.getComments());
			pstmt.setInt(2, vc.getCommIdx());
			pstmt.setInt(3, vc.getbIdx());		
			row = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row;
	
	}
	
	 //FAQ 댓글 삭제 
	 public int boardFaqCommDel(int commIdx){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			  //
			  this.sql = "UPDATE TF_BOARD_COMM_FAQ "
		  	 	  +	  "SET VIEWSTAT = 0 "
		  	  	  +   "WHERE COMMIDX = ?";			  
			  
			  pstmt = con.prepareStatement(this.sql);
			  pstmt.setInt(1,commIdx);
			  row = pstmt.executeUpdate();
			  
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }finally{
			  DBClose.close(con,pstmt);
		  }
		  
		  return row;
	  
	 }
	
	//FAQ 게시판 조회수 
	public int boardFaqHit(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			
			this.sql = "UPDATE TF_BOARD_FAQ "
				+ 	"SET HIT = HIT +1 "
				+ 	"WHERE BIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);		
			pstmt.setInt(1, bIdx);		
			row = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row;	 
	
	}
		
	//FAQ 게시판 추천
	public int boardFAQGood(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			
			this.sql = "UPDATE TF_BOARD_FAQ "
				+ 	"SET GOOD = GOOD + 1 "
				+ 	"WHERE BIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);		
			pstmt.setInt(1, bIdx);	
			row = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row;	 
		
	}
	
	//FAQ 게시판 반대
	public int boardFaqBad(int bIdx){
	
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
	
		try{
		
			this.sql = "UPDATE TF_BOARD_FAQ "
				+ 	"SET BAD = BAD +1 "
				+ 	"WHERE BIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);		
			pstmt.setInt(1, bIdx);	
			row = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row;	 
	
	}
	
	//FAQ 게시판 답글
	public int boardFaqReplyWrite(BoardVo inputBV){
	
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
	
		try {
		
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_BOARD_FAQ " 
				+	"SET RBIDX = RBIDX + 1 "
				+	"WHERE OBIDX = (SELECT OBIDX FROM TF_BOARD_FAQ WHERE BIDX = ?) " 
				+		"AND RBIDX > (SELECT RBIDX FROM TF_BOARD_FAQ WHERE BIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, inputBV.getbIdx());
			pstmt.setInt(2, inputBV.getbIdx());
						
			row += pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_BOARD_FAQ (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, ) "
				+	"VALUES (SEQ_TF_BIDX_FAQ.NEXTVAL, ?, ?, ?, ?, 0, 0, 0, (SELECT OBIDX FROM TF_BOARD_FAQ WHERE BIDX = ?), (SELECT RBIDX FROM TF_BOARD_FAQ WHERE BIDX = ?) + 1, (SELECT BDEPTH FROM TF_BOARD_FAQ WHERE BIDX = ?) + 1, 0, 1, SYSDATE, SYSDATE) ";
	
			pstmt = con.prepareStatement(this.sql);
			
			pstmt.setInt(1, inputBV.getIdx());
			pstmt.setString(2, inputBV.getCate());
			pstmt.setString(3, inputBV.getTitle());
			pstmt.setString(4, inputBV.getContents());
			pstmt.setInt(5, inputBV.getbIdx());
			pstmt.setInt(6, inputBV.getbIdx());
			pstmt.setInt(7, inputBV.getbIdx());
			
			row += pstmt.executeUpdate();
	
			con.commit();
		
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally {
			try{
				con.setAutoCommit(true);
			}catch(Exception e){
				e.getMessage();
			}
			DBClose.close(con,pstmt); 
		}
	
		return row;		
}
		
}