package problem3;

public class Textbook extends Book {
    public String level;

    // Constructor
    public Textbook(String title, String author, int nbrPages, String level) {
        super(title, author, nbrPages);
        this.level = level;
    }

    // Getter and Setter
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // toString method

    @Override
    public String toString() {
        return "Textbook{" +
                "numRec=" + numRec +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", nbrPages=" + nbrPages +
                ", level='" + level + '\'' +
                '}';
    }
}
