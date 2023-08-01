package com.example.collegecoursesservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private int id;
    private String courseCode;
    private String courseName;
}
