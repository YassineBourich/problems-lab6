package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    // Constructors
    public Bank() {
        this("J.P. Morgan");
    }

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        // Adding the customer to the bank if he does not exist already
        if (!this.customers.contains(customer)) {
            this.customers.add(customer);
            customer.setBank(this);
        }
    }

    public boolean addTransactionTo(Customer customer, double transaction) {
        // If the customer does not exist in this bank, return false with an error
        if (!this.customers.contains(customer)){
            System.out.println("Transaction failed: Customer " + customer.getName() + " does not exist in the bank " + name);
            return false;
        }

        // Otherwise perform the transaction and return true with a success message
        customer.addTransaction(transaction);
        System.out.println("Transaction succeded: Transaction to " + customer.getName() + " have been performed in the bank " + name + ", Amount: $" + Math.round(transaction * 100.0) / 100.0);
        return true;
    }

    public void printCustomers() {
        for (Customer customer : this.customers) {
            // Constructing the customer_statement using StringBuilder
            StringBuilder customer_statement = new StringBuilder("Customer:\n\tCustomer Name:\t");
            customer_statement.append(customer.getName());
            customer_statement.append("\n\tCustomer Transaction:\t");

            if (customer.getTransactions().isEmpty()) {
                customer_statement.append("No Transactions");
            } else {
                // Appending the transaction of this customer
                for (int i = 0; i < customer.getTransactions().size(); i++) {
                    // Unboxing the transaction
                    double transaction = customer.getTransactions().get(i);
                    // If the transaction is positive append + before the numerical value of the transaction
                    // for negative transactions, the sign - is already embedded.
                    if (transaction >= 0) {
                        customer_statement.append('+');
                    }
                    // Appending the transaction and the dollar sign
                    customer_statement.append(transaction);
                    customer_statement.append('$');

                    // Appending | between each transaction
                    if (i < customer.getTransactions().size() - 1) {
                        customer_statement.append(" | ");
                    }
                }
            }

            System.out.println(customer_statement);
        }
    }
}
