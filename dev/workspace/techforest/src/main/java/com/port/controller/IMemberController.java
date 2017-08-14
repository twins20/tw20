package com.port.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.port.common.PagingHelper;
import com.port.service.BoardVo;
import com.port.service.IMemberService;
import com.port.service.IMemberServiceImpl;
import com.port.service.MemberVo;
import com.port.service.MoneyVo;
import com.port.service.ProjectVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IMemberController {
	
	@Autowired(required=false)
	private MemberVo mv;
	@Autowired(required=false)
	private MoneyVo mov;
	@Autowired(required=false)
	private IMemberService is;
	@Autowired(required=false)
	private IMemberServiceImpl ii;
	
/*		
	private static final Logger logger = LoggerFactory.getLogger(IMemberController.class);
*/
	@RequestMapping(value = "/IMemberIndexP.do")
	public String IMemberIndexP(ModelMap modelMap, HttpServletRequest request, Integer curPage) {
	
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}

		if(curPage == null){
			curPage = 1;
		}
		
		int numPerPage = 10; //한 페이지당 게시물 수
		int pagePerBlock = 10; //한 블럭당 페이지 수 
		
 		int totalRecord = ii.iMemberProjectListTc(sess_idx); 	//총 게시물 수
		
		PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);
		is.setPagingHelper(pagingHelper);
		
		int start = pagingHelper.getStartRecord();
		int end = pagingHelper.getEndRecord();
		
		Integer no = is.getListNo();
		Integer prevLink = is.getPrevLink();
		Integer nextLink = is.getNextLink();
		Integer firstPage = is.getFirstPage();
		Integer lastPage = is.getLastPage();
		int[] pageLinks = is.getPageLinks();
		
		modelMap.addAttribute("no", no);
		modelMap.addAttribute("prevLink", prevLink);
		modelMap.addAttribute("nextLink", nextLink);
		modelMap.addAttribute("firstPage", firstPage);
		modelMap.addAttribute("lastPage", lastPage);
		modelMap.addAttribute("pageLinks", pageLinks);
		modelMap.addAttribute("curPage", curPage);
		
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

		dataList = ii.iMemberProjectList(sess_idx, start, end);
		
		modelMap.addAttribute("dataList", dataList);
		
		return "imember/IMemberIndexP";
	}
	
	@RequestMapping(value = "/IMemberQnaList.do")
	public String IMemberQnaLIst(ModelMap modelMap, HttpServletRequest request, Integer curPage){
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		if(curPage == null){
			curPage = 1;
		}
		
		int numPerPage = 10; //한 페이지당 게시물 수
		int pagePerBlock = 10; //한 블럭당 페이지 수 
		
 		int totalRecord = ii.iMemberQnaListTc(sess_idx); 	//총 게시물 수
		
		PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);
		is.setPagingHelper(pagingHelper);
		
		int start = pagingHelper.getStartRecord();
		int end = pagingHelper.getEndRecord();
		
		Integer no = is.getListNo();
		Integer prevLink = is.getPrevLink();
		Integer nextLink = is.getNextLink();
		Integer firstPage = is.getFirstPage();
		Integer lastPage = is.getLastPage();
		int[] pageLinks = is.getPageLinks();
		
		modelMap.addAttribute("no", no);
		modelMap.addAttribute("prevLink", prevLink);
		modelMap.addAttribute("nextLink", nextLink);
		modelMap.addAttribute("firstPage", firstPage);
		modelMap.addAttribute("lastPage", lastPage);
		modelMap.addAttribute("pageLinks", pageLinks);
		modelMap.addAttribute("curPage", curPage);
		
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>();
		blist = ii.iMemberQnaList(sess_idx, start, end);
		
		modelMap.addAttribute("blist", blist);
		
		return "imember/IMemberQnaList";
	}
	
	@RequestMapping(value = "/IMemberInfoCon.do")
	public String IMemberInfoCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		mv = ii.iMemberInfoCon(sess_idx); 
		
		request.setAttribute("mv", mv); 
		
		return "imember/IMemberInfoCon";
	}
	
	@RequestMapping(value = "/IMemberInfoConPw.do")
	public String IMemberInfoConPw(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		mv = ii.iMemberInfoCon(sess_idx); 
		
		request.setAttribute("mv", mv); 
		
		return "imember/IMemberInfoCon";
	}
	
	@RequestMapping(value = "/IMemberInfoMod.do")
	public String IMemberInfoMod(HttpServletRequest request, HttpServletResponse response) {
		
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
		row = ii.iMemberInfoModChk(mv);
	
		if(row == 0){
			
			answer = "redirect:/IMemberInfoCon.do";	
			
		}else{		
			
			mv = ii.iMemberInfoCon(sess_idx);
			request.setAttribute("mv", mv);
			
			answer = "imember/IMemberInfoMod";	
			
		}
		
		return answer;
	}
	
	@RequestMapping(value = "/IMemberInfoMod_Action.do")
	public String IMemberInfoMod_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
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
    	
    	mv.setPw(pw);
    	mv.setNick(nick);
    	mv.setPhone(phone);
    	mv.setAddr(addr);
    	
    	int row = 0;
    	row = ii.iMemInfoModAction(mv, sess_idx);
    	   	
		return "redirect:/IMemberInfoCon.do";
	}
	
	@RequestMapping(value = "/IMemberMoneyHis.do")
	public String IMemberMoneyHis(ModelMap modelMap, HttpServletRequest request, Integer curPage) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		if(curPage == null){
			curPage = 1;
		}
		
		int numPerPage = 10; //한 페이지당 게시물 수
		int pagePerBlock = 10; //한 블럭당 페이지 수 
		
 		int totalRecord = ii.iMemberMoneyHisListTc(sess_idx); 	//총 게시물 수
		
		PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);
		is.setPagingHelper(pagingHelper);
		
		int start = pagingHelper.getStartRecord();
		int end = pagingHelper.getEndRecord();
		
		Integer no = is.getListNo();
		Integer prevLink = is.getPrevLink();
		Integer nextLink = is.getNextLink();
		Integer firstPage = is.getFirstPage();
		Integer lastPage = is.getLastPage();
		int[] pageLinks = is.getPageLinks();
		
		modelMap.addAttribute("no", no);
		modelMap.addAttribute("prevLink", prevLink);
		modelMap.addAttribute("nextLink", nextLink);
		modelMap.addAttribute("firstPage", firstPage);
		modelMap.addAttribute("lastPage", lastPage);
		modelMap.addAttribute("pageLinks", pageLinks);
		modelMap.addAttribute("curPage", curPage);
		
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>(); 
		dataList = ii.iMemberMoneyHisList(sess_idx, start, end);
		
		modelMap.addAttribute("dataList", dataList);

		return "imember/IMemberMoneyHis";
	}
	
	@RequestMapping(value = "/IMemberMoneyCharge_Action.do")
	public String IMemberMoneyCharge_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		String contents = "";
		int chgMoney = 0;
		if (request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}
		if(request.getParameter("chgMoney") != null){
			chgMoney = Integer.parseInt(request.getParameter("chgMoney").trim());
		}
		
		mov.setChgMoney(chgMoney);
		mov.setContents(contents);
		mov.setIdx(sess_idx);
		
		int row = 0;
		row = ii.iMemberMoneyCharge(mov);
		
		return "redirect:/IMemberMoneyHis.do";
	}

	@RequestMapping(value = "/IMemberFundList.do")
	public String IMemberFundList(ModelMap modelMap, HttpServletRequest request, Integer curPage) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		if(curPage == null){
			curPage = 1;
		}
		
		int numPerPage = 10; //한 페이지당 게시물 수
		int pagePerBlock = 10; //한 블럭당 페이지 수 
		
 		int totalRecord = ii.iMemberProjectListTc(sess_idx); 	//총 게시물 수
		
		PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);
		is.setPagingHelper(pagingHelper);
		
		int start = pagingHelper.getStartRecord();
		int end = pagingHelper.getEndRecord();
		
		Integer no = is.getListNo();
		Integer prevLink = is.getPrevLink();
		Integer nextLink = is.getNextLink();
		Integer firstPage = is.getFirstPage();
		Integer lastPage = is.getLastPage();
		int[] pageLinks = is.getPageLinks();
		
		modelMap.addAttribute("no", no);
		modelMap.addAttribute("prevLink", prevLink);
		modelMap.addAttribute("nextLink", nextLink);
		modelMap.addAttribute("firstPage", firstPage);
		modelMap.addAttribute("lastPage", lastPage);
		modelMap.addAttribute("pageLinks", pageLinks);
		modelMap.addAttribute("curPage", curPage);
		
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		dataList = ii.iMemberProjectList(sess_idx, start, end);
		
		modelMap.addAttribute("dataList", dataList);
		
		return "imember/IMemberFundList";
	}

	@RequestMapping(value = "/IMemberWishList.do")
	public String IMemberWishList(ModelMap modelMap, HttpServletRequest request, Integer curPage) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		
		plist = ii.iMemberWishList(sess_idx);
		
		request.setAttribute("plist", plist);
		
		return "imember/IMemberWishList";
	}

	@RequestMapping(value = "/IMemberWishListDel_Action.do")
	public String IMemberWishListDel_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int pIdx = 0;
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx"));
		}
		
		int row = 0;
		row = ii.iMemberWishListDel(pIdx);
		
		return "redirect:/IMemberWishList.do";
	}

}
