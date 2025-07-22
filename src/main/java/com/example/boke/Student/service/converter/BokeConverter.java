package com.example.boke.Student.service.converter;

import com.example.boke.Student.domain.Student;
import com.example.boke.Student.service.DTO.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class BokeConverter {
    public static StudentDTO converStudent(Student student) {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }
    public static Student converStudent(StudentDTO studentDTO) {

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        return student;
    }
}
