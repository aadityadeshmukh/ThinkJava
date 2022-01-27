public class Time{
	public int hour;
	public int minute;
	public double seconds;

	public Time(){
		this.hour = 0;
		this.minute = 0;
		this.seconds = 0.0;
	}
	public Time(int hour, int minute, int seconds){
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}
	public String toString(){
		return String.format("%02d:%02d:%04.1f", this.hour,this.minute,this.seconds);
	}
	public boolean equals(Time that){
		final double DELTA = 0.001;
		return (this.hour == that.hour && this.minute == that.minute && Math.abs(this.seconds - that.seconds) <= DELTA);
	}

	public Time add(Time that){
		Time sum = new Time();
		sum.hour = this.hour + that.hour;
		sum.minute = this.minute + that.minute;
		sum.seconds = this.seconds + that.seconds;

		if(sum.seconds >= 60){
			sum.seconds -= 60;
			sum.minute++;
		}
		if(sum.minute >= 60){
			sum.minute -=60;
			sum.minute++;
		}
		if(sum.hour >= 24){
			sum.hour -= 24;
		}
		return sum;
	}
}