package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBClose;
import common.DBConnect;
import common.PagingQ;

public class BoardNoticeServiceImpl {
	
	DBConnect dbconnect = new DBConnect();
	String sql = "";
	
	public ArrayList<BoardVo> boardNoticeList(int bidx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT BIDX, TITLE, INSDATE, HIT "
				+		"FROM TF_BOARD_NOTICE "
				+		"WHERE BIDX = ? ";
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, bidx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setTitle(rs.getString("title"));
				vo.setInsDate(rs.getString("insdate"));
				vo.setHit(rs.getInt("hit"));
				
				alist.add(vo);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return alist;
		
	}
	
	public ArrayList<BoardVo> boardNoticeListCate(String cate, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT BIDX, CATE, TITLE, HIT, INSDATE "
				+		"FROM TF_BOARD_NOTICE "
				+		"WHERE VIEWSTAT = 1 "
				+			"AND  CATE = ? "
				+		"ORDER BY BIDX DESC ";
			
			this.sql = new PagingQ().pagingStr(this.sql, listCnt, pageCnt);
						
			pstmt = con.prepareStatement(this.sql);
			pstmt.setString(1,cate);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				BoardVo vo = new BoardVo();
				vo.setbIdx(rs.getInt("bidx"));
				vo.setCate(rs.getString("cate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));
				vo.setInsDate(rs.getString("insdate"));
				
				blist.add(vo);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			DBClose.close(con,pstmt,rs);
		}
		
		return blist;
		
	}	
		
	public ArrayList<BoardVo> boardNoticeCon(int bidx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		try{
			
			this.sql = "SELECT CATE, TITLE, CONTENTS, HIT, INSDATE "
				+		"FROM TF_BOARD_NOTICE "
				+		"WHERE BIDX = ? ";
			
			pstmt = con.prepareStatement(this.sql);
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
		
	public int boardNoticeHit(int bidx){
		
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		
		try{
			
			this.sql = "UPDATE TF_BOARD_NOTICE "
				+		"SET HIT = HIT + 1 "
				+		"WHERE BIDX = ?";
			
			pstmt=con.prepareStatement(this.sql);
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
