package com.example.Product1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

    private static final SessionFactory factory =
            HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== PRODUCT MANAGEMENT =====");
            System.out.println("1. Create Product");
            System.out.println("2. Read Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createProduct(sc);
                    break;

                case 2:
                    readProduct(sc);
                    break;

                case 3:
                    updateProduct(sc);
                    break;

                case 4:
                    deleteProduct(sc);
                    break;

                case 5:
                    factory.close();
                    sc.close();
                    System.out.println("Application Closed.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void createProduct(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product p = new Product();

        System.out.print("Enter Product ID: ");
        p.setId(sc.nextInt());

        sc.nextLine();

        System.out.print("Enter Product Name: ");
        p.setName(sc.nextLine());

        System.out.print("Enter Product Price: ");
        p.setPrice(sc.nextDouble());

        session.persist(p);

        tx.commit();
        session.close();

        System.out.println("Product Added Successfully!");
    }

    public static void readProduct(Scanner sc) {

        Session session = factory.openSession();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);

        if (p != null) {
            System.out.println("\nProduct Found");
            System.out.println("ID    : " + p.getId());
            System.out.println("Name  : " + p.getName());
            System.out.println("Price : " + p.getPrice());
        } else {
            System.out.println("Product Not Found!");
        }

        session.close();
    }

    public static void updateProduct(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Product ID to Update: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);

        if (p != null) {

            sc.nextLine();

            System.out.print("Enter New Product Name: ");
            p.setName(sc.nextLine());

            System.out.print("Enter New Product Price: ");
            p.setPrice(sc.nextDouble());

            session.merge(p);

            System.out.println("Product Updated Successfully!");
        } else {
            System.out.println("Product Not Found!");
        }

        tx.commit();
        session.close();
    }

    public static void deleteProduct(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Product ID to Delete: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);

        if (p != null) {
            session.remove(p);
            System.out.println("Product Deleted Successfully!");
        } else {
            System.out.println("Product Not Found!");
        }

        tx.commit();
        session.close();
    }
}