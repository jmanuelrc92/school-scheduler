package com.jmanuelrc.scheduler;

import java.sql.Connection;

import com.jmanuelrc.entity.ClassroomEntity;
import com.jmanuelrc.repository.ClassroomRepository;
import com.jmanuelrc.utils.DatabaseUtils;

public class Scheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DatabaseUtils.getConnection("scheduler.db");
		ClassroomEntity classroom = new ClassroomEntity();
		classroom.setClassroomName("Hola");
		classroom.setCapacity(10);
		
		boolean response = (new ClassroomRepository()).insert(classroom, conn);
		System.out.println(response);
	}

}
