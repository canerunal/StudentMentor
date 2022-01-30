package com.codimis.studentmentor.controller;

import com.codimis.studentmentor.dto.StudentGroupDto;
import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.entity.StudentGroup;
import com.codimis.studentmentor.mapper.StudentGroupMapper;
import com.codimis.studentmentor.service.StudentGroupService;
import com.codimis.studentmentor.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentGroupController {

    StudentGroupService studentGroupService;
    StudentService studentService;

    public StudentGroupController(StudentGroupService studentGroupService, StudentService studentService) {
        System.out.println("StudentGroupControllre constructor called");
        this.studentGroupService = studentGroupService;
        this.studentService = studentService;
    }

    @PostMapping("/studentgroup")
    public ResponseEntity<StudentGroup> createStudentGroup(@RequestBody StudentGroupDto studentGroupDto){
        StudentGroup studentGroup = StudentGroupMapper.INSTANCE.dtoToStudentGroup(studentGroupDto);
        StudentGroup createdStudentGroup = studentGroupService.saveStudentGroup(studentGroup);
        return new ResponseEntity<>(createdStudentGroup, HttpStatus.CREATED);
    }
    @GetMapping("/studentgroup/{id}")
    public StudentGroup getStudentGroup(@PathVariable(name = "id") int id){
        return studentGroupService.getStudentGroupById(id);
    }
    @PutMapping("/studentgroup/{id}/student/{student_id}")
    public ResponseEntity<StudentGroup> addStudentToGroup(@PathVariable(name="id") int id, @PathVariable(name="student_id") int studentID){
        StudentGroup studentGroup = studentGroupService.getStudentGroupById(id);
        Student student = studentService.getStudentById(studentID);
        student.getGroups().add(studentGroup);
        studentService.saveStudent(student);
        return new ResponseEntity<>(studentGroup, HttpStatus.OK);
    }
}
