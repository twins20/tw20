package com.port.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.port.service.BoardVo;
import com.port.service.CMemberServiceImpl;
import com.port.service.MemberVo;
import com.port.service.ProjectVo;

/**
 * Handles requests for the application home page.
 */

@Controller
public class CMemberController {
	
	@Autowired(required=false)
	private MemberVo mv;
	@Autowired(required=false)
	private ProjectVo pv;
	@Autowired(required=false)
	private BoardVo bv;
	@Autowired(required=false)
	private CMemberServiceImpl ci;
	
/*	
	private static final Logger logger = LoggerFactory.getLogger(CMemberController.class);
*/
	@RequestMapping(value = "/CMemberIndexP.do")
	public String CMemberIndexP(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		System.out.println(sess_idx);
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>();
		
		pv = ci.cMemberIndexProjNowList(sess_idx);
		dataList = ci.cMemberIndexCommList(sess_idx);
		
		request.setAttribute("pv", pv);
		request.setAttribute("dataList", dataList);
		request.setAttribute("blist", blist);
		
		return "cmember/CMemberIndexP";
	}
	
	@RequestMapping(value = "/CMemberInfoExtWrite.do")
	public String CMemberInfoExtWrite(HttpServletRequest request, HttpServletResponse response) {
		
		return "cmember/CMemberInfoExtWrite";
	}
	
	@RequestMapping(value = "/CMemberInfoExtWrite_Action.do")
	public String CMemberInfoExtWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		String answer = null;
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		String company = null, cNumber = null, cAddr = null;
				
		if(request.getParameter("company") != null){
			company = request.getParameter("company").trim();
		}
		if(request.getParameter("cNumber") != null){
			cNumber = request.getParameter("cNumber").trim();
		}
		if(request.getParameter("cAddr") != null){
			cAddr = request.getParameter("cAddr").trim();
		}
		
		mv.setIdx(sess_idx);
		mv.setCompany(company);
		mv.setcNumber(cNumber);
		mv.setcAddr(cAddr);
		
		int row = 0;
		
		row = ci.cMemberInfoExtWriteChk(sess_idx);
		
		System.out.println(row);
		if(row == 0){
			
			row += ci.cMemberInfoExtWrite(sess_idx, mv);

			answer = "redirect:/CMemberInfoCon.do";
		
		}else{
			
			answer = "redirect:/CMemberInfoCon.do";
		}
		
		return answer;
	}
		
	@RequestMapping(value = "/CMemberInfoCon.do")
	public String CMemberInfoCon(ModelMap modelMap, Map<String, Object> model, HttpServletRequest request) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data = ci.cMemberInfoCon(sess_idx);
		
		modelMap.addAttribute("data", data);
		
		return "cmember/CMemberInfoCon";
	}

	@RequestMapping(value = "/CMemberInfoMod.do")
	public String CMemberInfoMod(ModelMap modelMap, HttpServletRequest request) {
		
		String answer = null;
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}

		String pw = null;
		if(request.getParameter("pw") != null){
			pw = request.getParameter("pw").trim();
		}
		
		mv.setIdx(sess_idx);
		mv.setPw(pw);
		
		int row = 0;	
		row = ci.cMemberInfoModChk(mv);
		
		if(row == 0){ 

			answer = "redirect:/CMemberInfoCon.do";
			
		}else{
			
			Map<String, Object> data = new HashMap<String, Object>();
			data = ci.cMemberInfoCon(sess_idx);
			
			modelMap.addAttribute("data", data);
			
			answer = "cmember/CMemberInfoMod";
			
		}
		
		return answer;
	}

	@RequestMapping(value = "/CMemberInfoMod_Action.do")
	public String CMemberInfoMod_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int phone = 0;
		String pw = null, nick = null, addr = null;
				
		if(request.getParameter("pw") != null){
			pw = request.getParameter("pw").trim();
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
				
		mv.setIdx(sess_idx);
		mv.setPw(pw);
		mv.setNick(nick);
		mv.setPhone(phone);
		mv.setAddr(addr);
		
		int row = 0;
		System.out.println(row);
		row = ci.cMemberInfoMod(mv);
		
		return "redirect:/CMemberInfoCon.do";
	}

	@RequestMapping(value = "/CMemberProjNowList.do")
	public String CMemberProjNowList(ModelMap modelMap, HttpServletRequest request) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}

		pv = ci.cMemberProjNowList(sess_idx);
		modelMap.addAttribute("pv", pv);
		
		return "cmember/CMemberProjNowList";
	}
	
	@RequestMapping(value = "/CMemberProjHisList.do")
	public String CMemberProjHisList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		System.out.println("sessidx:"+sess_idx);
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		plist = ci.cMemberProjHisList(sess_idx);
		
		request.setAttribute("plist", plist);
		
		return "cmember/CMemberProjHisList";
	}
	
		
/*
	@RequestMapping(value = "/CMemberMemoWrite_Action.do")
	public ModelAndView CMemberMemoWrite_Action(HttpServletRequest request, HttpServletResponse response) {

		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int param_idx = 0;
		int sendIdx = sess_idx, recvIdx = param_idx;
		String contents = null;
		
		if(request.getParameter("param_idx") != null){
			param_idx = Integer.parseInt(request.getParameter("param_idx"));
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}

		mev.setSendIdx(sendIdx);
		mev.setRecvIdx(recvIdx);
		mev.setContents(contents);
				
		int row = 0;
		
		row = ci.cMemMemoWrite(mev);
		
		return new ModelAndView("redirect/CMemberMemoSendList.do");
	}

	@RequestMapping(value = "/CMemberProjApplyWrite.do")
	public String CMemberProjApplyWrite(HttpServletRequest request, HttpServletResponse response) {
	
		return "/cmember/CMemberProjApplyWrite";
	}
	
	@RequestMapping(value = "/CMemberProjApplyWrite_Action.do")
	public ModelAndView CMemberProjApplyWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int itListCnt = 0, ptFunds = 0, pGrade = 0;
		String pName = null, pCate = null, contents = null;
		
		if(request.getParameter("pName") != null){
			pName = request.getParameter("pName").trim();
		}
		if(request.getParameter("pCate") != null){
			pCate = request.getParameter("pCate").trim();
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}
		if(request.getParameter("itListCnt") != null){
			itListCnt = Integer.parseInt(request.getParameter("itListCnt").trim(),10);
		}
		if(request.getParameter("ptFunds") != null){
			ptFunds = Integer.parseInt(request.getParameter("ptFunds").trim(),10);
		}
		if(request.getParameter("pGrade") != null){
			pGrade = Integer.parseInt(request.getParameter("pGrade").trim(),10);
		}
		
		System.out.println("pName:"+pName);
		System.out.println("pCate:"+pCate);
		System.out.println("contents:"+contents);
		System.out.println("itListCnt:"+itListCnt);
		System.out.println("ptFunds:"+ptFunds);
		System.out.println("pGrade:"+pGrade);
	
		//테스트 변수입력 시작

//		itListCnt = 20;
		
		//테스트 변수입력 끝
		
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			itListArray[itCnt] = new ItemVo();
			
			if(request.getParameter("itList"+itCnt+"_itName") != null){
				itListArray[itCnt].setItName(request.getParameter("itLIst"+itCnt+"_itName").trim());
			}		
			if(request.getParameter("itList"+itCnt+"_itPrice") != null){
				itListArray[itCnt].setItPrice(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itPrice").trim(),10));
			}		
			if(request.getParameter("itList"+itCnt+"_contents") != null){
				itListArray[itCnt].setContents(request.getParameter("itLIst"+itCnt+"_contents").trim());
			}	
			if(request.getParameter("itList"+itCnt+"_itTCnt") != null){
				itListArray[itCnt].setItTCnt(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itTCnt").trim(),10));
			}
//			System.out.println("getItName:"+itListArray[itCnt].getItName());
//			System.out.println("getItPrice:"+itListArray[itCnt].getItPrice());
//			System.out.println("getContents:"+itListArray[itCnt].getContents());
//			System.out.println("getItTCnt:"+itListArray[itCnt].getItTCnt());
		}
		
		//테스트 변수입력 시작
		
//		idx = 2;
//		pName = "프로젝트 입력 테스트 이름";
//		pCate = "CATE";
//		contents = "프로젝트 입력 테스트 컨텐츠";
//		
//		ptFunds = 1000000;
//		pGrade = 5;
//		for(int testCnt = 0; testCnt < itListCnt; testCnt++){
//			itListArray[testCnt].setItName("테스트 아이템 ");
//			itListArray[testCnt].setItPrice(10000 * testCnt);
//			itListArray[testCnt].setContents("테스트 아이템 컨텐츠");
//			itListArray[testCnt].setItTCnt(100 * testCnt);
//		}
		
		//테스트 변수입력 끝	
		
		pv.setIdx(sess_idx);
		pv.setpName(pName);
		pv.setpCate(pCate);
		pv.setContents(contents);
		pv.setItListCnt(itListCnt);
		pv.setPtFunds(ptFunds);
		pv.setpGrade(pGrade);
		
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			data.put("itList"+itCnt, itListArray[itCnt]);	
		}
	
		int row = 0;
		
		row = ci.cMemProjApplyWriteTransaction(pv, data); //트랜잭션 적용
//		row = cs.cMemProjApplyWrite(inputPV, itData);
		
//		System.out.println(row);
		
		return new ModelAndView("redirect:/CMemberProjNowList.do");
	}
	
	@RequestMapping(value = "/CMemberProjApplyCon.do")
	public String CMemberProjApplyCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}

		pv = ci.cMemProjApplyConProj(sess_idx);
		ilist = ci.cMemProjApplyConItem(pv.getpIdx());
		
		request.setAttribute("pv", pv);
		request.setAttribute("ilist", ilist);
		
//		vo = (ProjectVo) request.getAttribute("vo"); 
//	
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getpName());
//		System.out.println(vo.getpCate());
//		System.out.println(vo.getContents());
//		System.out.println(vo.getItList());
//		System.out.println(vo.getItListCnt());
//		System.out.println(vo.getPtFunds());
//		System.out.println(vo.getPeDate());
//		System.out.println(vo.getPcDate());
//
//		alist = (ArrayList<ItemVo>) request.getAttribute("alist"); 
//		
//		for(ItemVo itVo : alist){
//			System.out.println(itVo.getItIdx());
//			System.out.println(itVo.getItName());
//			System.out.println(itVo.getItPrice());
//			System.out.println(itVo.getContents());
//			System.out.println(itVo.getItTCnt());
//		}
	
		return "/CMemberProjApplyCon";
	}
	
	@RequestMapping(value = "/CMemberProjApplyItemPlus.do")
	public String CMemberProjApplyItemPlus(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		pv = ci.cMemProjApplyItemPlusConProj(sess_idx);
		ilist = ci.cMemProjApplyItemPlusConItem(pv.getpIdx());
		
		request.setAttribute("pv", pv);
		request.setAttribute("ilist", ilist);
		
//		vo = (ProjectVo) request.getAttribute("vo"); 
//	
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getpName());
//		System.out.println(vo.getpCate());
//		System.out.println(vo.getContents());
//		System.out.println(vo.getItList());
//		System.out.println(vo.getItListCnt());
//		System.out.println(vo.getPtFunds());
//		System.out.println(vo.getPeDate());
//		System.out.println(vo.getPcDate());
//
//		alist = (ArrayList<ItemVo>) request.getAttribute("alist"); 
//		
//		for(ItemVo itVo : alist){
//			System.out.println(itVo.getItIdx());
//			System.out.println(itVo.getItName());
//			System.out.println(itVo.getItPrice());
//			System.out.println(itVo.getContents());
//			System.out.println(itVo.getItTCnt());
//		}
		
		return "/cmember/CMemberProjApplyItemPlus";
	}
	
	@RequestMapping(value = "/CMemberProjApplyItemPlus_Action.do")
	public String CMemberProjApplyItemPlus_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int pIdx = 0, itListCnt = 0;
			
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("itListCnt") != null){
			itListCnt = Integer.parseInt(request.getParameter("itListCnt").trim(),10);
		}
				
		//테스트 변수입력 시작

//		pIdx = 1;
//		itListCnt = 20;
		
		//테스트 변수입력 끝
		
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			
			if(request.getParameter("itList"+itCnt+"_itName") != null){
				iv.setItName(request.getParameter("itLIst"+itCnt+"_itName").trim());
			}
			if(request.getParameter("itList"+itCnt+"_itPrice") != null){
				iv.setItPrice(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itPrice").trim(),10));
			}
			if(request.getParameter("itList"+itCnt+"_contents") != null){
				iv.setContents(request.getParameter("itLIst"+itCnt+"_contents").trim());
			}
			if(request.getParameter("itList"+itCnt+"_itTCnt") != null){
				iv.setItTCnt(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itTCnt").trim(),10));
			}
			
			ilist.add(iv);
		}
		
		//테스트 변수입력 시작 테스트시 getParameter - 객체생성 부분을 주석처리 해줘야함
		
//		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
//			ItemVo inputIV = new ItemVo();
//			
//			inputIV.setItName("itemText " + itCnt);
//			inputIV.setItPrice(10000 * itCnt); 
//			inputIV.setContents("itemCon " + itCnt);
//			inputIV.setItTCnt(100 * itCnt);
//			
//			alist.add(inputIV);
//		}
		
		//테스트 변수입력 끝
		
		int row = 0;
		
		row = ci.cMemProjApplyItemPlus(pIdx, ilist);
		
//		System.out.println(row);
		
		return "/cmember/CMemberProjApplyCon";
	}
	

*/
}
