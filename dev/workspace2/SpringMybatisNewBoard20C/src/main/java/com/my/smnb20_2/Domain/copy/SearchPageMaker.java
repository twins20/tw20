package com.my.smnb20_2.Domain.copy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SearchPageMaker {

	private int totalCount;
	private int totalCount_R;
	
	private int startPage;
	private int endPage;
	

	private boolean prev;
	private boolean next;
	private int totalPage;
	

	private int displayPageNum = 10;
	
	private SearchCriteria scri;
	private BidxSearchCriteria bscri;

	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getTotalCount_R() {
		return totalCount_R;
	}

	public void setTotalCount_R(int totalCount_R) {
		this.totalCount_R = totalCount_R;
		
		calcData_R();
	}
	
	
	private void calcData(){
		
		endPage = (int) (Math.ceil(scri.getPage() / 
				(double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / 
				(double) scri.getPerPageNum()));
		
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * scri.getPerPageNum() >= totalCount ? false : true;
		
		totalPage =  (int) ( Math.ceil( totalCount / (double)scri.getPerPageNum() ) );
//		totalPage =  ( totalCount / scri.getPerPageNum() ) + 1;
	}
	
	
	private void calcData_R(){
		
		System.out.println("SearchPageMaker의 calcData_R()의 bscri = " + bscri);
		System.out.println("SearchPageMaker의 calcData_R()의 bscri.getPage() = " + bscri.getPage());
		
		endPage = (int) (Math.ceil(bscri.getPage() / 
				(double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount_R / 
				(double) bscri.getPerPageNum()));
		
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * bscri.getPerPageNum() >= totalCount_R ? false : true;
		
		totalPage =  (int) ( Math.ceil( totalCount_R / (double)bscri.getPerPageNum() ) );
//		totalPage =  ( totalCount / scri.getPerPageNum() ) + 1;
	}
	
	
	public String idxSend(int idx, String name) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("idx", idx)
			.queryParam("name",  encoding(name))
			.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeSearch(int page) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  scri.getPerPageNum())
			.queryParam("searchType",  scri.getSearchType())
			.queryParam( "keyword",  encoding( scri.getKeyword() ) )
			.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeSearch_R(int page) {
	
	UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
		.queryParam("page",  page)
		.queryParam("perPageNum",  bscri.getPerPageNum())
		.queryParam("searchType",  bscri.getSearchType())
		.queryParam( "keyword",  encoding( bscri.getKeyword() ) )
		.build();
	
	return uriComponents.toUriString();
	}
	
	public String idxMakeSearch_R(int page, int idx, String name) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  bscri.getPerPageNum())
			.queryParam("searchType",  bscri.getSearchType())
			.queryParam( "keyword",  encoding( bscri.getKeyword() ) )
			.queryParam("idx", idx)
			.queryParam("name",  encoding(name))
			.build();
		
		return uriComponents.toUriString();
		}

	public String bidxMakeSearch(int page, int bidx) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  scri.getPerPageNum())
			.queryParam("searchType",  scri.getSearchType())
			.queryParam( "keyword",  encoding( scri.getKeyword() ) )
			.queryParam("bidx", bidx)
			.build();
		
		return uriComponents.toUriString();
	}
	
	public String totalMakeSearch(int page) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  scri.getPerPageNum())
			.queryParam("searchType",  scri.getSearchType())
			.queryParam( "keyword",  encoding( scri.getKeyword() ) )
			.queryParam("totalPage",  totalPage)
			.build();
		
		return uriComponents.toUriString();
	}
	
	public String totalMakeSearch_R(int page) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  bscri.getPerPageNum())
			.queryParam("searchType",  bscri.getSearchType())
			.queryParam( "keyword",  encoding( bscri.getKeyword() ) )
			.queryParam("totalPage",  totalPage)
			.build();
		
		return uriComponents.toUriString();
	}
	
	public String bidxTotalMakeSearch(int page, int bidx) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  scri.getPerPageNum())
			.queryParam("searchType",  scri.getSearchType())
			.queryParam( "keyword",  encoding( scri.getKeyword() ) )
			.queryParam("totalPage",  totalPage)
			.queryParam("bidx", bidx)
			.build();
		
		return uriComponents.toUriString();
	}
	
	
	public String bidxTotalMakeSearch_R(int page, int bidx) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  bscri.getPerPageNum())
			.queryParam("searchType",  bscri.getSearchType())
			.queryParam( "keyword",  encoding( bscri.getKeyword() ) )
			.queryParam("totalPage",  totalPage)
			.queryParam("bidx", bidx)
			.build();
		
		return uriComponents.toUriString();
	    }
		
	
	public String idxMakeSearch(int page, int idx, String name) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  scri.getPerPageNum())
			.queryParam("searchType",  scri.getSearchType())
			.queryParam( "keyword",  encoding( scri.getKeyword() ) )
			.queryParam("idx", idx)
			.queryParam("name",  encoding(name))
			.build();
		
		return uriComponents.toUriString();
	}
	
	// ....
	
	public String bidxIdxMakeSearch(int page, int bidx, int idx, String name) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("page",  page)
			.queryParam("perPageNum",  scri.getPerPageNum())
			.queryParam("searchType",  scri.getSearchType())
			.queryParam( "keyword",  encoding( scri.getKeyword() ) )
			.queryParam("bidx", bidx)
			.queryParam("idx", idx)
			.queryParam("name", encoding(name))
			.build();
		
		return uriComponents.toUriString();
	}
	
	// ....

	public String idxTotalMakeSearch(int page, int idx, String name) {
	
	UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
//		 이렇게 바꾸면 페이지도 넘겨줄 필요가 없다.
//		.queryParam("page", scri.getPage())
		.queryParam("page",page)
		.queryParam("perPageNum",  scri.getPerPageNum())
		.queryParam("searchType",  scri.getSearchType())
		.queryParam( "keyword",  encoding( scri.getKeyword() ) )
		.queryParam("totalPage",  totalPage)
		.queryParam("idx", idx)
		.queryParam("name", encoding(name))
		.build();
	
		return uriComponents.toUriString();
	}
	
	public String idxTotalMakeSearch_R(int page, int idx, String name) {
		
	UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
		.queryParam("page",  page)
		.queryParam("perPageNum",  bscri.getPerPageNum())
		.queryParam("searchType",  bscri.getSearchType())
		.queryParam( "keyword",  encoding( bscri.getKeyword() ) )
		.queryParam("totalPage",  totalPage)
		.queryParam("idx", idx)
		.queryParam("name", encoding(name))
		.build();
	
		return uriComponents.toUriString();
	}
	
	public String bidxIdxTotalMakeSearch(int page, int bidx, int idx, String name) {
		
	UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
		.queryParam("page",  page)
		.queryParam("perPageNum",  scri.getPerPageNum())
		.queryParam("searchType",  scri.getSearchType())
		.queryParam( "keyword",  encoding( scri.getKeyword() ) )
		.queryParam("totalPage",  totalPage)
		.queryParam("bidx", bidx)
		.queryParam("idx", idx)
		.queryParam("name", encoding(name))
		.build();
	
	return uriComponents.toUriString();
	}
	
	public String bidxIdxTotalMakeSearch_R(int page, int bidx, int idx, String name) {
		
	UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
		.queryParam("page",  page)
		.queryParam("perPageNum",  bscri.getPerPageNum())
		.queryParam("searchType",  bscri.getSearchType())
		.queryParam( "keyword",  encoding( bscri.getKeyword() ) )
		.queryParam("totalPage",  totalPage)
		.queryParam("bidx", bidx)
		.queryParam("idx", idx)
		.queryParam("name", encoding(name))
		.build();
	
	return uriComponents.toUriString();
	}

	private String encoding (String keyword) {
		
		if (keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public void setScri(SearchCriteria scri) {
		this.scri = scri;
	}
	
	public SearchCriteria getScri() {
		return scri;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public BidxSearchCriteria getBscri() {
		return bscri;
	}

	public void setBscri(BidxSearchCriteria bscri) {
		this.bscri = bscri;
	}	
}

