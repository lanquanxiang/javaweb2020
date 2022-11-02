package cn.pzhuweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.pojo.User;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/jdbc2")
public class JDBCServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");//com.mysql.cj.jdbc.Driver  5.6+
			//2.获得连接
			String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password="1234";
			Connection connection = DriverManager.getConnection(url, user, password);
			//test 测试是否连接成功
			response.getWriter().print(connection);
			
			//3.编写SQL语句
			String sql="select * from user where name=?";
			//4.创建命令对象
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//5.执行命令
			preparedStatement.setString(1, request.getParameter("username"));
			ResultSet resultSet = preparedStatement.executeQuery();
			//6.处理结果
			
			ArrayList<User> list = new ArrayList<>();//保存所有的用户信息			
			while(resultSet.next()!=false){
				String name = resultSet.getString(1);
				String pwd = resultSet.getString("password");
				User temp = new User(name, pwd);
				list.add(temp);
			}
			//7. 释放资源
			resultSet.close();
			preparedStatement.close();
			connection.close();
			
			request.getSession().setAttribute("list", list);
			response.sendRedirect("show.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
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
