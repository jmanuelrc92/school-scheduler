package com.jmanuelrc.storage.model;

import java.util.ArrayList;

public class Teacher {
	private String teacherKey;
	private int firstHour;
	private int lastHour;
	private ArrayList<Assignment> assignments;
	
	public Teacher () {
		this.teacherKey = null;
		this.firstHour = -1;
		this.lastHour = -1;
		this.assignments = null;
	}
	
	public Teacher (String teacherKey, int firstHour, int lastHour) {
		this.teacherKey = teacherKey;
		this.firstHour = firstHour;
		this.lastHour = lastHour;
	}

	public String getTeacherKey() {
		return teacherKey;
	}

	public void setTeacherKey(String teacherKey) {
		this.teacherKey = teacherKey;
	}

	public int getFirstHour() {
		return firstHour;
	}

	public void setFirstHour(int firstHour) {
		this.firstHour = firstHour;
	}

	public int getLastHour() {
		return lastHour;
	}

	public void setLastHour(int lastHour) {
		this.lastHour = lastHour;
	}

	public void setSchedule(int firstHour, int lastHour) {
		this.firstHour = firstHour;
		this.lastHour = lastHour;
	}
	
	public void addAssignment(Assignment assignment) {
		if (this.assignments == null) {
			this.assignments = new ArrayList<Assignment>();
		}
		this.assignments.add(assignment);
	}
}
