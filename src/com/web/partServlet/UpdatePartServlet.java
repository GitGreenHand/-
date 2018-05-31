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
 * Servlet implementation class UpdatePartServlet
 */
@WebServlet("/UpdatePartServlet")
public class UpdatePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//	1获取要删除的id值
		String updateId = request.getParameter("Pid");
//	2创建数据库操作对象
		PartDAOImpl partDAOImpl=new PartDAOImpl();
		PartJavaBean part = partDAOImpl.get(updateId);
		request.setAttribute("updatePart", part);
		
//	3转发到界面上
	request.getRequestDispatcher("/updatePart.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
