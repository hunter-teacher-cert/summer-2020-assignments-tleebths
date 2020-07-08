import java.util.Arrays;
import java.util.Random;

/**
 * A deck of playing cards (of fixed size).
 */
public class Deck {

    private Card[] cards;
    private Random random = new Random();

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
        return random.nextInt(high-low) + low;
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
        for (int i=0; i < cards.length / 2; i++) {
            // choose a random number between i and length - 1
            int n = randomInt(i, cards.length);

            // swap the ith card and the randomly-chosen card
            swapCards(i, n);

        }  // end for
    }  // end shuffle

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    public int indexLowest(int low, int high) {
        int lowest = low;

        for (int i = low+1; i <= high; i++) {
            //System.out.print(cards[i]);
            if (cards[i].compareTo( cards[lowest] ) < 0) {
                lowest = i;
            }
        }  // end for loop

        //System.out.print("\nlowest: " + cards[lowest]);
        return lowest;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        int n = cards.length;

        for (int i=0; i < n-1; i++) {
            //System.out.printf("i=%d\n", i);
            // find the lowest card at or to the right of i
            int low = indexLowest(i, n-1);
            // swap the ith card and the lowest card found
            swapCards(i, low);

        }  // end for loop

    }  // end selectionSort()

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
        // Start from the second card, i=1. For each card at i,
        // check if it's smaller than the card at each preceding
        // slot. If so, swap the cards. Keep swwapping until
        // preceding Cards are smaller.
        for (int i=1; i<cards.length; i++) {
            Card saved = cards[i];
            for (int j=i-1; j>0 && saved.compareTo(cards[j]) < 0; j--){
                swapCards(j, j+1);
            }
        }

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


    /** Returns the number of cards in the deck */
    public int size() {
        return cards.length;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    public static Deck merge(Deck d1, Deck d2) {
        // create a new deck big enough for all the cards
        Deck combined = new Deck(d1.size() + d2.size());
        int temp;

        // use the index i to keep track of where we are at in
        // the first deck, and the index j for the second deck
        int i = 0;
        int j = 0;
        // the index k traverses the result deck
        for (int k = 0; k < combined.cards.length; k++) {

            // if d1 is empty, d2 wins
            if (i >= d1.size()) {
                combined.cards[k] = d2.cards[j];
                j++;
            } else if (j >= d2.size()) {  // if d2 is empty, d1 wins
                combined.cards[k] = d1.cards[i];
                i++;
            } else {
                // otherwise, compare the two cards
                temp = d1.cards[i].compareTo( d2.cards[j] );

                // add the winner to the new deck at position k
                if (temp < 0) {
                    combined.cards[k] = d1.cards[i];
                    i++;
                } else {
                    // System.out.println(d2.cards[j]);
                    combined.cards[k] = d2.cards[j];
                    j++;
                    // System.out.println(Arrays.toString(combined.cards));
                }
                // remember to increment either i or j
            }
        }  // end for loop

        // return the new deck
        return combined;
    }  // end merge()

    public Deck almostMergeSort() {
        // divide the deck into two subdecks
        Deck deck1 = subdeck(0, cards.length/2 - 1);
        Deck deck2 = subdeck(cards.length/2, cards.length-1);

        // sort the subdecks using selectionSort
        deck1.selectionSort();
        deck2.selectionSort();

        // merge the two halves and return the result
        return merge(deck1, deck2);
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        // if the deck is 0 or 1 cards, return it
        if (cards.length < 2)
            return this;

        // divide the deck into two subdecks
        Deck deck1 = subdeck(0, cards.length/2 - 1);
        Deck deck2 = subdeck(cards.length/2, cards.length-1);

        // sort the subdecks using mergeSort
        deck1 = deck1.mergeSort();
        deck2 = deck2.mergeSort();

        // merge the two halves and return the result
        return merge(deck1, deck2);
    }  // end mergeSort()


}  // end class
