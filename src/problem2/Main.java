package problem2;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Yassine");
        Customer customer2 = new Customer("Ahmed");
        Customer customer3 = new Customer("Omar");

        Bank bank = new Bank();

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        System.out.println("Printing the bank's cutomers:");
        bank.printCustomers();

        System.out.println("\nPerforming some transactions");
        customer1.sendTransactionTo(customer3, 50.5);
        customer1.sendTransactionTo(customer2, -12.9);
        customer2.sendTransactionTo(customer1, 30.78);

        customer2.addTransaction(40.0);
        customer2.addTransaction(300.5986868);
        customer2.sendTransactionTo(customer1, 66);

        System.out.println("Printing the bank's cutomers:");
        bank.printCustomers();
    }
}
