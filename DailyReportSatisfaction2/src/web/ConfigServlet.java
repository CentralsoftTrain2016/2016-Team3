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
 * Servlet implementation class ConfigServlet
 */
@WebServlet("/ConfigServlet")
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// user持ってくる
		User user = (User) request.getSession().getAttribute("user");
		// ConfigBean作成
		ConfigBean configBean = new ConfigBean();

		// 目標取得
		ConfigService service = new ConfigService();
		service.start();

		Communication communication = service.trainGoal1Select(user);
		Work work = service.trainGoal2Select(user);
		Technology technology = service.trainGoal3Select(user);

		configBean.setCommunication(communication);
		configBean.setWork(work);
		configBean.setTechnology(technology);

		// Config.jspに遷移
		request.setAttribute("bean", configBean);
		RequestDispatcher disp = request.getRequestDispatcher("/Config.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
