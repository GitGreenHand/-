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
 * Servlet implementation class UpdateOfferServletBack
 */
@WebServlet("/UpdateOfferServletBack")
public class UpdateOfferServletBack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 获取零件的所有信息
		String oname = request.getParameter("oname");
		String oad = request.getParameter("oad");
		String olike = request.getParameter("olike");
		String ophone = request.getParameter("ophone");
		String operson = request.getParameter("operson");

		// 2 创建一个零件对象，将零件信息封装在其中
		OfferJavaBean offer = new OfferJavaBean(oname, oad, olike, ophone, operson,1);
		// 3 利用数据库访问对象调用添加方法
		OfferDAOImpl offerDAOImpl = new OfferDAOImpl();
		offerDAOImpl.update(offer);
		response.sendRedirect("success.jsp");
		// 2 调用数据库操作对象
		// 3 给出提示

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
