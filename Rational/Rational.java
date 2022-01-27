public class Rational{
	private int numerator;
	private int denominator;

	//Constructors
	public Rational(){
		this.numerator = 1;
		this.denominator = 1;
	}
	public Rational(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}

	//accessors and mutators
	public int getNumerator(){
		return this.numerator;
	}

	public void setNumerator(int num){
		this.numerator = num;
	}

	public int getDenominator(){
		return this.denominator;
	}

	public void setDenominator(int den){
		this.denominator = den;
	}
	//instance methods
	public String toString(){
		return String.format("%d/%d", this.numerator, this.denominator);
	}

	//modifier
	public static void negate(Rational r){
		r.numerator = -r.numerator;
	}

	public static void invert(Rational r){
		r.numerator = r.denominator + r.numerator;
		r.denominator = r.numerator - r.denominator;
		r.numerator = r.numerator - r.denominator;
	}

	public double toDouble(){
		return (double) this.numerator / this.denominator;
	}
	public static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	public Rational reduce(){
		int gcd = gcd(this.numerator, this.denominator);
		Rational r = new Rational(this.numerator/gcd, this.denominator / gcd);
		return r;
	}

	public Rational add(Rational that){
		Rational result = new Rational();
		int num = this.numerator * that.denominator + that.numerator * this.denominator;
		int den = this.denominator * that.denominator;
		result.setNumerator(num);
		result.setDenominator(den);
		return result.reduce();
	}
	//Print method
	public static void printRational(Rational r){
		System.out.printf("%d/%d\n", r.numerator, r.denominator);
	}

	public static void main(String args[]){
		Rational r1 = new Rational(1,2);
		printRational(r1);
		//negate(r1);
		//System.out.println(r1);
		//invert(r1);
		System.out.println(r1);
		System.out.println(r1.toDouble());
		Rational r2 = new Rational(1,2);
		//System.out.println(r2.reduce());
		System.out.println((r1.add(r2)));
	}
}