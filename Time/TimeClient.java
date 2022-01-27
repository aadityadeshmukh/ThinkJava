public class TimeClient{
	public static void main(String args[]){
		Time t1 = new Time(6,32,22);
		System.out.println(t1);
		Time t2 = new Time(6,47,27);
		System.out.println(t2);
		System.out.println(t1.equals(t1));
		System.out.println(t1.add(t2));
	}
}