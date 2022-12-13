package com.stdudentsystem.api.controller;

import com.stdudentsystem.api.model.Student;
import com.stdudentsystem.api.services.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return  studentService.getAllStudent();
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable Long id){
        boolean deleted = false;
        deleted = studentService.deleteStudent(id);
        Map<String,Boolean> responseMap = new HashMap<>();
        responseMap.put("deleted",deleted);
        return ResponseEntity.ok(responseMap);


    }
@GetMapping("/students/{id}")
public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = null;
        student = studentService.getStudentById(id);
      System.out.println(student);
        return  ResponseEntity.ok(student);

    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        student = studentService.updateStudent(id,student);
        return ResponseEntity.ok(student);
    }



}
