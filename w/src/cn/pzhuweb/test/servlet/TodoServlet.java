package cn.pzhuweb.test.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.test.pojo.Message;
import cn.pzhuweb.test.pojo.UserInfo;
import cn.pzhuweb.test.util.UserUtil;

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
		//request.setCharacterEncoding("utf-8");//1.重置编码
		String username = request.getParameter("username");//2.获取参数
		String sage = request.getParameter("age");
		String [] hobby = request.getParameterValues("hobby");
		
		Integer age;
		try {
			age = Integer.parseInt(sage);//3.类型转换
		} catch (Exception e) {
			request.getSession().setAttribute("error", "年龄为空或者不是数字！");
			response.sendRedirect("error.jsp");//9.不符合预期，程序结束
			return;
		}
		//4.封装信息
		UserInfo userInfo = new UserInfo(username, age, hobby);
		//5.因为是静态方法，所以跳过5步
		//6.调用员工来进行业务处理
		Message message = UserUtil.check(userInfo);
		if (!message.isSuccess()) {
			request.getSession().setAttribute("error", message.getMsg());
			response.sendRedirect("error.jsp");//9.不符合预期，程序结束
			return;
		}
		//到application中去取旧的登记表
		ArrayList<UserInfo> list = (ArrayList<UserInfo>) request.getServletContext().getAttribute("list");
		if (UserUtil.isSave(username, list)) {
			request.getSession().setAttribute("error", "你已经登记了！");
			response.sendRedirect("error.jsp");//9.不符合预期，程序结束
			return;
		}
		//更新登记表
		ArrayList<UserInfo> newlist = UserUtil.update(userInfo, list);
		//7.保存必要信息
		request.getSession().setAttribute("userinfo", userInfo);
		request.getServletContext().setAttribute("list", newlist);
		
		
		request.getSession().setAttribute("yes", "yes");
		
		
		//8.成功
		response.sendRedirect(request.getContextPath()+"/success.jsp");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
