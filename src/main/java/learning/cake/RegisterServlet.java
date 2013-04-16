package learning.cake;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -133307009774270326L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		// 跳转至注册页面
		if (name == null || password == null) {
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
		} else {
			// 进行注册
			User user = new User();
			user.setName(name);
			user.setPassword(password);

			try {
				UserDao.save(user);
			} catch (SQLException e) {
				e.printStackTrace();
				resp.sendRedirect(req.getContextPath() + "/register?error=true");
				return;
			}
			// 注册成功跳转至登陆页面
			resp.sendRedirect(req.getContextPath() + "/login?registered=true");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
