package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] ars) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of documents: ");
        int n = scan.nextInt();
        scan.nextLine();

        Liberary lib = new Liberary(n);

        lib.add(new Book("Computers", "Yassine", 389));
        lib.add(new Magazine("The sun", "Jun", 2024));

        int choice;

        do {
            System.out.println("\n\n---------Menu---------");
            System.out.println("0 - exit");
            System.out.println("1 - add document");
            System.out.println("2 - search for document");
            System.out.println("3 - remove the searched document");
            System.out.println("4 - display documents");
            System.out.println("5 - display authors");
            System.out.print("Choose an operation from the menu: ");
            choice = scan.nextInt();
            scan.nextLine();

            dispatch(lib, scan, choice);
        } while (choice != 0);
    }

    public static void dispatch(Liberary lib, Scanner scan, int choice) {
        if (choice == 0) {
            System.out.println("Exiting...");
        } else if (choice == 1) {
            System.out.println("\n\tIndexes of document types:");
            System.out.println("\t0 - Document");
            System.out.println("\t1 - Book");
            System.out.println("\t2 - Novel");
            System.out.println("\t3 - Textbook");
            System.out.println("\t4 - Magazine");
            System.out.println("\t5 - Dictionary");
            System.out.print("Enter the type of document : ");
            int doctype = scan.nextInt();
            scan.nextLine();

            Document doc = readDocumentInfo(scan, doctype);
            boolean adding_success = lib.add(doc);
            if (adding_success) {
                System.out.println(doc + "was added successfully");
            } else {
                System.out.println("Failed to add the document");
            }
        } else if (choice == 2) {
            System.out.print("Enter the record number: ");
            int numEnrg = scan.nextInt();
            scan.nextLine();
            Document searched_doc = lib.document(numEnrg);
            if (searched_doc != null) {
                System.out.println(searched_doc);
                return;
            }
            System.out.println("Document not found");
        } else if (choice == 3) {
            System.out.print("Enter the record number: ");
            int numEnrg = scan.nextInt();
            scan.nextLine();
            Document searched_doc = lib.document(numEnrg);
            boolean deleting_success = lib.delete(searched_doc);
            if (deleting_success) {
                System.out.println(searched_doc + "was deleted successfully");
            } else {
                System.out.println("Failed to delete the document");
            }
        } else if (choice == 4) {
            lib.displayDocuments();
        } else if (choice == 5) {
            lib.displayAuthors();
        } else {
            System.out.println("Operation unsupported");
        }
    }

    public static Document readDocumentInfo(Scanner scan, int doctype) {
        Document doc;

        if (doctype == 0) {
            System.out.print("Enter the title of the document: ");
            String title = scan.nextLine();
            if (title.isEmpty()) {
                doc = new Document();
            } else {
                doc = new Document(title);
            }
        } else if (doctype == 1) {
            System.out.print("Enter the title of the book: ");
            String title = scan.nextLine();
            System.out.print("Enter the author of the book: ");
            String author = scan.nextLine();
            System.out.print("Enter the number of pages: ");
            int pagesNbr = scan.nextInt();
            scan.nextLine();
            if (title.isEmpty()) {
                if (author.isEmpty()) {
                    doc = new Book();
                } else {
                    doc = new Book(author, pagesNbr);
                }
            } else {
                doc = new Book(title, author, pagesNbr);
            }
        } else if (doctype == 2) {
            System.out.print("Enter the title of the novel: ");
            String title = scan.nextLine();
            System.out.print("Enter the author of the novel: ");
            String author = scan.nextLine();
            System.out.print("Enter the number of pages: ");
            int pagesNbr = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter the price: ");
            double price = scan.nextDouble();
            scan.nextLine();
            doc = new Novel(title, author, pagesNbr, price);
        } else if (doctype == 3) {
            System.out.print("Enter the title of the textbook: ");
            String title = scan.nextLine();
            System.out.print("Enter the author of the textbook: ");
            String author = scan.nextLine();
            System.out.print("Enter the number of pages: ");
            int pagesNbr = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter the level of the textbook: ");
            String level = scan.nextLine();
            doc = new Textbook(title, author, pagesNbr, level);
        } else if (doctype == 4) {
            System.out.print("Enter the title of the magazine: ");
            String title = scan.nextLine();
            System.out.print("Enter the month of the magazine: ");
            String month = scan.nextLine();
            System.out.print("Enter the year of the magazine: ");
            int year = scan.nextInt();
            scan.nextLine();
            if (title.isEmpty()) {
                doc = new Magazine(month, year);
            } else {
                doc = new Magazine(title, month, year);
            }
        } else if (doctype == 5) {
            System.out.print("Enter the title of the dictionary: ");
            String title = scan.nextLine();
            System.out.print("Enter the language of the dictionary: ");
            String language = scan.nextLine();
            if (title.isEmpty()) {
                doc = new Dictionary(language);
            } else {
                doc = new Dictionary(title, language);
            }
        } else {
            System.out.println("Unsupported document type");
            doc = null;
        }

        return doc;
    }
}
