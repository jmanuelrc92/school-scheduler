package com.jmanuelrc.storage.model;

public class Assignment {
	private String assignmentName;
	
	public Assignment () {
		this.assignmentName = null;
	}
	
	public Assignment (String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
}
