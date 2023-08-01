package com.example.collegecoursesservice.repository;

import com.example.collegecoursesservice.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
@Slf4j
public class CourseRepository {

    private static final Logger LOGGER = Logger.getLogger(CourseRepository.class.getName());
    List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList(){
        return courseList;
    }

    public Course getCourseById(int id) {
        Optional<Course> optionalCourse = courseList.stream()
                .filter(course -> course.getId() == id)
                .findFirst();

        if (optionalCourse.isEmpty()) {
            throw new EmptyStackException();
        }

        return optionalCourse.get();
    }

    public String insertCourse(Course course){
        try{
            if(course != null)
                courseList.add(course);
            return "Course added successfully!";
        }catch (Exception e){
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
        return "unable to add course";
    }
    public String editCourse(Course course){

        if(course.getId() > 0){
            courseList.stream().filter(course1 -> course1.getId() == course.getId())
                    .forEach(index -> {
                        index.setCourseCode(course.getCourseCode());
                        index.setCourseName(course.getCourseName());
                    });
            return "Course with ID#" + course.getId() + " is updated successfully!";
        }
       throw new ArithmeticException("Cannot find course id ");

    }
    public String deleteCourse(int id){
        try{
            if(id > 0)
                courseList.removeIf(course -> course.getId() == id);
            return "Course with ID# is " + id + "successfully deleted!";
        }catch(Exception e){
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
        return "Unable to delete course with ID#" + id;
    }
}
