package com.web.staffServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.StaffDAOImpl;
import com.web.model.StaffJavaBean;


@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("AddStaffServlet");
//		1 获取员工的信息
		String stid = request.getParameter("stid");
		String stname = request.getParameter("stname");
		String stsex = request.getParameter("stsex");
		String stage = request.getParameter("stage");
		String stpart = request.getParameter("stpart");
		
		 int stpower=9;
		String stpassword="123";
		//普通员工9级权限
		StaffJavaBean staff=new StaffJavaBean(stid, stname, stsex, Integer.parseInt(stage), stpower,stpassword,stpart);
//		2 将员工信息封装成对象
//		3 调用数据方法
		System.out.println("staff:"+staff);
		StaffDAOImpl staffDAOImpl =new StaffDAOImpl();
		staffDAOImpl.add(staff);
		
//		4 给出提示
		response.sendRedirect("success.jsp");
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
