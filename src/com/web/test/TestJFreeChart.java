package com.web.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import com.web.DAOImpl.ChartDAIOImpl;

/**
 * Servlet implementation class TestJFreeChart
 */
@WebServlet("/TestJFreeChart")
public class TestJFreeChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   ChartDAIOImpl impl=new ChartDAIOImpl();
		JFreeChart chart = impl.createColumnarTools();
		    // 将图形转换为图片传到dateSet.jsp
		    String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
		            null, request.getSession());
		    String chartURL = request.getContextPath() + "/chart?filename="
		            + fileName;
		    
		    request.setAttribute("chartColumnURL", chartURL);
		    request.getRequestDispatcher("/chart.jsp").forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
