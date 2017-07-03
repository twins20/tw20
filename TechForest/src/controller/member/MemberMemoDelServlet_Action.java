package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.MemberServiceImpl;
import service.MemoVo;

/**
 * Servlet implementation class MemberMemoDelServlet_Action
 */
@WebServlet("/MemberMemoDelServlet_Action")
public class MemberMemoDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMemoDelServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int memoIdx = 0;
		int row = 0;
		
		if(request.getParameter("memoIdx") != null) memoIdx = Integer.parseInt(request.getParameter("memoIdx").trim(),10);
			
		MemberServiceImpl ms = new MemberServiceImpl();
		row = ms.memMemoDel(memoIdx);
		
//		System.out.println(row);
				
		PageRedirect pr = new PageRedirect(true, "/member/MemberMemoList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
