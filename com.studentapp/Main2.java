package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

    private static List<Student> studentList;
    public static void main(String[] args) {


        System.out.println("***********************Student Management System *************");
        System.out.println("********** Welcome *********************");
        studentList = new ArrayList<Student>();

        Student s1 = new Student("Ram Kapoor",22,"S-432");
        s1.enrollCourse("Java");
        s1.enrollCourse("DevOps");
        s1.enrollCourse("DSA");



        Student s2 = new Student("Udyaraje",25,"S-421");
        s2.enrollCourse("Java");
        s2.enrollCourse("DevOps");


        Student s3 = new Student("Ritu",28,"S-824");
        s3.enrollCourse("Java");


        Student s4 = new Student("Ajit",18,"S-674");
        s4.enrollCourse("DSA");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);


        Student result = findStudentById("S-432");
        System.out.println("Result "+result);
        sortByName();



        }

    private static void sortByName() {

        Comparator<Student> studentNameComparator = (o1,o2) ->o1.getName().compareTo(o2.getName());

        Collections.sort(studentList,studentNameComparator);
        System.out.println(studentList);

    }

    public static Student findStudentById(String studentId){
        Student result = null;  //explicit initialization

        try{
            result = studentList
                    .stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() ->new RuntimeException("No Data found!!!!"));
        }
        catch(RuntimeException e){
            System.err.println("Student with ID "+studentId+ " not found!!!");
        }
        return result;
    }

}
