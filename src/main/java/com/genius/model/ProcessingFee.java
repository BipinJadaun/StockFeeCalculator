package com.genius.model;

public enum ProcessingFee {	
	TEN(10),
	FIFTY(50),
	HUNDREAD(100),
	FIVE_HUNDREAD(500);
	
	private double fees;
	
	ProcessingFee(double fees) {
		this.fees = fees;
	}
	public double getFees() {
		return fees;
	} 

}
