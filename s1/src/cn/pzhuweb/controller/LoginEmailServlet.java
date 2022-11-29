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
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String checkcode = request.getParameter("checkcode");
		
		if (name==null|| email==null||checkcode==null || "".equals(name) || "".equals(email) || "".equals(checkcode)) {
			response.getWriter().print("<script>alert('信息输入不完整!');window.location.href='forgot.jsp'</script>");
			return;
		}
		
		String token = (String) request.getSession().getAttribute("token");
		String usertoken = Conver2MD5.getSHA256(name)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(checkcode);
		if (!usertoken.equals(token)) {
			response.getWriter().print("<script>alert('校验失败!');window.location.href='forgot.jsp'</script>");
			return;
		}
		request.getSession().setAttribute("user",  new User(name, token));
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
