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

public class BoardNoticeServiceImpl {
	
	DBConnect dbconnect = new DBConnect();
	String sql = "";
	
	//공지사항 카테고리 리스트 
	public ArrayList<BoardVo> boardNoticeListCate(String cate, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT * "
				+		"FROM TF_BOARD_NOTICE "
				+		"WHERE VIEWSTAT = 1 "
				+			"AND  CATE = ? "
				+		"ORDER BY OBIDX DESC, RBIDX ASC";
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
						
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1,cate);
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

	//공지사항 카테고리 리스트 Cnt 
	public int boardNoticeListCateTtCnt(String cate){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		try{
			
			this.sql = "SELECT BIDX, CATE, TITLE, HIT, INSDATE "
				+		"FROM TF_BOARD_NOTICE "
				+		"WHERE VIEWSTAT = 1 "
				+			"AND  CATE = ? "
				+		"ORDER BY OBIDX DESC, RBIDX ASC";
			
			this.sql = new PagingQ().pagingCnt(this.sql);
						
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1,cate);
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
	
	//공지사항 전체 리스트
	public ArrayList<BoardVo> boardNoticeList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT * "
					+ 		"FROM TF_BOARD_NOTICE "
					+ 		"WHERE VIEWSTAT = 1 "
			 		+ 			"AND BDEPTH = 1 "
					+		"ORDER BY OBIDX DESC, RBIDX ASC";
			
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

	//공지사항 리스트 Cnt
	public int boardNoticeListTtCnt(){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		try{
			
			this.sql = "SELECT * "
					+ 		"FROM TF_BOARD_NOTICE "
					+ 		"WHERE VIEWSTAT = 1 "
			 		+ 			"AND BDEPTH = 1 "
					+		"ORDER BY OBIDX DESC, RBIDX ASC";
			
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

	//공지사항 프로젝트 리스트 
	public ProjectVo boardNoticeProjList(int pIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		ProjectVo vo = new ProjectVo();
		
		try{
			
			this.sql = "SELECT * "
				+	"FROM TF_PROJECT_LIST "
				+	"WHERE PIDX = (SELECT PIDX FROM TF_BOARD_NOTICE WHERE BIDX = ?)";
							
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
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

	//공지사항 게시판 내용
	public BoardVo boardNoticeCon(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		BoardVo vo = null;
		
		try{
			
			this.sql = "SELECT * "
				+		"FROM TF_BOARD_NOTICE "
				+		"WHERE BIDX = ? ";
			
			pstmt = con.prepareStatement(this.sql);
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

	//공지사항 게시판 작성 
	public int boardNoticeWrite(BoardVo vo){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			 
			  this.sql=	"INSERT INTO TF_BOARD_NOTICE (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE ) "
			  	+		"VALUES (SEQ_TF_BIDX_NOTICE.NEXTVAL, ?, ?, ?, ?, 0, 0, 0, SEQ_TF_BIDX_NOTICE.CURRVAL, 1, 1, 0, 1, SYSDATE, SYSDATE)";
		 
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

	//공지사항 게시판 수정
	public int boardNoticeMod(BoardVo vo){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			  
			  this.sql = "UPDATE TF_BOARD_NOTICE "
				  +	  	 "SET TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "
			  	  +	  	 "WHERE BIDX = ? ";
			  		  
			  pstmt = con.prepareStatement(this.sql);
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

	//공지사항 게시판 삭제 
	public int boardNoticeDel(int bIdx){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			
			  this.sql = "UPDATE TF_BOARD_NOTICE "
		  		  +		"SET VIEWSTAT = 0 "
		  		  +		"WHERE BIDX = ? ";
			  
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

	//공지사항 게시판 댓글 리스트
	public ArrayList<Map<String, Object>> boardNoticeCommList(int bIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
	
		try{		
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_NOTICE A, TF_MEMBER B "
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
	
	//공지사항 게시판 댓글 리스트 Cnt
	public int boardNoticeCommListTtCnt(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;

		try{		
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_NOTICE A, TF_MEMBER B "
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
	
	//공지사항 게시판 대댓글 리스트 
	public ArrayList<Map<String, Object>> BoardNoticeSubCommList(int commIdx, int bIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 

		try{
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_NOTICE A,TF_MEMBER B "
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
	
	//공지사항 게시판 대댓글 리스트 Cnt
	public int BoardNoticeSubCommListTtCnt(int commIdx, int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;

		try{
			
			this.sql = "SELECT A.*, B.NICK "
				+ 	"FROM TF_BOARD_COMM_NOTICE A,TF_MEMBER B "
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
	
	//공지사항 게시판 댓글 작성 
	public int boardNoticeCommWrite(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			
			this.sql = "INSERT INTO TF_BOARD_COMM_NOTICE (COMMIDX, BIDX, IDX, COMMENTS, GOOD, BAD, OCOMMIDX, RCOMMIDX, COMMDEPTH, VIEWSTAT, INSDATE, MODDATE ) "
				+	"VALUES (SEQ_TF_COMMIDX_NOTICE.NEXTVAL, ?, ?, ?, 0, 0, SEQ_TF_COMMIDX_NOTICE.CURRVAL, 1, 1, 1, SYSDATE, SYSDATE )";			
		
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
	
	//공지사항 대댓글 작성 
	public int boardNoticeSubCommWriteTransaction(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			 
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_BOARD_COMM_NOTICE "
				+	"SET RCOMMIDX = RCOMMIDX + 1 "
				+	"WHERE OCOMMIDX = ? "
				+ 		"AND BIDX = ?";
		
			pstmt = con.prepareStatement(this.sql);	
			
			pstmt.setInt(1, vc.getCommIdx());
			pstmt.setInt(2, vc.getbIdx());
							
			row += pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_BOARD_COMM_NOTICE (COMMIDX, BIDX, IDX, COMMENTS, GOOD, BAD, OCOMMIDX, RCOMMIDX, COMMDEPTH, VIEWSTAT, INSDATE, MODDATE ) "
				+	"VALUES (SEQ_TF_COMMIDX_NOTICE.NEXTVAL, ?, ?, ?, 0, 0, ?, 1, 1, 1, SYSDATE, SYSDATE )";	
				
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
	
	//공지사항 댓글 수정
	public int boardNoticeCommWriteCntMod(BoardCommVo vc){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;

		try{			
			
			this.sql = " UPDATE TF_BOARD_COMM_NOTICE "
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
	
	 // 공지사항 댓글 삭제 
	 public int boardNoticeCommDel(int commIdx){
		  
		  Connection con = dbconnect.getConnection();
		  PreparedStatement pstmt = null;
		  int row = 0;
		  
		  try{
			  
			  this.sql = "UPDATE TF_BOARD_COMM_NOTICE "
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
	
	//공지사항 게시판 조회수 
	public int boardNoticeHit(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			
			this.sql = "UPDATE TF_BOARD_NOTICE "
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
		
	//공지사항 게시판 추천
	public int boardNoticeGood(int bIdx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			
			this.sql = "UPDATE TF_BOARD_NOTICE "
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
	
	//공지사항 게시판 반대
	public int boardNoticeBad(int bIdx){
	
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
	
		try{
		
			this.sql = "UPDATE TF_BOARD_NOTICE "
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
	
	//공지사항 게시판 답글
	public int boardNoticeReplyWrite(BoardVo inputBV){
	
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
	
		try {
		
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_BOARD_NOTICE " 
				+		"SET RBIDX = RBIDX + 1 "
				+		"WHERE OBIDX = (SELECT OBIDX FROM TF_BOARD_NOTICE WHERE BIDX = ?) " 
				+			"AND RBIDX > (SELECT RBIDX FROM TF_BOARD_NOTICE WHERE BIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, inputBV.getbIdx());
			pstmt.setInt(2, inputBV.getbIdx());
						
			row += pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_BOARD_NOTICE (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, ) "
				+		"VALUES (SEQ_TF_BIDX_NOTICE.NEXTVAL, ?, ?, ?, ?, 0, 0, 0, (SELECT OBIDX FROM TF_BOARD_NOTICE WHERE BIDX = ?), (SELECT RBIDX FROM TF_BOARD_NOTICE WHERE BIDX = ?) + 1, (SELECT BDEPTH FROM TF_BOARD_NOTICE WHERE BIDX = ?) + 1, 0, 1, SYSDATE, SYSDATE) ";
	
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