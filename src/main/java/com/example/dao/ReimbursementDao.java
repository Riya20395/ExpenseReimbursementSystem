package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Reimbursement;
import com.example.models.User;

public interface ReimbursementDao {

	void createReimbursement(Reimbursement r) throws SQLException;

	void updateReimbursement(Reimbursement r);

	void deleteReimbursementDao(Reimbursement r);

	List<Reimbursement> getAllReimbursement();
	
	List<Reimbursement> getAllReimbursementByStatus(int ReimbStatusId);
	
	List<Reimbursement> getAllReimbursementByStatusByAuthor(int ReimbAuthor,int ReimbStatusId);
	
	public User loadUserRequest(User u);

	Reimbursement getReimbursementByReimbursementId(int ReimbursementId);
}
