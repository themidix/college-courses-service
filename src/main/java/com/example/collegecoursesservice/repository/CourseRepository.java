package com.example.collegecoursesservice.repository;

import com.example.collegecoursesservice.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList(){
        return courseList;
    }

    public Course getCourseById(int id){
        try{
            if(id > 0)
                return courseList.stream().filter(course -> course.getId() == id).findFirst().get();
        }catch(Exception e){
            e.printStackTrace();
        }
        throw new NullPointerException("Unable to find course with this id");
    }

    public String insertCourse(Course course){
        try{
            if(course != null)
                courseList.add(course);
            return "Course added successfully!";
        }catch (Exception e){
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return "Unable to delete course with ID#" + id;
    }
}
