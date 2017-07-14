package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.*;
import service.*;

/**
 * Servlet implementation class MemberFindMailServlet_Action
 */
@WebServlet("/MemberFindMailServlet_Action")
public class MemberFindMailServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindMailServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int phone = 0;
		String name = null;
		
		if(request.getParameter("name") != null){
			name = request.getParameter("name").trim();
		}
		if(request.getParameter("phone") != null){
			phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		}
				
		MemberVo inputMV = new MemberVo();
		inputMV.setName(name);
		inputMV.setPhone(phone);
		
		MemberVo vo = new MemberVo();
		
		MemberServiceImpl ms = new MemberServiceImpl();
		vo = ms.memMemberFindMail(inputMV);
		
		request.setAttribute("vo", vo);

//		System.out.println(vo.getId());
		
		PageRedirect pr = new PageRedirect(false, "/member/MemberFindMail_View.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
