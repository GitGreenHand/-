package com.web.partServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAOImpl.PartDAOImpl;
import com.web.model.PartJavaBean;
@WebServlet("/PartSelectServlet")
public class PartSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 步骤
		//知道是查询零件操作，要查询零件需要知道零件的id号
//		1获取当前的要查询的主键
		String mainKey = request.getParameter("partKey");
		String content = request.getParameter("searchInput");
		System.out.println("mainKey:"+mainKey);
		System.out.println("content:"+content);
		System.out.println("我的选择是："+mainKey);
	
//		3调用DAO
		PartDAOImpl partDAOImpl=new PartDAOImpl();
		List<PartJavaBean> list = partDAOImpl.select(mainKey, content);
//		4 给出提示
		System.out.println("list:"+list);
		request.setAttribute("listResult", list);
//		5 调转到显示界面
		request.getRequestDispatcher("/showPartList.jsp").forward(request, response);
		
	//response.sendRedirect("success.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
