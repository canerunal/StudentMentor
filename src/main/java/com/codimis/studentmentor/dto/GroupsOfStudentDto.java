package com.codimis.studentmentor.dto;

import com.codimis.studentmentor.entity.StudentGroup;

import java.util.Set;

public class GroupsOfStudentDto {
    private int id;
    private Set<StudentGroup> groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<StudentGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<StudentGroup> groups) {
        this.groups = groups;
    }
}
