package com.example.boke.Student.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {
    private long id;

    private String name;

    private String email;

    private String ape;
}
