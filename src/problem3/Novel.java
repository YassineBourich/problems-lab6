package problem3;

public class Novel extends Book {
    public double price;

    // Constructor
    public Novel(String title, String author, int nbrPages, double price) {
        super(title, author, nbrPages);
        this.price = price;
    }

    // Getter and Setter
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "Novel{" +
                "numRec=" + numRec +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", nbrPages=" + nbrPages +
                ", price=" + price +
                '}';
    }
}
