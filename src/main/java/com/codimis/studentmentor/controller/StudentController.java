package com.codimis.studentmentor.controller;

import com.codimis.studentmentor.dto.GroupsOfStudentDto;
import com.codimis.studentmentor.dto.StudentDto;
import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.entity.StudentGroup;
import com.codimis.studentmentor.mapper.StudentMapper;
import com.codimis.studentmentor.service.StudentGroupService;
import com.codimis.studentmentor.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;
    StudentGroupService studentGroupService;

    public StudentController(StudentService studentService, StudentGroupService studentGroupService){
        this.studentService = studentService;
        this.studentGroupService =  studentGroupService;
    }

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/student/{id}")
    public StudentDto getStudent(@PathVariable(name = "id") int id){
        Student student = studentService.getStudentById(id);
        return StudentMapper.INSTANCE.studentToDto(student);
    }
    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDto studentDto){
        Student studentFromDto = StudentMapper.INSTANCE.dtoToStudent(studentDto);
        Student savedStudent =  studentService.saveStudent(studentFromDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
}
