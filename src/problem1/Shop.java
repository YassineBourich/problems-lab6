package problem1;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            scan.nextLine();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
            scan.nextLine();
            // *** create a new item and add it to the cart
            item = new Item(itemName, itemPrice, quantity);
            cart.add(item);
            // *** print the contents of the cart object using println
            // This code does not print the content of the cart in a formal way
            /*System.out.println("\nCart contents: ");
            System.out.println(cart);
            System.out.println('\n');*/
            // It is replaced by the following printing procedure
            double totalPrice = 0.0;

            System.out.println("\nCart contents: ");
            System.out.println("Name\t\tPrice\t\tQuantity\t\tTotal");

            for (Item content_item : cart) {
                System.out.println(content_item);
                totalPrice += content_item.getPrice() * content_item.getQuantity();
            }

            NumberFormat fmt = NumberFormat.getCurrencyInstance();
            System.out.println("\nTotal price: " + fmt.format(totalPrice));

            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
    }
}
