package com.my.smnb20_2.Domain;

public class CheckLineVO {

	private String subject;
	private String author;
	
	public CheckLineVO(String subject, String author){
		super();
		this.subject = subject;
		this.author = author;
	}
	
	@Override
	public String toString(){
		return "CheckLineVO [subject="+subject+",author="+author+"]";
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
