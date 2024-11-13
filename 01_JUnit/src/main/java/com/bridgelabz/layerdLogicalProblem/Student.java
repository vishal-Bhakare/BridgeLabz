package com.bridgelabz.layerdLogicalProblem;

public class Student {

    private int studentId;
    private String studentName;
    private String coureseName;
    private double cgpa;


    public Student() {

    }

    public Student(int studentId, String studentName, String coureseName, double cgpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.coureseName = coureseName;
        this.cgpa = cgpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCoureseName() {
        return coureseName;
    }

    public void setCoureseName(String coureseName) {
        this.coureseName = coureseName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {

        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", coureseName='" + coureseName + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
