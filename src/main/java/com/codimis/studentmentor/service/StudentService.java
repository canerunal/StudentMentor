package com.codimis.studentmentor.service;

import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.entity.StudentGroup;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    Optional<Student> getStudentById(int id);
    List<Student> getAllStudents();
}
