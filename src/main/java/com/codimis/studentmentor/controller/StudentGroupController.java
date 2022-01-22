package com.codimis.studentmentor.controller;

import com.codimis.studentmentor.dto.StudentGroupDto;
import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.entity.StudentGroup;
import com.codimis.studentmentor.mapper.StudentGroupMapper;
import com.codimis.studentmentor.service.StudentGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentGroupController {

    StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        System.out.println("StudentGroupControllre constructor called");
        this.studentGroupService = studentGroupService;
    }

    @PostMapping("/studentgroup")
    public ResponseEntity<StudentGroup> createStudentGroup(@RequestBody StudentGroupDto studentGroupDto){
        StudentGroup studentGroup = StudentGroupMapper.INSTANCE.dtoToStudentGroup(studentGroupDto);
        StudentGroup createdStudentGroup = studentGroupService.addStudentGroup(studentGroup);
        return new ResponseEntity<>(createdStudentGroup, HttpStatus.CREATED);
    }
    @GetMapping("/studentgroup")
    public StudentGroup getStudentGroup(@RequestParam(name = "id") int id){
        return studentGroupService.getStudentGroupById(id);
    }
}
