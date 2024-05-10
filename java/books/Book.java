package books;

public abstract class Book {
    private static Book[] books = new Book[100];
    private static int index = 0;
    private String id;
    private String title;
    private String author;
    private String category;
    private int stock;
    private int duration;

    public Book(String id, String title, String author, String category, int stock, int duration) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
        this.duration = duration;
        books[index++] = this;
    }

    public Book(String id, String title, String author, int stock) {
    }

    public Book() {

    }

    public String getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static Book[] getBooks() {
        return books;
    }

    public static int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Category: " + category + ", Stock: " + stock + ", Duration: " + duration;
    }

    public String display() {
        return toString();
    }
}
