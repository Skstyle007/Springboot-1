package com.shivam.demo.studentserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.shivam.demo.studentserver.DTO.CreateStudentRequestDTO;
import com.shivam.demo.studentserver.DTO.CreateStudentResponseDTO;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService  = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(@RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
        CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);

        if(result == null){
            return ResponseEntity.status(400).body("Invalid student data");
        }

        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,
                                           @RequestBody Student student){

        Student result = studentService.updateStudent(id, student);

        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {

        studentService.deleteStudent(id);

        return ResponseEntity.status(200).body("Student Deleted Successfully");
    }
}
