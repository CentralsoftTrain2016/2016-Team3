package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.valueo.PointID;
import service.EditService;

/**
 * Servlet implementation class EditPointDeleteServlet
 */
@WebServlet("/EditPointDeleteServlet")
public class EditPointDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// user持ってくる
		User user = (User) request.getSession().getAttribute("user");
		// サービス開始
		EditService service = null;
		service = new EditService();
		service.start();


		String pointID = request.getParameter("pointID");


		PointID pointWrite = new PointID(pointID);

		// 指摘削除
		service.deletePoint(user.getUserID(), pointWrite);
		// EditServletへ飛ぶ
//		RequestDispatcher disp = request.getRequestDispatcher("MailTextServlet");
//		disp.forward(request, response);

		response.sendRedirect("MailTextServlet");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}