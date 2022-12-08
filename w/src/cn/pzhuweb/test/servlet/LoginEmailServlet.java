package cn.pzhuweb.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.test.pojo.User;
import cn.pzhuweb.test.util.Conver2MD5;

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
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String checkcode = request.getParameter("checkcode");
		
		if (username==null || email ==null || checkcode==null ||
				"".equals(username)|| "".equals(email)|| "".equals(checkcode)) {
			response.getWriter().print("<script>alert('登录信息不能为空!');window.location.href='email.jsp'</script>");
			return;
		}
		
		String usertoken = Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(checkcode);
		String token = (String) request.getSession().getAttribute("token");
		if (!usertoken.equals(token)) {
			response.getWriter().print("<script>alert('验证码错误!');window.location.href='email.jsp'</script>");
			return;
		}
		//登录成功保存必要的信息
		request.getSession().setAttribute("user", new User(username, token));//保存user，提供给head进行判断，显示不同的功能菜单
		request.getSession().setAttribute("yes", "yes");//标识用户是登录了的，让过滤器放行
		response.getWriter().print("<script>alert('登录成功!');window.location.href='success.jsp'</script>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
