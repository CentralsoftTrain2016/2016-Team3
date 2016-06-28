package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Point;
import domain.User;
import service.EditService;
import service.bean.EditBean;

@WebServlet("/TabServlet")
public class TabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TabServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// user持ってくる
		User user = (User) request.getSession().getAttribute("user");
		// EditBeanつくり！
		EditBean editBean = new EditBean();
		// サービス開始
		EditService service = null;
		service = new EditService();
		service.start();

		// 【指摘事項の取り出し】
		List<Point> pointList = service.getPoint(user.getUserID());
		editBean.setPointList(pointList);
		System.out.println("あ");
		System.out.println(pointList);

		request.setAttribute("bean", editBean);
		RequestDispatcher disp = request.getRequestDispatcher("/Tab.jsp");
		disp.forward(request, response); // ここ！
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}