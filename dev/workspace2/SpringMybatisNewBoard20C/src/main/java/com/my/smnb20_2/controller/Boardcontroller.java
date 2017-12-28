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
		
		
//		System.out.println("\n\nListcontroller_TS의 mv.idx = " + mv.getIdx());
//		System.out.println("Listcontroller_TS의 mv.name = " + mv.getName() +"\n\n");
//		
//		System.out.println("\n\nListcontroller_TS의 page = " + page);
//		System.out.println("Listcontroller_TS의 totalPage = " + totalPage +"\n\n");
		
		if(mv.getIdx() == 0);	
			
//		System.out.println("\n\nListcontroller_TS의 m.isDelete = " + m.getIsDelete()+"\n\n");
//		if (m.getIsDelete().equals("Yes"))
//			System.out.println("\n\nListcontroller_TS의 m.msg = " + m.getMsg()+"\n\n");
		
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
		
//		System.out.println("/Spring/MVCListcontroller_TS 의  list : " + list);
		
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

		System.out.println("/Spring/MVCListcontroller_R_TS 의  page = " + page);	
		System.out.println("/Spring/MVCListcontroller_R_TS 의  scri = " + scri);	
		
		int pagei = 1;		
		if (page.equals("")) pagei = 1;	
		else pagei = Integer.parseInt(page);
				
		scri.setPage(pagei);
		model.addAttribute("scri", scri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);
			
		list = bd.getBoardList_R_TS(scri, scri.getBidx());
		model.addAttribute("list", list);
		
//		System.out.println("/Spring/MVCListcontroller_R_TS 의  list : " + list);
		
		int cnt;
		try {
			cnt = bd.searchCountPaging_R(scri);
			
			System.out.println("/Spring/MVCListcontroller_R_TS 의  cnt = " + cnt);
			
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
		
		System.out.println("/Sping/MVCContentcontroller의 Bidx = " + bv.getBidx());

		//  bv.setBidx(0);		// 테스트용	

		// 성공시 bv에 모든 값이 담겨 오고, 실패시 bv.bidx에 0이 담겨온다. 
		try{
			bv = bd.getContent(bv.getBidx());
		}catch(Exception e){
			e.printStackTrace();
		}	
		model.addAttribute("bv", bv);		
   		
//   		System.out.println("/Spring/MVCContentcontroller의 bd : " + bd);
//   		System.out.println("/Spring/MVCContentcontroller의 bv : " + bv);
   		
   		if (bv.getBidx()==0) {
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
		
		System.out.println("\n\nWritecontroller의 mv.name ="+mv.getName()+"\n\n");
	
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
		model.addAttribute("scri", scri);  //Write.jsp에서 makeSearch() 메소드를 사용하기 위해 꼭 필요
			
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
		
		System.out.println("\n\nWrite_Actioncontroller의 mv.name 1 ="+mv.getName()+"\n\n");
		
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
		
		System.out.println("\n\n/Spring/Write_Actioncontroller의 mv.idx = "+mv.getIdx());
		System.out.println("/Spring/Write_Actioncontroller의 bv.idx = "+bv.getIdx()+"\n\n");
		System.out.println("/Spring/Write_Actioncontroller의 m.getRrds() = "+m.getRrds()+"\n\n");		
					
//		originbidx는 우선 hidden 으로 고정된 값을 받음		
							
		// 글을 쓰고 나서 이 메소드를 호출했는지 체크
		// subject를 사용하여 처음부터 시작했는지의 여부를 체크한다.
		if (bv.getSubject() == "") {   			
			msg = "처음부터 시작하세요.";
					
			System.out.println("\n\nWrite_Actioncontroller의 mv.name 2 ="+mv.getName()+"\n\n");
			return "forward:/Spring/MVCWritecontroller?msg="+msg;		
		}
					
		// 이부분에서는 idx의 입력 여부를 체크해 본다.
		if (bv.getIdx() == 0) {  
			msg = "idx를 입력하세요.";
			
			return "forward:/Spring/MVCWritecontroller?msg="+msg+"&idx="+idx+"&name="+name;
		} 
		
		System.out.println("1 /Spring/Write_Actioncontroller의 subject = "+bv.getSubject());
		System.out.println("1 /Spring/Write_Actioncontroller의 writer = "+bv.getWriter());

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
			
//		m.setRrds("0");	//테스트용
		
		if (m.getRrds().equals("0") && m.getIsWright().equals("Yes")) {			
			isRedirect = false;
			m.setMsg("글쓰기에 실패하였습니다.다시  입력하세요.");
			
		} else {
			isRedirect = true;
			m.setMsg("작성된 글이 저장되었습니다.");
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
		
		// 글쓰기의 결과로 페이지가 하나 늘어날 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
		// descending으로 정렬하여 최근것을 앞에 보여주므로 맨 마지막 것에 해당하는 totalCount의 계산은 의미없지만 
		// 데이터가 한번의 리스트에 나타날 정도로 아주 적을 경우에는 영향을 줌
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
		
// 		아래는 필요없는 과정. 왜냐면 전체 리스트 항목으로 돌아가므로 
//		현재페이지와 토탈페이지 정보만 필요함 
//		rttr.addAttribute("pageMaker", pageMaker);

		if (isRedirect) {				
		
			String subject = bv.getSubject();
			String writer = bv.getWriter();
			String rrds = m.getRrds();
			String isWrite = m.getIsWright();
			msg = m.getMsg();

			return "redirect:/Spring/MVCListcontroller_TS?subject="+subject+"&writer="			
			+writer+"&rrds="+rrds+"&isWrite="+isWrite+"&msg="+msg+"&page="+"1"+"&idx="+idx+"&name="+name;
			//descending으로 정렬하여 보여주므로 최근에 작성한 글은 무조건 1페이지에 나타난다.		
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
//		bv.setBidx(0);   // 테스트용
		
		model.addAttribute("bv", bv);					
		model.addAttribute("scri", scri);
		model.addAttribute("page", page);
		model.addAttribute("m", m);
		model.addAttribute("mv", mv);
			
  		PageMaker pageMaker = new PageMaker();	
		pageMaker.setScri(scri);
		model.addAttribute("pageMaker", pageMaker);
					 
		// 이 부분은 getContent()함수가 query 실패시 bv.bidx에 0 담아서 보내기 때문임
		 if (bv.getBidx() == 0) {		 
//			 model.addAttribute("bv_bidx", "0");  // 아무 의미도 없는게 왜 들어가 있을까??
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
			name = URLEncoder.encode(name, "UTF-8");	// 한글 깨짐 방지
		} catch (UnsupportedEncodingException en) {
			en.printStackTrace();
		}
		
		// 아래것은 없어도 됨.							  
		//model.addAttribute("scri", scri); // page, searchType, keyword 포함, List_TS.jsp로 보냄

//		아래 것은 꼭 써줘야 함										// redirect시
		rttr.addAttribute("searchType", scri.getSearchType());	// controller 사이에서 파라미터 전달
		rttr.addAttribute("keyword", scri.getKeyword());		// 주소창에 파라미터가 표시되지 않는 post 방식
							// return "rediect:/Srping/Contentcontroller_TS?page="+page 등과 중복 가능

		System.out.println("/Spring/MVCMoify_Actioncontroller의 idx = " + bv.getIdx());

		if (bv.getIdx() == 0) {
			String msg = "idx를 입력하세요.";
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg+"&idx="+idx+"&name="+name;
		}  
		
		if (bv.getBidx() == 0) {
			String msg = "처음부터 시작하세요.";
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
	    
//			RRD = 0;		//테스트 용
	    	    
	    if (RRD == 0 && m.getIsUpdate() == "Yes") {		
	    	String msg = "수정에 실패하였습니다. 다시입력해 주십시요.";	    	
			return "forward:/Spring/MVCModifycontroller?msg="+msg;	// 이렇게 해야됨(forward : post방식)
			
//				return "redirect:/Spring/MVCListcontroller_TS?msg="+msg; // 비교 : 이렇게 하면 한글 깨짐(redired:get방식)
			
		} else if (RRD == 1 && m.getIsUpdate() == "Yes"){			
			String msg = "수정하여 저장하였습니다.";
			try {
				msg = URLEncoder.encode(msg, "UTF-8");	// 한글 깨짐 방지
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			int bidx = bv.getBidx();	// Bidx를 bidx로 수정함.	// setter getter 함수와 멤버변수간 명칭호환 법칙에 따라 
																// Bidx와 bidx는 같은 변수로 취급됨 // 좀 더 확인 필요
			String isUpdate = m.getIsUpdate();
			String rrds = m.getRrds();
			return "redirect:/Spring/MVCContentcontroller?bidx="+bidx+"&rrds="+rrds		// 업데이트는 redirect방식 사용
					+"&isUpdate="+isUpdate+"&msg="+msg+"&page="+page+"&idx="+idx+"&name="+name;
		} 
  
		return ""; //의미 없음. 아무거나 써줌.
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
	//	String rrds = "1";	//테스트 용
		m.setRrds("0");
	
//		bv.setIdx(2);  //임시로 지정   //테스트용
		
		if (bv.getIdx() == 0) {
			msg = "idx를 입력하세요.";
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg+"&idx="+idx+"&name="+name; // 어디로  갈까???
		}
		//System.out.println("hidden idx = "+bv.getIdx());
		
//		bv.setBidx(0);	//테스트용
		
		if (bv.getBidx() == 0) {
			msg = "처음부터 시작하세요.";
			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;			
		}	
		
	    int RRD = 0;

	    RRD = bd.DeleteDB (bv.getBidx());  

//		RRD = 0;  // 테스트 용   	    
	           
	    if (RRD == 1) m.setRrds("1");		    	
	    else if (RRD == 0) m.setRrds("0");
		 
	    if (RRD == 1) {						     
		   msg = "해당글을 삭제 하였습니다.";
				
		   PageMaker pageMaker = new PageMaker();				
		   pageMaker.setScri(scri);		
				
		   // 글삭제의 결과로 페이지가 하나 줄어들 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
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
			 msg = "삭제에 실패하였습니다. 다시 시도하세요.";
			 
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

//		m.setRrds("0");	// 테스트용
		
		model.addAttribute("m", m);	// Reply.jsp에서 m.rrds값 체크.
		
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

//		bv.setBidx(0);   // 테스트용
		
		model.addAttribute("bv", bv);	// 이것 하나로 충분
//		model.addAttribute("bidx", bv.getBidx());  // Reply_Actioncontroller로 전달할 용도	
			 
		// 이 부분은 getContent()함수가 query 실패시 bv.bidx에 0 담아서 보내기 때문임
		if (bv.getBidx() == 0) {
			// 메시지 생략 ....
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
		
		// 글을 쓰고 나서 이 메소드를 호출했는지 체크
		// subject를 사용하여 처음부터 시작했는지의 여부를 체크한다.
		if (bv.getSubject() == "") {   			
			msg = "처음부터 시작하세요.";

			return "forward:/Spring/MVCWritecontroller?msg="+msg;		
		}

		// 이부분은 프로그램 개발시 idx의 입력 여부를 체크해 본다.
		if (bv.getIdx() == 0) {  
			msg = "idx를 입력하세요.";
			
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
			
			// 쿼리문장오류가 발생되면 RRD가 0이 되는게 아니고 에러가 나서 exception 처리가 된다.
			RRD = bd.ReplyUpdateDB(bv.getOriginbidx(), bv.getUpdown());					
			System.out.println("ReplyUpdateDB 의 실행결과  RRD = " + RRD);
			
			bv.setUpdown(nextupdowni);
			bv.setLeftright(nextleftrighti);
			bv.setModifydate(modifydate);
						
//			System.out.println("ReplyUpdateDB 의 실행 후 bv.getWritedate() = " + bv.getWritedate());
//			System.out.println("ReplyUpdateDB 의 실행 후 bv.getModifydate() = " + bv.getModifydate());
			
			RRD = bd.ReplyInsertDB(bv, nextbidx);										
			System.out.println("Reply InsertDB 의 실행결과  RRD = " + RRD);
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
//		request.setAttribute("RRDS", RRDS);  // view화면까지 전달위해 필요
//		request.setAttribute("isReply", isReply); // view화면까지 전달위해 필요
//		여기서는 get방식으로 대신 전달함
      		
//		RRD = 0;  //테스트용
		
		if (RRD == 0 && m.getIsReply() == "Yes") {
			
			msg = "답글을 저장하지 못했습니다. 다시 시도해주세요.";	
			
			model.addAttribute("scri", scri);  //???				
			return "forward:/Spring/MVCReplycontroller?msg="+msg;	
		} else {	
			
			msg = "답글을 저장하였습니다.";
		
			try {
				bv.setSubject(URLEncoder.encode(bv.getSubject(), "UTF-8"));
				bv.setWriter(URLEncoder.encode(bv.getWriter(), "UTF-8"));
				msg = URLEncoder.encode(msg, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}  
		    System.out.println("/Spring/MVCListcontroller_R_TS를 거쳐서 List_R_TS.jsp로 감");
				    		    
			if (totalPage.equals("")) totalPage = "1";	
			int totalPagei = Integer.parseInt(totalPage);
				
			PageMaker pageMaker = new PageMaker();				
			pageMaker.setScri(scri);
			pageMaker.getScri().setPage(totalPagei);		
			
//			SearchCriteria scri = new SearchCriteria();
//			pageMaker.setScri(scri);
			
			System.out.println("\nReply_Actioncontroller 의 nextbidx = " + nextbidx);
			pageMaker.getScri().setBidx(nextbidx);
			
			
			if (page.equals("")) page = "1";	
			int pagei = Integer.parseInt(page);
			pageMaker.getScri().setPage(pagei);
			pageMaker.getScri().setSearchType(scri.getSearchType());
			pageMaker.getScri().setKeyword(scri.getKeyword());
			
//			model.addAttribute("bscri", bscri);
			
			// 답글쓰기의 결과로 페이지가 하나 늘어날 경우를 대비해서 다시 한번 페이지 카운트를 업데이트 하는 과정
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
				
//			방식 통일이 필요함  // get?방식 또는 post?방식으로 통일  
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
//		//RedirectAttribute 테스트용
//		logger.info("\n\nList() called...한글  포함  ..." + rediredt_msg + "\n\n");
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
//		//setAttribute 속성을 담는다.
//		request.setAttribute("RRDS", RRDS);  // 그냥 중계만 해준다.
//		request.setAttribute("isWright", isWright); // 그냥 중계만 해준다.
//		request.setAttribute("isReply", isWright); // 그냥 중계만 해준다.		
//		request.setAttribute("msg", msg); // 그냥 중계만 해준다.	
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
////		request.setAttribute("Bidx", Bidx);  // 그냥 중계만 해준다.
//		
//		
//		// Spring MVC의 Model객체 사용 예제
//		CheckLineVO checkLine = new CheckLineVO(subject, writer);
//		model.addAttribute(checkLine);
//			
//		System.out.println("/Spring/MVCListcontroller의 bd = " + bd);
//		
//		ArrayList<BoardVO> list = bd.getBoardList();
//		request.setAttribute("list", list);
//		
//		System.out.println("/Spring/MVCListcontroller 의  list : " + list);
//		
////		 conn.close();  // pool을 끊는 것임.  이곳에서 끊는 것이 아니고 BoardDAO에서 끊어 줌
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
////		 forward 방식에서는 파라미터의 중계는 필요없다. sendRediret방식에서는 중계가 필요하다.		
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
//		//RedirectAttribute 테스트용
//		logger.info("\n\nList_T() called...한글  포함  ..." + rediredt_msg + "\n\n");
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
//		//setAttribute 속성을 담는다.
//		request.setAttribute("RRDS", RRDS);  // 그냥 중계만 해준다.
//		request.setAttribute("isWright", isWright); // 그냥 중계만 해준다.
//		request.setAttribute("isReply", isWright); // 그냥 중계만 해준다.		
//		request.setAttribute("msg", msg); // 그냥 중계만 해준다.	
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
////		request.setAttribute("Bidx", Bidx);  // 그냥 중계만 해준다.
//		
//		
//		// Spring MVC의 Model객체 사용 예제
//		CheckLineVO checkLine = new CheckLineVO(subject, writer);
//		model.addAttribute(checkLine);
//			
//		System.out.println("/Spring/MVCListcontroller_T의 bd = " + bd);
//		
////		Criteria cri = new Criteria();
////		cri.setPage(10);
////		cri.setPerPageNum(20);
//		
//		System.out.println("\n\nList_T Controller 의 cri.page number = " + cri.getPage() + "");
//		System.out.println("List_T Controller 의 searchType = " +searchType + "");
//		System.out.println("List_T Controller 의 keyword = " + keyword + "\n\n");
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
//		System.out.println("/Spring/MVCListcontroller_T 의  list : " + list);
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
////		 conn.close();  // pool을 끊는 것임.  이곳에서 끊는 것이 아니고 BoardDAO에서 끊어 줌
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
////		 forward 방식에서는 파라미터의 중계는 필요없다. sendRediret방식에서는 중계가 필요하다.		
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
////		System.out.println("\n\n/Spring/MVCListcontroller_TS의 page = "+page);
////		System.out.println("/Spring/MVCListcontroller_TS의 totalPage = "+totalPage);	
////		System.out.println("/Spring/MVCListcontroller_TS의 scri.searchType = "+scri.getSearchType());
////		System.out.println("/Spring/MVCListcontroller_TS의 scri.keyword = "+scri.getKeyword()+"\n\n");
//					
//		//addAttribute 속성을 담는다.
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
////		System.out.println("/Spring/MVCListcontroller_TS의 bd = " + bd);	
////		System.out.println("List_TS Controller 의 scri.searchType = " +scri.getSearchType() + "");
////		System.out.println("List_TS Controller 의 scri.keyword = " + scri.getKeyword() + "");
////		System.out.println("List_TS Controller 의 scri.page = " + scri.getPage() + "\n\n");
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
//		System.out.println("/Spring/MVCListcontroller_TS 의  list : " + list);
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
//		System.out.println("\n\n/Spring/MVCListcontroller_R_TS의 page = "+page);
//		System.out.println("/Spring/MVCListcontroller_R_TS의 totalPage = "+totalPage);	
//		System.out.println("/Spring/MVCListcontroller_R_TS의 bscri.searchType = "+bscri.getSearchType());
//		System.out.println("/Spring/MVCListcontroller_R_TS의 bscri.keyword = "+bscri.getKeyword()+"");
//		System.out.println("/Spring/MVCListcontroller_R_TS의 bscri.nextbidx = "+bscri.getKeyword()+"\n\n");
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
////		String Bidx= request.getParameter("Bidx");  //받을 필요 없음 bscri에 담겨옴
//	
//		//setAttribute 속성을 담는다.
//		request.setAttribute("RRDS", RRDS);  // 그냥 중계만 해준다.
//		request.setAttribute("isWright", isWright); // 그냥 중계만 해준다.
//		request.setAttribute("isReply", isWright); // 그냥 중계만 해준다.		
//		request.setAttribute("msg", msg); // 그냥 중계만 해준다.	
//
//		if (subject == null) subject = "";
//		if (content == null) content = "";
//		if (writer == null) writer = "";	
//		if (RRDS == null) RRDS = "0";	
//		
////		if (Bidx == null) Bidx = "1";  	//List_R_TS 에서는 꼭 필요  // 비교 검토 필요
////		if (Bidx == "") Bidx = "1";		//List_R_TS 에서는 꼭 필요	// 비교 검토 필요
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
////		request.setAttribute("Bidx", Bidx);  // 그냥 중계만 해준다.
//				
//		// Spring MVC의 Model객체 사용 예제
//		CheckLineVO checkLine = new CheckLineVO(subject, writer);
//		model.addAttribute(checkLine);
//		
//		System.out.println("/Spring/MVCListcontroller_R_TS의 bd = " + bd);
//
//		System.out.println("List_R_TS Controller 의 scri.searchType = " +bscri.getSearchType() + "");
//		System.out.println("List_R_TS Controller 의 scri.keyword = " + bscri.getKeyword() + "");
//		System.out.println("List_R_TS Controller 의 scri.page = " + bscri.getPage() + "\n\n");
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
//		System.out.println("\n/Spring/MVCListcontroller_R_TS 의  bscri.bidx before : " + bscri.getBidx());
//		
//		ArrayList<BoardVO> list = bd.getBoardList_R_TS(bscri, bscri.getBidx());
//		request.setAttribute("list", list);
//		
//		System.out.println("/Spring/MVCListcontroller_R_TS 의  list : " + list);
//		
//		System.out.println("\n/Spring/MVCListcontroller_R_TS 의  bscri.bidx after : " + bscri.getBidx());
//		
//		int cnt;
//		try {
//			cnt = bd.searchCountPaging_R(bscri);
//			
//			System.out.println("Reply_Actioncontroller의 cnt = " + cnt);
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
////		 forward 방식에서는 파라미터의 중계는 필요없다. sendRediret방식에서는 중계가 필요하다.		
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
//		String isUpdate = (String)request.getAttribute("isUpdate");  // 중계만 해준다.	
//		int Bidxi = Integer.parseInt(Bidx);
//		
//		request.setAttribute("msg", msg);
////		request.setAttribute("Bidx", Bidx);
//		request.setAttribute("RRDS", RRDS);
//		request.setAttribute("isUpdate", isUpdate);
//		
//		if (Bidx == null) {    // 왜 이코드만 안 먹을까????  
//			Bidx = "1";		//sendRedirect로 받은 변수의 null값 endoding이 안맞아서 그런가? 
//		} 
//		
//		Bidxi = 1;		
//		if (Bidx.equals("0")) {    // 이 코드는 먹는다.
//			Bidx = "1";
//		}
//		
//		System.out.println("/Sping/MVCContentcontroller의 Bidx = " + Bidx);
//		Bidxi = Integer.parseInt(Bidx);
//		System.out.println("/Spring/MVCContentcontroller의 Bidxx = " + Bidxi);
//		
//		//	Bidxx = 0;	  // 테스트용	
//		
//		// 성공시 bv에 모든 값이 담겨 오고, 실패시 bv.bidx에 0이 담겨온다. 
//		BoardVO bv = new BoardVO();
//		try{
//			bv = bd.getContent(Bidxi);
//		}catch(Exception e){
//			e.printStackTrace();
//		}			
//		request.setAttribute("bv", bv);    
//   		
//   		System.out.println("/Spring/MVCContentcontroller의 bd : " + bd);
//   		System.out.println("/Spring/MVCContentcontroller의 bv : " + bv);
//   		
//   		if (bv.getBidx()==0) {
//   			msg = "해당 항목이 존재하지 않습니다.";
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
//		System.out.println("\n\n/Spring/Write Controller의 mv.idx = "+mv.getIdx());
//		System.out.println("\n\n/Spring/Write Controller의 mv.name = "+mv.getName());
//		System.out.println("Write Controller 의 bv.idx = " + bv.getIdx() + "\n\n");
//		
//		//setAttribute 속성을 담는다.
//		model.addAttribute("m", m);
//		model.addAttribute("bv",bv);
//		model.addAttribute("mv",mv);
//			
//		System.out.println("\n\n Write Controller 의 page number = " + page + "");
//		System.out.println(" Write Controller 의 totalPage number = " + totalPage + "");	
//		System.out.println(" Write Controller 의 searchType = " + scri.getSearchType() + "");
//		System.out.println(" Write Controller 의 keyword = " + scri.getKeyword() + "\n\n");					
//
//		System.out.println("\nWritecontroller의 totalPage before = "+totalPage+"\n");
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
//		System.out.println("\nWritecontroller의 totalPage after = "+totalPage+"\n");
//		
//		model.addAttribute("searchPageMaker", searchPageMaker);
//		model.addAttribute("scri", scri);   //불필요하지만 연습삼아 
//		           // Write.jps에 searchType과 keyword를 찍어보기 위해
//		//Write.jsp에서 makeSearch() 메소드를 사용하기 위해 이제는 꼭 필요
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
//		System.out.println("\n\n/Spring/Write_Actioncontroller의 mv.idx = "+mv.getIdx());
//		System.out.println("/Spring/Write_Actioncontroller의 bv.idx = "+bv.getIdx()+"\n\n");
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
//													// originbidx는 우선 hidden 으로 고정된 값을 받음
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
////		bv.setSubject("Test");  // idx 입력 테스트용
////		m.setRrds("0");		    // idx 입력 테스트용
//		
//		// 글을 쓰고 나서 이 메소드를 호출했는지 체크
//		// 여기서는 idx대신 subject를 사용하여 처음부터 시작했는지의 여부를 체크한다.
//		if (bv.getSubject() == null) {   			
//			m.setMsg("처음부터 시작하세요.");
//			return "forward:/Spring/MVCWritecontroller";			
//		} else if (bv.getSubject() != null) {			
//			int RRD = Integer.parseInt(m.getRrds());			
//	
//			
////			System.out.println("Write_Actioncontroller의 inidx = "+inidx);		
//
//			if (inidx == null) {  
//				// 이부분은 member20 테이블과 관련하여 진짜 idx의 입력 여부를 체크해 본다. 참고용				
//				m.setMsg("idx를 입력하세요");
//				return "forward:/Spring/MVCWritecontroller"; 	
//			} else {  
//				idxx = Integer.parseInt(inidx);
//	
//				System.out.println("idx = "+inidx);
//				System.out.println("1 /Spring/Write_Actioncontroller의 subject = "+bv.getSubject());
//				System.out.println("1 /Spring/Write_Actioncontroller의 writer = "+bv.getWriter());
//
//				String writedate = bd.CreateyyMMdd();
//				String modifydate = bd.CreateyyMMdd();
//
//				RRD = 0;
//				int mmxidx = bd.MaxIdx();
//				int nextbidx = mmxidx + 1;
//				
////				BoardVO bv = new BoardVO();   // @Repository방식도 이용해 보자
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
//				//System.out.println("\n\n/Spring/MVCWrite_Actioncontroller의 RRD = " + RRD + "\n\n");
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
//				m.setMsg("글쓰기에 실패하였습니다.다시  입력하세요.");
//				model.addAttribute("mv", mv);
//			} else {
//				//DB의 내용이 바뀌었으므로 forward 방식을 쓰지 맑고 sendRedirect 방식을 써야 
//		     	//페이지의 새로 고침이 확실이 되어 새로운 데이터의 반영이 보장된다.
//				isRedirect = true;
//				
//				if (bv.getSubject() == null) bv.setSubject("");
//				if (bv.getWriter() == null) bv.setWriter("");
//				m.setMsg("작성된 글이 저장되었습니다.");
//				
//				System.out.println("2 /Spring/Write_Actioncontroller의 subject = "+bv.getSubject());
//				System.out.println("2 /Spring/Write_Actioncontroller의 writer = "+bv.getWriter());				
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
//		System.out.println("/Spring/Write_Actioncontroller의 msg = "+m.getMsg());	
//		System.out.println("\n\n Write_Action Controller 의 totalPage number = " + totalPage + "\n\n");				
//		
//		if (totalPage.equals("")) totalPage = "1";	
//		int totalPagei = Integer.parseInt(totalPage);
//			
//		SearchPageMaker searchPageMaker = new SearchPageMaker();
//		
//		searchPageMaker.setScri(scri);
//		searchPageMaker.getScri().setPage(totalPagei);		
//		
//		// 글쓰기의 결과로 페이지가 하나 늘어날 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
//		// descending으로 정렬하여 최근것을 앞에 보여주므로 맨 마지막 것에 해당하는 totalCount의 계산의 의미없음
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
//// 		아래는 필요없는 과정. 왜냐면 전체 리스트 항목으로 돌아가므로 
////		현재페이지와 토탈페이지 정보만 필요함 // 첫번째 것으로 그 아래 두개를 대체 가능함	
////		rttr.addAttribute("searchPageMaker", searchPageMaker);
////		rttr.addAttribute("searchType", scri.getSearchType());
////		rttr.addAttribute("keyword", scri.getKeyword());
//				
//		if (isRedirect) {				
//
////			return "redirect:/Spring/MVCListcontroller";	//RedirectAttribute 테스트용
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
////				//ascending으로 정렬하여 보여주므로 최근에 작성한 글은 무조건 totalPage(맨뒤페이지)에 나타난다.
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
//				//descending으로 정렬하여 보여주므로 최근에 작성한 글은 무조건 1페이지에 나타난다.		
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
////		System.out.println("\n\n/Spring/Write Controller의 mv.idx = "+mv.getIdx());
////		System.out.println("/Spring/Write Controller의 mv.name = "+mv.getName());
////		System.out.println("/Spring/Write Controller 의 bv.idx = " + bv.getIdx() + "\n\n");
//		
//		//setAttribute 속성을 담는다.
//		model.addAttribute("m", m);
//		model.addAttribute("bv",bv);
//		model.addAttribute("mv",mv);
//			
////		System.out.println("\n\n/Spring/Write Controller 의 page number = " + page + "");
////		System.out.println("/Spring/Write Controller 의 totalPage number = " + totalPage + "");	
////		System.out.println("/Spring/Write Controller 의 searchType = " + scri.getSearchType() + "");
////		System.out.println("/Spring/Write Controller 의 keyword = " + scri.getKeyword() + "\n\n");					
////
////		System.out.println("\n/Spring/Writecontroller의 totalPage before = "+totalPage+"\n");
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
////		System.out.println("\nWritecontroller의 totalPage after = "+totalPage+"\n");
//		
//		model.addAttribute("searchPageMaker", searchPageMaker);
//		model.addAttribute("scri", scri);   //불필요하지만 연습삼아 
//		           // Write.jps에 searchType과 keyword를 찍어보기 위해
//		//Write.jsp에서 makeSearch() 메소드를 사용하기 위해 이제는 꼭 필요
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
//		System.out.println("\n\n/Spring/Write_Actioncontroller의 mv.idx = "+mv.getIdx());
//		System.out.println("/Spring/Write_Actioncontroller의 bv.idx = "+bv.getIdx()+"\n\n");
//		System.out.println("/Spring/Write_Actioncontroller의 m.getRrds() = "+m.getRrds()+"\n\n");		
//		
////	@@@@@@@@  참고용  %Flash%	  rttr.addFlashAttribute("rediredt_msg", "RedirectAttribute Example Messsage!");   @@@@@@@@@@@@@@
//	
//			
//		// originbidx는 우선 hidden 으로 고정된 값을 받음	
//				
////		if (m.getRrds() == null) m.setRrds("0");   m의 rrds가 null인 경우는 안 생김
//		
////		bv.setSubject("Test");  // idx 입력 테스트용
////		m.setRrds("0");		    // idx 입력 테스트용
//		
//		// 글을 쓰고 나서 이 메소드를 호출했는지 체크
//		// 여기서는 idx대신 subject를 사용하여 처음부터 시작했는지의 여부를 체크한다.
//		if (bv.getSubject() == "") {   			
//			m.setMsg("처음부터 시작하세요.");
//			return "forward:/Spring/MVCWritecontroller";			
//		} else if (bv.getSubject() != "") {			
//			int RRD = Integer.parseInt(m.getRrds());			
//			
//			if (mv.getIdx() == 0) {  
//				// 이부분은 member20 테이블과 관련하여 진짜 idx의 입력 여부를 체크해 본다. 참고용				
//				m.setMsg("idx를 입력하세요");
//				return "forward:/Spring/MVCWritecontroller"; 	
//			} else {  
//	
//				System.out.println("1 /Spring/Write_Actioncontroller의 subject = "+bv.getSubject());
//				System.out.println("1 /Spring/Write_Actioncontroller의 writer = "+bv.getWriter());
//
//				String writedate = bd.CreateyyMMdd();
//				String modifydate = bd.CreateyyMMdd();
//
//				RRD = 0;
//				int mmxidx = bd.MaxIdx();
//				int nextbidx = mmxidx + 1;
//				
////				BoardVO bv = new BoardVO();   // @Repository방식도 이용해 보자
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
//				//System.out.println("\n\n/Spring/MVCWrite_Actioncontroller의 RRD = " + RRD + "\n\n");
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
//				m.setMsg("글쓰기에 실패하였습니다.다시  입력하세요.");
//				model.addAttribute("mv", mv);
//			} else {
//				//DB의 내용이 바뀌었으므로 forward 방식을 쓰지 맑고 sendRedirect 방식을 써야 
//		     	//페이지의 새로 고침이 확실이 되어 새로운 데이터의 반영이 보장된다.
//				isRedirect = true;
//				
////				if (bv.getSubject() == null) bv.setSubject("");   bv의 subject가 null인 경우는 안 생김
////				if (bv.getWriter() == null) bv.setWriter("");
//				
//				m.setMsg("작성된 글이 저장되었습니다.");
//				
////				System.out.println("2 /Spring/Write_Actioncontroller의 subject = "+bv.getSubject());
////				System.out.println("2 /Spring/Write_Actioncontroller의 writer = "+bv.getWriter());								
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
////		System.out.println("/Spring/Write_Actioncontroller의 msg = "+m.getMsg());	
////		System.out.println("\n\n Write_Action Controller 의 totalPage number = " + totalPage + "\n\n");				
//		
//		if (totalPage.equals("")) totalPage = "1";	
//		int totalPagei = Integer.parseInt(totalPage);
//			
//		SearchPageMaker searchPageMaker = new SearchPageMaker();
//		
//		searchPageMaker.setScri(scri);
//		searchPageMaker.getScri().setPage(totalPagei);		
//		
//		// 글쓰기의 결과로 페이지가 하나 늘어날 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
//		// descending으로 정렬하여 최근것을 앞에 보여주므로 맨 마지막 것에 해당하는 totalCount의 계산은 의미없지만 
//		// 데이터가 한번의 리스트에 나타날 정도로 아주 적을 경우에는 영향을 줌
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
//// 		아래는 필요없는 과정. 왜냐면 전체 리스트 항목으로 돌아가므로 
////		현재페이지와 토탈페이지 정보만 필요함 // 첫번째 것으로 그 아래 두개를 대체 가능함	
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
////			//ascending으로 정렬하여 보여주므로 최근에 작성한 글은 무조건 totalPage(맨뒤페이지)에 나타난다.
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
//			//descending으로 정렬하여 보여주므로 최근에 작성한 글은 무조건 1페이지에 나타난다.		
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
////		bv.setBidx(0);   // 테스트용
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
//		// 이 부분은 getContent()함수가 query 실패시 bv.bidx에 0 담아서 보내기 때문임
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
////		String RRDS = "1";	//테스트 용
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
//		model.addAttribute("scri", scri); // 이것 하나로 아래 세가지를 포함한다.
////		model.addAttribute("page", page);
////		model.addAttribute("searchType", scri.getSearchType());
////		model.addAttribute("keyword", scri.getKeyword());
//
//		rttr.addAttribute("searchType", scri.getSearchType());
//		rttr.addAttribute("keyword", scri.getKeyword());
//				
//		System.out.println("/Spring/MVCMoify_Actioncontroller의 page = " + page);
//		System.out.println("/Spring/MVCMoify_Actioncontroller의 scri.searchType = " + scri.getSearchType());
//		System.out.println("/Spring/MVCMoify_Actioncontroller의 scri.keyword = " + scri.getKeyword());
//				
//		if (idx == null) {
//			msg = "idx를 입력하세요.";
//			System.out.println("/Spring/MVCMoify_Actioncontroller의 idx = " + idx);
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg; // 어디로  갈까???
//		} else {  
//		    idxi = Integer.parseInt(idx);
//		    System.out.println("/Spring/MVCModify_Actioncontroller의 idx = "+idxi);
//		}    
//		
////		if (false) {		// 테스트용
//		if (Bidx != null) {	 
//			System.out.println("Bidx = "+Bidx);
//			int bidx = Integer.parseInt(Bidx);	
//
//			int RRD = 0;
//		    String modifydate = bd.CreateyyMMdd();
//	
//			BoardVO bv = new BoardVO();   // @Repository방식도 이용해 보자
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
//				msg = "수정에 실패하였습니다. 다시입력해 주십시요.";
//				request.setAttribute("msg", msg);
//				return "forward:/Spring/MVCModifycontroller";	
//				
//			} else if (RRDS == "1" && isUpdate == "Yes"){			
//				msg = "수정하여 저장하였습니다.";
//				try {
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
//				System.out.println("/Spring/MVCModify_Actioncontroller의 Bidx = " + Bidx);
//				System.out.println("/Spring/MVCModify_Actioncontroller의 RRDS = " + RRDS);
//				System.out.println("/Spring/MVCModify_Actioncontroller의 isUpdate = " + isUpdate);
//				System.out.println("/Spring/MVCModify_Actioncontroller의 msg = " + msg);
//				return "redirect:/Spring/MVCContentcontroller?Bidx="+Bidx+"&RRDS="+RRDS
//						                      +"&isUpdate="+isUpdate+"&msg="+msg+"&page="+page;
//			}  // the end of the second if
//		} // the end of the first if   
////		else if (true) {		// 테스트용
//		else if (Bidx == null) {
//			msg = "처음부터 시작하세요.";
//			try {
//				msg = URLEncoder.encode(msg, "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;
//		}	
//		return "forward:/Spring/MVCListcontroller_TS?msg="+msg; //의미 없음. 아무거나 써줌.
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
////		bv.setBidx(0);   // 테스트용
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
//		// 이 부분은 getContent()함수가 query 실패시 bv.bidx에 0 담아서 보내기 때문임
//		 if (bv.getBidx() == 0) {		 
////			 model.addAttribute("bv_bidx", "0");  // 아무 의미도 없는게 왜 들어가 있을까??
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
//		// 아래것은 없어도 됨. 추후에 더 테스트 해 봄. 								  
//		// 아마도 변한 설정이 없어서 예전 설정(메모리 내용)이 유지되고  // 그 설정을 그대로 사용하고 있을 것 같다.
//		// return "List_TS" 등의 경우에만 효력 발생할 것 같다.
//		// return "forward:...." 나 return "redirect:...."와는 무관한 기능 같다. 좀 더 확인 필요.
//		//model.addAttribute("scri", scri); // page, searchType, keyword 포함, List_TS.jsp로 보냄
//
////		아래 것은 꼭 써줘야 함										// redirect시
//		rttr.addAttribute("searchType", scri.getSearchType());	// controller 사이에서 파라미터 전달
//		rttr.addAttribute("keyword", scri.getKeyword());		// 주소창에 파라미터가 표시되지 않는 post 방식
//							// return "rediect:/Srping/Contentcontroller_TS?page="+page 등과 중복 가능
//							
////		bv.setIdx(0);	// 테스트용
//
//		System.out.println("/Spring/MVCMoify_Actioncontroller의 idx = " + bv.getIdx());
//
//		if (bv.getIdx() == 0) {
//			String msg = "idx를 입력하세요.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;
//		}  
//		
////		if (false) {		// 테스트용
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
////			RRD = 0;		//테스트 용
//		    	    
//		    if (RRD == 0 && m.getIsUpdate() == "Yes") {		
//		    	String msg = "수정에 실패하였습니다. 다시입력해 주십시요.";
//
////				m.setMsg(msg);	// 이건 안됨 (세트)
////				model.addAttribute("m", m);	// 이건 안됨 (세트)		// model은 controller와 jsp간의 파라미터 전달에 사용
////				return "forward:/Spring/MVCListcontroller_TS"; 	// 이건 안됨 (세트)
//		    	
//				return "forward:/Spring/MVCModifycontroller?msg="+msg;	// 이렇게 해야됨(post방식)
//				
////				return "redirect:/Spring/MVCListcontroller_TS?msg="+msg; // 비교 : 이렇게 하면 한글 깨짐(get방식)
//				
//			} else if (RRD == 1 && m.getIsUpdate() == "Yes"){			
//				String msg = "수정하여 저장하였습니다.";
//				try {
//					msg = URLEncoder.encode(msg, "UTF-8");	// 한글 깨짐 방지
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
//				int bidx = bv.getBidx();	// Bidx를 bidx로 수정함.	// setter getter 함수와 멤버변수간 명칭호환 법칙에 따라 
//																	// Bidx와 bidx는 같은 변수로 취급됨
//				String isUpdate = m.getIsUpdate();
//				String RRDS = m.getRrds();
//				return "redirect:/Spring/MVCContentcontroller?bidx="+bidx+"&RRDS="+RRDS		// 업데이트는 redirect방식 사용
//						                      +"&isUpdate="+isUpdate+"&msg="+msg+"&page="+page;
//			}  // the end of the second if
//		} // the end of the first if   
////		else if (true) {		// 테스트용
//		else if (bv.getBidx() == 0) {
//			String msg = "처음부터 시작하세요.";
////			try {
////				msg = URLEncoder.encode(msg, "UTF-8");
////			} catch (UnsupportedEncodingException e) {
////				e.printStackTrace();
////			}
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;
//		}	
//		return "forward:/Spring/MVCListcontroller_TS?msg="+"처음부터 시작하세요."; //의미 없음. 아무거나 써줌.
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
//	//	String RRDS = "1";	//테스트 용
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
//			msg = "idx를 입력하세요.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg; // 어디로  갈까???
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
////		    RRD = 0;  // 테스트 용   	    
//		           
//		    if (RRD == 1) RRDS = "1";		    	
//		    else if (RRD == 0) RRDS = "0";
//			 
//			 if (RRDS == "1") {						     
//			     msg = "해당글을 삭제 하였습니다.";
//			     try {
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}					
//					SearchPageMaker searchPageMaker = new SearchPageMaker();				
//					searchPageMaker.setScri(scri);		
//					
//					// 글삭제의 결과로 페이지가 하나 줄어들 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
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
//				 msg = "삭제에 실패하였습니다. 다시 시도하세요.";
//				 request.setAttribute("Bidx", Bidx);
//			     
////				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page+"&searchType="+scri.getSearchType()+"&keyword="+scri.getKeyword();		     
//				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page;
//			 }					 			 
//		}else{
//			msg = "처음부터 시작하세요.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;			
//		}		
//		msg = "의미없는 행입니다. 출력되지 않습니다. 만약 출력되는 경우 알려주시기 바랍니다.";
//		return "forward:/Spring/MVCListcontroller_TS?msg="+msg; //의미 없음. 아무거나 써줌. 	
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
//	//	String RRDS = "1";	//테스트 용
//		m.setRrds("0");
//	
//		bv.setIdx(2);  //임시로 지정
//		
//		if (bv.getIdx() == 0) {
//			msg = "idx를 입력하세요.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg; // 어디로  갈까???
//		}
//		//System.out.println("hidden idx = "+bv.getIdx());
//		
////		bv.setBidx(0);	//테스트용
//		
//		if (bv.getBidx() != 0) {			 
//	
//		    int RRD = 0;
//
//		    RRD = bd.DeleteDB (bv.getBidx());  
////		    RRD = 0;  // 테스트 용   	    
//		           
//		    if (RRD == 1) m.setRrds("1");		    	
//		    else if (RRD == 0) m.setRrds("0");
//			 
//		    if (RRD == 1) {						     
//			   msg = "해당글을 삭제 하였습니다.";
//			   try {
//				  msg = URLEncoder.encode(msg, "UTF-8");
//			   } catch (UnsupportedEncodingException e) {
//			      e.printStackTrace();
//			   }					
//			   SearchPageMaker searchPageMaker = new SearchPageMaker();				
//			   searchPageMaker.setScri(scri);		
//					
//			   // 글삭제의 결과로 페이지가 하나 줄어들 경우를 대비해서 다시 한번 페이지 카운트를 업에이트 하는 과정
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
//				 msg = "삭제에 실패하였습니다. 다시 시도하세요.";
//				 
//				 //request.setAttribute("Bidx", Bidx);			 
//				 //model.addAttribute("bv", bv);
//				 
////				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page+"&searchType="+scri.getSearchType()+"&keyword="+scri.getKeyword();		     
//				 return "forward:/Spring/MVCContentcontroller?msg="+msg+"&page="+page;
//			}					 			 
//		}else{
//			msg = "처음부터 시작하세요.";
//			return "forward:/Spring/MVCListcontroller_TS?msg="+msg;			
//		}		
//		msg = "의미없는 행입니다. 출력되지 않습니다. 만약 출력되는 경우 알려주시기 바랍니다.";
//		return "forward:/Spring/MVCListcontroller_TS?msg="+msg; //의미 없음. 아무거나 써줌. 	
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
//		System.out.println("\nReplycontroller의 totalPage = "+totalPage+"\n");
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
////		bv.setBidx(0);   // 테스트용
//		request.setAttribute("bv", bv);
//		request.setAttribute("Bidx", Bidx);  // Reply_Actioncontroller로 전달할 용도
//			
//		System.out.println("\nMVCReplycontroller의 bv.bidx = " + bv.getBidx());
//		System.out.println("MVCReplycontroller의 bv.originbidx = " + bv.getOriginbidx()+"\n");
//				
//		System.out.println("bv.getBidx() = " + bv.getBidx());
//			 
//		// 이 부분은 getContent()함수가 query 실패시 bv.bidx에 0 담아서 보내기 때문임
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
//		System.out.println("\n\n/Spring/MVCReply_Actioncontroller의 page = "+page);
//		System.out.println("/Spring/MVCReply_Actioncontroller의 totalPage = "+totalPage);	
//		System.out.println("/Spring/MVCReply_Actioncontroller의 scri.searchType = "+scri.getSearchType());
//		System.out.println("/Spring/MVCReply_Actioncontroller의 scri.keyword = "+scri.getKeyword()+"\n\n");		
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
//	//	subject = "Test";  // idx 입력 테스트용
//	//	RRDS="0";		   // idx 입력 테스트용
//		
//		// 글을 쓰고 나서 이 메소드를 호출했는지 체크
//		if (subject == null) {   // 여기서는 idx대신 subject를 사용하여 처음부터 시작했는지의 여부를 체크한다.
//	
//			msg = "처음부터 시작하세요";
//	//		request.setAttribute("msg", msg);  // 이 방식은 안됨. 
//			// /Spring/MVCListcontroller 쪽으로는 get방식으로 통일해야 됨
//			return "redirect:/Spring/MVCListcontroller_TS?msg="+msg;
//			
//		} else if (subject != null) {
//			
//			int RRD = Integer.parseInt(RRDS);
//			// 아래 부분은 나중에 더 생각해 볼 것
//			int bidxi = Integer.parseInt(Bidx);
//			int originbidxi = Integer.parseInt(originbidx);
//			int updowni = Integer.parseInt(updown);
//			int leftrighti = Integer.parseInt(leftright);
//			
//			int idxi = 0;
//	//		System.out.println("/Spring/MVCReply_Actioncontroller의 inidx = "+inidx);
//	
//			// 이부분은 member20 테이블과 관련하여 진짜 idx의 입력 여부를 체크해 본다. 참고용
//			if (inidx == null) {  
//				msg = "idx를 입력하세요";
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
//					// 쿼리문장오류가 발생되면 RRD가 0이 되는게 아니고 에러가 나서 exception 처리가 된다.
//					RRD = bd.ReplyUpdateDB(originbidxi, updowni);					
//					System.out.println("ReplyUpdateDB 의 실행결과  RRD = " + RRD);
//	
//					BoardVO bv = new BoardVO();   // @Repository방식도 이용해 보자					
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
//					System.out.println("ReplyUpdateDB 의 실행 후 bv.getWritedate() = " + bv.getWritedate());
//					
//					RRD = bd.ReplyInsertDB(bv, nextbidx);										
//					System.out.println("Reply InsertDB 의 실행결과  RRD = " + RRD);
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
//	//			request.setAttribute("RRDS", RRDS);  // view화면까지 전달위해 필요
//	//			request.setAttribute("isReply", isReply); // view화면까지 전달위해 필요
//	//				여기서는 get방식으로 대신 전달함
//		      
//			} // end of the first of the second if
//			
//	////생략가능	request.setAttribute("Bidx", Bidx);
//			
////			RRDS="0";  //테스트용
//			
//			if (RRDS == "0" && isReply == "Yes") {
//				
//				msg = "답글을 저장하지 못했습니다. 다시 시도해주세요.";
//				request.setAttribute("msg", msg);			
//				System.out.println("/Spring/MVCReplycontroller를 거쳐서 /Spring/MVCListcontroller_TS를 거쳐서 List_TS.jsp로 감");
//
//				model.addAttribute("scri", scri);
//				
//				return "forward:/Spring/MVCReplycontroller";	
//			} else {	
//				//DB의 내용이 바뀌었으므로 forward 방식을 쓰지 맑고 sendRedirect 방식을 써야 페이지의 새로 고침이 확실이 되어
//		     	//새로운 데이터의 반영이 보장된다.
//				msg = "답글을 저장하였습니다.";
//				if (subject == null) subject = "";
//				if (writer == null) writer = "";				
//				try {
//					subject = URLEncoder.encode(subject, "UTF-8");
//					writer = URLEncoder.encode(writer, "UTF-8");
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}  
//			    System.out.println("/Spring/MVCListcontroller_R_TS를 거쳐서 List_R_TS.jsp로 감");
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
//				System.out.println("\nReply_Actioncontroller 의 nextbidx = " + nextbidx);
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
//				// 답글쓰기의 결과로 페이지가 하나 늘어날 경우를 대비해서 다시 한번 페이지 카운트를 업데이트 하는 과정
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
////				방식 통일이 필요함  // get?방식 또는 post?방식으로 통일  
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
//		return "List_TS";  //의미 없음. 아무거나 적음.
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
////		System.out.println("\nReplycontroller의 totalPage = "+totalPage+"\n");
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
////		bv.setBidx(0);   // 테스트용
//		
//		model.addAttribute("bv", bv);	// 이것 하나로 충분
////		model.addAttribute("bidx", bv.getBidx());  // Reply_Actioncontroller로 전달할 용도	
//					
////		System.out.println("\nMVCReplycontroller의 bv.bidx = " + bv.getBidx());
////		System.out.println("MVCReplycontroller의 bv.originbidx = " + bv.getOriginbidx()+"\n");
//			 
//		// 이 부분은 getContent()함수가 query 실패시 bv.bidx에 0 담아서 보내기 때문임
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
////		System.out.println("\n\n/Spring/MVCReply_Actioncontroller의 page = "+page);
////		System.out.println("/Spring/MVCReply_Actioncontroller의 totalPage = "+totalPage);	
////		System.out.println("/Spring/MVCReply_Actioncontroller의 scri.searchType = "+scri.getSearchType());
////		System.out.println("/Spring/MVCReply_Actioncontroller의 scri.keyword = "+scri.getKeyword()+"\n\n");		
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
////		bv.setSubject("Test");  // idx 입력 테스트용
////		m.setRrds("0");		    // idx 입력 테스트용		
//			
//		// 글을 쓰고 나서 이 메소드를 호출했는지 체크
//		if (bv.getSubject() == "") {   // 여기서는 idx대신 subject를 사용하여 처음부터 시작했는지의 여부를 체크한다.
//	
//			msg = "처음부터 시작하세요";
//
//			// URLEncoder 필요 ...
//			// /Spring/MVCListcontroller 쪽으로는 get방식으로 통일해야 됨
//			return "redirect:/Spring/MVCListcontroller_TS?msg="+msg;
//			
//		} else if (bv.getSubject() != "") {
//			
//			int RRD = Integer.parseInt(m.getRrds());
//	
//			// 이부분은 member20 테이블과 관련하여 진짜 idx의 입력 여부를 체크해 본다
//			if (bv.getIdx() == 0) {  
//				msg = "idx를 입력하세요";
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
//					// 쿼리문장오류가 발생되면 RRD가 0이 되는게 아니고 에러가 나서 exception 처리가 된다.
//					RRD = bd.ReplyUpdateDB(bv.getOriginbidx(), bv.getUpdown());					
//					System.out.println("ReplyUpdateDB 의 실행결과  RRD = " + RRD);
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
//					System.out.println("ReplyUpdateDB 의 실행 후 bv.getWritedate() = " + bv.getWritedate());
//					System.out.println("ReplyUpdateDB 의 실행 후 bv.getModifydate() = " + bv.getModifydate());
//					
//					RRD = bd.ReplyInsertDB(bv, nextbidx);										
//					System.out.println("Reply InsertDB 의 실행결과  RRD = " + RRD);
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
//	//			request.setAttribute("RRDS", RRDS);  // view화면까지 전달위해 필요
//	//			request.setAttribute("isReply", isReply); // view화면까지 전달위해 필요
//	//			여기서는 get방식으로 대신 전달함
//		      
//			} // end of the first of the second if
//			
////			RRDS="0";  //테스트용
//			
//			if (RRD == 0 && m.getIsReply() == "Yes") {
//				
//				msg = "답글을 저장하지 못했습니다. 다시 시도해주세요.";
////보충필요				request.setAttribute("msg", msg);			
//				System.out.println("/Spring/MVCReplycontroller를 거쳐서 /Spring/MVCListcontroller_TS를 거쳐서 List_TS.jsp로 감");
//
//				model.addAttribute("scri", scri);
//				
//				return "forward:/Spring/MVCReplycontroller";	
//			} else {	
//				//DB의 내용이 바뀌었으므로 forward 방식을 쓰지 맑고 sendRedirect 방식을 써야 페이지의 새로 고침이 확실이 되어
//		     	//새로운 데이터의 반영이 보장된다.
//				msg = "답글을 저장하였습니다.";
//			
//				try {
//					bv.setSubject(URLEncoder.encode(bv.getSubject(), "UTF-8"));
//					bv.setWriter(URLEncoder.encode(bv.getWriter(), "UTF-8"));
//					msg = URLEncoder.encode(msg, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}  
//			    System.out.println("/Spring/MVCListcontroller_R_TS를 거쳐서 List_R_TS.jsp로 감");
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
//				System.out.println("\nReply_Actioncontroller 의 nextbidx = " + nextbidx);
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
//				// 답글쓰기의 결과로 페이지가 하나 늘어날 경우를 대비해서 다시 한번 페이지 카운트를 업데이트 하는 과정
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
////				방식 통일이 필요함  // get?방식 또는 post?방식으로 통일  
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
//		return "List_TS";  //의미 없음. 아무거나 적음.
//	}	
	
}





