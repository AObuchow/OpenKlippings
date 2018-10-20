/**
 * Class for containing quote creation data
 * @author Andrew Obuchowicz
 *
 */
public class TimeStamp {
	private int year;
	private int dayOfMonth;
	private String timeOfDay;
	private String month;
	private String dayOfWeek;

	public TimeStamp(String dayOfWeek, String month, int dayOfMonth, int year, String timeOfDay) {
		this.year = year;
		this.dayOfMonth = dayOfMonth;
		this.timeOfDay = timeOfDay;
		this.dayOfWeek = dayOfWeek;
		this.month = month;
	}

	public int getYear() {
		return this.year;
	}

	public int getDayOfMonth() {
		return this.dayOfMonth;
	}

	public String getTimeOfDay() {
		return this.timeOfDay;
	}

	public String getMonth() {
		return this.month;
	}

	public String getDayOfWeek() {
		return this.dayOfWeek;
	}

	@Override
	public String toString() {
		return String.format("Added on %s, %s %d, %d %s", this.dayOfWeek, this.month, this.dayOfMonth, this.year,
				this.timeOfDay);
	}

}
