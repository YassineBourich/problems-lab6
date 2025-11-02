package problem3;

import java.util.ArrayList;

public class Liberary {
    private int capacity;
    private ArrayList<Document> documents;

    // COnstructor
    public Liberary(int capacity) {
        this.capacity = capacity;
        documents = new ArrayList<>();
    }

    // Getters and Setters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // toString method

    @Override
    public String toString() {
        return "Liberary{" +
                "capacity=" + capacity +
                '}';
    }

    // Methods
    public void displayDocuments() {
        System.out.println("Documents: ");
        for (Document doc : this.documents) {
            System.out.print('\t');
            System.out.println(doc);
        }
    }

    public boolean add(Document doc) {
        if (documents.size() >= capacity) return false;

        return documents.add(doc);
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public Document document(int numEnrg) {
        for (Document doc : documents) {
            if (doc.getNumRec() == numEnrg) {
                return doc;
            }
        }

        return null;
    }

    public void displayAuthors() {
        ArrayList<String> authors_list = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.hasAuthor() && !authors_list.contains(doc.getAuthor())) {
                authors_list.add(doc.getAuthor());
            }
        }

        System.out.println(authors_list);
    }
}
