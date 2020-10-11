package naeun.calender;

import java.util.Scanner;

public class Calender {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int maxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printSampleOfMonth() {
		System.out.println("월  화  수  목  금  토  일\r\n" + "--------------------\r\n" + " 1  2  3  4  5  6  7\r\n"
				+ " 8  9 10 11 12 13 14\r\n" + "15 16 17 18 19 20 21\r\n" + "22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		System.out.println("몇번 반복할래요?");
		int times = scanner.nextInt();
		for (int i = 0; i < times; i++) {
			System.out.println("달을 입력하세요");
			int month = scanner.nextInt();
			System.out.printf("%d의 마지막날은 %d입니다.\n", month, cal.maxDaysOfMonth(month));

		}

		System.out.println("끝");

		scanner.close();

	}
}
