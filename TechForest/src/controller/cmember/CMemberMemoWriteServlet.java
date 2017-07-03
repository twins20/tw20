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
 * Servlet implementation class CMemberMemoWriteServlet
 */
@WebServlet("/CMemberMemoWriteServlet")
public class CMemberMemoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberMemoWriteServlet() {
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
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();

		CMemberServiceImpl cs = new CMemberServiceImpl();
		alist = cs.cMemMemoWriteIMemList(idx, 10, 1);
		
		request.setAttribute("alist", alist);
		
//		alist = (ArrayList<MemberVo>) request.getAttribute("alist"); 
//		
//		for(MemberVo vo : alist){
//			System.out.println(vo.getIdx());	
//			System.out.println(vo.getNick());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberMemoWrite.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
