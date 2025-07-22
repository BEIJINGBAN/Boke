package com.example.boke.Student.service.mpi;

import com.example.boke.Student.service.BokeService;
import com.example.boke.Student.service.converter.BokeConverter;
import com.example.boke.Student.domain.Student;
import com.example.boke.Student.service.DTO.StudentDTO;
import com.example.boke.Student.BokeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BokeSerivicempi implements BokeService {

    @Autowired
    private BokeRepository studentRepository;

    @Override
    public StudentDTO getStudentByid(long id){

        Student student = studentRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));
        return BokeConverter.converStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO){
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(studentList)){
            throw new IllegalStateException("email"+studentDTO.getEmail()+"has been taken");
        }
        Student student = studentRepository.save(BokeConverter.converStudent(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id){
        studentRepository.findById(id).orElseThrow(()->new IllegalStateException("id"+ id + "dosen't exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentByid(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id).orElseThrow(()->new IllegalStateException("id"+ id + "dosen't exist!"));

        if(StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){
            studentInDB.setName(name);
        }
        if(StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)){
            studentInDB.setEmail(email);
        }
        Student student = studentRepository.save(studentInDB);
        return BokeConverter.converStudent(student);
    }
}
