package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SalaryDao;
import Model.SalaryVo;

/**
 * Servlet implementation class SalaryWriteActionServelt
 */
@WebServlet("/SalaryWriteActionServelt")
public class SalaryWriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryWriteActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("UTF-8");
	    int amount = Integer.parseInt(request.getParameter("amount"));
	    int round = Integer.parseInt(request.getParameter("round"));  
	    int idx = Integer.parseInt(request.getParameter("idx"));
	    
	    SalaryDao sd = new SalaryDao();
	    
	    SalaryVo sv = new SalaryVo();
	    
	    sv.setAmount(amount);
	    sv.setRound(round);
	    sv.setIdx(idx);
	    
	    int max = sd.getMax();
	    int row = sd.insertWrite(sv, max); 
	    
	    //row 0이면 입력안됨
//	    if (row ==0) {
//	    response.sendRedirect(request.getContextPath()+"/Controller/SalaryWriteServlet.do");	
//	    }
//	    else{
//	    response.sendRedirect(request.getContextPath()+"/Controller/SalaryListServlet.do");
//	    }
	}

}
