package com.web.offerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.OfferDAOImpl;
import com.web.model.OfferJavaBean;

/**
 * Servlet implementation class UpdateOfferServlet
 */
@WebServlet("/UpdateOfferServlet")
public class UpdateOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
//		1获取要删除的id值
			String updateId = request.getParameter("oname");
//		2创建数据库操作对象
			OfferDAOImpl offerDAOImpl=new OfferDAOImpl();
			OfferJavaBean offer = offerDAOImpl.get(updateId);
			
			request.setAttribute("updateOffer", offer);
			
//		3转发到界面上
		request.getRequestDispatcher("/updateOffer.jsp").forward(request, response);
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
