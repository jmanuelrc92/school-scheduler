package com.jmanuelrc.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jmanuelrc.utils.ArrayUtils;
import com.jmanuelrc.utils.DatabaseUtils;

public class ClassroomEntity extends BaseEntity{
	
	private String classroomName;
	private int capacity;
	
	public ClassroomEntity () {
		super();
		this.classroomName = null;
		this.capacity = -1;
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

	@Override
	void performInsert() {
		// TODO Auto-generated method stub
		ArrayList<String> fields = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		String query = null;
		if (this.classroomName != null) {
			fields.add("classroom_name");
			values.add("\"" + this.classroomName + "\"");
		} else {
			//TODO
		}
		
		if (this.capacity > 0) {
			fields.add("capacity");
			values.add(String.valueOf(this.capacity));
		} else {
			//TODO
		}
	
		query = this.insertSingleQuery.replace(":tableName:", "classrooms");
		query = query.replace(":fields:", ArrayUtils.mImplode(fields, ","));
		query = query.replace(":conditions:", ArrayUtils.mImplode(values, ","));
		Connection conn = DatabaseUtils.getConnection("scheduler.db");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		Connection conn = DatabaseUtils.getConnection("scheduler.db");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
