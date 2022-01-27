public class Tile{
	private char letter;
	private int value;

	public Tile(char letter, int value){
		this.letter = letter;
		this.value = value;
	}
	
	//accesors - mutators
	public char getLetter(){
		return this.letter;
	}
	public int getValue(){
	return this.value;
	}
	public void setLetter(char letter){
		this.letter = letter;
	}
	public void setValue(int value){
		this.value = value;
	}

	//instance methods
	public String toString(){
		return String.format("Character: %s :: Value: %d\n", this.letter, this.value);
	}

	public boolean equals(Tile that){
		return (this.letter == that.letter && this.value == that.value);
	}

	//static methods
	public static void printTile(Tile t){
		System.out.printf(t.toString());
	}
	
}