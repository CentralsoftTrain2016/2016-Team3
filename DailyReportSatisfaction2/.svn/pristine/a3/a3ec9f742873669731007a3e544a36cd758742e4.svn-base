package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Point;
import domain.ReceiveMail;
import domain.User;
import service.EditService;
import service.bean.EditBean;

@WebServlet("/MailTextServlet")
public class MailTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailTextServlet() {
		super();
	}


	public static String  LAST_DISP_MAIL_SESSION_KEY = "lastDispMailKey";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String recieveMailId = request.getParameter("recieveMailId");
		User user = (User) request.getSession().getAttribute("user");
		// EditBeanつくり！
		EditBean editBean = new EditBean();
		// サービス開始
		EditService service = null;
		service = new EditService();
		service.start();

		List<ReceiveMail> receiveMailList =null;
		// 【メール1件の本文を取り出し】
		if( recieveMailId != null )
			receiveMailList = service.getMailText(recieveMailId);
		else
		{
			List<ReceiveMail> receiveMailListTmp = service.getReceiveMail(user.getUserID());
			receiveMailList = new ArrayList<ReceiveMail>();
			if(receiveMailListTmp.size() != 0){
			receiveMailList.add(receiveMailListTmp.get(0));
			}
 		}

		editBean.setReceiveMailList(receiveMailList);
		// 【指摘事項の取り出し】


		//最後に表示したメールをセッションに保存
		if(receiveMailList.size() != 0)
			request.getSession().setAttribute(LAST_DISP_MAIL_SESSION_KEY, receiveMailList.get(0).getText());
		else
			request.getSession().setAttribute(LAST_DISP_MAIL_SESSION_KEY, "");


		List<Point> pointList = service.getPoint(user.getUserID());
		editBean.setPointList(pointList);

		request.setAttribute("bean", editBean);
		RequestDispatcher disp = request.getRequestDispatcher("/MailText.jsp");
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