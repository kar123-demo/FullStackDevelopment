package com.example.Student;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    Student s = new Student();

                    System.out.print("Enter Student ID: ");
                    s.setstudentId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    s.setstudentName(sc.nextLine());

                    System.out.print("Enter Email: ");
                    s.setemail(sc.nextLine());

                    System.out.print("Enter Course: ");
                    s.setcourse(sc.nextLine());

                    System.out.print("Enter Age: ");
                    s.setage(sc.nextInt());

                    dao.save(s);

                    System.out.println("Student Saved Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    Student student = dao.getStudent(id);

                    if (student != null) {
                        System.out.println("\nStudent Details");
                        System.out.println("ID      : " + student.getId());
                        System.out.println("Name    : " + student.getName());
                        System.out.println("Email   : " + student.getemail());
                        System.out.println("Course  : " + student.getcourse());
                        System.out.println("Age     : " + student.getage());
                    } else {
                        System.out.println("Student Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();

                    Student updateStudent = dao.getStudent(updateId);

                    if (updateStudent != null) {

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        updateStudent.setstudentName(sc.nextLine());

                        System.out.print("Enter New Email: ");
                        updateStudent.setemail(sc.nextLine());

                        System.out.print("Enter New Course: ");
                        updateStudent.setcourse(sc.nextLine());

                        System.out.print("Enter New Age: ");
                        updateStudent.setage(sc.nextInt());

                        dao.updateStudent(updateStudent);

                        System.out.println("Student Updated Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);

                    System.out.println("Student Deleted Successfully!");
                    break;

                case 5:

                    HibernateUtil.getSessionFactory().close();
                    sc.close();

                    System.out.println("Application Closed.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}