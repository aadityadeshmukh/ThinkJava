public class Gauss{
	public static double power(double operand, double exp){
		double mult = 1.0;
		for(int i = 0; i < exp; i++){
			mult = mult * operand;
		}
		return mult;
	}
	public static double fact(int num){
		int result = 1;
		for(int i = num; i > 1; i--){
			result *= i;
		}
		return result;
	}
	public static double gauss(double x, int n){
		double sum = 0.0;
		for(int i = 0; i < n; i++){
			double iterationRes = power(-1, i) * power(x, 2*i) / fact(i);
			sum += iterationRes;
		}
		return sum;
	}
	public static void main(String[] args){
	double x = 2.0;
	int n = 7;
	double result = gauss(x,n);
	System.out.println(result);
}
}