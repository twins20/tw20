package controller.imember;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.IMemberServiceImpl;
import service.ProjectVo;

/**
 * Servlet implementation class IMemberWishListServlet
 */
@WebServlet("/IMemberWishListServlet")
public class IMemberWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberWishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
	
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		alist = si.IMemberWishList(idx, 10, 1);
		
//		request.setAttribute("alist", alist);
//		
//		alist = (ArrayList<ProjectVo>) request.getAttribute("alist");
//		
//		for(ProjectVo vo : alist){
//			
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getpName());	
//		System.out.println(vo.getPnFunds());
//		System.out.println(vo.getPtFunds());
//		System.out.println(vo.getPnFunds() / vo.getPtFunds() * 100);
//		}
		
		PageRedirect pr = new PageRedirect(false, "/imember/IMemberWishList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
