package books;

public class HistoryBook extends Book {
    private String category = "History";


    public HistoryBook(String id, String title, int stock, String author) {
        super(id, title, author, stock);
    }

    public HistoryBook(String id, String title, String author, int stock) {
        super();
    }


    public String getCategory() {

        return this.category;
    }
}



