package com.stdudentsystem.api.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.stdudentsystem.api.entity.StudentEntity;
import com.stdudentsystem.api.model.Student;
import com.stdudentsystem.api.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        StudentEntity studentEntity= new StudentEntity();
        BeanUtils.copyProperties(student,studentEntity);
         studentRepository.save(studentEntity);
         return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<Student>   students =studentEntities
                .stream()
                .map(emp->new Student(emp.getId()
                        ,emp.getName(),
                        emp.getLastName()
                        , emp.getEmail()))
                .collect(Collectors.toList());
        return  students;
    }

    @Override
    public Student updateStudent(Long id,Student student) {
        StudentEntity studentEntity= studentRepository.findById(id).get();
        studentEntity.setEmail(student.getEmail());
        studentEntity.setName(student.getName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setId(student.getId());
        studentRepository.save(studentEntity);


        return student ;
    }

    @Override
    public boolean deleteStudent(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        studentRepository.delete(studentEntity);
        return true;
    }

    @Override
    public Student getStudentById(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        Student student = new Student();
        BeanUtils.copyProperties(studentEntity,student);
        return student;
    }
}
