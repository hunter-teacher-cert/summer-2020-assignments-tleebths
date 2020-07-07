import java.util.Arrays;
import java.util.Random;

/**
 * A deck of playing cards (of fixed size).
 */
public class Deck {

    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println(this.cards[i]);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        return Arrays.toString(this.cards);
    }

    // sequential/linear search
    public static int search(Card[] cards, Card target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Card[] cards, Card target,
                                   int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = (low + high) / 2;                     // step 1
        int comp = cards[mid].compareTo(target);

        if (comp == 0) {                                // step 2
            return mid;
        } else if (comp < 0) {                          // step 3
            return binarySearch(cards, target, mid + 1, high);
        } else {                                        // step 4
            return binarySearch(cards, target, low, mid - 1);
        }
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    public int randomInt(int low, int high) {
        return 0;
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        // choose a random number between i and length - 1


        // swap the ith card and the randomly-chosen card


    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    public int indexLowest(int low, int high) {
        return 0;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        // find the lowest card at or to the right of i


        // swap the ith card and the lowest card found


    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    public static Deck merge(Deck d1, Deck d2) {
        // create a new deck big enough for all the cards

        // use the index i to keep track of where we are at in
        // the first deck, and the index j for the second deck
        int i = 0;
        int j = 0;
        // the index k traverses the result deck
        for (int k = 0; k < result.cards.length; k++) {

            // if d1 is empty, d2 wins

            // if d2 is empty, d1 wins

            // otherwise, compare the two cards

            // add the winner to the new deck at position k

            // increment either i or j

        }
        // return the new deck
        return null;
    }

    public Deck almostMergeSort() {
        // divide the deck into two subdecks
        // sort the subdecks using selectionSort
        // merge the two halves and return the result
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        // if the deck is 0 or 1 cards, return it


        // divide the deck into two subdecks


        // sort the subdecks using mergeSort

        
        // merge the two halves and return the result
        return this;
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

}
