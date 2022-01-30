import java.util.ArrayList;
import java.util.Random;
public class CardCollection{
	private String label;
	private ArrayList<Card> cards;

	public CardCollection(String label){
		this.label = label;
		this.cards = new ArrayList<Card>();
	}
	public String getLabel(){
		return label;
	}
	public int size(){
		return cards.size();
	}
	public void addCard(Card c){
		cards.add(c);
	}
	public Card popCard(){
		System.out.println(cards.size());
		int i = cards.size() - 1;
		Card c = cards.remove(i);
		return c;
	}
	public boolean isEmpty(){
		return cards.isEmpty();
	}	
	public Card getCard(int i){
		return cards.get(i);
	}
	public Card lastCard(){
		int i = cards.size() - 1;
		return cards.get(i);
	}
	public void swapCards(int i, int j){
		Card temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
	}
	public void shuffle(){
		Random r = new Random();
		for(int i = cards.size()-1; i > 0; i--){
			int idx = r.nextInt(i+1);
			swapCards(i,idx);
		}
	}

	public void deal(CardCollection cc, int n){
		for(int i = 0; i < n; i++){
			Card c = popCard();
			cc.addCard(c);
		}
	}
	public void dealAll(CardCollection cc){
		deal(cc, cards.size());
	}
}