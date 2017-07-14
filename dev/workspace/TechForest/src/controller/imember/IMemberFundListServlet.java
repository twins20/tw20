package controller.imember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.FundVo;
import service.IMemberServiceImpl;
import service.ProjectVo;

/**
 * Servlet implementation class IMemberFundListServlet
 */
@WebServlet("/IMemberFundListServlet")
public class IMemberFundListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberFundListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
		
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		ArrayList<ProjectVo> pList = new ArrayList<ProjectVo>();
		ArrayList<FundVo> fList = new ArrayList<FundVo>();
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		pList = si.IMemberFundList(idx);
		
		for(ProjectVo vo : pList){
			
			Map<String,Object> data = new HashMap<String,Object>();	
			
			fList = si.IMemberFundStatus(vo.getpIdx());
			
			data.put("fList",fList);
			data.put("pVo", vo);
			
			dataList.add(data);	
			
		}
	
		request.setAttribute("dataList", dataList);
		request.setAttribute("idx", idx);
		
		PageRedirect pr = new PageRedirect(false, "/imember/IMemberFundList.jsp", request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
