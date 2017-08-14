package com.port.service;

import org.springframework.stereotype.Service;

@Service
public class MoneyVo {
	
	private int rNum;
	private int mIdx;
	private int idx;
	private String contents;
	private int chgMoney;
	private int bMoney;
	private int aMoney;
	private int status;
	private int type;
	private String insDate;
	private String modDate;
	private String chkAdmin;
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getmIdx() {
		return mIdx;
	}
	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getChgMoney() {
		return chgMoney;
	}
	public void setChgMoney(int chgMoney) {
		this.chgMoney = chgMoney;
	}
	public int getbMoney() {
		return bMoney;
	}
	public void setbMoney(int bMoney) {
		this.bMoney = bMoney;
	}
	public int getaMoney() {
		return aMoney;
	}
	public void setaMoney(int aMoney) {
		this.aMoney = aMoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getInsDate() {
		return insDate;
	}
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public String getChkAdmin() {
		return chkAdmin;
	}
	public void setChkAdmin(String chkAdmin) {
		this.chkAdmin = chkAdmin;
	}
		
}
