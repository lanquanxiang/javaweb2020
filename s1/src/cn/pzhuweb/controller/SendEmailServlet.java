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
@WebServlet("/sendemail")
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
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		UserService us = new UserServiceImp();
		Message message = us.sendemail(username, email);
		if (message.isSuccess()) {
			//成功保存账户信息以及验证码
			String token = Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(message.getMsg());
			request.getSession().setAttribute("token", token);
			response.getWriter().print("邮件发送成功，请使用验证码登录!");
			
		}else{
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
