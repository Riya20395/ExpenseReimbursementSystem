package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class UserDaoDB implements UserDao {

	// create connection
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createUser(User u) throws SQLException {
		Connection con = conUtil.getConnection();

		// We will still create the sql string, but with some small changes
		String sql = "INSERT INTO ers_users(ers_username, ers_password, ers_first_name, ers_last_name, ers_email, ers_user_role_id)"
				+ "VALUES(?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, u.getUserName());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getFirstName());
		ps.setString(4, u.getLastName());
		ps.setString(5, u.getEmail());
		ps.setInt(6, u.getUserRoleId());

		ps.execute();

	}

	@Override
	public void updateUser(User u) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE ers_users SET ers_username=?, ers_password=?, ers_first_name=?, ers_last_name=?, ers_email=?, ers_user_role_id=?"
					+ "WHERE ers_users.ers_user_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUserRoleId());
			ps.setInt(7, u.getUserId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User u) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM ers_users WHERE ers_users.ers_user_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();

		try {
			// Make the actual connection to the db
			Connection con = conUtil.getConnection();

			// Create a simple statement
			String sql = "SELECT * FROM ers_users";

			// We need to create a statement with the sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			// We have to loop through the ResultSet and create objects based off the return
			while (rs.next()) {
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}

			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User getUserByuserName(String userName) {
		User user = new User();

		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM ers_users WHERE ers_users.ers_username='" + userName + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUserRoleId(rs.getInt(7));
				
			}

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
