package com.practice.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
public class Subjects {
    @Id
    @GeneratedValue
    @Column(name = "Id_sub")
    private int id;

    @Column(name = "name_sub")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    public Subjects() {

    }

    public Subjects(String name) {
        this.name = name;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append("Subjects{")
                .append("id=" + id)
                .append(", name=" + name)
                .append(", teacher=" + teacher)
                .append('}');
        if (teacher != null){
            builder.append(", teacher = " + teacher.getName());
        }

        builder.append('}');
        return builder.toString();
    }
}
