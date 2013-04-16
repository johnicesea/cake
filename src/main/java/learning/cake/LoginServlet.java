package learning.cake;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -3460422763086822516L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		// 跳转至登陆页面
		if (name == null || password == null) {
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		} else {
			// 进行登录
			User user = UserDao.find(name, password);

			if (user == null) {
				// 用户不存在,登陆失败
				resp.sendRedirect(req.getContextPath() + "/login?error=true");
			} else {
				// 登陆成功,跳转至订单显示页面
				req.getSession().setAttribute("user", user);
				resp.sendRedirect(req.getContextPath() + "/order/list");
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
