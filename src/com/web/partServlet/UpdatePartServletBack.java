package com.web.partServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.PartDAOImpl;
import com.web.model.PartJavaBean;
@WebServlet("/UpdatePartServletBack")
public class UpdatePartServletBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取零件的所有信息
		String P_id=request.getParameter("P_id");
		String P_name=request.getParameter("P_name");
		String P_sp=request.getParameter("P_sp");
		String  P_price=request.getParameter("P_price");
		String P_offer=request.getParameter("P_offer");
		String P_time=request.getParameter("P_time");
		
//		2 创建一个零件对象，将零件信息封装在其中
		PartJavaBean part=new PartJavaBean(P_id, P_name, P_sp,Double.parseDouble(P_price) , P_offer, P_time,1);
//		3 利用数据库访问对象调用添加方法
		PartDAOImpl partDAOImpl=new PartDAOImpl();
		partDAOImpl.update(part);
			response.sendRedirect("success.jsp");	
//	2 调用数据库操作对象
//	3 给出提示
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
