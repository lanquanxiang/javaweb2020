package cn.pzhuweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.service.UserService;
import cn.pzhuweb.service.imp.UserServiceImp;
import cn.pzhuweb.util.Conver2MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  name = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(name, Conver2MD5.getSHA256("javaweb"+name+password));
		UserService us = new UserServiceImp();
		Message message = us.login(user);
		if (message.isSuccess()) {
			request.getSession().setAttribute("ok", "yes");//为了让过滤器放行
			request.getSession().setAttribute("user", user);//为了判断是否登录，显示功能菜单
			String isSave = request.getParameter("isSave");
			if (isSave==null) {
				//不保存信息，需要清空原来的信息
				System.out.println("不保存信息，正在清除cookie……");
				Cookie namecookie = new Cookie("username", "");
				Cookie pwdcookie = new Cookie("password", "");
				Cookie savecookie = new Cookie("save", "");
				namecookie.setMaxAge(0);
				pwdcookie.setMaxAge(0);
				savecookie.setMaxAge(0);
				response.addCookie(savecookie);
				response.addCookie(pwdcookie);
				response.addCookie(namecookie);	
			}else{
				//要保存信息
				System.out.println("正在保存信息，写入cookie……");
				Cookie namecookie = new Cookie("username", name);
				Cookie pwdcookie = new Cookie("password", password);
				Cookie savecookie = new Cookie("save", "yes");
				response.addCookie(savecookie);
				response.addCookie(pwdcookie);
				response.addCookie(namecookie);				
			}			
			
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='success.jsp';</script>");
		}else{
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='login.jsp';</script>");
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
