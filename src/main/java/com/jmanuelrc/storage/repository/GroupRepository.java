package com.jmanuelrc.storage.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jmanuelrc.storage.model.Group;
import com.jmanuelrc.utils.DatabaseUtils;

public class GroupRepository {
		private String databaseName;
		
		public GroupRepository() {
			this.databaseName = null;
		}
		
		public GroupRepository(String databaseName) {
			this.databaseName = databaseName;
		}
		
		public void insert(Group group) {
			String query = "INSERT INTO groups (group_name, group_size, assignment_id, teacher_id, classroom_id, hour) VALUES (?, ?, ?, ?, ?, ?);";
			/*
			 * validation
			 */
			if (true) {
				ArrayList<Group> groupsList = new ArrayList<Group>();
				groupsList.add(group);
				this.insert(query, groupsList);
			}
		}
		
		public void insert(ArrayList<Group> groups) {
			String query = "INSERT INTO groups (group_name, group_size, assignment_id, teacher_id, classroom_id, hour) VALUES ";
			boolean persistanceFlag = true;
			for(int i = 0; i < groups.size(); i++) {
				/*
				 * validation
				 */
				if (true) {
					query += "(?, ?, ?, ?, ?, ?)";
				} else {
					persistanceFlag = false;
					break;
				}
			}
			if (persistanceFlag) {
				query += ";";
				this.insert(query, groups);
			} else {
				//TODO ... error
			}
		}
		
		private void insert(String query, ArrayList<Group> groups) {
			if (this.databaseName == null) {
				this.databaseName = "";
			}
			try {
				Connection databaseConnection = DatabaseUtils.getConnection(databaseName);
				PreparedStatement pst = databaseConnection.prepareStatement(query);
				for(int i = 0, parameterCount = 0; i < groups.size(); i++) {
					pst.setString(parameterCount++, groups.get(i).getGroupName());
				}
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void update(Group group) {
			/*
			 * validation
			 */
			if (true) {
				String query = "UPDATE groups SET assignment_name = ? WHERE assignment_name = ?;";
				this.update(query, group);
			}
		}
		
		private void update(String query, Group group) {
			if (this.databaseName != null) {
				this.databaseName = null;
			}
			try {
				Connection databaseConnection = DatabaseUtils.getConnection(this.databaseName);
				PreparedStatement pst = databaseConnection.prepareStatement(query);
				pst.setString(1, group.getGroupName());
				
				pst.executeUpdate();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
