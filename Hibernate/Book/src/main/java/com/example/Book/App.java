package com.example.Book;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {

            System.out.println("\n===== BOOK MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:
            	Book b=new Book();
                System.out.print("Book Id: ");
                int id = sc.nextInt();
                sc.nextLine();
                b.setBookId(id);
                System.out.print("Title: ");
                String title = sc.nextLine();
                b.setTitle(title);
                System.out.print("Author: ");
                String author = sc.nextLine();
                b.setAuthor(author);
                System.out.print("Category: ");
                String category = sc.nextLine();
                b.setCategory(category);
                System.out.print("Price: ");
                double price = sc.nextDouble();
                b.setPrice(price);
                System.out.print("Available Copies: ");
                int copies = sc.nextInt();

                b.setAvailableCopies(copies);

                dao.save(b);

                System.out.println("Book Saved Successfully");
                break;

            case 2:

                System.out.print("Enter Book Id: ");
                int readId = sc.nextInt();

                Book b1 = dao.read(readId);

                if (b1 != null)
                    System.out.println(b1);
                else
                    System.out.println("Book Not Found");

                break;

            case 3:

                System.out.print("Enter Book Id: ");
                int updateId = sc.nextInt();

                Book existing = dao.read(updateId);

                if (existing != null) {

                    sc.nextLine();

                    System.out.print("New Title: ");
                    existing.setTitle(sc.nextLine());

                    System.out.print("New Author: ");
                    existing.setAuthor(sc.nextLine());

                    System.out.print("New Category: ");
                    existing.setCategory(sc.nextLine());

                    System.out.print("New Price: ");
                    existing.setPrice(sc.nextDouble());

                    System.out.print("New Available Copies: ");
                    existing.setAvailableCopies(sc.nextInt());

                    dao.update(existing);

                    System.out.println("Book Updated");
                } else {
                    System.out.println("Book Not Found");
                }

                break;

            case 4:

                System.out.print("Enter Book Id: ");
                int deleteId = sc.nextInt();

                dao.delete(deleteId);

                System.out.println("Book Deleted");
                break;

            case 5:

                HibernateUtil.getSessionFactory().close();
                sc.close();

                System.out.println("Application Closed");
                System.exit(0);

            default:
                System.out.println("Invalid Choice");
            }
        }
    }
}