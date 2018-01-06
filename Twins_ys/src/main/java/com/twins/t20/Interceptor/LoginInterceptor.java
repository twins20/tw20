package com.twins.t20.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println("클래스로그인 실행");
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
	//	Object jmv = modelMap.get("jmv");

		Object jmid = modelAndView.getModel().get("jmid");
		Object jmidx = modelAndView.getModel().get("jmidx");
		
		
		//System.out.println("아이디"+jmv);
		if(jmid != null){
			session.setAttribute("jmid", jmid);
			session.setAttribute("jmidx", jmidx);
			//response.sendRedirect("/twins/jmInterceptorController");
			
		}
		
	}
}