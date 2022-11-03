package cn.pzhuweb.test.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.test.pojo.User;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/jdbc")
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
			
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");//Mysql5.6+ com.mysql.cj.jdbc.Driver
			//2.获得连接
			String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&charsetEncoding=UTF-8";
			String user="root";
			String password="1234";
			Connection con = DriverManager.getConnection(url, user, password);
			response.getWriter().print(con);
			//3.编写SQL
			String sql = "select * from user where name= '"+request.getParameter("username")+"'";
			//4.创建命令
			Statement sta = con.createStatement();
			//5.执行
			ResultSet res = sta.executeQuery(sql);
			//6.处理结果
			ArrayList<User> list = new ArrayList<>();
			while (res.next()==true) {
				String name = res.getString(1);
				String pwd = res.getString("password");//res.getString(2)
				User temp = new User(name, pwd);
				list.add(temp);
			}
			//7.释放资源
			res.close();
			sta.close();
			con.close();
			//8.保存必要的信息，进行跳转
			request.getSession().setAttribute("list",list);
			response.sendRedirect("show.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
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
