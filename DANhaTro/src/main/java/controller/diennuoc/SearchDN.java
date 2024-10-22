package controller.diennuoc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TienDienNuocDAO;
import model.TienDienNuoc;

/**
 * Servlet implementation class SearchDN
 */
@WebServlet("/searchdn")
public class SearchDN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String matiendien = request.getParameter("matiendien");
		TienDienNuocDAO dao = new TienDienNuocDAO();
		List<TienDienNuoc> dn = dao.searchDN(matiendien);
		request.setAttribute("dnN", dn);
		request.getRequestDispatcher("/tiendiennuoc/search.jsp").forward(request, response);
	}

}
