package com.abetterplanner.Repositories;

import com.abetterplanner.Models.Course;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    Course findBy_id(ObjectId _id);

    List<Course> findByCourseNumber(String courseNumber);
}
