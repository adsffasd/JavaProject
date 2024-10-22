package controller.loaiphong;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.LoaiPhongDAO;
import model.LoaiPhong;


/**
 * Servlet implementation class AddKT
 */
@WebServlet("/addlp")
public class AddLP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLP() {
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
		dao.insertLoaiPhong(maloaiphong, tenloaiphong, dongia);
		response.sendRedirect("showlp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
