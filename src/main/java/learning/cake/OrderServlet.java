package learning.cake;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 6264493491623661088L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		String path = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("path:" + path);

		// 录入订单页面
		if (path.startsWith("/order/create")) {
			createView(req, resp);
		} else if (path.startsWith("/order/save")) {
			// 保存订单
			save(req, resp);
		} else if (path.startsWith("/order/edit")) {
			// 编辑订单页面
			editView(req, resp);
		} else if (path.startsWith("/order/update")) {
			// 更新订单
			update(req, resp);
		} else if (path.startsWith("/order/delete")) {
			// 删除订单
			delete(req, resp);
		} else {
			// 展示订单
			list(req, resp);
		}
	}

	/**
	 * 跳转至订单录入页面
	 */
	private void createView(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(req, res);
	}

	/**
	 * 创建订单
	 */
	private void save(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException {
		String custName = req.getParameter("custName");
		String custAddr = req.getParameter("custAddr");
		String phone = req.getParameter("phone");
		String cakeName = req.getParameter("cakeName");
		String count = req.getParameter("count");

		Order order = new Order();
		order.setCustName(custName);
		order.setCustAddr(custAddr);
		order.setPhone(phone);
		order.setCakeName(cakeName);
		order.setCount(new Integer(count));

		OrderDao.save(order);

		// 创建完毕后跳转至订单展示页面
		list(req, res);
	}

	/**
	 * 跳转至订单编辑页面
	 */
	private void editView(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException {
		Long id = new Long(req.getParameter("id"));

		Order o = OrderDao.findById(id);
		req.setAttribute("order", o);
		req.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(req, res);
	}

	/**
	 * 编辑订单
	 */
	private void update(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException {
		String id = req.getParameter("id");
		String custName = req.getParameter("custName");
		String custAddr = req.getParameter("custAddr");
		String phone = req.getParameter("phone");
		String cakeName = req.getParameter("cakeName");
		String count = req.getParameter("count");

		Order order = new Order();
		order.setCustName(custName);
		order.setCustAddr(custAddr);
		order.setPhone(phone);
		order.setCakeName(cakeName);
		order.setCount(new Integer(count));
		order.setId(new Long(id));

		OrderDao.update(order);

		// 创建完毕后跳转至订单展示页面
		list(req, res);
	}

	/**
	 * 删除订单
	 */
	private void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException {
		String id = req.getParameter("id");

		OrderDao.deleteById(new Long(id));

		list(req, res);
	}

	/**
	 * 展示所有订单
	 */
	private void list(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException {
		req.setAttribute("orders", OrderDao.list());
		req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
