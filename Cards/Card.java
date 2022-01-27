import java.util.Arrays;
import java.util.Random;
public class Card{
	final private int suit;
	final private int rank;

	static final String[] SUITS = {"Clubs", "Diamonds", "Hearts" , "Spades"}; 
	static final String[] RANKS = {null, null, "Two", "Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King", "Ace"};
	//constructor
	public Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}

	public String toString(){
		return String.format("%s of %s" , RANKS[this.rank], SUITS[this.suit]);
	}

	public int compareTo(Card that){
		if(this.suit > that.suit) return 1;
		if(this.suit < that.suit) return -1;
		if(this.rank > that.rank) return 1;
		if(this.rank < that.rank) return -1;
		return 0;
	}

	//accessors and modifiers

	public int getSuit(){
		return this.suit;
	}

	public int getRank(){
		return this.rank;
	}

	public static int bSearch(Card[] cards, Card target){
		int low = 0;
		int high = cards.length - 1;
		while(low <= high){
			int mid = (low + high) / 2;
			if(cards[mid].compareTo(target) == 0)
				return mid;
			else if(cards[mid].compareTo(target) == 1)
				high = mid - 1;
			else if(cards[mid].compareTo(target) == -1)
				low = mid + 1;
		}
		return 0;
	}
	public static Card[] makeDeck(){
		Card[] deck = new Card[52];
		int index = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 2; j <= 14; j++){
				Card c = new Card(i,j);
				deck[index] = c;
				index++;
			}
		}
		return deck;
	}
	
	public static int[] suitHist(Card[] hand){
		int[] histogram = new int[4];
		for(int i = 0; i < hand.length; i++){
			histogram[hand[i].getSuit()]++;
		}
		return histogram;
	}
	public static Card[] drawCards(int numPlayers){
		int handSize = 52 / numPlayers;
		Card[] deck = new Card[handSize];
		Random r = new Random();
		for(int i = 0; i < handSize; i++){
			int suit = r.nextInt(4);
			int rank = r.nextInt(13);
			deck[i] = new Card(suit, rank+2);
		}
		return deck;
	}

	public static boolean isFlush(Card[] hand){
		int[] histogram = suitHist(hand);
		int zeroCount=0;
		for(int i = 0; i < histogram.length; i++){
			if(histogram[i] == 0) zeroCount++;
		}
		if(zeroCount == 3) return true;
		return false;
	}
	public static boolean isRoyalFlush(Card[] hand){
		int[] histogram = suitHist(hand);
		if(isFlush(hand)){
			for(int i = 0; i < hand.length; i++){
				if(hand[i].getRank() < 10) return false;
			}
		}
		return true;
	}
	// //main method
	// public static void main(String[] args){
	// 	Card[] deck1 = makeDeck();
	// 	Card c = new Card(0,2);
	// 	System.out.println("Card: " + c + " is at index " + bSearch(deck1,c));

	// 	System.out.println(Arrays.toString(suitHist(deck1)));

	// 	Card[] hand1 = drawCards(4);
	// 	System.out.println(isFlush(hand1));

	// 	Card[] hand2 = { new Card(0,10), 
	// 					 new Card(0,11), 
	// 					 new Card(0,12), 
	// 					 new Card(0,13), 
	// 					 new Card(0,14) };
		
	// 	System.out.println(isRoyalFlush(hand2));
	// }
}