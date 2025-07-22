package com.example.boke.Student.service;

import com.example.boke.Student.service.DTO.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public interface BokeService {

    StudentDTO getStudentByid(long id);

    Long addNewStudent(StudentDTO student);

    void deleteStudentById(long id);

    StudentDTO updateStudentByid(long id, String name, String email);
}
