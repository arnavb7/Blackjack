import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck stack = new Deck();
        stack.populateDeck();
        Deck playerHand = new Deck();
        Deck dealerHand = new Deck();

        playerHand.addCard(stack.drawCard());
        playerHand.addCard(stack.drawCard());
        dealerHand.addCard(stack.drawCard());
        dealerHand.addCard(stack.drawCard());
        System.out.println("------Player Hand:------");
//        System.out.println((playerHand.getDeck()).get(0));
//        System.out.println((playerHand.getDeck()).get(1));
        for (int i = 0; i < playerHand.getDeck().size(); i++) {
            System.out.println(playerHand.getDeck().get(i));
        }
        System.out.println("------Dealer Hand:------");
        System.out.println((dealerHand.getDeck()).get(0));
        System.out.println("Suit: Unknown, Face: Unknown");
        if (playerHand.getSoftValue() == 21) {
            System.out.println("Blackjack! You win!");
            return;
        } else if (dealerHand.getSoftValue() == 21) {
            System.out.println("------Dealer Hand:------");
            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                System.out.println(dealerHand.getDeck().get(i));
            }
            System.out.println("Dealer Blackjack! You lose! Better luck next time!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to hit or stand? Type 'h' for hit and 's' for stand.");
        String p = sc.nextLine();
        while ((!p.equals("h")) && (!p.equals("s"))) {
            System.out.println("Unknown action. Please try again.");
            p = sc.nextLine();
        }
        while ((p.equals("h")) && (playerHand.getHardValue() < 21)) {
            playerHand.addCard(stack.drawCard());
//            System.out.println((playerHand.getDeck()).get(playerHand.getDeck().size() - 1));
            System.out.println("------Player Hand:------");
            for (int i = 0; i < playerHand.getDeck().size(); i++) {
                System.out.println(playerHand.getDeck().get(i));
            }
//            System.out.println("The hard value of your hand is " + playerHand.getHardValue() + ", and the soft value of your hand is " + playerHand.getSoftValue() + ".");
            if (playerHand.getHardValue() > 21) {
                System.out.println("------Dealer Hand:------");
                for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                    System.out.println(dealerHand.getDeck().get(i));
                }
                System.out.println("Bust! Better luck next time!");
                return;
            } else if (playerHand.getHardValue() == 21 || playerHand.getSoftValue() == 21) {
                System.out.println("------Dealer Hand:------");
                for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                    System.out.println(dealerHand.getDeck().get(i));
                }
                System.out.println("Blackjack! You win!");
                return;
            }
            System.out.println("Do you want to hit or stand? Type 'h' for hit and 's' for stand.");
            p = sc.nextLine();
            while ((!p.equals("h")) && (!p.equals("s"))) {
                System.out.println("Unknown action. Please try again.");
                p = sc.nextLine();
            }
        }
//        if (playerHand.getHardValue() > 21) {
//            System.out.println("------Player Hand:------");
//            for (int i = 0; i < playerHand.getDeck().size(); i++) {
//                System.out.println(playerHand.getDeck().get(i));
//            } System.out.println("------Dealer Hand:------");
//            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
//                System.out.println(dealerHand.getDeck().get(i));
//            }
//            System.out.println("Bust! Better luck next time!");
//            return;
//        }
        while (dealerHand.getHardValue() < 17) {
            dealerHand.addCard(stack.drawCard());
//            should the dealer blackjack elseif sequence be here, or is it in the right spot at line 96
        } if (dealerHand.getHardValue() > 21) {
            System.out.println("------Player Hand:------");
            for (int i = 0; i < playerHand.getDeck().size(); i++) {
                System.out.println(playerHand.getDeck().get(i));
            } System.out.println("------Dealer Hand:------");
            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                System.out.println(dealerHand.getDeck().get(i));
            }
            System.out.println("Dealer bust! You win!");
            return;
        } else if (dealerHand.getHardValue() == 21 || dealerHand.getSoftValue() == 21) {
            System.out.println("------Player Hand:------");
            for (int i = 0; i < playerHand.getDeck().size(); i++) {
                System.out.println(playerHand.getDeck().get(i));
            } System.out.println("------Dealer Hand:------");
            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                System.out.println(dealerHand.getDeck().get(i));
            }
            System.out.println("Dealer Blackjack! You lose! Better luck next time!");
            return;
        }
        if (playerHand.getHardValue() > dealerHand.getHardValue()) {
            System.out.println("------Player Hand:------");
            for (int i = 0; i < playerHand.getDeck().size(); i++) {
                System.out.println(playerHand.getDeck().get(i));
            } System.out.println("------Dealer Hand:------");
            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                System.out.println(dealerHand.getDeck().get(i));
            }
            System.out.println("You win!");
            return;
        }
        else if ((playerHand.getSoftValue() > dealerHand.getHardValue()) && playerHand.getSoftValue() < 21) {
            System.out.println("------Player Hand:------");
            for (int i = 0; i < playerHand.getDeck().size(); i++) {
                System.out.println(playerHand.getDeck().get(i));
            } System.out.println("------Dealer Hand:------");
            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                System.out.println(dealerHand.getDeck().get(i));
            }
            System.out.println("You win!");
            return;
        }
//        does the sequence below make sense? im pretty sure if player soft value is greater than dealer soft value the numbers cancel out, im not sure doe
        else if ((playerHand.getSoftValue() > dealerHand.getSoftValue()) && (playerHand.getSoftValue() < 21) && (dealerHand.getSoftValue() < 21)) {
            System.out.println("------Player Hand:------");
            for (int i = 0; i < playerHand.getDeck().size(); i++) {
                System.out.println(playerHand.getDeck().get(i));
            } System.out.println("------Dealer Hand:------");
            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                System.out.println(dealerHand.getDeck().get(i));
            }
            System.out.println("You win!");
            return;
        }
        else {
            System.out.println("------Player Hand:------");
            for (int i = 0; i < playerHand.getDeck().size(); i++) {
                System.out.println(playerHand.getDeck().get(i));
            } System.out.println("------Dealer Hand:------");
            for (int i = 0; i < dealerHand.getDeck().size(); i++) {
                System.out.println(dealerHand.getDeck().get(i));
            }
            System.out.println("You lose! Better luck next time!");
            return;
        }
    }
}
