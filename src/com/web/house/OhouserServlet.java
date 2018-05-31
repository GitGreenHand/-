package com.web.house;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.HouseDAOImpl;
import com.web.model.IhouseJavaBean;
import com.web.model.OhouseJavaBean;

/**
 * Servlet implementation class OhouserServlet
 */
@WebServlet("/OhouserServlet")
public class OhouserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		String owid = request.getParameter("owid");
		String opid = request.getParameter("opid");
		String otime = request.getParameter("otime");
		String operson = request.getParameter("operson");
		int oprice = Integer.parseInt(request.getParameter("oprice"));
		int ocount = Integer.parseInt(request.getParameter("ocount"));
		int osum = Integer.parseInt(request.getParameter("osum"));

		OhouseJavaBean ohouse = new OhouseJavaBean(oid, owid, opid, otime, operson, oprice, ocount, osum);

		HouseDAOImpl impl = new HouseDAOImpl();
		boolean flag = impl.out(ohouse);
		if (!flag) // 如果库存不够
		{
			request.setAttribute("message", "库存不够");
			request.getRequestDispatcher("/GetPartidAndWareHouseidServlet?choose=0").forward(request, response);

		}
		// 如果库存够
		else {
			response.sendRedirect("success.jsp");

		}

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
