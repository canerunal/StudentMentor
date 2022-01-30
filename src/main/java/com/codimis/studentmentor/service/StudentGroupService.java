package com.codimis.studentmentor.service;

import com.codimis.studentmentor.entity.StudentGroup;

import java.util.List;

public interface StudentGroupService {
    StudentGroup saveStudentGroup(StudentGroup studentGroup);
    StudentGroup getStudentGroupById(int id);
}
