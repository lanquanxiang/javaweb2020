package cn.pzhuweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.model.UserUtil;
import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.UserInfo;

/**
 * Servlet implementation class TodoServlet
 */

public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String sage = request.getParameter("age");
		String [] hobby = request.getParameterValues("hobby");		
		Integer age = 0;
		try {
			age = Integer.parseInt(sage);
		} catch (Exception e) {
			request.getSession().setAttribute("error", "年龄没有输入或者不是数字！");
			response.sendRedirect("error.jsp");
			return;
		}		
		UserInfo userInfo = new UserInfo(username, age, hobby);
		Message message = UserUtil.check(userInfo);
		if (!message.isSuccess()) {
			request.getSession().setAttribute("error", message.getMsg());
			response.sendRedirect("error.jsp");
			return;
		}
		
		ArrayList<UserInfo> list = (ArrayList<UserInfo>) request.getServletContext().getAttribute("list");
		if (UserUtil.isSave(username, list)) {
			request.getSession().setAttribute("error","该用户已经被登记了！");
			response.sendRedirect("error.jsp");
			return;
		}
		
		ArrayList<UserInfo> newlist = UserUtil.add(userInfo, list);
		request.getSession().setAttribute("userinfo", userInfo);
		request.getServletContext().setAttribute("list", newlist);
		
		request.getSession().setAttribute("ok", "ok");
		response.sendRedirect("success.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
