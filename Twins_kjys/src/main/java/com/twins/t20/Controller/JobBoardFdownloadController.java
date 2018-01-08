package com.twins.t20.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobBoardFdownloadController {
	
	@RequestMapping(value="/twins/jbfWriteController")
	public String JobBoardFdownloadWrite(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbfWriteActionController")
	public String JobBoardFdownloadWriteAction(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbfOrderUpController")
	public String JobBoardFdownloadOrderUp(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbfOrderDownController")
	public String JobBoardFdownloadOrderDown(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbfDeleteActionController")
	public String JobBoardFdownloadDeleteAction(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbfContentController")
	public String JobBoardFdownloadContent(){
		return null;
	}
}
