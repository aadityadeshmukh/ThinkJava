import java.util.Random;
import java.util.Arrays;
public class ArraysPrac{
	public static int indexOfMax(int[] iArr){
		int maxIdx = -1;
		int max = 0;
		for(int i=0; i < iArr.length; i++){
			if(iArr[i] > max) {
				maxIdx = i;
				max = iArr[i];
			}
		}
		return maxIdx;
	}
	public static boolean[] sieve( int n){
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		int ctr = 2;
		primes[0] = false;
		primes[1] = false;
		for(int i = 3; i < primes.length; i++){
			for(int j = 3; j < primes.length; j++){
				if(j%ctr == 0 && j != ctr) primes[j] = false; 
			}
			if(primes[i] == true) ctr = i;
		}
		return primes;
	}
	public static int[] letterHist (String str){
		int[] hist = new int[26];
		Arrays.fill(hist, 0);
		str = str.toLowerCase();
		for(int i = 0; i < str.length(); i++){
			char letter = str.charAt(i);
			int index = letter - 'a';
			hist[index]++;
		}
		return hist;
	}
	public static boolean isAnagram(String str1, String str2){
		str1 = str1.replaceAll("\\s", "");
		str2 = str2.replaceAll("\\s", "");
		int[] lhist1 = letterHist(str1);
		int[] lhist2 = letterHist(str2);

		int comp = Arrays.compare(lhist1, lhist2);
		if(comp == 0) return true;
		else return false;
	}
	public static void main(String[] args){
		Random r = new Random();
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++){
			arr[i] = r.nextInt(100);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(indexOfMax(arr));

		boolean[] arrPrimes = sieve(100);
		System.out.println("Primes values upto 100 are:");
		for(int i = 0; i < arrPrimes.length; i++){
			if(arrPrimes[i] == true)
				System.out.print(i + " ");
		}
		System.out.println("");
		int[] lhist = letterHist("Hoobaloo");
		System.out.println(Arrays.toString(lhist));
		System.out.println(isAnagram("allen downey", "well annoyed"));
	}
}