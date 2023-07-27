package com.example.collegecoursesservice;

import com.example.collegecoursesservice.controller.CourseController;
import com.example.collegecoursesservice.model.Course;
import com.example.collegecoursesservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CollegeCoursesServiceApplication implements CommandLineRunner {


    private CourseRepository courseRepository;

    @Autowired
    public CollegeCoursesServiceApplication(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CollegeCoursesServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Course> list = new ArrayList<>(Arrays.asList(
              new Course(1,"CS1100","Intro to  computer Science Principles"),
                new Course(2,"CS372","Data Structures"),
                new Course(3,"SWE7200","Requirements Engineering"),
                new Course(4,"SWE6372","Web Engineering")
        ));
        courseRepository.getCourseList().addAll(list);
    }

}
