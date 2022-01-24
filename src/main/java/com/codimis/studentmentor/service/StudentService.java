package com.codimis.studentmentor.service;

import com.codimis.studentmentor.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}
