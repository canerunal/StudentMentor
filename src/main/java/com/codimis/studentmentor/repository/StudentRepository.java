package com.codimis.studentmentor.repository;

import com.codimis.studentmentor.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
