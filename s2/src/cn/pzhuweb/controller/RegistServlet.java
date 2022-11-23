package cn.pzhuweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.service.UserService;
import cn.pzhuweb.service.imp.UserServiceImp;
import cn.pzhuweb.util.Conver2MD5;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String captcha = request.getParameter("captcha");
		String codes = (String) request.getSession().getAttribute("codes");
		if (captcha==null || "".equals(codes)|| "".equals(captcha) || codes==null) {
			response.getWriter().print("<script>alert('验证码为空！');window.location.href='regist.jsp';</script>");
			return;
		}
		if (!codes.equalsIgnoreCase(captcha)) {
			response.getWriter().print("<script>alert('验证码输入错误！');window.location.href='regist.jsp';</script>");
			return;
		}		
		
		String  name = request.getParameter("username");
		String password = request.getParameter("password");
		
		String maskpassword = Conver2MD5.getSHA256("javaweb"+name+password);
		
		
		User user = new User(name, maskpassword);
		UserService us = new UserServiceImp();
		Message message = us.regist(user);
		if (message.isSuccess()) {
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='login.jsp';</script>");
		}else{
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='regist.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
