package common;

public class PagingQ {

	public String pagingStr(String query, int listCnt, int nowPage){
		query = "SELECT * FROM (SELECT ROWNUM RNUM, X.* FROM (" + query + ") X WHERE ROWNUM <= " + listCnt * nowPage + ") WHERE RNUM > " + listCnt * (nowPage - 1); 
		return query;
	}
	
	public String pagingCnt(String query){
		query = "SELECT COUNT(*) FROM (" + query + ") X";	
		return query;
	}
	
	public String pagingList(int listCnt, int pageCnt, int ttCnt){
		String rtn = null;
		int startPage = 0, endPage = 0;
				
		if(pageCnt < 5){
			startPage = 1;
		}else{
			startPage = pageCnt - 4;
		}
		
		if((ttCnt / listCnt) > pageCnt + 5){
			endPage = pageCnt + 5;
		}else{
			if((ttCnt % listCnt) == 0){
				endPage = (ttCnt / listCnt);	
			}else{
				endPage = (ttCnt / listCnt) + 1;	
			}
		}
		
		rtn = startPage + " " + pageCnt + " " + endPage; 
				
		return rtn;
	}
	
}
