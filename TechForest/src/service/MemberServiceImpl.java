package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import common.*;

public class MemberServiceImpl {

	DBConnect dbconnect = new DBConnect();
	String sql = null;
	
	public int memJoin(MemberVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;

		try {
			
			this.sql = "INSERT INTO TF_MEMBER(IDX,ID,PW,NAME,NICK,PHONE,ADDR,STATUS,TYPE,INSDATE) "
					+	"VALUES(SEQ_TF_IDX.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE) "; 
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setInt(5, vo.getPhone());
			pstmt.setString(6, vo.getAddr());
			pstmt.setInt(7, vo.getStatus());
			pstmt.setString(8, vo.getType());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public Map<String, Object> memLogIn(MemberVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		try {
			
			this.sql = "SELECT ROWNUM, IDX, ID, STATUS, TYPE "
					+	"FROM TF_MEMBER "
					+	"WHERE ID = ? AND PW = ?";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, inputMV.getId());
			pstmt.setString(2, inputMV.getPw());	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				data.put("rownum", rs.getInt("rownum"));
				data.put("idx", rs.getInt("idx"));
				data.put("id", rs.getString("id"));
				data.put("status", rs.getInt("status"));
				data.put("type", rs.getString("type"));
				
			}

		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return data;
		
	}

	public MemberVo memMemberFindMail(MemberVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo vo = new MemberVo();
		
		try {
			
			this.sql = "SELECT ID "
					+	"FROM TF_MEMBER "
					+	"WHERE NAME = ? "
					+	"AND PHONE = ?";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, inputMV.getName());
			pstmt.setInt(2, inputMV.getPhone());	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setId(rs.getString("id"));
			}

		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return vo;
		
	}
	
	public MemberVo memMemberFindPass(MemberVo inputMV){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo vo = new MemberVo();
		
		try {
			
			this.sql = "SELECT PW "
					+	"FROM TF_MEMBER "
					+	"WHERE ID = ? "
					+	"AND NAME = ? "
					+	"AND PHONE = ?";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1, inputMV.getId());
			pstmt.setString(2, inputMV.getName());
			pstmt.setInt(3, inputMV.getPhone());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setPw(rs.getString("pw"));
			}

		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return vo;
		
	}
	
	public ArrayList<MemoVo> memMemoList(int idx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemoVo> alist = new ArrayList<MemoVo>(); 
		
		try {
			
			this.sql = "SELECT * "
					+	"FROM TF_MEMO_LIST "
					+	"WHERE RECVIDX = ? "
					+	"AND (STATUS = 0 OR STATUS = 1) "
					+	"ORDER BY MEMOIDX DESC";
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemoVo vo = new MemoVo();
				
				vo.setMemoIdx(rs.getInt("memoidx"));
				vo.setSendIdx(rs.getInt("sendidx"));
				vo.setRecvIdx(rs.getInt("recvidx"));
				vo.setContents(rs.getString("contents"));
				vo.setStatus(rs.getInt("status"));
				
				alist.add(vo);
			}

		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return alist;
		
	}
	
	public MemoVo memMemoCon(int memoIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemoVo vo = new MemoVo(); 
		
		try {
			
			this.sql = "SELECT * "
					+	"FROM TF_MEMO_LIST "
					+	"WHERE MEMOIDX = ?";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, memoIdx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
						
				vo.setMemoIdx(rs.getInt("memoidx"));
				vo.setSendIdx(rs.getInt("sendidx"));
				vo.setRecvIdx(rs.getInt("recvidx"));
				vo.setContents(rs.getString("contents"));
				vo.setStatus(rs.getInt("status"));
				
			}

		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return vo;
		
	}
	
	public int memMemoDel(int memoIdx){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			
			this.sql = "UPDATE TF_MEMO_LIST "
					+	"SET STATUS = STATUS + 2 "
					+	"WHERE (STATUS = 0 OR STATUS = 1) "
					+	"AND MEMOIDX = ?";
		
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
}
