package cn.pzhuweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.service.UserService;
import cn.pzhuweb.service.imp.UserServiceImp;
import cn.pzhuweb.util.Conver2MD5;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username  = request.getParameter("username");
		String email = request.getParameter("email");
		UserService us = new UserServiceImp();
		Message message = us.sendEmail(username, email);
		if (message.isSuccess()) {
			//成功
			//口令保证用户信息的一致性：用户名、邮箱、验证码
			String code = message.getMsg();
			String token = Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(code);
			request.getSession().setAttribute("token", token);
			response.getWriter().print("邮件已经发送成功，请使用验证码登录!");
		}else{
			//失败
			response.getWriter().print(message.getMsg());
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
