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
 * Servlet implementation class SalaryModifyActionServlet
 */
@WebServlet("/SalaryModifyActionServlet")
public class SalaryModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryModifyActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		int sidx = Integer.parseInt(request.getParameter("sidx")); // idx 값
		int amount = Integer.parseInt(request.getParameter("amount")); // 네임 값
		int round = Integer.parseInt(request.getParameter("round")); // 나이
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		SalaryDao sd = new SalaryDao(); // 객체 생성
		SalaryVo sv = new SalaryVo(); // private 값 가져옴
		
		sv.setAmount(amount);
		sv.setRound(round);
		sv.setIdx(idx);

		int ra = sd.Update(sv, sidx); 
		
//		if (ra ==0) { // 실패 시 write로 다시 감
//		response.sendRedirect(request.getContextPath()+"/Controller/SalaryWriteServlet.do");	
//		}
//		else{ // 성공 시 리스트 화면으로 오고 데이터가 바뀜
//		response.sendRedirect(request.getContextPath()+"/Controller/SalaryListServlet.do");
//		}
	
	}

}
