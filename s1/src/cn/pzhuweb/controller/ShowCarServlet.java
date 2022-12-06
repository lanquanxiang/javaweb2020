package cn.pzhuweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.pojo.Car;
import cn.pzhuweb.service.CarService;
import cn.pzhuweb.service.imp.CarServiceImp;
import cn.pzhuweb.util.PageUtil;

/**
 * Servlet implementation class ShowCarServlet
 */
@WebServlet("/showcar")
public class ShowCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = (List<Car>) request.getSession().getAttribute("AllList");
		if (list==null) {
			CarService cs = new CarServiceImp();
			list = cs.showAll();
			request.getSession().setAttribute("AllList", list);
		}
		
		String snum = request.getParameter("num");
		String spage = request.getParameter("page");
		int num = 10,page=1;
		try {
			num = Integer.parseInt(snum);
		} catch (Exception e) {
			num = 10;			
		}	
		try {
			page = Integer.parseInt(spage);
		} catch (Exception e) {
			page=1;
		}
		List<Car> pagelist = PageUtil.splitList(list, page, num);//分割之后的list
		request.getSession().setAttribute("list", pagelist);
		
		//还需要一个导航栏
		String path= request.getContextPath()+"/showcar";
		StringBuffer bar = PageUtil.getBar(list, page, num, path);
		request.getSession().setAttribute("bar", bar);
		request.getSession().setAttribute("num", num);
		
		
		
		response.sendRedirect("show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
