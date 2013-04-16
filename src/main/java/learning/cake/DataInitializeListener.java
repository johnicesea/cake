package learning.cake;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 初始化数据结构
 */
public class DataInitializeListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Connection c = DbUtils.getConnection();
		String dropUserTable = "drop table if exists cake_user";
		String createUserTable = "create table cake_user(id int auto_increment, name varchar(30) unique, password varchar(50))";

		String dropOrderTable = "drop table if exists cake_order";
		String createOrderTable = "create table cake_order(id int auto_increment, cust_name varchar(30), cust_addr varchar(50),phone varchar(20), cake_name varchar(20),count int)";

		String userInitData = "insert into cake_user(name,password) values('admin','admin')";
		String orderInitData = "insert into cake_order(cust_name,cust_addr,phone,cake_name,count) values('张三','张三路1号','12345678901','巧克力布朗尼',1)";
		try {
			// 更新表结构
			c.prepareStatement(dropUserTable).executeUpdate();
			c.prepareStatement(createUserTable).executeUpdate();
			c.prepareStatement(dropOrderTable).executeUpdate();
			c.prepareStatement(createOrderTable).executeUpdate();

			// 初始化数据
			c.prepareStatement(userInitData).executeUpdate();
			c.prepareStatement(orderInitData).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
