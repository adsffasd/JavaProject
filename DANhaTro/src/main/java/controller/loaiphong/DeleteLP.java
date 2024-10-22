package controller.loaiphong;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.LoaiPhongDAO;
import model.LoaiPhong;

/**
 * Servlet implementation class DeleteKT
 */
@WebServlet("/deletelp")
public class DeleteLP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maloaiphong = request.getParameter("maloaiphong");
		LoaiPhongDAO dao = new LoaiPhongDAO();
		LoaiPhong lp = dao.getLoaiPhongByMa(maloaiphong);
		request.setAttribute("lpP", lp);
		request.getRequestDispatcher("/loaiphong/delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maloaiphong = request.getParameter("maloaiphong");
		
		LoaiPhongDAO dao = new LoaiPhongDAO();
		dao.deleteLoaiPhong(maloaiphong);
		response.sendRedirect("showlp");
	}

}
