package com.studentapp;

import java.util.*;

public class Main3 {

    private static List<Student> studentList;
    public static void main(String[] args) {


        System.out.println("***********************Student Management System *************");
        System.out.println("********** Welcome *********************");
        studentList = new ArrayList<Student>();

        //Read input from terminal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student name....");
        String name = scanner.next(); //if you want to read input in string format you will use next()
        System.out.println("You have entered the name: "+name);


        //To read integer values from console/terminal
        System.out.println("Enter Student age....");
        int age = scanner.nextInt();
        System.out.println("You have entered the age: "+age);





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
