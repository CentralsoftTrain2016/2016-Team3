package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreviewEditServlet
 */
@WebServlet("/PreviewEditServlet")
public class PreviewEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewEditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
																throws ServletException, IOException {

		request.setAttribute(
				"sender",
				new String(
						request.getParameter("sender").getBytes("ISO8859-1"),
						"UTF-8")
				);

		// 送信者
		request.setAttribute("destination", request.getParameter("destination"));		// 宛先
		request.setAttribute(
				"title",
				new String(
						request.getParameter("title").getBytes("ISO8859-1"),
						"UTF-8")
				);					// 件名


		// ReeditServletに遷移
		RequestDispatcher disp = request.getRequestDispatcher("ReeditServlet");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
