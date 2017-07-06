package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import common.*;

public class CMemberServiceImpl {

	DBConnect dbconnect = new DBConnect();
	String sql = null;
	CMemberServiceSql cMemberSql = new CMemberServiceSql();
	
	public ProjectVo cMemIndexProjNowList(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ProjectVo vo = new ProjectVo(); 

		try { 
			
			this.sql = cMemberSql.getcMemIndexProjNowList();
			
//			this.sql = "SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
//				+	"FROM TF_PROJECT_LIST "
//				+	"WHERE STATUS = 1 "
//				+		"AND IDX = ?";
		
//			this.sql = new PagingQ().pagingStr(sql, 10, 1);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
								
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
				vo.setStatus(rs.getInt("status"));
				
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public ArrayList<ProjectCommVo> cMemIndexCommList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectCommVo> alist = new ArrayList<ProjectCommVo>(); 

		try { 
			
			this.sql = cMemberSql.getcMemIndexCommList();
			
//			this.sql = "SELECT * "
//				+	"FROM TF_PROJECT_COMM "
//				+	"WHERE VIEWSTAT = 1 "
//				+		"AND PIDX = (SELECT PIDX FROM TF_PROJECT_LIST WHERE STATUS = 1 AND IDX = ?) "
//				+	"ORDER BY OPCOMMIDX DESC, RPCOMMIDX ASC";
		
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				ProjectCommVo vo = new ProjectCommVo(); 
				vo.setpCommIdx(rs.getInt("pcommidx"));
				vo.setComments(rs.getString("comments"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setOpCommIdx(rs.getInt("opcommidx"));
				vo.setRpCommIdx(rs.getInt("rpcommidx"));
				vo.setpCommDepth(rs.getInt("pcommdepth"));
				vo.setViewStat(rs.getInt("viewstat"));
				
				alist.add(vo);
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public ArrayList<BoardVo> cMemIndexNewsList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 

		try { 

			this.sql = cMemberSql.getcMemIndexNewsList();
			
//			this.sql = "SELECT B.* "
//				+	"FROM TF_PROJECT_LIST A, TF_BOARD_NEWS B "
//				+	"WHERE B.VIEWSTAT = 1 "
//				+		"AND A.PIDX = B.PIDX "
//				+		"AND A.IDX = ? "
//				+	"ORDER BY B.OBIDX DESC, B.RBIDX ASC";
		
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				BoardVo vo = new BoardVo(); 
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setObIdx(rs.getInt("obidx"));
				vo.setRbIdx(rs.getInt("rbidx"));
				vo.setbDepth(rs.getInt("bdepth"));
				vo.setCommCnt(rs.getInt("commcnt"));
				vo.setViewStat(rs.getInt("viewstat"));
				
				alist.add(vo);
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public MemberVo cMemInfoCon(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		MemberVo vo = new MemberVo(); 

		try { 

			this.sql = cMemberSql.getcMemInfoCon();
			
//			this.sql = "SELECT A.*, B.* "
//					+	"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
//					+	"WHERE A.IDX = B.IDX "
//					+	"AND A.IDX = ?";
		
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setNick(rs.getString("nick"));
				vo.setPhone(rs.getInt("phone"));
				vo.setAddr(rs.getString("addr"));
				vo.setStatus(rs.getInt("status"));
				vo.setType(rs.getString("type"));
				vo.setCompany(rs.getString("company"));
				vo.setcNumber(rs.getString("cnumber"));
				vo.setcAddr(rs.getString("caddr"));
				
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public int cMemInfoModChk(MemberVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
		
		try { 

			this.sql = cMemberSql.getcMemInfoModChk();
			
//			this.sql = "SELECT COUNT(*) "
//				+	"FROM TF_MEMBER "
//				+	"WHERE IDX = ? "
//				+		"AND PW = ?";
		
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, inputMV.getIdx());
			pstmt.setString(2, inputMV.getPw());
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				row = rs.getInt(1);
							
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return row;
		
	}
	
	public int cMemInfoMod(MemberVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 

			this.sql = cMemberSql.getcMemInfoMod();
			
//			this.sql = "UPDATE TF_MEMBER "
//				+	"SET PW = ?, NICK = ?, PHONE = ?, ADDR = ?, MODDATE = SYSDATE "
//				+	"WHERE IDX = ?";
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, inputMV.getPw());
			pstmt.setString(2, inputMV.getNick());
			pstmt.setInt(3, inputMV.getPhone());
			pstmt.setString(4, inputMV.getAddr());
			pstmt.setInt(5, inputMV.getIdx());
			row = pstmt.executeUpdate();
				
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int cMemInfoExtWriteChk(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
		
		try { 
			
			this.sql = cMemberSql.getcMemInfoExtWriteChk();
			
//			this.sql = "SELECT COUNT(*) "
//				+	"FROM TF_CMEMBER_EXT "
//				+	"WHERE IDX = ?";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				row = rs.getInt(1);
				
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return row;
		
	}
	
	public int cMemInfoExtWrite(MemberVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = cMemberSql.getcMemInfoExtWrite();
			
//			this.sql = "INSERT INTO TF_CMEMBER_EXT (CIDX, IDX, COMPANY, CNUMBER, CADDR) "
//				+	"VALUES (SEQ_TF_CIDX.NEXTVAL, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputMV.getIdx());
			pstmt.setString(2, inputMV.getCompany());
			pstmt.setString(3, inputMV.getcNumber());
			pstmt.setString(4, inputMV.getcAddr());
			row = pstmt.executeUpdate();
				
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public ArrayList<MemberVo> cMemMemoWriteIMemList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();
		
		try { 
			
			this.sql = cMemberSql.getcMemMemoWriteIMemList();
			
//			this.sql = "SELECT DISTINCT(A.NICK), A.IDX "
//				+	"FROM TF_MEMBER A, TF_PROJECT_LIST B, TF_FUND_HIS C "
//				+	"WHERE B.PIDX = C.PIDX "
//				+		"AND A.IDX = C.IDX "
//				+		"AND B.PIDX = ? "
//				+	"ORDER BY A.IDX ASC";
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				MemberVo vo = new MemberVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setNick(rs.getString("nick"));
				
				alist.add(vo);
			}
				
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public int cMemMemoWrite(MemoVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0; 
		
		try { 
			
			this.sql = cMemberSql.getcMemMemoWrite();
			
//			this.sql = "INSERT INTO TF_MEMO_LIST(MEMOIDX, SENDIDX, RECVIDX, CONTENTS, STATUS, INSDATE) "
//				+	"VALUES(SEQ_TF_MEMOIDX.NEXTVAL, ?, ?, ?, 0, SYSDATE)";
								
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputMV.getSendIdx());
			pstmt.setInt(2, inputMV.getRecvIdx());
			pstmt.setString(3, inputMV.getContents());
			row = pstmt.executeUpdate();
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public ArrayList<MemoVo> cMemMemoSendList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		ArrayList<MemoVo> alist = new ArrayList<MemoVo>();
		
		try { 

			this.sql = cMemberSql.getcMemMemoSendList();
			
//			this.sql = "SELECT * "
//				+	"FROM TF_MEMO_LIST "
//				+	"WHERE SENDIDX = ? "
//				+		"AND (STATUS = 0 OR STATUS = 2) "
//				+	"ORDER BY MEMOIDX DESC";

			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				MemoVo vo = new MemoVo();
				vo.setMemoIdx(rs.getInt("memoidx"));
				vo.setSendIdx(rs.getInt("sendidx"));
				vo.setRecvIdx(rs.getInt("recvidx"));
				vo.setContents(rs.getString("contents"));
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public int cMemMemoDel(int memoIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
				
		try { 
			
			this.sql = cMemberSql.getcMemMemoDel();
			
//			this.sql = "UPDATE TF_MEMO_LIST "
//				+	"SET STATUS = STATUS + 1 "
//				+	"WHERE (STATUS = 0 OR STATUS = 2) "
//				+		"AND MEMOIDX = ?";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, memoIdx);
			row = pstmt.executeUpdate();
		
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}

	public ArrayList<BoardVo> cMemNewsList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try { 
			
			this.sql = cMemberSql.getcMemNewsList();
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

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
				vo.setObIdx(rs.getInt("obidx"));
				vo.setInsDate(rs.getString("insdate"));
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public int cMemNewsListTtCnt(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		int row = 0;
		ResultSet rs = null;
				
		try { 
			
			this.sql = cMemberSql.getcMemNewsList();
			
			this.sql = new PagingQ().pagingCnt(this.sql);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				row = rs.getInt(1);
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return row;
		
	}
	
	public Map<String, Object> cMemNewsCon(int bidx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		try { 
			
			this.sql = cMemberSql.getcMemNewsCon();
			
//			this.sql = "SELECT A.*, B.PIDX, B.PNAME, B.PNFUNDS, B.PGRADE, B.STATUS "
//				+	"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B "
//				+	"WHERE A.PIDX = B.PIDX "
//				+		"AND A.BIDX = ?";

//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bidx);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpIdx(rs.getInt("pidx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setObIdx(rs.getInt("obidx"));
				vo.setInsDate(rs.getString("insdate"));

				ProjectVo pvo = new ProjectVo();
				pvo.setpIdx(rs.getInt("pidx"));
				pvo.setpName(rs.getString("pname"));
				pvo.setPnFunds(rs.getInt("pnfunds"));
				pvo.setpGrade(rs.getInt("pgrade"));
				pvo.setStatus(rs.getInt("status"));

				data.put("vo", vo);
				data.put("pvo", pvo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return data;
		
	}
	
	public int cMemNewsMod(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0; 
		
		try { 
			
			this.sql = cMemberSql.getcMemNewsMod();
			
//			this.sql = "UPDATE TF_BOARD_NEWS "
//				+	"SET CATE = (SELECT PCATE FROM TF_PROJECT_LIST WHERE PIDX = ?), TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE, PIDX = ? "
//				+	"WHERE BIDX = ?";
								
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputBV.getpIdx());
			pstmt.setString(2, inputBV.getTitle());
			pstmt.setString(3, inputBV.getContents());
			pstmt.setInt(4, inputBV.getpIdx());
			pstmt.setInt(5, inputBV.getbIdx());
						
			row = pstmt.executeUpdate();
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public ProjectVo cMemNewsWriteProjNow(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		ProjectVo vo = new ProjectVo();
		
		try { 

			this.sql = cMemberSql.getcMemNewsWriteProjNow();
			
//			this.sql = "SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
//				+	"FROM TF_PROJECT_LIST "
//				+	"WHERE STATUS = 1 "
//				+		"AND IDX = ?";
								
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
					
			while(rs.next()) { 
				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
				vo.setStatus(rs.getInt("status"));
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public int cMemNewsWrite(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = cMemberSql.getcMemNewsWrite();
			
//			this.sql = "INSERT INTO TF_BOARD_NEWS (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, PIDX) "
//				+	"VALUES (SEQ_TF_BIDX_NEWS.NEXTVAL, ?, (SELECT PCATE FROM TF_PROJECT_LIST WHERE PIDX = ?), ?, ?, 0, 0, 0, SEQ_TF_BIDX_NEWS.CURRVAL, 1, 1, 0, 1, SYSDATE, SYSDATE, ?)";
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputBV.getIdx());
			pstmt.setInt(2, inputBV.getpIdx());
			pstmt.setString(3, inputBV.getTitle());
			pstmt.setString(4, inputBV.getContents());
			pstmt.setInt(5, inputBV.getpIdx());
			
			row = pstmt.executeUpdate();
						
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int cMemNewsDel(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = cMemberSql.getcMemNewsDel();
			
//			this.sql = "UPDATE TF_BOARD_NEWS "
//				+	"SET VIEWSTAT = 0, MODDATE = SYSDATE "
//				+ 	"WHERE BIDX = ?";
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bIdx);
						
			row = pstmt.executeUpdate();
						
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public ProjectVo cMemProjNowList(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProjectVo vo = new ProjectVo();
		
		try { 
			
			this.sql = cMemberSql.getcMemProjNowList();
			
//			this.sql = "SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
//				+	"FROM TF_PROJECT_LIST "
//				+	"WHERE STATUS = 1 "
//				+		"AND IDX = ?";
								
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
					
			while(rs.next()) { 
				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
				vo.setStatus(rs.getInt("status"));
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public ArrayList<ProjectVo> cMemProjHisList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
			
		try { 

			this.sql = cMemberSql.getcMemProjHisList();
			
//			this.sql = "SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
//				+	"FROM TF_PROJECT_LIST "
//				+	"WHERE STATUS > 3 "
//				+		"AND IDX = ?";
								
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
					
			while(rs.next()) { 
				
				ProjectVo vo = new ProjectVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
				vo.setStatus(rs.getInt("status"));
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public int cMemProjApplyWrite(ProjectVo inputPV, Map itData){

//	펑션을 먼저 SQL 내부에 등록해야함.
//	CREATE OR REPLACE FUNCTION GET_SEQ_TF_ITIDX RETURN NUMBER AS NUM NUMBER;
//	BEGIN
//	SELECT SEQ_TF_ITIDX.NEXTVAL
//	INTO NUM
//	FROM DUAL;
//	RETURN NUM;
//	END GET_SEQ_TF_ITIDX;

		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		int row = 0;
		String itListSeq = null;
		String itListMark = null;
		
		ItemVo[] itList = new ItemVo[5];
		for(int itCnt = 0; itCnt < inputPV.getItListCnt(); itCnt++){
			itList[itCnt] = (ItemVo) itData.get("itList"+itCnt);
		}
				
		try { 
			
			this.sql = "INSERT ALL "
				+	"INTO TF_PROJECT_LIST (PIDX, IDX, PNAME, PCATE, CONTENTS, ITLIST, ITLISTCNT, PTFUNDS, PNFUNDS, PGRADE, STATUS, INSDATE, PSDATE, PEDATE, PCDATE, CHKADMIN) "
				+		"VALUES ( "
				+			"SEQ_TF_PIDX.NEXTVAL, "
				+			"?, " //IDX
				+			"?, " //PNAME
				+			"?, " //PCATE
				+			"?, "; //CONTENTS

			for(int itCnt = 0; itCnt < inputPV.getItListCnt(); itCnt++){
				
				itListSeq = "(SELECT GET_SEQ_TF_ITIDX() FROM DUAL)";
								
				if(itCnt != inputPV.getItListCnt()-1){
					itListMark = "||'|'||";
				}else{
					itListMark = ", ";
				}

				this.sql += (itListSeq + itListMark);
				
			}
			
			this.sql +=			"?, " //ITLISTCNT
				+			"?, " //PTFUNDS
				+			"0, "
				+			"?, " //PGRADE
				+			"0, "
				+			"SYSDATE, "
				+			"SYSDATE, "
				+			"NULL, "
				+			"NULL, "
				+			"NULL "
				+		") ";
		
			for(int itCnt = 0; itCnt < inputPV.getItListCnt(); itCnt++){
				this.sql += "INTO TF_ITEM_LIST (ITIDX, PIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT, ITSCNT, STATUS)	"
						+	"VALUES (SEQ_TF_ITIDX.NEXTVAL+" + (itCnt + 1) + ", SEQ_TF_PIDX.CURRVAL, ?, ?, ?, ?, 0, 1) ";
			}
			
			this.sql += "SELECT * FROM DUAL";
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputPV.getIdx());
			pstmt.setString(2, inputPV.getpName());
			pstmt.setString(3, inputPV.getpCate());
			pstmt.setString(4, inputPV.getContents());
			pstmt.setInt(5, inputPV.getItListCnt());
			pstmt.setInt(6, inputPV.getPtFunds());
			pstmt.setInt(7, inputPV.getpGrade());
			
			for(int itCnt = 0; itCnt < inputPV.getItListCnt(); itCnt++){
				pstmt.setString((itCnt * 4) + 8, itList[itCnt].getItName());
				pstmt.setInt((itCnt * 4) + 9, itList[itCnt].getItPrice());
				pstmt.setString((itCnt * 4) + 10, itList[itCnt].getContents());
				pstmt.setInt((itCnt * 4) + 11, itList[itCnt].getItTCnt());
			}
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int cMemProjApplyWriteTransaction(ProjectVo inputPV, Map itData){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		int row = 0;
		String itListSeq = null;
		String itListMark = null;
		
		ItemVo[] itList = new ItemVo[inputPV.getItListCnt()];
		for(int itCnt = 0; itCnt < inputPV.getItListCnt(); itCnt++){
			itList[itCnt] = (ItemVo) itData.get("itList"+itCnt);
		}
				
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = "INSERT "
				+	"INTO TF_PROJECT_LIST (PIDX, IDX, PNAME, PCATE, CONTENTS, ITLIST, ITLISTCNT, PTFUNDS, PNFUNDS, PGRADE, STATUS, INSDATE, PSDATE, PEDATE, PCDATE, CHKADMIN) "
				+		"VALUES ( "
				+			"SEQ_TF_PIDX.NEXTVAL, "
				+			"?, " //IDX
				+			"?, " //PNAME
				+			"?, " //PCATE
				+			"?, "; //CONTENTS
		
			for(int itCnt = 0; itCnt < inputPV.getItListCnt(); itCnt++){
				
				if(itCnt == 0){
					itListSeq = "SEQ_TF_ITIDX.NEXTVAL";
				}else{
					itListSeq = "(SEQ_TF_ITIDX.CURRVAL+" + itCnt + ")";
				}
				
				if(itCnt != inputPV.getItListCnt()-1){
					itListMark = "||'|'||";
				}else{
					itListMark = ", ";
				}

				this.sql += (itListSeq + itListMark);
				
			}
			
			this.sql +=			"?, " //ITLISTCNT
				+			"?, " //PTFUNDS
				+			"0, "
				+			"?, " //PGRADE
				+			"0, "
				+			"SYSDATE, "
				+			"SYSDATE, "
				+			"NULL, "
				+			"NULL, "
				+			"NULL "
				+		") ";
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputPV.getIdx());
			pstmt.setString(2, inputPV.getpName());
			pstmt.setString(3, inputPV.getpCate());
			pstmt.setString(4, inputPV.getContents());
			pstmt.setInt(5, inputPV.getItListCnt());
			pstmt.setInt(6, inputPV.getPtFunds());
			pstmt.setInt(7, inputPV.getpGrade());
			row += pstmt.executeUpdate();
			
			for(int itCnt = 0; itCnt < inputPV.getItListCnt(); itCnt++){
				this.sql = "INSERT "
						+ 	"INTO TF_ITEM_LIST (ITIDX, PIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT, ITSCNT, STATUS)	"
						+		"VALUES ( ";
				if(itCnt == 0){
					this.sql +=		"SEQ_TF_ITIDX.CURRVAL, ";
				}else{
					this.sql +=		"SEQ_TF_ITIDX.NEXTVAL, ";
				}
				
				this.sql +=			"SEQ_TF_PIDX.CURRVAL, "
					+			"?, " //ITNAME
					+			"?, " //ITPRICE
					+			"?, " //CONTENTS
					+			"?, " //ITTCNT
					+			"0, "
					+			"1 "
					+ 		") ";
			
				pstmt = con.prepareStatement(this.sql);
				pstmt.setString(1, itList[itCnt].getItName());
				pstmt.setInt(2, itList[itCnt].getItPrice());
				pstmt.setString(3, itList[itCnt].getContents());
				pstmt.setInt(4, itList[itCnt].getItTCnt());
				row += pstmt.executeUpdate();
			}
			
			con.commit();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

	public ProjectVo cMemProjApplyConProj(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		ProjectVo vo = new ProjectVo();
		
		try { 

			this.sql = cMemberSql.getcMemProjApplyConProj();
			
//			this.sql = "SELECT PIDX, IDX, PNAME, PCATE, CONTENTS, ITLIST, ITLISTCNT, PTFUNDS, PEDATE, PCDATE "
//				+	"FROM TF_PROJECT_LIST "
//				+	"WHERE IDX = ? "
//				+		"AND STATUS = 0 ";
								
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
					
			while(rs.next()) { 
				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setContents(rs.getString("contents"));
				vo.setItList(rs.getString("itlist"));
				vo.setItListCnt(rs.getInt("itlistcnt"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPeDate(rs.getString("pedate"));
				vo.setPcDate(rs.getString("pcdate"));
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public ArrayList<ItemVo> cMemProjApplyConItem(int pIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		ArrayList<ItemVo> alist = new ArrayList<ItemVo>();
		
		try { 
			
			this.sql = cMemberSql.getcMemProjApplyConItem();
			
//			this.sql = "SELECT ITIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT "
//				+	"FROM TF_ITEM_LIST "
//				+	"WHERE PIDX = ?";
								
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();
					
			while(rs.next()) { 
				
				ItemVo vo = new ItemVo();
				vo.setItIdx(rs.getInt("itidx"));
				vo.setItName(rs.getString("itname"));
				vo.setItPrice(rs.getInt("itprice"));
				vo.setContents(rs.getString("contents"));
				vo.setItTCnt(rs.getInt("ittcnt"));
							
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public int cMemProjApplyModTransaction(Map<String, Object> mapData){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		ProjectVo inputPV = (ProjectVo) mapData.get("inputPV");
		Map<String, Object> itData = (Map<String, Object>) mapData.get("itData");
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = cMemberSql.getcMemProjApplyModTransaction_1();
			
//			this.sql = "UPDATE TF_PROJECT_LIST "
//				+	"SET PNAME = ?, CONTENTS = ?, ITLIST = ?, ITLISTCNT = ?, MODDATE = SYSDATE "
//				+	"WHERE PIDX = ?";
				
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, inputPV.getpName());
			pstmt.setString(2, inputPV.getContents());
			pstmt.setString(3, inputPV.getItList());
			pstmt.setInt(4, inputPV.getItListCnt());
			pstmt.setInt(5, inputPV.getpIdx());
			row += pstmt.executeUpdate();
			
			this.sql = cMemberSql.getcMemProjApplyModTransaction_2();
			
//			this.sql = "UPDATE TF_ITEM_LIST "
//				+	"SET ITNAME = ?, ITPRICE = ?, CONTENTS = ?, ITTCNT = ? "
//				+	"WHERE ITIDX = ?"
//				+ 		"AND PIDX = ?";
			
			for(int itCnt = 0; itCnt < itData.size(); itCnt++){
				pstmt = con.prepareStatement(this.sql);
				pstmt.setString(1, ((ItemVo) itData.get("itList"+itCnt)).getItName());
				pstmt.setInt(2, ((ItemVo) itData.get("itList"+itCnt)).getItPrice());
				pstmt.setString(3, ((ItemVo) itData.get("itList"+itCnt)).getContents());
				pstmt.setInt(4, ((ItemVo) itData.get("itList"+itCnt)).getItTCnt());
				pstmt.setInt(5, ((ItemVo) itData.get("itList"+itCnt)).getItIdx());
				pstmt.setInt(6, ((ItemVo) itData.get("itList"+itCnt)).getpIdx());
				row += pstmt.executeUpdate();
			}
			
			con.commit();
						
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	
	public int cMemProjApplyModProj(ProjectVo inputPV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = cMemberSql.getcMemProjApplyModProj();
			
//			this.sql = "UPDATE TF_PROJECT_LIST "
//				+	"SET PNAME = ?, CONTENTS = ?, ITLIST = ?, ITLISTCNT = ?, MODDATE = SYSDATE "
//				+	"WHERE PIDX = ?";
				
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, inputPV.getpName());
			pstmt.setString(2, inputPV.getContents());
			pstmt.setString(3, inputPV.getItList());
			pstmt.setInt(4, inputPV.getItListCnt());
			pstmt.setInt(5, inputPV.getpIdx());
			row = pstmt.executeUpdate();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int cMemProjApplyModItem(Map<String, Object> itData){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = cMemberSql.getcMemProjApplyModItem();
			
//			this.sql = "UPDATE TF_ITEM_LIST "
//				+	"SET ITNAME = ?, ITPRICE = ?, CONTENTS = ?, ITTCNT = ? "
//				+	"WHERE ITIDX = ? "
//				+		"AND PIDX = ?";
			
			for(int itCnt = 0; itCnt < itData.size(); itCnt++){
				pstmt = con.prepareStatement(this.sql);
				pstmt.setString(1, ((ItemVo) itData.get("itList"+itCnt)).getItName());
				pstmt.setInt(2, ((ItemVo) itData.get("itList"+itCnt)).getItPrice());
				pstmt.setString(3, ((ItemVo) itData.get("itList"+itCnt)).getContents());
				pstmt.setInt(4, ((ItemVo) itData.get("itList"+itCnt)).getItTCnt());
				pstmt.setInt(5, ((ItemVo) itData.get("itList"+itCnt)).getItIdx());
				pstmt.setInt(6, ((ItemVo) itData.get("itList"+itCnt)).getpIdx());
				row += pstmt.executeUpdate();
			}
			
			con.commit();
						
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	
	public ProjectVo cMemProjApplyItemPlusConProj(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		ProjectVo vo = new ProjectVo();
		
		try { 
			
			this.sql = cMemberSql.getcMemProjApplyItemPlusConProj();
			
//			this.sql = "SELECT PIDX, IDX, PNAME, PCATE, CONTENTS, ITLIST, ITLISTCNT, PTFUNDS, PEDATE, PCDATE "
//				+	"FROM TF_PROJECT_LIST "
//				+	"WHERE IDX = ? "
//				+		"AND STATUS = 0 ";
								
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
					
			while(rs.next()) { 
				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setContents(rs.getString("contents"));
				vo.setItList(rs.getString("itlist"));
				vo.setItListCnt(rs.getInt("itlistcnt"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPeDate(rs.getString("pedate"));
				vo.setPcDate(rs.getString("pcdate"));
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public ArrayList<ItemVo> cMemProjApplyItemPlusConItem(int pIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		ArrayList<ItemVo> alist = new ArrayList<ItemVo>();
		
		try { 
			
			this.sql = cMemberSql.getcMemProjApplyItemPlusConItem();
			
//			this.sql = "SELECT ITIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT "
//				+	"FROM TF_ITEM_LIST "
//				+	"WHERE PIDX = ?";
								
//			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();
					
			while(rs.next()) { 
				
				ItemVo vo = new ItemVo();
				vo.setItIdx(rs.getInt("itidx"));
				vo.setItName(rs.getString("itname"));
				vo.setItPrice(rs.getInt("itprice"));
				vo.setContents(rs.getString("contents"));
				vo.setItTCnt(rs.getInt("ittcnt"));
							
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public int cMemProjApplyItemPlus(int pIdx, ArrayList<ItemVo> alist){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		
		String tmpItList = "";
		int tmpItIdxSeq = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			for(int itCnt = 0; itCnt < alist.size(); itCnt++){
				
				ItemVo vo = alist.get(itCnt);
								
				this.sql = cMemberSql.getcMemProjApplyItemPlus_1();
				
//				this.sql = "SELECT SEQ_TF_ITIDX.NEXTVAL FROM DUAL";
				
				pstmt = con.prepareStatement(this.sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					tmpItIdxSeq = rs.getInt(1);
				}
				
				tmpItList += tmpItIdxSeq;
				if(itCnt != (alist.size() - 1)) tmpItList += "|";
				
				this.sql = cMemberSql.getcMemProjApplyItemPlus_2();
				
//				this.sql = "INSERT INTO TF_ITEM_LIST (ITIDX, PIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT, ITSCNT, STATUS) "
//					+	"VALUES (?, ?, ?, ?, ?, ?, 0, 0)";
				
				pstmt = con.prepareStatement(this.sql);
				pstmt.setInt(1, tmpItIdxSeq);
				pstmt.setInt(2, pIdx);
				pstmt.setString(3, vo.getItName());
				pstmt.setInt(4, vo.getItPrice());
				pstmt.setString(5, vo.getContents());
				pstmt.setInt(6, vo.getItTCnt());
				row += pstmt.executeUpdate();

			}
		
			this.sql = cMemberSql.getcMemProjApplyItemPlus_3();
			
//			this.sql = "UPDATE TF_PROJECT_LIST "
//				+	"SET "
//				+		"ITLIST = ITLIST || ?, "
//				+		"ITLISTCNT = ITLISTCNT + ? "
//				+	"WHERE PIDX = ?";
				
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, tmpItList);
			pstmt.setInt(2, alist.size());
			pstmt.setInt(3, pIdx);
			row += pstmt.executeUpdate();		

			con.commit();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try{
				con.setAutoCommit(true);
			}catch(Exception e){
				e.getMessage();
			}
			DBClose.close(con,pstmt,rs); 
		}
	
		return row;
		
	}
	
	public ArrayList<Map<String, Object>> cMemQnaList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
		
		try { 
			
			this.sql = cMemberSql.getcMemQnaList();
			
//			this.sql = "SELECT A.PIDX, A.PNAME, B.BIDX, B.IDX, B.CATE, B.TITLE, B.HIT, B.GOOD, B.BAD, B.COMMCNT, B.OBIDX, B.INSDATE, B.PIDX, (SELECT MAX(BDEPTH) FROM TF_BOARD_QNA WHERE BIDX = B.BIDX) STATUS "
//				+	"FROM TF_PROJECT_LIST A, TF_BOARD_QNA B "
//				+	"WHERE A.PIDX = B.PIDX "
//				+		"AND A.IDX = ? "
//				+	"ORDER BY B.OBIDX DESC, B.RBIDX ASC";

			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				Map<String, Object> data = new HashMap<String,Object>();
				
				BoardVo bvo = new BoardVo();
				bvo.setbIdx(rs.getInt("bidx"));
				bvo.setIdx(rs.getInt("idx"));
				bvo.setCate(rs.getString("cate"));
				bvo.setTitle(rs.getString("title"));
				bvo.setHit(rs.getInt("hit"));
				bvo.setGood(rs.getInt("good"));
				bvo.setBad(rs.getInt("bad"));
				bvo.setCommCnt(rs.getInt("commcnt"));
				bvo.setObIdx(rs.getInt("obidx"));
				bvo.setInsDate(rs.getString("insdate"));
				
				ProjectVo pvo = new ProjectVo();
				pvo.setpIdx(rs.getInt("pidx"));
				pvo.setpName(rs.getString("pname"));
				
				String status = rs.getString("status");
				
				data.put("bvo", bvo);
				data.put("pvo", pvo);
				data.put("status", status);
								
				alist.add(data);
				
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public Map<String, Object> cMemQnaCon(int bidx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		try { 
			
			this.sql = cMemberSql.getcMemQnaCon();
			
//			this.sql = "SELECT A.*, B.PIDX, B.PNAME, B.PNFUNDS, B.PGRADE, B.STATUS "
//				+	"FROM TF_BOARD_QNA A, TF_PROJECT_LIST B "
//				+	"WHERE A.PIDX = B.PIDX "
//				+		"AND A.BIDX = ?";

			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bidx);
			rs = pstmt.executeQuery();

			while(rs.next()){
			
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpIdx(rs.getInt("pidx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setObIdx(rs.getInt("obidx"));
				vo.setInsDate(rs.getString("insdate"));
				
				ProjectVo pvo = new ProjectVo();
				pvo.setpIdx(rs.getInt("pidx"));
				pvo.setpName(rs.getString("pname"));
				pvo.setPnFunds(rs.getInt("pnfunds"));
				pvo.setpGrade(rs.getInt("pgrade"));
				pvo.setStatus(rs.getInt("status"));

				data.put("vo", vo);
				data.put("pvo", pvo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return data;
		
	}
	
	public int cMemQnaWrite(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		int row = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = cMemberSql.getcMemQnaWrite_1();
			
//			this.sql = "UPDATE TF_BOARD_QNA "
//				+	"SET RBIDX = RBIDX + 1 "
//				+	"WHERE OBIDX = (SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) "
//				+		"AND RBIDX > (SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?)";

			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputBV.getObIdx());
			pstmt.setInt(2, inputBV.getObIdx());
			row += pstmt.executeUpdate();
			
			this.sql = cMemberSql.getcMemQnaWrite_2();
			
//			this.sql = "INSERT INTO TF_BOARD_QNA (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, PIDX) "
//				+	"VALUES ("
//				+		"SEQ_TF_BIDX_QNA.NEXTVAL, "
//				+		"?, " //IDX
//				+		"(SELECT CATE FROM TF_BOARD_QNA WHERE BIDX = ?), " //CATE
//				+		"?, " //TITLE
//				+		"?, " //CONTENTS
//				+		"0, "
//				+		"0, "
//				+		"0, "
//				+		"(SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?), " //OBIDX
//				+		"(SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //RBIDX
//				+		"(SELECT BDEPTH FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //BDEPTH
//				+		"0, "
//				+		"1, "
//				+		"SYSDATE, "
//				+		"SYSDATE, "
//				+		"(SELECT PIDX FROM TF_BOARD_QNA WHERE BIDX = ?)" //PIDX
//				+	")";

			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, inputBV.getIdx());
			pstmt.setInt(2, inputBV.getObIdx());
			pstmt.setString(3, inputBV.getTitle());
			pstmt.setString(4, inputBV.getContents());
			pstmt.setInt(5, inputBV.getObIdx());
			pstmt.setInt(6, inputBV.getObIdx());
			pstmt.setInt(7, inputBV.getObIdx());
			pstmt.setInt(8, inputBV.getObIdx());
			row += pstmt.executeUpdate();
			
			con.commit();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	
	public int cMemQnaMod(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		int row = 0;
		
		try { 
			
			this.sql = cMemberSql.getcMemQnaMod();
			
//			this.sql = "UPDATE TF_BOARD_QNA "
//				+	"SET TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "
//				+	"WHERE BIDX = ?";

			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, inputBV.getTitle());
			pstmt.setString(2, inputBV.getContents());
			pstmt.setInt(3, inputBV.getbIdx());
			row = pstmt.executeUpdate();
						
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	
}
