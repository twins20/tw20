package com.my.smnb20_2.Domain.copy;

public class Message {
	
	String rrds = "";
	String isWright = "";
	String isReply = "";
	String isDelete = "";
	String isUpdate = "";
	String msg = "";
	
	public String getRrds() {
		return rrds;
	}
	public void setRrds(String rrds) {
		this.rrds = rrds;
	}
	public String getIsWright() {
		return isWright;
	}
	public void setIsWright(String isWright) {
		this.isWright = isWright;
	}
	public String getIsReply() {
		return isReply;
	}
	public void setIsReply(String isReply) {
		this.isReply = isReply;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	public String getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
