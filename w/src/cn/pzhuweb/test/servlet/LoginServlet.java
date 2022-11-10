package cn.pzhuweb.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.test.pojo.Message;
import cn.pzhuweb.test.pojo.User;
import cn.pzhuweb.test.service.UserService;
import cn.pzhuweb.test.service.imp.UserServiceImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImp();
       
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
		User user = new User(name, password);
		Message message = us.login(user);
		if (message.isSuccess()) {
			request.getSession().setAttribute("user", user);//保存user，提供给head进行判断，显示不同的功能菜单
			request.getSession().setAttribute("yes", "yes");//标识用户是登录了的，让过滤器放行
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
