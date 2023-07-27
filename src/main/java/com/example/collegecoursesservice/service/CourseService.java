package com.example.collegecoursesservice.service;

import com.example.collegecoursesservice.model.Course;
import com.example.collegecoursesservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourseList(){
        return courseRepository.getCourseList();
    }
    public Course getCourseById(int id){
        return courseRepository.getCourseById(id);
    }
    public String insertCourse(Course course){
        return courseRepository.insertCourse(course);
    }
    public String editCourse(Course course){
        return courseRepository.editCourse(course);
    }
    public String deleteCourse(int id){
        return courseRepository.deleteCourse(id);
    }
}
