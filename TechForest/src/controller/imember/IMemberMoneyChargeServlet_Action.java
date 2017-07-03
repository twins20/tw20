package controller.imember;

import java.io.IOException;
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
 * Servlet implementation class IMemberMoneyChargeServlet_Action
 */
@WebServlet("/IMemberMoneyChargeServlet_Action")
public class IMemberMoneyChargeServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberMoneyChargeServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
	
		String contents = null; 
		int chgMoney = 0;
		
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();
		if(request.getParameter("chgmoney") != null) chgMoney = Integer.parseInt(request.getParameter("chgmoney").trim());
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		MoneyVo vo = new MoneyVo();
		vo.setChgMoney(chgMoney);
		vo.setContents(contents);
		vo.setIdx(idx);
		
		int row = 0;
		
		row = si.IMemberMoneyCharge(vo);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/IMemberMonyHisServlet.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
