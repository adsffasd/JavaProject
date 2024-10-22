package controller.phong;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.LoaiPhongDAO;
import database.PhongDAO;
import model.LoaiPhong;
import model.Phong;

/**
 * Servlet implementation class DeletePT
 */
@WebServlet("/deletept")
public class DeletePT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePT() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maphong = request.getParameter("maphong");
		PhongDAO dao = new PhongDAO();
		Phong p = dao.getPhongByMa(maphong);
		request.setAttribute("pP", p);
		request.setAttribute("listlp", p.getLoaiphong().getTenloaiphong());

		LoaiPhongDAO dao1 = new LoaiPhongDAO();
		List<LoaiPhong> list1 = dao1.getAllLoaiPhong();
		request.setAttribute("loaiphonglist", list1);

		request.getRequestDispatcher("phong/delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maphong = request.getParameter("maphong");

		PhongDAO dao = new PhongDAO();
		dao.deletePhong(maphong);
		response.sendRedirect("showpt");
	}

}
