public class MultAdd{
	public static double multadd(double a, double b, double c){
		return (a*b)+c;
	}

	public static double expSum(double x){
		double aVal = x;
		double bVal = Math.pow(Math.E, -x);
		double cVal = Math.sqrt(1-(Math.pow(Math.E, -x)));
		return multadd(aVal, bVal, cVal);
	}
	public static void main(String[] args){
		double result = multadd(0.5, Math.cos(Math.PI/4), Math.sin(Math.PI/4));
		System.out.println(result);

		double res1 = multadd(1.0, Math.log(10), Math.log(20));
		System.out.println(res1);

		System.out.println(expSum(2));
}
}