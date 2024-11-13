package com.bridgelabz.layerdLogicalProblem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class StudentService {

    //geekOfGeeks

    // Appending i.e. adding students at the end of the
    // list and returning the studentlist size
    public int appendStudent(Student stu, List<Student> stuList) {
        stuList.add(stu);
        return stuList.size();
    }

    // Inserting i.e. inserting students at the middle
    // of the list and returning the studentlist size
    public int insertStudent(Student stu, List<Student> stuList, int index) {
        stuList.add(index, stu);
        return stuList.size();
    }

    // Removing students from the list and
    // returning the studentlist size
    public int deleteStudent(List<Student> stuList, int index) {
        stuList.remove(index);
        return stuList.size();
    }

    public int getStudent(List<Student> stuList) {

       //System.out.println("GetStudents : "+stuList.size() );


        return stuList.size();
    }

    // Retrieving the student name at the specified index
    public String getStudentName(List<Student> stuList, int index) {
        return stuList.get(index).getStudentName();
    }

    // Returning the student list who matches for a specific course
    public List<Student> getStudentCourseWise(List<Student> stuList, String courseName) {

        List<Student> list = new ArrayList<Student>();

        for (int i = 0; i < stuList.size(); i++) {

            if (stuList.get(i).getCoureseName().equalsIgnoreCase(courseName)) {
                list.add(stuList.get(i));
            }
        }
        return list;
    }

    // Returning the student list who matches for a specific gpa and more
    public List<Student> getStudentsByGPA(List<Student> stuList, double cgpa) {
        List<Student> list = new ArrayList<Student>();

        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getCgpa() >= cgpa) {
                list.add(stuList.get(i));
            }
        }
        return list;
    }
}
