package com.studentapp;

import java.util.*;

import static java.lang.System.exit;

public class Main4 {

    private static List<Student> studentList;
    private static Scanner scanner;
    public static void main(String[] args) {


        System.out.println("***********************Student Management System *************");

        studentList = new ArrayList<Student>();
        scanner = new Scanner(System.in);
        while (true) {
        System.out.println("********** Welcome *********************");
        System.out.println("Select an Option......");
        System.out.println("1. Register a student...");
        System.out.println("2. Find student with studentId...");
        System.out.println("3. List all student information...");
        System.out.println("4. List student information in sorted order...");
        System.out.println("5. Exit...");
        int option = scanner.nextInt();

            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option selected!!.....Please select valid option between 1 to 5.....");

            }
        }
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.println("Enter Student name....");
        String studentName = scanner.next();

        System.out.println("Enter Student age....");
        int studentAge = scanner.nextInt();

        System.out.println("Enter Student Id....");
        String studentId = scanner.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);
        while(true) {
            System.out.println("Enter the course to be enrolled!!...Type Done to Exit");
            String courseName = scanner.next();
            if(courseName.equalsIgnoreCase("Done")){
                break; //exit from the loop we will use break keyword
            }
            newStudent.enrollCourse(courseName);
        }

        newStudent.printStudentInfo();


    }


    private static void sortByName() {
        Comparator<Student> studentNameComparator = (o1,o2) ->o1.getName().compareTo(o2.getName());

        Collections.sort(studentList,studentNameComparator);
        printAllStudentData();
    }

    private static void findStudentById(Scanner scanner) {
        Student studentFound = null;  //explicit initialization
        System.out.println("Enter Student Id....");
        String studentId = scanner.next();

        try{
            studentFound = studentList
                    .stream()
                    .filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() ->new RuntimeException("No Data found!!!!"));
        }
        catch(RuntimeException e){
            System.err.println("Student with ID "+studentId+ " not found!!!");
        }
        studentFound.printStudentInfo();
    }

    private static void exit() {
        System.out.println("good bye!!!!");
        System.exit(0);
    }

    private static void printAllStudentData() {
        if(studentList.size()>0) {

            System.out.println("*****************Print all student Data***********************");
            for (Student student : studentList) {
                student.printStudentInfo();

            }
            System.out.println("****************************************");
        }else{
            System.err.println("Student list is empty!!!.............No Student Record found");
        }
    }



    
    }


    



