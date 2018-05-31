package com.web.staffServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.StaffDAOImpl;
import com.web.model.StaffJavaBean;

/**
 * Servlet implementation class UpdateStaffServlet
 */
@WebServlet("/UpdateStaffServlet")
public class UpdateStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		1获取要删除的id值
			String updateId = request.getParameter("stid");
//		2创建数据库操作对象
			StaffDAOImpl staffDAOImpl=new StaffDAOImpl();
					
			StaffJavaBean staff = staffDAOImpl.get(updateId);
			request.setAttribute("updateStaff", staff);
			
//		3转发到界面上
		request.getRequestDispatcher("/updateStaff.jsp").forward(request, response);
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
