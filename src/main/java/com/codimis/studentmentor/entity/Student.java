package com.codimis.studentmentor.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String university_name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_date;
    @ManyToMany
    @JoinTable(
            name = "student_group_members",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "student_group_id"))
    private Set<StudentGroup> studentGroupSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Set<StudentGroup> getStudentGroupSet() {
        return studentGroupSet;
    }

    public void setStudentGroupSet(Set<StudentGroup> studentGroupSet) {
        this.studentGroupSet = studentGroupSet;
    }
}
