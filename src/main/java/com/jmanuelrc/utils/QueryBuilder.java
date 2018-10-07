package com.jmanuelrc.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

public class QueryBuilder<T> {
	private String queryType;
	
	
	private ArrayList<String> fields;
	private ArrayList<String> types;
	private ArrayList<T> values;
	private String query;
	private String tableName;
	
	public final static String INSERT = "INSERT";
	public final static String UPDATE = "UPDATE";
	public final static String DELETE = "DELETE";
	public final static String SELECT = "SELECT";
	
	public QueryBuilder (String queryType) {
		this.queryType = queryType;
		switch (queryType) {
		case QueryBuilder.INSERT:
			break;
		case QueryBuilder.SELECT:
			break;
		case QueryBuilder.UPDATE:
		case QueryBuilder.DELETE:
			//TODO
			break;
		}
		this.fields = new ArrayList<String>();
		this.types = new ArrayList<String>();
		this.values = new ArrayList<T>();
		this.query = null;
		this.tableName = null;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(ArrayList<String> fields) {
		this.fields = fields;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(ArrayList<T> values) {
		this.values = values;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	private String getColumns(ArrayList<String> list, String separator, String type) {
		String elementsUnited = null;
		switch (type) {
		case "insert":
			elementsUnited = String.join(type, list);
			break;
		case "select":
			ArrayList<String>copyList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				copyList.add(list.get(i) + " = ?");
			}
			elementsUnited = String.join(separator, copyList);
			break;
		}
		return elementsUnited;
	}
	
	public boolean insert(Connection databaseConnection) {
		this.query = this.query.replaceAll(":tableName:", this.tableName);
		this.query = this.query.replaceAll(":columns:", this.getColumns(this.fields, ",", "insert"));
		
		return false;
	}

}