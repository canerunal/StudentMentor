package com.codimis.studentmentor.service;

import com.codimis.studentmentor.entity.Student;

public interface StudentService {
    Student addStudent(Student student);
    Student getStudentById(int id);
}
