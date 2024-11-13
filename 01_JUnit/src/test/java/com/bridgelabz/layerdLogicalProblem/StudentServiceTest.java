/*
package com.bridgelabz.layerdLogicalProblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class StudentServiceTest {

    List<Student> stuList = new ArrayList<>();
    StudentService stu = new StudentService();

    @DisplayName("Test check for adding/inserting/filtering by coursewise or gpawise/removing students ")
    @Test
    public void testCheckForAdditionAndDeletion() {

        assertEquals(true, stu.getStudent(stuList) == 0);

        Student st = new Student(1, "Vishal", "Java", 8.56);
        stu.appendStudent(st, stuList);
        assertEquals(true, stu.getStudent(stuList) == 1);


        // After inserting the data
        stu.insertStudent(*/
/**//*
st1, stuList, 0);
        assertEquals(true, stu.getStudentName(stuList, 0).equalsIgnoreCase("Saurabh"));
        assertEquals(true, stu.getStudent(stuList) == 2);

        Student phoebe = new Student(3, "Akshay", "Python", 8.5);
        stu.appendStudent(phoebe, stuList);
        assertEquals(true, stu.getStudent(stuList) == 3);
        assertEquals(true, stu.getStudentName(stuList, 1).equalsIgnoreCase("Vishal"));
        assertEquals(true, stu.getStudent(stuList) == stuList.size());

        // checking according to coursewise, first check for java
        List<Student> javacourseList = new ArrayList<Student>();
        javacourseList = stu.getStudentCourseWise(stuList, "Java");

        // As for java, only 2 students are entered and checking like below
        assertEquals(true, stu.getStudent(javacourseList) == 2);
        assertEquals(true, stu.getStudentName(stuList, 1).equalsIgnoreCase("Vishal"));

        // As for python, only 1 student is entered and checking like below

        List<Student> pythoncourseList = new ArrayList<Student>();
        pythoncourseList = stu.getStudentCourseWise(stuList, "Python");
        assertEquals(true, stu.getStudent(pythoncourseList) == 1);
        assertEquals(true, stu.getStudentName(stuList, 2).equalsIgnoreCase("Akshay"));

        //check other course
        List<Student> otherList = new ArrayList<Student>();
        otherList = stu.getStudentCourseWise(stuList, "unkown");

        // As for php, no students are there, we need to check like below
        assertEquals(true, stu.getStudent(otherList) == 0);

        // Now with cgpa check
        List<Student> gpaWiseStudent = new ArrayList<>();
        gpaWiseStudent = stu.getStudentsByGPA(stuList,8.56);
        assertEquals(true,stu.getStudent(gpaWiseStudent) == 1);
        assertEquals(true, stu.getStudentName(stuList, 1).equalsIgnoreCase("Vishal"));

        // let us remove the students
        stu.deleteStudent(stuList,0);

        // As 0th index student got removed, only 2 students remain
        assertEquals(true, stu.getStudent(stuList)==2);
    }

}
*/
