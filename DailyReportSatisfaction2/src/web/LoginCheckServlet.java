package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.LoginService;
import service.bean.LoginBean;

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService service = null;
		// LoginBean作成
		LoginBean loginBean = new LoginBean();
		// Login.jspで入力されたuserIDとpasswordを受け取る
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");

		// ユーザーID未入力のとき
		if (userID == null || userID.equals("")) {
			loginBean.setMessage("ユーザIDが未入力です");
			request.setAttribute("bean", loginBean);
			RequestDispatcher disp = request.getRequestDispatcher("/Login.jsp");
			disp.forward(request, response);
			return;
		} else if (password == null || password.equals("")) {
			loginBean.setMessage("パスワードが未入力です");
			request.setAttribute("bean", loginBean);
			RequestDispatcher disp = request.getRequestDispatcher("/Login.jsp");
			disp.forward(request, response);
			return;
		}

		userID = new String(userID.getBytes("ISO8859-1"),"UTF-8");
		//サービスからユーザーを取得
		service = new LoginService();
		service.start();

		User user = service.getUser(userID, password);

		if(user == null){
			loginBean.setMessage("ログインに失敗しました");
			request.setAttribute("bean", loginBean);
			RequestDispatcher disp = request.getRequestDispatcher("/Login.jsp");
			disp.forward(request, response);
			return;
		}else{

		loginBean.setUserID(user.getUserID().getUserID());
		loginBean.setPassword(user.getPassword().getPassword());
		loginBean.setName(user.getName().getName());
		loginBean.setTrainerAID(user.getTrainerAID().getTrainerAID());
		loginBean.setTrainerBID(user.getTrainerBID().getTrainerBID());
		loginBean.setDepartmentID(user.getDepartmentID().getDepartmentID());

		}


		// ユーザ情報をセッションへ投げつける
		request.getSession().setAttribute("user", user);
		// EditServletへ飛ぶ
		RequestDispatcher disp = request.getRequestDispatcher("/EditBaseServlet");
		disp.forward(request, response);

		//response.sendRedirect("EditServlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
