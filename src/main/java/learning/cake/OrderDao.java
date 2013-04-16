package learning.cake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

	public static List<Order> list() {
		List<Order> orders = new ArrayList<Order>();
		Connection c = DbUtils.getConnection();

		try {
			PreparedStatement ps = c.prepareStatement("select * from cake_order");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getLong("id"));
				o.setCustName(rs.getString("cust_name"));
				o.setCustAddr(rs.getString("cust_addr"));
				o.setPhone(rs.getString("phone"));
				o.setCakeName(rs.getString("cake_name"));
				o.setCount(rs.getInt("count"));
				orders.add(o);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.clear(c);
		}

		return orders;
	}

	public static Order findById(Long id) {
		Order order = null;
		Connection c = DbUtils.getConnection();

		try {
			PreparedStatement ps = c.prepareStatement("select * from cake_order where id = ?");
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				order = new Order();
				order.setId(rs.getLong("id"));
				order.setCustName(rs.getString("cust_name"));
				order.setCustAddr(rs.getString("cust_addr"));
				order.setPhone(rs.getString("phone"));
				order.setCakeName(rs.getString("cake_name"));
				order.setCount(rs.getInt("count"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.clear(c);
		}

		return order;
	}

	public static void save(Order order) {
		Connection c = DbUtils.getConnection();

		try {
			PreparedStatement ps = c
					.prepareStatement("insert into cake_order(cust_name,cust_addr,phone,cake_name,count) values(?,?,?,?,?)");
			ps.setString(1, order.getCustName());
			ps.setString(2, order.getCustAddr());
			ps.setString(3, order.getPhone());
			ps.setString(4, order.getCakeName());
			ps.setInt(5, order.getCount());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.clear(c);
		}
	}

	public static void update(Order order) {
		Connection c = DbUtils.getConnection();

		try {
			PreparedStatement ps = c
					.prepareStatement("update cake_order set cust_name = ?,cust_addr = ?,phone = ?,cake_name = ?,count = ? where id = ?");
			ps.setString(1, order.getCustName());
			ps.setString(2, order.getCustAddr());
			ps.setString(3, order.getPhone());
			ps.setString(4, order.getCakeName());
			ps.setInt(5, order.getCount());
			ps.setLong(6, order.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.clear(c);
		}
	}

	public static void deleteById(Long id) {
		Connection c = DbUtils.getConnection();

		try {
			PreparedStatement ps = c.prepareStatement("delete from cake_order where id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.clear(c);
		}
	}
}
