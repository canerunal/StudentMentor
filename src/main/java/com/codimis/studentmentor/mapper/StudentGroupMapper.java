package com.codimis.studentmentor.mapper;

import com.codimis.studentmentor.dto.StudentGroupDto;
import com.codimis.studentmentor.entity.StudentGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StudentGroupMapper {

    StudentGroupMapper INSTANCE = Mappers.getMapper( StudentGroupMapper.class );

    StudentGroupDto studentGroupToStudentGroupDto(StudentGroup studentGroup);
    StudentGroup dtoToStudentGroup(StudentGroupDto studentGroupDto);
}
