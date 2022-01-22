package com.codimis.studentmentor.service;

import com.codimis.studentmentor.entity.StudentGroup;

public interface StudentGroupService {
    StudentGroup addStudentGroup(StudentGroup studentGroup);
    StudentGroup getStudentGroupById(int id);
}
