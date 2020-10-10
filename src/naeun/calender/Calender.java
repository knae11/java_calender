package naeun.calender;

import java.util.Scanner;

public class Calender {
	public static void main(String[] args) {
		
		
		System.out.println("월  화  수  목  금  토  일\r\n"
				+ "--------------------\r\n"
				+ " 1  2  3  4  5  6  7\r\n"
				+ " 8  9 10 11 12 13 14\r\n"
				+ "15 16 17 18 19 20 21\r\n"
				+ "22 23 24 25 26 27 28");
	
		Scanner month = new Scanner(System.in);
		int a;

		System.out.println("달을 입력하세요");
		String x = month.next();
		a = Integer.parseInt(x);
		int[] yearmonth = {31,29,31,30,31,30,31,31,30,31,30,31};
		System.out.println(yearmonth[a+1]);
		System.out.printf("%d의 마지막날은 %d입니다.", a, yearmonth[a+1]);
		month.close();
		
	}
}
