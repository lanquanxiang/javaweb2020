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
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		String maskpassword = Conver2MD5.getSHA256(Conver2MD5.getSHA256(name+password)+"pzhu");
		
		User user = new User(name, maskpassword);
		UserService us = new UserServiceImp();
		Message message = us.login(user);
		if (message.isSuccess()) {
			
			String isSave = request.getParameter("isSave");
			if (isSave==null) {
				//没有勾选，清空cookie	
				System.out.println("正在清除cookie……");
				Cookie nameCookie = new Cookie("username", "");
				Cookie pwdCookie = new Cookie("password", "");
				Cookie saveCookie = new Cookie("isSave", "");
				//nameCookie.setMaxAge(0);
				response.addCookie(nameCookie);
				response.addCookie(pwdCookie);
				response.addCookie(saveCookie);	
			}else{
				//保存信息
				System.out.println("正在写入cookie……");
				Cookie nameCookie = new Cookie("username", name);
				Cookie pwdCookie = new Cookie("password", password);
				Cookie saveCookie = new Cookie("isSave", "yes");
				response.addCookie(nameCookie);
				response.addCookie(pwdCookie);
				response.addCookie(saveCookie);				
			}
						
			request.getSession().setAttribute("user", user);
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='success.jsp'</script>");
		}else{
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='login.jsp'</script>");
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
