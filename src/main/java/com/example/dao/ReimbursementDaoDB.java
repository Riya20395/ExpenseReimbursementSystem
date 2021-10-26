package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Reimbursement;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class ReimbursementDaoDB implements ReimbursementDao {

	// create connection
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createReimbursement(Reimbursement r) throws SQLException {
		Connection con = conUtil.getConnection();

		// We will still create the sql string, but with some small changes
		String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
				+ "VALUES(?, ?, ?, ?, ?, ?,?);";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDouble(1, r.getReimbAmount());
		ps.setString(2, r.getReimbDescription());
		ps.setBytes(3, r.getReimbReceipt());
		ps.setInt(4, r.getReimbAuthor());
		ps.setInt(5, r.getReimbResolver());
		ps.setInt(6, r.getReimbStatusId());
		ps.setInt(7, r.getReimbTypeId());

		ps.execute();
	}

	@Override
	public void updateReimbursement(Reimbursement r) {
		try {
			Connection con = conUtil.getConnection();

			String sql = "UPDATE ers_reimbursement SET reimb_amount=?, reimb_submitted=?,reimb_resolved=?, reimb_description=?, reimb_receipt=?, reimb_author=?, reimb_resolver=?, reimb_status_id=?, reimb_type_id=?"
					+ "WHERE ers_reimbursement.reimb_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, r.getReimbAmount());
			ps.setString(2, r.getReimbDescription());
			ps.setBytes(3, r.getReimbReceipt());
			ps.setInt(4, r.getReimbAuthor());
			ps.setInt(5, r.getReimbResolver());
			ps.setInt(6, r.getReimbStatusId());
			ps.setInt(7, r.getReimbTypeId());
			ps.setInt(8, r.getReimbId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteReimbursementDao(Reimbursement r) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM ers_reimbursement WHERE ers_reimbursement.reimb_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getReimbId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();

		try {
			// Make the actual connection to the db
			Connection con = conUtil.getConnection();

			// Create a simple statement
			String sql = "SELECT * FROM ers_reimbursement";

			// We need to create a statement with the sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			// We have to loop through the ResultSet and create objects based off the return
			while (rs.next()) {
				reimbursementList.add(new Reimbursement(rs.getInt(1),rs.getDouble(2), rs.getString(3),rs.getBytes(4),rs.getInt(5),rs.getInt(6),rs.getInt(7), rs.getInt(8)));
			}

			return reimbursementList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Reimbursement getReimbursementByReimbursementId(int ReimbursementId) {
		Reimbursement reimbursement = new Reimbursement();

		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM ers_reimbursement WHERE ers_reimbursement.reimb_id = '" + ReimbursementId + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				reimbursement.setReimbId(rs.getInt(1));
				reimbursement.setReimbAmount(rs.getDouble(2));
				reimbursement.setReimbDescription(rs.getString(3));
				reimbursement.setReimbReceipt(rs.getBytes(4));
				reimbursement.setReimbAuthor(rs.getInt(5));
				reimbursement.setReimbResolver(rs.getInt(6));
				reimbursement.setReimbStatusId(rs.getInt(7));
				reimbursement.setReimbTypeId(rs.getInt(8));
				
			}

			return reimbursement;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Reimbursement> getAllReimbursementByStatus(int ReimbStatusId) {
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();

		try {
			// Make the actual connection to the db
			Connection con = conUtil.getConnection();

			// Create a simple statement
			String sql = "SELECT * FROM ers_reimbursement WHERE ers_reimbursement.reimb_id = '" + ReimbStatusId + "'";

			// We need to create a statement with the sql string 
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			// We have to loop through the ResultSet and create objects based off the return
			while (rs.next()) {
				reimbursementList.add(new Reimbursement(rs.getInt(1),rs.getDouble(2), rs.getString(3),rs.getBytes(4),rs.getInt(5),rs.getInt(6),rs.getInt(7), rs.getInt(8)));
			}

			return reimbursementList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursementByStatusByAuthor(int ReimbAuthor, int ReimbStatusId) {
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();

		try {
			// Make the actual connection to the db
			Connection con = conUtil.getConnection();

			// Create a simple statement
			String sql = "SELECT * FROM ers_reimbursement WHERE ers_reimbursement.reimb_id = '" + ReimbAuthor + "',ers_reimbursement.reimb_id = '" + ReimbStatusId + "'";

			// We need to create a statement with the sql string 
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			// We have to loop through the ResultSet and create objects based off the return
			while (rs.next()) {
				reimbursementList.add(new Reimbursement(rs.getInt(1),rs.getDouble(2), rs.getString(3),rs.getBytes(4),rs.getInt(5),rs.getInt(6),rs.getInt(7), rs.getInt(8)));
			}

			return reimbursementList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User loadUserRequest(User u) {
		List<Reimbursement> requests = new ArrayList<Reimbursement>();
		
		try {
			
			Connection con = conUtil.getConnection();
			
			con.setAutoCommit(false);
			
			String sql = "{?=call get_user_requests(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, u.getUserId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getBytes(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8));
				requests.add(r);
			}
			
			u.setRequests(requests);
			
			con.setAutoCommit(true);
			
			return u;	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
}
}
