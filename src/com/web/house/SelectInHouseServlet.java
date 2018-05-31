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
import com.web.model.StoreJavaBean;

/**
 * Servlet implementation class SelectInHouseServlet
 */
@WebServlet("/SelectInHouseServlet")
public class SelectInHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectInHouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//				1 首先获取仓库的编码
				String inHouseid = request.getParameter("searchInput");
//			2 然后将仓库的信息获取出来
				HouseDAOImpl houseDAOImpl=new HouseDAOImpl();
				List<IhouseJavaBean> list = houseDAOImpl.getInhouse(inHouseid);
				request.setAttribute("listResult", list);
					request.getRequestDispatcher("/inHouseSelect.jsp").forward(request, response);
							
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
