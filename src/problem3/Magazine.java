package problem3;

public class Magazine extends Document {
    private String month;
    private int year;

    // Constructors
    public Magazine(String month, int year) {
        this.month = month;
        this.year = year;
    }

    public Magazine(String title, String month, int year) {
        super(title);
        this.month = month;
        this.year = year;
    }

    // Getters and Setters
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // toString method
    @Override
    public String toString() {
        return "Magazine{" +
                "numRec=" + numRec +
                ", title='" + title + '\'' +
                ", month='" + month + '\'' +
                ", year=" + year +
                '}';
    }
}
