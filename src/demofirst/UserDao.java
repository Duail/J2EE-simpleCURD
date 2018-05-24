package demofirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public UserDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getconnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
				+ "characterEncoding=utf-8&useSSL=true","root","dc13526005039");
	}
	
	public int getTotal() {
		int total = 0;
		String sql = "select count(*) from demofirst";
		try (Connection c = getconnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public void add(UserInfo userInfo) {
		String sql = "insert into demofirst values(null,?,?,?)";
		try (Connection c = getconnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, userInfo.getName());
			ps.setString(2, userInfo.getEmail());
			ps.setString(3, userInfo.getTelephone());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(UserInfo userInfo) {
		String sql = "update demofirst set name=?,email=?,telephone=? where id=?";
		try (Connection c = getconnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, userInfo.getName());
			ps.setString(2, userInfo.getEmail());
			ps.setString(3, userInfo.getTelephone());
			ps.setInt(4, userInfo.getId());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "delete from demofirst where id=?";
		try (Connection c = getconnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public UserInfo get(int id) {
		UserInfo userInfo = new UserInfo();
		String sql = "select * from demofirst where id=?";
		try (Connection c = getconnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				userInfo.setId(rs.getInt(1));
				userInfo.setName(rs.getString(2));
				userInfo.setEmail(rs.getString(3));
				userInfo.setTelephone(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userInfo;
	}
	
	public List<UserInfo> list() {
		return list(0, 999);
	}
	
	public List<UserInfo> list(int start, int count) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		String sql = "select * from demofirst limit ?,?";
		try (Connection c = getconnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, start);
			ps.setInt(2, count);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setId(rs.getInt(1));
				userInfo.setName(rs.getString(2));
				userInfo.setEmail(rs.getString(3));
				userInfo.setTelephone(rs.getString(4));
				
				userInfos.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfos;
	}

}
