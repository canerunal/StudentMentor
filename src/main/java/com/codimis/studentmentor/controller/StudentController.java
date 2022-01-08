package com.codimis.studentmentor.controller;

import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/student/{id}")
    public Student getStudent(@RequestParam(name = "id") int id){
        return studentService.getStudentById(id);
    }
    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
}
