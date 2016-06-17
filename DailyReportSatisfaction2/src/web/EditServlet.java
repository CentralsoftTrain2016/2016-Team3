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
import domain.Draft;
import domain.Point;
import domain.User;
import domain.valueo.WeekDay;
import service.EditService;
import service.bean.EditBean;
import service.bean.GoalBean;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
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

		//展開のために下書きを読み込む 曜日は仮データ
		List<Draft> drafts = service.getDraft(user.getUserID(), user.getDepartmentID(), new WeekDay("1"));
		editBean.setDrafts(drafts);

		// 【メールの取り出し】
		// List<Mail> mailList = service.getMail(loginBean.getUserId());
		// List<Template> templateList = service.getTemplate();

		// request.setAttribute("mailList",mailList);

		// 【指摘事項の取り出し】
		List<Point> pointList = service.getPoint(user.getUserID());
		editBean.setPointList(pointList);
		//目標目的の取り出し
		GoalBean goal = new GoalBean();
		goal = service.getGoal(user.getName());
		editBean.setGoal(goal.getGoal());
		editBean.setPurpose(goal.getPurpose());

		//設定取り出し
		List<Config> configList = service.getConfig(user.getUserID());
		editBean.setConfigList(configList);
		//名前セット
		editBean.setName(user.getName());

		request.setAttribute("bean", editBean);
		RequestDispatcher disp = request.getRequestDispatcher("/Edit.jsp");
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