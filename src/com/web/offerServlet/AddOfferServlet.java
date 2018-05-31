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
 * Servlet implementation class AddOfferServlet
 */
@WebServlet("/AddOfferServlet")
public class AddOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AddStaffServlet");
		// 1 获取员工的信息
		String oname = request.getParameter("oname");
		String oad = request.getParameter("oad");
		String olike = request.getParameter("olike");
		String ophone = request.getParameter("ophone");
		String operson = request.getParameter("operson");

		// 普通员工9级权限
		// 2 将员工信息封装成对象
		OfferJavaBean offer= new OfferJavaBean(oname, oad, olike, ophone, operson,1);
		
		// 3 调用数据方法
		System.out.println("offer:" + offer);
		OfferDAOImpl offerDAOImpl=new OfferDAOImpl();
		offerDAOImpl.add(offer);
		// 4 给出提示
		response.sendRedirect("success.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
