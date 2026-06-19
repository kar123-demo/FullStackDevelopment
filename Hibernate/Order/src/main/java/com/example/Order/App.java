package com.example.Order;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

       

     ;

        OrderDAO dao = new OrderDAO();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ORDER MANAGEMENT =====");
            System.out.println("1. Create Order");
            System.out.println("2. Read Order");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                Order order = new Order();

                System.out.print("Order ID: ");
                order.setOrderId(sc.nextInt());
                sc.nextLine();

                System.out.print("Customer Name: ");
                order.setCustomerName(sc.nextLine());

                System.out.print("Product Name: ");
                order.setProductName(sc.nextLine());

                System.out.print("Quantity: ");
                order.setQuantity(sc.nextInt());

                System.out.print("Total Amount: ");
                order.setTotalAmount(sc.nextDouble());

                dao.save(order);
                System.out.println("Order Saved Successfully");
                break;

            case 2:
                System.out.print("Enter Order ID: ");
                int readId = sc.nextInt();

                Order found = dao.getById(readId);

                if (found != null)
                    System.out.println(found);
                else
                    System.out.println("Order Not Found");

                break;

            case 3:
                System.out.print("Enter Order ID to Update: ");
                int updateId = sc.nextInt();

                Order updateOrder = dao.getById(updateId);

                if (updateOrder != null) {

                    sc.nextLine();

                    System.out.print("New Customer Name: ");
                    updateOrder.setCustomerName(sc.nextLine());

                    System.out.print("New Product Name: ");
                    updateOrder.setProductName(sc.nextLine());
                    sc.nextLine();
                    System.out.print("New Quantity: ");
                    updateOrder.setQuantity(sc.nextInt());

                    System.out.print("New Total Amount: ");
                    updateOrder.setTotalAmount(sc.nextDouble());

                    dao.update(updateOrder);

                    System.out.println("Order Updated Successfully");
                } else {
                    System.out.println("Order Not Found");
                }

                break;

            case 4:
                System.out.print("Enter Order ID to Delete: ");
                int deleteId = sc.nextInt();

                dao.delete(deleteId);

                System.out.println("Order Deleted Successfully");
                break;

            case 5:
              HibernateUtil.getSessionFactory().close();
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice");
            }
        }
    }
}