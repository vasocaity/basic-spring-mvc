
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForecastController
 */
public class ForecastController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApiClient api = new ApiClient();
		String prov = request.getParameter("prov");
		ArrayList<String> province = new ArrayList<String>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if (prov == null) {
			province = api.getProv();
			request.setAttribute("plist", province);
		}else {
			prov = request.getParameter("prov");
			temp = api.findTem(prov);
			province = api.getProv();
			request.setAttribute("plist", province);
			request.setAttribute("tlist", temp);
			request.setAttribute("province", prov);
		}
		RequestDispatcher view = request.getRequestDispatcher("main.jsp");
		view.forward(request, response);
	}

}
