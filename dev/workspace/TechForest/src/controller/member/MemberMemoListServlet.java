package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.*;
import service.*;

/**
 * Servlet implementation class MemberMemoListServlet
 */
@WebServlet("/MemberMemoListServlet")
public class MemberMemoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMemoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idx = 0;
			
		if(request.getParameter("idx") != null) idx = Integer.parseInt(request.getParameter("idx").trim(),10);
						
		ArrayList<MemoVo> alist = new ArrayList<MemoVo>();
		
		MemberServiceImpl ms = new MemberServiceImpl();
		alist = ms.memMemoList(idx, 10, 1);
		
		request.setAttribute("alist", alist);
		
//		alist = (ArrayList<MemoVo>) request.getAttribute("alist");
//		
//		for(MemoVo vo : alist){
//			System.out.println(vo.getMemoIdx());
//			System.out.println(vo.getSendIdx());
//			System.out.println(vo.getRecvIdx());
//			System.out.println(vo.getContents());
//			System.out.println(vo.getStatus());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/member/MemberMemoList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}