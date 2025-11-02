package problem2;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    private Bank bank;

    // Constructors
    public Customer() {
        this("John Doe");
    }

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    public void addTransaction(double transaction) {
        // Rounding the transaction to two decimals then adding it to the list
        transaction = Math.round(transaction * 100.0) / 100.0;
        this.transactions.add(transaction);
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean sendTransactionTo(Customer customer, double transaction) {
        // The transaction have to be positive
        if (transaction <= 0) {
            System.out.println("Transaction sent must be positive");
            return false;
        }

        // Sending the transaction to the other customer
        boolean transaction_success = bank.addTransactionTo(customer, transaction);

        // If the transaction succeeded, reduce the transaction from this customer
        if (transaction_success)
            this.addTransaction(-1 * transaction);

        return transaction_success;
    }
}
