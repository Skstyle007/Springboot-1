package com.shivam.demo.studentserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shivam.demo.studentserver.DTO.CreateStudentRequestDTO;
import com.shivam.demo.studentserver.DTO.CreateStudentResponseDTO;

import java.time.LocalDateTime;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO){
        Student student = mapToStudent(createStudentRequestDTO);
        student = studentRepository.save(student);
        return mapToResponseDTO(student);
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = new Student();
        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());
        return createStudentResponseDTO;
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
