package cn.pzhuweb.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhuweb.test.pojo.Car;
import cn.pzhuweb.test.service.CarService;
import cn.pzhuweb.test.service.imp.CarServiceImp;
import cn.pzhuweb.test.util.PageUtil;

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
		
		List<Car> list = (List<Car>) request.getSession().getAttribute("allList");//读取缓存内容
		if (list==null) {
			CarService cs = new CarServiceImp();
			List<Car> carlist=cs.showAllCarInfo();
			request.getSession().setAttribute("allList", carlist);//将查询内容放入缓存
		}
		
		String spage = request.getParameter("page");
		String snun = request.getParameter("num");
		int page = 1,num=10;
		try {
			page = Integer.parseInt(spage);
		} catch (Exception e) {
			page = 1;
		}
		try {
			num = Integer.parseInt(snun);
		} catch (Exception e) {
			num = 10;
		}
		
		List<Car> pagelist = PageUtil.splitList(list,page,num);
		request.getSession().setAttribute("list", pagelist);	
		
		String path = request.getContextPath() +  "/showcar";
		StringBuffer bar = PageUtil.getBar(list,page,num,path);
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
