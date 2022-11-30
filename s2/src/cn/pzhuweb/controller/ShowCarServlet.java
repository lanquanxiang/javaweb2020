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
		List<Car> allList = (List<Car>) request.getSession().getAttribute("allList");
		if (allList==null) {
			CarService cs = new CarServiceImp();
			allList = cs.showAllCarInfo();
		}
		String spage = request.getParameter("page");
		String snum = request.getParameter("num");
		int page = 1,num=10;
		try {
			page = Integer.parseInt(spage);
		} catch (Exception e) {
			page = 1;
		}
		try {
			num = Integer.parseInt(snum);
		} catch (Exception e) {
			num = 10;
		}	
		
		List<Car> list = PageUtil.splitList(allList, page, num);
		request.getSession().setAttribute("list",list);
		
		StringBuffer bar = PageUtil.getBar(allList, page, num);
		request.getSession().setAttribute("bar", bar);		
		
		
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
