package com.twins.t20.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
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
import com.twins.t20.Domain.UserInfo;
import com.twins.t20.Service.JobBoardDaoSon;

@Controller
@RequestMapping(value="/twins")
public class JobBoardController {
	
private static final Logger logger =
		LoggerFactory.getLogger(JobBoardController.class);	
	
	@Resource(name="jobBoardDaoSon")
	private JobBoardDaoSon jbds;
	
	@RequestMapping(value="/jbListController")
	public String JobBoardList(
			@ModelAttribute("page") String page,
			@ModelAttribute("totalPage") String totalPage,					
			Model model,
			ArrayList<JobBoardVo> list,
			JobBoardVo jbv,
			UserInfo ui,
			Message m,
			SearchCriteria scri
			) throws Exception{
			
		if(ui.getJmidx() == 0) ui.setJmidx(100);	// �ӽ÷�
		
		model.addAttribute("m", m);  
		model.addAttribute("jbv", jbv);	
		model.addAttribute("ui", ui);
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}
		
		if (scri.getJbcategory().equals("m")) {
			
			scri.setSearchType("jbwriter");
			scri.setKeyword(ui.getJmname());
			scri.setJbcategory("");
			
			System.out.println("\n\nHere!!! jbcategory is m ");
			System.out.println("Here!!! ui �� jmname = " + ui.getJmname() + "\n");
		}
				
		model.addAttribute("scri", scri);
		
		System.out.println("L.C�� jbcategory = " + scri.getJbcategory());
		
		HashMap<String, Object> map = new HashMap<>();	;
		
		if (scri.getJbcategory().isEmpty()) {
			
			System.out.println("\n\nHere!!! jbcategory is empty \n");

			map = jbds.getJobBoardList(scri);
			list = (ArrayList<JobBoardVo>) map.get("list");
		} else {
							
			map = jbds.getJobBoardList_nfcrd(scri);
			list = (ArrayList<JobBoardVo>) map.get("list");		
		}		
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);	// �߿�
		pageMaker.setUi(ui);		// �߿�

		int cnt = (int) map.get("cnt");
		pageMaker.setTotalCount(cnt);

		model.addAttribute("pageMaker", pageMaker);
		 
		return "/Board/TwinsJobBoardList";  		 			
	}
	
	@RequestMapping(value="/jbListController_rm")
	public String JobBoardList_rm(
			@ModelAttribute("page") String page,
			@ModelAttribute("totalPage") String totalPage,					
			Model model,
			ArrayList<JobBoardVo> list,
			JobBoardVo jbv,
			UserInfo ui,
			Message m,
			SearchCriteria scri
		   )throws Exception{
		
		if(ui.getJmidx() == 0) ui.setJmidx(100);	// �ӽ÷�
		
		model.addAttribute("m", m);  
		model.addAttribute("jbv", jbv);	
		model.addAttribute("ui", ui);
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}
		
		if (scri.getJbcategory() == "m") {
			
			scri.setSearchType("jbwriter");
			scri.setKeyword(ui.getJmname());
			scri.setJbcategory("");
		}
		
		model.addAttribute("scri", scri);
		
		System.out.println("L.C�� jbcategory = " + scri.getJbcategory());
		
		HashMap<String, Object> map = new HashMap<>();	;
		
		if (scri.getJbcategory().isEmpty()) {
			
			map = jbds.getJobBoardList_rm(scri);
			list = (ArrayList<JobBoardVo>) map.get("list");
		} else {
							
			map = jbds.getJobBoardList_nfcrd_rm(scri);
			list = (ArrayList<JobBoardVo>) map.get("list");		
		}		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);    // �߿�
		pageMaker.setUi(ui);		// �߿�

		int cnt = (int) map.get("cnt");
		pageMaker.setTotalCount(cnt);

		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		 
		return "/Board/TwinsJobBoardList";  		 			
	}
	
//	@RequestMapping(value="/twins/jbList_nfcrdController")
//	public String JobBoardList_nfcrd(
//			@ModelAttribute("page") String page,
//			@ModelAttribute("totalPage") String totalPage,					
//			Model model,
//			ArrayList<JobBoardVo> list,
//			JobBoardVo jbv,
//			JobMemberVo jmv,
//			Message m,
//			SearchCriteria scri
//		   ) throws Exception{
//		
////		if(jmv.getJmidx() == 0);	
//		
//		model.addAttribute("m", m);  
//		model.addAttribute("jbv", jbv);	
//		model.addAttribute("jmv", jmv);
//		
//		int pagei = 1;		
//		if (page.equals("")) pagei = 1;	
//		else pagei = Integer.parseInt(page);
//		
//		scri.setPage(pagei);
//		model.addAttribute("scri", scri);
//
//		HashMap<String, Object> map = new HashMap<>();		
//		map = jbds.getJobBoardList_nfcrd(scri);
//		list = (ArrayList<JobBoardVo>) map.get("list");
//		
//		model.addAttribute("list", list);
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setScri(scri);
//
//		int cnt = (int) map.get("cnt");
//		pageMaker.setTotalCount(cnt);
//
//		model.addAttribute("pageMaker", pageMaker);
//		 
//		return "/Board/TwinsJobBoardList";  		 		
//	}
//	
//	@RequestMapping(value="/twins/jbList_nfcrd_Controller_rm")
//	public String JobBoardList_nfcrd_rm(	
//			@ModelAttribute("page") String page,
//			@ModelAttribute("totalPage") String totalPage,					
//			Model model,
//			ArrayList<JobBoardVo> list,
//			JobBoardVo jbv,
//			JobMemberVo jmv,
//			Message m,
//			SearchCriteria scri
//		   ) throws Exception{
//		
////		if(jmv.getJmidx() == 0);	
//		
//		model.addAttribute("m", m);  
//		model.addAttribute("jbv", jbv);	
//		model.addAttribute("jmv", jmv);
//		
//		int pagei = 1;		
//		if (page.equals("")) pagei = 1;	
//		else pagei = Integer.parseInt(page);
//		
//		scri.setPage(pagei);
//		model.addAttribute("scri", scri);
//
//		HashMap<String, Object> map = new HashMap<>();		
//		map = jbds.getJobBoardList_nfcrd_rm(scri);
//		list = (ArrayList<JobBoardVo>) map.get("list");
//		
//		model.addAttribute("list", list);
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setScri(scri);
//
//		int cnt = (int) map.get("cnt");
//		pageMaker.setTotalCount(cnt);
//
//		model.addAttribute("pageMaker", pageMaker);
//		 
//		return "/Board/TwinsJobBoardList";  		 	
//	}
	
	@RequestMapping(value="/jbContentController")
	public String JobBoardContent(	
			 @ModelAttribute("page") String page,
			 @ModelAttribute("totalPage") String totalPage,
			 JobBoardVo jbv,
			 UserInfo ui,
			 Message m,
			 SearchCriteria scri, 
			 Model model
			) throws Exception {

		model.addAttribute("m", m); 
		model.addAttribute("ui", ui); 
		
		if (jbv.getJbidx() == 0) {    
			jbv.setJbidx(1);
		}
		
		System.out.println("/jbContentController�� jbidx = " + jbv.getJbidx());
		
		//  jbv.setJbidx(0);		// �׽�Ʈ��	
		
		// ������ jbv�� ��� ���� ��� ����, ���н� jbv.jbidx�� 0�� ��ܿ´�.
		
		HashMap<String, Object> map = new HashMap<>();
		try{
			map = jbds.getJobBoardContent (jbv.getJbidx());
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		jbv = (JobBoardVo) map.get("jbv");
		
		int rd = (int) map.get("rd");  // ���� ó��

		model.addAttribute("jbv", jbv);		
		
		if (jbv.getJbidx()==0) {
			m.setMsg("�ش� �׸��� �������� �ʽ��ϴ�.");
			model.addAttribute("m", m);    			
		} 
			
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}
				
		model.addAttribute("scri", scri);
		
		if (totalPage.equals("")) totalPage = "1";	
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.setUi(ui);		// �߿�
		pageMaker.setTotalPage(totalPagei);
		model.addAttribute("pageMaker", pageMaker);
				
		return "/Board/TwinsJobBoardContent";	
	}
	
	@RequestMapping(value="/jbModifyController")
	public String JobBoardModify(			
			 @ModelAttribute("page") String page,
			  JobBoardVo jbv,
			  UserInfo ui,
			  Message m,
			  Model model,
			  SearchCriteria scri
			 ) throws Exception {
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}
		
		model.addAttribute("scri", scri);

		if (jbv.getJbidx() == 0) jbv.setJbidx(1);
		
		HashMap<String, Object> map = new HashMap<>();	
		
		try{
			map = jbds.getJobBoardContent(jbv.getJbidx());	
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		jbv = (JobBoardVo)map.get("jbv");
		int rd = (int) map.get("rd");  // ���� ó��
		
		//jbv.setJbidx(0);   // �׽�Ʈ��
		
		model.addAttribute("jbv", jbv);					
		model.addAttribute("scri", scri);
		model.addAttribute("page", page);
		model.addAttribute("m", m);
		model.addAttribute("ui", ui);

		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.setUi(ui);		// �߿�

		model.addAttribute("pageMaker", pageMaker);
				 
		// �� �κ��� getJobBoardContent()�Լ��� query ���н� jbv.jbidx�� 0 ��Ƽ� ������ ������
		if (jbv.getJbidx() == 0) {		 
			return  "forward:/twins/jbListController";
		} else {		
			return "/Board/TwinsJobBoardModify";
		}			
	}
	
	@RequestMapping(value="/jbModifyActionController")
	public String JobBoardModifyAction(
			 JobBoardVo jbv,
			// JobMemberVo jmv,
			 UserInfo ui,
			 Message m,
			 RedirectAttributes rttr,
			 Model model,
			 SearchCriteria scri
			) {
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}

		m.setIsUpdate("Yes");
		m.setRds("0");
		
		int jmidx = ui.getJmidx();
		String jmname = ui.getJmname();
		if(jmname == null) jmname="";  // �ӽ÷� // null pointer exception�� �����ϱ� ����
		jmidx = 1;
		ui.setJmidx(1);
		jbv.setJmidx(1);
		
		int page = scri.getPage();
		
		
		try {
			jmname = URLEncoder.encode(jmname, "UTF-8");	// �ѱ� ���� ����
		} catch (UnsupportedEncodingException en) {
			en.printStackTrace();
		}
			
		//�Ʒ� ���� �� ����� ��										// redirect��
		rttr.addAttribute("searchType", scri.getSearchType());	// controller ���̿��� �Ķ���� ����
		rttr.addAttribute("keyword", scri.getKeyword());		// �ּ�â�� �Ķ���Ͱ� ǥ�õ��� �ʴ� post ���
		rttr.addAttribute("jbcategory", scri.getJbcategory());
		// ���� : return "redirect:/twins/jbContentController?page="+page ��� �ߺ� ����
		
//		String searchType = scri.getSearchType();
//		String keyword = scri.getKeyword();
		
		
		System.out.println("/twins/jbModifyActionController�� jmidx = " + jbv.getJmidx());
		System.out.println("/twins/jbModifyActionController�� searchType = " + scri.getSearchType());
		
		if (jbv.getJmidx() == 0) {
			String msg = "jmidx�� �Է��ϼ���.";
			return "forward:/twins/jbListController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
		}  
		
		if (jbv.getJbidx() == 0) {
			String msg = "ó������ �����ϼ���.";
			return "forward:/twins/jbListController?msg="+msg;
		}	
		
		System.out.println("jbidx = "+jbv.getJbidx());		
		
		int rd = 0;
		String jbmodifydate = jbds.CreateyyMMdd();
		
		jbv.setJbmodifydate(jbmodifydate);		    
		
		HashMap<String, Object> map = new HashMap<>();	
		map.put("jbsubject", jbv.getJbsubject());
		map.put("jbcontent", jbv.getJbcontent());
		map.put("jbwriter", jbv.getJbwriter());
		map.put("jbmodifydate", jbv.getJbmodifydate());
		map.put("jbidx", jbv.getJbidx());
		
		try {   
			rd = jbds.updateJobBoard(map);
		} catch (Exception e) {
			rd = 0;
			e.printStackTrace();
		}
		
		if (rd == 1) m.setRds("1");
		else m.setRds("0"); 
		
		//rd = 0;		//�׽�Ʈ ��
		
		if (rd == 0 && m.getIsUpdate() == "Yes") {		
			String msg = "������ �����Ͽ����ϴ�. �ٽ��Է��� �ֽʽÿ�.";	    	
			return "forward:/twins/jbModifyController?msg="+msg;	// �̷��� �ؾߵ�(forward : post���)
		
		//return "redirect://twins/jbListController?msg="+msg; // �� : �̷��� �ϸ� �ѱ� ����(redired:get���)
		
		} else if (rd == 1 && m.getIsUpdate() == "Yes"){			
			String msg = "�����Ͽ� �����Ͽ����ϴ�.";
		try {
			msg = URLEncoder.encode(msg, "UTF-8");	// �ѱ� ���� ����
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int jbidx = jbv.getJbidx();	// ���� : setter getter �Լ��� ��������� ��Īȣȯ ��Ģ�� ���� 
								    // Jbidx�� jbidx�� ���� ������ ��޵� // �� �� Ȯ�� �ʿ�
		String isUpdate = m.getIsUpdate();
		String rds = m.getRds();
		
		System.out.println("\n\nhere!!!!! page = "+ page + "\n\n");
		
		return "redirect:/twins/jbContentController?jbidx="+jbidx+"&rds="+rds		// ������Ʈ�� redirect��� ���
		+"&isUpdate="+isUpdate+"&msg="+msg+"&page="+page+"&jmidx="+jmidx+"&jmname="+jmname;
		//+"&searchType="+searchType+"keyword="+keyword+"&jbcategory="+jbcategory;
		} 
		
		return ""; //�ǹ� ����. �ƹ��ų� ����.
	}
	
	@RequestMapping(value="/jbWriteController")
	public String JobBoardWrite(
			 @ModelAttribute("page") String page, 
			 @ModelAttribute("totalPage") String totalPage, 
			 Message m,
			 JobBoardVo jbv,		
			 //JobMemberVo jmv,
			 UserInfo ui,
			 Model model, 
			 SearchCriteria scri
			 ) throws Exception {
		
		// ----
		
		if (scri.getJbcategory() == null) { 	
			scri.setJbcategory("");		// ������ null�� �Ѿ�ͼ� �� ������ �� �����
		}

		model.addAttribute("scri", scri);
		
		int jmidx = ui.getJmidx();
		String jmname = ui.getJmname();
		if(jmname == null) jmname="";
		
		try {
			jmname = URLEncoder.encode(jmname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
				
//		if (scri.getJbcategory().isEmpty()) {
//			
//			String msg = "���� �� �Խ��� ������ ���� �����ϼ���.";
//			
//			try {
//				msg = URLEncoder.encode(msg, "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}  
//			return "redirect:/twins/jbListController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
//		}
		
		// ---- 
		
		if (m.getRds() == "") { 
			m.setRds("0");
		}
		
		System.out.println("\n\n/twins/jbWriteController�� ui.jmname ="+ui.getJmname()+"\n\n");
		
		model.addAttribute("m", m);
		model.addAttribute("jbv",jbv);
		model.addAttribute("ui",ui);
		
		if (page.equals("")) page = "1";	
		if (totalPage.equals("")) totalPage = "1";		
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.getScri().setPage(totalPagei);		
		int cnt;
		try {
			cnt = jbds.getJobBoardTotalRecordCount(scri); 
						// scri.jbcategory ���� ���� ���� ������ �޶���  
						// scri.jbcategory ���� n, f, c, r, d �� �ϳ���
			pageMaker.setTotalCount(cnt);
		} catch (Exception e) {
			pageMaker.setTotalCount(10);
			e.printStackTrace();
		}	
			
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("scri", scri);  
		//  /Board/TwinsJobBoardWrite.jsp���� makeSearch()���� �޼ҵ带 ����ϱ� ���� �� �ʿ�
		pageMaker.setUi(ui); // �߿�
		
		return "/Board/TwinsJobBoardWrite";
	}
	
	@RequestMapping(value="/jbWriteActionController")
	public String JobBoardWriteAction(			
			@ModelAttribute("page") String page, 
			@ModelAttribute("totalPage") String totalPage,
			Model model, 
			JobBoardVo jbv,
			//JobMemberVo jmv,
			UserInfo ui,
			Message m,
			SearchCriteria scri
			) {
		
		// ----
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}

		model.addAttribute("scri", scri);
		
		int jmidx = ui.getJmidx();
		String jmname = ui.getJmname();
		if(jmname == null) jmname="";
		
		try {
			jmname = URLEncoder.encode(jmname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
				
		if (scri.getJbcategory().isEmpty()) {	
			
			String msg = "���� �� �Խ��� ������ ���� �����ϼ���.";
			
			try {
				msg = URLEncoder.encode(msg, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}  
			
			return "redirect:/twins/jbWriteController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
		}
		
		// ----
		
		jbv.setJbcategory(scri.getJbcategory());  //  ���� ���� �ʿ��� ***
		
		if (jmidx == 0) {
			ui.setJmidx(10);
			jbv.setJmidx(10);  // �ӽ÷�
			jmidx = 10;
		}
		
//		if (jbv.getJbcategory() == "") {
//			jbv.setJbcategory("f");  // �ӽ÷�
//		}
		
		System.out.println("\n\n/twins/jbWriteActionController�� ui.jmname 1 ="+ui.getJmname()+"\n\n");
		
		boolean isRedirect = false; 		
		m.setIsWright("Yes");
		m.setRds("0");	
		String msg = "";
		int RD = 0;
		
		System.out.println("\n\n/twins/jbWriteActionController�� ui.jmidx = "+ui.getJmidx());
		System.out.println("/twins/jbWriteActionControlle�� jbv.jmidx = "+jbv.getJmidx()+"\n\n");
		System.out.println("/twins/jbWriteActionController�� m.getRds() = "+m.getRds()+"\n\n");		
		
		//jboidx�� �켱 hidden ���� ������ ���� ����		
				
		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
		// jbsubject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
		if (jbv.getJbsubject() == "") {   			
			msg = "ó������ �����ϼ���.";
		
			System.out.println("\n\n/twins/jbWriteActionController�� ui.jmname 2 ="+ui.getJmname()+"\n\n");
			return "forward:/twins/jbWriteController?msg="+msg;		
		}
		
		// �̺κп����� idx�� �Է� ���θ� üũ�� ����.
		if (jbv.getJmidx() == 0) {  
			msg = "jmidx�� �Է��ϼ���.";
		
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
						// scri.jbcategory ���� ���� ���� ������ �޶���
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
	
	@RequestMapping(value="/jbReplyController")
	public String JobBoardReply(
			 @ModelAttribute("page") String page, 
			 @ModelAttribute("totalPage") String totalPage, 
			 JobBoardVo jbv,
			 //JobMemberVo jmv,
			 UserInfo ui,
			 Message m,
			 SearchCriteria scri,
			 Model model
			)throws SQLException {
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}
		
		model.addAttribute("ui", ui);
		model.addAttribute("scri", scri);
		
		int jmidx = ui.getJmidx();
		String jmname = ui.getJmname();
		if(jmname == null) jmname="";
		
		try {
			jmname = URLEncoder.encode(jmname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		//m.setRds("0");	// �׽�Ʈ��
		
		model.addAttribute("m", m);	// /Board/TwinsJobBoardReply���� m.rds�� üũ.
		
		if (totalPage.equals("")) totalPage = "1";	
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.setUi(ui);		// �߿�
		pageMaker.setTotalPage(totalPagei);
		
		model.addAttribute("pageMaker", pageMaker);
		
		if (jbv.getJbidx() == 0){
			jbv.setJbidx(1);
		}
		
		HashMap<String, Object> map = new  HashMap<>();
		
		try{
			map = jbds.getJobBoardContent(jbv.getJbidx());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		jbv = (JobBoardVo) map.get("jbv");
		int rd = (int) map.get("rd");  // ���� ó��
		
		//jbv.setJbidx(0);   // �׽�Ʈ��
		
		model.addAttribute("jbv", jbv);	// �̰� �ϳ��� ���
		//model.addAttribute("jbidx", jbv.getJbidx());  
		// /twins/jbReplyActionController�� ������ �뵵	
		
		// �� �κ��� getContent()�Լ��� query ���н� bv.bidx�� 0 ��Ƽ� ������ ������
		if (jbv.getJbidx() == 0) {
			// �޽��� ���� ....
			return "forward:/twins/jbListController?page="+page+"&jmidx="+jmidx+"&jmname="+jmname; 
		} else {		
			return "/Board/TwinsJobBoardReply";
		}	 
	}
	
	@RequestMapping(value="/jbReplyActionController")
	public String JobBoardReplyAction(			
			@ModelAttribute("page") String page,
			@ModelAttribute("totalPage") String totalPage,
			JobBoardVo jbv,
			//JobMemberVo jmv,
			UserInfo ui,
			Message m,
			SearchCriteria scri, 
			RedirectAttributes rttr,
			Model model								
		   )throws UnsupportedEncodingException {
		
		String jbcategory =	jbv.getJbcategory();
		scri.setJbcategory(jbcategory);
		
//		if (scri.getJbcategory() == null) {
//		scri.setJbcategory("");
//	}	
		
		int jmidx = ui.getJmidx();
		String jmname = ui.getJmname();
		if(jmname == null) jmname="";
		
		System.out.println("R.A.C�� scri.searchType = " + scri.getSearchType());
		System.out.println("R.A.C�� scri.page = " + scri.getPage());
	
		if (jmidx == 0) {
			ui.setJmidx(10);
			jbv.setJmidx(10);  // �ӽ÷�
			jmidx = 10;
		}
		
		try {
			jmname = URLEncoder.encode(jmname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		model.addAttribute("ui", ui);
		
		m.setIsReply("Yes");
		m.setRds("0");
		String msg = "";
		int RD = Integer.parseInt(m.getRds());
		
		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
		// jbsubject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
		if (jbv.getJbsubject() == "") {   			
			msg = "ó������ �����ϼ���.";		
			return "forward:/twins/jbWriteController?msg="+msg;		
		}
		
		// �̺κ��� ���α׷� ���߽� jmidx�� �Է� ���θ� üũ�� ����.
		if (jbv.getJmidx() == 0) {  
			msg = "jmidx�� �Է��ϼ���.";
			return "forward:/twins/jbListController?msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname;
		}
		
		String jbwritedate = jbds.CreateyyMMdd();
		String jbmodifydate = jbds.CreateyyMMdd();
		
		int jbidx = 0;  // ����� ���� ���� �׽�Ʈ �ʿ�
		RD = 0;
		
		jbv.setJbupdown(jbv.getJbupdown() + 1);
		jbv.setJbleftright(jbv.getJbleftright() + 1);
		jbv.setJbwritedate(jbwritedate);
		jbv.setJbmodifydate(jbmodifydate);		
			
		try{
			jbidx = jbds.replyWriteJobBoard(jbv); // ����� jbidx�� ��ƿ´�.
			if (jbidx != 0) RD =1;
			else RD = 0;
		} catch(Exception e){
			RD = 0;
			e.printStackTrace();
		}			
				
		if (RD == 1) {
			m.setRds("1");
		} else if (RD == 0){
			m.setRds("0");
		}		      
		
		//RD = 0;  //�׽�Ʈ��
		
		if (RD == 0 && m.getIsReply() == "Yes") {
		
			msg = "����� �������� ���߽��ϴ�. �ٽ� �õ����ּ���.";	
		
			model.addAttribute("scri", scri);  //???				
			return "forward:/twins/jbReplyController?msg="+msg;	
		} else {	
		
			msg = "����� �����Ͽ����ϴ�.";
		
		try {
			jbv.setJbsubject(URLEncoder.encode(jbv.getJbsubject(), "UTF-8"));
			jbv.setJbwriter(URLEncoder.encode(jbv.getJbwriter(), "UTF-8"));
			msg = URLEncoder.encode(msg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		System.out.println("/twins/jbListController_rm�� ���ļ�/Board/TwinsJobBoardList.jsp�� ��");
				    
		if (totalPage.equals("")) totalPage = "1";	
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();				
		pageMaker.setScri(scri);
		pageMaker.getScri().setPage(totalPagei);		
		
		System.out.println("\n/twins/jbReplyActionController �� jbidx = " + jbidx);
		pageMaker.getScri().setJbidx(jbidx);
				
		if (page.equals("")) page = "1";	
		int pagei = Integer.parseInt(page);
		pageMaker.getScri().setPage(pagei);
		pageMaker.getScri().setSearchType(scri.getSearchType());
		pageMaker.getScri().setKeyword(scri.getKeyword());
		
		// ��۾����� ����� �������� �ϳ� �þ ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
		int cnt;
		try {
			cnt = jbds.getJobBoardTotalRecordCount_rm(pageMaker.getScri());// _rmȣ��
						// scri.jbcategory ���� ���� ���� ������ �޶���
						// _rm�� reply�� modify�� ��쿡 �ش��
			pageMaker.setTotalCount(cnt);
			totalPagei= pageMaker.getTotalPage();
			
			Integer i = new Integer(totalPagei);
			totalPage = i.toString();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//��� ������ �ʿ���  // get?��� �Ǵ� post?������� ����  
		//rttr.addAttribute("pageMaker", pageMaker);
		//rttr.addAttribute("searchType", scri.getSearchType());
		//rttr.addAttribute("keyword", scri.getKeyword()); 
		    		    
		String searchType = pageMaker.getScri().getSearchType();
		String keyword = pageMaker.getScri().getKeyword();
		try {
			searchType = URLEncoder.encode(searchType, "UTF-8");
			keyword = URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		String jbsubject = jbv.getJbsubject();
		String jbwriter = jbv.getJbwriter();
		String rds = m.getRds();
		String isReply = m.getIsReply();
		
		return "redirect:/twins/jbListController_rm?jbsubject="+jbsubject+"&jbwriter="
		  +jbwriter+"&rds="+rds+"&isReply="+isReply+"&msg="+msg+"&jmidx="+jmidx+"&jmname="+jmname
		  +"&page="+page+"&totalPage="+totalPage
		  +"&searchType="+searchType+"&keyword="+keyword+"&jbidx="+jbidx+"&jbcategory="+jbcategory;  
		}
	}
	
	@RequestMapping(value="/jbDeleteActionController")
	public String JobBoardDeleteAction(		
			 @ModelAttribute("page") String page,
			 JobBoardVo jbv,
			 //JobMemberVo jmv,
			 UserInfo ui,
			 Message m,
			 SearchCriteria scri, 
			 RedirectAttributes rttr
//			 Model model
			)throws Exception {
		
		if (scri.getJbcategory() == null) {
			scri.setJbcategory("");
		}
		
		int jmidx=ui.getJmidx();
		String jmname=ui.getJmname();
		
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
		else m.setRds("0");
		
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
			rttr.addAttribute("jbcategory", scri.getJbcategory());
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
