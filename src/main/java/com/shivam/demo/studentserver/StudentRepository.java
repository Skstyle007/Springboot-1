package com.shivam.demo.studentserver;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public Student save(Student student){
        System.out.println("Student information saved");
        return student;
    }
}