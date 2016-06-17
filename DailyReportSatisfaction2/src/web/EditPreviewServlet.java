package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Draft;
import service.EditService;

/**
 * Servlet implementation class EditPreviewServlet
 */
@WebServlet("/EditPreviewServlet")
public class EditPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPreviewServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EditService service = null;
		try{
			service = new EditService();
			service.start();

			String cnt = request.getParameter("cnt");
			int icnt = Integer.parseInt(cnt);
			List<Draft> draftList = new ArrayList<Draft>();
			for(int i = 0;i<icnt;i++){

				Draft draft = new Draft(
						request.getParameter("draftID" + i),
						request.getParameter("text" + i)
						);
				draftList.add(draft);
			}
			service.updateDraft(draftList);
			// 仮実装
			// 動作確認用 将来的に消す
			String templateID = request.getParameter("templateID");
			request.setAttribute("templateID", templateID);
			String trainerID = request.getParameter("trainerID");
			request.setAttribute("trainerID", trainerID);


			RequestDispatcher disp = request.getRequestDispatcher("PreviewServlet");
			disp.forward(request, response);
		}catch(Throwable e){
			service.rollebackEnd();
			throw e;
		}finally{
			service.end();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
