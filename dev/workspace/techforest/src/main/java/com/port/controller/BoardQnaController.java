package com.port.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.port.service.BoardQnaServiceImpl;
import com.port.service.BoardVo;



@Controller
public class BoardQnaController {
	
	@Autowired
	private BoardQnaServiceImpl bs;
	@Autowired
	private BoardVo vo;
	
	@RequestMapping(value = "/QnaList.do")
	public String QnaList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null ){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}	
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		alist = bs.boardQnaList(sess_idx); 		
		request.setAttribute("alist", alist);
			
		return "boardQna/QnaList";
	}
		
	@RequestMapping(value = "/QnaCon.do")
	public String QnaCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		} 		
	
		vo = bs.boardQnaCon(bIdx);
		request.setAttribute("vo", vo);
		

		return "boardQna/QnaCon";
	}
	
	@RequestMapping(value = "/QnaWrite.do")
	public String QnaWrite(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null ) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		return "boardQna/QnaWrite";
	}
	
	@RequestMapping(value = "/QnaWrite_Action.do")
	public String QnaWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		String cate = null, title = null, contents = null, imgfile = null;
		int row = 0; 
			
		if(request.getParameter("cate") != null) {
			cate = request.getParameter("cate").trim();  
		}
		if(request.getParameter("title") != null) {
			title = request.getParameter("title").trim(); 
		}
		if(request.getParameter("contents") != null) {
			contents = request.getParameter("contents").trim();  
		}
		if(request.getParameter("imgfile") != null) {
			imgfile = request.getParameter("imgfile").trim();
		}

	    vo.setIdx(sess_idx);
	    vo.setCate(cate);
	    vo.setTitle(title);
	    vo.setContents(contents);
	    
	    row = bs.boardQnaWrite(vo); 
						
			
		return "redirect:/QnaList.do";
	}
	
	@RequestMapping(value = "/QnaMod.do")
	public String QnaMod(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		int bIdx =0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}

		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx").trim());
		}
		
		vo = bs.boardQnaCon(bIdx);
		
		request.setAttribute("sess_idx", sess_idx);
		request.setAttribute("vo", vo);
		
		return "boardQna/QnaMod";
	}
	
	@RequestMapping(value = "/QnaMod_Action.do")
	public String QnaMod_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		int bIdx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}	
		
		String Title = null, Contents = null;
		int row = 0;
		
		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx").trim());
		}
		if(request.getParameter("title") != null) {
			Title = request.getParameter("title").trim();
		}
		if(request.getParameter("contents") != null) {
			Contents = request.getParameter("contents").trim();
		}

		vo.setTitle(Title);
		vo.setContents(Contents);	
		vo.setbIdx(bIdx);		
				
		row = bs.boardQnaMod(vo);

		return "redirect:/QnaList.do";
	}
	
	@RequestMapping(value = "/QnaDel_Action.do")
	public String QnaDel_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int bIdx = 0;
		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx"));
		}
		
		bs.boardQnaDel(bIdx); 
		
		return "redirect:/QnaList.do";
	}

	
/*
	@RequestMapping(value = "/QnaConGoodBad_Action.do")
	public ModelAndView QnaConGoodBad_Action(HttpServletRequest request, HttpServletResponse response) {
		
		String answer = null;
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = (Integer) session.getAttribute("idx");	
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}

		String GoodBad = null;
		if(request.getParameter("goodbad") != null) {
			GoodBad = request.getParameter("goodbad");
		}
	
		int row = 0;
		
		if(GoodBad.equals("up")){
			row = bi.boardNoticeBad(bIdx);
			if(row == 1){
				answer = new ModelAndView("redirect:/NoticeCon.do?bIdx="+bIdx+"");
			}
		
		}else if(GoodBad.equals("down")){
			row = bi.boardNoticeGood(bIdx);
			if(row == 1){
				answer = new ModelAndView("redirect:/NoticeCon.do?bIdx="+bIdx+"");
				
		return answer;
	}
*/
}
