
// Design a better strategy for the Player.play method. For example,
// if there are multiple cards you can play, and one of them is an eight,
// you might want to play the eight.
// Think of other ways you can minimize penalty points, such as
// playing the highest ranking cards first.

public class SmartPlayer extends Player {

	public SmartPlayer(String name) {
		super(name);
	}

	/**
     * Removes and returns a legal card from the player's hand.
     */
    // public Card play(Eights eights, Card prev) {
    //     Card card = searchForMatches(prev).popCard();
    //     if (card == null) {
    //         card = drawForMatch(eights, prev);
    //     }
    //     return card;
    // }  // end play()


	/**
     * Searches the player's hand for a matching card.
     */
    public CardCollection searchForMatches(Card prev) {
		CardCollection posPlays = new CardCollection("possible plays");  // collect possible plays first

        for (int i = 0; i < getHand().size(); i++) {
            Card card = this.getHand().getCard(i);
            if (cardMatches(card, prev)) {
                posPlays.addCard(card);
            }
        }

		return posPlays;
    }  // end searchForMatches()


}  // end class
