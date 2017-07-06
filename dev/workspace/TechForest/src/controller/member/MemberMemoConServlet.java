package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.MemberServiceImpl;
import service.MemoVo;

/**
 * Servlet implementation class MemberMemoConServlet
 */
@WebServlet("/MemberMemoConServlet")
public class MemberMemoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMemoConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int memoIdx = 0;
			
		if(request.getParameter("memoIdx") != null) memoIdx = Integer.parseInt(request.getParameter("memoIdx").trim(),10);
						
		MemoVo vo = new MemoVo();
		
		MemberServiceImpl ms = new MemberServiceImpl();
		vo = ms.memMemoCon(memoIdx);
		
		request.setAttribute("vo", vo);
		
//		vo = (MemoVo) request.getAttribute("vo");
//		
//		System.out.println(vo.getMemoIdx());
//		System.out.println(vo.getSendIdx());
//		System.out.println(vo.getRecvIdx());
//		System.out.println(vo.getContents());
//		System.out.println(vo.getStatus());
				
		PageRedirect pr = new PageRedirect(false, "/member/MemberMemoCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
