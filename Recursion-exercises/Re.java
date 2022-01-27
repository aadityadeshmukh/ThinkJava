public class Re{
	public static void beerMe(int number){
		if(number == 0){
			System.out.printf("No bottles of beer on the wall,\n no bottles of beer,\n ya' can't take one down,\n ya' can't pass it around,\n 'cause there are no more bottles of beer on the wall!\n");
			return;
		}
		if(number - 1 == 0){
			System.out.printf("%d bottles of beer on the wall,\n %d bottles of beer,\n ya' take one down,\n ya' pass it around,\n  %s bottles of beer on the wall!\n", number, number, "No" );
		}
		else{
			System.out.printf("%d bottles of beer on the wall,\n %d bottles of beer,\n ya' take one down,\n ya' pass it around,\n  %d bottles of beer on the wall!\n", number, number, number-1 );
		}
		
		beerMe(number-1);
	}

	public static int oddSum(int num){
		if(num%2 == 0) return -1;
		if(num < 0) return 0;
		return num + oddSum(num-2);
	}

	public static int prod(int m, int n){
		if(m == n) return n;
		return n * prod(m, n-1);
	}

	public static int ack(int m, int n){
		if(m == 0) return n+1;
		if(m>0 && n==0) return ack(m-1, 1);
		return ack(m-1,ack(m,n-1));
	}
	public static void main(String[] args){
		System.out.println();
		//beerMe(3);
		//int res = oddSum(16);
		System.out.println(prod(3,5));
		System.out.println(ack(3,1));
	}
}