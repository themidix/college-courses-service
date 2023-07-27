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


    @RequestMapping(method = RequestMethod.GET,value = "/courses")
    public List<Course> getCourseList(){
        return courseService.getCourseList();
    }

   // @ApiOperation(value ="fetch a course by Id", response= Course.class)
    @RequestMapping(method = RequestMethod.GET,value = "/courses/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    //@ApiOperation(value ="Insert a new course", response= String.class)
    @RequestMapping(method = RequestMethod.POST,value = "/courses")
    public String insertCourse(@RequestBody Course course){
        return courseService.insertCourse(course);
    }

    //@ApiOperation(value ="Edit a course", response= String.class)
    @RequestMapping(method = RequestMethod.PUT,value = "/courses")
    public String editCourse(@RequestBody Course course){
        return courseService.editCourse(course);
    }

   // @ApiOperation(value ="Edit a course", response= String.class)
    @RequestMapping(method = RequestMethod.DELETE,value = "/courses/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }
}
