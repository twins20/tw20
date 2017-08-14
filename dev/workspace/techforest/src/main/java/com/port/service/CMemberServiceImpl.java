package com.port.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CMemberServiceImpl implements CMemberService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ProjectVo cMemberIndexProjNowList(int sess_idx){
		
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		ProjectVo pv = cMemberMapper.cMemberIndexProjNowList(sess_idx);
		
		return pv;	
	}
	
	@Override
	public ArrayList<Map<String, Object>> cMemberIndexCommList(int sess_idx){
		
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		dataList = cMemberMapper.cMemberIndexCommList(sess_idx);
		
		return dataList;
	}
	
	@Override
	public int cMemberInfoExtWriteChk(int sess_idx){
		
		int row = 0;
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		row = cMemberMapper.cMemberInfoExtWriteChk(sess_idx);
		
		return row;		
	}
	
	@Override
	public int cMemberInfoExtWrite(int sess_idx, MemberVo mv){
		
		int row = 0;
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("sess_idx", sess_idx);
		data.put("cIdx", mv.getcIdx());
		data.put("company", mv.getCompany());
		data.put("cNumber", mv.getcNumber());
		data.put("cAddr", mv.getcAddr());
		
		row = cMemberMapper.cMemberInfoExtWrite(data);
		
		return row;	
	}
	
	@Override
	public Map<String, Object> cMemberInfoCon(int sess_idx){

		Map<String, Object> data = new HashMap<String, Object>();
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		data = cMemberMapper.cMemberInfoCon(sess_idx);
		
		return data;	
	}
	
	@Override
	public int cMemberInfoModChk(MemberVo mv){
		
		int row = 0;
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		row = cMemberMapper.cMemberInfoModChk(mv);
		
		return row;
	}
	
	@Override
	public int cMemberInfoMod(MemberVo mv){
		
		int row = 0;
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		row = cMemberMapper.cMemberInfoMod(mv);

		return row;
	}
	
	@Override
	public ProjectVo cMemberProjNowList(int sess_idx){
		
		ProjectVo pv = new ProjectVo();
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		pv = cMemberMapper.cMemberProjNowList(sess_idx);
		
		return pv;
	}
	
	@Override
	public ArrayList<ProjectVo> cMemberProjHisList(int sess_idx){
		
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		plist = cMemberMapper.cMemberProjHisList(sess_idx);
	
		return plist;
	}
	
/*
	public int cMemProjApplyWrite(ProjectVo inputPV, Map itData){

		//펑션을 먼저 SQL 내부에 등록해야함.
		//CREATE OR REPLACE FUNCTION GET_SEQ_TF_ITIDX RETURN NUMBER AS NUM NUMBER;
		//BEGIN
		//SELECT SEQ_TF_ITIDX.NEXTVAL
		//INTO NUM
		//FROM DUAL;
		//RETURN NUM;
		//END GET_SEQ_TF_ITIDX;

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
				pstmt.setString(1, itList[itCnt].getItName());
				pstmt.setInt(2, itList[itCnt].getItPrice());
				pstmt.setString(3, itList[itCnt].getContents());
				pstmt.setInt(4, itList[itCnt].getItTCnt());
			}
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
	}
	
	
/*
	public int cMemberMemoWrite(MemoVo mev){
		
		int row = 0; 
		CMemberMapper cMemberMapper = sqlSession.getMapper(CMemberMapper.class);
		row = cMemberMapper.cMemberMemoWrite(mev);
		
		INSERT INTO TF_BOARD_NEWS (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, PIDX) 
		VALUES (SEQ_TF_BIDX_NEWS.NEXTVAL, ?, (SELECT PCATE FROM TF_PROJECT_LIST WHERE PIDX = ?), ?, ?, 0, 0, 0, SEQ_TF_BIDX_NEWS.CURRVAL, 1, 1, 0, 1, SYSDATE, SYSDATE, ?)
		
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

	public ProjectVo cMemProjApplyConProj(int sess_idx){
		
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
			pstmt.setInt(1, sess_idx);
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
	
	public ProjectVo cMemProjApplyItemPlusConProj(int sess_idx){
		
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
			pstmt.setInt(1, sess_idx);
			rs = pstmt.executeQuery();
					
			if(rs.next()) { 
				
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
	
*/	
}