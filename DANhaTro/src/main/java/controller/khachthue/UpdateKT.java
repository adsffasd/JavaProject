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
 * Servlet implementation class Update
 */
@WebServlet("/updatekt")
public class UpdateKT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String makhach = request.getParameter("makhach");
		KhachThueDAO dao = new KhachThueDAO();
		KhachThue kt = dao.getKhachThueByMa(makhach);
		request.setAttribute("ktT", kt);
		request.getRequestDispatcher("/khachthue/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String makhach = request.getParameter("makhach");
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		String gioitinh = request.getParameter("gioitinh");
		String diachi = request.getParameter("diachi");
		String sodienthoai = request.getParameter("sodienthoai");
		
		KhachThueDAO dao = new KhachThueDAO();
		dao.updateKhachThue(makhach, hoten, ngaysinh, gioitinh, diachi, sodienthoai);
		response.sendRedirect("showkt");
	}

}
