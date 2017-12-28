package com.my.smnb20_2.Domain;


public class SearchCriteria extends Criteria{
	
	private int bidx;
	private String searchType;
	private String keyword;
	
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchCriteria [bidx=" + bidx + ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}
