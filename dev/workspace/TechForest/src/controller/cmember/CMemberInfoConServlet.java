package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberInfoConServlet
 */
@WebServlet("/CMemberInfoConServlet")
public class CMemberInfoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberInfoConServlet() {
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
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
				
		MemberVo vo = new MemberVo();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		vo = cs.cMemInfoCon(idx);
				
		request.setAttribute("vo", vo);
		
//		vo = (MemberVo) request.getAttribute("vo");
//		
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());
//		System.out.println(vo.getName());
//		System.out.println(vo.getNick());
//		System.out.println(vo.getPhone());
//		System.out.println(vo.getAddr());
//		System.out.println(vo.getStatus());
//		System.out.println(vo.getType());
//		System.out.println(vo.getCompany());
//		System.out.println(vo.getcNumber());
//		System.out.println(vo.getcAddr());
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberInfoCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
