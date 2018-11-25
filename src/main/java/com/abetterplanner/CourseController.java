package com.abetterplanner;

import com.abetterplanner.Models.Course;
import com.abetterplanner.Repositories.CourseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
@ComponentScan
public class CourseController{
    @Autowired
    private CourseRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Course getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Course course) {
        course.set_id(id);
        repository.save(course);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Course createPet(@Valid @RequestBody Course course) {
        course.set_id(ObjectId.get());
        repository.save(course);
        return course;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
