package com.my.smnb20_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.smnb20_2.Domain.CheckLineVO;

@Controller
public class SampleController5 {

	@RequestMapping("/doJSON")
	public @ResponseBody CheckLineVO doJSON(){
		
		CheckLineVO cv = new CheckLineVO("제목 예", "저자 예");
		
		return cv;		
	}	
}
