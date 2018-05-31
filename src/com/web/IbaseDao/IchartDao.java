package com.web.IbaseDao;

import org.jfree.chart.JFreeChart;

public interface IchartDao {
	
		public JFreeChart createColumnarTools();

		JFreeChart createColumnarTools(String wid);
}
