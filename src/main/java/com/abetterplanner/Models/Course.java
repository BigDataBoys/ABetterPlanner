package com.abetterplanner.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Course {

    @Id
    private ObjectId _id;

    private String course_number;
    private String class_number;
    private String building;
    private String time;
    private String instructor;

    public Course(){

    }

    public Course(ObjectId _id, String course_number, String class_number, String building, String time, String instructor){
        this._id = _id;
        this.course_number = course_number;
        this.class_number = class_number;
        this.building = building;
        this.time = time;
        this.instructor = instructor;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getCourse_number() {
        return course_number;
    }

    public void setCourse_number(String course_number) {
        this.course_number = course_number;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
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
