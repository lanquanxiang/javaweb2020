package cn.pzhuweb.test.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.test.pojo.User;
import cn.pzhuweb.test.util.JDBCUtil;

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
			
			
			//2.获得连接
			
			Connection con = JDBCUtil.getConnection();
			response.getWriter().print(con);
			//3.编写SQL
			String sql = "select * from user where name= ? ";
			//4.创建命令
			PreparedStatement sta = con.prepareStatement(sql);
			//5.执行
			sta.setString(1, request.getParameter("username"));
			ResultSet res = sta.executeQuery();
			//6.处理结果
			ArrayList<User> list = new ArrayList<>();
			while (res.next()==true) {
				String name = res.getString(1);
				String pwd = res.getString("password");//res.getString(2)
				User temp = new User(name, pwd);
				list.add(temp);
			}
			//7.释放资源
			JDBCUtil.close(res, sta, con);
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
