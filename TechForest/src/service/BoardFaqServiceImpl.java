package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBClose;
import common.DBConnect;
import common.PagingQ;

public class BoardFaqServiceImpl {
	DBConnect dbconnect = new DBConnect();
	String sql = "";
	
	public ArrayList<BoardVo> boardFaqList(int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT BIDX, CATE, TITLE, HIT, INSDATE "
				+	"FROM TF_BOARD_FAQ "
				+	"ORDER BY BIDX DESC ";		
			
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setInsDate(rs.getString("insdate"));
				
				alist.add(vo);				
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
		
	}
	
	public ArrayList<BoardVo> boardListCate(String cate, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT BIDX, CATE, TITLE, HIT, INSDATE "
				+	"FROM TF_BOARD_FAQ "
				+	"WHERE CATE =? "
				+	"ORDER BY BIDX DESC ";
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "회원");
			rs = pstmt.executeQuery();
	
			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setInsDate(rs.getString("insdate"));
				
				alist.add(vo);
				
			}			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
	
	}
	
	public ArrayList<BoardVo> boardFaqCon(int bidx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			this.sql = "SELECT CATE, TITLE, CONTENTS, HIT, INSDATE "
				+	"FROM TF_BOARD_FAQ "
				+	"WHERE BIDX = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bidx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setHit(rs.getInt("hit"));
				vo.setInsDate(rs.getString("insdate"));
			
				alist.add(vo);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
	}

	
	public int boardFaqHit(int bidx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;		
		
		try{
			this.sql = "UPDATE TF_BOARD_FAQ "
				+ 	"SET HIT = HIT + 1 "
				+ 	"WHERE BIDX = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bidx);
			
			row = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt);
		}
		
		return row ;
	
	}	
	
	
}