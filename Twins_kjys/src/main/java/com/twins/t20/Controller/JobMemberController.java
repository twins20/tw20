package com.twins.t20.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twins.t20.Domain.JobMemberVo;
import com.twins.t20.Service.JobMemberDaoFather;

@Controller
@RequestMapping(value="/twins")
public class JobMemberController {
	
	@Autowired
	private JobMemberDaoFather jmds;
	
	 @Autowired
	 JavaMailSender mailSender;
	 
	@RequestMapping(value="/jmMainController")
	public String JobMemberMain(
			JobMemberVo jmv,
			String msg,
			Model model
		   ){
		
		model.addAttribute("jmv", jmv);
		model.addAttribute("msg", msg);
		
		return "TwinsMain";	
	}
	
	
	@RequestMapping(value="/jmLoginController")
	public String JobMemberLogin(
			String msg,
			Model model
		   ){
		
//		String jmname = jmv.getJmname();
//		String jmemail =jmv.getJmemail();
		
		model.addAttribute("msg", msg);
		
		return "/Member/TwinsJobMemberLoginCheck";
	}
	
	
	@RequestMapping(value="/jmLoginCheckController")
	public String JobMemberLoginCheck(
			JobMemberVo jmv, 
			RedirectAttributes rttr
		   ){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		map.put("jmid", jmv.getJmid());
		map.put("jmpsword", jmv.getJmpsword());
		
		JobMemberVo jmvr = jmds.loginJobMember(map); 
		
		if(jmvr == null) {
			String msg = "�α��ο� �����Ͽ����ϴ�. �ٽ� �α����Ͽ� �ֽʽÿ�.";
			rttr.addAttribute("msg", msg);
			return "redirect:/twins/jmLoginController";
		}
		
		String jmid = jmvr.getJmid();
		int jmidx= jmvr.getJmidx();
		String jmname = jmvr.getJmname();
		
		rttr.addAttribute("jmid", jmid);
		rttr.addAttribute("jmidx", jmidx);
		rttr.addAttribute("jmname", jmname);

		return "redirect:/twins/jmMainController";
	}
	@RequestMapping(value="/jmLoginOutController")
	public String JobMemberLoginOut(HttpSession session,Model model){
		
		jmds.loginout(session);
		System.out.println("�α׾ƿ�"+session);
		return "redirect:/twins/jmLoginController";
	}
	
	@RequestMapping(value="/jmJoinController")
	public String JobMemberJoin(
			String msg, 
			Model model
		   ){
		
		model.addAttribute("msg", msg);		
		return "/Member/TwinsJobMemberJoin";
	}
	
	
	@RequestMapping(value="/jmJoinActionController")
	public String JobMemberJoinAction(
			JobMemberVo jmv,
			RedirectAttributes rttr
		   ){
		
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");		
		String date = sdf.format(dt);		
		date = date.substring(2);		
				
		jmv.setJmregdate(date);
	
		int rd = jmds.insertJobMember(jmv);

//		int rd = 0;  // �׽�Ʈ ��

		String msg;
		
		if (rd == 0) {
			msg = "ȸ�����Կ� �����Ͽ����ϴ�. �ٽ��ѹ� �õ��� �ֽʽÿ�.";
			rttr.addAttribute("msg", msg);
			
			return "redirect:/twins/jmJoinController";
		} else {
			msg = "ȸ�������� ���ϵ帳�ϴ�. Twins�� ���Ű��� ȯ���մϴ�. �α��� ���ֽʽÿ�.";
			rttr.addAttribute("msg", msg);
			
			return "redirect:/twins/jmLoginController";
		}		
	}
	
	@RequestMapping(value="/jmConfirmIDController")
	public String JobMemberConfirmID(
//			@ModelAttribute("jmid")String jmid,
			String jmid,
			Model model
		   ) {
		
		String url = "";
		
		System.out.println("���̵� = " + jmid);	
		int rd = jmds.confirmJobMemberID(jmid);
		
		System.out.println("rd = " + rd);
		model.addAttribute("rd", rd);	
		
		url = "/Member/TwinsJobMemberConfirm";
		
//		if(rd != 0){
//			url = "/Member/TwinsJobMemberJoin";
//		}else{
//			url = "/Member/TwinsJobMemberConfirm";
//		}
		
		return url;
	}
	
	
	@RequestMapping(value="/jmDropController")
	public String JobMemberDrop(
			JobMemberVo jmv,
			Model model,
			RedirectAttributes rttr
		   ){
		
//		System.out.println("jmDropContoller�� jmv.jmidx = " + jmv.getJmidx());
//		System.out.println("jmDropContoller�� jmv.jmid = " + jmv.getJmid());
//		System.out.println("jmDropContoller�� jmv.jmname = " + jmv.getJmname());
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		
		map.put("jmidx", jmv.getJmidx());
		map.put("jmid", jmv.getJmid());
		
		int rd = jmds.deleteJobMember(map);
		
		System.out.println("jmDropContoller�� rd = " + rd);

//		rd = 0; // �׽�Ʈ ��    // or jmid = 'admin'
		
		if (rd == 1) {
			
			model.addAttribute("jmv", jmv);				
			
			return "/Member/TwinsJobMemberDrop";
		} else {		
			String msg = "ȸ��Ż�� ó���� ���� �Ͽ����ϴ�. �ٽ��ѹ� �õ��� �ֽʽÿ�.";
			
			rttr.addAttribute("jmidx", jmv.getJmidx());
			rttr.addAttribute("jmid", jmv.getJmid());
			rttr.addAttribute("jmname", jmv.getJmname());
			rttr.addAttribute("msg",  msg);
			
			return "redirect:/twins/jmMainController";
		}
	}
	
	
	@RequestMapping(value="/jmChangePswordController")
	public String JobMemberChangePsword(
			Integer jmidx,
			String msg,
			Model model
		   ){
		
		JobMemberVo jmv = jmds.selectJobMember(jmidx);
		
//		System.out.println("��й�ȣ : " + jmv.getJmpsword());
		
		model.addAttribute("jmv", jmv);
		model.addAttribute("msg", msg);
		
		return "/Member/TwinsJobMemberChangePsword";
	}
	
	
	@RequestMapping(value="/jmChangePswordActionController")
	public String JobMemberChangePswordAction(
			JobMemberVo jmv,
			RedirectAttributes rttr
		   ){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		
		map.put("jmpsword", jmv.getJmpsword());
		map.put("jmidx",jmv.getJmidx());
		
//		System.out.println("�� ��й�ȣ : " + jmv.getJmpsword());
		
		int rd = jmds.changePsword(map);
		
//		rd = 0;  // �׽�Ʈ ��
		
		if (rd == 1) {
			String msg = "��й�ȣ ���濡 �����Ͽ����ϴ�.";
			
			rttr.addAttribute("jmidx", jmv.getJmidx());
			rttr.addAttribute("jmid", jmv.getJmid());
			rttr.addAttribute("jmname", jmv.getJmname());
			rttr.addAttribute("msg", msg);
			
			return "redirect:/twins/jmMainController";
		} else {
			String msg = "��й�ȣ ���濡 �����Ͽ����ϴ�. �ٽ��ѹ� �õ��� �ֽʽÿ�.";
			int jmidx = jmv.getJmidx();
			
			rttr.addAttribute("jmidx", jmidx);
			rttr.addAttribute("msg", msg);
			
			return "redirect:/twins/jmChangePswordController";
		}	
	}
	
	
	@RequestMapping(value="/jmModifyController")
	public String JobMemberModify(
			JobMemberVo jmv,
			String msg,
			Model model
		   ){
	
		jmv = jmds.selectJobMember(jmv.getJmidx());
	
		model.addAttribute("jmv", jmv);
		model.addAttribute("msg", msg);   // ��� ó������ ��� ��
	
		return "/Member/TwinsJobMemberModify";
	}
	
	
	@RequestMapping(value="/jmModifyActionController")
	public String JobMemberModifyAction(
			JobMemberVo jmv,
			RedirectAttributes rttr
		   ) throws Exception {
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
	
		map.put("jmemail", jmv.getJmemail());
		map.put("jmaddr", jmv.getJmaddr());
		map.put("jmidx", jmv.getJmidx());
		
		int rd = jmds.modifyJobMember(map);
		
		String msg = "";
		
		if (rd == 1) {
//			msg = "�� ���� ������ �����Ͽ����ϴ�."; 	// iframe�� �̿��Ͽ� 
										        // alertó�� ���			
		} else {
//			msg = "�� ���� ������ �����Ͽ����ϴ�. �ٽ� �õ��Ͽ� �ֽʽÿ�.";  						        
									// iframe�� �̿��Ͽ� alertó�� ���			
		}
		
		System.out.println("\njmModifyActionController�� rd = " + rd);
		
		rttr.addAttribute("jmidx", jmv.getJmidx());
		rttr.addAttribute("msg", msg);
		
		return "redirect:/twins/jmModifyController";
		// forward ����� ���� �޸𸮿� ����� ������ �״�� ������
		// ********** ��� ������ �ɰ��� ��� �ؾ� �� **********
	}
	
	
	@RequestMapping(value="/jmIDController")
	public String JobMemberFindID(){
		
		return "/Member/TwinsJobMemberGetID";		
	}
	
	
	@RequestMapping(value="/jmGetIDController")
	public String JobMemberGetID(
			JobMemberVo jmv,
			RedirectAttributes rttr
		   ){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		
		map.put("jmname", jmv.getJmname());
		map.put("jmemail", jmv.getJmemail());
		
//		System.out.println(jmv.getJmname());
//		System.out.println(jmv.getJmemail());
		
		String id = jmds.getIDJobMember(map);
// 		�ٷ� �� �κ�. �̸��ϰ� �̸��� �Է��Ͽ� ���̵� �̾Ʒδ� ������ ������ �Ǵ��� �����ؾ� ��
		
//		id = "ok"; // �ӽ÷� ����	

		if (id != null) {
			
			// ���⿡ �̸��� ���� ���μ����� �־�� ��
			String msg = "���̵� �̸��Ϸ� �����Ͽ����ϴ�.";			
			rttr.addAttribute("msg",  msg);
			
			return "redirect:/twins/jmLoginController?";	
		} else {		
			String msg = "Twins ȸ���� �ƴմϴ�. ȸ�������� ���ֽʽÿ�.";
			rttr.addAttribute("msg",  msg);
			return "redirect:/twins/jmLoginController";	
		}	
	}
	
	
	@RequestMapping(value="/jmPswordController")
	public String JobMemberFindPsword(){
		
		return "/Member/TwinsJobMemberGetPsword";
	}
	
	
	@RequestMapping(value="/jmGetPswordController")
	public String JobMemberGetPsword(
			JobMemberVo jmv,
			RedirectAttributes rttr
		   ){
		
		HashMap<String,Object> map = new  HashMap<String,Object>();
		map.put("jmid", jmv.getJmid());
		map.put("jmemail",jmv.getJmemail());
		
		String ps = jmds.getPswordJobMember(map);
		// �ٷ� �� �κ�. �̸��ϰ� �̸��� �Է��Ͽ� �н����带 �̾Ʒδ� ������ ������ �Ǵ��� �����ؾ� ��
		
//		ps = "ok"; // �ӽ÷� ����	
		
		if (ps != null) {
			
			// ���⿡ �̸��� ���� ���μ����� �־�� ��
			String msg = "�ӽ� �н����带 �̸��Ϸ� �����Ͽ����ϴ�.";			
			rttr.addAttribute("msg",  msg);
			
			return "redirect:/twins/jmLoginController?";	
		} else {		
			String msg = "Twins ȸ���� �ƴմϴ�. ȸ�������� ���ֽʽÿ�.";
			rttr.addAttribute("msg",  msg);
			return "redirect:/twins/jmMailController";	
		}
	}
	
	
	@RequestMapping(value="/jmBlankPageController")
	public String JobMemberBlankPage(){
		
		return "/Member/TwinsJobMemberBlankPage";
	}
	
	@RequestMapping(value="/jmAgreementController")
	public String JobMemberAgreement(){
		
		return "/Member/TwinsJobMemberJoinAgreement";
	}
	@RequestMapping(value="/jmMailController")
	public String JobMemberMailSending(
			JobMemberVo jmv,
			Model model,
			HttpServletResponse response){
		
		String email = jmv.getJmemail();
		String content = jmv.getJmpsword();
		
		System.out.println("�̸���"+email);
		System.out.println("���"+content);
		 try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom("twinstw20@gmail.com");
			messageHelper.setTo(email);
			messageHelper.setText(content);
			
			mailSender.send(message);
			
		 } catch (MessagingException e) {
		
			e.printStackTrace();
		} 
		return "redirect:/twins/jmLoginController";
		
	}
}
