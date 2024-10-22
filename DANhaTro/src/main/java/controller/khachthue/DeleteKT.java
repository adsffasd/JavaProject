package controller.khachthue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachThueDAO;
import model.KhachThue;

/**
 * Servlet implementation class DeleteKT
 */
@WebServlet("/deletekt")
public class DeleteKT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String makhach = request.getParameter("makhach");
		KhachThueDAO dao = new KhachThueDAO();
		KhachThue kt = dao.getKhachThueByMa(makhach);
		request.setAttribute("ktT", kt);
		request.getRequestDispatcher("/khachthue/delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String makhach = request.getParameter("makhach");
		
		KhachThueDAO dao = new KhachThueDAO();
		dao.deleteKhachThue(makhach);
		response.sendRedirect("showkt");
	}

}
