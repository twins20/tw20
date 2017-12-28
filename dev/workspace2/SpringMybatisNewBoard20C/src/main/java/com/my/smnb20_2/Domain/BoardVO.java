package com.my.smnb20_2.Domain;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service

@Repository
public class BoardVO {
 
	private int bidx = 0;
	private int originbidx = 0;
	private int updown = 0;
	private int leftright = 0;
	private String subject = "";
	private String content = "";
	private String writer = "";
	private String writedate = "";
	private String modifydate = "";	
	private int idx = 0;
	 
	 
	public int getBidx() { 
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public int getOriginbidx() {
		return originbidx;
	}
	public void setOriginbidx(int originbidx) {
		this.originbidx = originbidx;
	}
	public int getUpdown() {
		return updown;
	}
	public void setUpdown(int updown) {
		this.updown = updown;
	}
	public int getLeftright() {
		return leftright;
	}
	public void setLeftright(int leftright) {
		this.leftright = leftright;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
}
