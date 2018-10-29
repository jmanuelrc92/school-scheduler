package com.jmanuelrc.storage.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jmanuelrc.storage.model.Assignment;
import com.jmanuelrc.utils.DatabaseUtils;

public class AssignmentRepository {
	private String databaseName;
	
	public AssignmentRepository () {
		this.databaseName = null;
	}
	
	public AssignmentRepository (String databaseName) {
		this.databaseName = databaseName;
	}
	
	public void insert(Assignment assignment) {
		String query = "INSERT INTO assignments (assignment_name) VALUES (?);";
		/*
		 * validation
		 */
		if (true) {
			ArrayList<Assignment> assignmentsList = new ArrayList<Assignment>();
			assignmentsList.add(assignment);
			this.insert(query, assignmentsList);
		}
	}
	
	public void insert(ArrayList<Assignment> assignments) {
		String query = "INSERT INTO assignments (assignment_name) VALUES ";
		boolean persistanceFlag = true;
		for(int i = 0; i < assignments.size(); i++) {
			/*
			 * validation
			 */
			if (true) {
				query += "(?)";
			} else {
				persistanceFlag = false;
				break;
			}
		}
		if (persistanceFlag) {
			query += ";";
			this.insert(query, assignments);
		} else {
			//TODO ... error
		}
	}
	
	private void insert(String query, ArrayList<Assignment> assignments) {
		if (this.databaseName == null) {
			this.databaseName = "";
		}
		try {
			Connection databaseConnection = DatabaseUtils.getConnection(databaseName);
			PreparedStatement pst = databaseConnection.prepareStatement(query);
			for(int i = 0, parameterCount = 0; i < assignments.size(); i++) {
				pst.setString(parameterCount++, assignments.get(i).getAssignmentName());
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Assignment assignment) {
		/*
		 * validation
		 */
		if (true) {
			String query = "UPDATE assignments SET assignment_name = ? WHERE assignment_name = ?;";
			this.update(query, assignment);
		}
	}
	
	private void update(String query, Assignment assignment) {
		if (this.databaseName != null) {
			this.databaseName = null;
		}
		try {
			Connection databaseConnection = DatabaseUtils.getConnection(this.databaseName);
			PreparedStatement pst = databaseConnection.prepareStatement(query);
			pst.setString(1, assignment.getAssignmentName());
			
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
