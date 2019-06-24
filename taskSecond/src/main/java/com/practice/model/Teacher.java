package com.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "id_teacher")
    private  int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "degree")
    private Degree degree;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "teacher")
    private Set<Subjects> subjects = new HashSet<>();

    public Teacher() {
    }

    public Teacher(String name, String lastName, Degree degree) {
        this.name = name;
        this.lastName = lastName;
        this.degree = degree;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }

    public void addSubjects(Subjects subject) {
        this.subjects.add(subject);
        subject.setTeacher(this);
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", degree=" + degree +
                ", subjects=" + subjects +
                '}';
    }
}
