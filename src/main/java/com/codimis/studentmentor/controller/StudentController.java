package com.codimis.studentmentor.controller;

import com.codimis.studentmentor.dto.StudentDto;
import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.entity.StudentGroup;
import com.codimis.studentmentor.mapper.StudentGroupMapper;
import com.codimis.studentmentor.mapper.StudentMapper;
import com.codimis.studentmentor.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable(name="id") int id){
        return studentService.getStudentById(id);
    }
    @PostMapping("/student")
    public Student createStudent(@Valid @RequestBody StudentDto studentDto){
        Student student = StudentMapper.INSTANCE.dtoToStudent(studentDto);
        return studentService.addStudent(student);
    }
}
