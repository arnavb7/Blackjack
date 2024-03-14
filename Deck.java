import java.util.*;

public class Deck {
    private ArrayList<Card> deck;
    public static Map<String, Integer> faceToValue = new HashMap<String, Integer>() {{
        put("ACE",1);
        put("2",2);
        put("3",3);
        put("4",4);
        put("5",5);
        put("6",6);
        put("7",7);
        put("8",8);
        put("9",9);
        put("10",10);
        put("JACK",10);
        put("QUEEN",10);
        put("KING",10);
    }};
    public static Set<String> keys = faceToValue.keySet();
    private final String[] FACE_ARRAY = keys.toArray(new String[keys.size()]);;
    private final Suit[] SUIT_ARRAY = Suit.values();

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public void populateDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(SUIT_ARRAY[i], FACE_ARRAY[j]));
            }
        }
        Collections.shuffle(this.deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card drawCard() {
        return deck.remove(0);
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public int getHardValue() {
        int sum = 0;
        for (int i = 0; i < deck.size(); i++) {
            sum += (Integer)faceToValue.get(deck.get(i).getFace());
        }
        return sum;
    }

    public int getSoftValue() {
        int sum = 0;
        for (int i = 0; i < deck.size(); i++) {
            if ((deck.get(i).getFace()).equals("ACE")) {
                sum += 11;
            }   else {
                sum += (Integer)faceToValue.get(deck.get(i).getFace());
            }
        }
        return sum;
    }



}