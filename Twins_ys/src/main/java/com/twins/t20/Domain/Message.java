package com.twins.t20.Domain;

public class Message {

	private String name;
	private String msg;
	
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
	
	@Override
	public String toString() {
		return "Message [name=" + name + ", msg=" + msg + "]";
	}
}
