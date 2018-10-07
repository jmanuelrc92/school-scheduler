package com.jmanuelrc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jmanuelrc.entity.ClassroomEntity;

public class ClassroomRepository extends BaseRepository{
	private final String tableName = "classrooms";
	
	public ClassroomRepository() {
		super();
		this.setTableName(tableName);
	}
	
	public boolean insert(ClassroomEntity classroom, Connection dbConnection) {
		PreparedStatement command = null;
		try {
			command = dbConnection.prepareStatement("INSERT INTO " + tableName + " (classroom_name, capacity) VALUES (?, ?);");
			command.setString(1, classroom.getClassroomName());
			command.setInt(2, classroom.getCapacity());
			return super.insert(command);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void select() {
		
	}
	
}
