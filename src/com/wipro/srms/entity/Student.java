package com.wipro.srms.entity;

public class Student {

    private String studentId;
    private String name;
    private String program;
    private int currentSemester;

    public Student(String studentId, String name, String program, int currentSemester) {
        this.studentId = studentId;
        this.name = name;
        this.program = program;
        this.currentSemester = currentSemester;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }
}