package com.core;

import java.io.Serializable;

public enum Plan implements Serializable{
	MONTHLY(3000), QUARTARLY(11700), HALFYEAR(17500), YEARLY(32000);
	
	private double planAmount;
	
	public double getPlanAmount() {
		return planAmount;
	}

	public void setPlanAmount(double planAmount) {
		this.planAmount = planAmount;
	}

	Plan(double planAmount) {
		this.planAmount=planAmount;
	}
}
