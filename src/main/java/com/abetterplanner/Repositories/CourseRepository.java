package com.abetterplanner.Repositories;

import com.abetterplanner.Models.Course;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    Course findBy_id(ObjectId _id);
}
