package com.abetterplanner.Models;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
public class CourseNumber {

    private String courseNumber;
    @Field("building")
    private String building;
    @Field("time")
    private String time;
    @Field("instructor")
    private String instructor;

    public CourseNumber() {

    }

    public CourseNumber(String courseNumber){
        this.courseNumber = courseNumber;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setSubValues(String building, String time, String instructor){
        this.building = building;
        this.time = time;
        this.instructor = instructor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
