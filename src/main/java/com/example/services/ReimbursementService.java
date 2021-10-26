package com.example.services;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.ReimbursementDao;
import com.example.models.Reimbursement;
import com.example.models.User;

public class ReimbursementService {

private ReimbursementDao rDao;
	
	public ReimbursementService(ReimbursementDao rdao) {
		this.rDao = rdao;
	}
	
	// create request for reimbursement
	public void RequestReimbursement(double reimbAmount, String reimbDescription, byte[] reimbReceipt, int reimbAuthor,
			int reimbResolver, int reimbStatusId, int reimbTypeId) throws SQLException {
		Reimbursement  r= new Reimbursement(reimbAmount, reimbDescription, 
				reimbReceipt, reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId);
		rDao.createReimbursement(r);
	}
	
	//all request from all user
	public List<Reimbursement> getAllRequests(){
		return rDao.getAllReimbursement();
	}
	
	//all request with status id
	public List<Reimbursement> getAllRequests(int StatusId){
		return rDao.getAllReimbursementByStatus(StatusId);
	}
	
	public List<Reimbursement> getAllRequests(int authorId,int StatusId){
		return rDao.getAllReimbursementByStatusByAuthor(authorId,StatusId);
	}
	
	//all request from specific user
	public User loadUserRequest(User u) {
		return rDao.loadUserRequest(u);
	}
}
