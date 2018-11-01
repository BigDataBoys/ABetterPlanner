package com.abetterplanner.data;

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

	public void addPrereq(ArrayList<Course> course){
		prereqs.addAll(course);
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed){
		this.completed = completed;
	}
}
