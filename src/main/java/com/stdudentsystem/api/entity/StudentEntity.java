package com.stdudentsystem.api.entity;


import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;

}
