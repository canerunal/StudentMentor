package com.codimis.studentmentor.mapper;

import com.codimis.studentmentor.dto.GroupsOfStudentDto;
import com.codimis.studentmentor.dto.StudentDto;
import com.codimis.studentmentor.dto.StudentGroupDto;
import com.codimis.studentmentor.entity.Student;
import com.codimis.studentmentor.entity.StudentGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto studentToDto(Student student);
    Student dtoToStudent(StudentDto studentDto);
    GroupsOfStudentDto dtoToGroupsOfStudent(Student student);
}
