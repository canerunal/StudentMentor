package com.codimis.studentmentor.dto;

import javax.validation.constraints.NotNull;

public class StudentDto {
    @NotNull(message = "name can not be null")
    private String name;
    @NotNull(message = "surname can not be null")
    private String surname;
    @NotNull(message = "universityName can not be null")
    private String universityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
