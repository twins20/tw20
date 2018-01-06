package com.twins.t20.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobBoardController {
	
	@RequestMapping(value="/twins/jbListController")
	public String JobBoardList(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbList_rmController")
	public String JobBoardList_rm(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbList_nfcrdController")
	public String JobBoardList_nfcrd(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbList_nfcrd_rmController")
	public String JobBoardList_nfcrd_rm(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbContentController")
	public String JobBoardContent(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbModifyController")
	public String JobBoardModify(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbModifyActionController")
	public String JobBoardModifyAction(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbWriteController")
	public String JobBoardWrite(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbWriteActionController")
	public String JobBoardWriteAction(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbReplyController")
	public String JobBoardReply(){
		return null;	
	}
	
	@RequestMapping(value="/twins/jbReplyActionController")
	public String JobBoardReplyAction(){
		return null;
	}
	
	@RequestMapping(value="/twins/jbDeleteActionController")
	public String JobBoardDeleteAction(){
		return null;
	}
}
