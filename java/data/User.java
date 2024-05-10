package data;

import java.util.ArrayList;
import java.util.List;

import books.Book;


public abstract class User {

    private String nim;

    public User(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void addStudent(){

    }
    public void choiceBook(Book[] bookList){

    }

    public abstract void displayBooks(Book[] bookList);
}

