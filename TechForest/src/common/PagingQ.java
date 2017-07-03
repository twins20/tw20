package common;

public class PagingQ {

	public String pagingStr(String query, int listCnt, int nowPage){
		query = "SELECT * FROM (SELECT ROWNUM RNUM, X.* FROM (" + query + ") X WHERE ROWNUM <= " + listCnt * nowPage + ") WHERE RNUM > " + listCnt * (nowPage - 1); 
		return query;
	}
}
