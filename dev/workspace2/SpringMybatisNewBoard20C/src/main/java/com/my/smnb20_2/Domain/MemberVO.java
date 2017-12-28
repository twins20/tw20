package com.my.smnb20_2.Domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class MemberVO {

	private String id;
	private String password;
	private int idx;
	private String name = "";
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String sendLoginInfo(int idx, String name) {
		
		UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
			.queryParam("idx",  idx)
			.queryParam("name",  encoding(name))
			.build();
		
		return uriComponents.toUriString();
	}
	
	private String encoding (String name) {
		
		if (name == null || name.trim().length() == 0) {
			return "";
		}
		
		try {
			return URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
