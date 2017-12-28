package com.my.smnb20_2.Domain;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository
public class Criteria {

	private int page;
	private int perPageNum;
	
	public Criteria(){
		
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		if(page<=0){
			this.page = 1;
			return;
		}
		this.page = page;
	}

	// method for MyBatis SQL Mapper
	public int getPerPageNum() {
		return this.perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		if (perPageNum <=0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	// method for MyBatis SQL Mapper
	public int getPageStart() {
		int startPage = ( (this.page - 1) * perPageNum ) + 1;
		return startPage; 
	}
	
	public int getPageEnd() {
		return this.page * perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page="+page+","+"perPageNum="+perPageNum+"]"; 
	}
}
