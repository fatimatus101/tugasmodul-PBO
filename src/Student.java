import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    String faculty;
    String nim;
    String program;
    List<Book> borrowedBooks;

    public Student(String name,String faculty,String nim,String program) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.program = program;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.stock--;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.stock++;
    }

    public void displayBooks() {
        for (Book book : borrowedBooks) {
            System.out.println("Title: " + book.title + ", Author: " + book.author);
        }
    }

    public void logout() {
        // Log out functionality for future implementation
    }
}

