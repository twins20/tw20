package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.MemberServiceImpl;
import service.MemberVo;


@WebServlet("/AdminImemWriteServlet_Action")
public class AdminImemWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminImemWriteServlet_Action() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int phone = 0, status = 0;
		String id = null, pw = null, name = null, nick = null, addr = null, type = null;
		int row = 0;
		
		if(request.getParameter("id") != null) id = request.getParameter("id").trim();
		if(request.getParameter("pw") != null) pw = request.getParameter("pw").trim();
		if(request.getParameter("name") != null) name = request.getParameter("name").trim();
		if(request.getParameter("nick") != null) nick = request.getParameter("nick").trim();
		if(request.getParameter("phone") != null) phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		if(request.getParameter("addr") != null) addr = request.getParameter("addr").trim();
		if(request.getParameter("status") != null) status = Integer.parseInt(request.getParameter("status").trim(),10);
		if(request.getParameter("type") != null) type = request.getParameter("type").trim();
				
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setNick(nick);
		vo.setPhone(phone);
		vo.setAddr(addr);
		vo.setStatus(status);
		vo.setType(type);
		
		MemberServiceImpl ms = new MemberServiceImpl();
		row = ms.memJoin(vo);
		
		System.out.println(row);
		PageRedirect pr = new PageRedirect(false, "/admin/AdminImeminfoList.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
