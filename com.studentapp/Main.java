package com.studentapp;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("***********************Student Management System *************");
        System.out.println("********** Welcome *********************");

        Student s1 = new Student("Ram Kapoor",22,"S-432");
        s1.enrollCourse("Java");
        s1.enrollCourse("DevOps");
        s1.enrollCourse("DSA");
        s1.enrollCourse("C#");
        //System.out.println(s1);
        s1.printStudentInfo();

        Student s2 = new Student("Udyaraje",25,"S-421");
        s2.enrollCourse("Java");
        s2.enrollCourse("DevOps");
        //System.out.println(s2);
        s2.printStudentInfo();

        Student s3 = new Student("Ritu",28,"S-824");
        s3.enrollCourse("Java");
        //System.out.println(s3);
        s3.printStudentInfo();

        //new Student("Ram",22,"S1");
        /*
        1) Class will be loaded in the Heap memory
        2) Instance variables will be created
        3) Constructor is getting invoked
         */

    }

}
