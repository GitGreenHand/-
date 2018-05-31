package com.web.house;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.HouseDAOImpl;
import com.web.model.IhouseJavaBean;
import com.web.model.OhouseJavaBean;

/**
 * Servlet implementation class SelectOutHouseServlet
 */
@WebServlet("/SelectOutHouseServlet")
public class SelectOutHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOutHouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		1 首先获取仓库的编码
		String outHouseid = request.getParameter("searchInput");
//	2 然后将仓库的信息获取出来
		HouseDAOImpl houseDAOImpl=new HouseDAOImpl();
		List<OhouseJavaBean> list = houseDAOImpl.getOuthouse(outHouseid);
		request.setAttribute("listResult", list);
			request.getRequestDispatcher("/outHouseSelect.jsp").forward(request, response);
					}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
