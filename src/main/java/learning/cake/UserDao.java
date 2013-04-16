package learning.cake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public static User save(User user) throws SQLException {

		Connection c = DbUtils.getConnection();
		try {
			PreparedStatement ps = c
					.prepareStatement("insert into cake_user(name,password) values(?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				Long id = rs.getLong(1);
				user.setId(id);
			} else {
				throw new RuntimeException("no generated key returned");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			DbUtils.clear(c);
		}

		return user;
	}

	public static User find(String name, String password) {

		User user = null;
		Connection c = DbUtils.getConnection();
		try {
			PreparedStatement ps = c
					.prepareStatement("select * from cake_user where name = ? and password = ?");
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.clear(c);
		}

		return user;
	}
}
