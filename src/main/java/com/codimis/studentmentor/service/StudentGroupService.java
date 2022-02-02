package com.codimis.studentmentor.service;

import com.codimis.studentmentor.entity.StudentGroup;

import java.util.Optional;

public interface StudentGroupService {
    StudentGroup saveStudentGroup(StudentGroup studentGroup);
    Optional<StudentGroup> getStudentGroupById(int id);
}
