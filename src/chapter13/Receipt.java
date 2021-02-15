package chapter13;

import java.util.Formatter;
import java.util.regex.Pattern;

public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter();
    public void printTitle() {
        f.format("%-15s %5s %10s\n ", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n ", "Item", "Qty", "Price");
    }

    public void print(String name, int Qty, double price) {
        f.format("%-15.15s %5d %10.2f\n ", name, Qty, price);
        total +=price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n ", "Tax", "", total*0.06);
        f.format("%-15s %5s %10s\n ","","","-----");
        f.format("%-15s %5s %10.2f\n ", "Total", "", total*1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jacks magic beans", 4, 4.25);
        receipt.print("Princess peas", 3,5.1);
        receipt.print("Three Bears Porridge",1, 14.29);
        receipt.printTotal();
    }
}
