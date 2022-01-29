import java.util.ArrayList;
public class Pile{
	ArrayList<Card> cards;

	public Pile(){
		this.cards = new ArrayList<Card>();
	}

	public Card popCard(){
		return this.cards.remove(0);
	}

	public void addCard(Card c){
		this.cards.add(c);
	}

	public boolean isEmpty(){
		return this.cards.isEmpty();
	}

	public void addDeck(Deck d){
		for(Card c: d.getCards()){
			this.cards.add(c);
		}
	}

	public static void main(String[] args){
		Deck deck = new Deck();
		deck.shuffle();
		//deck.print();
		//Divide in piles
		Pile p1 = new Pile();
		Deck subD1 = deck.subDeck(0,25);
		System.out.println("D1!");
		//subD1.print();
		p1.addDeck(subD1);
		System.out.println("D2!");
		Pile p2 = new Pile();
		Deck subD2 = deck.subDeck(26,51);
		//subD2.print();
		p2.addDeck(subD2);

		//Time for war!

		while(!p1.isEmpty() && !p2.isEmpty()){
			Card c1 = p1.popCard();
			Card c2 = p2.popCard();
			//System.out.println(c1 + "vs" + c2);
			if(c1.compareTo(c2) == -1){
				p2.addCard(c1);
				p2.addCard(c2);
			}
			else if(c1.compareTo(c2) == 1){
				p1.addCard(c1);
				p1.addCard(c2);
			}
			else
			{
				System.out.println("Tie!");
			}
		}

		if(p1.isEmpty()){
			System.out.println("p2 wins!");
		}
		else if(p2.isEmpty()){
			System.out.println("p1 wins!");
		}
	}
}