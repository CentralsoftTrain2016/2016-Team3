package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.valueo.Communication;
import domain.valueo.Technology;
import domain.valueo.Work;
import service.ConfigService;
import service.bean.ConfigBean;

/**
 * Servlet implementation class ConfigUpdateServlet
 */
@WebServlet("/ConfigUpdateServlet")
public class ConfigUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// user持ってくる
		User user = (User) request.getSession().getAttribute("user");
		//値受け取り
		String commuStr = request.getParameter("comyu");
		String workStr = request.getParameter("work");
		String skillStr = request.getParameter("skill");
		//文字化け
		commuStr = new String(commuStr.getBytes("ISO8859-1"),"UTF-8");
		workStr = new String(workStr.getBytes("ISO8859-1"),"UTF-8");
		skillStr = new String(skillStr.getBytes("ISO8859-1"),"UTF-8");

		Communication commu = new Communication(commuStr);
		Work work = new Work(workStr);
		Technology technology = new Technology(skillStr);
		// ConfigBean作成
		ConfigBean configBean = new ConfigBean();

		// 目標更新
		ConfigService service = new ConfigService();

		service.start();
		service.TrainGoal1Update(user.getUserID(), commu);
		 service.TrainGoal2Update(user.getUserID(), work);
		 service.TrainGoal3Update(user.getUserID(), technology);

//		// 研修の目標を初期化
//		communication = new Communication(null);
//		work = new Work(null);
//		technology = new Technology(null);



		// Editに遷移
		//request.setAttribute("bean", configBean);
		RequestDispatcher disp = request.getRequestDispatcher("/ConfigServlet");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
