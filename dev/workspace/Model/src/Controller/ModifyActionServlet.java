package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDao;
import Model.MemberVo;

/**
 * Servlet implementation class ModifyActionServlet
 */
@WebServlet("/ModifyActionServlet")
public class ModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyActionServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		int idx = Integer.parseInt(request.getParameter("idx")); // idx 값
		String name = request.getParameter("name"); // 네임 값
		int age = Integer.parseInt(request.getParameter("age")); // 나이
		String sex = request.getParameter("sex"); // 성별
		String area = request.getParameter("area"); // 지역
		
		MemberDao md = new MemberDao(); // 객체 생성
		MemberVo vo = new MemberVo(); // private 값 가져옴
		
		vo.setName(name);
		vo.setAge(age);
		vo.setSex(sex);
		vo.setArea(area);

		int ra = md.Update(vo, idx); 
		
//		if (ra ==0) { // 실패 시 write로 다시 감
//		response.sendRedirect(request.getContextPath()+"/Controller//WriteServlet.do");	
//		}
//		else{ // 성공 시 리스트 화면으로 오고 데이터가 바뀜
//		response.sendRedirect(request.getContextPath()+"/Controller/ListServlet.do");
//		}
	}

}
