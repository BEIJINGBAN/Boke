package com.example.boke.Student.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy =  IDENTITY)
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name="email")
    private String email;



    @Column(name="ape")
    private int ape;

}
