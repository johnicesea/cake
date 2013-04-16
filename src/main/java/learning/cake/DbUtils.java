package learning.cake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

	public static final String url = "jdbc:h2:tcp://localhost:9092/~/test";
	public static final String user = "sa";
	public static final String password = "";

	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			c = DriverManager.getConnection(DbUtils.url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void clear(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
