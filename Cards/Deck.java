import java.util.Random;
public class Deck{
	private Card[] cards;

	//default constructor for a standard 52 card deck
	public Deck(){
		this.cards = new Card[52];
		int index = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 2; j <= 14; j++){
				this.cards[index] = new Card(i,j);	
				index++;
			}
		}
	}

	//constructor for creating a deck for n cards
	public Deck(int n){
		this.cards = new Card[n];
	}

	public Card[] getCards(){
		return this.cards;
	}

	public void print(){
		for(Card c: this.cards){
			System.out.println(c);
		}
	}
	public static int randomInt(int low, int high){
		Random r = new Random();
		int rand = low + (int)(Math.random() * (high-low));
		return rand;
	}
	public void swapCards(int i, int j){
		if(i == j) return;
		Card temp = this.cards[i];
		this.cards[i] = this.cards[j];
		this.cards[j] = temp;
	}
	public void shuffle(){
		//run a loop with iterator i
		for(int i = 0; i < this.cards.length; i++){
			//choose a random number between a range i = length - 1
			int swapIdx = randomInt(i, this.cards.length  - 1);
			//swap i and generated random card
			this.swapCards(i, swapIdx);
		}
	}
	public int lowestIndex(int low, int high){
		for(int i = low; i < high; i++){
			if(this.cards[low].compareTo(this.cards[i]) == 1){
				low = i;
			}
		}
		return low;
	}
	public void selectionSort(){
		for(int i = 0; i < this.cards.length; i++){
			int li =  lowestIndex(i, this.cards.length);
			swapCards(i,li);
		}
	}
	public static void main(String args[]){
		Deck d = new Deck();
		d.print();
		d.shuffle();
		System.out.println("After shuffle:********");
		d.print();
		d.selectionSort();
		System.out.println("After selection sort:********");
		d.print();
	}
}