package com.web.partServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.PartDAOImpl;

@WebServlet("/DeletePartServlet")
public class DeletePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		1获取要删除的id值
			String deleteId = request.getParameter("pid");
//		2创建数据库操作对象
			PartDAOImpl partDAOImpl=new PartDAOImpl();
			partDAOImpl.delete(deleteId);
			//request.setAttribute("updatePart", part);
			response.sendRedirect("success.jsp");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
