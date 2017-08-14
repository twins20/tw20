package com.port.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.port.service.ItemVo;
import com.port.service.MemberVo;
import com.port.service.ProjectCommVo;
import com.port.service.ProjectServiceImpl;
import com.port.service.ProjectVo;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ProjectController {
/*
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
*/
	@Autowired(required=false)
	private MemberVo mv;
	@Autowired(required=false)
	private ProjectVo pv;
	@Autowired(required=false)
	private ItemVo iv;
	@Autowired(required=false)
	private ProjectServiceImpl pi;
	
	@RequestMapping(value = "/ProjectListByCate.do")
	public String ProjectListByCate(HttpServletRequest request, HttpServletResponse response) {
		
		String pCate = null;
		if(request.getParameter("pCate") != null){
			pCate = request.getParameter("pCate").trim();
		}
		 
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		
		plist = pi.projListByCate(pCate);
		
		request.setAttribute("plist", plist);
		
		return "project/ProjectListByCate";
	}

	@RequestMapping(value = "/ProjectListByPower.do")
	public String ProjectListByPower(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		plist = pi.projListByPower();
		
		request.setAttribute("plist", plist);
		
		return "project/ProjectListByPower";
	}

	@RequestMapping(value = "/ProjectListByTech.do")
	public String ProjectListByTech(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		plist = pi.projListByTech();
		
		request.setAttribute("plist", plist);
	
		return "project/ProjectListByPower";
	}

	@RequestMapping(value = "/ProjectCon.do")
	public String ProjectCon(HttpServletRequest request, HttpServletResponse response) {
		
		int pIdx = 0;
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx"));
		}
		
		ArrayList<ItemVo> itemList = new ArrayList<ItemVo>();
//		ArrayList<ProjectCommVo> pclist = new ArrayList<ProjectCommVo>();
		
		pv = pi.projCon(pIdx);
		itemList = pi.projConItemList(pIdx);
//		mv = pi.projConCmem(pIdx);
//		pclist = pi.projConCommList(pIdx);
		
		request.setAttribute("pv", pv);
		request.setAttribute("itemList", itemList);
//		request.setAttribute("mv", mv);
//		request.setAttribute("pclist", pclist);
		
		return "project/ProjectCon";
	}

	@RequestMapping(value = "/ProjectPay.do")
	public String ProjectPay(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int pIdx = 0, itIdx = 0;
		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("itIdx") != null){
			itIdx = Integer.parseInt(request.getParameter("itIdx").trim());
		}
		System.out.println(itIdx);
		Map<String, Object> data = new HashMap<String, Object>();
		
		data = pi.projPayMyMoney(sess_idx);
		pv = pi.projCon(pIdx);
		iv = pi.projPayItem(itIdx);
		
		request.setAttribute("data", data);
		request.setAttribute("pv", pv);
		request.setAttribute("iv", iv);
		
		return "project/ProjectPay";
	}
/*	
	@RequestMapping(value = "/ProjectPay_Action.do")
	public String ProjectPay_Action(HttpServletRequest request, HttpServletResponse response) {
		
		String name = null, email = null, addr = null, message = null;
		int pIdx = 0, itIdx = 0, param_idx = 0, phone = 0, inFunds = 0;
		int row = 0;
		
		if(request.getParameter("name") != null){
			name = (String)request.getParameter("name");
		}
		if(request.getParameter("email") != null){
			email = (String)request.getParameter("email");
		}
		if(request.getParameter("addr") != null){
			addr = (String)request.getParameter("addr");
		}
		if(request.getParameter("message") != null){
			message = (String)request.getParameter("message");
		}
		if(request.getParameter("phone") != null){
			phone = Integer.parseInt(request.getParameter("phone").trim(),20);
		}
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("itIdx") != null){
			itIdx = Integer.parseInt(request.getParameter("itIdx").trim(),10);
		}
		if(request.getParameter("idx") != null){
			param_idx = Integer.parseInt(request.getParameter("idx").trim(),10);
		}
		if(request.getParameter("inFunds") != null){
			inFunds = Integer.parseInt(request.getParameter("inFunds").trim(),10);
		}
		
		ov.setName(name);
		ov.setId(email);
		ov.setAddr(addr);
		ov.setMessage(message);
		ov.setPhone(phone);
		
		fv.setpIdx(pIdx);
		fv.setItIdx(itIdx);
		fv.setIdx(param_idx);
		fv.setInFunds(inFunds);
		
		request.setAttribute("ov", ov);
		request.setAttribute("fv", fv);
		
		row += pi.projPayTransaction(fv);
	
		return "/project/ProjectPaySuccess";
	}
	
	@RequestMapping(value = "/ProjectConCommWrite_Action.do")
	public ModelAndView ProjectConCommWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int pIdx = 0;
		String comments = null;
		int row = 0;
		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("comments") != null){
			comments = request.getParameter("comments").trim();
		}
			
		pcv.setpIdx(pIdx);
		pcv.setIdx(sess_idx);
		pcv.setComments(comments);
		
		row = pi.projConCommWrite(pcv);

		return new ModelAndView("redirect:/ProjectCon?pIdx="+pIdx+"");
	}
	
	@RequestMapping(value = "/ProjectConSubCommWrite_Action.do")
	public ModelAndView ProjectConSubCommWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer)session.getAttribute("idx");
		}
		
		int pIdx = 0, opCommIdx = 0;
		String comments = null;
		int row = 0;
		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("opCommIdx") != null){
			opCommIdx = Integer.parseInt(request.getParameter("opCommIdx").trim(),10);
		}
		
		pcv.setpIdx(pIdx);
		pcv.setIdx(sess_idx);
		pcv.setComments(comments);
		pcv.setOpCommIdx(opCommIdx);
		
		//트랜잭션 사용
		row = pi.projConSubCommWriteTransaction(pcv);
		
		//트랜잭션 미사용				
//		row = ps.projConSubCommWriteUpdate(inputPV);
//		if(row != 0) row += ps.projConSubCommWriteInsert(inputPV);

		return new ModelAndView("redirect:/ProjectCon?pIdx"+pIdx+"");
	}
*/	
}
