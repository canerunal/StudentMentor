package com.codimis.studentmentor.controller;

import com.codimis.studentmentor.dto.StudentGroupDto;
import com.codimis.studentmentor.entity.StudentGroup;
import com.codimis.studentmentor.mapper.StudentGroupMapper;
import com.codimis.studentmentor.service.StudentGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentGroupController {

    @Autowired
    StudentGroupServiceImpl studentGroupService;

    @PostMapping("/studentgroup")
    public ResponseEntity<StudentGroup> createStudentGroup(@RequestBody StudentGroupDto studentGroupDto){
        StudentGroup studentGroup = StudentGroupMapper.INSTANCE.dtoToStudentGroup(studentGroupDto);
        StudentGroup createdStudentGroup = studentGroupService.addStudentGroup(studentGroup);
        return new ResponseEntity<>(createdStudentGroup, HttpStatus.CREATED);
    }
}
