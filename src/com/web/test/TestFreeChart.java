package com.web.test;

import java.io.*;
import java.sql.*;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

public class TestFreeChart {
	
	public static void main() throws Exception {
		//String mobilebrands[] = { "IPhone 5s", "SamSung Grand", "MotoG", "Nokia Lumia" };
		
		/* Create MySQL Database Connection */
		test();
	}
	@Test
	private static void test() throws ClassNotFoundException, SQLException, IOException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String username = "hr";
		String password = "123456";
		Class.forName(driver);
		Connection connect = DriverManager.getConnection(url, username, password);
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from testchart");
		DefaultPieDataset dataset = new DefaultPieDataset();
		while (resultSet.next()) {
			dataset.setValue(resultSet.getString("tname"), (resultSet.getInt("tvalue")));
		}
		JFreeChart chart = ChartFactory.createPieChart("手机价格", // chart
				dataset, // data
				true, // include legend
				true, false);
		int width = 560; /* Width of the image */
		int height = 370; /* Height of the image */
		File pieChart = new File("Pie_Chart.jpeg");
		ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
	}
}
