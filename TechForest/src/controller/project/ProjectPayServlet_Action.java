package controller.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.*;

/**
 * Servlet implementation class ProjectPayServlet_Action
 */
@WebServlet("/ProjectPayServlet_Action")
public class ProjectPayServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectPayServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pIdx = 0, itIdx = 0, idx = 0, inFunds = 0;
		int row = 0;
		
		if(request.getParameter("pIdx") != null) pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		if(request.getParameter("itIdx") != null) itIdx = Integer.parseInt(request.getParameter("itIdx").trim(),10);
		if(request.getParameter("idx") != null) idx = Integer.parseInt(request.getParameter("idx").trim(),10);
		if(request.getParameter("inFunds") != null) inFunds = Integer.parseInt(request.getParameter("inFunds").trim(),10);
		
		FundVo inputFV = new FundVo();
		inputFV.setpIdx(pIdx);
		inputFV.setItIdx(itIdx);
		inputFV.setIdx(idx);
		inputFV.setInFunds(inFunds);
			
		ProjectServiceImpl ps = new ProjectServiceImpl();
		
		//트랜잭션 사용
		row += ps.projPayTransaction(inputFV);

		//트랜잭션 미사용		
//		row += ps.projPay(inputFV);
//		if(row != 0) row += ps.projPayWishListDel(inputFV);
//		if(row != 0) row += ps.projPayMyMoneyChg(inputFV);	
//		if(row != 0) row += ps.projPayPnFundsMod(inputFV);
//		if(row != 0) row += ps.projPayItemSellCntMod(inputFV);
		
//		System.out.println(row);

		PageRedirect pr = new PageRedirect(true, "/index.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
