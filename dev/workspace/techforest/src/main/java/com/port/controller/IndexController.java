package com.port.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.port.service.ProjectServiceImpl;
import com.port.service.ProjectVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	@Autowired
	ProjectServiceImpl pi;
/*	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
*/	
	@RequestMapping(value = "/index.do")
	public String Index(HttpServletRequest request, HttpServletResponse response) {
		
		String pCate = "TECH";
		if(request.getParameter("pCate") != null){
			pCate = request.getParameter("pCate").trim();
		}
		 
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		
		plist = pi.projListByCate(pCate);
		
		request.setAttribute("plist", plist);
		
		return "index";
	}
	
}
