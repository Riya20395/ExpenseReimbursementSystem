package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Reimbursement;

public interface ReimbursementDao {

	void createReimbursement(Reimbursement r) throws SQLException;

	void updateReimbursement(Reimbursement r);

	void deleteReimbursementDao(Reimbursement r);

	List<Reimbursement> getAllReimbursement();

	Reimbursement getReimbursementByReimbursementId(int ReimbursementId);
}
