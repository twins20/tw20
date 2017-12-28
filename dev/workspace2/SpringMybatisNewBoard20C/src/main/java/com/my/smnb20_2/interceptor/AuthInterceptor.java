package com.my.smnb20_2.interceptor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.my.smnb20_2.Domain.MemberVO;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
					 	    HttpServletResponse response,
						    Object handler
						    ) throws Exception {
		
		System.out.println("Auth pre handle.........");
		
		HttpSession session = request.getSession();	
		if(session.getAttribute("mv") == null) {
			
			String msg = "로그인 후 사용하여 주십시요.";
			
			try {
				msg = URLEncoder.encode(msg, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
					
			logger.info("Current user is not logined");
			response.sendRedirect("/Spring/MVCLogincontroller?msg="+msg);
			return false;
		}	
		logger.info("Current user is logined");
		
//		-------------------------------------------
		Object result = session.getAttribute("mv");
		MemberVO mv = (MemberVO) result;			
		System.out.println("\n\nAuth pre 의 mv.idx =" + mv.getIdx());
		System.out.println("Auth pre 의 mv.name =" + mv.getName()+"\n\n");
//		-------------------------------------------
		
		return true;
	}
	
	
	
}
