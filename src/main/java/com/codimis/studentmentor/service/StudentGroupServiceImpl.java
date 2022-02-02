package com.codimis.studentmentor.service;

import com.codimis.studentmentor.entity.StudentGroup;
import com.codimis.studentmentor.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentGroupServiceImpl implements StudentGroupService{

    StudentGroupRepository studentGroupRepository;

    @Autowired
    public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }
    @Override
    public StudentGroup saveStudentGroup(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }
    @Override
    public Optional<StudentGroup> getStudentGroupById(int id) {
        return studentGroupRepository.findById(id);
    }
}
