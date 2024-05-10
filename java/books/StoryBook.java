package books;

public class StoryBook extends Book {
    private String category = "Story";

    public StoryBook(String id, String title, String author, int stock) {
        super(id, title, author, stock);
    }

    public String getCategory() {
        return this.category;
    }
}

