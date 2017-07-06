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
import service.MoneyVo;

/**
 * Servlet implementation class IMemberMoneyHisServlets
 */
@WebServlet("/IMemberMoneyHisServlet")
public class IMemberMoneyHisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberMoneyHisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = 1;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		ArrayList<MoneyVo> alist = new ArrayList<MoneyVo>();
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		alist = si.IMemberMoneyHisList(idx, 10, 1);
		
		request.setAttribute("alist", alist);
		request.setAttribute("idx", idx);
		
		PageRedirect pr = new PageRedirect(false, "/imember/IMemberMoneyHis.jsp", request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
