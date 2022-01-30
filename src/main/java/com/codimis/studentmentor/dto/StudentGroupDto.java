package com.codimis.studentmentor.dto;

import javax.validation.constraints.NotNull;

public class StudentGroupDto {
    @NotNull(message = "name can not be null")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
