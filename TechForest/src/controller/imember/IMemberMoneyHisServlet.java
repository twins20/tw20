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
@WebServlet("/IMemberMoneyHisServlets")
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
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		ArrayList<MoneyVo> alist = si.IMemberMoneyHisList(idx);
		
		request.setAttribute("alist", alist);
		
		alist = (ArrayList<MoneyVo>) request.getAttribute("alist");
		
		for(MoneyVo vo : alist){
			
		String status = null;
			if(vo.getStatus() == 0){
				status = "신청";
			}else if(vo.getStatus() == 1){
				status = "완료";
			}else if(vo.getStatus() == 2){
				status = "취소";
			}
			
//			System.out.println(vo.getmIdx());
//			System.out.println(vo.getChgMoney());
//			System.out.println(vo.getInsDate());
//			System.out.println(status);
			
		}
		
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
