package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ReceiveMail;
import domain.User;
import service.EditService;
import service.bean.EditBean;

@WebServlet("/MailListServlet")
public class MailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailListServlet() {
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

		// 【メールの取り出し】
		List<ReceiveMail> receiveMailList = service.getReceiveMail(user.getUserID());
		editBean.setReceiveMailList(receiveMailList);


		request.setAttribute("bean", editBean);
		RequestDispatcher disp = request.getRequestDispatcher("/MailList.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}