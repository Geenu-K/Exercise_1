package exercise1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card.
 * To be used as starting code in Exercise
 *
 * Author: GurleenKaur
 * Date: 2/3/2024
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] hand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill the hand with random cards
        for (int i = 0; i < hand.length; i++) {
            int value = random.nextInt(13) + 1; // values 1-13
            String suit = Card.SUITS[random.nextInt(Card.SUITS.length)];
            hand[i] = new Card(suit, value);
        }

        // User interaction
        System.out.println("Enter a card value (1-13 where 1 is Ace and 13 is King):");
        int chosenValue = scanner.nextInt();

        System.out.println("Enter a suit (0-Hearts, 1-Diamonds, 2-Clubs, 3-Spades):");
        int chosenSuitIndex = scanner.nextInt();

        String chosenSuit;
        switch (chosenSuitIndex) {
            case 0:
                chosenSuit = "Hearts";
                break;
            case 1:
                chosenSuit = "Diamonds";
                break;
            case 2:
                chosenSuit = "Clubs";
                break;
            case 3:
                chosenSuit = "Spades";
                break;
            default:
                chosenSuit = "Invalid Suit";
                break;
        }

        // Search for the card
        boolean isCardInHand = false;
        for (Card card : hand) {
            if (card.getValue() == chosenValue && card.getSuit().equals(chosenSuit)) {
                isCardInHand = true;
                break;
            }
        }

        // Output result
        if (isCardInHand) {
            printInfo();
        } else {
            System.out.println("Sorry, your card is not in the hand.");
        }

        // Close the scanner
        scanner.close();
    }

    /**
     * A simple method to print out personal information.
     */
    private static void printInfo() {
        System.out.println("Congratulations, you guessed right!");
        System.out.println();
        System.out.println("My name is Gurleen Kaur");
        System.out.println();
        System.out.println("My career ambitions:");
        System.out.println("To become a skilled software developer");
        System.out.println(); 
        System.out.println("My hobbies:");
        System.out.println("Traveling and exploring new cultures");
        System.out.println();
    }
}

class Card {
    private String suit;
    private int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    // Getter for suit
    public String getSuit() {
        return suit;
    }

    // Setter for suit
    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Setter for value
    public void setValue(int value) {
        this.value = value;
    }

    // Array of suits
    public static final String[] SUITS = {
        "Hearts", "Diamonds", "Clubs", "Spades"
    };
}
