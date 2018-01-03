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
		
		System.out.println("/twins/jbContentController��Jbidx = " + jbv.getJbidx());
		
		//  jbv.setJbidx(0);		// �׽�Ʈ��	
		
		// ������ jbv�� ��� ���� ��� ����, ���н� jbv.jbidx�� 0�� ��ܿ´�.
		
		HashMap<String, Object> map = new HashMap<>();
		try{
			map = jbds.getJobBoardContent (jbv.getJbidx());
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		jbv = (JobBoardVo) map.get("jbv");

		model.addAttribute("jbv", jbv);		
		
		if (jbv.getJbidx()==0) {
			m.setMsg("�ش� �׸��� �������� �ʽ��ϴ�.");
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
		
		System.out.println("\n\n/twins/jbWriteController�� jmv.jmname ="+jmv.getJmname()+"\n\n");
		
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
		model.addAttribute("scri", scri);  //Write.jsp���� makeSearch() �޼ҵ带 ����ϱ� ���� �� �ʿ�
		
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
			jbv.setJmidx(10);  // �ӽ÷�
			jmidx = 10;
		}
		
		if (jbv.getJbcategory() == "") {
			jbv.setJbcategory("f");  // �ӽ÷�
		}
		
		System.out.println("\n\n/twins/jbWriteActionController�� jmv.jmname 1 ="+jmv.getJmname()+"\n\n");
		
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
		
		System.out.println("\n\n/twins/jbWriteActionController�� jmv.jmidx = "+jmv.getJmidx());
		System.out.println("/twins/jbWriteActionControlle�� jbv.jmidx = "+jbv.getJmidx()+"\n\n");
		System.out.println("/twins/jbWriteActionController�� m.getRds() = "+m.getRds()+"\n\n");		
		
		//jboidx�� �켱 hidden ���� ������ ���� ����		
				
		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
		// jbsubject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
		if (jbv.getJbsubject() == "") {   			
			msg = "ó������ �����ϼ���.";
		
			System.out.println("\n\n/twins/jbWriteActionController�� jmv.jmname 2 ="+jmv.getJmname()+"\n\n");
			return "forward:/twins/jbWriteController?msg="+msg;		
		}
		
		// �̺κп����� idx�� �Է� ���θ� üũ�� ����.
		if (jbv.getJmidx() == 0) {  
			msg = "idx�� �Է��ϼ���.";
		
		return "forward:/twins/jbWriteController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
		} 
		
		System.out.println("1 /twins/jbWriteActionController�� jbsubject = "+jbv.getJbsubject());
		System.out.println("1 /twins/jbWriteActionController�� jbwriter = "+jbv.getJbwriter());
		
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
		
		//m.setRds("0");	//�׽�Ʈ��
		
		if (m.getRds().equals("0") && m.getIsWright().equals("Yes")) {			
			isRedirect = false;
			m.setMsg("�۾��⿡ �����Ͽ����ϴ�.�ٽ�  �Է��ϼ���.");
		} else {
			isRedirect = true;
			m.setMsg("�ۼ��� ���� ����Ǿ����ϴ�.");
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
		
		// �۾����� ����� �������� �ϳ� �þ ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
		// descending���� �����Ͽ� �ֱٰ��� �տ� �����ֹǷ� �� ������ �Ϳ� �ش��ϴ� totalCount�� ����� �ǹ̾����� 
		// �����Ͱ� �ѹ��� ����Ʈ�� ��Ÿ�� ������ ���� ���� ��쿡�� ������ ��
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
		
		//�Ʒ��� �ʿ���� ����. �ֳĸ� ��ü ����Ʈ �׸����� ���ư��Ƿ� 
		//������������ ��Ż������ ������ �ʿ��� 
		//rttr.addAttribute("pageMaker", pageMaker);
		
		if (isRedirect) {				
		
			String jbsubject = jbv.getJbsubject();
			String jbwriter = jbv.getJbwriter();
			String rds = m.getRds();
			String isWrite = m.getIsWright();
			msg = m.getMsg();
		
			return "redirect:/twins/jbListController?jbsubject="+jbsubject+"&jbwriter="			
					+jbwriter+"&rds="+rds+"&isWrite="+isWrite+"&msg="+msg+"&page="+"1"+"&jmidx="+jmidx+"&jmname="+jmname;
					//descending���� �����Ͽ� �����ֹǷ� �ֱٿ� �ۼ��� ���� ������ 1�������� ��Ÿ����.		
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
		//	String rds = "1";	//�׽�Ʈ ��
		m.setRds("0");
		
		jbv.setJmidx(2);  //�ӽ÷� ����   //�׽�Ʈ��
		
		if (jbv.getJmidx() == 0) {
			msg = "jmidx�� �Է��ϼ���.";
		return "forward:/twins/jbListController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
		}
		
		//jbv.setJbidx(0);	//�׽�Ʈ��
		
		if (jbv.getJbidx() == 0) {
			msg = "ó������ �����ϼ���.";
		return "forward:/twins/jbListController?msg="+msg;			
		}	
		
		int RD = 0;
		int cnt = 0;
		
		cnt = jbds.deleteJobBaoard(scri); 
		
		if (cnt == 0) RD = 0;
		else RD = 1;
		
		//RD = 0;  // �׽�Ʈ ��   	    
		
		if (RD == 1) m.setRds("1");		    	
		else if (RD == 0) m.setRds("0");
		
		if (RD == 1) {						     
		msg = "�ش���� ���� �Ͽ����ϴ�.";
		
		PageMaker pageMaker = new PageMaker();				
		pageMaker.setScri(scri);		
		
		// �ۻ����� ����� �������� �ϳ� �پ�� ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
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
				 
			msg = "������ �����Ͽ����ϴ�. �ٽ� �õ��ϼ���.";
		
		return "forward:/twins/jbContentController?msg="+msg+"&page="+page;
		}					 		
	}
}
