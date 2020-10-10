package naeun.calender;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		System.out.println("합을 구할 두 수를 입력하세요");
		Scanner number = new Scanner(System.in);
		int x = number.nextInt();
		int y = number.nextInt();
		System.out.println("두 수의 합은 "+(x+y)+"입니다.");
		System.out.printf("두 수의 합은 %d입니다",x+y);
		number.close();
	}
} 
