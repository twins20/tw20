package com.my.smnb20_2.controller;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Target;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.my.smnb20_2.Domain.BidxSearchCriteria;
import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.CheckLineVO;
import com.my.smnb20_2.Domain.Criteria;
import com.my.smnb20_2.Domain.MemberVO;
import com.my.smnb20_2.Domain.Message;
import com.my.smnb20_2.Domain.SearchCriteria;
import com.my.smnb20_2.Domain.PageMaker;
import com.my.smnb20_2.service.*;
 

@Controller
public class Boardcontroller {
  
	private static final Logger logger =
		LoggerFactory.getLogger(Boardcontroller.class);

	//@org.springframework.beans.factory.annotation.Autowired(required=true)
	
	@Resource(name="boardDAO_ano_Son")
//	private BoardDAO_ano_Father bd;
	private BoardDAO_ano_Son bd;
	
	
	
	@RequestMapping(value="/Spring/MVCListcontroller_TS")
	public String List_TS(
						@ModelAttribute("page") String page,
						@ModelAttribute("totalPage") String totalPage,					
						Model model,
						ArrayList<BoardVO> list,
						BoardVO bv,
						MemberVO mv,
						Message m,
						SearchCriteria scri
						) throws SQLException {
		
		
//		System.out.println("\n\nListcontroller_TS�� mv.idx = " + mv.getIdx());
//		System.out.println("Listcontroller_TS�� mv.name = " + mv.getName() +"\n\n");
//		
//		System.out.println("\n\nListcontroller_TS�� page = " + page);
//		System.out.println("Listcontroller_TS�� totalPage = " + totalPage +"\n\n");
		
		if(mv.getIdx() == 0);	
			
//		System.out.println("\n\nListcontroller_TS�� m.isDelete = " + m.getIsDelete()+"\n\n");
//		if (m.getIsDelete().equals("Yes"))
//			System.out.println("\n\nListcontroller_TS�� m.msg = " + m.getMsg()+"\n\n");
		
		model.addAttribute("m", m);  
		model.addAttribute("bv", bv);	
		model.addAttribute("mv", mv);
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
		
		scri.setPage(pagei);
		model.addAttribute("scri", scri);
		
		list = bd.getBoardList_TS(scri);
		model.addAttribute("list", list);
		
//		System.out.println("/Spring/MVCListcontroller_TS ��  list : " + list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);
		int cnt;
		try {
			cnt = bd.searchCountPaging(scri);
			pageMaker.setTotalCount(cnt);
		} catch (Exception e) {
			pageMaker.setTotalCount(10);
			e.printStackTrace();
		}		
		model.addAttribute("pageMaker", pageMaker);
		 
		return "List_TS";  		 	
	}
	
	

	
	@RequestMapping(value="/Spring/MVCListcontroller_R_TS")
	public String List_R_TS(
						@ModelAttribute("page") String page,
						@ModelAttribute("totalPage") String totalPage,
						Model model,
						ArrayList<BoardVO> list,
						BoardVO bv,
						MemberVO mv,
						Message m,
						SearchCriteria scri					
						) throws SQLException {

		model.addAttribute("mv", mv);  
		model.addAttribute("m", m);  
		model.addAttribute("bv", bv);	

		System.out.println("/Spring/MVCListcontroller_R_TS ��  page = " + page);	
		System.out.println("/Spring/MVCListcontroller_R_TS ��  scri = " + scri);	
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
				
		scri.setPage(pagei);
		model.addAttribute("scri", scri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);
			
		list = bd.getBoardList_R_TS(scri, scri.getBidx());
		model.addAttribute("list", list);
		
//		System.out.println("/Spring/MVCListcontroller_R_TS ��  list : " + list);
		
		int cnt;
		try {
			cnt = bd.searchCountPaging_R(scri);
			
			System.out.println("/Spring/MVCListcontroller_R_TS ��  cnt = " + cnt);
			
			pageMaker.setTotalCount(cnt);
		} catch (Exception e) {
			pageMaker.setTotalCount(10);
			e.printStackTrace();
		}
			
		model.addAttribute("pageMaker", pageMaker);

		return "List_R_TS";
	}	
	
	
	
	@RequestMapping(value="/Spring/MVCContentcontroller")
	public String Content(
						  @ModelAttribute("page") String page,
						  @ModelAttribute("totalPage") String totalPage,
						  BoardVO bv,
						  MemberVO mv,
						  Message m,
						  SearchCriteria scri, 
						  Model model
						  ) throws SQLException {
		
		model.addAttribute("m", m); 
		model.addAttribute("mv", mv); 
		
		if (bv.getBidx() == 0) {    
			bv.setBidx(1);
		}
		
		System.out.println("/Sping/MVCContentcontroller�� Bidx = " + bv.getBidx());

		//  bv.setBidx(0);		// �׽�Ʈ��	

		// ������ bv�� ��� ���� ��� ����, ���н� bv.bidx�� 0�� ��ܿ´�. 
		try{
			bv = bd.getContent(bv.getBidx());
		}catch(Exception e){
			e.printStackTrace();
		}	
		model.addAttribute("bv", bv);		
   		
//   		System.out.println("/Spring/MVCContentcontroller�� bd : " + bd);
//   		System.out.println("/Spring/MVCContentcontroller�� bv : " + bv);
   		
   		if (bv.getBidx()==0) {
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
   				
		return "Content";
	}
	
	
	
	
	@RequestMapping(value="/Spring/MVCWritecontroller")
	public String Write (
				 		 @ModelAttribute("page") String page, 
						 @ModelAttribute("totalPage") String totalPage, 
						 Message m,
						 BoardVO bv,		
						 MemberVO mv,
						 Model model, 
						 SearchCriteria scri
						 ) throws SQLException {
		
		if (m.getRrds() == "") { 
			m.setRrds("0");
		}
		
		System.out.println("\n\nWritecontroller�� mv.name ="+mv.getName()+"\n\n");
	
		model.addAttribute("m", m);
		model.addAttribute("bv",bv);
		model.addAttribute("mv",mv);
			
		if (page.equals("")) page = "1";	
		if (totalPage.equals("")) totalPage = "1";		
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.getScri().setPage(totalPagei);		
		int cnt;
		try {
			cnt = bd.countPaging(scri);
			pageMaker.setTotalCount(cnt);
		} catch (Exception e) {
			pageMaker.setTotalCount(10);
			e.printStackTrace();
		}	
				
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("scri", scri);  //Write.jsp���� makeSearch() �޼ҵ带 ����ϱ� ���� �� �ʿ�
			
		return "Write";
	}
	
	

	@RequestMapping(value="/Spring/MVCWrite_Actioncontroller")
	public String Write_Action (
								@ModelAttribute("page") String page, 
								@ModelAttribute("totalPage") String totalPage,
								Model model, 
								BoardVO bv,
								MemberVO mv,
								Message m,
								SearchCriteria scri
								) {
		
		int idx = mv.getIdx();
		String name = mv.getName();
		
		System.out.println("\n\nWrite_Actioncontroller�� mv.name 1 ="+mv.getName()+"\n\n");
		
		try {
			name = URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		boolean isRedirect = false; 		
		m.setIsWright("Yes");
		m.setRrds("0");	
		String msg = "";
		int RRD;
		
		System.out.println("\n\n/Spring/Write_Actioncontroller�� mv.idx = "+mv.getIdx());
		System.out.println("/Spring/Write_Actioncontroller�� bv.idx = "+bv.getIdx()+"\n\n");
		System.out.println("/Spring/Write_Actioncontroller�� m.getRrds() = "+m.getRrds()+"\n\n");		
					
//		originbidx�� �켱 hidden ���� ������ ���� ����		
							
		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
		// subject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
		if (bv.getSubject() == "") {   			
			msg = "ó������ �����ϼ���.";
					
			System.out.println("\n\nWrite_Actioncontroller�� mv.name 2 ="+mv.getName()+"\n\n");
			return "forward:/Spring/MVCWritecontroller?msg="+msg;		
		}
					
		// �̺κп����� idx�� �Է� ���θ� üũ�� ����.
		if (bv.getIdx() == 0) {  
			msg = "idx�� �Է��ϼ���.";
			
			return "forward:/Spring/MVCWritecontroller?msg="+msg+"&idx="+idx+"&name="+name;
		} 
		
		System.out.println("1 /Spring/Write_Actioncontroller�� subject = "+bv.getSubject());
		System.out.println("1 /Spring/Write_Actioncontroller�� writer = "+bv.getWriter());

		String writedate = bd.CreateyyMMdd();
		String modifydate = bd.CreateyyMMdd();

		RRD = 0;
		int mmxidx = bd.MaxIdx();
		int nextbidx = mmxidx + 1;
					
		bv.setWritedate(writedate);
		bv.setModifydate(modifydate);

		try{
			RRD = bd.InsertDB(bv, nextbidx);
		} catch(Exception e){
			RRD = 0;
			e.printStackTrace();
		}								
      
		if (RRD == 1) {
			m.setRrds("1");
		} else if (RRD == 0){
			m.setRrds("0");
		}		      
			
//		m.setRrds("0");	//�׽�Ʈ��
		
		if (m.getRrds().equals("0") && m.getIsWright().equals("Yes")) {			
			isRedirect = false;
			m.setMsg("�۾��⿡ �����Ͽ����ϴ�.�ٽ�  �Է��ϼ���.");
			
		} else {
			isRedirect = true;
			m.setMsg("�ۼ��� ���� ����Ǿ����ϴ�.");
		    try {
				 bv.setSubject(URLEncoder.encode(bv.getSubject(), "UTF-8"));
				 bv.setWriter(URLEncoder.encode(bv.getWriter(), "UTF-8"));
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
			cnt = bd.searchCountPaging(scri);
			pageMaker.setTotalCount(cnt);
			totalPagei= pageMaker.getTotalPage();
			
			Integer i = new Integer(totalPagei);
			totalPage = i.toString();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
// 		�Ʒ��� �ʿ���� ����. �ֳĸ� ��ü ����Ʈ �׸����� ���ư��Ƿ� 
//		������������ ��Ż������ ������ �ʿ��� 
//		rttr.addAttribute("pageMaker", pageMaker);

		if (isRedirect) {				
		
			String subject = bv.getSubject();
			String writer = bv.getWriter();
			String rrds = m.getRrds();
			String isWrite = m.getIsWright();
			msg = m.getMsg();

			return "redirect:/Spring/MVCListcontroller_TS?subject="+subject+"&writer="			
			+writer+"&rrds="+rrds+"&isWrite="+isWrite+"&msg="+msg+"&page="+"1"+"&idx="+idx+"&name="+name;
			//descending���� �����Ͽ� �����ֹǷ� �ֱٿ� �ۼ��� ���� ������ 1�������� ��Ÿ����.		
		}else {
			msg = m.getMsg();
			return "forward:/Spring/MVCWritecontroller?page="+page+"&msg="+msg;
		}
	}	


	
	@RequestMapping(value="/Spring/MVCModifycontroller")
	public String Modify (
						  @ModelAttribute("page") String page,
						  BoardVO bv,
						  MemberVO mv,
						  Message m,
						  Model model,
						  SearchCriteria scri
						 ) throws SQLException {
	
		if (bv.getBidx() == 0) bv.setBidx(1);
			
		try{
			bv = bd.getContent(bv.getBidx());
		}catch(Exception e){
			e.printStackTrace();
		}		
//		bv.setBidx(0);   // �׽�Ʈ��
		
		model.addAttribute("bv", bv);					
		model.addAttribute("scri", scri);
		model.addAttribute("page", page);
		model.addAttribute("m", m);
		model.addAttribute("mv", mv);
			
  		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		model.addAttribute("pageMaker", pageMaker);
					 
		// �� �κ��� getContent()�Լ��� query ���н� bv.bidx�� 0 ��Ƽ� ������ ������
		 if (bv.getBidx() == 0) {		 
//			 model.addAttribute("bv_bidx", "0");  // �ƹ� �ǹ̵� ���°� �� �� ������??
			 return  "forward:/Spring/MVCListcontroller_TS";
		 } else {		
			 return "Modify";
		 }			
	}
	
	
	
	@RequestMapping(value="/Spring/MVCModify_Actioncontroller")
	public String Modify_Action (	
								 @ModelAttribute("page") String page, 
								 BoardVO bv,
								 MemberVO mv,
								 Message m,
								 RedirectAttributes rttr,
								 Model model,
								 SearchCriteria scri
								) {
		
		m.setIsUpdate("Yes");
		m.setRrds("0");

		int idx = mv.getIdx();
		String name = mv.getName();
		
		try {
			name = URLEncoder.encode(name, "UTF-8");	// �ѱ� ���� ����
		} catch (UnsupportedEncodingException en) {
			en.printStackTrace();
		}
		
		// �Ʒ����� ��� ��.							  
		//model.addAttribute("scri", scri); // page, searchType, keyword ����, List_TS.jsp�� ����

//		�Ʒ� ���� �� ����� ��										// redirect��
		rttr.addAttribute("searchType", scri.getSearchType());	// controller ���̿��� �Ķ���� ����
		rttr.addAttribute("keyword", scri.getKeyword());		// �ּ�â�� �Ķ���Ͱ� ǥ�õ��� �ʴ� post ���
							// return "rediect:/Srping/Contentcontroller_TS?page="+page ��� �ߺ� ����

		System.out.println("/Spring/MVCMoify_Actioncontroller�� idx = " + bv.getIdx());

		if (bv.getIdx() == 0) {
			String msg = "idx�� �Է��ϼ���.";
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg+"&idx="+idx+"&name="+name;
		}  
		
		if (bv.getBidx() == 0) {
			String msg = "ó������ �����ϼ���.";
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;
		}	
				
		System.out.println("Bidx = "+bv.getBidx());		
	
		int RRD = 0;
	    String modifydate = bd.CreateyyMMdd();

	    bv.setModifydate(modifydate);		    

		try {   
		    RRD = bd.UpdateDB (bv, bv.getBidx());	    
		} catch (Exception e) {
			RRD = 0;
			e.printStackTrace();
		}
		
	    if (RRD == 1) m.setRrds("1");
	    else m.setRrds("0"); 
	    
//			RRD = 0;		//�׽�Ʈ ��
	    	    
	    if (RRD == 0 && m.getIsUpdate() == "Yes") {		
	    	String msg = "������ �����Ͽ����ϴ�. �ٽ��Է��� �ֽʽÿ�.";	    	
			return "forward:/Spring/MVCModifycontroller?msg="+msg;	// �̷��� �ؾߵ�(forward : post���)
			
//				return "redirect:/Spring/MVCListcontroller_TS?msg="+msg; // �� : �̷��� �ϸ� �ѱ� ����(redired:get���)
			
		} else if (RRD == 1 && m.getIsUpdate() == "Yes"){			
			String msg = "�����Ͽ� �����Ͽ����ϴ�.";
			try {
				msg = URLEncoder.encode(msg, "UTF-8");	// �ѱ� ���� ����
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			int bidx = bv.getBidx();	// Bidx�� bidx�� ������.	// setter getter �Լ��� ��������� ��Īȣȯ ��Ģ�� ���� 
																// Bidx�� bidx�� ���� ������ ��޵� // �� �� Ȯ�� �ʿ�
			String isUpdate = m.getIsUpdate();
			String rrds = m.getRrds();
			return "redirect:/Spring/MVCContentcontroller?bidx="+bidx+"&rrds="+rrds		// ������Ʈ�� redirect��� ���
					+"&isUpdate="+isUpdate+"&msg="+msg+"&page="+page+"&idx="+idx+"&name="+name;
		} 
  
		return ""; //�ǹ� ����. �ƹ��ų� ����.
	}	
	
	
	
	@RequestMapping(value="/Spring/MVCDelete_Actioncontroller")
	public String Delete_Action (
								 @ModelAttribute("page") String page,
								 BoardVO bv,
								 MemberVO mv,
								 Message m,
								 SearchCriteria scri, 
								 RedirectAttributes rttr
//								 Model model
								)throws SQLException {
		
		int idx=mv.getIdx();
		String name=mv.getName();
		
		m.setIsDelete("Yes");	    
	    String msg = "";
	//	String rrds = "1";	//�׽�Ʈ ��
		m.setRrds("0");
	
//		bv.setIdx(2);  //�ӽ÷� ����   //�׽�Ʈ��
		
		if (bv.getIdx() == 0) {
			msg = "idx�� �Է��ϼ���.";
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg+"&idx="+idx+"&name="+name; // ����  ����???
		}
		//System.out.println("hidden idx = "+bv.getIdx());
		
//		bv.setBidx(0);	//�׽�Ʈ��
		
		if (bv.getBidx() == 0) {
			msg = "ó������ �����ϼ���.";
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;			
		}	
		
	    int RRD = 0;

	    RRD = bd.DeleteDB (bv.getBidx());  

//		RRD = 0;  // �׽�Ʈ ��   	    
	           
	    if (RRD == 1) m.setRrds("1");		    	
	    else if (RRD == 0) m.setRrds("0");
		 
	    if (RRD == 1) {						     
		   msg = "�ش���� ���� �Ͽ����ϴ�.";
				
		   PageMaker pageMaker = new PageMaker();				
		   pageMaker.setScri(scri);		
				
		   // �ۻ����� ����� �������� �ϳ� �پ�� ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
		   int cnt;
		   try {
			   cnt = bd.searchCountPaging(scri);
			   pageMaker.setTotalCount(cnt);
			   int totalPagei= pageMaker.getTotalPage();
			   int presentPagei = scri.getPage();
					
			   if (presentPagei > totalPagei) presentPagei = totalPagei;
			   scri.setPage(presentPagei);
											
			   Integer i = new Integer(presentPagei);
			   page = i.toString();					
		   } catch (Exception e) {
//  		   pageMaker.setTotalCount(10);
			   e.printStackTrace();
		   }
								
//		   model.addAttribute("pageMaker", pageMaker);
					
		   rttr.addAttribute("page", page);
		   rttr.addAttribute("searchType", scri.getSearchType());
		   rttr.addAttribute("keyword", scri.getKeyword());
		   rttr.addAttribute("rrds", m.getRrds());
		   rttr.addAttribute("isDelete", m.getIsDelete());
		   rttr.addAttribute("msg", msg);
		   rttr.addAttribute("idx", idx);
		   rttr.addAttribute("name", name);
		     		     
		   String rrds = m.getRrds();
		   String isDelete = m.getIsDelete();
		   	   
		   return "redirect:/Spring/MVCListcontroller_TS";
		     
		} else {
			 
//			 model.addAttribute("scri", scri);				 
			 msg = "������ �����Ͽ����ϴ�. �ٽ� �õ��ϼ���.";
			 
			 //request.setAttribute("Bidx", Bidx);			 
			 //model.addAttribute("bv", bv);
			 
//			 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page+"&searchType="+scri.getSearchType()+"&keyword="+scri.getKeyword();		     
			 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page;
		}					 			 
	}	

	
	
	@RequestMapping(value="/Spring/MVCReplycontroller")
	public String Reply (
						 @ModelAttribute("page") String page, 
						 @ModelAttribute("totalPage") String totalPage, 
						 BoardVO bv,
						 MemberVO mv,
						 Message m,
						 SearchCriteria scri,
						 Model model
						)throws SQLException {
		
		int idx = mv.getIdx();
		String name = mv.getName();
		
		try {
			name = URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		model.addAttribute("mv", mv);		
		model.addAttribute("scri", scri);

//		m.setRrds("0");	// �׽�Ʈ��
		
		model.addAttribute("m", m);	// Reply.jsp���� m.rrds�� üũ.
		
		if (totalPage.equals("")) totalPage = "1";	
		int totalPagei = Integer.parseInt(totalPage);
		
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		pageMaker.setTotalPage(totalPagei);
		model.addAttribute("pageMaker", pageMaker);
		
		if (bv.getBidx() == 0){
			bv.setBidx(1);
		}
		
		try{
			bv = bd.getContent(bv.getBidx());
		}catch(Exception e){
			e.printStackTrace();
		}

//		bv.setBidx(0);   // �׽�Ʈ��
		
		model.addAttribute("bv", bv);	// �̰� �ϳ��� ���
//		model.addAttribute("bidx", bv.getBidx());  // Reply_Actioncontroller�� ������ �뵵	
			 
		// �� �κ��� getContent()�Լ��� query ���н� bv.bidx�� 0 ��Ƽ� ������ ������
		if (bv.getBidx() == 0) {
			// �޽��� ���� ....
			return "forward:/Spring/MVCListcontroller_TS?page="+page+"&idx="+idx+"&name="+name; 
		} else {		
			return "Reply";
		}	 
	}			
	
	
	@Transactional
	@RequestMapping(value="/Spring/MVCReply_Actioncontroller")
	public String Reply_Action (
								@ModelAttribute("page") String page,
								@ModelAttribute("totalPage") String totalPage,
								BoardVO bv,
								MemberVO mv,
								Message m,
								SearchCriteria scri, 
								RedirectAttributes rttr,
								Model model								
							   )throws UnsupportedEncodingException {
		
		int idx = mv.getIdx();
		String name = mv.getName();
		
		try {
			name = URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		model.addAttribute("mv", mv);
		
		m.setIsReply("Yes");
		m.setRrds("0");
		int nextbidx = 1;
		String msg = "";
		int RRD = Integer.parseInt(m.getRrds());
		
		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
		// subject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
		if (bv.getSubject() == "") {   			
			msg = "ó������ �����ϼ���.";

			return "forward:/Spring/MVCWritecontroller?msg="+msg;		
		}

		// �̺κ��� ���α׷� ���߽� idx�� �Է� ���θ� üũ�� ����.
		if (bv.getIdx() == 0) {  
			msg = "idx�� �Է��ϼ���.";
			
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg+"&idx="+idx+"&name="+name;
		}
			
//		String writedate = bd.CreateyyMMdd();
		String modifydate = bd.CreateyyMMdd();

		RRD = 0;
		
		try {		
			int mmxidx = bd.MaxIdx();
			nextbidx = mmxidx + 1;								
			int nextupdowni=bv.getUpdown() + 1;
			int nextleftrighti=bv.getLeftright() + 1;	
			
			// ������������� �߻��Ǹ� RRD�� 0�� �Ǵ°� �ƴϰ� ������ ���� exception ó���� �ȴ�.
			RRD = bd.ReplyUpdateDB(bv.getOriginbidx(), bv.getUpdown());					
			System.out.println("ReplyUpdateDB �� ������  RRD = " + RRD);
			
			bv.setUpdown(nextupdowni);
			bv.setLeftright(nextleftrighti);
			bv.setModifydate(modifydate);
						
//			System.out.println("ReplyUpdateDB �� ���� �� bv.getWritedate() = " + bv.getWritedate());
//			System.out.println("ReplyUpdateDB �� ���� �� bv.getModifydate() = " + bv.getModifydate());
			
			RRD = bd.ReplyInsertDB(bv, nextbidx);										
			System.out.println("Reply InsertDB �� ������  RRD = " + RRD);
		} catch (Exception e) {
			RRD = 0;
			e.printStackTrace();
		}

		if (RRD == 1) {
			m.setRrds("1");
		} else if (RRD == 0){
			m.setRrds("0");
		}
      
//		model.addAttribute("m", m);
//		request.setAttribute("RRDS", RRDS);  // viewȭ����� �������� �ʿ�
//		request.setAttribute("isReply", isReply); // viewȭ����� �������� �ʿ�
//		���⼭�� get������� ��� ������
      		
//		RRD = 0;  //�׽�Ʈ��
		
		if (RRD == 0 && m.getIsReply() == "Yes") {
			
			msg = "����� �������� ���߽��ϴ�. �ٽ� �õ����ּ���.";	
			
			model.addAttribute("scri", scri);  //???				
			return "forward:/Spring/MVCReplycontroller?msg="+msg;	
		} else {	
			
			msg = "����� �����Ͽ����ϴ�.";
		
			try {
				bv.setSubject(URLEncoder.encode(bv.getSubject(), "UTF-8"));
				bv.setWriter(URLEncoder.encode(bv.getWriter(), "UTF-8"));
				msg = URLEncoder.encode(msg, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}  
		    System.out.println("/Spring/MVCListcontroller_R_TS�� ���ļ� List_R_TS.jsp�� ��");
				    		    
			if (totalPage.equals("")) totalPage = "1";	
			int totalPagei = Integer.parseInt(totalPage);
				
			PageMaker pageMaker = new PageMaker();				
			pageMaker.setScri(scri);
			pageMaker.getScri().setPage(totalPagei);		
			
//			SearchCriteria scri = new SearchCriteria();
//			pageMaker.setScri(scri);
			
			System.out.println("\nReply_Actioncontroller �� nextbidx = " + nextbidx);
			pageMaker.getScri().setBidx(nextbidx);
			
			
			if (page.equals("")) page = "1";	
			int pagei = Integer.parseInt(page);
			pageMaker.getScri().setPage(pagei);
			pageMaker.getScri().setSearchType(scri.getSearchType());
			pageMaker.getScri().setKeyword(scri.getKeyword());
			
//			model.addAttribute("bscri", bscri);
			
			// ��۾����� ����� �������� �ϳ� �þ ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
			int cnt;
			try {
				cnt = bd.searchCountPaging_R(pageMaker.getScri());
				pageMaker.setTotalCount(cnt);
				totalPagei= pageMaker.getTotalPage();
				
				Integer i = new Integer(totalPagei);
				totalPage = i.toString();					
			} catch (Exception e) {
				e.printStackTrace();
			}
				
//			��� ������ �ʿ���  // get?��� �Ǵ� post?������� ����  
//			rttr.addAttribute("pageMaker", pageMaker);
//			rttr.addAttribute("searchType", scri.getSearchType());
//			rttr.addAttribute("keyword", scri.getKeyword()); 
		    		    		    
			String searchType = pageMaker.getScri().getSearchType();
			String keyword = pageMaker.getScri().getKeyword();
			try {
				searchType = URLEncoder.encode(searchType, "UTF-8");
				keyword = URLEncoder.encode(keyword, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}  
			
			String subject = bv.getSubject();
			String writer = bv.getWriter();
			String rrds = m.getRrds();
			String isReply = m.getIsReply();
				
		    return "redirect:/Spring/MVCListcontroller_R_TS?subject="+subject+"&writer="
		    		  +writer+"&rrds="+rrds+"&isReply="+isReply+"&msg="+msg+"&idx="+idx+"&name="+name
		    		  +"&page="+page+"&totalPage="+totalPage
		    		  +"&searchType="+searchType+"&keyword="+keyword+"&bidx="+nextbidx;  
		}
	}	
	
	
	
	
	
//	@RequestMapping(value="/Spring/MVCListcontroller")
//	public String List(HttpServletRequest request, 
//					   HttpServletResponse response, 
//					   @ModelAttribute("rediredt_msg") String rediredt_msg, 
//					   Model model 
//					   ) throws SQLException {
//		
//		//RedirectAttribute �׽�Ʈ��
//		logger.info("\n\nList() called...�ѱ�  ����  ..." + rediredt_msg + "\n\n");
//				
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		response.setCharacterEncoding("UTF-8");
//
//		String subject= request.getParameter("subject");
//		String writer= request.getParameter("writer");	
//		String content= request.getParameter("content");	
//		
//		String RRDS= request.getParameter("RRDS");
//		String isWright= request.getParameter("isWright");
//		String isReply= request.getParameter("isReply");
//		String isDelete = (String) request.getAttribute("isDelete");
//		String msg = request.getParameter("msg");
////  	String Bidx= request.getParameter("Bidx");
//	
//		//setAttribute �Ӽ��� ��´�.
//		request.setAttribute("RRDS", RRDS);  // �׳� �߰踸 ���ش�.
//		request.setAttribute("isWright", isWright); // �׳� �߰踸 ���ش�.
//		request.setAttribute("isReply", isWright); // �׳� �߰踸 ���ش�.		
//		request.setAttribute("msg", msg); // �׳� �߰踸 ���ش�.	
//
//		if (subject == null) subject = "";
//		if (content == null) content = "";
//		if (writer == null) writer = "";	
//		if (RRDS == null) RRDS = "0";
////		if (Bidx == null) Bidx = "1";
//			
//		try {
//			subject = URLDecoder.decode(subject, "UTF-8");
//			writer = URLDecoder.decode(writer, "UTF-8");	
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		request.setAttribute("subject", subject);
//		request.setAttribute("writer", writer);
////		request.setAttribute("Bidx", Bidx);  // �׳� �߰踸 ���ش�.
//		
//		
//		// Spring MVC�� Model��ü ��� ����
//		CheckLineVO checkLine = new CheckLineVO(subject, writer);
//		model.addAttribute(checkLine);
//			
//		System.out.println("/Spring/MVCListcontroller�� bd = " + bd);
//		
//		ArrayList<BoardVO> list = bd.getBoardList();
//		request.setAttribute("list", list);
//		
//		System.out.println("/Spring/MVCListcontroller ��  list : " + list);
//		
////		 conn.close();  // pool�� ���� ����.  �̰����� ���� ���� �ƴϰ� BoardDAO���� ���� ��
//		 
//		 if (RRDS == "1" && isDelete == "Yes") {
//			 
//			 return "List";
//		 
//		 } else if (RRDS == "0" && isDelete == "Yes") {
//			 
//			 return "/Spring/MVCWrirtecontroller";	
//			
//		 } else {
//			 return "List";
//		 } 
//		 
////		 forward ��Ŀ����� �Ķ������ �߰�� �ʿ����. sendRediret��Ŀ����� �߰谡 �ʿ��ϴ�.		
//	}
//	
//	
//	
//	@RequestMapping(value="/Spring/MVCListcontroller_T")
//	public String List_T(HttpServletRequest request, 
//						 HttpServletResponse response, 
//						 @ModelAttribute("rediredt_msg") String rediredt_msg, 
//						 @ModelAttribute("page") String page, 
//						 @ModelAttribute("searchType") String searchType, 
//						 @ModelAttribute("keyword") String keyword, Model model, 
//						 Criteria cri, 
//						 SearchCriteria scri
//						 ) throws SQLException {
//		
//		//RedirectAttribute �׽�Ʈ��
//		logger.info("\n\nList_T() called...�ѱ�  ����  ..." + rediredt_msg + "\n\n");
//				
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		response.setCharacterEncoding("UTF-8");
//
//		String subject= request.getParameter("subject");
//		String writer= request.getParameter("writer");	
//		String content= request.getParameter("content");		
//		String RRDS= request.getParameter("RRDS");
//		String isWright= request.getParameter("isWright");
//		String isReply= request.getParameter("isReply");
//		String isDelete = (String) request.getAttribute("isDelete");
//		String msg = request.getParameter("msg");
////  	String Bidx= request.getParameter("Bidx");
//	
//		//setAttribute �Ӽ��� ��´�.
//		request.setAttribute("RRDS", RRDS);  // �׳� �߰踸 ���ش�.
//		request.setAttribute("isWright", isWright); // �׳� �߰踸 ���ش�.
//		request.setAttribute("isReply", isWright); // �׳� �߰踸 ���ش�.		
//		request.setAttribute("msg", msg); // �׳� �߰踸 ���ش�.	
//
//		if (subject == null) subject = "";
//		if (content == null) content = "";
//		if (writer == null) writer = "";	
//		if (RRDS == null) RRDS = "0";
////		if (Bidx == null) Bidx = "1";
//		
//		try {
//			subject = URLDecoder.decode(subject, "UTF-8");
//			writer = URLDecoder.decode(writer, "UTF-8");	
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		request.setAttribute("subject", subject);
//		request.setAttribute("writer", writer);
////		request.setAttribute("Bidx", Bidx);  // �׳� �߰踸 ���ش�.
//		
//		
//		// Spring MVC�� Model��ü ��� ����
//		CheckLineVO checkLine = new CheckLineVO(subject, writer);
//		model.addAttribute(checkLine);
//			
//		System.out.println("/Spring/MVCListcontroller_T�� bd = " + bd);
//		
////		Criteria cri = new Criteria();
////		cri.setPage(10);
////		cri.setPerPageNum(20);
//		
//		System.out.println("\n\nList_T Controller �� cri.page number = " + cri.getPage() + "");
//		System.out.println("List_T Controller �� searchType = " +searchType + "");
//		System.out.println("List_T Controller �� keyword = " + keyword + "\n\n");
//		
//		
//		int pagei = 1;
//		
//		if (page.equals("")) pagei = 1;	
//		else pagei = Integer.parseInt(page);
//		
//		
//		cri.setPage(pagei);
//		
//		
//		ArrayList<BoardVO> list = bd.getBoardList_T(cri);
//		request.setAttribute("list", list);
//		
//		System.out.println("/Spring/MVCListcontroller_T ��  list : " + list);
//		
//		
//		PageMaker pageMaker = new PageMaker();
//		
//		pageMaker.setCri(cri);
//		int cnt;
//		try {
//			cnt = bd.countPaging(cri);
//			pageMaker.setTotalCount(cnt);
//		} catch (Exception e) {
//			pageMaker.setTotalCount(10);
//			e.printStackTrace();
//		}
//		
//		
//		model.addAttribute("pageMaker", pageMaker);
//		
////		 conn.close();  // pool�� ���� ����.  �̰����� ���� ���� �ƴϰ� BoardDAO���� ���� ��
//		 
//		 if (RRDS == "1" && isDelete == "Yes") {
//			 
//			 return "List_T";
//		 
//		 } else if (RRDS == "0" && isDelete == "Yes") {
//			 
//			 return "/Spring/MVCWrirtecontroller?page=${page}";	
//			
//		 } else {
//			 return "List_T";
//		 } 
//		 
////		 forward ��Ŀ����� �Ķ������ �߰�� �ʿ����. sendRediret��Ŀ����� �߰谡 �ʿ��ϴ�.		
//	}

		
	
//	@RequestMapping(value="/Spring/MVCListcontroller_TS")
//	public String List_TS(
//						@ModelAttribute("page") String page,
//						@ModelAttribute("totalPage") String totalPage,
//						Model model,
//						ArrayList<BoardVO> list,
//						BoardVO bv,
//						Message m,
//						SearchCriteria scri
//						) throws SQLException {
//	
//		
////		System.out.println("\n\n/Spring/MVCListcontroller_TS�� page = "+page);
////		System.out.println("/Spring/MVCListcontroller_TS�� totalPage = "+totalPage);	
////		System.out.println("/Spring/MVCListcontroller_TS�� scri.searchType = "+scri.getSearchType());
////		System.out.println("/Spring/MVCListcontroller_TS�� scri.keyword = "+scri.getKeyword()+"\n\n");
//					
//		//addAttribute �Ӽ��� ��´�.
//		model.addAttribute("m", m);  
//		
////		try {
////			bv.setSubject(URLDecoder.decode(bv.getSubject(), "UTF-8"));
////			bv.setWriter(URLDecoder.decode(bv.getWriter(), "UTF-8"));	
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
//			
//		model.addAttribute("bv", bv);		
////		model.addAttribute("subject", subject);
////		model.addAttribute("writer", writer);
//
////		System.out.println("/Spring/MVCListcontroller_TS�� bd = " + bd);	
////		System.out.println("List_TS Controller �� scri.searchType = " +scri.getSearchType() + "");
////		System.out.println("List_TS Controller �� scri.keyword = " + scri.getKeyword() + "");
////		System.out.println("List_TS Controller �� scri.page = " + scri.getPage() + "\n\n");
//		
//		
//		int pagei = 1;		
//		if (page.equals("")) pagei = 1;	
//		else pagei = Integer.parseInt(page);
//		
//		scri.setPage(pagei);
//		model.addAttribute("scri", scri);
//		
//		list = bd.getBoardList_TS(scri);
//		model.addAttribute("list", list);
//		
//		System.out.println("/Spring/MVCListcontroller_TS ��  list : " + list);
//		
//		SearchPageMaker searchPageMaker = new SearchPageMaker();
//		searchPageMaker.setScri(scri);
//		int cnt;
//		try {
//			cnt = bd.searchCountPaging(scri);
//			searchPageMaker.setTotalCount(cnt);
//		} catch (Exception e) {
//			searchPageMaker.setTotalCount(10);
//			e.printStackTrace();
//		}		
//		model.addAttribute("searchPageMaker", searchPageMaker);
//		 
//		 if (m.getRrds().equals("1") && m.getIsDelete().equals("Yes")) {		 
//			 return "List_TS";
//		 } else if (m.getRrds().equals("0") && m.getIsDelete().equals("Yes")) {			 
//			 return "/Spring/MVCWrirtecontroller?page=${page}";	
//		 } else {
//			 return "List_TS";
//		 } 		 	
//	}
	
	


//	@RequestMapping(value="/Spring/MVCListcontroller_R_TS")
//	public String List_R_TS(
//						HttpServletRequest request, 
//						HttpServletResponse response, 
//						@ModelAttribute("page") String page,
//						@ModelAttribute("totalPage") String totalPage,
//						Model model,
//						@ModelAttribute("bscri") BidxSearchCriteria bscri
//						) throws SQLException {
//		
//		System.out.println("\n\n/Spring/MVCListcontroller_R_TS�� page = "+page);
//		System.out.println("/Spring/MVCListcontroller_R_TS�� totalPage = "+totalPage);	
//		System.out.println("/Spring/MVCListcontroller_R_TS�� bscri.searchType = "+bscri.getSearchType());
//		System.out.println("/Spring/MVCListcontroller_R_TS�� bscri.keyword = "+bscri.getKeyword()+"");
//		System.out.println("/Spring/MVCListcontroller_R_TS�� bscri.nextbidx = "+bscri.getKeyword()+"\n\n");
//		
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		response.setCharacterEncoding("UTF-8");
//
//		String subject= request.getParameter("subject");
//		String writer= request.getParameter("writer");	
//		String content= request.getParameter("content");		
//		String RRDS= request.getParameter("RRDS");
//		String isWright= request.getParameter("isWright");
//		String isReply= request.getParameter("isReply");
//		String isDelete = (String) request.getAttribute("isDelete");
//		String msg = request.getParameter("msg");
////		String Bidx= request.getParameter("Bidx");  //���� �ʿ� ���� bscri�� ��ܿ�
//	
//		//setAttribute �Ӽ��� ��´�.
//		request.setAttribute("RRDS", RRDS);  // �׳� �߰踸 ���ش�.
//		request.setAttribute("isWright", isWright); // �׳� �߰踸 ���ش�.
//		request.setAttribute("isReply", isWright); // �׳� �߰踸 ���ش�.		
//		request.setAttribute("msg", msg); // �׳� �߰踸 ���ش�.	
//
//		if (subject == null) subject = "";
//		if (content == null) content = "";
//		if (writer == null) writer = "";	
//		if (RRDS == null) RRDS = "0";	
//		
////		if (Bidx == null) Bidx = "1";  	//List_R_TS ������ �� �ʿ�  // �� ���� �ʿ�
////		if (Bidx == "") Bidx = "1";		//List_R_TS ������ �� �ʿ�	// �� ���� �ʿ�
////		int Bidxi = Integer.parseInt(Bidx);		
//		
//		try {
//			subject = URLDecoder.decode(subject, "UTF-8");
//			writer = URLDecoder.decode(writer, "UTF-8");	
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		request.setAttribute("subject", subject);
//		request.setAttribute("writer", writer);
////		request.setAttribute("Bidx", Bidx);  // �׳� �߰踸 ���ش�.
//				
//		// Spring MVC�� Model��ü ��� ����
//		CheckLineVO checkLine = new CheckLineVO(subject, writer);
//		model.addAttribute(checkLine);
//		
//		System.out.println("/Spring/MVCListcontroller_R_TS�� bd = " + bd);
//
//		System.out.println("List_R_TS Controller �� scri.searchType = " +bscri.getSearchType() + "");
//		System.out.println("List_R_TS Controller �� scri.keyword = " + bscri.getKeyword() + "");
//		System.out.println("List_R_TS Controller �� scri.page = " + bscri.getPage() + "\n\n");
//			
//		int pagei = 1;		
//		if (page.equals("")) pagei = 1;	
//		else pagei = Integer.parseInt(page);
//				
//		bscri.setPage(pagei);
//		model.addAttribute("bscri", bscri);
//		
////		BidxSearchCriteria bscri = new BidxSearchCriteria();
//	//	bscri.setBidx(Bidxi);	
//		bscri.setPage(pagei);
////		bscri.setSearchType(bscri.getSearchType());
////		bscri.setKeyword(bscri.getKeyword());
//		
//		SearchPageMaker searchPageMaker = new SearchPageMaker();
//		searchPageMaker.setBscri(bscri);
//		
//		System.out.println("\n/Spring/MVCListcontroller_R_TS ��  bscri.bidx before : " + bscri.getBidx());
//		
//		ArrayList<BoardVO> list = bd.getBoardList_R_TS(bscri, bscri.getBidx());
//		request.setAttribute("list", list);
//		
//		System.out.println("/Spring/MVCListcontroller_R_TS ��  list : " + list);
//		
//		System.out.println("\n/Spring/MVCListcontroller_R_TS ��  bscri.bidx after : " + bscri.getBidx());
//		
//		int cnt;
//		try {
//			cnt = bd.searchCountPaging_R(bscri);
//			
//			System.out.println("Reply_Actioncontroller�� cnt = " + cnt);
//			
//			searchPageMaker.setTotalCount_R(cnt);
//		} catch (Exception e) {
//			searchPageMaker.setTotalCount_R(10);
//			e.printStackTrace();
//		}
//			
//		model.addAttribute("searchPageMaker", searchPageMaker);
//		 
//		 if (RRDS == "1" && isDelete == "Yes") {			 
//			 return "List_R_TS";		 
//		 } else if (RRDS == "0" && isDelete == "Yes") {			 
//			 return "/Spring/MVCWrirtecontroller?page=${page}";				
//		 } else {
//			 return "List_R_TS";
//		 } 		 
////		 forward ��Ŀ����� �Ķ������ �߰�� �ʿ����. sendRediret��Ŀ����� �߰谡 �ʿ��ϴ�.		
//	}
	
	
	
	
//	@RequestMapping(value="/Spring/MVCContentcontroller")
//	public String Content(HttpServletRequest request, HttpServletResponse response,
//						@ModelAttribute("page") String page,
//						@ModelAttribute("totalPage") String totalPage,
//						SearchCriteria scri, Model model) throws SQLException {
//		
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}	
//
//		String Bidx = (String)request.getParameter("Bidx"); 
//		String msg = request.getParameter("msg");
//		String RRDS= request.getParameter("RRDS");
//		String isUpdate = (String)request.getAttribute("isUpdate");  // �߰踸 ���ش�.	
//		int Bidxi = Integer.parseInt(Bidx);
//		
//		request.setAttribute("msg", msg);
////		request.setAttribute("Bidx", Bidx);
//		request.setAttribute("RRDS", RRDS);
//		request.setAttribute("isUpdate", isUpdate);
//		
//		if (Bidx == null) {    // �� ���ڵ常 �� ������????  
//			Bidx = "1";		//sendRedirect�� ���� ������ null�� endoding�� �ȸ¾Ƽ� �׷���? 
//		} 
//		
//		Bidxi = 1;		
//		if (Bidx.equals("0")) {    // �� �ڵ�� �Դ´�.
//			Bidx = "1";
//		}
//		
//		System.out.println("/Sping/MVCContentcontroller�� Bidx = " + Bidx);
//		Bidxi = Integer.parseInt(Bidx);
//		System.out.println("/Spring/MVCContentcontroller�� Bidxx = " + Bidxi);
//		
//		//	Bidxx = 0;	  // �׽�Ʈ��	
//		
//		// ������ bv�� ��� ���� ��� ����, ���н� bv.bidx�� 0�� ��ܿ´�. 
//		BoardVO bv = new BoardVO();
//		try{
//			bv = bd.getContent(Bidxi);
//		}catch(Exception e){
//			e.printStackTrace();
//		}			
//		request.setAttribute("bv", bv);    
//   		
//   		System.out.println("/Spring/MVCContentcontroller�� bd : " + bd);
//   		System.out.println("/Spring/MVCContentcontroller�� bv : " + bv);
//   		
//   		if (bv.getBidx()==0) {
//   			msg = "�ش� �׸��� �������� �ʽ��ϴ�.";
//   			request.setAttribute("msg", msg);
//   		} 
//   			
//   		if (page.equals("")) page = "1";	
//   		model.addAttribute("scri", scri);
//   		
//		if (totalPage.equals("")) totalPage = "1";	
//		int totalPagei = Integer.parseInt(totalPage);
//   
//   		SearchPageMaker searchPageMaker = new SearchPageMaker();	
//		searchPageMaker.setScri(scri);
//		searchPageMaker.setTotalPage(totalPagei);
//		model.addAttribute("searchPageMaker", searchPageMaker);
//   				
//		return "Content";
//	}
	

	
//	@RequestMapping(value="/Spring/MVCWritecontroller")
//	public String Write (
////						 HttpServletRequest request, 
////						 HttpServletResponse response, 
//				 		 @ModelAttribute("page") String page, 
//						 @ModelAttribute("totalPage") String totalPage, 
//						 Message m,
//						 BoardVO bv,		
//						 MemberVO mv,
//						 Model model, SearchCriteria scri
//						 ) throws SQLException {
//		
////		try {
////			request.setCharacterEncoding("UTF-8");
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
//		
////		String RRDS= request.getParameter("RRDS");
////		String isWrite= request.getParameter("isWrite");
//
//		//bv.setIdx(6);		
//		if (m.getRrds() == null) { 
//			m.setRrds("0");
//		}
//
//		
////		MemberVO mv = new MemberVO();
////		mv.setName();
//		
//		System.out.println("\n\n/Spring/Write Controller�� mv.idx = "+mv.getIdx());
//		System.out.println("\n\n/Spring/Write Controller�� mv.name = "+mv.getName());
//		System.out.println("Write Controller �� bv.idx = " + bv.getIdx() + "\n\n");
//		
//		//setAttribute �Ӽ��� ��´�.
//		model.addAttribute("m", m);
//		model.addAttribute("bv",bv);
//		model.addAttribute("mv",mv);
//			
//		System.out.println("\n\n Write Controller �� page number = " + page + "");
//		System.out.println(" Write Controller �� totalPage number = " + totalPage + "");	
//		System.out.println(" Write Controller �� searchType = " + scri.getSearchType() + "");
//		System.out.println(" Write Controller �� keyword = " + scri.getKeyword() + "\n\n");					
//
//		System.out.println("\nWritecontroller�� totalPage before = "+totalPage+"\n");
//		
//		if (page.equals("")) page = "1";	
//		if (totalPage.equals("")) totalPage = "1";		
//		int totalPagei = Integer.parseInt(totalPage);
//		
//		SearchPageMaker searchPageMaker = new SearchPageMaker();	
//		searchPageMaker.setScri(scri);
//		searchPageMaker.getScri().setPage(totalPagei);		
//		int cnt;
//		try {
//			cnt = bd.countPaging(scri);
//			searchPageMaker.setTotalCount(cnt);
//		} catch (Exception e) {
//			searchPageMaker.setTotalCount(10);
//			e.printStackTrace();
//		}	
//		
//		System.out.println("\nWritecontroller�� totalPage after = "+totalPage+"\n");
//		
//		model.addAttribute("searchPageMaker", searchPageMaker);
//		model.addAttribute("scri", scri);   //���ʿ������� ������� 
//		           // Write.jps�� searchType�� keyword�� ���� ����
//		//Write.jsp���� makeSearch() �޼ҵ带 ����ϱ� ���� ������ �� �ʿ�
//			
//		return "Write";
//	}
//	
//	
//
//	@RequestMapping(value="/Spring/MVCWrite_Actioncontroller")
//	public String Write_Action (
//								HttpServletRequest request, 
////								HttpServletResponse response,
//								@ModelAttribute("page") String page, 
//								@ModelAttribute("totalPage") String totalPage,
////								RedirectAttributes rttr,
//								Model model, 
//								BoardVO bv,
//								MemberVO mv,
//								Message m,
//								SearchCriteria scri
//								) {
//		
//		boolean isRedirect = false; 		
//		m.setIsWright("Yes");
//		
////		String RRDS = "0";		
////		String msg = "";
//		
//		int idxx = 0;
//		
//		
//		System.out.println("\n\n/Spring/Write_Actioncontroller�� mv.idx = "+mv.getIdx());
//		System.out.println("/Spring/Write_Actioncontroller�� bv.idx = "+bv.getIdx()+"\n\n");
//		
//		
////		rttr.addFlashAttribute("rediredt_msg", "RedirectAttribute Example Messsage!");
//	
////		try {
////			request.setCharacterEncoding("UTF-8");
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
////		response.setCharacterEncoding("UTF-8");
//									
//													// originbidx�� �켱 hidden ���� ������ ���� ����
//		
////		String originbidx = request.getParameter("originbidx");  
////		String updown = request.getParameter("updown");
////		String leftright = request.getParameter("leftright");
////		String subject= request.getParameter("subject");
////		String content= request.getParameter("content");
////		String writer= request.getParameter("writer");
//
//		String inidx = request.getParameter("idx");	
//		m.setRrds(request.getParameter("RRD"));
//		
//		if (m.getRrds() == null) m.setRrds("0");
//		
////		bv.setSubject("Test");  // idx �Է� �׽�Ʈ��
////		m.setRrds("0");		    // idx �Է� �׽�Ʈ��
//		
//		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
//		// ���⼭�� idx��� subject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
//		if (bv.getSubject() == null) {   			
//			m.setMsg("ó������ �����ϼ���.");
//			return "forward:/Spring/MVCWritecontroller";			
//		} else if (bv.getSubject() != null) {			
//			int RRD = Integer.parseInt(m.getRrds());			
//	
//			
////			System.out.println("Write_Actioncontroller�� inidx = "+inidx);		
//
//			if (inidx == null) {  
//				// �̺κ��� member20 ���̺�� �����Ͽ� ��¥ idx�� �Է� ���θ� üũ�� ����. �����				
//				m.setMsg("idx�� �Է��ϼ���");
//				return "forward:/Spring/MVCWritecontroller"; 	
//			} else {  
//				idxx = Integer.parseInt(inidx);
//	
//				System.out.println("idx = "+inidx);
//				System.out.println("1 /Spring/Write_Actioncontroller�� subject = "+bv.getSubject());
//				System.out.println("1 /Spring/Write_Actioncontroller�� writer = "+bv.getWriter());
//
//				String writedate = bd.CreateyyMMdd();
//				String modifydate = bd.CreateyyMMdd();
//
//				RRD = 0;
//				int mmxidx = bd.MaxIdx();
//				int nextbidx = mmxidx + 1;
//				
////				BoardVO bv = new BoardVO();   // @Repository��ĵ� �̿��� ����
//				
////				bv.setSubject(subject);
////				bv.setContent(content);
////				bv.setWriter(writer);
//				
//				bv.setWritedate(writedate);
//				bv.setModifydate(modifydate);
//				bv.setIdx(idxx);
//
//				try{
//					RRD = bd.InsertDB(bv, nextbidx);
//				} catch(Exception e){
//					RRD = 0;
//					e.printStackTrace();
//				}								
//				//System.out.println("\n\n/Spring/MVCWrite_Actioncontroller�� RRD = " + RRD + "\n\n");
//		      
//				if (RRD == 1) {
//					m.setRrds("1");
//				} else if (RRD == 0){
//					m.setRrds("0");
//				}		      
//			} // end of the first of the second if
//			
//			if (m.getRrds().equals("0") && m.getIsWright().equals("Yes")) {			
//				isRedirect = false;
//				m.setMsg("�۾��⿡ �����Ͽ����ϴ�.�ٽ�  �Է��ϼ���.");
//				model.addAttribute("mv", mv);
//			} else {
//				//DB�� ������ �ٲ�����Ƿ� forward ����� ���� ���� sendRedirect ����� ��� 
//		     	//�������� ���� ��ħ�� Ȯ���� �Ǿ� ���ο� �������� �ݿ��� ����ȴ�.
//				isRedirect = true;
//				
//				if (bv.getSubject() == null) bv.setSubject("");
//				if (bv.getWriter() == null) bv.setWriter("");
//				m.setMsg("�ۼ��� ���� ����Ǿ����ϴ�.");
//				
//				System.out.println("2 /Spring/Write_Actioncontroller�� subject = "+bv.getSubject());
//				System.out.println("2 /Spring/Write_Actioncontroller�� writer = "+bv.getWriter());				
//				
//			    try {
//					 bv.setSubject(URLEncoder.encode(bv.getSubject(), "UTF-8"));
//					 bv.setWriter(URLEncoder.encode(bv.getWriter(), "UTF-8"));
//					 m.setMsg(URLEncoder.encode(m.getMsg(), "UTF-8"));
//				} catch (UnsupportedEncodingException e) {
//					 e.printStackTrace();
//				}
//			    
//			} // end of the second of the second if
//			
//		} // end of the first if
//			
//		model.addAttribute("m", m);
//		
////		request.setAttribute("msg", msg);
//		
//		System.out.println("/Spring/Write_Actioncontroller�� msg = "+m.getMsg());	
//		System.out.println("\n\n Write_Action Controller �� totalPage number = " + totalPage + "\n\n");				
//		
//		if (totalPage.equals("")) totalPage = "1";	
//		int totalPagei = Integer.parseInt(totalPage);
//			
//		SearchPageMaker searchPageMaker = new SearchPageMaker();
//		
//		searchPageMaker.setScri(scri);
//		searchPageMaker.getScri().setPage(totalPagei);		
//		
//		// �۾����� ����� �������� �ϳ� �þ ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
//		// descending���� �����Ͽ� �ֱٰ��� �տ� �����ֹǷ� �� ������ �Ϳ� �ش��ϴ� totalCount�� ����� �ǹ̾���
//		int cnt;
//		try {
//			cnt = bd.searchCountPaging(scri);
//			searchPageMaker.setTotalCount(cnt);
//			totalPagei= searchPageMaker.getTotalPage();
//			
//			Integer i = new Integer(totalPagei);
//			totalPage = i.toString();					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//// 		�Ʒ��� �ʿ���� ����. �ֳĸ� ��ü ����Ʈ �׸����� ���ư��Ƿ� 
////		������������ ��Ż������ ������ �ʿ��� // ù��° ������ �� �Ʒ� �ΰ��� ��ü ������	
////		rttr.addAttribute("searchPageMaker", searchPageMaker);
////		rttr.addAttribute("searchType", scri.getSearchType());
////		rttr.addAttribute("keyword", scri.getKeyword());
//				
//		if (isRedirect) {				
//
////			return "redirect:/Spring/MVCListcontroller";	//RedirectAttribute �׽�Ʈ��
//							
////		    rttr.addAttribute("page", totalPage);
////		    rttr.addFlashAttribute("RRDS", RRDS);
////		    rttr.addFlashAttribute("subject", subject);
////		    rttr.addFlashAttribute("writer", writer);
////		    rttr.addFlashAttribute("isWrite", isWrite);
////		    rttr.addFlashAttribute("msg", msg);
//			
//			
////			return "redirect:/Spring/MVCListcontroller_TS?subject="+subject+"&writer="
////							+writer+"&RRDS="+RRDS+"&isWrite="+isWrite+"&msg="+msg+"&page="+totalPage;
////				//ascending���� �����Ͽ� �����ֹǷ� �ֱٿ� �ۼ��� ���� ������ totalPage(�ǵ�������)�� ��Ÿ����.
//			
//			String subject = bv.getSubject();
//			String writer = bv.getWriter();
//			String RRDS = m.getRrds();
//			String isWrite = m.getIsWright();
//			String msg = m.getMsg();
//			int idx = mv.getIdx();
//			String name = mv.getName();
//			try {
//				name = URLEncoder.encode(name, "utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			
//			return "redirect:/Spring/MVCListcontroller_TS?subject="+subject+"&writer="			
//			+writer+"&RRDS="+RRDS+"&isWrite="+isWrite+"&msg="+msg+"&page="+"1"+"&idx="+idx+"&name="+name;
//				//descending���� �����Ͽ� �����ֹǷ� �ֱٿ� �ۼ��� ���� ������ 1�������� ��Ÿ����.		
//		}else {
//			return "forward:/Spring/MVCWritecontroller?page="+page;
//		}
//	}	


	
	
//	@RequestMapping(value="/Spring/MVCWritecontroller")
//	public String Write (
//				 		 @ModelAttribute("page") String page, 
//						 @ModelAttribute("totalPage") String totalPage, 
//						 Message m,
//						 BoardVO bv,		
//						 MemberVO mv,
//						 Model model, SearchCriteria scri
//						 ) throws SQLException {
//
//		// bv.setIdx(11);	
//		// mv.setIdx(11);
//		// mv.setName();
//		
//		if (m.getRrds() == null) { 
//			m.setRrds("0");
//		}
//	
////		System.out.println("\n\n/Spring/Write Controller�� mv.idx = "+mv.getIdx());
////		System.out.println("/Spring/Write Controller�� mv.name = "+mv.getName());
////		System.out.println("/Spring/Write Controller �� bv.idx = " + bv.getIdx() + "\n\n");
//		
//		//setAttribute �Ӽ��� ��´�.
//		model.addAttribute("m", m);
//		model.addAttribute("bv",bv);
//		model.addAttribute("mv",mv);
//			
////		System.out.println("\n\n/Spring/Write Controller �� page number = " + page + "");
////		System.out.println("/Spring/Write Controller �� totalPage number = " + totalPage + "");	
////		System.out.println("/Spring/Write Controller �� searchType = " + scri.getSearchType() + "");
////		System.out.println("/Spring/Write Controller �� keyword = " + scri.getKeyword() + "\n\n");					
////
////		System.out.println("\n/Spring/Writecontroller�� totalPage before = "+totalPage+"\n");
//		
//		if (page.equals("")) page = "1";	
//		if (totalPage.equals("")) totalPage = "1";		
//		int totalPagei = Integer.parseInt(totalPage);
//		
//		SearchPageMaker searchPageMaker = new SearchPageMaker();	
//		searchPageMaker.setScri(scri);
//		searchPageMaker.getScri().setPage(totalPagei);		
//		int cnt;
//		try {
//			cnt = bd.countPaging(scri);
//			searchPageMaker.setTotalCount(cnt);
//		} catch (Exception e) {
//			searchPageMaker.setTotalCount(10);
//			e.printStackTrace();
//		}	
//		
////		System.out.println("\nWritecontroller�� totalPage after = "+totalPage+"\n");
//		
//		model.addAttribute("searchPageMaker", searchPageMaker);
//		model.addAttribute("scri", scri);   //���ʿ������� ������� 
//		           // Write.jps�� searchType�� keyword�� ���� ����
//		//Write.jsp���� makeSearch() �޼ҵ带 ����ϱ� ���� ������ �� �ʿ�
//			
//		return "Write";
//	}
//	
//	
//
//	@RequestMapping(value="/Spring/MVCWrite_Actioncontroller")
//	public String Write_Action (
////								HttpServletRequest request, 
////								HttpServletResponse response,
//								@ModelAttribute("page") String page, 
//								@ModelAttribute("totalPage") String totalPage,
////								RedirectAttributes rttr,
//								Model model, 
//								BoardVO bv,
//								MemberVO mv,
//								Message m,
//								SearchCriteria scri
//								) {
//		
//		boolean isRedirect = false; 		
//		m.setIsWright("Yes");
//		m.setRrds("0");
//		
//		System.out.println("\n\n/Spring/Write_Actioncontroller�� mv.idx = "+mv.getIdx());
//		System.out.println("/Spring/Write_Actioncontroller�� bv.idx = "+bv.getIdx()+"\n\n");
//		System.out.println("/Spring/Write_Actioncontroller�� m.getRrds() = "+m.getRrds()+"\n\n");		
//		
////	@@@@@@@@  �����  %Flash%	  rttr.addFlashAttribute("rediredt_msg", "RedirectAttribute Example Messsage!");   @@@@@@@@@@@@@@
//	
//			
//		// originbidx�� �켱 hidden ���� ������ ���� ����	
//				
////		if (m.getRrds() == null) m.setRrds("0");   m�� rrds�� null�� ���� �� ����
//		
////		bv.setSubject("Test");  // idx �Է� �׽�Ʈ��
////		m.setRrds("0");		    // idx �Է� �׽�Ʈ��
//		
//		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
//		// ���⼭�� idx��� subject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
//		if (bv.getSubject() == "") {   			
//			m.setMsg("ó������ �����ϼ���.");
//			return "forward:/Spring/MVCWritecontroller";			
//		} else if (bv.getSubject() != "") {			
//			int RRD = Integer.parseInt(m.getRrds());			
//			
//			if (mv.getIdx() == 0) {  
//				// �̺κ��� member20 ���̺�� �����Ͽ� ��¥ idx�� �Է� ���θ� üũ�� ����. �����				
//				m.setMsg("idx�� �Է��ϼ���");
//				return "forward:/Spring/MVCWritecontroller"; 	
//			} else {  
//	
//				System.out.println("1 /Spring/Write_Actioncontroller�� subject = "+bv.getSubject());
//				System.out.println("1 /Spring/Write_Actioncontroller�� writer = "+bv.getWriter());
//
//				String writedate = bd.CreateyyMMdd();
//				String modifydate = bd.CreateyyMMdd();
//
//				RRD = 0;
//				int mmxidx = bd.MaxIdx();
//				int nextbidx = mmxidx + 1;
//				
////				BoardVO bv = new BoardVO();   // @Repository��ĵ� �̿��� ����
//							
//				bv.setWritedate(writedate);
//				bv.setModifydate(modifydate);
////				bv.setIdx(idxx);
//
//				try{
//					RRD = bd.InsertDB(bv, nextbidx);
//				} catch(Exception e){
//					RRD = 0;
//					e.printStackTrace();
//				}								
//				//System.out.println("\n\n/Spring/MVCWrite_Actioncontroller�� RRD = " + RRD + "\n\n");
//		      
//				if (RRD == 1) {
//					m.setRrds("1");
//				} else if (RRD == 0){
//					m.setRrds("0");
//				}		      
//			} // end of the first of the second if
//			
//			if (m.getRrds().equals("0") && m.getIsWright().equals("Yes")) {			
//				isRedirect = false;
//				m.setMsg("�۾��⿡ �����Ͽ����ϴ�.�ٽ�  �Է��ϼ���.");
//				model.addAttribute("mv", mv);
//			} else {
//				//DB�� ������ �ٲ�����Ƿ� forward ����� ���� ���� sendRedirect ����� ��� 
//		     	//�������� ���� ��ħ�� Ȯ���� �Ǿ� ���ο� �������� �ݿ��� ����ȴ�.
//				isRedirect = true;
//				
////				if (bv.getSubject() == null) bv.setSubject("");   bv�� subject�� null�� ���� �� ����
////				if (bv.getWriter() == null) bv.setWriter("");
//				
//				m.setMsg("�ۼ��� ���� ����Ǿ����ϴ�.");
//				
////				System.out.println("2 /Spring/Write_Actioncontroller�� subject = "+bv.getSubject());
////				System.out.println("2 /Spring/Write_Actioncontroller�� writer = "+bv.getWriter());								
//			    try {
//					 bv.setSubject(URLEncoder.encode(bv.getSubject(), "UTF-8"));
//					 bv.setWriter(URLEncoder.encode(bv.getWriter(), "UTF-8"));
//					 m.setMsg(URLEncoder.encode(m.getMsg(), "UTF-8"));
//				} catch (UnsupportedEncodingException e) {
//					 e.printStackTrace();
//				}			    
//			} // end of the second of the second if			
//		} // end of the first if
//			
//		model.addAttribute("m", m);
//				
////		System.out.println("/Spring/Write_Actioncontroller�� msg = "+m.getMsg());	
////		System.out.println("\n\n Write_Action Controller �� totalPage number = " + totalPage + "\n\n");				
//		
//		if (totalPage.equals("")) totalPage = "1";	
//		int totalPagei = Integer.parseInt(totalPage);
//			
//		SearchPageMaker searchPageMaker = new SearchPageMaker();
//		
//		searchPageMaker.setScri(scri);
//		searchPageMaker.getScri().setPage(totalPagei);		
//		
//		// �۾����� ����� �������� �ϳ� �þ ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
//		// descending���� �����Ͽ� �ֱٰ��� �տ� �����ֹǷ� �� ������ �Ϳ� �ش��ϴ� totalCount�� ����� �ǹ̾����� 
//		// �����Ͱ� �ѹ��� ����Ʈ�� ��Ÿ�� ������ ���� ���� ��쿡�� ������ ��
//		int cnt;
//		try {
//			cnt = bd.searchCountPaging(scri);
//			searchPageMaker.setTotalCount(cnt);
//			totalPagei= searchPageMaker.getTotalPage();
//			
//			Integer i = new Integer(totalPagei);
//			totalPage = i.toString();					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//// 		�Ʒ��� �ʿ���� ����. �ֳĸ� ��ü ����Ʈ �׸����� ���ư��Ƿ� 
////		������������ ��Ż������ ������ �ʿ��� // ù��° ������ �� �Ʒ� �ΰ��� ��ü ������	
////		rttr.addAttribute("searchPageMaker", searchPageMaker);
////		rttr.addAttribute("searchType", scri.getSearchType());
////		rttr.addAttribute("keyword", scri.getKeyword());
//				
//		if (isRedirect) {				
//		
////		    rttr.addAttribute("page", totalPage);
////		    rttr.addFlashAttribute("RRDS", RRDS);
////			.....		
////			return "redirect:/Spring/MVCListcontroller_TS?subject="+subject+"&writer="
////							+writer+"&RRDS="+RRDS+"&isWrite="+isWrite+"&msg="+msg+"&page="+totalPage;
////			//ascending���� �����Ͽ� �����ֹǷ� �ֱٿ� �ۼ��� ���� ������ totalPage(�ǵ�������)�� ��Ÿ����.
//			
//			String subject = bv.getSubject();
//			String writer = bv.getWriter();
//			String RRDS = m.getRrds();
//			String isWrite = m.getIsWright();
//			String msg = m.getMsg();
//			int idx = mv.getIdx();
//			String name = mv.getName();
//			try {
//				name = URLEncoder.encode(name, "utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			
//			return "redirect:/Spring/MVCListcontroller_TS?subject="+subject+"&writer="			
//			+writer+"&RRDS="+RRDS+"&isWrite="+isWrite+"&msg="+msg+"&page="+"1"+"&idx="+idx+"&name="+name;
//			//descending���� �����Ͽ� �����ֹǷ� �ֱٿ� �ۼ��� ���� ������ 1�������� ��Ÿ����.		
//		}else {
//			return "forward:/Spring/MVCWritecontroller?page="+page;
//		}
//	}	
	
	

	
//	@RequestMapping(value="/Spring/MVCModifycontroller")
//	public String Modify (HttpServletRequest request, HttpServletResponse response,
//		
//			@ModelAttribute("page") String page,
//			Model model
//			, SearchCriteria scri					
//			) throws SQLException {
//		
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		String Bidx = request.getParameter("Bidx");
////		String msg = request.getParameter("msg");   //??
////		String RRD = request.getParameter("RRD");   //??
//
//		if (Bidx == null) Bidx = "1";
//		int Bidxi = Integer.parseInt(Bidx);
//		
//		BoardVO bv = new BoardVO();
//		try{
//			bv = bd.getContent(Bidxi);
//		}catch(Exception e){
//			e.printStackTrace();
//		}	
//		
////		bv.setBidx(0);   // �׽�Ʈ��
//		
//		request.setAttribute("bv", bv);		
////		request.setAttribute("msg", msg);  //??
//				
//		model.addAttribute("scri", scri);
//		model.addAttribute("page", page);
//		model.addAttribute("searchType", scri.getSearchType());
//		model.addAttribute("keyword", scri.getKeyword());
//			
//  		SearchPageMaker searchPageMaker = new SearchPageMaker();	
//		searchPageMaker.setScri(scri);
//		model.addAttribute("searchPageMaker", searchPageMaker);
//					 
//		// �� �κ��� getContent()�Լ��� query ���н� bv.bidx�� 0 ��Ƽ� ������ ������
//		 if (bv.getBidx() == 0) {		 
//			 request.setAttribute("bv_bidx", "0");
//			 return  "forward:/Spring/MVCListcontroller_TS";
//		 } else {		
//			 return "Modify";
//		 }			
//	}
//	
//	
//	
//	@RequestMapping(value="/Spring/MVCModify_Actioncontroller")
//	public String Modify_Action (HttpServletRequest request, HttpServletResponse response,			
//						@ModelAttribute("page") String page, 
//						RedirectAttributes rttr
//						,Model model
//						,SearchCriteria scri) {
//		
//		String isUpdate = "Yes";
////		String RRDS = "1";	//�׽�Ʈ ��
//		String RRDS = "0";
//		String msg = "";
//		int idxi = 0;
//	
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//	    response.setCharacterEncoding("UTF-8");
//
//		String Bidx = request.getParameter("Bidx");
//		String subject = request.getParameter("subject");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//		String idx = request.getParameter("idx");
//				
//		model.addAttribute("scri", scri); // �̰� �ϳ��� �Ʒ� �������� �����Ѵ�.
////		model.addAttribute("page", page);
////		model.addAttribute("searchType", scri.getSearchType());
////		model.addAttribute("keyword", scri.getKeyword());
//
//		rttr.addAttribute("searchType", scri.getSearchType());
//		rttr.addAttribute("keyword", scri.getKeyword());
//				
//		System.out.println("/Spring/MVCMoify_Actioncontroller�� page = " + page);
//		System.out.println("/Spring/MVCMoify_Actioncontroller�� scri.searchType = " + scri.getSearchType());
//		System.out.println("/Spring/MVCMoify_Actioncontroller�� scri.keyword = " + scri.getKeyword());
//				
//		if (idx == null) {
//			msg = "idx�� �Է��ϼ���.";
//			System.out.println("/Spring/MVCMoify_Actioncontroller�� idx = " + idx);
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg; // ����  ����???
//		} else {  
//		    idxi = Integer.parseInt(idx);
//		    System.out.println("/Spring/MVCModify_Actioncontroller�� idx = "+idxi);
//		}    
//		
////		if (false) {		// �׽�Ʈ��
//		if (Bidx != null) {	 
//			System.out.println("Bidx = "+Bidx);
//			int bidx = Integer.parseInt(Bidx);	
//
//			int RRD = 0;
//		    String modifydate = bd.CreateyyMMdd();
//	
//			BoardVO bv = new BoardVO();   // @Repository��ĵ� �̿��� ����
//		    
//		    bv.setSubject(subject);
//			bv.setContent(content);
//			bv.setWriter(writer);
//			bv.setModifydate(modifydate);
//		    
//			try {   
//			    RRD = bd.UpdateDB (bv, bidx);	    
//			} catch (Exception e) {
//				RRD = 0;
//				e.printStackTrace();
//			}
//			
//		    if (RRD == 1)RRDS = "1";
//		    else RRDS = "0"; 
//		    	    
//		    if (RRDS == "0" && isUpdate == "Yes") {		
//				msg = "������ �����Ͽ����ϴ�. �ٽ��Է��� �ֽʽÿ�.";
//				request.setAttribute("msg", msg);
//				return "forward:/Spring/MVCModifycontroller";	
//				
//			} else if (RRDS == "1" && isUpdate == "Yes"){			
//				msg = "�����Ͽ� �����Ͽ����ϴ�.";
//				try {
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
//				System.out.println("/Spring/MVCModify_Actioncontroller�� Bidx = " + Bidx);
//				System.out.println("/Spring/MVCModify_Actioncontroller�� RRDS = " + RRDS);
//				System.out.println("/Spring/MVCModify_Actioncontroller�� isUpdate = " + isUpdate);
//				System.out.println("/Spring/MVCModify_Actioncontroller�� msg = " + msg);
//				return "redirect:/Spring/MVCContentcontroller?Bidx="+Bidx+"&RRDS="+RRDS
//						                      +"&isUpdate="+isUpdate+"&msg="+msg+"&page="+page;
//			}  // the end of the second if
//		} // the end of the first if   
////		else if (true) {		// �׽�Ʈ��
//		else if (Bidx == null) {
//			msg = "ó������ �����ϼ���.";
//			try {
//				msg = URLEncoder.encode(msg, "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;
//		}	
//		return "forward:/Spring/MVCListcontroller_TS?msg="+msg; //�ǹ� ����. �ƹ��ų� ����.
//	}	
	
	
	
//	@RequestMapping(value="/Spring/MVCModifycontroller")
//	public String Modify (
//						  @ModelAttribute("page") String page,
//						  BoardVO bv,
////						  MemberVO mv,
//						  Message m,
//						  Model model,
//						  SearchCriteria scri
//						 ) throws SQLException {
//	
//		if (bv.getBidx() == 0) bv.setBidx(1);
//			
//		try{
//			bv = bd.getContent(bv.getBidx());
//		}catch(Exception e){
//			e.printStackTrace();
//		}		
////		bv.setBidx(0);   // �׽�Ʈ��
//		
//		model.addAttribute("bv", bv);					
//		model.addAttribute("scri", scri);
//		model.addAttribute("page", page);
//		model.addAttribute("m", m);
//			
//  		SearchPageMaker searchPageMaker = new SearchPageMaker();	
//		searchPageMaker.setScri(scri);
//		model.addAttribute("searchPageMaker", searchPageMaker);
//					 
//		// �� �κ��� getContent()�Լ��� query ���н� bv.bidx�� 0 ��Ƽ� ������ ������
//		 if (bv.getBidx() == 0) {		 
////			 model.addAttribute("bv_bidx", "0");  // �ƹ� �ǹ̵� ���°� �� �� ������??
//			 return  "forward:/Spring/MVCListcontroller_TS";
//		 } else {		
//			 return "Modify";
//		 }			
//	}
//	
//	
//	
//	@RequestMapping(value="/Spring/MVCModify_Actioncontroller")
//	public String Modify_Action (	
//								 @ModelAttribute("page") String page, 
//								 BoardVO bv,
////								 MemberVO mv,
//								 Message m,
//								 RedirectAttributes rttr,
//								 Model model,
//								 SearchCriteria scri
//								) {
//		
//		m.setIsUpdate("Yes");
//		m.setRrds("0");
//
//		// �Ʒ����� ��� ��. ���Ŀ� �� �׽�Ʈ �� ��. 								  
//		// �Ƹ��� ���� ������ ��� ���� ����(�޸� ����)�� �����ǰ�  // �� ������ �״�� ����ϰ� ���� �� ����.
//		// return "List_TS" ���� ��쿡�� ȿ�� �߻��� �� ����.
//		// return "forward:...." �� return "redirect:...."�ʹ� ������ ��� ����. �� �� Ȯ�� �ʿ�.
//		//model.addAttribute("scri", scri); // page, searchType, keyword ����, List_TS.jsp�� ����
//
////		�Ʒ� ���� �� ����� ��										// redirect��
//		rttr.addAttribute("searchType", scri.getSearchType());	// controller ���̿��� �Ķ���� ����
//		rttr.addAttribute("keyword", scri.getKeyword());		// �ּ�â�� �Ķ���Ͱ� ǥ�õ��� �ʴ� post ���
//							// return "rediect:/Srping/Contentcontroller_TS?page="+page ��� �ߺ� ����
//							
////		bv.setIdx(0);	// �׽�Ʈ��
//
//		System.out.println("/Spring/MVCMoify_Actioncontroller�� idx = " + bv.getIdx());
//
//		if (bv.getIdx() == 0) {
//			String msg = "idx�� �Է��ϼ���.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;
//		}  
//		
////		if (false) {		// �׽�Ʈ��
//		if (bv.getBidx() != 0) {	 
//			System.out.println("Bidx = "+bv.getBidx());		
//		
//			int RRD = 0;
//		    String modifydate = bd.CreateyyMMdd();
//
//		    bv.setModifydate(modifydate);		    
//
//			try {   
//			    RRD = bd.UpdateDB (bv, bv.getBidx());	    
//			} catch (Exception e) {
//				RRD = 0;
//				e.printStackTrace();
//			}
//			
//		    if (RRD == 1) m.setRrds("1");
//		    else m.setRrds("0"); 
//		    
////			RRD = 0;		//�׽�Ʈ ��
//		    	    
//		    if (RRD == 0 && m.getIsUpdate() == "Yes") {		
//		    	String msg = "������ �����Ͽ����ϴ�. �ٽ��Է��� �ֽʽÿ�.";
//
////				m.setMsg(msg);	// �̰� �ȵ� (��Ʈ)
////				model.addAttribute("m", m);	// �̰� �ȵ� (��Ʈ)		// model�� controller�� jsp���� �Ķ���� ���޿� ���
////				return "forward:/Spring/MVCListcontroller_TS"; 	// �̰� �ȵ� (��Ʈ)
//		    	
//				return "forward:/Spring/MVCModifycontroller?msg="+msg;	// �̷��� �ؾߵ�(post���)
//				
////				return "redirect:/Spring/MVCListcontroller_TS?msg="+msg; // �� : �̷��� �ϸ� �ѱ� ����(get���)
//				
//			} else if (RRD == 1 && m.getIsUpdate() == "Yes"){			
//				String msg = "�����Ͽ� �����Ͽ����ϴ�.";
//				try {
//					msg = URLEncoder.encode(msg, "UTF-8");	// �ѱ� ���� ����
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
//				int bidx = bv.getBidx();	// Bidx�� bidx�� ������.	// setter getter �Լ��� ��������� ��Īȣȯ ��Ģ�� ���� 
//																	// Bidx�� bidx�� ���� ������ ��޵�
//				String isUpdate = m.getIsUpdate();
//				String RRDS = m.getRrds();
//				return "redirect:/Spring/MVCContentcontroller?bidx="+bidx+"&RRDS="+RRDS		// ������Ʈ�� redirect��� ���
//						                      +"&isUpdate="+isUpdate+"&msg="+msg+"&page="+page;
//			}  // the end of the second if
//		} // the end of the first if   
////		else if (true) {		// �׽�Ʈ��
//		else if (bv.getBidx() == 0) {
//			String msg = "ó������ �����ϼ���.";
////			try {
////				msg = URLEncoder.encode(msg, "UTF-8");
////			} catch (UnsupportedEncodingException e) {
////				e.printStackTrace();
////			}
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;
//		}	
//		return "forward:/Spring/MVCListcontroller_TS?msg="+"ó������ �����ϼ���."; //�ǹ� ����. �ƹ��ų� ����.
//	}	

	

//	@RequestMapping(value="/Spring/MVCDelete_Actioncontroller")
//	public String Delete_Action (HttpServletRequest request, HttpServletResponse response,
//								@ModelAttribute("page") String page,
//								SearchCriteria scri, 
//								RedirectAttributes rttr
////								,Model model
//								)throws SQLException {
//		
//	    String isDelete = "Yes";	    
//	    String msg = "";
//	//	String RRDS = "1";	//�׽�Ʈ ��
//		String RRDS = "0";
//		int idxi = 0;
//	
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//	//    response.setCharacterEncoding("UTF-8");
//	
//		String Bidx = request.getParameter("Bidx");
//		String idx = request.getParameter("idx");
//		
//		int idxx = 0;	
//		if (idx == null) {
//			msg = "idx�� �Է��ϼ���.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg; // ����  ����???
//		} else {  
//			idxx = Integer.parseInt(idx);
//		}
//		
//		if (Bidx != null) {			 
//			//System.out.println("Bidx = "+Bidx);
//			//System.out.println("hidden idx = "+idx);
//	
//			int bidx = Integer.parseInt(Bidx);		
//		    int RRD = 0;
//
//		    RRD = bd.DeleteDB (bidx);  
////		    RRD = 0;  // �׽�Ʈ ��   	    
//		           
//		    if (RRD == 1) RRDS = "1";		    	
//		    else if (RRD == 0) RRDS = "0";
//			 
//			 if (RRDS == "1") {						     
//			     msg = "�ش���� ���� �Ͽ����ϴ�.";
//			     try {
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}					
//					SearchPageMaker searchPageMaker = new SearchPageMaker();				
//					searchPageMaker.setScri(scri);		
//					
//					// �ۻ����� ����� �������� �ϳ� �پ�� ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
//					int cnt;
//					try {
//						cnt = bd.searchCountPaging(scri);
//						searchPageMaker.setTotalCount(cnt);
//						int totalPagei= searchPageMaker.getTotalPage();
//						int presentPagei = searchPageMaker.getScri().getPage();
//						
//						if (presentPagei > totalPagei) presentPagei = totalPagei;
//						searchPageMaker.getScri().setPage(presentPagei);
//												
//						Integer i = new Integer(presentPagei);
//						page = i.toString();					
//					} catch (Exception e) {
////						searchPageMaker.setTotalCount(10);
//						e.printStackTrace();
//					}
//									
////					model.addAttribute("searchPageMaker", searchPageMaker);
//						
//			     rttr.addAttribute("page", page);
//			     rttr.addAttribute("searchType", scri.getSearchType());
//			     rttr.addAttribute("keyword", scri.getKeyword());
//			     rttr.addFlashAttribute("RRDS", RRDS);
//			     rttr.addFlashAttribute("isDelete", isDelete);
//			     rttr.addFlashAttribute("msg", msg);
//			     		     
//			     return "redirect:/Spring/MVCListcontroller_TS?RRDS="+RRDS+"&isDelete="+isDelete+"&msg="+msg+"&page="+page;
//			     
//			 } else if (RRDS == "0") {
//				 
////				 model.addAttribute("scri", scri);				 
//				 msg = "������ �����Ͽ����ϴ�. �ٽ� �õ��ϼ���.";
//				 request.setAttribute("Bidx", Bidx);
//			     
////				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page+"&searchType="+scri.getSearchType()+"&keyword="+scri.getKeyword();		     
//				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page;
//			 }					 			 
//		}else{
//			msg = "ó������ �����ϼ���.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;			
//		}		
//		msg = "�ǹ̾��� ���Դϴ�. ��µ��� �ʽ��ϴ�. ���� ��µǴ� ��� �˷��ֽñ� �ٶ��ϴ�.";
//		return "forward:/Spring/MVCListcontroller_TS?msg="+msg; //�ǹ� ����. �ƹ��ų� ����. 	
//	}	


	
//	@RequestMapping(value="/Spring/MVCDelete_Actioncontroller")
//	public String Delete_Action (
//								 @ModelAttribute("page") String page,
//								 BoardVO bv,
////								 MemberVO mv,
//								 Message m,
//								 SearchCriteria scri, 
//								 RedirectAttributes rttr
////								 Model model
//								)throws SQLException {
//		
//	    m.setIsDelete("Yes");	    
//	    String msg = "";
//	//	String RRDS = "1";	//�׽�Ʈ ��
//		m.setRrds("0");
//	
//		bv.setIdx(2);  //�ӽ÷� ����
//		
//		if (bv.getIdx() == 0) {
//			msg = "idx�� �Է��ϼ���.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg; // ����  ����???
//		}
//		//System.out.println("hidden idx = "+bv.getIdx());
//		
////		bv.setBidx(0);	//�׽�Ʈ��
//		
//		if (bv.getBidx() != 0) {			 
//	
//		    int RRD = 0;
//
//		    RRD = bd.DeleteDB (bv.getBidx());  
////		    RRD = 0;  // �׽�Ʈ ��   	    
//		           
//		    if (RRD == 1) m.setRrds("1");		    	
//		    else if (RRD == 0) m.setRrds("0");
//			 
//		    if (RRD == 1) {						     
//			   msg = "�ش���� ���� �Ͽ����ϴ�.";
//			   try {
//				  msg = URLEncoder.encode(msg, "UTF-8");
//			   } catch (UnsupportedEncodingException e) {
//			      e.printStackTrace();
//			   }					
//			   SearchPageMaker searchPageMaker = new SearchPageMaker();				
//			   searchPageMaker.setScri(scri);		
//					
//			   // �ۻ����� ����� �������� �ϳ� �پ�� ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
//			   int cnt;
//			   try {
//				   cnt = bd.searchCountPaging(scri);
//				   searchPageMaker.setTotalCount(cnt);
//				   int totalPagei= searchPageMaker.getTotalPage();
//				   int presentPagei = searchPageMaker.getScri().getPage();
//						
//				   if (presentPagei > totalPagei) presentPagei = totalPagei;
//				   searchPageMaker.getScri().setPage(presentPagei);
//												
//				   Integer i = new Integer(presentPagei);
//				   page = i.toString();					
//			   } catch (Exception e) {
////				   searchPageMaker.setTotalCount(10);
//				   e.printStackTrace();
//			   }
//									
////			   model.addAttribute("searchPageMaker", searchPageMaker);
//						
//			   rttr.addAttribute("page", page);
//			   rttr.addAttribute("searchType", scri.getSearchType());
//			   rttr.addAttribute("keyword", scri.getKeyword());
//			   rttr.addFlashAttribute("rrds", m.getRrds());
//			   rttr.addFlashAttribute("isDelete", m.getIsDelete());
//			   rttr.addFlashAttribute("msg", msg);
//			     		     
//			   String rrds = m.getRrds();
//			   String isDelete = m.getIsDelete();
//			   
//			   return "redirect:/Spring/MVCListcontroller_TS?rrds="+rrds+"&isDelete="+isDelete+"&msg="+msg+"&page="+page;
//			     
//			} else if (m.getRrds() == "0") {
//				 
////				 model.addAttribute("scri", scri);				 
//				 msg = "������ �����Ͽ����ϴ�. �ٽ� �õ��ϼ���.";
//				 
//				 //request.setAttribute("Bidx", Bidx);			 
//				 //model.addAttribute("bv", bv);
//				 
////				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page+"&searchType="+scri.getSearchType()+"&keyword="+scri.getKeyword();		     
//				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page;
//			}					 			 
//		}else{
//			msg = "ó������ �����ϼ���.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;			
//		}		
//		msg = "�ǹ̾��� ���Դϴ�. ��µ��� �ʽ��ϴ�. ���� ��µǴ� ��� �˷��ֽñ� �ٶ��ϴ�.";
//		return "forward:/Spring/MVCListcontroller_TS?msg="+msg; //�ǹ� ����. �ƹ��ų� ����. 	
//	}	

	
	
	
//	@RequestMapping(value="/Spring/MVCReplycontroller")
//	public String Reply (HttpServletRequest request, HttpServletResponse response,		
//						@ModelAttribute("page") String page, 
//						@ModelAttribute("totalPage") String totalPage, 
////						@ModelAttribute("searchType") String searchType,
////						@ModelAttribute("keyword") String keyword	
//						SearchCriteria scri
//						,Model model
//						)throws SQLException {
//		
////		SearchCriteria scri = new SearchCriteria();
////		scri.setSearchType(searchType);
////		scri.setKeyword(keyword);
//		model.addAttribute("scri", scri);
//		
//		System.out.println("\nReplycontroller�� totalPage = "+totalPage+"\n");
//		
//		if (totalPage.equals("")) totalPage = "1";	
//		int totalPagei = Integer.parseInt(totalPage);
//		
//		SearchPageMaker searchPageMaker = new SearchPageMaker();	
//		searchPageMaker.setScri(scri);
//		searchPageMaker.setTotalPage(totalPagei);
//		model.addAttribute("searchPageMaker", searchPageMaker);
//			
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		response.setCharacterEncoding("UTF-8");
//		
//		//String Bidx = (String)request.getAttribute("Bidx"); // ??? getAttribute???
//		
//		String Bidx = request.getParameter("Bidx");
//		//String RRD = request.getParameter("RRD");
//		
//		if (Bidx == null){
//			Bidx = "1";
//		}
//		int Bidxx = Integer.parseInt(Bidx);
//			
//		BoardVO bv = new BoardVO();
//
//		try{
//			bv = bd.getContent(Bidxx);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
////		bv.setBidx(0);   // �׽�Ʈ��
//		request.setAttribute("bv", bv);
//		request.setAttribute("Bidx", Bidx);  // Reply_Actioncontroller�� ������ �뵵
//			
//		System.out.println("\nMVCReplycontroller�� bv.bidx = " + bv.getBidx());
//		System.out.println("MVCReplycontroller�� bv.originbidx = " + bv.getOriginbidx()+"\n");
//				
//		System.out.println("bv.getBidx() = " + bv.getBidx());
//			 
//		// �� �κ��� getContent()�Լ��� query ���н� bv.bidx�� 0 ��Ƽ� ������ ������
//		if (bv.getBidx() == 0) {
//			
////			model.addAttribute("scri", scri);
////			model.addAttribute("searchType", scri.getSearchType());
////			model.addAttribute("keyword", scri.getKeyword());
//			return "forward:/Spring/MVCListcontroller_TS?page="+page; 
//		} else {		
//			return "Reply";
//		}	 
//	}			
//	
//	
//	@Transactional
//	@RequestMapping(value="/Spring/MVCReply_Actioncontroller")
//	public String Reply_Action (
//								HttpServletRequest request, 
//								HttpServletResponse response,	
//								@ModelAttribute("page") String page,
//								@ModelAttribute("totalPage") String totalPage,
//								SearchCriteria scri, 
//								RedirectAttributes rttr
//								,Model model								
//								)throws UnsupportedEncodingException {
//			
//		System.out.println("\n\n/Spring/MVCReply_Actioncontroller�� page = "+page);
//		System.out.println("/Spring/MVCReply_Actioncontroller�� totalPage = "+totalPage);	
//		System.out.println("/Spring/MVCReply_Actioncontroller�� scri.searchType = "+scri.getSearchType());
//		System.out.println("/Spring/MVCReply_Actioncontroller�� scri.keyword = "+scri.getKeyword()+"\n\n");		
//		
//		String isReply = "Yes";
//		String RRDS = "0";
//		int nextbidx = 1;
//		
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		
//		String Bidx = request.getParameter("Bidx");
//		String originbidx = request.getParameter("originbidx"); 
//		String updown = request.getParameter("updown");
//		String leftright = request.getParameter("leftright");
//		String subject= request.getParameter("subject");
//		String content= request.getParameter("content");
//		String writer= request.getParameter("writer");
//		String writedate= request.getParameter("writedate");
//		String inidx = request.getParameter("idx");
//		RRDS = request.getParameter("RRD");
//		
//		String msg = "";
//		
//		if (RRDS == null) RRDS = "0";
//							
//	//	subject = "Test";  // idx �Է� �׽�Ʈ��
//	//	RRDS="0";		   // idx �Է� �׽�Ʈ��
//		
//		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
//		if (subject == null) {   // ���⼭�� idx��� subject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
//	
//			msg = "ó������ �����ϼ���";
//	//		request.setAttribute("msg", msg);  // �� ����� �ȵ�. 
//			// /Spring/MVCListcontroller �����δ� get������� �����ؾ� ��
//			return "redirect:/Spring/MVCListcontroller_TS?msg="+msg;
//			
//		} else if (subject != null) {
//			
//			int RRD = Integer.parseInt(RRDS);
//			// �Ʒ� �κ��� ���߿� �� ������ �� ��
//			int bidxi = Integer.parseInt(Bidx);
//			int originbidxi = Integer.parseInt(originbidx);
//			int updowni = Integer.parseInt(updown);
//			int leftrighti = Integer.parseInt(leftright);
//			
//			int idxi = 0;
//	//		System.out.println("/Spring/MVCReply_Actioncontroller�� inidx = "+inidx);
//	
//			// �̺κ��� member20 ���̺�� �����Ͽ� ��¥ idx�� �Է� ���θ� üũ�� ����. �����
//			if (inidx == null) {  
//				msg = "idx�� �Է��ϼ���";
//	//			return "forward:/Spring/MVCListcontroller?msg="+msg;
//			} else {  
//				idxi = Integer.parseInt(inidx);
//	//			System.out.println("idx = "+inidx);
//	
//	//			String writedate = bd.CreateyyMMdd();
//				String modifydate = bd.CreateyyMMdd();
//	
//				RRD = 0;
//				
//				try {		
//					int mmxidx = bd.MaxIdx();
//					nextbidx = mmxidx + 1;								
//					int nextupdowni=updowni + 1;
//					int nextleftrighti=leftrighti + 1;	
//					
//					// ������������� �߻��Ǹ� RRD�� 0�� �Ǵ°� �ƴϰ� ������ ���� exception ó���� �ȴ�.
//					RRD = bd.ReplyUpdateDB(originbidxi, updowni);					
//					System.out.println("ReplyUpdateDB �� ������  RRD = " + RRD);
//	
//					BoardVO bv = new BoardVO();   // @Repository��ĵ� �̿��� ����					
//					bv.setOriginbidx(originbidxi);
//					bv.setUpdown(nextupdowni);
//					bv.setLeftright(nextleftrighti);
//					bv.setSubject(subject);
//					bv.setContent(content);
//					bv.setWriter(writer);
//					bv.setWritedate(writedate);
//					bv.setModifydate(modifydate);
//					bv.setIdx(idxi);
//								
//					System.out.println("ReplyUpdateDB �� ���� �� bv.getWritedate() = " + bv.getWritedate());
//					
//					RRD = bd.ReplyInsertDB(bv, nextbidx);										
//					System.out.println("Reply InsertDB �� ������  RRD = " + RRD);
//				} catch (Exception e) {
//					RRD = 0;
//					e.printStackTrace();
//				}
//	
//				if (RRD == 1) {
//					RRDS = "1";
//				} else if (RRD == 0){
//					RRDS = "0";
//				}
//		      
//	//			request.setAttribute("RRDS", RRDS);  // viewȭ����� �������� �ʿ�
//	//			request.setAttribute("isReply", isReply); // viewȭ����� �������� �ʿ�
//	//				���⼭�� get������� ��� ������
//		      
//			} // end of the first of the second if
//			
//	////��������	request.setAttribute("Bidx", Bidx);
//			
////			RRDS="0";  //�׽�Ʈ��
//			
//			if (RRDS == "0" && isReply == "Yes") {
//				
//				msg = "����� �������� ���߽��ϴ�. �ٽ� �õ����ּ���.";
//				request.setAttribute("msg", msg);			
//				System.out.println("/Spring/MVCReplycontroller�� ���ļ� /Spring/MVCListcontroller_TS�� ���ļ� List_TS.jsp�� ��");
//
//				model.addAttribute("scri", scri);
//				
//				return "forward:/Spring/MVCReplycontroller";	
//			} else {	
//				//DB�� ������ �ٲ�����Ƿ� forward ����� ���� ���� sendRedirect ����� ��� �������� ���� ��ħ�� Ȯ���� �Ǿ�
//		     	//���ο� �������� �ݿ��� ����ȴ�.
//				msg = "����� �����Ͽ����ϴ�.";
//				if (subject == null) subject = "";
//				if (writer == null) writer = "";				
//				try {
//					subject = URLEncoder.encode(subject, "UTF-8");
//					writer = URLEncoder.encode(writer, "UTF-8");
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}  
//			    System.out.println("/Spring/MVCListcontroller_R_TS�� ���ļ� List_R_TS.jsp�� ��");
//					    		    
//				if (totalPage.equals("")) totalPage = "1";	
//				int totalPagei = Integer.parseInt(totalPage);
//					
//				SearchPageMaker searchPageMaker = new SearchPageMaker();				
//				searchPageMaker.setScri(scri);
//				searchPageMaker.getScri().setPage(totalPagei);		
//				
//				BidxSearchCriteria bscri = new BidxSearchCriteria();
//				searchPageMaker.setBscri(bscri);
//				
//				System.out.println("\nReply_Actioncontroller �� nextbidx = " + nextbidx);
//				searchPageMaker.getBscri().setBidx(nextbidx);
//				
//				
//				if (page.equals("")) page = "1";	
//				int pagei = Integer.parseInt(page);
//				searchPageMaker.getBscri().setPage(pagei);
//				searchPageMaker.getBscri().setSearchType(scri.getSearchType());
//				searchPageMaker.getBscri().setKeyword(scri.getKeyword());
//				
////				model.addAttribute("bscri", bscri);
//				
//				// ��۾����� ����� �������� �ϳ� �þ ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
//				int cnt;
//				try {
//					cnt = bd.searchCountPaging_R(searchPageMaker.getBscri());
//					searchPageMaker.setTotalCount_R(cnt);
//					totalPagei= searchPageMaker.getTotalPage();
//					
//					Integer i = new Integer(totalPagei);
//					totalPage = i.toString();					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//					
////				��� ������ �ʿ���  // get?��� �Ǵ� post?������� ����  
////				rttr.addAttribute("searchPageMaker", searchPageMaker);
////				rttr.addAttribute("searchType", scri.getSearchType());
////				rttr.addAttribute("keyword", scri.getKeyword()); 
//			    		    		    
//				String searchType = searchPageMaker.getBscri().getSearchType();
//				String keyword = searchPageMaker.getBscri().getKeyword();
//				try {
//					searchType = URLEncoder.encode(searchType, "UTF-8");
//					keyword = URLEncoder.encode(keyword, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}  
//					
//			    return "redirect:/Spring/MVCListcontroller_R_TS?subject="+subject+"&writer="
//			    		  +writer+"&RRDS="+RRDS+"&isReply="+isReply+"&msg="+msg
//			    		  +"&page="+page+"&totalPage="+totalPage
//			    		  +"&searchType="+searchType+"&keyword="+keyword+"&bidx="+nextbidx;
//			    
//			} // end of the second of the second if
//		} // end of the first if
//		return "List_TS";  //�ǹ� ����. �ƹ��ų� ����.
//	}	
	
	
//	@RequestMapping(value="/Spring/MVCReplycontroller")
//	public String Reply (
//						 @ModelAttribute("page") String page, 
//						 @ModelAttribute("totalPage") String totalPage, 
//						 BoardVO bv,
////						 MemberVO mv,
//						 Message m,
//						 SearchCriteria scri,
//						 Model model
//						)throws SQLException {
//		
//		model.addAttribute("scri", scri);
//		
////		System.out.println("\nReplycontroller�� totalPage = "+totalPage+"\n");
//		
//		if (totalPage.equals("")) totalPage = "1";	
//		int totalPagei = Integer.parseInt(totalPage);
//		
//		SearchPageMaker searchPageMaker = new SearchPageMaker();	
//		searchPageMaker.setScri(scri);
//		searchPageMaker.setTotalPage(totalPagei);
//		model.addAttribute("searchPageMaker", searchPageMaker);
//		
//		//String RRD = request.getParameter("RRD");
//		
//		if (bv.getBidx() == 0){
//			bv.setBidx(1);
//		}
//		
//		try{
//			bv = bd.getContent(bv.getBidx());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
////		bv.setBidx(0);   // �׽�Ʈ��
//		
//		model.addAttribute("bv", bv);	// �̰� �ϳ��� ���
////		model.addAttribute("bidx", bv.getBidx());  // Reply_Actioncontroller�� ������ �뵵	
//					
////		System.out.println("\nMVCReplycontroller�� bv.bidx = " + bv.getBidx());
////		System.out.println("MVCReplycontroller�� bv.originbidx = " + bv.getOriginbidx()+"\n");
//			 
//		// �� �κ��� getContent()�Լ��� query ���н� bv.bidx�� 0 ��Ƽ� ������ ������
//		if (bv.getBidx() == 0) {
//			return "forward:/Spring/MVCListcontroller_TS?page="+page; 
//		} else {		
//			return "Reply";
//		}	 
//	}			
	
	
	
//	@Transactional
//	@RequestMapping(value="/Spring/MVCReply_Actioncontroller")
//	public String Reply_Action (
//								@ModelAttribute("page") String page,
//								@ModelAttribute("totalPage") String totalPage,
//								BoardVO bv,
////								MemberVO mv,
//								Message m,
//								SearchCriteria scri, 
//								RedirectAttributes rttr,
//								Model model								
//							   )throws UnsupportedEncodingException {
//			
////		System.out.println("\n\n/Spring/MVCReply_Actioncontroller�� page = "+page);
////		System.out.println("/Spring/MVCReply_Actioncontroller�� totalPage = "+totalPage);	
////		System.out.println("/Spring/MVCReply_Actioncontroller�� scri.searchType = "+scri.getSearchType());
////		System.out.println("/Spring/MVCReply_Actioncontroller�� scri.keyword = "+scri.getKeyword()+"\n\n");		
//		
//		m.setIsReply("Yes");
//		m.setRrds("0");
//		int nextbidx = 1;
//		
////		RRDS = request.getParameter("RRD");
//		
//		String msg = "";
//		
////		if (RRDS == null) RRDS = "0";
//
//
////		bv.setSubject("Test");  // idx �Է� �׽�Ʈ��
////		m.setRrds("0");		    // idx �Է� �׽�Ʈ��		
//			
//		// ���� ���� ���� �� �޼ҵ带 ȣ���ߴ��� üũ
//		if (bv.getSubject() == "") {   // ���⼭�� idx��� subject�� ����Ͽ� ó������ �����ߴ����� ���θ� üũ�Ѵ�.
//	
//			msg = "ó������ �����ϼ���";
//
//			// URLEncoder �ʿ� ...
//			// /Spring/MVCListcontroller �����δ� get������� �����ؾ� ��
//			return "redirect:/Spring/MVCListcontroller_TS?msg="+msg;
//			
//		} else if (bv.getSubject() != "") {
//			
//			int RRD = Integer.parseInt(m.getRrds());
//	
//			// �̺κ��� member20 ���̺�� �����Ͽ� ��¥ idx�� �Է� ���θ� üũ�� ����
//			if (bv.getIdx() == 0) {  
//				msg = "idx�� �Է��ϼ���";
////				return "forward:/Spring/MVCListcontroller?msg="+msg;
//			} else {  
//				
////				String writedate = bd.CreateyyMMdd();
//				String modifydate = bd.CreateyyMMdd();
//	
//				RRD = 0;
//				
//				try {		
//					int mmxidx = bd.MaxIdx();
//					nextbidx = mmxidx + 1;								
//					int nextupdowni=bv.getUpdown() + 1;
//					int nextleftrighti=bv.getLeftright() + 1;	
//					
//					// ������������� �߻��Ǹ� RRD�� 0�� �Ǵ°� �ƴϰ� ������ ���� exception ó���� �ȴ�.
//					RRD = bd.ReplyUpdateDB(bv.getOriginbidx(), bv.getUpdown());					
//					System.out.println("ReplyUpdateDB �� ������  RRD = " + RRD);
//					
////					bv.setOriginbidx(bv.getOriginbidx());
//					bv.setUpdown(nextupdowni);
//					bv.setLeftright(nextleftrighti);
////					bv.setSubject(bv.getSubject());
////					bv.setContent(bv.getContent());
////					bv.setWriter(bv.getWriter());
////					bv.setWritedate(bv.getWritedate());
//					bv.setModifydate(modifydate);
////					bv.setIdx(bv.getIdx());
//								
//					System.out.println("ReplyUpdateDB �� ���� �� bv.getWritedate() = " + bv.getWritedate());
//					System.out.println("ReplyUpdateDB �� ���� �� bv.getModifydate() = " + bv.getModifydate());
//					
//					RRD = bd.ReplyInsertDB(bv, nextbidx);										
//					System.out.println("Reply InsertDB �� ������  RRD = " + RRD);
//				} catch (Exception e) {
//					RRD = 0;
//					e.printStackTrace();
//				}
//	
//				if (RRD == 1) {
//					m.setRrds("1");
//				} else if (RRD == 0){
//					m.setRrds("0");
//				}
//		      
//	//			model.addAttribute("m", m);
//	//			request.setAttribute("RRDS", RRDS);  // viewȭ����� �������� �ʿ�
//	//			request.setAttribute("isReply", isReply); // viewȭ����� �������� �ʿ�
//	//			���⼭�� get������� ��� ������
//		      
//			} // end of the first of the second if
//			
////			RRDS="0";  //�׽�Ʈ��
//			
//			if (RRD == 0 && m.getIsReply() == "Yes") {
//				
//				msg = "����� �������� ���߽��ϴ�. �ٽ� �õ����ּ���.";
////�����ʿ�				request.setAttribute("msg", msg);			
//				System.out.println("/Spring/MVCReplycontroller�� ���ļ� /Spring/MVCListcontroller_TS�� ���ļ� List_TS.jsp�� ��");
//
//				model.addAttribute("scri", scri);
//				
//				return "forward:/Spring/MVCReplycontroller";	
//			} else {	
//				//DB�� ������ �ٲ�����Ƿ� forward ����� ���� ���� sendRedirect ����� ��� �������� ���� ��ħ�� Ȯ���� �Ǿ�
//		     	//���ο� �������� �ݿ��� ����ȴ�.
//				msg = "����� �����Ͽ����ϴ�.";
//			
//				try {
//					bv.setSubject(URLEncoder.encode(bv.getSubject(), "UTF-8"));
//					bv.setWriter(URLEncoder.encode(bv.getWriter(), "UTF-8"));
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}  
//			    System.out.println("/Spring/MVCListcontroller_R_TS�� ���ļ� List_R_TS.jsp�� ��");
//					    		    
//				if (totalPage.equals("")) totalPage = "1";	
//				int totalPagei = Integer.parseInt(totalPage);
//					
//				SearchPageMaker searchPageMaker = new SearchPageMaker();				
//				searchPageMaker.setScri(scri);
//				searchPageMaker.getScri().setPage(totalPagei);		
//				
//				BidxSearchCriteria bscri = new BidxSearchCriteria();
//				searchPageMaker.setBscri(bscri);
//				
//				System.out.println("\nReply_Actioncontroller �� nextbidx = " + nextbidx);
//				searchPageMaker.getBscri().setBidx(nextbidx);
//				
//				
//				if (page.equals("")) page = "1";	
//				int pagei = Integer.parseInt(page);
//				searchPageMaker.getBscri().setPage(pagei);
//				searchPageMaker.getBscri().setSearchType(scri.getSearchType());
//				searchPageMaker.getBscri().setKeyword(scri.getKeyword());
//				
////				model.addAttribute("bscri", bscri);
//				
//				// ��۾����� ����� �������� �ϳ� �þ ��츦 ����ؼ� �ٽ� �ѹ� ������ ī��Ʈ�� ������Ʈ �ϴ� ����
//				int cnt;
//				try {
//					cnt = bd.searchCountPaging_R(searchPageMaker.getBscri());
//					searchPageMaker.setTotalCount_R(cnt);
//					totalPagei= searchPageMaker.getTotalPage();
//					
//					Integer i = new Integer(totalPagei);
//					totalPage = i.toString();					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//					
////				��� ������ �ʿ���  // get?��� �Ǵ� post?������� ����  
////				rttr.addAttribute("searchPageMaker", searchPageMaker);
////				rttr.addAttribute("searchType", scri.getSearchType());
////				rttr.addAttribute("keyword", scri.getKeyword()); 
//			    		    		    
//				String searchType = searchPageMaker.getBscri().getSearchType();
//				String keyword = searchPageMaker.getBscri().getKeyword();
//				try {
//					searchType = URLEncoder.encode(searchType, "UTF-8");
//					keyword = URLEncoder.encode(keyword, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}  
//				
//				String subject = bv.getSubject();
//				String writer = bv.getWriter();
//				String rrds = m.getRrds();
//				String isReply = m.getIsReply();
//					
//			    return "redirect:/Spring/MVCListcontroller_R_TS?subject="+subject+"&writer="
//			    		  +writer+"&rrds="+rrds+"&isReply="+isReply+"&msg="+msg
//			    		  +"&page="+page+"&totalPage="+totalPage
//			    		  +"&searchType="+searchType+"&keyword="+keyword+"&bidx="+nextbidx;
//			    
//			} // end of the second of the second if
//		} // end of the first if
//		return "List_TS";  //�ǹ� ����. �ƹ��ų� ����.
//	}	
	
}





