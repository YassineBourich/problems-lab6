package problem3;

public class Book extends Document {
    protected String author;
    protected int nbrPages;

    // No-args constructor and params constructor
    public Book() {
        this("John Doe", 0);
    }

    public Book(String author, int nbrPages) {
        this.author = author;
        this.nbrPages = nbrPages;
        setHasAuthor(true);
    }

    public Book(String title, String author, int nbrPages) {
        super(title);
        this.author = author;
        this.nbrPages = nbrPages;
        setHasAuthor(true);
    }

    // Getters and Setters
    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNbrPages() {
        return nbrPages;
    }

    public void setNbrPages(int nbrPages) {
        this.nbrPages = nbrPages;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "numRec=" + numRec +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", nbrPages=" + nbrPages +
                '}';
    }
}
