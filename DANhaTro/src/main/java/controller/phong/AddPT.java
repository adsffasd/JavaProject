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
 * Servlet implementation class AddPT
 */
@WebServlet("/addpt")
public class AddPT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		LoaiPhongDAO dao = new LoaiPhongDAO();
		List<LoaiPhong> list = dao.getAllLoaiPhong();
		System.out.println(list	);
		request.setAttribute("listLP", list);
		request.getRequestDispatcher("/phong/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maphong = request.getParameter("maphong");
		String tenphong = request.getParameter("tenphong");
		String loaiphong = request.getParameter("loaiphong");
		String trangthai = request.getParameter("trangthai");
		
		PhongDAO dao = new PhongDAO();
		
		Phong p = new Phong(maphong, tenphong, new LoaiPhong(loaiphong), trangthai);
		dao.insertPhong(p);
		response.sendRedirect("showpt");
	}

}
