package com.example.boke.Student;

import com.example.boke.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BokeRepository extends JpaRepository<Student, Long > {

    List<Student> findByEmail(String email);
}


