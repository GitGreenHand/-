package com.web.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.AdminDAOImpl;
import com.web.model.AdminJavaBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入RegisterServlet");
		// 1 获取表单提交中所提交的值
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//System.out.println("id:"+id);
		//System.out.println("password:"+password);
		// 2 创建一个对象，将数据写入对象中,并且将用户的名字写入到session中。
		AdminJavaBean admin = new AdminJavaBean(id,password);

		//System.out.println("admin1:"+admin);
		// 3 链接数据库 两个步骤一起走
		// 4 将数据写入数据库中,调用数据库操作相应的DAO
		AdminDAOImpl adminDAOImpl = new AdminDAOImpl();
		adminDAOImpl.add(admin);//将用户插入进去
		//System.out.println("admin  "+admin);
		//System.out.println("日志："+request.getContextPath()+"/login.jsp");
		// connection.prepareStatement(SQL);
			// 6 并且给转发到主页面。
			//System.out.println("admin2:"+admin);
			request.setAttribute("id", id);
			request.setAttribute("password", password);
			
			request.getRequestDispatcher("/login.jsp")
			.forward(request, response);
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
