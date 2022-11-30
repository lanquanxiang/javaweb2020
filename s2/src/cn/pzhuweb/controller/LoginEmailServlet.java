package cn.pzhuweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.pojo.User;
import cn.pzhuweb.util.Conver2MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginemail")
public class LoginEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  username = request.getParameter("username");
		String email = request.getParameter("email");
		String checkcode= request.getParameter("checkcode");
		String token = (String) request.getSession().getAttribute("token");
		
		if (username==null || email==null || checkcode==null || token==null || "".equals(username) || "".equals(email) || "".equals(checkcode)) {
			response.getWriter().print("<script>alert('验证信息不完整!');window.location.href='email.jsp';</script>");
			return;
		}
		String usertoken = Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(checkcode);
		if (!usertoken.equals(token)) {
			response.getWriter().print("<script>alert('验证码错误或信息不一致!');window.location.href='email.jsp';</script>");
			return;
		}
		
		request.getSession().setAttribute("ok", "yes");//为了让过滤器放行
		request.getSession().setAttribute("user", new User(username, token));//为了判断是否登录，显示功能菜单
		response.getWriter().print("<script>alert('登录成功!');window.location.href='success.jsp';</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
