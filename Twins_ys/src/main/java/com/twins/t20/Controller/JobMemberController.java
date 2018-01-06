package com.twins.t20.Controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twins.t20.Domain.JobMemberVo;
import com.twins.t20.Service.JobMemberDaoFather;

@Controller
public class JobMemberController {
	
	@Autowired
	private JobMemberDaoFather jmdf;
	
	@RequestMapping(value="/twins/jmJoinController")
	public String JobMemberJoin(@ModelAttribute("jmv")JobMemberVo jmv,Model model){
		
		model.addAttribute("jmv", jmv);
		
		return "/Member/TwinsJobMemberJoin";
	}
	
	@RequestMapping(value="/twins/jmJoinActionController")
	public String JobMemberJoinAction(JobMemberVo jmv,Model model){
		
//		Date dt = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");		
//		String date = sdf.format(dt);		
//		date = date.substring(2);		
		
		
//		jmv.setJmregdate(date);
		int cf = jmdf.insertJobMember(jmv);
		
		
		
		model.addAttribute("cf", cf);
		
		return "redirect:/twins/jmMainController";
	}
	@ResponseBody
	@RequestMapping(value="/twins/jmConfirmIDController")
	public String JobMemberConfirmID(@RequestParam("jmid")String jmid,HttpServletResponse response,Model model) throws IOException{
		
		PrintWriter out =response.getWriter();
		
		boolean result = jmdf.confirmJobMemberID(jmid);
	
		if(result) out.println("0");
		else out.println("1");
		
		out.close();
		return "TwinsJobMemberJoin";
	}
	
	@RequestMapping(value="/twins/jmLoginCheckController")
	public String JobMemberLoginCheck(JobMemberVo jmv,Model model
		){
		
		String url = "";
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		map.put("jmid", jmv.getJmid());
		map.put("jmpsword", jmv.getJmpsword());
		
		jmv = jmdf.loginJobMember(map);
		
		model.addAttribute("jmv", jmv);
		model.addAttribute("jmid",jmv.getJmid());
		model.addAttribute("jmidx", jmv.getJmidx());
//		System.out.println("로그인");
		if(jmv != null ){
			url = "redirect:/twins/jmMainController";
		}else{
			url = "redirect:/twins/jmLoginController";
		}
		return url;
	}
	
	@RequestMapping(value="/twins/jmGetIDController")
	public String JobMemberGetID(JobMemberVo jmv,Model model){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		
		map.put("jmname", jmv.getJmname());
		map.put("jmemail", jmv.getJmemail());
		
//		System.out.println(jmv.getJmname());
//		System.out.println(jmv.getJmemail());
		String getId = jmdf.getIDJobMember(map);
		
		
		
		model.addAttribute("getId", getId);
		
		return "redirect:/twins/jmLoginController";
		
	}
	
	@RequestMapping(value="/twins/jmDropController")
	public String JobMemberDrop(JobMemberVo jmv,Model model){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		
		map.put("jmregister", jmv.getJmregister());
		map.put("jmidx", jmv.getJmidx());
		
		int drop = jmdf.deleteJobMember(map);
		
		model.addAttribute("drop", drop);
		
		return "/Member/TwinsJobMemberDrop";
	}
	
	@RequestMapping(value="/twins/jmChangePswordController")
	public String JobMemberChangePsword(Integer jmidx,Model model){
		
	JobMemberVo jmv = jmdf.selectJobMember(jmidx);
		System.out.println("비밀번호"+jmv.getJmpsword());
	model.addAttribute("jmv", jmv);
		
		return "/Member/TwinsJobMemberChangePsword";
	}
	@RequestMapping(value="/twins/jmChangePswordActionController")
	public String JobMemberChangePswordAction(Integer jmidx,
			JobMemberVo jmv,Model model){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		
		map.put("jmpsword", jmv.getJmpsword());
		map.put("jmidx",jmv.getJmidx());
		
		System.out.println("비밀번호:"+jmv.getJmpsword());
		
		int cp = jmdf.changePsword(map);
				
		model.addAttribute("cp", cp);
		model.addAttribute("jmv", jmv);
		
		return "redirect:/twins/jmMainController";
		
	}
	@RequestMapping(value="/twins/jmModifyController")
	public String JobMemberModify(Integer  jmidx,JobMemberVo jmv,Model model){
	
		jmv = jmdf.selectJobMember(jmidx);
	
		model.addAttribute("jmv", jmv);
	
		return "/Member/TwinsJobMemberModify";
	}
	
	@RequestMapping(value="/twins/jmModifyActionController")
	public String JobMemberModifyAction(Integer jmidx,JobMemberVo jmv,Model model){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
	
		map.put("jmemail", jmv.getJmemail());
		map.put("jmaddr", jmv.getJmaddr());
		map.put("jmidx", jmv.getJmidx());
		
		int modify = jmdf.modifyJobMember(map);
		
		model.addAttribute("modify", modify);
		
		return "redirect:/twins/jmModifyController?jmidx="+jmidx;
	}
	@RequestMapping(value="/twins/jmLoginController")
	public String JobMemberLogin(JobMemberVo jmv){
//		String jmname = jmv.getJmname();
//		String jmemail =jmv.getJmemail();
		
		return "/Member/TwinsJobMemberLoginCheck";
		
	}
	@RequestMapping(value="/twins/jmIDController")
	public String JobMemberFindID(JobMemberVo jmv){
		
		
		return "/Member/TwinsJobMemberGetID";
		
	}
	@RequestMapping(value="/twins/jmPswordController")
	public String JobMemberFindPsword(JobMemberVo jmv){
		
	
	return "/Member/TwinsJobMemberGetPsword";
	}
	@RequestMapping(value="/twins/jmGetPswordController")
	public String JobMemberGetPsword(JobMemberVo jmv,Model model){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		map.put("jmid", jmv.getJmid());
		map.put("jmemail",jmv.getJmemail());
		
		String getps = jmdf.getPswordJobMember(map);
		
		model.addAttribute("getps", getps);
		
		return "redirect:/twins/jmLoginController";
		
	}
	@RequestMapping(value="/twins/jmMainController")
	public String JobMemberMain(JobMemberVo jmv,Model model){
		
		model.addAttribute("jmv", jmv);
		
		return "TwinsMain";
		
	}
	@RequestMapping(value="/twins/jmConfimController")
	public String JobMemberConfirm(@RequestParam("jmid")String jmid,Model model){
		
		return "/Member/TwinsMemberConfirm";
	}
}
