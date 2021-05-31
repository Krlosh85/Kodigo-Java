package exercise2;
import java.util.HashMap;
import java.util.Scanner;

/*
*   Homework:
*   Create a program that calculates the VAT of a product, asking the name and the price of the product
*   Then, refactor the code to request for 3 products instead of 1, showing each name and price with and without VAT.
*   Finally, save all on a text file.
* */
public class exercise2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double vat = 0.13;
        double number;
        String product;
        double product_vat;

        /*Name of the product and price*/
        HashMap<String, Double> products = new HashMap<String, Double>();

        System.out.println("Insert the first product: ");
        product = scan.nextLine();

        System.out.println("What's it value?");
        number = scan.nextDouble();

        product_vat = (number * vat);

        System.out.println(product+"With VAT: "+product_vat);

        for (int i = 0; i <= 3; i++){

        }
    }
}
