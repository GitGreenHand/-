package com.web.house;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.HouseDAOImpl;

/**
 * Servlet implementation class GetPartidAndWareHouseidServlet
 */
@WebServlet("/GetPartidAndWareHouseidServlet")
public class GetPartidAndWareHouseidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPartidAndWareHouseidServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int choose= Integer.parseInt( request.getParameter("choose"));
		List<String> listpartid = new ArrayList<>();
		List<String> listwarehouseid = new ArrayList<>();
		HouseDAOImpl impl = new HouseDAOImpl();
		Map<String, List<String>> map = impl.getPartIdAndWareHouseId();
		listpartid = map.get("partid");
		listwarehouseid = map.get("warehouseid");
		//request.getAttribute("message");
		request.setAttribute("listPartId", listpartid);
		request.setAttribute("listWareHouseId", listwarehouseid);
		if (choose == 1)
		//当choose==1 就是入库查询
			{
			request.getRequestDispatcher("/inHouse.jsp").forward(request, response);
		} else if(choose == 0) {
			//当choose==0 就是出库查询
			request.getRequestDispatcher("/outHouse.jsp").forward(request, response);

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
