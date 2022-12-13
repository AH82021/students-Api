package com.stdudentsystem.api.services;

import com.stdudentsystem.api.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student updateStudent(Long id,Student student);

    boolean deleteStudent(Long id);

    Student getStudentById(Long id);
}
