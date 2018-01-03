package com.twins.t20.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twins.t20.Domain.JobBoardVo;
import com.twins.t20.Domain.JobMemberVo;
import com.twins.t20.Domain.Message;
import com.twins.t20.Domain.PageMaker;
import com.twins.t20.Domain.SearchCriteria;
import com.twins.t20.Service.JobBoardDaoSon;

@Controller
public class JobBoardController {
	
private static final Logger logger =
		LoggerFactory.getLogger(JobBoardController.class);	
	
	@Resource(name="jobBoardDaoSon")
	private JobBoardDaoSon jbds;
	
	@RequestMapping(value="/twins/jbListController", method = RequestMethod.GET)
	public String JobBoardList(
			@ModelAttribute("page") String page,
			@ModelAttribute("totalPage") String totalPage,					
			Model model,
			ArrayList<JobBoardVo> list,
			JobBoardVo jbv,
			JobMemberVo jmv,
			Message m,
			SearchCriteria scri
			) throws Exception{
			
//		if(jmv.getJmidx() == 0);	
		
		model.addAttribute("m", m);  
		model.addAttribute("jbv", jbv);	
		model.addAttribute("jmv", jmv);
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		model.addAttribute("scri", scri);

		HashMap<String, Object> map = new HashMap<>();		
		map = jbds.getJobBoardList(scri);
		list = (ArrayList<JobBoardVo>) map.get("list");
		
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);

		int cnt = (int) map.get("cnt");
		pageMaker.setTotalCount(cnt);

		model.addAttribute("pageMaker", pageMaker);
		 
		return "/Board/TwinsJobBoardList";  		 			
	}
	
	@RequestMapping(value="/twins/jbList_rmController")
	public String JobBoardList_rm(
			@ModelAttribute("page") String page,
			@ModelAttribute("totalPage") String totalPage,					
			Model model,
			ArrayList<JobBoardVo> list,
			JobBoardVo jbv,
			JobMemberVo jmv,
			Message m,
			SearchCriteria scri
		   )throws Exception{
		
//		if(jmv.getJmidx() == 0);	
		
		model.addAttribute("m", m);  
		model.addAttribute("jbv", jbv);	
		model.addAttribute("jmv", jmv);
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		model.addAttribute("scri", scri);

		HashMap<String, Object> map = new HashMap<>();		
		map = jbds.getJobBoardList_rm(scri);
		list = (ArrayList<JobBoardVo>) map.get("list");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);

		int cnt = (int) map.get("cnt");
		pageMaker.setTotalCount(cnt);

		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		 
		return "/Board/TwinsJobBoardList";  		 			
	}
	
	@RequestMapping(value="/twins/jbList_nfcrdController")
	public String JobBoardList_nfcrd(
			@ModelAttribute("page") String page,
			@ModelAttribute("totalPage") String totalPage,					
			Model model,
			ArrayList<JobBoardVo> list,
			JobBoardVo jbv,
			JobMemberVo jmv,
			Message m,
			SearchCriteria scri
		   ) throws Exception{
		
//		if(jmv.getJmidx() == 0);	
		
		model.addAttribute("m", m);  
		model.addAttribute("jbv", jbv);	
		model.addAttribute("jmv", jmv);
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		model.addAttribute("scri", scri);

		HashMap<String, Object> map = new HashMap<>();		
		map = jbds.getJobBoardList_nfcrd(scri);
		list = (ArrayList<JobBoardVo>) map.get("list");
		
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);

		int cnt = (int) map.get("cnt");
		pageMaker.setTotalCount(cnt);

		model.addAttribute("pageMaker", pageMaker);
		 
		return "/Board/TwinsJobBoardList";  		 		
	}
	
	@RequestMapping(value="/twins/jbList_nfcrd_rmController")
	public String JobBoardList_nfcrd_rm(	
			@ModelAttribute("page") String page,
			@ModelAttribute("totalPage") String totalPage,					
			Model model,
			ArrayList<JobBoardVo> list,
			JobBoardVo jbv,
			JobMemberVo jmv,
			Message m,
			SearchCriteria scri
		   ) throws Exception{
		
//		if(jmv.getJmidx() == 0);	
		
		model.addAttribute("m", m);  
		model.addAttribute("jbv", jbv);	
		model.addAttribute("jmv", jmv);
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		model.addAttribute("scri", scri);

		HashMap<String, Object> map = new HashMap<>();		
		map = jbds.getJobBoardList_nfcrd_rm(scri);
		list = (ArrayList<JobBoardVo>) map.get("list");
		
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);

		int cnt = (int) map.get("cnt");
		pageMaker.setTotalCount(cnt);

		model.addAttribute("pageMaker", pageMaker);
		 
		return "/Board/TwinsJobBoardList";  		 	
	}
	
	@RequestMapping(value="/twins/jbContentController")
	public String JobBoardContent(	
			 @ModelAttribute("page") String page,
			 @ModelAttribute("totalPage") String totalPage,
			 JobBoardVo jbv,
			 JobMemberVo jmv,
			 Message m,
			 SearchCriteria scri, 
			 Model model
			) throws Exception {

		model.addAttribute("m", m); 
		model.addAttribute("jmv", jmv); 
		
		if (jbv.getJbidx() == 0) {    
		jbv.setJbidx(1);
		}
		
		System.out.println("/twins/jbContentController의Jbidx = " + jbv.getJbidx());
		
		//  jbv.setJbidx(0);		// 테스트용	
		
		// 성공시 jbv에 모든 값이 담겨 오고, 실패시 jbv.jbidx에 0이 담겨온다.
		
		HashMap<String, Object> map = new HashMap<>();
		try{
			map = jbds.getJobBoardContent (jbv.getJbidx());
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		jbv = (JobBoardVo) map.get("jbv");

		model.addAttribute("jbv", jbv);		
		
		if (jbv.getJbidx()==0) {
			m.setMsg("해당 항목이 존재하지 않습니다.");
			model.addAttribute("m", m);    			
		} 
			
		if (page.equals("")) page = "1";	
		model.addAttribute("scri", scri);
		
		if (totalPage.equals("")) totalPage = "1";	
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.setTotalPage(totalPagei);
		model.addAttribute("pageMaker", pageMaker);
				
		return "/Board/TwinsJobBoardContent";	
	}
	
	@RequestMapping(value="/twins/jbModifyController")
	public String JobBoardModify(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbModifyActionController")
	public String JobBoardModifyAction(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbWriteController")
	public String JobBoardWrite(
			 @ModelAttribute("page") String page, 
			 @ModelAttribute("totalPage") String totalPage, 
			 Message m,
			 JobBoardVo jbv,		
			 JobMemberVo jmv,
			 Model model, 
			 SearchCriteria scri
			 ) throws Exception {

		if (m.getRds() == "") { 
		m.setRds("0");
		}
		
		System.out.println("\n\n/twins/jbWriteController의 jmv.jmname ="+jmv.getJmname()+"\n\n");
		
		model.addAttribute("m", m);
		model.addAttribute("jbv",jbv);
		model.addAttribute("jmv",jmv);
		
		if (page.equals("")) page = "1";	
		if (totalPage.equals("")) totalPage = "1";		
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.getScri().setPage(totalPagei);		
		int cnt;
		try {
			cnt = jbds.getJobBoardTotalRecordCount(scri);
			pageMaker.setTotalCount(cnt);
		} catch (Exception e) {
			pageMaker.setTotalCount(10);
			e.printStackTrace();
		}	
			
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("scri", scri);  //Write.jsp에서 makeSearch() 메소드를 사용하기 위해 꼭 필요
		
		return "/Board/TwinsJobBoardWrite";
	}
	
	@RequestMapping(value="/twins/jbWriteActionController")
	public String JobBoardWriteAction(			
			@ModelAttribute("page") String page, 
			@ModelAttribute("totalPage") String totalPage,
			Model model, 
			JobBoardVo jbv,
			JobMemberVo jmv,
			Message m,
			SearchCriteria scri
			) {

		int jmidx = jmv.getJmidx();
		String jmname = jmv.getJmname();
		
		if (jmidx == 0) {
			jmv.setJmidx(10);
			jbv.setJmidx(10);  // 임시로
			jmidx = 10;
		}
		
		if (jbv.getJbcategory() == "") {
			jbv.setJbcategory("f");  // 임시로
		}
		
		System.out.println("\n\n/twins/jbWriteActionController의 jmv.jmname 1 ="+jmv.getJmname()+"\n\n");
		
		try {
			jmname = URLEncoder.encode(jmname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		boolean isRedirect = false; 		
		m.setIsWright("Yes");
		m.setRds("0");	
		String msg = "";
		int RD = 0;
		
		System.out.println("\n\n/twins/jbWriteActionController의 jmv.jmidx = "+jmv.getJmidx());
		System.out.println("/twins/jbWriteActionControlle의 jbv.jmidx = "+jbv.getJmidx()+"\n\n");
		System.out.println("/twins/jbWriteActionController의 m.getRds() = "+m.getRds()+"\n\n");		
		
		//jboidx는 우선 hidden 으로 고정된 값을 받음		
				
		// 글을 쓰고 나서 이 메소드를 호출했는지 체크
		// jbsubject를 사용하여 처음부터 시작했는지의 여부를 체크한다.
		if (jbv.getJbsubject() == "") {   			
			msg = "처음부터 시작하세요.";
		
			System.out.println("\n\n/twins/jbWriteActionController의 jmv.jmname 2 ="+jmv.getJmname()+"\n\n");
			return "forward:/twins/jbWriteController?msg="+msg;		
		}
		
		// 이부분에서는 idx의 입력 여부를 체크해 본다.
		if (jbv.getJmidx() == 0) {  
			msg = "idx를 입력하세요.";
		
		return "forward:/twins/jbWriteController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
		} 
		
		System.out.println("1 /twins/jbWriteActionController의 jbsubject = "+jbv.getJbsubject());
		System.out.println("1 /twins/jbWriteActionController의 jbwriter = "+jbv.getJbwriter());
		
		String writedate = jbds.CreateyyMMdd();
		String modifydate = jbds.CreateyyMMdd();
		jbv.setJbwritedate(writedate);
		jbv.setJbmodifydate(modifydate);
		
		try{
			RD = jbds.writeJobBoard(jbv);
		} catch(Exception e){
			RD = 0;
			e.printStackTrace();
		}								
		
		if (RD == 1) {
			m.setRds("1");
		} else if (RD == 0){
			m.setRds("0");
		}		      
		
		//m.setRds("0");	//테스트용
		
		if (m.getRds().equals("0") && m.getIsWright().equals("Yes")) {			
			isRedirect = false;
			m.setMsg("글쓰기에 실패하였습니다.다시  입력하세요.");
		} else {
			isRedirect = true;
			m.setMsg("작성된 글이 저장되었습니다.");
			try {
				jbv.setJbsubject(URLEncoder.encode(jbv.getJbsubject(), "UTF-8"));
				jbv.setJbwriter(URLEncoder.encode(jbv.getJbwriter(), "UTF-8"));
				m.setMsg(URLEncoder.encode(m.getMsg(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			    
		} 		
		
		if (totalPage.equals("")) totalPage = "1";	
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setScri(scri);
		pageMaker.getScri().setPage(totalPagei);		
		
		// 글쓰기의 결과로 페이지가 하나 늘어날 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
		// descending으로 정렬하여 최근것을 앞에 보여주므로 맨 마지막 것에 해당하는 totalCount의 계산은 의미없지만 
		// 데이터가 한번의 리스트에 나타날 정도로 아주 적을 경우에는 영향을 줌
		int cnt;
		try {
			cnt = jbds.getJobBoardTotalRecordCount(scri);
			pageMaker.setTotalCount(cnt);
			totalPagei= pageMaker.getTotalPage();
		
			Integer i = new Integer(totalPagei);
			totalPage = i.toString();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//아래는 필요없는 과정. 왜냐면 전체 리스트 항목으로 돌아가므로 
		//현재페이지와 토탈페이지 정보만 필요함 
		//rttr.addAttribute("pageMaker", pageMaker);
		
		if (isRedirect) {				
		
			String jbsubject = jbv.getJbsubject();
			String jbwriter = jbv.getJbwriter();
			String rds = m.getRds();
			String isWrite = m.getIsWright();
			msg = m.getMsg();
		
			return "redirect:/twins/jbListController?jbsubject="+jbsubject+"&jbwriter="			
					+jbwriter+"&rds="+rds+"&isWrite="+isWrite+"&msg="+msg+"&page="+"1"+"&jmidx="+jmidx+"&jmname="+jmname;
					//descending으로 정렬하여 보여주므로 최근에 작성한 글은 무조건 1페이지에 나타난다.		
		}else {
			msg = m.getMsg();
			return "forward:/twins/jbWriteController?page="+page+"&msg="+msg;
		}
	}
	
	@RequestMapping(value="/twins/jbReplyController")
	public String JobBoardReply(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbReplyActionController")
	public String JobBoardReplyAction(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbDeleteActionController")
	public String JobBoardDeleteAction(		
			 @ModelAttribute("page") String page,
			 JobBoardVo jbv,
			 JobMemberVo jmv,
			 Message m,
			 SearchCriteria scri, 
			 RedirectAttributes rttr
//			 Model model
			)throws Exception {

		int jmidx=jmv.getJmidx();
		String jmname=jmv.getJmname();
		
		m.setIsDelete("Yes");	    
		String msg = "";
		//	String rds = "1";	//테스트 용
		m.setRds("0");
		
		jbv.setJmidx(2);  //임시로 지정   //테스트용
		
		if (jbv.getJmidx() == 0) {
			msg = "jmidx를 입력하세요.";
		return "forward:/twins/jbListController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
		}
		
		//jbv.setJbidx(0);	//테스트용
		
		if (jbv.getJbidx() == 0) {
			msg = "처음부터 시작하세요.";
		return "forward:/twins/jbListController?msg="+msg;			
		}	
		
		int RD = 0;
		int cnt = 0;
		
		cnt = jbds.deleteJobBaoard(scri); 
		
		if (cnt == 0) RD = 0;
		else RD = 1;
		
		//RD = 0;  // 테스트 용   	    
		
		if (RD == 1) m.setRds("1");		    	
		else if (RD == 0) m.setRds("0");
		
		if (RD == 1) {						     
		msg = "해당글을 삭제 하였습니다.";
		
		PageMaker pageMaker = new PageMaker();				
		pageMaker.setScri(scri);		
		
		// 글삭제의 결과로 페이지가 하나 줄어들 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
		pageMaker.setTotalCount(cnt);
		int totalPagei= pageMaker.getTotalPage();
		int presentPagei = scri.getPage();
		
		if (presentPagei > totalPagei) presentPagei = totalPagei;
		scri.setPage(presentPagei);
								
		Integer i = new Integer(presentPagei);
		page = i.toString();					
					
		rttr.addAttribute("page", page);
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		rttr.addAttribute("rds", m.getRds());
		rttr.addAttribute("isDelete", m.getIsDelete());
		rttr.addAttribute("msg", msg);
		rttr.addAttribute("jmidx", jmidx);
		rttr.addAttribute("jmname", jmname);
			     
		String rds = m.getRds();
		String isDelete = m.getIsDelete();
		
		return "redirect:/twins/jbListController";
		
		} else {
				 
			msg = "삭제에 실패하였습니다. 다시 시도하세요.";
		
		return "forward:/twins/jbContentController?msg="+msg+"&page="+page;
		}					 		
	}
}
