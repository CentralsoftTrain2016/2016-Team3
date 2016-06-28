package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.valueo.TemplateID;

/**
 * Servlet implementation class EditSelectTemplateServlet
 */
@WebServlet("/EditSelectTemplateServlet")
public class EditSelectTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSelectTemplateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//選ばれたテンプレート取得
		TemplateID templateID = new TemplateID(request.getParameter("templateID"));
		String referer = "EditSelectTemplateServlet";
		//セット
		request.setAttribute("templateID", templateID);
		request.setAttribute("referer", referer);

		RequestDispatcher disp = request.getRequestDispatcher("/EditServlet");
		disp.forward(request, response);
	}

}
