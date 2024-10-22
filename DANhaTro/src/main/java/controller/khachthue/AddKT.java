package controller.khachthue;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachThueDAO;


/**
 * Servlet implementation class AddKT
 */
@WebServlet("/addkt")
public class AddKT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKT() {
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
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		String gioitinh = request.getParameter("gioitinh");
		String diachi = request.getParameter("diachi");
		String sodienthoai = request.getParameter("sodienthoai");
		
		KhachThueDAO dao = new KhachThueDAO();
		dao.insertKhachThue(makhach, hoten, Date.valueOf(ngaysinh), gioitinh, diachi, sodienthoai);
		response.sendRedirect("showkt");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
