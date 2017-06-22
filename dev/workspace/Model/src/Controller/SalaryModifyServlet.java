package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SalaryDao;
import Model.SalaryVo;
import Model.MemberDao;
import Model.MemberVo;


/**
 * Servlet implementation class SalaryModifyServlet
 */
@WebServlet("/SalaryModifyServlet")
public class SalaryModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberDao md = new MemberDao();
		ArrayList<MemberVo> list = md.getMemberList();
		
	
		request.setAttribute("list",list);
		
		int sidx = Integer.parseInt(request.getParameter("sidx"));
		SalaryDao sd = new SalaryDao();
		SalaryVo sv = sd.Modify(sidx);
		
		request.setAttribute("sv", sv); // set = 담다 / attribute = 속성 값을 담음
		request.setAttribute("sidx", sidx);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/model2/Salary/Modify.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
