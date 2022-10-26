package cn.pzhuweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.model.UserUtil;
import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.SUser;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 编码
		//request.setCharacterEncoding("utf-8");
		//2. 接收参数
		String username = request.getParameter("username");
		String sage = request.getParameter("age");
		String [] hobby = request.getParameterValues("hobby");
		//3. 数据类型转换
		Integer age = 0;
		try {
			age = Integer.parseInt(sage);
		} catch (Exception e) {
			//9.失败，直接跳转到9
			request.getSession().setAttribute("error", "年龄不是数字!");
			response.sendRedirect("error.jsp");
			return;
		}
		//4. 封装数据
		SUser user = new SUser(username,age,hobby);
		//5. 调用模型的方法
		Message message = UserUtil.check(user);
		//需要从application里面去取list(假设用户登记表是保存在application的list中的)
		
		@SuppressWarnings("unchecked")
		ArrayList<SUser> list = (ArrayList<SUser>) request.getServletContext().getAttribute("list");
		//6. 保存模型的结果
		if (!message.isSuccess()) {
			//7.保存失败消息
			request.getSession().setAttribute("error", message.getMsg());
			//9.定向到error
			response.sendRedirect("error.jsp");
			return;
		}
		if (UserUtil.isRegist(username, list)) {
			//7.保存失败消息
			request.getSession().setAttribute("error", "用户已经被登记!");
			//9.定向到error
			response.sendRedirect("error.jsp");
			return;
		}
		ArrayList<SUser> newlist = UserUtil.add(user, list);
			//成功，返回到登记成功的页面
			//7.保存新的list
		request.getServletContext().setAttribute("list",newlist);//保存所有信息，方便在显示登记表的时候显示
			//8.定向到success
		request.getSession().setAttribute("user", user);//保存用户信息，方便在success页面进行显示
		
		request.getSession().setAttribute("flag", "yes");//表示用户执行了todo
		
		response.sendRedirect("success.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
