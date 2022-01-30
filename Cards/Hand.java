public class Hand extends CardCollection{
	public Hand(String label){
		super(label);
	}

	public void display(){
		System.out.println(getLabel() + ": ");
		for(int i = 0; i < size();i++){
			System.out.println(getCard(i));
		}
	}

	public static void main(String[] args){
		Deck deck = new Deck();
		deck.shuffle();

		Hand hand = new Hand("Hand");
		deck.deal(hand, 5);
		hand.display();
	}
}