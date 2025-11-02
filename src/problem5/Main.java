package problem5;

public class Main {
    public static void main(String[] args) {
        BookStack stack = new BookStack();
        BookQueue queue = new BookQueue();

        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book2 = new Book("1984", "George Orwell", 1949);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2008);

        stack.push(book1);
        stack.push(book2);
        stack.push(book3);

        queue.enqueue(book1);
        queue.enqueue(book2);
        queue.enqueue(book3);

        System.out.println("=== Stack Test ===");
        stack.display();
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.peek());
        stack.display();

        System.out.println("\n=== Queue Test ===");
        queue.display();
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
        queue.display();
    }
}
