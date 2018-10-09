package com.abetterplanner.controller;
import java.util.ArrayList;

public class Course {
	private String name;
	private ArrayList<Course> prereqs = new ArrayList<Course>();
	private String description;
	private boolean completed = false;
	
	public Course(String n, String d) {
		name = n;
		description = d;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public void addPrereq(Course C) {
		prereqs.add(C);
	}
	
	public boolean isCompleted() {
		return completed;
	}
}
