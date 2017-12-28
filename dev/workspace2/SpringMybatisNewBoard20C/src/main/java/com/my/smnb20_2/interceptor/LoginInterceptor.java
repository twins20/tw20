package com.my.smnb20_2.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.my.smnb20_2.Domain.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response,
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		
		System.out.println("post handle.........");
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		
		Object result = modelMap.get("mv");
		
		if(result != null) {
			
			logger.info("New login successed");
			session.setAttribute("mv", result);
//			response.sendRedirect("/doA");	//Welcome 화면으로 돌릴 때

//			response.sendRedirect("/MVC/Welcome.jsp");
			
//			-------------------------------------------
			Object res = session.getAttribute("mv");
			MemberVO mv = (MemberVO) res;			
			System.out.println("\n\nLogin post 의 mv.idx = " + mv.getIdx());
			System.out.println("Login post 의 mv.name = " + mv.getName()+"\n\n");
//			-------------------------------------------			
		}
		else logger.info("Login failed");
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
					 	    HttpServletResponse response,
						    Object handler
						    ) throws Exception {
		
		System.out.println("pre handle.........");
		
//		HandlerMethod method = (HandlerMethod) handler;
//		Method methodObj = method.getMethod();
		
//		System.out.println("Bean: " + method.getBean());
//		System.out.println("Method: " + methodObj);
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("mv") != null) {
			
			logger.info("Previous login data cleared");
			session.removeAttribute("mv");
		}
		
		return true;
	}
	
}
