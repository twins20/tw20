package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SalaryDao;
import Model.SalaryVo;


/**
 * Servlet implementation class SalaryContentServlet
 */
@WebServlet("/SalaryContentServlet")
public class SalaryContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int sidx = Integer.parseInt(request.getParameter("sidx"));
		SalaryDao sd = new SalaryDao(); // data access object
		SalaryVo sv = sd.getSalary(sidx); // value object
		
		request.setAttribute("sv", sv); // set = 담다 / attribute = 속성 값을 담음
		request.setAttribute("sidx", sidx);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/model2/Salary/Content.jsp");
//		// requestdispatcher 공유, 받고 
//		//RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/model2/List.jsp");
//		rd.forward(request, response); // 포워드 방식으로 requestdispatcher이 list로 값을 넘겨줌
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
