package learning.cake;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String path = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("path to filter is:" + path);

		// 请求订单相关内容，需要登录
		if (path.startsWith("/order")) {
			Object user = req.getSession().getAttribute("user");
			// 未登录
			if (user == null) {
				// 转向登录页面
				resp.sendRedirect(req.getContextPath() + "/login");
			} else {
				// 已登录
				chain.doFilter(request, response);
			}
		} else {
			// 无需过滤
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
