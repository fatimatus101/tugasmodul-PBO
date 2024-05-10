package books;

public class TextBook extends Book {
    private String category = "Text";
    public TextBook(String id, String title, String author, int stock) {
        super(id, title, author, stock);
    }
    public String getCategory() {
        return this.category;
    }
}

