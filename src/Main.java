import model.Card;
import model.Purchase;

import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the limit of the card: ");
        double limit = sc.nextDouble();
        Card card = new Card(limit);

        int exit = 1;
        while(exit != 0) {
            System.out.println("Type the purchase description: ");
            String description = sc.next();

            System.out.println("Type the value of purchase:");
            double value = sc.nextDouble();

            Purchase purchase = new Purchase(description, value);
            boolean purchaseMade = card.launchOrder(purchase);

            if (purchaseMade) {
                System.out.println("Purchase made!");
                System.out.println("Type 0 for exit or 1 for continue");
                exit = sc.nextInt();
            } else {
                System.out.println("Insufficient balance!");
                exit = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("Purchases made:\n");

        Collections.sort(card.getPurchases());
        for (Purchase p : card.getPurchases()) {
            System.out.println(p.getDescription() + " - " + p.getValue());
        }
        System.out.println("\n***********************");

        System.out.println("\nCard balance: " + card.getBalance());
    }
}
