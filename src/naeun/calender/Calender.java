package naeun.calender;

public class Calender {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] WEEKDAYS = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}

		return false;
	}

	public int maxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		}
		return MAX_DAYS[month - 1];
	}

	public void printCalender(int year, int month, int weekday) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA\r\n" + "----------------------");
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = maxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = count<7? count : 0;

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		for (int j = count + 1; j <= maxDay; j++) {
			System.out.printf("%3d", j);
			if (j % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

}
