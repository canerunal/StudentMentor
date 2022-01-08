package com.codimis.studentmentor.repository;

import com.codimis.studentmentor.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Integer> {
}
