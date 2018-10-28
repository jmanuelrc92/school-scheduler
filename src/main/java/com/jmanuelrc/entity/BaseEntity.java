package com.jmanuelrc.entity;

public abstract class BaseEntity {
	protected int id;
	
	protected final String insertSingleQuery = "INSERT INTO :tableName: (:fields:) VALUES (:conditions:);";
	protected final String updateQuery = "UPDATE :tableName: SET :fields: WHERE :conditions:;";
	
	public BaseEntity() {
		this.id = -1;
	}
	
	public boolean isNew() {
		return (this.id < 1);
	}
	
	public void save() {
		if (this.isNew()) {
			//performInsert
			this.performInsert();
		} else {
			//performUpdate
			this.performUpdate();
		}
	}
	
	abstract void performInsert();
	abstract void performUpdate();
}
