public class sqrt{
	public static double squareRoot(double a, double x0){
		return (x0 + a / x0)/2;
		
	}
	public static void main(String[] args){
		double num = 9;
		double prevRoot = 0.0;
		double sqrt = num / 2;
		double diff = 1.0;
		while(diff > 0.0001){
			sqrt = squareRoot(num, sqrt);
			System.out.println("sqrt: " + sqrt);
			diff = Math.abs(sqrt - prevRoot);
			System.out.println("diff: " + diff);
			prevRoot = sqrt;
		}
}
}