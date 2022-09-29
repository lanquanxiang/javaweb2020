package cn.pzhuweb.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutServlet
 */
@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");	
		
		String username = request.getParameter("username");
		String[] tags = request.getParameterValues("tag");
		
		//response.setContentType("text/html");
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().print("姓名："+username+"<br/>");
		response.getWriter().print("标签：");
		if(tags==null){
			response.getWriter().print("你什么都没有选!");
		}else{
			for(int i=0;i<tags.length;i++){
				response.getWriter().print(tags[i]);
			}
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
