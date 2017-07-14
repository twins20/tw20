package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import common.*;


public class AdminServiceImpl {
	
	DBConnect dbconnect = new DBConnect();
	AdminServiceSql adminSql = new AdminServiceSql();
	String sql = null;
	
	
	//관리자 인덱스 페이지 충전 대기 리스트
	public ArrayList<Map<String, Object>> adminIndexPMoneyChkList(int listCnt, int pageCnt){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try {	
			
			this.sql = adminSql.getAdminIndexPMoneyChkList();
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				MemberVo mbv = new MemberVo();				
				mbv.setIdx(rs.getInt("idx"));
				mbv.setName(rs.getString("name"));
				
				MoneyVo mnv = new MoneyVo();
				mnv.setmIdx(rs.getInt("midx"));
				mnv.setChgMoney(rs.getInt("chgmoney"));
				mnv.setInsDate(rs.getString("insdate"));
				mnv.setStatus(rs.getInt("status"));
				
				data.put("mbv",mbv);
				data.put("mnv",mnv);
				data.put("rNum", rs.getInt("rnum"));
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}
	
	//관리자 인덱스 페이지 충전 대기 리스트 TtCnt
	public int adminIndexPMoneyChkListTtCnt(){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
		
		try {	
			
			this.sql = adminSql.getAdminIndexPMoneyChkList();
		
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 인덱스 페이지 프로젝트 승인 대기 리스트
	public ArrayList<ProjectVo> adminIndexPProjectChkList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
					
		try {	
			
			this.sql = adminSql.getAdminIndexPProjectChkList();
					
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				ProjectVo vo = new ProjectVo();	
				vo.setrNum(rs.getInt("rnum"));
				vo.setpIdx(rs.getInt("pIdx"));
				vo.setpName(rs.getString("pName"));
				vo.setInsDate(rs.getString("insDate"));				
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
	
	//관리자 인덱스 페이지 프로젝트 승인 대기 리스트 TtCnt
		public int adminIndexPProjectChkListTtCnt(){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try {	
				
				this.sql = adminSql.getAdminIndexPProjectChkList();
						
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 인덱스 페이지 사업자 승인 대기 리스트
	public ArrayList<MemberVo> adminIndexPCmemChkList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
					
		try {	
			
			this.sql = adminSql.getAdminIndexPCmemChkList();
					
//			this.sql = "SELECT A.IDX, A.NAME, B.COMPANY, A.MODDATE "
//				+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
//				+		"WHERE A.IDX = B.IDX "
//				+			"AND A.STATUS = 0 "
//				+			"AND A.TYPE = 'C' "
//				+		"ORDER BY B.CIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				MemberVo vo = new MemberVo();
				vo.setrNum(rs.getInt("rnum"));
				vo.setIdx(rs.getInt("Idx"));
				vo.setName(rs.getString("Name"));
				vo.setCompany(rs.getString("Company"));				
				vo.setModDate(rs.getString("ModDate"));				
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;
	}
	
	//관리자 인덱스 페이지 사업자 승인 대기 리스트 TtCnt
		public int adminIndexPCmemChkListTtCnt(){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try {	
				
				this.sql = adminSql.getAdminIndexPCmemChkList();
						
//				this.sql = "SELECT A.IDX, A.NAME, B.COMPANY, A.MODDATE "
//					+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
//					+		"WHERE A.IDX = B.IDX "
//					+			"AND A.STATUS = 0 "
//					+			"AND A.TYPE = 'C' "
//					+		"ORDER BY B.CIDX DESC";
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 투자자 회원정보 페이지 회원리스트
	public ArrayList<MemberVo> adminImemInfoList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
					
		try {	
			
			this.sql = adminSql.getAdminlmemInfoList();
					
//			this.sql = "SELECT A.IDX, A.ID, A.NAME, A.STATUS, B.MONEY "
//				+		"FROM TF_MEMBER A, TF_IMEMBER_EXT B "
//				+		"WHERE A.IDX = B.IDX "
//				+			"AND A.TYPE = 'I' "
//				+		"ORDER BY IIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);						
			rs = pstmt.executeQuery();			
			
			while(rs.next()) { 
				
				MemberVo vo = new MemberVo();	
				vo.setrNum(rs.getInt("rnum"));
				vo.setIdx(rs.getInt("Idx"));
				vo.setId(rs.getString("Id"));
				vo.setName(rs.getString("Name"));
				vo.setStatus(rs.getInt("Status"));				
				vo.setMoney(rs.getInt("Money"));
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;
	}
	
	//관리자 투자자 회원정보 페이지 회원리스트 TtCnt
	public int adminImemInfoListTtCnt(){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
					
		try {	
			
			this.sql = adminSql.getAdminlmemInfoList();
					
//			this.sql = "SELECT A.IDX, A.ID, A.NAME, A.STATUS, B.MONEY "
//				+		"FROM TF_MEMBER A, TF_IMEMBER_EXT B "
//				+		"WHERE A.IDX = B.IDX "
//				+			"AND A.TYPE = 'I' "
//				+		"ORDER BY IIDX DESC";
		
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql);						
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
	
	//관리자 투자자 회원 정보 페이지 회원별 상세 정보
	public ArrayList<MemberVo> adminImemInfoCon(int param_idx){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
					
		try { 	
			
			this.sql = adminSql.getAdminlmemInfoCon();
			
//			this.sql = "SELECT IDX, ID, NAME, PHONE, ADDR "
//				+		"FROM TF_MEMBER "
//				+		"WHERE IDX = ?";			
			
			pstmt = con.prepareStatement(this.sql);			
			pstmt.setInt(1, param_idx);			
			rs = pstmt.executeQuery();			
			
			if(rs.next()) { 
				
				MemberVo vo = new MemberVo();				
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setNick(rs.getString("nick"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getInt("phone"));				
				vo.setAddr(rs.getString("addr"));			
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;	
	}	
	
	//관리자 투자자 회원정보 페이지 회원별 충전 기록 리스트
	public ArrayList<MoneyVo> adminImemInfoMoneyHis(int param_idx, int listCnt, int pageCnt){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<MoneyVo> alist = new ArrayList<MoneyVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminImemInfoMoneyHis();
			
//			this.sql = "SELECT MIDX, CHGMONEY, INSDATE, STATUS "
//				+		"FROM TF_MONEY_HIS " 
//				+		"WHERE IDX = ? " 	
//				+		"ORDER BY MIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, param_idx);				
			rs = pstmt.executeQuery();			
			
			while(rs.next()) { 
				
				MoneyVo vo = new MoneyVo();	
				vo.setrNum(rs.getInt("rNum"));
				vo.setmIdx(rs.getInt("mIdx"));
				vo.setChgMoney(rs.getInt("ChgMoney"));
				vo.setInsDate(rs.getString("InsDate"));
				vo.setStatus(rs.getInt("Status"));
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;
	}
	
	//관리자 투자자 회원정보 페이지 회원별 충전 기록 리스트 TtCnt
		public int adminImemInfoMoneyHisTtCnt(int param_idx){
				
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 		
				
				this.sql = adminSql.getAdminImemInfoMoneyHis();
				
//				this.sql = "SELECT MIDX, CHGMONEY, INSDATE, STATUS "
//					+		"FROM TF_MONEY_HIS " 
//					+		"WHERE IDX = ? " 	
//					+		"ORDER BY MIDX DESC";
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql);							
				pstmt.setInt(1, param_idx);				
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
		
	//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
	public ArrayList<Map<String, Object>> adminImemInfoProjHis(int param_idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try { 	
			
			this.sql = adminSql.getAdminImemInfoProjHis();					
					
//			this.sql = "SELECT A.PIDX, A.PNAME, B.INFUNDS, B.INSDATE, A.PNFUNDS, A.PTFUNDS "
//				+		"FROM TF_PROJECT_LIST A, TF_FUND_HIS B "
//				+		"WHERE A.PIDX = B.PIDX " 
//				+			"AND B.IDX = ? "
//				+		"ORDER BY B.FIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				ProjectVo pvo = new ProjectVo();				
				pvo.setpIdx(rs.getInt("pidx"));
				pvo.setpName(rs.getString("pname"));				
				pvo.setPnFunds(rs.getInt("pnfunds"));
				pvo.setPtFunds(rs.getInt("ptfunds"));	
				
				FundVo fvo = new FundVo();
				fvo.setInFunds(rs.getInt("infunds"));
				fvo.setInsDate(rs.getString("insdate"));
				
				data.put("pvo",pvo);
				data.put("fvo",fvo);
				data.put("rNum", rs.getInt("rnum"));
			
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}
	
	//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트 TtCnt
		public int adminImemInfoProjHisTtCnt(int param_idx){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 	
				
				this.sql = adminSql.getAdminImemInfoProjHis();					
						
//				this.sql = "SELECT A.PIDX, A.PNAME, B.INFUNDS, B.INSDATE, A.PNFUNDS, A.PTFUNDS "
//					+		"FROM TF_PROJECT_LIST A, TF_FUND_HIS B "
//					+		"WHERE A.PIDX = B.PIDX " 
//					+			"AND B.IDX = ? "
//					+		"ORDER BY B.FIDX DESC";
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, param_idx);
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
		
	//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트	
	public ArrayList<Map<String, Object>> adminImemInfoQnaHis(int param_idx, int listCnt, int pageCnt){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try { 			
			
			this.sql = adminSql.getAdminImemInfoQnaHis(); 
					
//			this.sql = "SELECT A.IDX, B.TITLE, B.INSDATE, (SELECT MAX(BDEPTH) FROM TF_BOARD_QNA WHERE OBIDX = B.OBIDX) BDEPTH "
//				+		"FROM TF_MEMBER A, TF_BOARD_QNA B "
//				+		"WHERE A.IDX = B.IDX " 
//				+			"AND A.IDX = ? "
//				+		"ORDER BY B.BIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				MemberVo mvo = new MemberVo();							
				mvo.setIdx(rs.getInt("idx"));				
				
				BoardVo bvo = new BoardVo();
				bvo.setbIdx(rs.getInt("bidx"));
				bvo.setInsDate(rs.getString("insdate"));
				bvo.setTitle(rs.getString("title"));
				bvo.setbDepth(rs.getInt("bdepth"));				
				bvo.setMaxDepth(rs.getInt("maxdepth"));
				
				data.put("mvo",mvo);
				data.put("bvo",bvo);
				data.put("rNum", rs.getInt("rNum"));
			
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}
	
	//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트 TtCnt	
		public int adminImemInfoQnaHisTtCnt(int param_idx){
				
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 			
				
				this.sql = adminSql.getAdminImemInfoQnaHis(); 
						
//				this.sql = "SELECT A.IDX, B.TITLE, B.INSDATE, (SELECT MAX(BDEPTH) FROM TF_BOARD_QNA WHERE OBIDX = B.OBIDX) BDEPTH "
//					+		"FROM TF_MEMBER A, TF_BOARD_QNA B "
//					+		"WHERE A.IDX = B.IDX " 
//					+			"AND A.IDX = ? "
//					+		"ORDER BY B.BIDX DESC";
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, param_idx);
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
		
	//관리자 머니 충전 기록 리스트  
	public ArrayList<Map<String, Object>> adminMoneyList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminMoneyList();
			
//			this.sql = "A.IDX, B.MIDX, A.NAME, A.NICK, B.CHGMONEY, B.INSDATE, B.STATUS "
//				+		"FROM TF_MEMBER A, TF_MONEY_HIS B "
//				+		"WHERE A.IDX = B.IDX "
//				+		"ORDER BY B.MIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				MemberVo mbv = new MemberVo();				
				mbv.setIdx(rs.getInt("idx"));				
				mbv.setName(rs.getString("name"));
				mbv.setNick(rs.getString("nick"));
				
				MoneyVo mnv = new MoneyVo();
				mnv.setmIdx(rs.getInt("midx"));
				mnv.setChgMoney(rs.getInt("chgMoney"));
				mnv.setInsDate(rs.getString("insDate"));
				mnv.setStatus(rs.getInt("Status"));
				
				data.put("mbv",mbv);
				data.put("mnv",mnv);
				data.put("rNum", rs.getInt("rnum"));
			
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}
	
	//관리자 머니 충전 기록 리스트  TtCnt
		public int adminMoneyListTtCnt(){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 		
				
				this.sql = adminSql.getAdminMoneyList();
				
//				this.sql = "A.IDX, B.MIDX, A.NAME, A.NICK, B.CHGMONEY, B.INSDATE, B.STATUS "
//					+		"FROM TF_MEMBER A, TF_MONEY_HIS B "
//					+		"WHERE A.IDX = B.IDX "
//					+		"ORDER BY B.MIDX DESC";
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 머니 승인 트랜잭션
	public int adminMoneyModOkTransaction(int sess_idx, int mIdx) {
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = adminSql.getAdminMoneyModOkTransaction_1();
			
//			this.sql = "UPDATE TF_MONEY_HIS " 
//					+		"SET STATUS = 1, "
//					+		"AMONEY = CHGMONEY + BMONEY, "
//					+		"CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX = ?), " // sess_idx
//					+		"MODDATE = SYSDATE "
//					+		"WHERE MIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, sess_idx); 
			pstmt.setInt(2, mIdx);
						
			row = pstmt.executeUpdate();
			
			this.sql = adminSql.getAdminMoneyModOkTransaction_2();
			
//			this.sql = "UPDATE TF_IMEMBER_EXT "
//					+		"SET MONEY = (SELECT AMONEY FROM TF_MONEY_HIS WHERE MIDX = ?) "		
//					+		"WHERE IDX = (SELECT IDX FROM TF_MONEY_HIS WHERE MIDX = ?)";
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, mIdx);
			pstmt.setInt(2, mIdx);
			
			row += pstmt.executeUpdate();
	
			con.commit();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			
			try {
				con.rollback();
			} catch (SQLException e1) {		
				System.out.println(e1.getMessage());
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
	
	
	//관리자 머니 충전 승인
	public int adminMoneyModOk(int mIdx, Connection con){
				
		PreparedStatement pstmt = null;
				
		int row = 0; 		
		
		try { 		
								
			this.sql = "UPDATE TF_MONEY_HIS " 
				+		"SET STATUS = 1, "
				+		"CHKADMIN = '관리자', " 
				+		"MODDATE = SYSDATE "
				+		"WHERE MIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, mIdx);	
			row = pstmt.executeUpdate();			
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(pstmt); 
		}	
		return row;
	}
	
	//관리자 머니 충전 승인시 머니값 변경
	public int adminMoneyModImember(int mIdx, Connection con){
		 
		PreparedStatement pstmt = null; 
		
		int row = 0; 		
		
		try { 		
			
			this.sql = "UPDATE TF_IMEMBER_EXT "
				+		"SET MONEY = (SELECT AMONEY FROM TH_MONEY_HIS WHERE MIDX=?) "		
				+		"WHERE IDX = (SELECT IDX FROM TF_MONEY_HIS WHERE MIDX=?)";
					
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, mIdx);
			pstmt.setInt(2, mIdx);
			row = pstmt.executeUpdate();			
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(pstmt); 
		}	
		return row;
	}
	
	//관리자 머니 충전 거부
	public int adminMoneyModNOk(int sess_idx, int mIdx){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;	
		
		int row = 0; 		
		
		try { 	
			
			this.sql = adminSql.getAdminMoneyModNOk();
			
//			this.sql = "UPDATE TF_MONEY_HIS " 
//					+		"SET STATUS = 3, "
//					+		"CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX=?), " 
//					+		"MODDATE = SYSDATE "
//					+		"WHERE MIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, sess_idx);
			pstmt.setInt(2, mIdx);
			row = pstmt.executeUpdate();			
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}	
		return row;
	}
	
	//관리자 사업자 회원정보 페이지 회원리스트  
	public ArrayList<Map<String, Object>> adminCmemInfoList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try { 			
			
			this.sql = adminSql.getAdminCmemInfoList();
			
//			this.sql = "SELECT A.IDX, A.ID, A.NAME, B.PNFUNDS, C.STATUS "
//				+		"FROM TF_MEMBER A, (SELECT IDX, SUM(PNFUNDS) PNFUNDS FROM TF_PROJECT_LIST GROUP BY IDX) B, TF_PROJECT_LIST C "
//				+		"WHERE A.IDX = B.IDX "
//				+			"AND A.IDX = C.IDX "
//				+			"AND A.TYPE = 'C' "
//				+		"ORDER BY A.IDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				MemberVo mvo = new MemberVo();
				mvo.setIdx(rs.getInt("idx"));
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setStatus(rs.getInt("status"));
				
				ProjectVo pvo = new ProjectVo();					
				pvo.setPnFunds(rs.getInt("pnfunds"));
				
				data.put("mvo",mvo);
				data.put("pvo",pvo);
				data.put("rNum", rs.getInt("rnum"));
			
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}
	
	//관리자 사업자 회원정보 페이지 회원리스트  TtCnt
		public int adminCmemInfoListTtCnt(){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 			
				
				this.sql = adminSql.getAdminCmemInfoList();
				
//				this.sql = "SELECT A.IDX, A.ID, A.NAME, B.PNFUNDS, C.STATUS "
//					+		"FROM TF_MEMBER A, (SELECT IDX, SUM(PNFUNDS) PNFUNDS FROM TF_PROJECT_LIST GROUP BY IDX) B, TF_PROJECT_LIST C "
//					+		"WHERE A.IDX = B.IDX "
//					+			"AND A.IDX = C.IDX "
//					+			"AND A.TYPE = 'C' "
//					+		"ORDER BY A.IDX DESC";
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 사업자 회원정보 페이지 회원별 상세정보  
	public ArrayList<MemberVo> adminCmemInfoCon(int param_idx){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
						
			try { 		
				
				this.sql = adminSql.getAdminCmemInfoCon();
				
//				this.sql = "SELECT A.IDX, A.ID, A.NICK, A.NAME, A.PHONE, A.ADDR, B.CNUMBER, B.CADDR " 
//					+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
//					+		"WHERE A.IDX = B.IDX "
//					+			"AND A.TYPE ='C' "
//					+			"AND A.IDX = ?";
											
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, param_idx);	
				rs = pstmt.executeQuery();
				
				while(rs.next()) { 
					
					MemberVo vo = new MemberVo();					
					vo.setIdx(rs.getInt("idx"));
					vo.setId(rs.getString("id"));	
					vo.setNick(rs.getString("nick"));
					vo.setName(rs.getString("name"));
					vo.setPhone(rs.getInt("phone"));
					vo.setAddr(rs.getString("addr"));
					vo.setcNumber(rs.getString("cnumber"));
					vo.setcAddr(rs.getString("caddr"));				
								
					alist.add(vo);
				}
				
			}catch(Exception e) { 
				System.out.println(e.getMessage());
			}finally { 
				DBClose.close(con,pstmt,rs); 
			}	
			return alist;	
	}
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트	
	public ArrayList<ProjectVo> adminCmemInfoProj(int param_idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminCmemInfoProj();
			
//			this.sql = "SELECT PIDX, PNFUNDS, PTFUNDS, PNAME "
//				+		"FROM TF_PROJECT_LIST "
//				+		"WHERE STATUS = 1 "		
//				+			"AND IDX = ?";
										
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				ProjectVo vo = new ProjectVo();				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setPtFunds(rs.getInt("ptfunds"));
				vo.setpName(rs.getString("pname"));			
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;	
	}
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트1
	public ArrayList<FundVo> adminCmemInfoProj1(int param_idx){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			ArrayList<FundVo> alist = new ArrayList<FundVo>(); 
						
			try { 	
				
				this.sql = adminSql.getAdminCmemInfoProj1();
				
//				this.sql = "SELECT * "
//					+		"FROM TF_FUND_HIS "
//					+		"WHERE STATUS = 1 "
//					+			"AND IDX = ?";
											
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, param_idx);	
				rs = pstmt.executeQuery();
				
				while(rs.next()) { 
					
					FundVo vo = new FundVo();					
					vo.setInFunds(rs.getInt("infunds"));
					vo.setbFunds(rs.getInt("bfunds"));
					vo.setaFunds(rs.getInt("afunds"));
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
	
	//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트
	public ArrayList<ProjectVo> adminCmemInfoProjHis(int param_idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminCmemInfoProjHis();
			
//			this.sql = "SELECT PIDX, PNAME, PNFUNDS, PTFUNDS, INSDATE " 
//				+		"FROM TF_PROJECT_LIST "
//				+		"WHERE STATUS > 3 "
//				+			"AND IDX = ? "
//				+		"ORDER BY PIDX DESC";
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				ProjectVo vo = new ProjectVo();	
				vo.setrNum(rs.getInt("rnum"));
				vo.setpIdx(rs.getInt("pidx"));
				vo.setpName(rs.getString("pname"));
				vo.setPnFunds(rs.getInt("pnfunds"));
				vo.setPtFunds(rs.getInt("ptfunds"));
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
	
	//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트 TtCnt
		public int adminCmemInfoProjHisTtCnt(int param_idx){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 		
				
				this.sql = adminSql.getAdminCmemInfoProjHis();
				
//				this.sql = "SELECT PIDX, PNAME, PNFUNDS, PTFUNDS, INSDATE " 
//					+		"FROM TF_PROJECT_LIST "
//					+		"WHERE STATUS > 3 "
//					+			"AND IDX = ? "
//					+		"ORDER BY PIDX DESC";
				
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, param_idx);	
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
		
	//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트
	public ArrayList<Map<String, Object>> adminCmemInfoProjFundHis(int param_idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try { 	
			
			this.sql = adminSql.getAdminCmemInfoProjFundHis();
			
//			this.sql = "SELECT A.NICK, B.AFUNDS, B.INSDATE, B.STATUS FROM TF_MEMBER A, TF_FUND_HIS B "
//				+		"WHERE A.IDX = B.IDX "
//				+			"AND B.PIDX = (SELECT PIDX FROM TF_PROJECT_LIST WHERE IDX = ? AND STATUS = 1) "
//				+		"ORDER BY B.FIDX DESC";
			
			//테스트 전 프로젝트 테이블에서 status값 확인, 한 idx당 status값이 1개만 존재해야됨
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				MemberVo mvo = new MemberVo();
				mvo.setNick(rs.getString("nick"));
				
				FundVo fvo = new FundVo();				
				fvo.setaFunds(rs.getInt("afunds"));
				fvo.setInsDate(rs.getString("insdate"));
				fvo.setStatus(rs.getInt("status"));
				
				data.put("mvo",mvo);
				data.put("fvo",fvo);
			
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트 TtCnt
		public int adminCmemInfoProjFundHisTtCnt(int param_idx){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 	
				
				this.sql = adminSql.getAdminCmemInfoProjFundHis();
				
//				this.sql = "SELECT A.NICK, B.AFUNDS, B.INSDATE, B.STATUS FROM TF_MEMBER A, TF_FUND_HIS B "
//					+		"WHERE A.IDX = B.IDX "
//					+			"AND B.PIDX = (SELECT PIDX FROM TF_PROJECT_LIST WHERE IDX = ? AND STATUS = 1) "
//					+		"ORDER BY B.FIDX DESC";
				
				//테스트 전 프로젝트 테이블에서 status값 확인, 한 idx당 status값이 1개만 존재해야됨
				
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, param_idx);
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
		
	//관리자 사업자 회원정보 페이지 뉴스 리스트
	public ArrayList<Map<String, Object>> adminCmemInfoProjNewsHis(int param_idx, int listCnt, int pageCnt){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminCmemInfoProjNewsHis();
			
//			this.sql = "SELECT A.BIDX, A.TITLE, B.PNAME, A.INSDATE "
//				+		"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B "
//				+		"WHERE B.PIDX = A.PIDX "
//				+			"AND A.VIEWSTAT = 1 "
//				+			"AND B.IDX = ? "
//				+		"ORDER BY OBIDX DESC, RBIDX ASC";
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				BoardVo bvo = new BoardVo();				
				bvo.setbIdx(rs.getInt("bidx"));
				bvo.setTitle(rs.getString("title"));					
				bvo.setInsDate(rs.getString("insdate"));	
										
				ProjectVo pvo = new ProjectVo();
				pvo.setpName(rs.getString("pname"));
				
				data.put("bvo",bvo);
				data.put("pvo",pvo);
				data.put("rNum", rs.getInt("rnum"));
			
				alist.add(data);				
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;	
	}
	
	//관리자 사업자 회원정보 페이지 뉴스 리스트 TtCnt
		public int adminCmemInfoProjNewsHisTtCnt(int param_idx){
				
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 		
				
				this.sql = adminSql.getAdminCmemInfoProjNewsHis();
				
//				this.sql = "SELECT A.BIDX, A.TITLE, B.PNAME, A.INSDATE "
//					+		"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B "
//					+		"WHERE B.PIDX = A.PIDX "
//					+			"AND A.VIEWSTAT = 1 "
//					+			"AND B.IDX = ? "
//					+		"ORDER BY OBIDX DESC, RBIDX ASC";
				
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, param_idx);	
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
		
	//관리자 사업자 회원정보 페이지 QNA 리스트
	public ArrayList<BoardVo> adminCmemInfoProjQna(int param_idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminCmemInfoProjQna();
			
//			this.sql = "SELECT A.* "
//				+		"FROM TF_BOARD_QNA A, TF_PROJECT_LIST B "
//				+		"WHERE A.PIDX = B.PIDX "
//				+			"AND A.VIEWSTAT = 1 "
//				+			"AND B.IDX = ? "
//				+		"ORDER BY A.OBIDX DESC, A.RBIDX ASC";
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
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
				vo.setRbIdx(rs.getInt("rbidx"));
				vo.setbDepth(rs.getInt("bdepth"));
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
	
	//관리자 사업자 회원정보 페이지 QNA 리스트 TtCnt
	public int adminCmemInfoProjQnaTtCnt(int param_idx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
					
		try { 		
			
			this.sql = adminSql.getAdminCmemInfoProjQna();
			
//				this.sql = "SELECT A.* "
//					+		"FROM TF_BOARD_QNA A, TF_PROJECT_LIST B "
//					+		"WHERE A.PIDX = B.PIDX "
//					+			"AND A.VIEWSTAT = 1 "
//					+			"AND B.IDX = ? "
//					+		"ORDER BY A.OBIDX DESC, A.RBIDX ASC";
			
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, param_idx);	
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
	
	//관리자 사업자 등록 승인 리스트
	public ArrayList<MemberVo> adminCmemChkList(int listCnt, int pageCnt){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminCmemChkList();
			
//			this.sql = "SELECT A.IDX, A.NAME, A.MODDATE, A.STATUS "
//				+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
//				+		"WHERE A.IDX = B.IDX "
//				+			"AND TYPE = 'C' "
//				+			"AND STATUS = 0 "
//				+		"ORDER BY B.CIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				MemberVo vo = new MemberVo();				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setModDate(rs.getString("moddate"));
				vo.setStatus(rs.getInt("status"));
				vo.setrNum(rs.getInt("rnum"));
				
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;
	}
	
	//관리자 사업자 등록 승인 리스트 TtCnt
	public int adminCmemChkListTtCnt(){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
					
		try { 		
			
			this.sql = adminSql.getAdminCmemChkList();
			
//				this.sql = "SELECT A.IDX, A.NAME, A.MODDATE, A.STATUS "
//					+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
//					+		"WHERE A.IDX = B.IDX "
//					+			"AND TYPE = 'C' "
//					+			"AND STATUS = 0 "
//					+		"ORDER BY B.CIDX DESC";
		
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 사업자 등록 승인
	public int adminCmemChkOkMem(int param_idx){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0; 		
		
		try { 		
			
			this.sql = adminSql.getAdminCmemChkOkMem();
			
//			this.sql = "UPDATE TF_MEMBER "
//				+		"SET STATUS = 3 "
//				+		"WHERE IDX = ?";
					
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, param_idx);	
			row = pstmt.executeUpdate();			
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}	
		return row;
	}
	
	//관리자 사업자 등록 승인
	public int adminCmemChkOkCmem(int sess_idx, int param_idx){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0; 		
		
		try { 		
			
			this.sql = adminSql.getAdminCmemChkOkCmem();
			
//			this.sql = "UPDATE TF_CMEMBER_EXT "
//				+		"SET CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX = ?) "
//				+		"WHERE IDX = ?";
					
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, sess_idx);	
			pstmt.setInt(2, param_idx);
			row = pstmt.executeUpdate();			
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}	
		return row;
	}
	
	//관리자 프로젝트 등록 승인 리스트 
	public ArrayList<ProjectVo> adminProjChkList(int listCnt, int pageCnt){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminProjChkList();
			
//			this.sql = "SELECT PIDX, PNAME, INSDATE, STATUS " 
//				+		"FROM TF_PROJECT_LIST "
//				+		"ORDER BY PIDX DESC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ProjectVo vo = new ProjectVo();				
				vo.setpIdx(rs.getInt("pidx"));
				vo.setpName(rs.getString("pname"));
				vo.setInsDate(rs.getString("insdate"));				
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
	
	//관리자 프로젝트 등록 승인 리스트 TtCnt
	public int adminProjChkListTtCnt(){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0; 
					
		try { 		
			
			this.sql = adminSql.getAdminProjChkList();
			
//				this.sql = "SELECT PIDX, PNAME, INSDATE, STATUS " 
//					+		"FROM TF_PROJECT_LIST "
//					+		"ORDER BY PIDX DESC";
		
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 프로젝트 등록 승인 내용  
	public ArrayList<Map<String, Object>> adminProJChkCon(int pIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try { 				
			
			this.sql = adminSql.getAdminProJChkCon();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_PROJECT_LIST A, TF_ITEM_LIST B "
//				+		"WHERE A.PIDX = B.PIDX "
//				+			"AND A.PIDX = ?";
					
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				ProjectVo pvo = new ProjectVo();	
				pvo.setpIdx(rs.getInt("pidx"));
				pvo.setpName(rs.getString("pname"));
				pvo.setpCate(rs.getString("pcate"));
				pvo.setContents(rs.getString("contents"));
				pvo.setItList(rs.getString("itlist"));
				pvo.setItListCnt(rs.getInt("itlistcnt"));
				pvo.setPtFunds(rs.getInt("ptfunds"));
				pvo.setPnFunds(rs.getInt("pnfunds"));
				pvo.setpGrade(rs.getInt("pgrade"));
				pvo.setStatus(rs.getInt("status"));
				pvo.setInsDate(rs.getString("insdate"));
				pvo.setPsDate(rs.getString("psdate"));
				pvo.setPeDate(rs.getString("pedate"));
				pvo.setPcDate(rs.getString("pcdate"));
				
				ItemVo ivo = new ItemVo();
				ivo.setItIdx(rs.getInt("itidx"));
				ivo.setItName(rs.getString("itname"));
				ivo.setItPrice(rs.getInt("itprice"));
				ivo.setContents(rs.getString("contents"));
				ivo.setItTCnt(rs.getInt("ittcnt"));
				ivo.setItSCnt(rs.getInt("itscnt"));
				ivo.setStatus(rs.getInt("status"));
								
				data.put("pvo",pvo);
				data.put("ivo",ivo);
			
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}
	
	//관리자 프로젝트 등록 승인
	public int adminProJChkOk(int sess_idx, int pIdx){
			
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0; 		
		
		try { 	
			
			this.sql = adminSql.getAdminProJChkOk();
			
//			this.sql = "UPDATE TF_PROJECT_LIST " 
//				+		"SET STATUS = 1 "
//				+		"CHKADMIN = '(SELECT NICK FROM TF_MEMBER WHERE IDX = ?)' "	
//				+		"WHERE PIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, sess_idx);	
			pstmt.setInt(2, pIdx);
			row = pstmt.executeUpdate();			
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}	
		return row;
	}

	//관리자 프로젝트 등록 반려 
	public int adminProJChkNOk(int sess_idx, int pIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0; 		
		
		try { 			
			
			this.sql = adminSql.getAdminProJChkNOk();
			
//			this.sql = "UPDATE TF_PROJECT_LIST " 
//				+		"SET STATUS = 2, " 
//				+		"CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX = ?) "
//				+		"WHERE PIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);							
			pstmt.setInt(1, sess_idx);
			pstmt.setInt(2, pIdx);
			row = pstmt.executeUpdate();			
					
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}	
		return row;
	}
	
	//관리자 고객센터 페이지 QNA리스트 
	public ArrayList<BoardVo> adminBoardQnaList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminBoardQnaList();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_BOARD_QNA "
//				+		"WHERE VIEWSTAT = 1 "
//				+		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
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
				vo.setRbIdx(rs.getInt("rbidx"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
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
	
	//관리자 고객센터 페이지 QNA리스트 TtCnt
		public int adminBoardQnaListTtCnt(){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 		
				
				this.sql = adminSql.getAdminBoardQnaList();
				
//				this.sql = "SELECT * "
//					+		"FROM TF_BOARD_QNA "
//					+		"WHERE VIEWSTAT = 1 "
//					+		"ORDER BY OBIDX DESC, RBIDX ASC";
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 고객센터 페이지 QNA 상세내용
	public ArrayList<BoardVo> adminBoardQnaCon(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 			
			
			this.sql = adminSql.getAdminBoardQnaCon();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_BOARD_QNA "
//				+		"WHERE BIDX = ?";
					
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				
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
				vo.setContents(rs.getString("contents"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));
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
	
	//관리자 고객센터 페이지 QNA 답변 작성
	public int adminBoardQnaWrite(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try {
			
			con.setAutoCommit(false);
			
			this.sql = adminSql.getAdminBoardQnaWrite_1();
			
//			this.sql = "UPDATE TF_BOARD_QNA " 
//				+		"SET RBIDX = RBIDX + 1 "
//				+		"WHERE OBIDX = (SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) " 
//				+			"AND RBIDX > (SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, inputBV.getbIdx());
			pstmt.setInt(2, inputBV.getbIdx());
						
			row = pstmt.executeUpdate();
			
			this.sql = adminSql.getAdminBoardQnaWrite_2();
			
//			this.sql = "INSERT INTO TF_BOARD_QNA (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, PIDX) "
//				+		"VALUES ("
//				+ 				"SEQ_TF_BIDX_QNA.NEXTVAL, "
//				+ 				"?, " // IDX
//				+ 				"?, " // CATE
//				+ 				"?, " // TITLE
//				+ 				"?, " // CONTENTS
//				+ 				"0, " // HIT
//				+ 				"0, " // GOOD
//				+ 				"0, " // BAD
//				+ 				"(SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?), " //OBIDX
//				+ 				"(SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //RBIDX
//				+ 				"(SELECT BDEPTH FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //BDEPTH
//				+ 				"0, " //COMMCNT
//				+ 				"1, " //VIEWSTAT
//				+ 				"SYSDATE, " //INSDATE
//				+ 				"SYSDATE, " //MODDATE
//				+ 				"(SELECT PIDX FROM TF_BOARD_QNA WHERE BIDX = ?) " //PIDX
//				+ 				")";

			pstmt = con.prepareStatement(this.sql);
			
			pstmt.setInt(1, inputBV.getIdx());
			pstmt.setString(2, inputBV.getCate());
			pstmt.setString(3, inputBV.getTitle());
			pstmt.setString(4, inputBV.getContents());
			pstmt.setInt(5, inputBV.getbIdx());
			pstmt.setInt(6, inputBV.getbIdx());
			pstmt.setInt(7, inputBV.getbIdx());
			pstmt.setInt(8, inputBV.getpIdx());
			
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
		
	//관리자 고객센터 페이지 QNA 답변 및 내용 수정 
	public int adminBoardQnaMod(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = adminSql.getAdminBoardQnaMod();
			
//			this.sql = "UPDATE TF_BOARD_QNA "
//				+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "	
//				+		"WHERE BIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setString(1, inputBV.getCate());
			pstmt.setString(2, inputBV.getTitle());
			pstmt.setString(3, inputBV.getContents());
			pstmt.setInt(4, inputBV.getbIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	//관리자 고객센터 페이지 QNA 삭제 
	public int adminBoardQnaDel(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = adminSql.getAdminBoardQnaDel();
					
//			this.sql = "UPDATE TF_BOARD_QNA "
//				+		"SET VIEWSTAT = 0 "	
//				+		"WHERE BIDX = ?";
		
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
	
	//관리자 고객센터 페이지 FAQ 리스트 
	public ArrayList<BoardVo> adminBoardFaqList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 
			
			this.sql = adminSql.getAdminBoardFaqList();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_BOARD_FAQ "
//				+		"WHERE VIEWSTAT = 1 "
//				+		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
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
				vo.setObIdx(rs.getInt("obidx"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));	
				vo.setbDepth(rs.getInt("bdepth"));
				vo.setViewStat(rs.getInt("viewStat"));
			
				alist.add(vo);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}	
		return alist;	
	}
	
	//관리자 고객센터 페이지 FAQ 리스트 TtCnt
	public int adminBoardFaqListTtCnt(){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
					
		try { 
			
			this.sql = adminSql.getAdminBoardFaqList();
			
//				this.sql = "SELECT * "
//					+		"FROM TF_BOARD_FAQ "
//					+		"WHERE VIEWSTAT = 1 "
//					+		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 고객센터 페이지 FAQ 상세내용 
	public ArrayList<BoardVo> adminBoardFaqCon(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 	
			
			this.sql = adminSql.getAdminBoardFaqCon();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_BOARD_FAQ "
//				+		"WHERE BIDX = ?";
					
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, bIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				
				BoardVo vo = new BoardVo();				
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setObIdx(rs.getInt("obidx"));
				vo.setRbIdx(rs.getInt("rbidx"));
				vo.setContents(rs.getString("contents"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));	
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
		
	
	//관리자 고객센터 페이지 FAQ 작성  
	public int adminBoardFaqWrite(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try {			
			
			this.sql = adminSql.getAdminBoardFaqWrite();
			
//			this.sql = "INSERT INTO TF_BOARD_FAQ (BIDX, IDX, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE) "
//				 +		"VALUES ("
//				 +			"SEQ_TF_BIDX_FAQ.NEXTVAL, "
//				 + 			"?, " //IDX
//				 + 			"?, " //CATE
//				 + 			"?, " //TITLE
//				 + 			"?, " //CONTENTS
//				 + 			"0, " //HIT
//				 + 			"0, " //GOOD
//				 + 			"0, " //BAD
//				 + 			"SEQ_TF_BIDX_FAQ.CURRVAL, " //OBIDX
//				 + 			"1, " //RBIDX
//				 + 			"1, " //BDEPTH
//				 + 			"0, " //COMMCNT
//				 + 			"1, " //VIEWSTAT
//				 + 			"SYSDATE, " //INSDATE
//				 + 			"SYSDATE" //MODDATE
//				 + 		")";

			pstmt = con.prepareStatement(this.sql); 
			
			pstmt.setInt(1, inputBV.getIdx());
			pstmt.setString(2, inputBV.getCate());
			pstmt.setString(3, inputBV.getTitle());
			pstmt.setString(4, inputBV.getContents());			
			
			row = pstmt.executeUpdate();	
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally {			
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	//관리자 고객센터 페이지 FAQ 수정 
	public int adminBoardFaqMod(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = adminSql.getAdminBoardFaqMod();
			
//			this.sql = "UPDATE TF_BOARD_FAQ "
//				+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "	
//				+		"WHERE BIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setString(1, inputBV.getCate());
			pstmt.setString(2, inputBV.getTitle());
			pstmt.setString(3, inputBV.getContents());	
			pstmt.setInt(4, inputBV.getbIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	//관리자 고객센터 페이지 FAQ 삭제  
	public int adminBoardFaqDel(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 	
			
			this.sql = adminSql.getAdminBoardFaqDel();
			
//			this.sql = "UPDATE TF_BOARD_FAQ "
//				+		"SET VIEWSTAT = 0 "	
//				+		"WHERE BIDX = ?";
		
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

	//관리자 고객센터 페이지 전체 공지사항 리스트 
	public ArrayList<BoardVo> adminBoardNoticeList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminBoardNoticeList();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_BOARD_NOTICE "
//				+		"WHERE VIEWSTAT = 1 "
//				+		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
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
				vo.setObIdx(rs.getInt("obidx"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));		
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
	
	//관리자 고객센터 페이지 전체 공지사항 리스트 TtCnt
	public int adminBoardNoticeListTtCnt(){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
					
		try { 		
			
			this.sql = adminSql.getAdminBoardNoticeList();
			
//				this.sql = "SELECT * "
//					+		"FROM TF_BOARD_NOTICE "
//					+		"WHERE VIEWSTAT = 1 "
//					+		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 고객센터 페이지 전체 공지사항 상세내용 
	public ArrayList<BoardVo> adminBoardNoticeCon(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 	
			
			this.sql = adminSql.getAdminBoardNoticeCon();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_BOARD_NOTICE "
//				+		"WHERE BIDX = ?";
					
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, bIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				
				BoardVo vo = new BoardVo();				
				vo.setbIdx(rs.getInt("bidx"));
				vo.setIdx(rs.getInt("idx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setObIdx(rs.getInt("obidx"));
				vo.setRbIdx(rs.getInt("rbidx"));
				vo.setContents(rs.getString("contents"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setModDate(rs.getString("moddate"));	
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
	
	//관리자 고객센터 페이지 전체 공지사항 작성 
	public int adminBoardNoticeWrite(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try {			
			
			this.sql = adminSql.getAdminBoardNoticeWrite();
			
//			this.sql = "INSERT INTO TF_BOARD_NOTICE (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE) "
//				+		"VALUES ("
//				+ 			"SEQ_TF_BIDX_NOTICE.NEXTVAL, "
//				+ 			"?, " // IDX
//				+			"?, " // CATE
//				+ 			"?, " // TITLE
//				+ 			"?, " // CONTENTS
//				+ 			"0, "
//				+ 			"0, "
//				+ 			"0, "
//				+ 			"SEQ_TF_BIDX_NOTICE.CURRVAL, "
//				+ 			"1, "
//				+ 			"1, "
//				+ 			"0, "
//				+ 			"1, "
//				+ 			"SYSDATE, "
//				+ 			"SYSDATE"
//				+ 		")";

			pstmt = con.prepareStatement(this.sql); 
			
			pstmt.setInt(1, inputBV.getIdx());
			pstmt.setString(2, inputBV.getCate());
			pstmt.setString(3, inputBV.getTitle());
			pstmt.setString(4, inputBV.getContents());			
			
			row = pstmt.executeUpdate();	
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally {			
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	//관리자 고객센터 페이지 전체 공지사항 수정
	public int adminBoardNoticeMod(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = adminSql.getAdminBoardNoticeMod();
			
//			this.sql = "UPDATE TF_BOARD_NOTICE "
//				+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "	
//				+		"WHERE BIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setString(1, inputBV.getCate());
			pstmt.setString(2, inputBV.getTitle());
			pstmt.setString(3, inputBV.getContents());	
			pstmt.setInt(4, inputBV.getbIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	//관리자 고객센터 페이지 전체 공지사항 삭제  
	public int adminBoardNoticeQnaDel(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 		
			
			this.sql = adminSql.getAdminBoardNoticeQnaDel();
			
//			this.sql = "UPDATE TF_BOARD_NOTICE "
//				+		"SET VIEWSTAT = 0 "	
//				+		"WHERE BIDX = ?";
		
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
	
	//관리자 뉴스관리 페이지 뉴스 리스트  
	public ArrayList<BoardVo> adminBoardNewsList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
					
		try { 		
			
			this.sql = adminSql.getAdminBoardNewsList();
			
//			this.sql = "SELECT * "
//				+		"FROM TF_BOARD_NEWS "
//				+		"WHERE VIEWSTAT = 1 "
//				+		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
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
				vo.setModDate(rs.getString("moddate"));
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
	
	//관리자 뉴스관리 페이지 뉴스 리스트  TtCnt
	public int adminBoardNewsListTtCnt(){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		int row = 0;
					
		try { 		
			
			this.sql = adminSql.getAdminBoardNewsList();
			
//				this.sql = "SELECT * "
//					+		"FROM TF_BOARD_NEWS "
//					+		"WHERE VIEWSTAT = 1 "
//					+		"ORDER BY OBIDX DESC, RBIDX ASC";
		
			this.sql = new PagingQ().pagingCnt(sql);
			
			pstmt = con.prepareStatement(this.sql); 
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
		
	//관리자 뉴스관리 페이지 뉴스 상세내용  
	public ArrayList<Map<String, Object>> adminBoardNewsCon(int bIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
					
		try {		
			
			this.sql = adminSql.getAdminBoardNewsCon();
			
//			this.sql = "SELECT A.*, B.PIDX, B.PNAME, B.PNFUNDS, B.PGRADE, B.STATUS "
//				 +		"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B " 
//				 +		"WHERE A.PIDX = B.PIDX "
//				 +			"AND A.BIDX = ?";	
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, bIdx);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				Map<String, Object> data = new HashMap<String, Object>(); 
				
				BoardVo bvo = new BoardVo();				
				bvo.setbIdx(rs.getInt("bidx"));
				bvo.setpIdx(rs.getInt("pidx"));
				bvo.setIdx(rs.getInt("idx"));				
				bvo.setCate(rs.getString("cate"));
				bvo.setTitle(rs.getString("title"));
				bvo.setHit(rs.getInt("hit"));
				bvo.setGood(rs.getInt("good"));
				bvo.setBad(rs.getInt("bad"));
				bvo.setObIdx(rs.getInt("obidx"));
				bvo.setRbIdx(rs.getInt("rbidx"));
				bvo.setContents(rs.getString("contents"));
				bvo.setInsDate(rs.getString("insdate"));
				bvo.setModDate(rs.getString("moddate"));	
				
				ProjectVo pvo = new ProjectVo();				
				pvo.setpName(rs.getString("pname"));
				pvo.setPnFunds(rs.getInt("pnfunds"));
				pvo.setpGrade(rs.getInt("pgrade"));
				pvo.setStatus(rs.getInt("status"));
								
				data.put("bvo", bvo);
				data.put("pvo", pvo);
			
				alist.add(data);
			}
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
	}	
	
	//관리자 뉴스관리 페이지 뉴스 작성
	public int adminBoardNewsWrite(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try {		
			
			this.sql = adminSql.getAdminBoardNewsWrite();
			
//			this.sql = "INSERT INTO TF_BOARD_NEWS (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE) "
//				+		"VALUES ("
//				+ 			"SEQ_TF_BIDX_NEWS.NEXTVAL, "
//				+ 			"?, " // IDX
//				+ 			"?, " // CATE
//				+ 			"?, " // TITLE
//				+ 			"?, " // CONTENTS
//				+ 			"0, "
//				+ 			"0, "
//				+ 			"0, "
//				+ 			"SEQ_TF_BIDX_NEWS.CURRVAL, "
//				+ 			"1, "
//				+ 			"1, "
//				+ 			"0, "
//				+ 			"1, "
//				+ 			"SYSDATE, "
//				+ 			"SYSDATE"
//				+ 		")";

			pstmt = con.prepareStatement(this.sql); 
			
			pstmt.setInt(1, inputBV.getIdx());
			pstmt.setString(2, inputBV.getCate());
			pstmt.setString(3, inputBV.getTitle());
			pstmt.setString(4, inputBV.getContents());			
			
			row = pstmt.executeUpdate();	
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally {			
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	//관리자 뉴스관리 페이지 뉴스 수정  
	public int adminBoardNewsMod(BoardVo inputBV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = adminSql.getAdminBoardNewsMod();
			
//			this.sql = "UPDATE TF_BOARD_NEWS "
//				+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE"	
//				+		"WHERE BIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setString(1, inputBV.getCate());
			pstmt.setString(2, inputBV.getTitle());
			pstmt.setString(3, inputBV.getContents());	
			pstmt.setInt(4, inputBV.getbIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	//관리자 뉴스관리 페이지 뉴스 삭제 
	public int adminBoardNewsDel(int bIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 	
			
			this.sql = adminSql.getAdminBoardNewsDel();
			
//			this.sql = "UPDATE TF_BOARD_NEWS "
//				+		"SET VIEWSTAT = 0 "	
//				+		"WHERE BIDX = ?";
		
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

	//관리자 메모리스트 확인 
	public ArrayList<MemoVo> adminBoardMemoList(int sess_idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<MemoVo> alist = new ArrayList<MemoVo>(); 
					
		try { 	
			
			this.sql = adminSql.getAdminBoardMemoList();
			
//				this.sql = "SELECT * "
//					+		"FROM TF_MEMO_LIST "
//					+		"WHERE RECVIDX = ? "
//					+		"ORDER BY MEMOIDX DESC";	
		
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, sess_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				
				MemoVo vo = new MemoVo();					
				vo.setMemoIdx(rs.getInt("memoidx"));
				vo.setSendIdx(rs.getInt("sendidx"));
				vo.setRecvIdx(rs.getInt("recvidx"));
				vo.setContents(rs.getString("contents"));
				vo.setStatus(rs.getInt("status"));
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
	
	//관리자 메모리스트 확인 TtCnt
		public int adminBoardMemoListTtCnt(int sess_idx){
			
			Connection con = dbconnect.getConnection(); 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			int row = 0;
						
			try { 	
				
				this.sql = adminSql.getAdminBoardMemoList();
				
//					this.sql = "SELECT * "
//						+		"FROM TF_MEMO_LIST "
//						+		"WHERE RECVIDX = ? "
//						+		"ORDER BY MEMOIDX DESC";	
			
				this.sql = new PagingQ().pagingCnt(sql);
				
				pstmt = con.prepareStatement(this.sql); 
				pstmt.setInt(1, sess_idx);
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
		
	//관리자 메모페이지 메모 작성 
	public int adminBoardMemoSend(int sendIdx, int recvIdx, MemoVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try {		
			
			this.sql = adminSql.getAdminBoardMemoSend();
			
//			this.sql = "INSERT INTO TF_MEMO_LIST (MEMOIDX,SENDIDX,RECVIDX,CONTENTS,STATUS,INSDATE) "
//				+		"VALUES ("
//				+ 			"SEQ_TF_MEMOIDX.NEXTVAL, " // MEMOIDX
//				+ 			"?, " // SENDIDX
//				+ 			"(SELECT IDX FROM TF_MEMBER WHERE ID = ?), " // RECVIDX
//				+ 			"?, " // CONTNTS
//				+ 			"0, " // STATUS
//				+ 			"SYSDATE"
//				+ 		")";

			pstmt = con.prepareStatement(this.sql); 
						
			pstmt.setInt(1, sendIdx);
			pstmt.setInt(2, recvIdx);			
			pstmt.setString(3, inputMV.getContents());	
			
			row = pstmt.executeUpdate();	
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally {			
			DBClose.close(con,pstmt); 
		}
	
		return row;		
	}
	
	
}

