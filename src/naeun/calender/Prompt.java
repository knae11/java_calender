package naeun.calender;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	/*
	 * @param week 요일명
	 * 
	 * @return 0~6 (0=Sunday~6=Saturday)
	 */
//	public int parseDay(String week) {
//		if (week.equals("su"))
//			return 0;
//		else if (week.equals("mo"))
//			return 1;
//		else if (week.equals("tu"))
//			return 2;
//		else if (week.equals("we"))
//			return 3;
//		else if (week.equals("th"))
//			return 4;
//		else if (week.equals("fr"))
//			return 5;
//		else if (week.equals("sa"))
//			return 6;
//		else
//			return 0;
//
//	}

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.println(">");
			String cmd = scanner.next();

			if (cmd.equals("1")) {
				cmdRegister(scanner, cal);
			} else if (cmd.equals("2")) {
				cmdSearch(scanner, cal);
			} else if (cmd.equals("3")) {
				cmdCal(scanner, cal);
			} else if (cmd.equals("h")) {
				printMenu();
			} else if (cmd.equals("q")) {
				break;
			}

		}
		System.out.println("Thank you, bye~");
		scanner.close();

	}

	private void cmdCal(Scanner s, Calender c) {

		int month = 1;
		int year = 2017;

		System.out.println("년을 입력하세요");
		System.out.print("YEAR> ");
		year = s.nextInt();

		System.out.println("달을 입력하세요");
		System.out.print("MONTH> ");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력 입니다.");
			return;
		}
		c.printCalender(year, month);
	}

	private void cmdSearch(Scanner s, Calender c) {
		System.out.println("[일정검색] 날짜를 입력해 주세요 (yyyy-mm-dd)");
		String date = s.next();
		String plan="";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정검색중 오류");
		}
		System.out.println(plan);

	}

	private void cmdRegister(Scanner s, Calender c) throws ParseException {
		System.out.println("[일정등록] 날짜를 입력해 주세요 (yyyy-mm-dd)");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해 주세요 (문장 끝에 ;을 입력해 주세요)");
		while(true) {
			String word = s.next();
			text += word + " ";
			if (word.endsWith(";")){
				break;
			}
		}
		c.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {

		Prompt p = new Prompt();
		p.runPrompt();

	}
}
