package com.StudentTracer.StudentTracer;



public class StudentModel {
    private String name;
    private int marks;

    public StudentModel() {} // Needed for JSON serialization

    public StudentModel(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
}

