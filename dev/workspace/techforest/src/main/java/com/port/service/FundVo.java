package com.port.service;

import org.springframework.stereotype.Service;

@Service
public class FundVo {
	
	private int rNum;
	private int fIdx;
	private int pIdx;
	private int itIdx;
	private int idx;
	private int inFunds;
	private int bFunds;
	private int aFunds;
	private int status;
	private String insDate;
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getfIdx() {
		return fIdx;
	}
	public void setfIdx(int fIdx) {
		this.fIdx = fIdx;
	}
	public int getpIdx() {
		return pIdx;
	}
	public void setpIdx(int pIdx) {
		this.pIdx = pIdx;
	}
	public int getItIdx() {
		return itIdx;
	}
	public void setItIdx(int itIdx) {
		this.itIdx = itIdx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getInFunds() {
		return inFunds;
	}
	public void setInFunds(int inFunds) {
		this.inFunds = inFunds;
	}
	public int getbFunds() {
		return bFunds;
	}
	public void setbFunds(int bFunds) {
		this.bFunds = bFunds;
	}
	public int getaFunds() {
		return aFunds;
	}
	public void setaFunds(int aFunds) {
		this.aFunds = aFunds;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInsDate() {
		return insDate;
	}
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}
	
}
