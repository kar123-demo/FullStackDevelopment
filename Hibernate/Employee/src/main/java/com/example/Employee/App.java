package com.example.Employee;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    Employee e = new Employee();

                    System.out.print("Enter Employee ID: ");
                    e.setid(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    e.setname(sc.nextLine());

                    System.out.print("Enter Department: ");
                    e.setdept(sc.nextLine());

                    System.out.print("Enter Salary: ");
                    e.setsalary(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter Joining Date: ");
                    e.setdate(sc.nextLine());

                    dao.save(e);

                    System.out.println("Employee Saved Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    Employee emp = dao.read(id);

                    if (emp != null) {

                        System.out.println("\nEmployee Details");
                        System.out.println("ID      : " + emp.getId());
                        System.out.println("Name    : " + emp.getname());
                        System.out.println("Dept    : " + emp.getdept());
                        System.out.println("Salary  : " + emp.getsalary());
                        System.out.println("Date    : " + emp.getdate());

                    } else {
                        System.out.println("Employee Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();

                    Employee updateEmp = dao.read(updateId);

                    if (updateEmp != null) {

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        updateEmp.setname(sc.nextLine());

                        System.out.print("Enter New Department: ");
                        updateEmp.setdept(sc.nextLine());

                        System.out.print("Enter New Salary: ");
                        updateEmp.setsalary(sc.nextDouble());
                        sc.nextLine();

                        System.out.print("Enter New Joining Date: ");
                        updateEmp.setdate(sc.nextLine());

                        dao.update(updateEmp);

                        System.out.println("Employee Updated Successfully!");

                    } else {
                        System.out.println("Employee Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    dao.delete(deleteId);

                    System.out.println("Employee Deleted Successfully!");
                    break;

                case 5:

                    HibernateUtil.getSession().close();
                    sc.close();

                    System.out.println("Application Closed.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}