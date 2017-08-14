package com.port.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.port.service.MemberServiceImpl;
import com.port.service.MemberVo;



/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
/*	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
*/

	@Autowired
	private MemberVo mv;
	@Autowired
	private MemberServiceImpl mi;
	
	@RequestMapping(value = "/MemberLogIn.do")
	public String MemberLogIn(HttpServletRequest request, HttpServletResponse response) {

		return "member/MemberLogIn";
	}
	
	@RequestMapping(value = "/MemberJoin.do")
	public String MemberJoin() {
	
		return "member/MemberJoin";
	}
	
	@RequestMapping(value = "/MemberLogIn_Action.do")
	public String MemberLogIn_Action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String answer = null;
		
		String id = null, pw = null;
		if(request.getParameter("id") != null){
			id = request.getParameter("id").trim();
		}
		if(request.getParameter("pw") != null){
			pw = request.getParameter("pw").trim();
		}
		
		mv.setId(id);
		mv.setPw(pw);
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		data = mi.memberLogIn(mv);

		if(data != null){
			
			HttpSession session = request.getSession();
					
			session.setAttribute("idx", data.get("IDX"));
			session.setAttribute("id", data.get("ID"));
			session.setAttribute("nick", data.get("NICK"));
			session.setAttribute("status", data.get("STATUS"));
			session.setAttribute("type", data.get("TYPE"));
			
			answer = "redirect:/index.do";
				
		}else if(data == null){
			
			answer = "redirect:/MemberLogIn.do";
		}
		
		return answer;
	}
	
	@RequestMapping(value = "/MemberLogOut_Action.do")
	public String MemberLogOut_Action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/index.do";
	}
	
	@RequestMapping(value = "/MemberJoin_Action.do")
	public String MemberJoin_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int phone = 0, status = 1;
		String id = null, pw = null, name = null, nick = null, addr = null, type = null;
		int row = 0;
		
		if(request.getParameter("id") != null){
			id = request.getParameter("id").trim();
		}
		if(request.getParameter("pw") != null){
			pw = request.getParameter("pw").trim();
		}
		if(request.getParameter("name") != null){
			name = request.getParameter("name").trim();
		}
		if(request.getParameter("nick") != null){
			nick = request.getParameter("nick").trim();
		}
		if(request.getParameter("phone") != null){
			phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		}
		if(request.getParameter("addr") != null){
			addr = request.getParameter("addr").trim();
		}
		if(request.getParameter("status") != null){
			status = Integer.parseInt(request.getParameter("status").trim(),10);
		}
		if(request.getParameter("type") != null){
			type = request.getParameter("type").trim();
		}
				
		mv.setId(id);
		mv.setPw(pw);
		mv.setName(name);
		mv.setNick(nick);
		mv.setPhone(phone);
		mv.setAddr(addr);
		mv.setStatus(status);
		mv.setType(type);
		
		row = mi.memberJoin(mv);
		
		return "redirect:/index.do";
	}
	
	@RequestMapping(value = "/MemberFindMail.do")
	public String MemberFindMail(HttpServletRequest request, HttpServletResponse response) {

		return "member/MemberFindMail";
	}
	
	@RequestMapping(value = "/MemberFindMail_Action.do")
	public String MemberFindMail_Action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String answer = null;
		
		int phone = 0;
		String name = null;
		
		if(request.getParameter("name") != null){
			name = request.getParameter("name").trim();
		}
		if(request.getParameter("phone") != null){
			phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		}
				
		mv.setName(name);
		mv.setPhone(phone);
		
		MemberVo vo = new MemberVo();
	
		vo = mi.memberFindMail(mv);
		
		request.setAttribute("vo", vo);

		if(vo == null){
			
			answer = "member/MemberFindMail";
			
		} else {
			
			answer = "member/MemberFindMail_View";
		}
		
		return answer;
	}
	
	@RequestMapping(value = "/MemberFindPass.do")
	public String MemberFindPass(HttpServletRequest request, HttpServletResponse response) {
		
		return "member/MemberFindPass";
	}
	
	@RequestMapping(value = "/MemberFindPass_Action.do")
	public String MemberFindPass_Action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String answer = null;
		
		int phone = 0;
		String id = null, name = null;
		
		if(request.getParameter("id") != null){
			id = request.getParameter("id").trim();
		}
		if(request.getParameter("name") != null){
			name = request.getParameter("name").trim();
		}
		if(request.getParameter("phone") != null){
			phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		}
		
		mv.setId(id);
		mv.setName(name);
		mv.setPhone(phone);
						
		MemberVo vo = new MemberVo();
		
		vo = mi.memberFindPass(mv);
		
		request.setAttribute("vo", vo);
		
		if(vo == null){
		
			answer = "/member/MemberFindPass";
		
		} else {
			
			answer = "/member/MemberFindPass_View";
		}
		
		return answer; 
	}

}
