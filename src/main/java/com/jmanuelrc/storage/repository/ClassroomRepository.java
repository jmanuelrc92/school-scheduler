package com.jmanuelrc.storage.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jmanuelrc.storage.model.Classroom;
import com.jmanuelrc.utils.DatabaseUtils;

public class ClassroomRepository {
		private String databaseName;
		
		public ClassroomRepository() {
			this.databaseName = null;
		}
		
		public ClassroomRepository(String databaseName) {
			this.databaseName = databaseName;
		}
		
		public void insert(Classroom classroom) {
			String query = "INSERT INTO classrooms (classroom_name, capacity) VALUES (?,?);";
			/*
			 * validation
			 */
			if (true) {
				ArrayList<Classroom> classroomsList = new ArrayList<Classroom>();
				classroomsList.add(classroom);
				this.insert(query, classroomsList);
			}
		}
		
		public void insert(ArrayList<Classroom> classrooms) {
			String query = "INSERT INTO classrooms (classroom_name, capacity) VALUES ";
			boolean persistanceFlag = true;
			for(int i = 0; i < classrooms.size(); i++) {
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
				this.insert(query, classrooms);
			} else {
				//TODO ... error
			}
		}
		
		private void insert(String query, ArrayList<Classroom> classrooms) {
			if (this.databaseName == null) {
				this.databaseName = "";
			}
			try {
				Connection databaseConnection = DatabaseUtils.getConnection(databaseName);
				PreparedStatement pst = databaseConnection.prepareStatement(query);
				for(int i = 0, parameterCount = 0; i < classrooms.size(); i++) {
					pst.setString(parameterCount++, classrooms.get(i).getClassroomName());
					pst.setInt(parameterCount++, classrooms.get(i).getCapacity());
				}
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void update(Classroom classroom) {
			/*
			 * validation
			 */
			if (true) {
				String query = "UPDATE classrooms SET classroom_name = ?, capacity = ? WHERE classroom_name = ?;";
				this.update(query, classroom);
			}
		}
		
		private void update(String query, Classroom classroom) {
			if (this.databaseName != null) {
				this.databaseName = null;
			}
			try {
				Connection databaseConnection = DatabaseUtils.getConnection(this.databaseName);
				PreparedStatement pst = databaseConnection.prepareStatement(query);
				pst.setString(1, classroom.getClassroomName());
				pst.setInt(2, classroom.getCapacity());
				
				pst.executeUpdate();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}