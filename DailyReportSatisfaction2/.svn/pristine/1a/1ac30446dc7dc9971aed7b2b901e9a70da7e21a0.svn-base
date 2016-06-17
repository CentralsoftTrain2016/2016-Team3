package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReeditServlet
 */
@WebServlet("/ReeditServlet")
public class ReeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReeditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sender = request.getParameter("sender");					// 送信者
		String destination = request.getParameter("destination");		// 宛先
		String title = request.getParameter("title");					// 件名
		RequestDispatcher disp = request.getRequestDispatcher("/Reedit.jsp");
		disp.forward(request, response);
	}

}
