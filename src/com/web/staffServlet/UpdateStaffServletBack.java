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
 * Servlet implementation class UpdateStaffServletBack
 */
@WebServlet("/UpdateStaffServletBack")
public class UpdateStaffServletBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//1 获取零件的所有信息
		String stid = request.getParameter("stid");
		String stname = request.getParameter("stname");
		String stsex = request.getParameter("stsex");
		String stpart = request.getParameter("stpart");
		int stage = Integer.parseInt(request.getParameter("stage"));
		int stpower = Integer.parseInt(request.getParameter("stpower"));
			
		String stpassword="123"	;
//				2 创建一个零件对象，将零件信息封装在其中
		StaffJavaBean staff =new StaffJavaBean(stid, stname, stsex,stage,stpower,stpassword,stpart);
//				3 利用数据库访问对象调用添加方法
				StaffDAOImpl staffDAOImpl =new StaffDAOImpl();
				staffDAOImpl.update(staff);
					response.sendRedirect("success.jsp");	
//			2 调用数据库操作对象
//			3 给出提示
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
