package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.valueo.AdministratorFlag;
import domain.valueo.DepartmentID;
import domain.valueo.Name;
import domain.valueo.Password;
import domain.valueo.TrainerAID;
import domain.valueo.TrainerBID;
import domain.valueo.UserID;
import service.bean.LoginBean;;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Login.jspで入力されたuserIDとpasswordを受け取る
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");

		// ユーザーID未入力のとき
		if (userID == null || userID.equals("")) {
			String message = "ユーザーIDが未入力です";
			request.setAttribute("message", message);
			RequestDispatcher disp = request.getRequestDispatcher("/Login.jsp");
			disp.forward(request, response);
			return;
		} else if (password == null || password.equals("")) {
			String message = "パスワードが未入力です";
			request.setAttribute("message", message);
			RequestDispatcher disp = request.getRequestDispatcher("/Login.jsp");
			disp.forward(request, response);
			return;
		}
		// ログインサービス

		// 仮のログインするのやつ

		// ユーザー情報

		// ﾕｰｻﾞｰ情報 仮のやつ！User
		// 文字化けのおまじない


		User user = new User(null, null, null, null, null, null, null);
		user.setUserID(new UserID("CS-362"));
		user.setPassword(new Password("1234"));
		user.setAdministratorFlag(new AdministratorFlag(false));
		user.setName(new Name("今井祐太"));
		user.setTrainerAID(new TrainerAID("三堂雄大"));
		user.setTrainerBID(new TrainerBID("渡琢生"));
		user.setDepartmentID(new DepartmentID("1"));

		// String tes = user.getUserID().getUserID();

		// 仮のやつ LoginBean【仮】
		LoginBean loginBean = new LoginBean();
		loginBean.setUserID(user.getUserID().getUserID());
		loginBean.setPassword(user.getPassword().getPassword());
		loginBean.setAdministratorFlag(user.getAdministratorFlag().getAdministratorFlag());
		loginBean.setName(user.getName().getName());
		loginBean.setTrainerAID(user.getTrainerAID().getTrainerAID());
		loginBean.setTrainerBID(user.getTrainerBID().getTrainerBID());

		// ユーザ情報をセッションへ投げつける
		request.getSession().setAttribute("user", user);

		// EditServletへ飛ぶ
		RequestDispatcher disp = request.getRequestDispatcher("/EditServlet");
		disp.forward(request, response);

		//response.sendRedirect("EditServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
