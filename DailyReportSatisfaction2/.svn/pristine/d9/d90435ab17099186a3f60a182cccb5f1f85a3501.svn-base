package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PreviewService;

/**
 * Servlet implementation class PreviewSubmitServlet
 */
@WebServlet("/PreviewSubmitServlet")
public class PreviewSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sender = request.getParameter("sender");
		String senderAddress = request.getParameter("senderAddress");
		String destination = request.getParameter("destination");
		String title = request.getParameter("title");
		String text = request.getParameter("sendText");

		// サービス開始
		PreviewService service = null;
		service = new PreviewService();
		service.start();
		//ここで送信
		service.SubmitMail(sender, senderAddress, destination, title, text);

		RequestDispatcher disp = request.getRequestDispatcher("/Submit.html");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
