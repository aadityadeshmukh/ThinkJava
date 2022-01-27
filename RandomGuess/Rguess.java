import java.util.Scanner;
import java.util.Random;
public class Rguess{
	public static void main(String[] args){
	int userGuess, compGuess;
	System.out.print("Guess a number between 1-100: ");
	Scanner scan = new Scanner(System.in);
	userGuess = scan.nextInt();
	Random r = new Random();
	compGuess = r.nextInt(100)+1;
	System.out.println("I was thinking: " + compGuess);
	System.out.println("You were off by: " + Math.abs(compGuess - userGuess));
		}
}