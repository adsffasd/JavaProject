package controller.login_register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Login_RegisterDAO;
import model.Login_Register;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "RegisterController", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		request.setAttribute("user", user);
		request.setAttribute("password", password);
		request.setAttribute("repassword", repassword);
		request.setAttribute("dongYNhanMail", dongYNhanMail);

		String url = "";

		String baoLoi = "";
		Login_RegisterDAO registerDAO = new Login_RegisterDAO();
		if (registerDAO.checkUser(user)) {
			baoLoi += "Đã tồn tại tên này, xin vui lòng đổi tên khác";
		}

		if (!password.equals(repassword)) {
			baoLoi += "Mật khẩu không khớp";
		}

		if (baoLoi.length() > 0) {
			url = "/login_register_logout/register.jsp";
		} else {
			Login_Register rg = new Login_Register(user, repassword);
			registerDAO.insert(rg);
		}
		url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();

		response.sendRedirect(url + "/login_register_logout/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
