package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Draft;
import domain.User;
import domain.valueo.Destination;
import domain.valueo.Sender;
import domain.valueo.TemplateID;
import domain.valueo.Title;
import domain.valueo.UserID;
import service.PreviewService;
import service.bean.PreviewBean;

/**
 * Servlet implementation class PreviewServlet
 */
@WebServlet("/PreviewServlet")
public class PreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
																throws ServletException, IOException {

		String templateID = request.getParameter("templateID");				// テンプレートID
		String trainerAddress = request.getParameter("trainerAddress");		// 宛先

		User user = (User)request.getSession().getAttribute("user");

		// プレビューサービスを生成
		PreviewService ps = null;
		ps = new PreviewService();
		// 件名を自動生成
		String autoTitle = ps.createMailTitle(user.getUserID());


		//Sender sender = request.getParameter(sender);
		Sender sender = new Sender(user.getName().getName());			// 送信者
		Destination destination = new Destination(trainerAddress);		// 宛先
		Title title = new Title(autoTitle);								// 件名
		List<Draft> drafts = ps.getIndentDraft(new TemplateID("0001"), new UserID("CS-362"));	// 本文


		// PreviewBeanに値をセット
		PreviewBean bean = new PreviewBean();
		bean.setSender(sender);
		bean.setDestination(destination);
		bean.setTitle(title);
		bean.setDraft(drafts);

		// プレビュー画面に値を渡して遷移
		request.setAttribute("bean", bean);
		RequestDispatcher disp = request.getRequestDispatcher("Preview.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
