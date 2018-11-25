package com.abetterplanner.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Course {

    @Id
    private ObjectId _id;

    //TODO: Fix traversal of courseNumber and classNumbers
    private String courseNumber;
    private ArrayList<CourseNumber> classNumbers;

    public Course(){

    }

    public Course(ObjectId _id, String courseNumber, ArrayList<CourseNumber> classNumbers){
        this._id = _id;
        this.courseNumber = courseNumber;
        this.classNumbers = classNumbers;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public ArrayList<CourseNumber> getClassNumbers() {
        return classNumbers;
    }

    public void setClassNumbers(ArrayList<CourseNumber> classNumbers) {
        this.classNumbers = classNumbers;
    }
}
