package com.example.sqlite.entity;

public class student_tb {

    private Integer id;
    private String studentno;
    private String name;


    @Override
    public String toString() {
        return "student{" +
                "id=" + getId() +
                ", studentno='" + getStudentno() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
