package com.web.partServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.PartDAOImpl;
import com.web.model.PartJavaBean;

/**
 * Servlet implementation class partAddServlet
 */
@WebServlet("/partAddServlet")
public class partAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		1 获取零件的所有信息
		
		String pid=request.getParameter("P_id");
		String pname=request.getParameter("P_name");
		String psp=request.getParameter("P_sp");
		String  pprice=request.getParameter("P_price");
		String poffer=request.getParameter("P_offer");
		String ptime=request.getParameter("P_time");
		
//		2 创建一个零件对象，将零件信息封装在其中
		PartJavaBean part=new PartJavaBean(pid, pname, psp,Double.parseDouble(pprice) , poffer, ptime,1);
//		3 利用数据库访问对象调用添加方法
		PartDAOImpl partDAOImpl=new PartDAOImpl();
		partDAOImpl.add(part);
//		4 显示和重定向
	response.sendRedirect("success.jsp ");
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
