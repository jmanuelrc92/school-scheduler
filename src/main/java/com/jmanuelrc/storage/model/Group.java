package com.jmanuelrc.storage.model;

public class Group {
	private String groupName;
	private int groupSize;
	private Assignment assignment;
	private Teacher teacher;
	private Classroom classroom;
	private int hour;
	
	public Group() {
		this.groupName = null;
		this.groupSize = -1;
		this.assignment = null;
		this.teacher = null;
		this.classroom = null;
		this.hour = -1;
	}
	
	public Group(String groupName, int groupSize, Assignment assignment, Teacher teacher, Classroom classroom,
			int hour) {
		this.groupName = groupName;
		this.groupSize = groupSize;
		this.assignment = assignment;
		this.teacher = teacher;
		this.classroom = classroom;
		this.hour = hour;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
}
