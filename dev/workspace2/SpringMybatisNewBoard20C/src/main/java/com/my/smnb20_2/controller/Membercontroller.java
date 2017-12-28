package com.my.smnb20_2.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.MemberVO;
import com.my.smnb20_2.Domain.Message;
import com.my.smnb20_2.Domain.SearchCriteria;
import com.my.smnb20_2.service.BoardDAO_ano_Son;
import com.my.smnb20_2.service.MemberDAO_Son;

@Controller
public class Membercontroller {
		
	@Autowired
	private MemberDAO_Son md;
		
		
	@RequestMapping(value="/Spring/MVCMemberLoginCheck")
	public String LoginCheck(
			Model model,
			MemberVO mv
			) throws SQLException {
		
		MemberVO result_mv;
		String name="";
		int idx=0;
		String msg="";
		
		System.out.println("/Spring/MVCMemberLoginCheck �Դϴ�.");
		
		try{
			result_mv = md.loginCheck(mv);
		} catch (Exception e) {
			result_mv = null;
			e.printStackTrace();
		}		
			
		if (result_mv == null) {
			msg= "�α��ο� �����Ͽ����ϴ�. �ٽ� �α��� �Ͽ� �ֽʽÿ�.";

			try {
				msg = URLEncoder.encode(msg, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}	
					
			return "redirect:/Spring/MVCLogincontroller?msg="+msg;
		}
		else {
			name = result_mv.getName();
			idx = result_mv.getIdx();
			msg = "ȯ���մϴ�";
			
			try {
				name = URLEncoder.encode(name, "utf-8");
				msg = URLEncoder.encode(msg, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			model.addAttribute("mv", mv);	// LoginInterceptor ó���� �� �߰��� ��
	
	//		�� �κ��� postHandler()���� ó���ϰ� �˴ϴ�.		
	//		return "redirect:/Spring/MVCListcontroller_TS?name="+name+"&idx="+idx+"&msg="+msg;			
			return "redirect:/Spring/MVCWelcomecontroller?name="+name+"&idx="+idx+"&msg="+msg;
		}	
	}
	
	
	@RequestMapping(value="/Spring/MVCLogincontroller")
	public String Login(
			Model model,
			Message m
			) throws SQLException {

		model.addAttribute("m", m);
		return "Login";
	}
	
	
	
	@RequestMapping(value="/Spring/MVCWelcomecontroller")
	public String Welcome(
						  MemberVO mv,		
						  Model model,
						  Message m
					  	 ) {
		
		System.out.println("\n\nWelcomecontroller�� mv.name ="+mv.getName()+"\n\n");
		
		System.out.println("Welcomecontroller................");
		model.addAttribute("mv", mv);
		model.addAttribute("m", m);
	
		return "Welcome";
	}

	
//	@RequestMapping(value="/doA")
//	public String doA(
//					  Locale locale, 
////					  MemberVO mv,		// Session �� �������
//					  Model model
//					  ) {
//		
//		System.out.println("doA................");
////		model.addAttribute("mv", mv);	// Session �� �������
//	
//		return "Welcome";
//	}
//	
//	
//	@RequestMapping(value="/doB")
//	public String doB(Locale locale, Model model) {
//	
//		System.out.println("doB....................");
//		
//		model.addAttribute("result", "DOB RESULT");
//		
//		return "Welcome";
//	}	
	
	
//	@RequestMapping(value="/Spring/MVCMemberLoginCheck")
//	public String LoginCheck(
//			Model model,
////			RedirectAttributes rttr, //�̰��� �� �ȵɱ�?
//			MemberVO mv,
//			Message m
//			) throws SQLException {
//		System.out.println("/Spring/MVCMemberLoginCheck �Դϴ�.");
//		
//		MemberVO result_mv;
//		String name;
//		int idx;
//		
//		try{
//			result_mv = md.loginCheck(mv);
//		} catch (Exception e) {
//			result_mv = null;
//			e.printStackTrace();
//		}
//		
//		if (result_mv == null) {
//			name = "";
//			idx = 0;
//			m.setMsg("�α��ο� �����Ͽ����ϴ�");
//		}
//		else {
//			name = result_mv.getName();
//			idx = result_mv.getIdx();
//			m.setMsg("ȯ���մϴ�");
//		
//			
//	//		
//	//		model.addAttribute("m", m);
//	//		rttr.addAttribute("mv", result_mv);	//�̰��� �� �ȵɱ�?
//			
//			String msg = m.getMsg();
//			
//			try {
//				name = URLEncoder.encode(name, "utf-8");
//				msg = URLEncoder.encode(msg, "utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			
////			model.addAttribute("name", name);
////			model.addAttribute("idx", idx);
////			model.addAttribute("msg", msg);
//	
//			model.addAttribute("mv", mv);	// LoginInterceptor ó���� �� �߰��� ��
//			
//			// return "forward:/Spring/MVCListcontroller_TS"; //�̰� �ȵ�
//			// return "redirect:/Spring/MVCListcontroller_TS"; //�̰� �ȵ�
//	
//	//		�� �κ��� postHandler()���� ó���ϰ� �˴ϴ�.		
//	//		return "redirect:/Spring/MVCListcontroller_TS?name="+name+"&idx="+idx+"&msg="+msg;
//	
//			
//			return "redirect:/Spring/MVCWelcomecontroller?name="+name+"&idx="+idx+"&msg="+msg;
//	//		return "redirect:/Spring/MVCWelcomecontroller";
//			
//	//		
//	////		return "redirect:/MVC/Welcome.jsp";
//	////		return "redirect:/MVC/Welcome.jsp?name="+name+"&idx="+idx+"&msg="+msg;
//	////		return "Welcome";	
//		}
//		
//		return "Login";
//	}
//	
//	
	
}
