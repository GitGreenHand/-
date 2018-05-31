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
 * Servlet implementation class UpdateWarehouseServletBack
 */
@WebServlet("/UpdateWarehouseServletBack")
public class UpdateWarehouseServletBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private final int  ENNABLE=1;
     // private final int  DISNABLE=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWarehouseServletBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取零件的所有信息
		String wid =request.getParameter("wid");
		String wad =request.getParameter("wad"); 
		int wsize =Integer.parseInt(request.getParameter("wsize"));
		String wphone =request.getParameter("wperson");
		String wperson =request.getParameter("wperson");
		int wspace =Integer.parseInt(request.getParameter("wspace"));
		//int wstate=request.getParameter("wstate");
		
//		2 创建一个零件对象，将零件信息封装在其中
		WarehouseJavaBean warehouser=new WarehouseJavaBean(wid, wad, wsize, wphone, wperson, wspace,ENNABLE);
//		3 利用数据库访问对象调用添加方法
		WarehouseDAOImpl warehouseDAOImpl=new WarehouseDAOImpl();
		warehouseDAOImpl.update(warehouser);
		System.out.println(wid+":wid 已经修改了");
			response.sendRedirect("success.jsp");	
//	2 调用数据库操作对象
//	3 给出提示
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
