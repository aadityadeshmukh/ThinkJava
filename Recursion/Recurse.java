public class Recurse{
	public static void countDown(int n){
		if(n == 0) System.out.println("Boom!");
		else{
			countDown(n-1);
			System.out.println(n);
		}
	}
	public static void displayBinary(int val){
		if(val == 0) return;
		displayBinary(val/2);
		System.out.print(val%2);
	}
	public static String noX(String str){
		if(str.length() == 0) return "";
		char first = str.charAt(0);
		String rest = str.substring(1);
		if(first == 'x')
			return noX(rest);
		else
			return first + noX(rest);
	}
	public static int array11(int[] arr, int index){
		if(index >= arr.length) return 0;
		int count = array11(arr, index+1);
		if(arr[index] == 11) return count += 1;
		return count;
	}
	
	public static void main(String[] args){
		countDown(3);
		displayBinary(23);
		System.out.println();
		String result = noX("abxy");
		System.out.println(result);
		int[] iArr = {10,11,2,9,11,10,11};
		System.out.println(array11(iArr, 0));
	}
}