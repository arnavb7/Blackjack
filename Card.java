public class Card {
    private String face;
    private Suit suit;

    public Card(Suit suit, String face) {
        this.suit = suit;
        this.face = face;
    }

    public String getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return "Suit: " + getSuit() + ", Face: " + getFace();
    }
}
