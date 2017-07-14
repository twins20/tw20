package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.MemberServiceImpl;
import service.MemberVo;

/**
 * Servlet implementation class MemberFindPassServlet_Action
 */
@WebServlet("/MemberFindPassServlet_Action")
public class MemberFindPassServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPassServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int phone = 0;
		String id = null, name = null;
		
		if(request.getParameter("id") != null){
			id = request.getParameter("id").trim();
		}
		if(request.getParameter("name") != null){
			name = request.getParameter("name").trim();
		}
		if(request.getParameter("phone") != null){
			phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		}
		
		MemberVo inputMV = new MemberVo();
		inputMV.setId(id);
		inputMV.setName(name);
		inputMV.setPhone(phone);
						
		MemberVo vo = new MemberVo();
		
		MemberServiceImpl ms = new MemberServiceImpl();
		vo = ms.memMemberFindPass(inputMV);
		
		request.setAttribute("vo", vo);
		
		PageRedirect pr = new PageRedirect(false, "/member/MemberFindPass_View.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
