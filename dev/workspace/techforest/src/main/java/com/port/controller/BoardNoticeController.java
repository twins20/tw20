package com.port.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.port.service.BoardNoticeServiceImpl;
import com.port.service.BoardVo;


@Controller
public class BoardNoticeController {

	@Autowired
	private BoardVo bv;
	@Autowired
	private BoardNoticeServiceImpl bs;
	
	
	@RequestMapping(value = "/NoticeList.do")
	public String NoticeList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
    	ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
    	alist = bs.boardNoticeList();
    	System.out.println(alist);    	
    	request.setAttribute("alist", alist);	
    	   	
		return "boardNotice/NoticeList";
	}
		
	@RequestMapping(value = "/NoticeCon.do")
	public String NoticeCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
    	
    	int bIdx = 0;
    	
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		bv = bs.boardNoticeCon(bIdx);
		request.setAttribute("bv", bv);
		
		
		return "boardNotice/NoticeCon";
	}	

}
