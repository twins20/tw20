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




/**
 * Servlet implementation class SalaryListServlet
 */
@WebServlet("/SalaryListServlet")
public class SalaryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SalaryDao sd = new SalaryDao(); // 리스트에 있던 것을 가져옴
		ArrayList<SalaryVo> alist = sd.getSalaryList(); // 값을 꺼냄
		
		request.setAttribute("alist", alist); // set = 담다 / attribute = 속성 값을 담음
//		RequestDispatcher rd = request.getRequestDispatcher("/model2/Salary/List.jsp");
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
