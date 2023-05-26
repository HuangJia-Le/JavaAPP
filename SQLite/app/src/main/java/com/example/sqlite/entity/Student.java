package com.example.sqlite.entity;

public class Student {

    private Integer id;
    private String studentno;
    private String name;

    public Student(Integer id, String studentno, String name) {
        this.id = id;
        this.studentno = studentno;
        this.name = name;
    }

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
