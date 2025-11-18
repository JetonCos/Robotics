import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {

    // ----------------- Card class -----------------
    static class Card {
        private final String rank;
        private final String suit;

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public String getRank() {
            return rank;
        }

        public int getValue() {
            switch (rank) {
                case "2": return 2;
                case "3": return 3;
                case "4": return 4;
                case "5": return 5;
                case "6": return 6;
                case "7": return 7;
                case "8": return 8;
                case "9": return 9;
                case "10":
                case "J":
                case "Q":
                case "K":
                    return 10;
                case "A":
                default:
                    return 1; // Ace handled specially in Hand
            }
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    // ----------------- Deck class -----------------
    static class Deck {
        private final List<Card> cards = new ArrayList<>();
        private int currentIndex = 0;

        public Deck() {
            String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
            String[] suits = {"Hearts","Diamonds","Clubs","Spades"};

            for (String suit : suits) {
                for (String rank : ranks) {
                    cards.add(new Card(rank, suit));
                }
            }
            shuffle();
        }

        public void shuffle() {
            Collections.shuffle(cards);
            currentIndex = 0;
        }

        public Card draw() {
            if (currentIndex >= cards.size()) {
                shuffle();
            }
            return cards.get(currentIndex++);
        }
    }

    // ----------------- Hand class -----------------
    static class Hand {
        private final List<Card> cards = new ArrayList<>();

        public void addCard(Card card) {
            cards.add(card);
        }

        public List<Card> getCards() {
            return cards;
        }

        public int getBestScore() {
            int total = 0;
            int aceCount = 0;

            for (Card c : cards) {
                total += c.getValue();
                if (c.getRank().equals("A")) {
                    aceCount++;
                }
            }

            int bestScore = total;
            for (int i = 0; i < aceCount; i++) {
                if (bestScore + 10 <= 21) {
                    bestScore += 10;
                }
            }

            return bestScore;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cards.size(); i++) {
                sb.append(cards.get(i));
                if (i < cards.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" (Total: ").append(getBestScore()).append(")");
            return sb.toString();
        }
    }

    // ----------------- Game logic -----------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        System.out.println("=== Welcome to the Blackjack Decision Game ===");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println();
            System.out.println("Starting a new round...");
            System.out.println();

            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();

            // Initial deal (2 cards each)
            playerHand.addCard(deck.draw());
            playerHand.addCard(deck.draw());
            dealerHand.addCard(deck.draw());
            dealerHand.addCard(deck.draw());

            System.out.println("Your hand: " + playerHand);
            System.out.println("Dealer shows: " + dealerHand.getCards().get(0) + " and [hidden]");

            // ----- Player turn -----
            boolean playerBust = false;
            while (true) {
                System.out.print("Do you want to [H]it or [S]tand? ");
                String choice = scanner.nextLine().trim().toUpperCase();

                if (choice.equals("H")) {
                    Card drawn = deck.draw();
                    playerHand.addCard(drawn);
                    System.out.println("You drew: " + drawn);
                    System.out.println("Your hand: " + playerHand);

                    if (playerHand.getBestScore() > 21) {
                        System.out.println("You busted! Dealer wins.");
                        playerBust = true;
                        break;
                    }
                } else if (choice.equals("S")) {
                    System.out.println("You stand with: " + playerHand.getBestScore());
                    break;
                } else {
                    System.out.println("Invalid choice. Please type H or S.");
                }
            }

            // ----- Dealer turn -----
            if (!playerBust) {
                System.out.println();
                System.out.println("Dealer's turn...");
                System.out.println("Dealer reveals hand: " + dealerHand);

                while (dealerHand.getBestScore() < 17) {
                    Card drawn = deck.draw();
                    dealerHand.addCard(drawn);
                    System.out.println("Dealer draws: " + drawn);
                    System.out.println("Dealer's hand: " + dealerHand);
                }

                int playerScore = playerHand.getBestScore();
                int dealerScore = dealerHand.getBestScore();

                System.out.println();
                System.out.println("Final Scores:");
                System.out.println("Your hand: " + playerHand);
                System.out.println("Dealer's hand: " + dealerHand);

                if (dealerScore > 21) {
                    System.out.println("Dealer busts! You win!");
                } else if (playerScore > dealerScore) {
                    System.out.println("You win!");
                } else if (playerScore < dealerScore) {
                    System.out.println("Dealer wins!");
                } else {
                    System.out.println("It's a tie (push)!");
                }
            }

            System.out.println();
            System.out.print("Play another round? (Y/N): ");
            String again = scanner.nextLine().trim().toUpperCase();
            playAgain = again.equals("Y");
        }

        System.out.println();
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
