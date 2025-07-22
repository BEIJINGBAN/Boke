package com.example.boke.Student.controller;

import com.example.boke.Student.service.DTO.StudentDTO;
import com.example.boke.Response;
import com.example.boke.Student.service.BokeService;
import com.example.boke.annotation.OUT;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class BokeController {

    @Autowired
    private BokeService bokeService;

    @OUT
    @GetMapping("/student")
    public Response<StudentDTO> getStudentByid(@RequestParam("id") long id){
        return Response.newSuccess(bokeService.getStudentByid(id));
    }


    @PostMapping("/student")
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO){
        return Response.newSuccess(bokeService.addNewStudent(studentDTO));
    }


    @DeleteMapping("/student")
    public void deleteStudent(@PathParam("id") long id){
        bokeService.deleteStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Response<StudentDTO> updateStudentById(@PathVariable long id,@RequestParam(required = false) String name,@RequestParam(required = false)String email){
        return Response.newSuccess(bokeService.updateStudentByid(id,name,email));
    }


}
