package com.jmanuelrc.storage.model;

public class Classroom {
	private String classroomName;
	private int capacity;
	
	public Classroom () {
		this.capacity = -1;
		this.classroomName = null;
	}
	
	public Classroom(String classroomName, int capacity) {
		this.classroomName = classroomName;
		this.capacity = capacity;
	}

	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
