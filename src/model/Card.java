package model;

import java.util.ArrayList;

public class Card {
    private double cardLimit;
    private double balance;
    private ArrayList<Purchase> purchases;

    public Card(double cardLimit) {
        this.cardLimit = cardLimit;
        this.balance = cardLimit;
        this.purchases = new ArrayList<>();
    }

    public boolean launchOrder(Purchase purchase){
        if(this.balance >= purchase.getValue()){
            this.balance -= purchase.getValue();
            purchases.add(purchase);
            return true;
        }

        return false;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }


}
