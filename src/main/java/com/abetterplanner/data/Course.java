package com.abetterplanner.data;

import com.abetterplanner.data.provider.CourseInterface;

import java.util.ArrayList;

public class Course implements CourseInterface<Course> {
	private String name;
	private String description;
	private boolean completed;
	private ArrayList<Course> prerequisites;

	public Course(String name, String description){
		this(name, description, false);
	}

	public Course(String name, String description, boolean completed){
		this(name, description, completed, new ArrayList<>());
	}

	public Course(String name, String description, boolean completed, ArrayList<Course> prerequisites) {
		this.name = name;
		this.description = description;
		this.completed = completed;
		this.prerequisites.addAll(prerequisites);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean isCompleted() {
		return completed;
	}

	@Override
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}

	@Override
	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites.addAll(prerequisites);
	}

	@Override
	public void setPrerequisite(Course course){
		this.prerequisites.add(course);
	}
}
