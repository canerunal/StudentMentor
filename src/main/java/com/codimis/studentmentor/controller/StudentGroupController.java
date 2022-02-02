package com.codimis.studentmentor.controller;

import com.codimis.studentmentor.dto.StudentGroupDto;
import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.entity.StudentGroup;
import com.codimis.studentmentor.exception.DataNotExistsException;
import com.codimis.studentmentor.mapper.StudentGroupMapper;
import com.codimis.studentmentor.service.StudentGroupService;
import com.codimis.studentmentor.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
    public ResponseEntity<StudentGroup> createStudentGroup(@Valid @RequestBody StudentGroupDto studentGroupDto){
        StudentGroup studentGroup = StudentGroupMapper.INSTANCE.dtoToStudentGroup(studentGroupDto);
        StudentGroup createdStudentGroup = studentGroupService.saveStudentGroup(studentGroup);
        return new ResponseEntity<>(createdStudentGroup, HttpStatus.CREATED);
    }
    @GetMapping("/studentgroup/{id}")
    public StudentGroup getStudentGroup(@PathVariable(name = "id") int id) throws Exception{
        Optional<StudentGroup> studentGroup =  studentGroupService.getStudentGroupById(id);
        if(!studentGroup.isPresent())
            throw new DataNotExistsException("StudentGroup not exists");
        return studentGroup.get();
    }
    @PutMapping("/studentgroup/{id}/student/{student_id}")
    public ResponseEntity<StudentGroup> addStudentToGroup(@PathVariable(name="id") int id, @PathVariable(name="student_id") int studentID) throws Exception{
        Optional<StudentGroup> studentGroup = studentGroupService.getStudentGroupById(id);
        Optional<Student> student = studentService.getStudentById(studentID);
        if(!studentGroup.isPresent())
            throw new DataNotExistsException("StudentGroup not exists");
        if(!student.isPresent())
            throw new DataNotExistsException("Student not exists");
        student.get().getGroups().add(studentGroup.get());
        studentService.saveStudent(student.get());
        return new ResponseEntity<>(studentGroup.get(), HttpStatus.OK);
    }
}
