package problem3;

public class Dictionary extends Document {
    private String language;

    // Constructors
    public Dictionary(String language) {
        this.language = language;
    }

    public Dictionary(String title, String language) {
        super(title);
        this.language = language;
    }

    // Getter and Setter
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // toString method
    @Override
    public String toString() {
        return "Dictionary{" +
                "numRec=" + numRec +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
