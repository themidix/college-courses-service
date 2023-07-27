package com.example.collegecoursesservice.repository;

import com.example.collegecoursesservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Integer> {
}
