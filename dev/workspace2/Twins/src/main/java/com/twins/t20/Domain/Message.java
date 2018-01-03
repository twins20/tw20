package com.twins.t20.Domain;

public class Message {

	private String name;
	private String msg;
	private String rds;
	private String isUpdate;
	private String isReply;
	private String isDelete;
	private String isWright;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRds() {
		return rds;
	}
	public void setRds(String rds) {
		this.rds = rds;
	}
	public String getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
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
	public String getIsWright() {
		return isWright;
	}
	public void setIsWright(String isWright) {
		this.isWright = isWright;
	}
	@Override
	public String toString() {
		return "Message [name=" + name + ", msg=" + msg + ", rds=" + rds + ", isUpdate=" + isUpdate + ", isReply="
				+ isReply + ", isDelete=" + isDelete + ", isWright=" + isWright + "]";
	}
}
