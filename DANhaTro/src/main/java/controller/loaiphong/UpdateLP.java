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
 * Servlet implementation class Update
 */
@WebServlet("/updatelp")
public class UpdateLP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maloaiphong = request.getParameter("maloaiphong");
		LoaiPhongDAO dao = new LoaiPhongDAO();
		LoaiPhong lp = dao.getLoaiPhongByMa(maloaiphong);
		request.setAttribute("lpP", lp);
		request.getRequestDispatcher("/loaiphong/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maloaiphong = request.getParameter("maloaiphong");
		String tenloaiphong = request.getParameter("tenloaiphong");
		String dongia_Str = request.getParameter("dongia");
		
		int dongia;
		try {
			dongia = Integer.parseInt(dongia_Str);
		} catch (NumberFormatException e) {
			dongia = 0;
			e.printStackTrace();
		}
		
		
		LoaiPhongDAO dao = new LoaiPhongDAO();
		dao.updateLoaiPhong(maloaiphong, tenloaiphong, dongia);
		response.sendRedirect("showlp");
	}

}
