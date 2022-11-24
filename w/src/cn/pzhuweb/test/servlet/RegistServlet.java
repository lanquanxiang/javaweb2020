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
import cn.pzhuweb.test.util.Conver2MD5;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImp();
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
		String ans = (String) request.getSession().getAttribute("answer");
		if (captcha==null || "".equals(captcha) || ans==null) {
			response.getWriter().print("<script>alert('验证码为空！');window.location.href='regist.jsp'</script>");
			return;
		}
		if (!captcha.equalsIgnoreCase(ans)) {
			response.getWriter().print("<script>alert('验证码错误！');window.location.href='regist.jsp'</script>");
			return;
		}
		
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		String maskpassword = Conver2MD5.getMD5(Conver2MD5.getMD5(name+password).substring(0,25)+"pzhu");
		
		User user = new User(name, maskpassword);
		Message message = us.regist(user);
		if (message.isSuccess()) {			
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='login.jsp'</script>");
		}else{
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='regist.jsp'</script>");
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
