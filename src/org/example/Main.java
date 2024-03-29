package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentUser = "";
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter your NIM: ");
                String nim = scanner.next();
                if (nim.equals("202310370311271")) {
                    currentUser = "Student";
                    System.out.println("Successful Login as Student");
                } else {
                    System.out.println("User Not Found");
                }
            } else if (choice == 2) {
                if (currentUser.equals("Admin")) {
                    System.out.println("You are already logged in as Admin");
                } else {
                    System.out.print("Enter your username (admin): ");
                    String username = scanner.next();
                    System.out.print("Enter your password (admin): ");
                    String password = scanner.next();
                    if (username.equals("admin") && password.equals("admin")) {
                        currentUser = "Admin";
                        System.out.println("Successful Login as Admin");
                    } else {
                        System.out.println("Admin User Not Found!!");
                    }
                }
            } else if (choice == 3) {
                isRunning = false;
                System.out.println("adios");
            } else {
                System.out.println("Invalid option, please choose again");
            }

        }
        scanner.close();
    }
}