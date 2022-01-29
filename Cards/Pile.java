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
			int diff = c1.getRank() - c2.getRank();
			if(diff > 0){
				p2.addCard(c1);
				p2.addCard(c2);
			}
			else if(diff < 0){
				p1.addCard(c1);
				p1.addCard(c2);
			}
			else
			{
				Pile temp = new Pile();
				temp.addCard(c1);
				temp.addCard(c2);
				int comp = 0;
				while(comp != 0){
					if(p1.cards.size() < 4 || p2.cards.size() < 4) break;
					for(int i = 0; i < 3; i++){
						temp.addCard(p1.popCard());
						temp.addCard(p2.popCard());
					}
					Card tempc14 =  p1.popCard();
					Card tempc24 =  p1.popCard();
					temp.addCard(tempc14);
					temp.addCard(tempc24);
					comp = tempc14.getRank() - tempc24.getRank();
				}
				
				if(comp > 1){
					while(!temp.isEmpty()){
						p2.addCard(temp.popCard());
					}
				}else{
					while(!temp.isEmpty()){
						p1.addCard(temp.popCard());
					}
				}
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