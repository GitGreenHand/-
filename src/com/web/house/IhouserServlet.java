package com.web.house;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.HouseDAOImpl;
import com.web.model.IhouseJavaBean;

/**
 * Servlet implementation class IhouserServlet
 */
@WebServlet("/IhouserServlet")
public class IhouserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iid =request.getParameter("iid"); 
		String iWid =request.getParameter("iwid"); 
		String iPid=request.getParameter("ipid");
		String itime=request.getParameter("itime");
		String iperson=request.getParameter("iperson"); 
		int iprice=Integer.parseInt(request.getParameter("iprice")); 
		int icount=Integer.parseInt(request.getParameter("icount")); 
		int isum=Integer.parseInt(request.getParameter("isum")); 
		
		IhouseJavaBean ihouse=new IhouseJavaBean(iid, iWid, iPid,  itime, iperson, iprice, icount, isum);
		HouseDAOImpl impl=new HouseDAOImpl();
		boolean flag = impl.in(ihouse);
	if(flag)
	{
		response.sendRedirect("success.jsp");
	}
	else
	{//如果错误就是库存地方不够
		request.setAttribute("message", "库存空间不足");
		request.getRequestDispatcher("/GetPartidAndWareHouseidServlet?choose=1").forward(request, response);
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
