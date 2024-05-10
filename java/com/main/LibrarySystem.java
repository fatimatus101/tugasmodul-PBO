package com.main;

import books.*;
import data.Admin;
import data.Student;
import data.User;
import books.Book;

import java.util.ArrayList;
import java.util.Scanner;

import static sun.security.util.KnownOIDs.Data;

public class LibrarySystem {

    // menyimpan semua object dalam satu array dengan teknik polymorphism
    public static Book daftarBuku[] = new Book[100]; // array satu dimensi untuk menyimpan buku
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBuku[i++] = new StoryBook("SB32F", "Demon Emperor", "alex", 5);
        daftarBuku[i++] = new HistoryBook("HB324", "Superhuman Battlefield", "jay", 9);
        daftarBuku[i++] = new TextBook("TB323", "Hero Academy", "sera", 10);

//         Mengisi daftar mahasiswa
        studentList.add(0, new Student("202310370311345", "Ali", "Teknik","Mesin"));
        studentList.add(1, new Student("202310370311025", "Riska", "Bisnis","Managemen"));
        studentList.add(2, new Student("202310370311455", "Luluk", "Teknik","Industri"));

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih antara (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM : ");
                    String nimStudent = scanner.next();
                    scanner.nextLine();
                    while(true){
                        if (nimStudent.length() != 15 ) {
                            System.out.print("Nim Harus 15 Digit!!!\n");
                            System.out.print("Masukkan NIM : ");
                            nimStudent = scanner.nextLine();

                        } else if (checkNim(nimStudent)){
                            Student student = new Student(nimStudent);
                            student.login();
                            break;
                        } else {
                            System.out.println("Nim tidak terdaftar!");
                            break;
                        }
                    }
                    break;
                case 2:
                    Admin admin = new Admin();
                    admin.login();
                    break;
                case 3:
                    System.out.println("Terima kasih semoga puas dengan pelayanan kami");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}