package com.batch.model;

public class GetMember {
	String usn, sem;

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public GetMember(String usn, String sem) {
		super();
		this.usn = usn;
		this.sem = sem;
	}
	
}
