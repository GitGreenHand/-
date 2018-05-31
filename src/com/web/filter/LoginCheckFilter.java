package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/main.jsp"})
public class LoginCheckFilter implements Filter {

	public LoginCheckFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest servletRequest = (HttpServletRequest) request;
		  HttpServletResponse servletResponse = (HttpServletResponse) response;
		  HttpSession session = servletRequest.getSession();
		  //获取请求的路径
		  String path = servletRequest.getRequestURI();
		  //滤过登录和注册界面
		 //System.out.println("path:"+path);
		// int index= path.lastIndexOf("/");
		// System.out.println("index："+index);
		  String id = (String) session.getAttribute("id");
		  if(null==id){
			  servletRequest.setAttribute("error", "noLogin");
			  servletRequest.getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
		  }
		  chain.doFilter(servletRequest, servletResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
