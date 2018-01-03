package com.twins.t20.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobMemberController {
	
	@RequestMapping(value="/twins/jmJoinController")
	public String JobMemberJoin(){
		return null;
	}
	
	@RequestMapping(value="/twins/jmConfirmIDController")
	public String JobMemberConfirmID(){
		return null;
	}
	
	@RequestMapping(value="/twins/jmLoginCheckController")
	public String JobMemberLoginCheck(){
		return null;
	}
	
	@RequestMapping(value="/twins/jmGetIDController")
	public String JobMemberGetID(){
		return null;
	}
	
	@RequestMapping(value="/twins/jmDropController")
	public String JobMemberDrop(){
		return null;
	}
	
	@RequestMapping(value="/twins/jmChangePswordController")
	public String JobMemberChangePsword(){
		return null;
	}
	
	@RequestMapping(value="/twins/jmModifyController")
	public String JobMemberModify(){
		return null;
	}
	
	@RequestMapping(value="/twins/jmModifyActionController")
	public String JobMemberModifyAction(){
		return null;
	}
}
