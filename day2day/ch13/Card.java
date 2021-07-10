//../ch12/Card.java
public class Card {
    private final int rank;
    private final int suit;

    public static final String[] RANKS = {
        null, "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "Jack", "Queen", "King", "Ace"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /** Method counts number of each suit in a given hand */
    public static int[] suitHist(Card[] hand) {
        int[] histogram = new int[4];  // C/D/H/S

        for(int i=0; i<hand.length; i++) {
            histogram[ hand[i].suit ]++;
        }

        return histogram;
    }

    /** Method returns true if a hand has >=5 of any suit */
    public static boolean hasFlush(Card[] hand) {
        int[] histogram = suitHist(hand);
        for (int i=0; i<histogram.length; i++)
            if (histogram[i] > 4)
                return true;

        return false;
    }


    // instance variables and constructors go here
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

	public boolean equals(Card that) {
	    return this.rank == that.rank
	        && this.suit == that.suit;
	}

	public int compareTo(Card that) {
	    if (this.suit < that.suit) {
	        return -1;
	    }
	    if (this.suit > that.suit) {
	        return 1;
	    }
	    if (this.rank < that.rank) {
	        return -1;
	    }
	    if (this.rank > that.rank) {
	        return 1;
	    }
	    return 0;
	}

	public int getRank() {
	    return this.rank;
	}

	public int getSuit() {
	    return this.suit;
	}


}  // end class
