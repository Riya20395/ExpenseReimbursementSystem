package com.example.models;

import java.util.Arrays;

public class Reimbursement {

	private int ReimbId;
	private double ReimbAmount;
	// private ReimbSubmitted
	// private ReimbResolved
	private String ReimbDescription;
	private byte[] ReimbReceipt;
	
	private int ReimbAuthor;
	private int ReimbResolver;
	private int ReimbStatusId;
	private int ReimbTypeId;

	public Reimbursement() {
	}

	public Reimbursement(int reimbId, double reimbAmount, String reimbDescription, byte[] reimbReceipt, int reimbAuthor,
			int reimbResolver, int reimbStatusId, int reimbTypeId) {
		ReimbId = reimbId;
		ReimbAmount = reimbAmount;
		ReimbDescription = reimbDescription;
		ReimbReceipt = reimbReceipt;
		ReimbAuthor = reimbAuthor;
		ReimbResolver = reimbResolver;
		ReimbStatusId = reimbStatusId;
		ReimbTypeId = reimbTypeId;
	}

	public Reimbursement(double reimbAmount, String reimbDescription, byte[] reimbReceipt, int reimbAuthor,
			int reimbResolver, int reimbStatusId, int reimbTypeId) {
		ReimbAmount = reimbAmount;
		ReimbDescription = reimbDescription;
		ReimbReceipt = reimbReceipt;
		ReimbAuthor = reimbAuthor;
		ReimbResolver = reimbResolver;
		ReimbStatusId = reimbStatusId;
		ReimbTypeId = reimbTypeId;
	}

	public int getReimbId() {
		return ReimbId;
	}

	public void setReimbId(int reimbId) {
		ReimbId = reimbId;
	}

	public double getReimbAmount() {
		return ReimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		ReimbAmount = reimbAmount;
	}

	public String getReimbDescription() {
		return ReimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		ReimbDescription = reimbDescription;
	}

	public byte[] getReimbReceipt() {
		return ReimbReceipt;
	}

	public void setReimbReceipt(byte[] reimbReceipt) {
		ReimbReceipt = reimbReceipt;
	}

	public int getReimbAuthor() {
		return ReimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		ReimbAuthor = reimbAuthor;
	}

	public int getReimbResolver() {
		return ReimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		ReimbResolver = reimbResolver;
	}

	public int getReimbStatusId() {
		return ReimbStatusId;
	}

	public void setReimbStatusId(int reimbStatusId) {
		ReimbStatusId = reimbStatusId;
	}

	public int getReimbTypeId() {
		return ReimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
		ReimbTypeId = reimbTypeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [ReimbId=" + ReimbId + ", ReimbAmount=" + ReimbAmount + ", ReimbDescription="
				+ ReimbDescription + ", ReimbReceipt=" + Arrays.toString(ReimbReceipt) + ", ReimbAuthor=" + ReimbAuthor
				+ ", ReimbResolver=" + ReimbResolver + ", ReimbStatusId=" + ReimbStatusId + ", ReimbTypeId="
				+ ReimbTypeId + "]";
	}
	
	

}
