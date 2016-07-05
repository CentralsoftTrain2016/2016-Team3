package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Config;
import domain.Point;
import domain.ReceiveMail;
import domain.User;
import service.EditService;
import service.MailService;
import service.PointService;
import service.bean.EditBean;

@WebServlet("/EditBaseServlet")
public class EditBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBaseServlet() {
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
		PointService pointService = null;
		MailService mailService =null;
		service = new EditService();
		pointService = new PointService();
		mailService  = new MailService();
		service.start();
		pointService.start(service);
		mailService.start(service);

		// 展開のために下書きを読み込む 曜日は仮データ

		//List<Draft> drafts = service.getDraft(user.getUserID(), user.getDepartmentID());

		//目標目的の適用
//		drafts = service.setGoal(drafts, user.getUserID());
//		editBean.setDrafts(drafts);

		// 【メールの取り出し】
		List<ReceiveMail> receiveMailList = mailService.getReceiveMail(user.getUserID());
		editBean.setReceiveMailList(receiveMailList);

		// 【指摘事項の取り出し】
		List<Point> pointList = pointService.getPoint(user.getUserID());
		editBean.setPointList(pointList);

		//目標目的の取り出し  使わないかも
		/*
		GoalBean goal = new GoalBean();
		goal = service.getGoal(user.getName());
		editBean.setGoal(goal.getGoal());
		editBean.setPurpose(goal.getPurpose());
		 */

		// 設定取り出し
		List<Config> configList = service.getConfig(user.getUserID());
		editBean.setConfigList(configList);
		// 名前セット
		editBean.setName(user.getName());

		// 件名を自動生成
/*		String autoTitle = service.createMailTitle(user.getUserID());
		Title title = new Title(autoTitle);
		editBean.setTitle(title);
*/
		request.setAttribute("bean", editBean);
		RequestDispatcher disp = request.getRequestDispatcher("/EditBase.jsp"); //frame用テスト！
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