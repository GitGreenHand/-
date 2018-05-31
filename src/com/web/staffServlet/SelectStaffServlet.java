package com.web.staffServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.StaffDAOImpl;
import com.web.model.StaffJavaBean;

@WebServlet("/SelectStaffServlet")
public class SelectStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 步骤
				//知道是查询零件操作，要查询零件需要知道零件的id号
//				1获取当前的要查询的主键
				String mainKey = request.getParameter("staffKey");
				String content = request.getParameter("searchInput");
				System.out.println("mainKey:"+mainKey);
				System.out.println("content:"+content);
				System.out.println("我的选择是："+mainKey);
			
//				3调用DAO
				StaffDAOImpl staffDAOImpl= new StaffDAOImpl();
				List<StaffJavaBean> list = staffDAOImpl.select(mainKey, content);
				
//				4 给出提示
				System.out.println("list:"+list);
				request.setAttribute("listResult", list);
//				5 调转到显示界面
				request.getRequestDispatcher("/showStaffList.jsp").forward(request, response);
				
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
