package com.port.service;

import org.springframework.stereotype.Service;

@Service
public class WishVo {
	
	private int rNum;
	private int wIdx;
	private int idx;
	private int pIdx;
	private int itIdx;
	private int viewStat;
	private int insDate;
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getwIdx() {
		return wIdx;
	}
	public void setwIdx(int wIdx) {
		this.wIdx = wIdx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public int getViewStat() {
		return viewStat;
	}
	public void setViewStat(int viewStat) {
		this.viewStat = viewStat;
	}
	public int getInsDate() {
		return insDate;
	}
	public void setInsDate(int insDate) {
		this.insDate = insDate;
	}
	
}
