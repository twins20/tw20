package service;

import common.DBClose;
import common.DBConnect;
import common.PagingQ;
import java.sql.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IMemberServiceImpl {
	
	DBConnect dbconnect = new DBConnect(); 
	String sql=""; 
	
	public ArrayList<Map<String,Object>> IMemberIndexPProjectList(int idx, int listCnt, int nowPage){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null;
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String,Object>>(); 
		
		try { 
			
			this.sql = "SELECT A.PIDX, A.IDX, A.PNAME, A.PCATE, A.PGRADE, A.PNFUNDS, A.PTFUNDS, B.INFUNDS, B.INSDATE "
				+		"FROM TF_PROJECT_LIST A, TF_FUND_HIS B "
				+		"WHERE A.PIDX = B.PIDX "
				+			"AND B.STATUS = 1 "
				+			"AND B.IDX = ?";	
		
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, nowPage);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();  
			
			while(rs.next()) {  
				
				Map<String,Object> data = new HashMap<String,Object>();
			
				ProjectVo pvo = new ProjectVo();
				pvo.setrNum(rs.getInt("rnum"));
				pvo.setpIdx(rs.getInt("pidx"));
				pvo.setIdx(rs.getInt("idx"));
				pvo.setpName(rs.getString("pname"));
				pvo.setpCate(rs.getString("pcate"));
				pvo.setpGrade(rs.getInt("pgrade"));
				pvo.setPnFunds(rs.getInt("pnfunds"));
				pvo.setPtFunds(rs.getInt("ptfunds"));
			
				FundVo fvo = new FundVo();
				fvo.setInFunds(rs.getInt("infunds"));
				fvo.setInsDate(rs.getString("insdate"));
				
				data.put("vo", pvo);
				data.put("vo2", fvo);
				
				alist.add(data);	
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
		
		return alist;
		
	}
	
	public ArrayList<BoardVo> IMemberIndexPQnaList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null; 
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try {
		
			this.sql = "SELECT A.*, (SELECT MAX(BDEPTH) FROM TF_BOARD_QNA WHERE BIDX = BIDX) "
				+ 		"FROM TF_BOARD_QNA A "
				+ 		"WHERE VIEWSTAT = 1 "
				+ 			"AND IDX = ? "
				+ 		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);	
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1,idx);
			rs = pstmt.executeQuery();  
			
			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setbDepth(rs.getInt("bdepth"));
				vo.setViewStat(rs.getInt("viewstat"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
				
				alist.add(vo);		
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
		
		return alist;
		
	}
			
	public MemberVo IMemberInfoCon(int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null;  
		MemberVo vo = new MemberVo();
		
		try { 
			
			this.sql = "SELECT * "
				+ 		"FROM TF_MEMBER "
				+ 		"WHERE IDX = ?";
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1,idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {  
				
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setNick(rs.getString("nick"));
				vo.setPhone(rs.getInt("phone"));
				vo.setAddr(rs.getString("addr"));
				vo.setStatus(rs.getInt("status"));
				vo.setType(rs.getString("type"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
				
			}
		
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs);
		}
		
		return vo;
		
	}
	
	public int IMemberInfoModChk(MemberVo InputMV){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null;  
		
		int row = 0;
		
		try { 
			
			this.sql = "SELECT COUNT(*) "
				+ 		"FROM TF_MEMBER "
				+ 		"WHERE IDX = ? "
				+ 			"AND PW = ?";
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1,InputMV.getIdx());
			pstmt.setString(2,InputMV.getPw());
			rs = pstmt.executeQuery();  
			
			if(rs.next()) {  
				
				row = rs.getInt(1);  
				
			}
		
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs);
		}
		
		return row;
		
	}
	
	public int IMemInfoModAction(MemberVo InputMV, int idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		
		int row = 0;
		
		try {
			
			this.sql = "UPDATE TF_MEMBER "
				+ 		"SET PW = ?, NICK = ?, PHONE = ?, ADDR = ?, MODDATE = SYSDATE "
				+ 		"WHERE IDX = ?";
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1,InputMV.getPw());
			pstmt.setString(2, InputMV.getNick());
			pstmt.setInt(3, InputMV.getPhone());
			pstmt.setString(4, InputMV.getAddr());
			pstmt.setInt(5, idx);
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) { 
			
		}finally { 
			DBClose.close(con,pstmt); 
		} 
		
		return row; 
		
	}
	
	public ArrayList<MoneyVo> IMemberMoneyHisList(int idx, int listCnt, int pageCnt){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null; 
		ArrayList<MoneyVo> alist = new ArrayList<MoneyVo>(); 
			
		try { 
			
			this.sql = "SELECT * "
				+ 		"FROM TF_MONEY_HIS "
				+ 		"WHERE IDX = ?";	
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();  
			
			while(rs.next()) {  
				
				MoneyVo vo = new MoneyVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setmIdx(rs.getInt("midx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setContents(rs.getString("contents"));
				vo.setChgMoney(rs.getInt("chgmoney"));
				vo.setbMoney(rs.getInt("bmoney"));
				vo.setaMoney(rs.getInt("amoney"));
				vo.setStatus(rs.getInt("status"));
				vo.setType(rs.getInt("type"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
				vo.setChkAdmin(rs.getString("chkadmin"));
				
				alist.add(vo);
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
		
		return alist;
		
	}
	
	public int IMemberMoneyCharge(MoneyVo InputMV){

		Connection con = dbconnect.getConnection();  
		PreparedStatement pstmt = null; 
		int row = 0; 
		
		try 
			{ 
			
			this.sql = "INSERT INTO TF_MONEY_HIS (MIDX, IDX, CONTENTS, CHGMONEY, BMONEY, AMONEY, STATUS, TYPE, INSDATE, MODDATE) "
				+ 		"VALUES (SEQ_TF_MIDX.NEXTVAL, ?, ?, ?, (SELECT * FROM (SELECT AMONEY FROM TF_MONEY_HIS WHERE IDX = ? ORDER BY MIDX DESC) WHERE ROWNUM = 1), (SELECT * FROM (SELECT AMONEY FROM TF_MONEY_HIS WHERE IDX = ? ORDER BY MIDX DESC) WHERE ROWNUM = 1), 0, 0, SYSDATE, SYSDATE)";
			
			pstmt = con.prepareStatement(this.sql); 
			
			pstmt.setInt(1, InputMV.getIdx()); 
			pstmt.setString(2, InputMV.getContents());
			pstmt.setInt(3, InputMV.getChgMoney());
			pstmt.setInt(4, InputMV.getIdx());
			pstmt.setInt(5, InputMV.getIdx());
	
			row = pstmt.executeUpdate(); 
									
		}catch(Exception e) { 
			System.out.println(e.getMessage());		
		}finally { 
			DBClose.close(con,pstmt); 
		} 
		
		return row; 
		
	} 
	
	public ArrayList<ProjectVo> IMemberFundList(int idx){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
			
		try { 
			
			this.sql = "SELECT B.PIDX PIDX, B.PNAME PNAME, B.PTFUNDS PTFUNDS, B.PNFUNDS PNFUNDS "
				+ 		"FROM TF_FUND_HIS A, TF_PROJECT_LIST B "
				+ 		"WHERE A.PIDX = B.PIDX "
				+ 			"AND A.ROWID IN "
				+ 				"(SELECT MAX(ROWID) FROM TF_FUND_HIS WHERE IDX = ? GROUP BY PIDX) "
				+ 			"AND B.STATUS < 4 "
				+ 		"ORDER BY FIDX DESC ";
				
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1,idx);
			rs = pstmt.executeQuery();  
			
			while(rs.next()) {  
				
				ProjectVo vo = new ProjectVo();
				vo.setpIdx(rs.getInt("pidx"));
				vo.setpName(rs.getString("pname"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				
				alist.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
		
		return alist;
		
	}
	
	public ArrayList<FundVo> IMemberFundStatus(int pidx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null; 
		ArrayList<FundVo> flist = new ArrayList<FundVo>(); 
			
		try { 
			
			this.sql = "SELECT * "
				+ 		"FROM TF_FUND_HIS "
				+ 		"WHERE STATUS = 1 "
				+ 			"AND PIDX = ?";		
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1,pidx);
			rs = pstmt.executeQuery();  
			
			while(rs.next()) {  
				
				FundVo vo = new FundVo();
				vo.setfIdx(rs.getInt("fidx"));
				vo.setInFunds(rs.getInt("infunds"));
				vo.setbFunds(rs.getInt("bfunds"));
				vo.setaFunds(rs.getInt("afunds"));
				vo.setInsDate(rs.getString("insdate"));
			
				flist.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
		
		return flist;
		
	}
	
	public ArrayList<ProjectVo> IMemberWishList(int idx, int listCnt, int nowPage){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;  
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();  
			
		try { 
			
			this.sql = "SELECT A.* "
				+		"FROM TF_PROJECT_LIST A,TF_WISH_LIST B "
				+ 		"WHERE A.PIDX = B.PIDX "
				+ 			"AND B.VIEWSTAT = 1 "
				+ 			"AND A.STATUS = 1 "
				+ 			"AND B.IDX = ? "
				+ 		"ORDER BY WIDX";		
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, nowPage);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1,idx);
			rs = pstmt.executeQuery();  
			
			while(rs.next()) {  
				
				ProjectVo vo = new ProjectVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setpIdx(rs.getInt("pidx"));
				vo.setpName(rs.getString("pname"));		
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				
				alist.add(vo);
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
		
		return alist;
		
	}
	
	public int IMemberWishListDel(int pidx){

		Connection con = dbconnect.getConnection();  
		PreparedStatement pstmt = null; 
		
		int row = 0; 
		
		try { 
			
			this.sql = "UPDATE TF_WISH_LIST "
				+ 		"SET VIEWSTAT = 0 "
				+ 		"WHERE PIDX = ?";
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, pidx); 
	
			row = pstmt.executeUpdate(); 
									
		}catch(Exception e) { 
			System.out.println(e.getMessage());		
		}finally { 
			DBClose.close(con,pstmt); 
		} 
		
		return row; 
		
	} 

}
