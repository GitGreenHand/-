package com.web.offerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.OfferDAOImpl;

/**
 * Servlet implementation class DeleteOfferServlet
 */
@WebServlet("/DeleteOfferServlet")
public class DeleteOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		1获取要删除的id值
			String deleteId = request.getParameter("oname");
//		2创建数据库操作对象
			OfferDAOImpl offerDAOImpl=new OfferDAOImpl();
			boolean istrue = offerDAOImpl.delete(deleteId);
			System.out.println(istrue);
			response.sendRedirect("success.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
