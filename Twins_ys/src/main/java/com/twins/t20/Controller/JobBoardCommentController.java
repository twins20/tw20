package com.twins.t20.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class JobBoardCommentController {
	
	@RequestMapping(value="/twins/jbcContentController")
	public String JobBoardCommentContent(){
		return null;
	}	
	
	@RequestMapping(value="/twins/jbcWriteController")
	public String JobBoardCommentWrite(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbcWriteActionController")
	public String JobBoardCommentWriteAction(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbcDeleteActionController")
	public String JobBoardCommentDeleteAction(){
		return null;
	}
}
