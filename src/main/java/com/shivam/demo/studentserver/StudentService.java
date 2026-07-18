package com.shivam.demo.studentserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student studentValidate(Student student){
        int id = student.getId();
        String name  = student.getName();
        int age = student.getAge();
        String department = student.getDepartment();

        if(id<0 || name == null || age<0 || department==null || age>100){
            return null;
        }

        student.setCreatedAt(LocalDateTime.now());


        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if(existingStudent == null){
            return null;
        }
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setDepartment(student.getDepartment());
      //  existingStudent.setUpdateAt(LocalDateTime.now());
        existingStudent.setUpdatedAt(LocalDateTime.now());
        studentRepository.save(existingStudent);

        return existingStudent;

    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
