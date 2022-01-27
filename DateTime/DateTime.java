public class DateTime{
	public static void printAmerican(String day, String month, String date, String year){
				System.out.println("American Style: " + day + ", " + month + " " + date + ", " + year);
	}

		public static void printEuropean(String day, String month, String date, String year){
				System.out.println("European Style: " + day + " " + date + " " + month + " " + year);
	}
	public static void main(String[] args){
	String day, date, month, year;
		day = "Tuesday";
		date = "11th";
		month = "January";
		year = "2022";
		printAmerican(day, month, date, year);
		printEuropean(day, month, date, year);

		int hour, min, sec;
		hour = 12;
		min = 9;
		sec = 32;

		int elaspedSeconds = (hour * 60 + min) * 60 + sec;
		System.out.println("Seconds elasped since midnight: " + elaspedSeconds);

		int remainingSeconds = (24 * 60 * 60) - elaspedSeconds;
		System.out.println("Seconds remaining in the day: " + remainingSeconds);

		double percentDay = elaspedSeconds * 100.0 / (24*60*60);
		System.out.println("Percentage elasped in the day: " + percentDay + "%");

		int currHr = 12;
		int currMin = 16;
		int currS = 01;

		int timeForExercise = ((currHr * 60 + currMin) * 60 + currS) - ((hour * 60 + min) * 60 + sec);

		System.out.println("Time needed for exercide: " + timeForExercise + "seconds");
}
}