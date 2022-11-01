package cn.pzhuweb.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.pojo.User;
import cn.pzhuweb.util.DBUtil;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection con = DBUtil.getConection();
			//3.编写SQL
			String username = request.getParameter("username");
			//String sql = "select * from user where name='"+username+"'";
			String sql = "select * from user where name=?";
			//4.创建命令对象
			//Statement sta = con.createStatement();
			PreparedStatement sta = con.prepareStatement(sql);
			//5.执行命令
			//ResultSet res = sta.executeQuery(sql);
			sta.setString(1, username);
			ResultSet res = sta.executeQuery();
			//6.处理结果
			ArrayList<User> list = new ArrayList<>();//保存结果集中的所有用户信息
			while(res.next()==true){
				String name = res.getString(1);
				String psw = res.getString("password");
				User temp = new User(name, psw);
				list.add(temp);//将这一行的user加入集合中
			}
			//7. 释放资源
			DBUtil.close(res, sta, con);			
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
