package com.web.warehouseServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.WarehouseDAOImpl;
import com.web.model.WarehouseJavaBean;

/**
 * Servlet implementation class UpdateWarehouseServlet
 */
@WebServlet("/UpdateWarehouseServlet")
public class UpdateWarehouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWarehouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		1获取要删除的id值
			String updateId = request.getParameter("wid");
//		2创建数据库操作对象
			WarehouseDAOImpl warehouseDAOImpl=new WarehouseDAOImpl();
			WarehouseJavaBean warehouse = warehouseDAOImpl.get(updateId);
			
			request.setAttribute("updateWarehouse", warehouse);
			
//		3转发到界面上
		request.getRequestDispatcher("/updateWarehouse.jsp").forward(request, response);
		
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
