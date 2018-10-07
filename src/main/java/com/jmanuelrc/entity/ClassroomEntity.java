package com.jmanuelrc.entity;

public class ClassroomEntity extends BaseEntity{
	
	private String classroomName;
	private int capacity;
	
	public ClassroomEntity () {
		super();
		this.classroomName = "CTST";
		this.capacity = 10;
	}

	/**
	 * @return the classroomName
	 */
	public String getClassroomName() {
		return classroomName;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param classroomName the classroomName to set
	 */
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
