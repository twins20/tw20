package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberInfoModServlet_Action
 */
@WebServlet("/CMemberInfoModServlet_Action")
public class CMemberInfoModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberInfoModServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		int phone = 0;
		String pw = null, nick = null, addr = null;
				
		if(request.getParameter("pw") != null) pw = request.getParameter("pw").trim();
		if(request.getParameter("nick") != null) nick = request.getParameter("nick").trim();
		if(request.getParameter("phone") != null) phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		if(request.getParameter("addr") != null) addr = request.getParameter("addr").trim();
				
		MemberVo vo = new MemberVo();
		vo.setIdx(idx);
		vo.setPw(pw);
		vo.setNick(nick);
		vo.setPhone(phone);
		vo.setAddr(addr);
		
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemInfoMod(vo);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/CMemberInfoCon.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
