package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.*;

public class ProjectServiceImpl {

	DBConnect dbconnect = new DBConnect();
	String sql = null;
	
	public ArrayList<ProjectVo> projListByCate(String pCate, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 

		try { 
			
			this.sql = "SELECT * "
					+	"FROM TF_PROJECT_LIST " 
					+	"WHERE STATUS = 1 AND PCATE = ? ORDER BY PIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setString(1, pCate);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				ProjectVo vo = new ProjectVo(); 
				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
				
				alist.add(vo); 
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public ArrayList<ProjectVo> projListByPower(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 

		try { 
			
			this.sql = "SELECT * "
					+	"FROM TF_PROJECT_LIST " 
					+	"WHERE STATUS = 1 ORDER BY PNFUNDS DESC";
		
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				ProjectVo vo = new ProjectVo(); 
				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
				
				alist.add(vo); 
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}

	public ArrayList<ProjectVo> projListByTech(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 

		try { 
			
			this.sql = "SELECT * "
					+	"FROM TF_PROJECT_LIST " 
					+	"WHERE STATUS = 1 ORDER BY PGRADE DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				ProjectVo vo = new ProjectVo(); 
				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pname"));
				vo.setpCate(rs.getString("pcate"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
				
				alist.add(vo); 
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}

	public ProjectVo projCon(int pIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ProjectVo vo = new ProjectVo(); 
		
		try { 
			
			this.sql = "SELECT * "
					+	"FROM TF_PROJECT_LIST " 
					+	"WHERE PIDX = ?";
		
			//this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, pIdx);
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
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setpGrade(rs.getInt("pgrade"));
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public MemberVo projPayMyMoney(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		MemberVo vo = new MemberVo(); 
		
		try { 
			
			this.sql = "SELECT MONEY "
					+	"FROM TF_MEMBER A, TF_IMEMBER_EXT B " 
					+	"WHERE A.IDX = B.IDX "
					+	"AND A.IDX = ?";
		
			//this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			while(rs.next()) { 
				vo.setMoney(rs.getInt("money"));
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return vo;
		
	}
	
	public ArrayList<ProjectCommVo> projConCommList(int pIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectCommVo> alist = new ArrayList<ProjectCommVo>(); 
		
		try { 
			
			this.sql = "SELECT * "
					+	"FROM TF_PROJECT_COMM "
					+	"WHERE VIEWSTAT = 1 "
					+	"AND PIDX = ? "
					+	"ORDER BY OPCOMMIDX DESC, RPCOMMIDX ASC";
					
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, pIdx);
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
	
	public ArrayList<BoardVo> projConNewsList(int pIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		
		try { 
						
			this.sql = "SELECT A.* " 
					+	"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B " 
					+	"WHERE A.PIDX = B.PIDX AND VIEWSTAT = 1 " 
					+	"AND B.PIDX = ? " 
					+	"ORDER BY OBIDX DESC, RBIDX ASC";	
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();

			while(rs.next()) { 
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
	
	public MemberVo projConCmem(int pIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		MemberVo vo = new MemberVo(); 
		
		try { 
			
			this.sql = "SELECT * "
					+	"FROM TF_CMEMBER_EXT " 
					+	"WHERE IDX = (SELECT IDX FROM TF_PROJECT_LIST WHERE PIDX = ?)";
		
			//this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();

			while(rs.next()) { 
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
	
	public int projConCommWrite(ProjectCommVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "INSERT INTO TF_PROJECT_COMM (PCOMMIDX, PIDX, IDX, COMMENTS, GOOD, BAD, OPCOMMIDX, RPCOMMIDX, PCOMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
					+	"VALUES (SEQ_TF_PCOMMIDX.NEXTVAL, ?, ?, ?, 0, 0, SEQ_TF_PCOMMIDX.CURRVAL, 1, 1, 1, SYSDATE, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getIdx());
			pstmt.setString(3, vo.getComments());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}

	public int projConSubCommWriteTransaction(ProjectCommVo vo) {
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_PROJECT_COMM "
					+	"SET RPCOMMIDX = RPCOMMIDX + 1 "
					+	"WHERE OPCOMMIDX = (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) "
					+	"AND RPCOMMIDX > (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getOpCommIdx());
			pstmt.setInt(2, vo.getOpCommIdx());
						
			row = pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_PROJECT_COMM (PCOMMIDX, PIDX, IDX, COMMENTS, GOOD, BAD, OPCOMMIDX, RPCOMMIDX, PCOMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
					+	"VALUES (SEQ_TF_PCOMMIDX.NEXTVAL, ?, ?, ?, 0, 0, (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?), (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, (SELECT PCOMMDEPTH FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, 1, SYSDATE, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getIdx());
			pstmt.setString(3, vo.getComments());
			pstmt.setInt(4, vo.getOpCommIdx());
			pstmt.setInt(5, vo.getOpCommIdx());
			pstmt.setInt(6, vo.getOpCommIdx());
			
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
	
	public int projConSubCommWriteUpdate(ProjectCommVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_PROJECT_COMM "
					+	"SET RPCOMMIDX = RPCOMMIDX + 1 "
					+	"WHERE OPCOMMIDX = (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) "
					+	"AND RPCOMMIDX > (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getOpCommIdx());
			pstmt.setInt(2, vo.getOpCommIdx());
						
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projConSubCommWriteInsert(ProjectCommVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "INSERT INTO TF_PROJECT_COMM (PCOMMIDX, PIDX, IDX, COMMENTS, GOOD, BAD, OPCOMMIDX, RPCOMMIDX, PCOMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
					+	"VALUES (SEQ_TF_PCOMMIDX.NEXTVAL, ?, ?, ?, 0, 0, (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?), (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, (SELECT PCOMMDEPTH FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, 1, SYSDATE, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getIdx());
			pstmt.setString(3, vo.getComments());
			pstmt.setInt(4, vo.getOpCommIdx());
			pstmt.setInt(5, vo.getOpCommIdx());
			pstmt.setInt(6, vo.getOpCommIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayTransaction(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = "INSERT INTO TF_FUND_HIS (FIDX, PIDX, ITIDX, IDX, INFUNDS, BFUNDS, AFUNDS, STATUS, INSDATE) "
					+	"VALUES (SEQ_TF_FIDX.NEXTVAL, ?, ?, ?, ?, (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1), (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1) + ?, 1, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getItIdx());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setInt(4, vo.getInFunds());
			pstmt.setInt(5, vo.getpIdx());
			pstmt.setInt(6, vo.getpIdx());
			pstmt.setInt(7, vo.getInFunds());
			
			row = pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_WISH_LIST "
					+	"SET VIEWSTAT = 0 "
					+	"WHERE VIEWSTAT = 1 "
					+	"AND IDX = ? "
					+	"AND PIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getIdx());
			pstmt.setInt(2, vo.getpIdx());
			
			row += pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_IMEMBER_EXT "
					+	"SET MONEY = MONEY - ? "
					+	"WHERE IDX = ? ";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getIdx());
			
			row += pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_PROJECT_LIST "
					+	"SET PNFUNDS = PNFUNDS + ? "
					+	"WHERE PIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getpIdx());
						
			row += pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_ITEM_LIST "
					+	"SET ITSCNT = ITSCNT + 1 "
					+	"WHERE ITIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getItIdx());
						
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
	
	public int projPay(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "INSERT INTO TF_FUND_HIS (FIDX, PIDX, ITIDX, IDX, INFUNDS, BFUNDS, AFUNDS, STATUS, INSDATE) "
					+	"VALUES (SEQ_TF_FIDX.NEXTVAL, ?, ?, ?, ?, (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1), (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1) + ?, 1, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getItIdx());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setInt(4, vo.getInFunds());
			pstmt.setInt(5, vo.getpIdx());
			pstmt.setInt(6, vo.getpIdx());
			pstmt.setInt(7, vo.getInFunds());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally {
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayWishListDel(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_WISH_LIST "
					+	"SET VIEWSTAT = 0 "
					+	"WHERE VIEWSTAT = 1 "
					+	"AND IDX = ? "
					+	"AND PIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getIdx());
			pstmt.setInt(2, vo.getpIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayMyMoneyChg(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_IMEMBER_EXT "
					+	"SET MONEY = MONEY - ? "
					+	"WHERE IDX = ? ";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayPnFundsMod(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_PROJECT_LIST "
					+	"SET PNFUNDS = PNFUNDS + ? "
					+	"WHERE PIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getpIdx());
						
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayItemSellCntMod(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_ITEM_LIST "
					+	"SET ITSCNT = ITSCNT + 1 "
					+	"WHERE ITIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getItIdx());
						
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
}
