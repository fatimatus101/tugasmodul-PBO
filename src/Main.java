import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Book> bookList = new ArrayList<>();
    private static List<Student> userStudent = new ArrayList<>();
    private static Student currentStudent;
    private static Admin currentAdmin;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBooks(); // Inisialisasi daftar buku saat program dijalankan
        displayAvailableBooks(); // Menampilkan daftar buku yang tersedia

        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as admin");
            System.out.println("2. Login as student");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentAdmin = new Admin();
                    menuAdmin();
                    break;
                case 2:
                    currentStudent = getStudentByNim(inputNim());
                    if (currentStudent == null) {
                        System.out.println("Invalid NIM.");
                        break;
                    }
                    menuStudent();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void initializeBooks() {
        // Tambahkan buku-buku ke dalam daftar bookList saat program dijalankan
        bookList.add(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 5));
        bookList.add(new Book("2", "To Kill a Mockingbird", "Harper Lee", "Fiction", 3));
        bookList.add(new Book("3", "The Catcher in the Rye", "J.D. Salinger", "Fiction", 4));
    }

    private static void displayAvailableBooks() {
        // Menampilkan daftar buku yang tersedia saat program dijalankan
        System.out.println("Available Books:");
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    private static String inputNim() {
        System.out.print("Enter student NIM: ");
        return scanner.next();
    }

    private static String inputBookId() {
        System.out.print("Enter book ID: ");
        return scanner.next();
    }

    private static Student getStudentByNim(String nim) {
        for (Student student : userStudent) {
            if (student.nim.equals(nim)) {
                return student;
            }
        }
        return null;
    }

    private static void menuAdmin() {
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add student");
            System.out.println("2. Display students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String name = inputName();
                    String nim = inputNimForAddStudent();
                    String faculty = inputFaculty();
                    String program = inputProgram();
                    currentAdmin.addStudent(name, nim, faculty, program);
                    userStudent.add(new Student(name, faculty, nim, program));
                    break;
                case 2:
                    currentAdmin.displayStudents();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void menuStudent() {
        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Display borrowed books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book or Logout");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            Book book = null;

            switch (choice) {
                case 1:
                    currentStudent.displayBooks();
                    break;
                case 2:
                    book = getBookById(inputBookId());
                    if (book != null && book.stock > 0) {
                        currentStudent.borrowBook(book);
                    } else {
                        System.out.println("Failed to borrow book.");
                    }
                    break;
                case 3:
                    book = getBookById(inputBookId());
                    if (book != null && currentStudent.borrowedBooks.contains(book)) {
                        currentStudent.returnBook(book);
                    } else {
                        System.out.println("Failed to return book.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static String inputName() {
        System.out.print("Enter student name: ");
        return scanner.next();
    }

    private static String inputNimForAddStudent() {
        System.out.print("Enter student NIM (15 characters): ");
        return scanner.next();
    }

    private static String inputFaculty() {
        System.out.print("Enter student faculty: ");
        return scanner.next();
    }

    private static String inputProgram() {
        System.out.print("Enter student program: ");
        return scanner.next();
    }

    private static Book getBookById(String id) {
        for (Book book : bookList) {
            if (book.id.equals(id)) {
                return book;
            }
        }
        return null;
    }
}