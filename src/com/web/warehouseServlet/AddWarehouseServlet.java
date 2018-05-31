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
 * Servlet implementation class AddWarehouseServlet
 */
@WebServlet("/AddWarehouseServlet")
public class AddWarehouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWarehouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		1 获取零件的所有信息
		String wid=request.getParameter("wid");
		String wad=request.getParameter("wad");
		String wsize=request.getParameter("wsize");
		String  wphone=request.getParameter("wphone");
		String wperson=request.getParameter("wperson");
		String wspace=request.getParameter("wspace");
		
//		2 创建一个零件对象，将零件信息封装在其中
		// 存在状态 默认为1
		WarehouseJavaBean warehouse = new WarehouseJavaBean(wid, wad,Integer.parseInt(wsize) , wphone, wperson, Integer.parseInt(wspace),1);
		
//		3 利用数据库访问对象调用添加方法
		WarehouseDAOImpl warehouseDAOImpl=new WarehouseDAOImpl();
		warehouseDAOImpl.add(warehouse);
//		4 显示和重定向
	response.sendRedirect("success.jsp ");
	
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
