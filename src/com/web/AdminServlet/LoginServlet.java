package com.web.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.DAOImpl.AdminDAOImpl;
import com.web.DAOImpl.OfferDAOImpl;
import com.web.DAOImpl.StaffDAOImpl;
import com.web.model.AdminJavaBean;
import com.web.model.StaffJavaBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入LoginServlet");
		// 1 获取表单提交中所提交的值
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		// 2 创建一个对象，将数据写入对象中,并且将用户的名字写入到session中。
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("type", type);

		// 3 链接数据库 两个步骤一起走
		AdminJavaBean admin = new AdminJavaBean();
		StaffJavaBean staff=new StaffJavaBean();
		// 4 将数据写入数据库中,调用数据库操作相应的DAO
		if (type.equals("admin")) {
			AdminDAOImpl aDaoImpl = new AdminDAOImpl();
			admin = aDaoImpl.select(id);// 根据id值查找用户
			session.setAttribute("notAdmin", null);
			if (admin == null) {
				request.setAttribute("error", "noUser");
				// System.out.println("admin "+admin);
				request.getRequestDispatcher("/error.jsp").forward(request, response);
				// connection.prepareStatement(SQL);
			} else if (admin.getSpassword().equals(password)) {
				// 5 成功给出提示！
				// System.out.println("password"+password);
				// System.out.println("admin.getSpassword"+admin.getSpassword());
				// System.out.println("成功登陆");
				// 6 并且给转发到主页面。
				// request.setAttribute("Sadmin", admin);
				System.out.println("存在" + admin.getId() + "用户");
				response.sendRedirect("main.jsp");
			} else {
				request.setAttribute("error", "errorMessage");
				request.getRequestDispatcher("/error.jsp").forward(request, response);

			}
		} else if("staff".equals(type)){
			session.setAttribute("notAdmin", "notAdmin");
			StaffDAOImpl aDaoImpl = new StaffDAOImpl();
			staff = aDaoImpl.get(id);// 根据id值查找用户
			if (staff == null) {
				request.setAttribute("error", "noUser");
				// System.out.println("admin "+admin);
				request.getRequestDispatcher("/error.jsp").forward(request, response);
				// connection.prepareStatement(SQL);
			} else if (staff.getStpassword().equals(password)) {
				// 5 成功给出提示！
				// System.out.println("password"+password);
				// System.out.println("admin.getSpassword"+admin.getSpassword());
				// System.out.println("成功登陆");
				// 6 并且给转发到主页面。
				// request.setAttribute("Sadmin", admin);
				System.out.println("存在" + staff.getStid() + "用户");
				response.sendRedirect("main.jsp");
			} else {
				request.setAttribute("error", "errorMessage");
				request.getRequestDispatcher("/error.jsp").forward(request, response);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
