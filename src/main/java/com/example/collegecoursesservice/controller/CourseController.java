package com.example.collegecoursesservice.controller;

import com.example.collegecoursesservice.model.Course;
import com.example.collegecoursesservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping(path = "/getCourseList")
    public List<Course> getCourseList(){
        return courseService.getCourseList();
    }


    @GetMapping(path = "/courses/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @PostMapping(path = "/courses")
    public String insertCourse(@RequestBody Course course){
        return courseService.insertCourse(course);
    }

    @PutMapping(path = "/editCourse")
    public String editCourse(@RequestBody Course course){
        return courseService.editCourse(course);
    }

    @DeleteMapping(path = "/courses/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }
}
