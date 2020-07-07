import java.util.Arrays;

/**
 * Test sorting algorithms for decks of cards.
 */
public class Test {

    /**
     * Checks that the deck is sorted.
     */
    public static void checkSorted(Deck deck) {
        Card[] cards = deck.getCards();
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].compareTo(cards[i + 1]) >= 0) {
                System.out.println("Card #" + i + " not sorted! " + cards[i] + "\t" + cards[i + 1]);
            }
        }
    }

    /**
     * Demonstrates how to call the sorting methods.
     */
    public static void main(String[] args) {
        Deck deck;
        deck = new Deck();
        int x;

        //System.out.printf("testing suitHist: %s\n", Arrays.toString(Card.suitHist(deck.getCards())));
        //System.out.printf("testing hasFlush: %s\n", Card.hasFlush(deck.getCards()));
        // for(int i=0; i<20; i++)  // testing randomInt
        //    System.out.print(deck.randomInt(3,6) + " ");
        /*
        System.out.println("Testing indexLowest...");
        deck.shuffle();
        for (int i=0; i<52; i+=13) {
            x = deck.indexLowest(i, i+12);
            System.out.println("\t" + x);
        }
        */

        System.out.println("Testing selection...");
        deck = new Deck();
        deck.shuffle();
        deck.selectionSort();
        checkSorted(deck);

        System.out.println("Testing almostMergeSort...");
        deck = new Deck();
        deck.shuffle();
        deck = deck.subdeck(0,10);
        deck.almostMergeSort();
        System.out.println("almostMergeSorted");
        deck.print();
        checkSorted(deck);

        System.out.println("Testing mergesort...");
        deck = new Deck();
        deck.shuffle();
        deck = deck.mergeSort();
        checkSorted(deck);

        System.out.println("Testing insertion...");
        deck = new Deck();
        deck.shuffle();
        deck.insertionSort();
        checkSorted(deck);
    }

}
