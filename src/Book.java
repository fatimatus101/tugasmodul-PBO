class Book {
    String id;
    String title;
    String author;
    String category;
    int stock;

    public Book(String id, String title, String author, String category, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }
    public String toString() {
        return "|| " + id + " || " + title + " || " + author + " || " + category + " || " + stock + " ||";
    }

}
