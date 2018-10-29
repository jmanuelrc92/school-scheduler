package com.jmanuelrc.storage.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jmanuelrc.storage.model.Teacher;
import com.jmanuelrc.utils.DatabaseUtils;

public class TeacherRepository {
	private String databaseName;
	
	public TeacherRepository () {
		this.databaseName = null;
	}
	
	public TeacherRepository (String databaseName) {
		this.databaseName = databaseName;
	}
	
	public void insert(Teacher teacher) {
		String query = "INSERT INTO teachers (teacher_key, first_hour, last_hour) VALUES (?,?,?);";
		/*
		 * validation
		 */
		if (true) {
			ArrayList<Teacher> teachersList = new ArrayList<Teacher>();
			teachersList.add(teacher);
			this.insert(query, teachersList);
		}
	}
	
	public void insert(ArrayList<Teacher> teachers) {
		String query = "INSERT INTO teachers (teacher_key, first_hour, last_hour) VALUES ";
		boolean persistanceFlag = true;
		for(int i = 0; i < teachers.size(); i++) {
			/*
			 * validation
			 */
			if (true) {
				query += "(?, ?, ?)";
			} else {
				persistanceFlag = false;
				break;
			}
		}
		if (persistanceFlag) {
			query += ";";
			this.insert(query, teachers);
		} else {
			//TODO ... error
		}
	}
	
	private void insert(String query, ArrayList<Teacher> teachers) {
		if (this.databaseName == null) {
			this.databaseName = "";
		}
		try {
			Connection databaseConnection = DatabaseUtils.getConnection(databaseName);
			PreparedStatement pst = databaseConnection.prepareStatement(query);
			for(int i = 0, parameterCount = 0; i < teachers.size(); i++) {
				pst.setString(parameterCount++, teachers.get(i).getTeacherKey());
				pst.setInt(parameterCount++, teachers.get(i).getFirstHour());
				pst.setInt(parameterCount++, teachers.get(i).getLastHour());
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Teacher teacher) {
		/*
		 * validation
		 */
		if (true) {
			String query = "UPDATE teachers SET teacher_key = ?, first_hour = ?, last_hour = ? WHERE teacher_key = ?;";
			this.update(query, teacher);
		}
	}
	
	private void update(String query, Teacher teacher) {
		if (this.databaseName != null) {
			this.databaseName = null;
		}
		try {
			Connection databaseConnection = DatabaseUtils.getConnection(this.databaseName);
			PreparedStatement pst = databaseConnection.prepareStatement(query);
			pst.setString(1, teacher.getTeacherKey());
			pst.setInt(2, teacher.getFirstHour());
			pst.setInt(3, teacher.getLastHour());
			pst.setString(4, teacher.getTeacherKey());
			
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
