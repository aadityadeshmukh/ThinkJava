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

	public void insertionSort(){
		for(int i = 1; i < this.cards.length; i++){
			for(int k = i; k > 0 ; k--){
				if(this.cards[k].compareTo(this.cards[k-1]) == -1)
					swapCards(k, k-1);
			}
		}
	}
	//merge sort
	//sub deck helper method
	public Deck subDeck(int low, int high){
		Deck sub = new Deck(high - low + 1);
		for(int i = 0; i < sub.cards.length; i++){
			sub.cards[i] = this.cards[low+i];
		}
		return sub;
	}

	//merge deck
	public Deck mergeDeck(Deck d1, Deck d2){
		Deck d3 = new Deck(d1.cards.length + d2.cards.length);
		int i = 0;
		int j = 0;

		for(int k = 0; k < d3.cards.length; k++){
			//check if top card in d1 is empty - then add first d2 to d3
			if(i > d1.cards.length-1 && j < d2.cards.length)
			{
				d3.cards[k] = d2.cards[j];
				j++;
			}
			else if(i < d1.cards.length && j > d2.cards.length-1)
			{//check if top card in d2 is empty - then add first of d1 to d3
				d3.cards[k] = d1.cards[i];
				i++;
			}
			else //else compare and add lower of the two to d3
			{
				if(d1.cards[i].compareTo(d2.cards[j]) == -1){
					d3.cards[k] = d1.cards[i];
					i++;
				}
				else{
					d3.cards[k] = d2.cards[j];
					j++;
				}
			}
		}
		return d3;
	}

	//almost merge sort
	public Deck mergeSort(){
		System.out.println(this.cards.length);
		//add base cases - 0 or 1 cards cant be out of order
		if(this.cards.length <= 1) return this;
		//split deck in half
		int l = 0;
		int r = this.cards.length - 1;
		Deck sortedDeck = new Deck(this.cards.length);
		if(l < r){
			int half = (l + (r-l)/2);
			Deck d1 = this.subDeck(l,half);
			Deck d2 = this.subDeck(half, r);
			Deck sortedD1 = d1.mergeSort();
			Deck sortedD2 = d2.mergeSort();
			sortedDeck = mergeDeck(sortedD1, sortedD2);
		}
		return sortedDeck;
	}
	public static void main(String args[]){
		Deck d = new Deck();
		d.print();
		d.shuffle();
		System.out.println("After shuffle:********");
		d.print();
		d.insertionSort();
		System.out.println("After sort:********");
		d.print();
	}
}