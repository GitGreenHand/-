package com.web.warehouseServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.WarehouseDAOImpl;

/**
 * Servlet implementation class DeleteWarehouseServlet
 */
@WebServlet("/DeleteWarehouseServlet")
public class DeleteWarehouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWarehouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		1获取要删除的id值
			String deleteId = request.getParameter("wid");
//		2创建数据库操作对象
			WarehouseDAOImpl warehouseDAOImpl=new WarehouseDAOImpl();
			warehouseDAOImpl.delete(deleteId);
			//request.setAttribute("updatePart", part);
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
