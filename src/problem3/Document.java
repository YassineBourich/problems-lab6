package problem3;

public class Document {
    static private int nextNumRec;
    protected int numRec;
    protected String title;
    protected boolean hasAuthor;

    // No-args constructor and title constructor
    public Document() {
        this("Random Document");
    }

    public Document(String title) {
        this.numRec = nextNumRec++;     // Auto-incremental record number
        this.title = title;
        this.hasAuthor = false;
    }

    // Getters and Setters
    public int getNumRec() {
        return numRec;
    }

    public void setNumRec(int numRec) {
        this.numRec = numRec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean hasAuthor() { return this.hasAuthor; }

    public void setHasAuthor(boolean val) { this.hasAuthor = val; }

    public String getAuthor() {return null;}

    // toString method

    @Override
    public String toString() {
        return "Document{" +
                "numRec=" + numRec +
                ", title='" + title + '\'' +
                '}';
    }
}
